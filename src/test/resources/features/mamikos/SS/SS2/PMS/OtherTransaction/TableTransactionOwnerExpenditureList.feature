@SS2 @pms @owner-expenditure

Feature: Table Transaction Owner Expenditure List

  Background: Open Other Transaction Menu
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to other transation menu

  @TEST_SS-562
  Scenario: Click Expand to See the Table Detail
    When admin expand first owner expenditure list
    Then first owner expenditure detail should be visible
      #Open Lampiran
    When admin click lihat lampiran first owner expenditure list
    And admin set active page to 1
    Then lampiran opened in new tab

  @TEST_SS-696
  Scenario: Check value in each filter
    When admin open filter owner expenditure
    Then status konfirmasi manager filter should contains option:
      | Menunggu Konfirmasi |
      | Dikonfirmasi        |
      | Ditolak             |
    And status konfirmasi finance filter should contains option:
      | Menunggu Konfirmasi |
      | Dikonfirmasi        |
      | Ditolak             |
    And kategori biaya filter should contains option:
      | Administrasi & Iuran Kos       |
      | Amenities Penyewa              |
      | Bahan Pembersih Kos & Dapur    |
      | Gaji & Biaya Operasional Staff |
      | Pembayaran Listrik             |
      | Pembayaran PDAM                |
      | Pembayaran Wifi                |
      | Pengendalian Hama              |
      | Perbaikan AC                   |
      | Perbaikan Fasilitas Bangunan   |
      | Perbaikan Fasilitas Kamar      |
      | Perbaikan Fasilitas Umum       |
      | Perbaikan Wifi                 |
      | Perlengkapan Dapur             |
      | Perlengkapan Kebersihan Kos    |
      | Lainnya                        |
    And tujuan transfer pengeluaran filter should contains option:
      | Aeroo System (Vendor)                              |
      | Agus Haryanto (Vendor)                             |
      | Amando Mitra Lestari (Vendor)                      |
      | Bagiyo Teknik (Vendor)                             |
      | Bambang Wartono (Vendor)                           |
      | Andriyanto Akbar Pratama Katili (Internal Mamikos) |
      | Aulia As Shiddiq (Internal Mamikos)                |
      | Ayu Putri (Internal Mamikos)                       |
      | Bima Kunta Wira Negara (Internal Mamikos)          |
      | Carsim (Internal Mamikos)                          |
      | Other (Internal Mamikos)                           |

  @TEST_SS-688
  Scenario Outline: Single Filter Status Konfirmasi Manager
    When admin filter status konfirmasi manager "<status>"
    Then system only display owner expenditure with status konfirmasi manager "<status>"

    Examples:
      | status              |
      | Menunggu Konfirmasi |
      | Dikonfirmasi        |
      | Ditolak             |

  @TEST_SS-686
  Scenario Outline: Single Filter Status Konfirmasi Finance
    When admin filter status konfirmasi finance "<status>"
    Then system only display owner expenditure with status konfirmasi finance "<status>"

    Examples:
      | status              |
      | Menunggu Konfirmasi |
      | Dikonfirmasi        |
      | Ditolak             |

  @TEST_SS-737
  Scenario Outline: Single Filter Kategori Biaya
    When admin filter kategori biaya "<kategori>"
    Then system only display owner expenditure contains biaya "<kategori>"

    Examples:
      | kategori                 |
      | Administrasi & Iuran Kos |
      | Amenities Penyewa        |
      | Pembayaran Wifi          |
      | Lainnya                  |

  @TEST_SS-735
  Scenario Outline: Single Filter Tujuan Transfer Pengeluaran
    When admin filter tujuan transfer "<vendor>"
    Then system only display owner expenditure transfered to "<Vendor Name>" "<Nama Pemilik Rekening>" "<No Rekening>" "<Nama Bank>"

    Examples:
      | vendor                       | Vendor Name   | Nama Pemilik Rekening      | No Rekening     | Nama Bank |
      | Agus Haryanto (Vendor)       | Agus Haryanto | Agus Haryanto              | 307801035017535 | BRI       |
      | Bagiyo Teknik (Vendor)       | Bagiyo Teknik | Bagiyo                     | 6760559405      | BCA       |
      | Ayu Putri (Internal Mamikos) | Ayu Putri     | Ayu Putri Niken Pratiwi    | 3940229609      | BCA       |
      | Febrian (Internal Mamikos)   | Febrian       | Febrian                    | 662969867       | BCA       |
      | Other (Internal Mamikos)     | Other         | MAMA TEKNOLOGI PROPERTI PT | 1262407777      | BCA       |

  @TEST_SS-739
  Scenario: Multiple Filter Owner Expenditure
    When admin filter status konfirmasi manager "Dikonfirmasi"
    And admin filter status konfirmasi finance "Menunggu Konfirmasi"
    And admin filter kategori biaya "Perbaikan AC"
    And admin filter tujuan transfer "Clean and Cool Indonesia"
#      And admin filter tanggal mulai "today"
#      And admin filter tanggal akhir "tomorrow"
    Then system only display owner expenditure with status konfirmasi manager "Dikonfirmasi"
    And system only display owner expenditure with status konfirmasi finance "Menunggu Konfirmasi"
    And system only display owner expenditure contains biaya "Perbaikan AC"
    And system only display owner expenditure transfered to "Clean and Cool Indonesia" "Lina Wardana" "1821208756" "BCA"

  @TEST_SS-693
  Scenario: Reset Filter Owner Expenditure
    When admin choose some filter
    And admin reset filter from pop up
    Then counter in filter disappear
    When admin filter status konfirmasi manager "Menunggu Konfirmasi"
    And admin filter status konfirmasi finance "Menunggu Konfirmasi"
    Then counter in filter button "visible"
    When admin reset filter owner expenditure
    Then counter in filter button "hidden"