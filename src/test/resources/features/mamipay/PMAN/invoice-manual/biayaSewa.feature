@regression @pman @mamipay @invoice-manual @biaya-sewa

  Feature: Invoice Manual - Biaya Sewa

    @TEST_PMAN-5626 @pman-prod
    Scenario Outline: Add Biaya Sewa in Invoice Manual
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
      And the admin creates Invoice Manual "Biaya Sewa" and input all fields "<Nama Biaya>", "<Lainnya>", "<Awal>", "<Akhir>", "<Durasi Biaya>", "<Jumlah Biaya>"
      Then "<Nama Biaya on Table>", "<Awal on Table>", "<Akhir on Table>", "<Jumlah Biaya on Table>" are displayed in the biaya sewa table

      Examples:
        | Nama Biaya                        | Lainnya | Awal  | Akhir     | Durasi Biaya    | Jumlah Biaya  | Nama Biaya on Table                         | Awal on Table | Akhir on Table  | Jumlah Biaya on Table |
        | Perpanjang sewa harian            | -       | today | tomorrow  | 2 hari          | 500000        | Perpanjang sewa harian (2 hari)             | today         | tomorrow        | Rp500.000             |
        | Kekurangan biaya sewa kamar       | -       | -     | -         | 3 hari          | 500000        | Kekurangan biaya sewa kamar (3 hari)        | -             | -               | Rp500.000             |
        | Pindah tipe kamar/kos (relokasi)  | -       | today | tomorrow  | 2A ke 1A        | 20000         | Pindah tipe kamar/kos (relokasi) (2A ke 1A) | today         | tomorrow        | Rp20.000              |
        | Lainnya                           | Sampah  | today | tomorrow  | Tambahan Kasur  | 100000        | Sampah (Tambahan Kasur)                     | today         | tomorrow        | Rp100.000             |

    @TEST_PMAN-5767 @pman-prod
    Scenario Outline: <button> modal tambah biaya sewa
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
      And the admin selects "Kekurangan biaya sewa kamar" in the "Biaya Sewa"
      When the admin fills all fields in Tambah Biaya Sewa pop up
        | Durasi Biaya  | Jumlah Biaya  |
        | Kebersihan    | 25000         |
      And the admin clicks "<button>" modal tambah biaya
      Then tambah biaya modal is closed

      Examples:
        | button      |
        | close       |
        | kembali     |

    @TEST_PMAN-5775 @pman-prod
    Scenario: Add multiple biaya sewa
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
      And admin creates multiple Invoice Manual "Biaya Sewa"
        | Nama Biaya                        | Lainnya     | Periode Awal  | Periode Akhir   | Durasi Biaya    | Jumlah Biaya  |
        | Perpanjang sewa harian            | -           | today         | tomorrow        | automation pman | 50000         |
        | Kekurangan biaya sewa kamar       | -           | -             | -               | automation pman | 50000         |
        | Pindah tipe kamar/kos (relokasi)  | -           | today         | tomorrow        | automation pman | 50000         |
        | Lainnya                           | Ganti Lampu | -             | -               | automation pman | 100000        |
      Then "Biaya Sewa" Invoice Manual are displayed on table
        | Nama Biaya on Table                                 | Row |
        | Perpanjang sewa harian (automation pman)            | 1   |
        | Kekurangan biaya sewa kamar (automation pman)       | 2   |
        | Pindah tipe kamar/kos (relokasi) (automation pman)  | 3   |
        | Ganti Lampu (automation pman)                       | 4   |

    @TEST_PMAN-5784 @pman-prod
    Scenario Outline: Check required fields in the Biaya Sewa
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
      And the admin creates Invoice Manual "Biaya Sewa" and checks required fields "<Nama Biaya>", "<Awal>", "<Akhir>", "<Durasi Biaya>", "<Jumlah Biaya>"
      Then the error messages "<Nama Biaya Error Msg>", "<Awal Error Msg>", "<Akhir Error Msg>", "<Jumlah Biaya Error Msg>" are displayed

      Examples:
        | Nama Biaya              | Awal  | Akhir     | Durasi Biaya  | Jumlah Biaya  | Nama Biaya Error Msg            | Awal Error Msg                    | Akhir Error Msg                   | Jumlah Biaya Error Msg            |
        | -                       | -     | -         | -             | -             | Nama biaya tidak boleh kosong.  | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
        | Perpanjang sewa harian  | -     | -         | -             | -             | -                               | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
        | -                       | today | -         | -             | -             | Nama biaya tidak boleh kosong.  | -                                 | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
        | -                       | -     | -         | 1 hari        | -             | Nama biaya tidak boleh kosong.  | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
        | -                       | -     | -         | -             | 11000         | Nama biaya tidak boleh kosong.  | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | -                                 |