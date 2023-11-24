@cp-disbursement @tambah-daftar-transfer @pman @regression

Feature: CP Disbursement - Tambah Daftar Transfer

  @TEST_PMAN-3328 @continue
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
      | Product Type | Bank     | Nomor Rekening | Nama Pemilik Rekening | Nomor Telepon Pemilik |
      | APIK         | mandiri  | 10000245429    | Yudha Ferroza         | 083342344565          |

  @TEST_PMAN-3339 @continue
  Scenario: Ensure data not deleted when popup closed
    When admin fill remaining field
      | Total Pendapatan  | Tipe Transaksi  | Tanggal Transfer  | Berkas Laporan  | Tipe Disbursement     |
      | 100000            | Commission      | today             | pdf example.pdf | Disbursement susulan  |
    And admin close pop up tambah data transfer
    And admin tambah data transfer
    Then all information should be keep
      | Nama Property                                     | Product Type | Bank     | Nomor Rekening | Nama Pemilik Rekening | Nomor Telepon Pemilik | Total Pendapatan  | Tipe Transaksi  | Tanggal Transfer  | Berkas Laporan  | Tipe Disbursement     |
      | Kost Apik Khusus Automation PMAN Halmahera Utara  | APIK         | mandiri  | 10000245429    | Yudha Ferroza         | 083342344565          | 100000            | Commission      | today             | pdf example.pdf | Disbursement susulan  |

  @TEST_PMAN-3333 @continue
  Scenario: input > 50 characters in tipe transaksi lainnya
    When admin select tipe transaksi lainnya ">50 characters"
    Then admin only can input transaksi lainnya using only 50 characters

  @TEST_PMAN-3340
  Scenario: Submit with valid data
    When admin select tipe transaksi lainnya "Automation Testing PMAN"
    And admin submit tambah data transfer
    Then new cp disbursement data should add in daftar transfer
      | Tanggal Transfer ke Pemilik | Nama Property                                     | Tipe Transaksi          | Total Pendapatan  | Detail Rekening                   |
      | (Today)                     | Kost Apik Khusus Automation PMAN Halmahera Utara  | Automation Testing PMAN | Rp100.000         | Yudha Ferroza 10000245429 mandiri |