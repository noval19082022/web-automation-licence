@cp-disbursement @tambah-daftar-transfer @SS1 @regression

Feature: CP Disbursement - Tambah Daftar Transfer

  @TEST_SS-687 @continue
  Scenario: Input Invalid property
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin tambah data transfer
    And admin search property "ABC" in tambah data transfer
    Then error message "Mohon periksa kembali nama/level kos" should occur in nama property field
    Then Tambahkan button is disable

  @TEST_SS-689 @continue
  Scenario: Input Valid property
    When admin search property "khu" in tambah data transfer
    And admin select suggestion "Kost Apik Khusus Automation PMAN Halmahera Utara"
    Then transfer information should auto fill
      | Product Type | Bank    | Nomor Rekening | Nama Pemilik Rekening | Nomor Telepon Pemilik |
      | APIK         | mandiri | 10000245429    | Yudha Ferroza         | 083342344565          |
    When admin fill remaining field
      | Total Pendapatan | Tipe Transaksi | Tanggal Transfer | Berkas Laporan  | Tipe Disbursement    |
      | 100000           | Commission     | today            | pdf example.pdf | Disbursement susulan |
    Then Tambahkan button is enable

  @TEST_SS-698
  Scenario: Change valid to invalid property
    When admin search property "ABC" in tambah data transfer
    Then error message "Mohon periksa kembali nama/level kos" should occur in nama property field
    And Tambahkan button is disable

  @TEST_SS-670 @continue
  Scenario: Change invalid to valid property
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin tambah data transfer
    #search invalid property
    And admin search property "ABC" in tambah data transfer
    Then error message "Mohon periksa kembali nama/level kos" should occur in nama property field
    #search valid property
    When admin search property "khu" in tambah data transfer
    And admin select suggestion "Kost Apik Khusus Automation PMAN Halmahera Utara"
    Then transfer information should auto fill
      | Product Type | Bank    | Nomor Rekening | Nama Pemilik Rekening | Nomor Telepon Pemilik |
      | APIK         | mandiri | 10000245429    | Yudha Ferroza         | 083342344565          |

  @TEST_SS-659 @continue
  Scenario: Ensure data not deleted when popup closed
    When admin fill remaining field
      | Total Pendapatan | Tipe Transaksi | Tanggal Transfer | Berkas Laporan  | Tipe Disbursement    |
      | 100000           | Commission     | today            | pdf example.pdf | Disbursement susulan |
    And admin "close" pop up tambah data transfer
    And admin tambah data transfer
    Then all information should be keep
      | Nama Property                                    | Product Type | Bank    | Nomor Rekening | Nama Pemilik Rekening | Nomor Telepon Pemilik | Total Pendapatan | Tipe Transaksi | Tanggal Transfer | Berkas Laporan  | Tipe Disbursement    |
      | Kost Apik Khusus Automation PMAN Halmahera Utara | APIK         | mandiri | 10000245429    | Yudha Ferroza         | 083342344565          | 100000           | Commission     | today            | pdf example.pdf | Disbursement susulan |

  @TEST_SS-678 @continue
  Scenario: input > 50 characters in tipe transaksi lainnya
    When admin select tipe transaksi lainnya ">50 characters"
    Then admin only can input transaksi lainnya using only 50 characters

  @TEST_SS-661 @continue
  Scenario: Submit with valid data
    When admin select tipe transaksi lainnya "Automation Testing PMAN"
    And admin submit tambah data transfer
    And admin search cp disbursement by "Nama Property" using keyword "Khusus Automation"
    Then new cp disbursement data should add in daftar transfer
      | Tanggal Transfer ke Pemilik | Nama Property                                    | Tipe Transaksi          | Total Pendapatan | Detail Rekening                   |
      | (Today)                     | Kost Apik Khusus Automation PMAN Halmahera Utara | Automation Testing PMAN | Rp100.000        | Yudha Ferroza 10000245429 mandiri |

  @TEST_SS-668 @continue
  Scenario: Delete Total Pendapatan and Check Error Message and Transfer Sekarang button
    When admin clicks Transfer button in one of list data transaction
    And admin remove "Total Pendapatan" value
    Then error message on "Total Pendapatan" field is displayed
    And Tambahkan button is disable

  @TEST_SS-665 @continue
  Scenario: Delete Nomor Rekening and Check Error Message and Transfer Sekarang button
    When admin refresh page in CP Disbursement
    And admin clicks Transfer button in one of list data transaction
    And admin remove "Nomor Rekening" value
    Then error message on "Nomor Rekening" field is displayed
    And Tambahkan button is disable

  @TEST_SS-666
  Scenario: Delete Nama Pemilik Rekening and Check Error Message and Transfer Sekarang button
    When admin refresh page in CP Disbursement
    And admin clicks Transfer button in one of list data transaction
    And admin remove "Nama Pemilik Rekening" value
    Then error message on "Nama Pemilik Rekening" field is displayed
    And Tambahkan button is disable

  @TEST_SS-663
  Scenario: Input Total Pendapatan with Char
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin tambah data transfer
    And admin search property "khusus" in tambah data transfer
    And admin select suggestion "Kost Apik Khusus Automation PMAN Halmahera Utara"
    And admin fill remaining field
      | Total Pendapatan | Tipe Transaksi | Tanggal Transfer | Berkas Laporan  | Tipe Disbursement    |
      | 123abc           | Commission     | today            | pdf example.pdf | Disbursement susulan |
    Then error message on "Total Pendapatan" field is displayed
    And Tambahkan button is disable

  @TEST_SS-683 @continue
  Scenario: Add without fill any field
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin tambah data transfer
    Then Tambahkan button is disable

  @TEST_SS-671 @continue
  Scenario: Tambah Data Transfer pop up display
    When admin refresh page in CP Disbursement
    And admin tambah data transfer
    Then tambah data transfer pop up contains field
      | Nama Property                                       |
      | Product Type                                        |
      | Nomor Rekening                                      |
      | Nama Pemilik Rekening                               |
      | Nomor Telepon Pemilik                               |
      | Total Pendapatan                                    |
      | Total Pendapatan Sebelum Komisi + Add On (jika ada) |
      | Tipe Transaksi                                      |
      | Tanggal Transfer ke Pemilik                         |
      | Berkas Laporan Pendapatan                           |
      | Tipe Disbursement                                   |
    And tambah data transfer pop up title is "Tambah Data Transfer"
    And tambah data transfer pop up have button
      | Kembali   |
      | Tambahkan |

  @TEST_SS-677 @continue
  Scenario: Empty tipe transaksi lainnya
    When admin search property "khusus" in tambah data transfer
    And admin select suggestion "Kost Apik Khusus Automation PMAN Halmahera Utara"
    And admin fill remaining field
      | Total Pendapatan | Tipe Transaksi | Tanggal Transfer | Berkas Laporan  | Tipe Disbursement    |
      | 123abc           | Lainnya        | today            | pdf example.pdf | Disbursement susulan |
    Then error message on "Tipe Transaksi" field is displayed
    And Tambahkan button is disable

  @TEST_SS-673 @continue
  Scenario: Kembali from pop up tambah data transfer
    When admin "kembali" pop up tambah data transfer
    Then tambah data transfer pop up closed

  @TEST_SS-674 @continue
  Scenario: Close pop up tambah data transfer
    When admin tambah data transfer
    And admin "close" pop up tambah data transfer
    Then tambah data transfer pop up closed

  @TEST_SS-669 @continue
  Scenario: Input Invalid Bank Account
    When admin refresh page in CP Disbursement
    And admin tambah data transfer
    And admin search property "khusus" in tambah data transfer
    And admin select suggestion "Kost Apik Khusus Automation PMAN Halmahera Utara"
    And admin fill remaining field
      | Total Pendapatan | Tipe Transaksi | Tanggal Transfer | Berkas Laporan  | Tipe Disbursement    |
      | 100000           | Commission     | today            | pdf example.pdf | Disbursement susulan |
    And admin fill nomor rekening "lorem ipsum"
    Then error message on "Nomor Rekening" field is displayed

  @TEST_SS-676 @continue
  Scenario: Add without fill bank account name
    When admin refresh page in CP Disbursement
    And admin tambah data transfer
    And admin search property "khusus" in tambah data transfer
    And admin select suggestion "Kost Apik Khusus Automation PMAN Halmahera Utara"
    And admin fill nama pemilik rekening "-"
    Then error message on "Nama Pemilik Rekening" field is displayed

  @TEST_SS-675 @continue
  Scenario: Add without fill tipe transaksi
    When admin refresh page in CP Disbursement
    And admin tambah data transfer
    And admin search property "khusus" in tambah data transfer
    And admin select suggestion "Kost Apik Khusus Automation PMAN Halmahera Utara"
    And admin fill remaining field
      | Total Pendapatan | Tipe Transaksi | Tanggal Transfer | Berkas Laporan  | Tipe Disbursement    |
      | 100000           | -              | today            | pdf example.pdf | Disbursement susulan |
    Then error message on "Tipe Transaksi" field is displayed

  @TEST_SS-672
  Scenario: Add without select schedule transfer
    When admin refresh page in CP Disbursement
    And admin tambah data transfer
    And admin search property "khusus" in tambah data transfer
    And admin select suggestion "Kost Apik Khusus Automation PMAN Halmahera Utara"
    And admin fill remaining field
      | Total Pendapatan | Tipe Transaksi | Tanggal Transfer | Berkas Laporan  | Tipe Disbursement    |
      | 100000           | Commission     | -                | pdf example.pdf | Disbursement susulan |
    Then error message on "Tanggal Transfer" field is displayed