#Will be update using new biaya tambahan master data

@mamipay @invoice-manual @biayaTambahan

Feature: Invoice Manual - Biaya Tambahan

  @TEST_PMAN-5773
  Scenario: Periode is disabled when choose Deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the admin selects "Deposit" in the "Biaya Tambahan"
    Then the Periode Awal and Periode Akhir are disable

  @continue @TEST_PMAN-5697
  Scenario: Check required fields Nama Biaya in the biaya tambahan
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin tambah pengeluaran "Biaya Tambahan"
    And Checks required fields "-", "today", "today", "1 Hari", "10000"
    Then the error messages "Nama biaya tidak boleh kosong.", "-", "-", "-" are displayed

  @continue @TEST_PMAN-7583
  Scenario: Check required fields Periode Awal in the Biaya Tambahan
    And Checks required fields "Parkir Mobil", "-", "-", "1 Hari", "10000"
    Then the error messages "-", "Periode awal tidak boleh kosong.", "-", "-" are displayed

  @continue @TEST_PMAN-7584
  Scenario: Check required fields Periode Akhir in the Biaya Tambahan
    And Checks required fields "Parkir Mobil", "today", "-", "1 Hari", "10000"
    Then the error messages "-", "-", "Periode akhir tidak boleh kosong.", "-" are displayed

  @TEST_PMAN-7585
  Scenario: Check required fields Jumlah Biaya in the Biaya Tambahan
    And Checks required fields "Parkir Mobil", "today", "today", "1 Hari", "-"
    Then the error messages "-", "-", "-", "Jumlah biaya tidak boleh kosong." are displayed

  @TEST_PMAN-5771
  Scenario Outline: <button> modal tambah biaya sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag | email prod | password  |
      | <Account>  | <Account>  | qwerty123 |
    And the admin selects "Deposit" in the "Biaya Tambahan"
    When the admin fills all fields in Tambah Biaya Tambahan pop up
      | Durasi Biaya | Jumlah Biaya |
      | Park Fee     | 25000        |
    And the admin clicks "<button>" modal tambah biaya
    Then tambah biaya modal is closed

    Examples:
      | button  | Account                      |
      | Close   | automationpman01@mamikos.com |
      | Kembali | automationpman02@mamikos.com |

  @TEST_PMAN-5962
  Scenario: delete biaya tambahan
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And admin creates Invoice Manual "Biaya Tambahan"
      | Nama Biaya   | Periode Awal | Periode Akhir | Durasi Biaya | Jumlah Biaya |
      | Parkir Mobil | today        | tomorrow      | 3 hari       | 25000        |
    And the admin deletes Invoice Manual
    Then the empty state is display in "Biaya Tambahan" table

  @TEST_PMAN-5595
  Scenario Outline: Create Biaya Tambahan with Autofilled disburse to owner
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag | email prod | password  |
      | <Account>  | <Account>  | qwerty123 |
    And the admin creates Invoice Manual "Biaya Tambahan" and input all fields "<Nama Biaya>", "<Lainnya>", "<Awal>", "<Akhir>", "<Durasi Biaya>", "<Jumlah Biaya>"
    Then "<Nama Biaya on Table>", "<Awal on Table>", "<Akhir on Table>", "<Jumlah Biaya on Table>", "<Disburse to Pemilik>" are displayed in the biaya tambahan table

    Examples:
      | Nama Biaya                                 | Lainnya | Awal  | Akhir    | Durasi Biaya | Jumlah Biaya | Nama Biaya on Table                                | Awal on Table | Akhir on Table | Jumlah Biaya on Table | Disburse to Pemilik | Account                      |
      | Parkir Mobil                               | -       | today | tomorrow | 3 hari       | 25000        | Parkir Mobil (3 hari)                              | today         | tomorrow       | Rp25.000              | Ya                  | automationpman01@mamikos.com |
      | Parkir Motor                               | -       | today | tomorrow | -            | 10000        | Parkir Motor                                       | today         | tomorrow       | Rp10.000              | Ya                  | automationpman02@mamikos.com |
      | Sekamar Berdua                             | -       | today | tomorrow | 2 Minggu     | 50000        | Sekamar Berdua (2 Minggu)                          | today         | tomorrow       | Rp50.000              | Ya                  | automationpman03@mamikos.com |
      | Tamu Menginap                              | -       | today | tomorrow | 1 BULAN      | 45990        | Tamu Menginap (1 BULAN)                            | today         | tomorrow       | Rp45.990              | Ya                  | automationpman01@mamikos.com |
      | Listrik                                    | -       | today | tomorrow | -            | 7000         | Listrik                                            | today         | tomorrow       | Rp7.000               | Ya                  | automationpman02@mamikos.com |
      | Air                                        | -       | today | tomorrow | 11 hari      | 11000        | Air (11 hari)                                      | today         | tomorrow       | Rp11.000              | Ya                  | automationpman03@mamikos.com |
      | Wifi                                       | -       | today | tomorrow | seminggu     | 55000        | Wifi (seminggu)                                    | today         | tomorrow       | Rp55.000              | Ya                  | automationpman01@mamikos.com |
      | Laundry                                    | -       | today | tomorrow | -            | 35000        | Laundry                                            | today         | tomorrow       | Rp35.000              | Tidak               | automationpman02@mamikos.com |
      | Deposit                                    | -       | -     | -        | sehari       | 100000       | Deposit (sehari)                                   | -             | -              | Rp100.000             | Tidak               | automationpman03@mamikos.com |
      | Penggantian kerusakan/kehilangan fasilitas | -       | today | tomorrow | Kursi        | 50000        | Penggantian kerusakan/kehilangan fasilitas (Kursi) | today         | tomorrow       | Rp50.000              | Tidak               | automationpman01@mamikos.com |
      | Lainnya                                    | sampah  | today | tomorrow | 1 hari       | 7500         | sampah (1 hari)                                    | today         | tomorrow       | Rp7.500               | Ya                  | automationpman02@mamikos.com |

  @continue @TEST_PMAN-5992
  Scenario: add multiple biaya tambahan
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And admin creates multiple Invoice Manual "Biaya Tambahan"
      | Nama Biaya   | Lainnya | Periode Awal | Periode Akhir | Durasi Biaya    | Jumlah Biaya |
      | Parkir Mobil | -       | today        | tomorrow      | automation pman | 50000        |
      | Laundry      | -       | today        | tomorrow      | automation pman | 50000        |
      | Deposit      | -       | -            | -             | automation pman | 50000        |
      | Lainnya      | Sampah  | -            | -             | automation pman | 50000        |
    Then "Biaya Tambahan" Invoice Manual are displayed on table
      | Nama Biaya on Table            | Row |
      | Parkir Mobil (automation pman) | 1   |
      | Laundry (automation pman)      | 2   |
      | Deposit (automation pman)      | 3   |
      | Sampah (automation pman)       | 4   |

  @TEST_PMAN-5964
  Scenario: delete multiple biaya tambahan
    When admin deletes all "Biaya Tambahan" or sewa on Invoice Manual
    Then the empty state of "Biaya Tambahan" is displayed

  @TEST_PMAN-6055
  Scenario: Edit Biaya Tambahan
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And admin creates Invoice Manual "Biaya Tambahan"
      | Nama Biaya   | Periode Awal | Periode Akhir | Durasi Biaya | Jumlah Biaya |
      | Parkir Mobil | today        | tomorrow      | 3 hari       | 50000        |
    And admin edits Invoice Manual "Biaya Tambahan" and checks them on the table
      | Nama Biaya | Periode Awal      | Periode Akhir      | Durasi Biaya | Jumlah Biaya | Nama Biaya on Table | Awal on Table | Akhir on Table     | Jumlah Biaya on Table | Disburse to Pemilik |
      | Laundry    | edit for tomorrow | day after tomorrow | 5 Kg         | 25000        | Laundry (5 Kg)      | tomorrow      | day after tomorrow | Rp25.000              | Tidak               |
    And admin edits Invoice Manual "Biaya Tambahan" into Lainnya and checks them on the table
      | Nama Biaya | Lainnya | Durasi Biaya | Jumlah Biaya | Nama Biaya on Table | Awal on Table | Akhir on Table     | Jumlah Biaya on Table | Disburse to Pemilik |
      | Lainnya    | Sampah  | -            | 30000        | Sampah              | tomorrow      | day after tomorrow | Rp30.000              | Ya                  |

  @TEST_PMAN-6534
  Scenario: Lainnya Validation Biaya Tambahan
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the admin creates Invoice Manual "Biaya Tambahan" Lainnya
    Then error message "Jenis invoice tidak sesuai. Pilih jenis invoice Biaya Sewa untuk biaya ini." appear if user input Lainnya field :
      | relokasi                     |
      | RELOKASI                     |
      | sewa harian                  |
      | ini seWa Harian              |
      | perpanjang sewa harian       |
      | ssewa hariann 12             |
      | extend                       |
      | extEND kontrak               |
      | perpanjang                   |
      | Perpanjangan                 |
      | kurang sewa                  |
      | tenant ini kurang sewa       |
      | selisih                      |
      | ada selisih di invoicenya    |
      | pindah                       |
      | tenant 2 Taylor Pindah kamar |
      | Biaya Sewa                   |
      | BIAYA SEWA                   |
      | biaya sewa                   |
      | BiAya sEwA                   |
      | Biaya Sewa                   |
      | biaya    sewa                |
      | biaya sewa                   |
      | Ini Biaya Sewa               |
      | biaya sewa &                 |
      | biayasewa                    |
      | biayaSewa                    |
      | biay4 s3wa                   |
      | biaya sevva                  |