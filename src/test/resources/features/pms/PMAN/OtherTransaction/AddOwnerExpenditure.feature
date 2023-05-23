@regression @pman @pms @owner-expenditure

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

  @TEST_PMAN-6313 @pman-prod
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
