@regression @pman2 @pms @owner-expenditure

Feature: Add Owner Expenditure
  Background: Open Other Transaction Menu
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to other transation menu

  @TEST_PMAN-6038
  Scenario: Add valid owner expenditure
    When admin add new owner expenditure "Reimbursement" in property "Khusus Automation"
    And admin add multiple biaya pengeluaran :
      | no  | Kategori Pengeluaran        | Nama Pengeluaran  | Kuantitas | Nominal Pengeluaran | Status Persediaan | Jenis Produk  |
      | 1   | Administrasi & Iuran Kos    | Wifi              | 1         | 50000               | Non Stock         | LSSS          |
      | 2   | Amenities Penyewa           | Sabun Mandi       | 1         | 20000               | Stock             | LSAP          |
      | 3   | Bahan Pembersih Kos & Dapur | Wipol             | 1         | 20000               | Stock             | PC            |
    And admin upload valid attachment
    And admin input no invoice biaya "AT/2023/01"
    And admin choose tujuan transfer "Other (Internal Mamikos)"
    And submit owner expenditure
    Then owner expenditure confirmation pop up appear
    #cancel confirmation add owner expenditure
    When user "cancel" tambah data owner expenditure
    Then confirmation pop up should closed
    #confirm add owner expenditure
    When submit owner expenditure
    And user "confirm" tambah data owner expenditure
    Then toast message "Data berhasil ditambah" should be appear
    And new owner expenditure record should be on the first list contains:
      | Tipe Pengajuan Cash Out | Nama Properti                                     | Total Pengeluaran |
      | Reimbursement           | Kost Apik Khusus Automation PMAN Halmahera Utara  | Rp90.000          |
    And should contains nama pengeluaran:
      | Wifi        |
      | Sabun Mandi |
      | Wipol       |

  @TEST_PMAN-6311
  Scenario Outline: Search active and expired property
    When admin add new owner expenditure and search property "<keyword>"
    Then system should show property suggestion "<property name>"

    Examples:
      | keyword | property name                                             |
      | Asgard  | Kost Singgahsini Asgard Halmahera Utara                   |
      | Beruang | Kost Singgahsini Beruang Terbang Mamitest Halmahera Utara |

  @TEST_PMAN-6439
  Scenario Outline: Search terminated and auto_terminated property
    When admin add new owner expenditure and search property "<keyword>"
    Then property suggestion not appear

    Examples:
      | keyword     |
      | Jotunheim   |
      | Woodchuck   |

  @TEST_PMAN-6312
  Scenario: Auto Fill Kota and Sisa Kontrak Kerja Sama
    #terminated property
    When admin add new owner expenditure and search property "Jotunheim"
    Then kota and sisa kontrak kerja sama should be "-"
    #active property
    When admin edit and choose property "Asgard"
    Then system should be auto fill kota and sisa kontrak kerja sama

  @TEST_PMAN-6313 @pman2-prod
  Scenario: Verify Kategori Pengeluaran List
    When admin tambah data owner expenditure
    Then admin verify kategori pengeluaran list should contains :
      | Administrasi & Iuran Kos                    |
      | Amenities Penyewa                           |
      | Bahan Pembersih Kos & Dapur                 |
      | Gaji & Biaya Operasional Staff              |
      | Pembayaran Listrik                          |
      | Pembayaran PDAM                             |
      | Pembayaran Wifi                             |
      | Pengendalian Hama                           |
      | Perbaikan AC                                |
      | Perbaikan Fasilitas Bangunan                |
      | Perbaikan Fasilitas Kamar                   |
      | Perbaikan Fasilitas Umum                    |
      | Perbaikan Wifi                              |
      | Perlengkapan Dapur                          |
      | Perlengkapan Kebersihan Kos                 |
      | Lainnya                                     |

  @TEST_PMAN-6314 @pman2-prod
  Scenario: Nama Pengeluaran Validation
    When admin tambah data owner expenditure
    #empty nama pengeluaran
    And admin fill biaya pengeluaran except nama pengeluaran
    Then tambah pengeluaran button should be disabled
    #valid nama pengeluaran
    When admin fill nama pengeluaran "Gaji Penjaga"
    Then tambah pengeluaran button should be enable
    #nama pengeluaran more than 50 characters
    When admin fill nama pengeluaran more than 50 characters
    Then nama pengeluaran should be only contains 50 characters
    And tambah pengeluaran button should be enable

  @TEST_PMAN-6315 @pman2-prod
  Scenario: Kuantitas Validation
    When admin tambah data owner expenditure
    #empty kuantitas
    And admin fill biaya pengeluaran except kuantitas
    Then tambah pengeluaran button should be disabled
    #kuantitas = 0
    When admin fill kuantitas "0"
    Then kuantitas field value should be "0"
    And tambah pengeluaran button should be disabled
    #input char in kuantitas
    When admin fill kuantitas "abcdefghijklmnopqrstuvwxyz!@#$%^&*()-="
    Then kuantitas field value should be empty
    And tambah pengeluaran button should be disabled
    #input valid kuantitas
    When admin fill kuantitas "50"
    Then kuantitas field value should be "50"
    And tambah pengeluaran button should be enable

  @TEST_PMAN-6316 @pman2-prod
  Scenario: Nominal Pengeluaran Validation
    When admin tambah data owner expenditure
    #empty nominal
    And admin fill biaya pengeluaran except nominal
    Then tambah pengeluaran button should be disabled
    #nominal pengeluaran 0
    When admin fill biaya pengeluaran "0"
    Then tambah pengeluaran button should be disabled
    #valid nominal pengeluaran
    When admin fill biaya pengeluaran "10000"
    Then biaya pengeluaran value should be "10.000"

  @TEST_PMAN-6035 @pman2-prod
  Scenario: Upload Valid Format Attachment
    When admin tambah data owner expenditure
    #upload valid jpg
    And admin upload "jpg" attachment
    Then "jpg" attachment should be uploaded
    #uplaod valid jpeg
    When admin delete attachment
    And admin upload "jpeg" attachment
    Then "jpeg" attachment should be uploaded
    #uplaod valid png
    When admin delete attachment
    And admin upload "png" attachment
    Then "png" attachment should be uploaded
    #uplaod valid pdf
    When admin delete attachment
    And admin upload "pdf" attachment
    Then "pdf" attachment should be uploaded
    #upload valid jpg more than 8MB
    When admin delete attachment
    And admin upload "jpg 8MB" attachment
    Then show upload attachment error message
    #upload valid pdf more than 8MB
    When admin delete attachment
    And admin upload "pdf 8MB" attachment
    Then show upload attachment error message

  @TEST_PMAN-6036 @pman2-prod
  Scenario: Upload Invalid Format Attachment
    When admin tambah data owner expenditure
    And admin upload invalid attachment
    Then show upload attachment error message

  @TEST_PMAN-6538 @pman2-prod
  Scenario: Max 30 pengeluaran each Owner Expenditure
    When admin tambah data owner expenditure
    And admin add 30 pengeluaran
    Then admin can't add more pengeluaran

  @TEST_PMAN-6537 @pman2-prod
  Scenario: Total Pengeluaran Calculation
    When admin tambah data owner expenditure
    #there is no pengeluaran yet
    Then total pengeluaran should be "-"
    #Add pengeluaran 1
    When admin add pengeluaran :
      | no  | Kategori Pengeluaran        | Nama Pengeluaran  | Kuantitas | Nominal Pengeluaran | Status Persediaan | Jenis Produk  |
      | 1   | Administrasi & Iuran Kos    | Wifi              | 1         | 50000               | Non Stock         | LSSS          |
    Then total pengeluaran should be "Rp50.000"
    #Add pengeluaran 2
    When admin add pengeluaran :
      | no  | Kategori Pengeluaran        | Nama Pengeluaran  | Kuantitas | Nominal Pengeluaran | Status Persediaan | Jenis Produk  |
      | 2   | Amenities Penyewa           | Sabun Mandi       | 1         | 20000               | Stock             | LSAP          |
    Then total pengeluaran should be "Rp70.000"
    #Add pengeluaran 3
    When admin add pengeluaran :
      | no  | Kategori Pengeluaran        | Nama Pengeluaran  | Kuantitas | Nominal Pengeluaran | Status Persediaan | Jenis Produk  |
      | 3   | Bahan Pembersih Kos & Dapur | Wipol             | 1         | 10000               | Stock             | PC            |
    Then total pengeluaran should be "Rp80.000"
    #Remove pengeluaran 2
    When admin remove pengeluaran "2"
    Then total pengeluaran should be "Rp60.000"