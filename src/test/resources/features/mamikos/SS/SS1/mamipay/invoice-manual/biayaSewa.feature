#Will be update using new biaya tambahan master data

@mamipay @invoice-manual @biaya-sewa

Feature: Invoice Manual - Biaya Sewa

  @TEST_PMAN-5626
  Scenario Outline: Add Biaya Sewa in Invoice Manual
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag | email prod | password  |
      | <Account>  | <Account>  | qwerty123 |
    And the admin creates Invoice Manual "Biaya Sewa" and input all fields "<Nama Biaya>", "<Lainnya>", "<Awal>", "<Akhir>", "<Durasi Biaya>", "<Jumlah Biaya>"
    Then "<Nama Biaya on Table>", "<Awal on Table>", "<Akhir on Table>", "<Jumlah Biaya on Table>" are displayed in the biaya sewa table

    Examples:
      | Nama Biaya                       | Lainnya | Awal  | Akhir    | Durasi Biaya   | Jumlah Biaya | Nama Biaya on Table                         | Awal on Table | Akhir on Table | Jumlah Biaya on Table | Account                      |
      | Perpanjang sewa harian           | -       | today | tomorrow | 2 hari         | 500000       | Perpanjang sewa harian (2 hari)             | today         | tomorrow       | Rp500.000             | automationpman01@mamikos.com |
      | Kekurangan biaya sewa kamar      | -       | -     | -        | 3 hari         | 500000       | Kekurangan biaya sewa kamar (3 hari)        | -             | -              | Rp500.000             | automationpman02@mamikos.com |
      | Pindah tipe kamar/kos (relokasi) | -       | today | tomorrow | 2A ke 1A       | 20000        | Pindah tipe kamar/kos (relokasi) (2A ke 1A) | today         | tomorrow       | Rp20.000              | automationpman03@mamikos.com |
      | Lainnya                          | Sampah  | today | tomorrow | Tambahan Kasur | 100000       | Sampah (Tambahan Kasur)                     | today         | tomorrow       | Rp100.000             | automationpman01@mamikos.com |

  @continue @TEST_PMAN-5775
  Scenario: Add multiple biaya sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin creates multiple Invoice Manual "Biaya Sewa"
      | Nama Biaya                       | Lainnya     | Periode Awal | Periode Akhir | Durasi Biaya    | Jumlah Biaya |
      | Perpanjang sewa harian           | -           | today        | tomorrow      | automation pman | 50000        |
      | Kekurangan biaya sewa kamar      | -           | -            | -             | automation pman | 50000        |
      | Pindah tipe kamar/kos (relokasi) | -           | today        | tomorrow      | automation pman | 50000        |
      | Lainnya                          | Ganti Lampu | -            | -             | automation pman | 100000       |
    Then "Biaya Sewa" Invoice Manual are displayed on table
      | Nama Biaya on Table                                | Row |
      | Perpanjang sewa harian (automation pman)           | 1   |
      | Kekurangan biaya sewa kamar (automation pman)      | 2   |
      | Pindah tipe kamar/kos (relokasi) (automation pman) | 3   |
      | Ganti Lampu (automation pman)                      | 4   |

  @TEST_PMAN-5966
  Scenario: delete multiple biaya sewa
    When admin deletes all "Biaya Sewa" or sewa on Invoice Manual
    Then the empty state of "Biaya Sewa" is displayed

  @continue @TEST_PMAN-5784
  Scenario: Check required fields Nama Biaya in the Biaya Sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And admin tambah pengeluaran "Biaya Sewa"
    And Checks required fields "-", "today", "today", "1 Hari", "10000"
    Then the error messages "Nama biaya tidak boleh kosong.", "-", "-", "-" are displayed

  @continue @TEST_PMAN-7574
  Scenario: Check required fields Periode Awal in the Biaya Sewa
    And Checks required fields "Perpanjang sewa harian", "-", "-", "1 Hari", "10000"
    Then the error messages "-", "Periode awal tidak boleh kosong.", "-", "-" are displayed

  @continue @TEST_PMAN-7575
  Scenario: Check required fields Periode Akhir in the Biaya Sewa
    And Checks required fields "Perpanjang sewa harian", "today", "-", "1 Hari", "10000"
    Then the error messages "-", "-", "Periode akhir tidak boleh kosong.", "-" are displayed

  @TEST_PMAN-7576
  Scenario: Check required fields Jumlah Biaya in the Biaya Sewa
    And Checks required fields "Perpanjang sewa harian", "today", "today", "1 Hari", "-"
    Then the error messages "-", "-", "-", "Jumlah biaya tidak boleh kosong." are displayed

  @TEST_PMAN-6039
  Scenario: Edit Biaya Sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin creates Invoice Manual "Biaya Sewa"
      | Nama Biaya             | Periode Awal | Periode Akhir | Durasi Biaya    | Jumlah Biaya |
      | Perpanjang sewa harian | today        | tomorrow      | automation pman | 50000        |
    And admin edits Invoice Manual "Biaya Sewa" and checks them on the table
      | Nama Biaya                  | Periode Awal | Periode Akhir | Durasi Biaya    | Jumlah Biaya | Nama Biaya on Table                           | Awal on Table | Akhir on Table | Jumlah Biaya on Table |
      | Kekurangan biaya sewa kamar | -            | -             | automation pman | 20000        | Kekurangan biaya sewa kamar (automation pman) | -             | -              | Rp20.000              |
    And admin edits Invoice Manual "Biaya Sewa" into Lainnya and checks them on the table
      | Nama Biaya | Lainnya    | Periode Awal | Periode Akhir      | Durasi Biaya | Jumlah Biaya | Nama Biaya on Table | Awal on Table | Akhir on Table     | Jumlah Biaya on Table |
      | Lainnya    | Kebersihan | tomorrow     | day after tomorrow | -            | 30000        | Kebersihan          | tomorrow      | day after tomorrow | Rp30.000              |

  @TEST_PMAN-5743
  Scenario: Periode is disabled when choose Jenis Biaya Kekurangan biaya sewa kamar
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And the admin selects "Kekurangan biaya sewa kamar" in the "Biaya Sewa"
    Then the Periode Awal and Periode Akhir are disable

  @TEST_PMAN-6575
  Scenario: Lainnya Validation Biaya Sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And the admin creates Invoice Manual "Biaya Sewa" Lainnya
    Then error message "Jenis invoice tidak sesuai. Pilih jenis invoice Biaya Tambahan untuk biaya ini." appear if user input Lainnya field :
      | parkir                |
      | tempat PArkIR         |
      | sekamar berdua        |
      | tamu menginap         |
      | KeliStriKAN 21 hari   |
      | air                   |
      | wifi                  |
      | KeLaUNDryaN           |
      | deposit               |
      | denda                 |
      | KeKERUSAKANAN 21 hari |
      | kehilangan            |
      | asuransi              |

  @TEST_PMAN-5767
  Scenario Outline: <button> modal tambah biaya sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag | email prod | password  |
      | <Account>  | <Account>  | qwerty123 |
    And the admin selects "Kekurangan biaya sewa kamar" in the "Biaya Sewa"
    When the admin fills all fields in Tambah Biaya Sewa pop up
      | Durasi Biaya | Jumlah Biaya |
      | Kebersihan   | 25000        |
    And the admin clicks "<button>" modal tambah biaya
    Then tambah biaya modal is closed

    Examples:
      | button  | Account                      |
      | close   | automationpman02@mamikos.com |
      | kembali | automationpman03@mamikos.com |

  @TEST_PMAN-5965
  Scenario: delete biaya sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin creates Invoice Manual "Biaya Sewa"
      | Nama Biaya             | Periode Awal | Periode Akhir | Durasi Biaya    | Jumlah Biaya |
      | Perpanjang sewa harian | today        | tomorrow      | automation pman | 50000        |
    And the admin deletes Invoice Manual
    Then the empty state is display in "Biaya Sewa" table