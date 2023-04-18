@pman @mamipay @invoice-manual

Feature: Invoice Manual - Biaya Tambahan

  @TEST_PMAN-5773 @pman-prod
  Scenario: Periode is disabled when choose Deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the admin selects "Deposit" in the Biaya Tambahan
    Then the Periode Awal and Periode Akhir are disable

  @TEST_PMAN-5771 @pman-prod
  Scenario Outline: <button> modal tambah biaya sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the admin selects "Deposit" in the Biaya Tambahan
    When the admin fill all fields in Tambah Biaya Tambahan pop up
      | Durasi Biaya  | Jumlah Biaya  |
      | Park Fee      | 25000         |
    And the admin click "<button>" modal tambah biaya
    Then tambah biaya modal is closed

    Examples:
      | button  |
      | Close   |
      | Kembali |

  @TEST_PMAN-5697 @pman-prod
  Scenario Outline: Check required fields in the biaya tambahan
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the admin create Invoice Manual "Biaya Tambahan" and check required fields "<Nama Biaya>", "<Awal>", "<Akhir>", "<Durasi Biaya>", "<Jumlah Biaya>"
    Then the error messages "<Nama Biaya Error Msg>", "<Awal Error Msg>", "<Akhir Error Msg>", "<Jumlah Biaya Error Msg>" are displayed

    Examples:
      | Nama Biaya      | Awal  | Akhir     | Durasi Biaya  | Jumlah Biaya  | Nama Biaya Error Msg            | Awal Error Msg                    | Akhir Error Msg                   | Jumlah Biaya Error Msg            |
      | -               | -     | -         | -             | -             | Nama biaya tidak boleh kosong.  | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
      | Parkir Mobil    | -     | -         | -             | -             | -                               | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
      | -               | today | -         | -             | -             | Nama biaya tidak boleh kosong.  | -                                 | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
      | -               | -     | -         | 1 hari        | -             | Nama biaya tidak boleh kosong.  | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
      | -               | -     | -         | -             | 11000         | Nama biaya tidak boleh kosong.  | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | -                                 |

  @TEST_PMAN-5962 @pman-prod
  Scenario: delete biaya tambahan
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And admin create Invoice Manual "Biaya Tambahan"
      | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya  | Jumlah Biaya  |
      | Parkir Mobil            | today         | tomorrow        | 3 hari        | 25000         |
    And the admin delete Invoice Manual
    Then the empty state is display in "Biaya Tambahan" table

  @TEST_PMAN-5595 @pman-prod
  Scenario Outline: Create Biaya Tambahan with Autofilled disburse to owner
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the admin create Invoice Manual "Biaya Tambahan" and input all fields "<Nama Biaya>", "<Lainnya>", "<Awal>", "<Akhir>", "<Durasi Biaya>", "<Jumlah Biaya>"
    Then "<Nama Biaya on Table>", "<Awal on Table>", "<Akhir on Table>", "<Jumlah Biaya on Table>", "<Disburse to Pemilik>" are displayed in the biaya tambahan table

    Examples:
      | Nama Biaya                                  | Lainnya | Awal  | Akhir     | Durasi Biaya  | Jumlah Biaya  | Nama Biaya on Table                                 | Awal on Table | Akhir on Table  | Jumlah Biaya on Table | Disburse to Pemilik |
      | Parkir Mobil                                | -       | today | tomorrow  | 3 hari        | 25000         | Parkir Mobil (3 hari)                               | today         | tomorrow        | Rp25.000              | Ya                  |
      | Parkir Motor                                | -       | today | tomorrow  | -             | 10000         | Parkir Motor                                        | today         | tomorrow        | Rp10.000              | Ya                  |
      | Sekamar Berdua                              | -       | today | tomorrow  | 2 Minggu      | 50000         | Sekamar Berdua (2 Minggu)                           | today         | tomorrow        | Rp50.000              | Ya                  |
      | Tamu Menginap                               | -       | today | tomorrow  | 1 BULAN       | 45990         | Tamu Menginap (1 BULAN)                             | today         | tomorrow        | Rp45.990              | Ya                  |
      | Listrik                                     | -       | today | tomorrow  | -             | 7000          | Listrik                                             | today         | tomorrow        | Rp7.000               | Ya                  |
      | Air                                         | -       | today | tomorrow  | 11 hari       | 11000         | Air (11 hari)                                       | today         | tomorrow        | Rp11.000              | Ya                  |
      | Wifi                                        | -       | today | tomorrow  | seminggu      | 55000         | Wifi (seminggu)                                     | today         | tomorrow        | Rp55.000              | Ya                  |
      | Laundry                                     | -       | today | tomorrow  | -             | 35000         | Laundry                                             | today         | tomorrow        | Rp35.000              | Tidak               |
      | Deposit                                     | -       | -     | -         | sehari        | 100000        | Deposit (sehari)                                    | -             | -               | Rp100.000             | Tidak               |
      | Penggantian kerusakan/kehilangan fasilitas  | -       | today | tomorrow  | Kursi         | 50000         | Penggantian kerusakan/kehilangan fasilitas (Kursi)  | today         | tomorrow        | Rp50.000              | Tidak               |
      | Lainnya                                     | sampah  | today | tomorrow  | 1 hari        | 7500          | sampah (1 hari)                                     | today         | tomorrow        | Rp7.500               | Ya                  |