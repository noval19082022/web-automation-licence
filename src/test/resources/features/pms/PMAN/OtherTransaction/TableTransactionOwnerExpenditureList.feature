@pman @pms @owner-expenditure

  Feature: Table Transaction Owner Expenditure List
    Background: Open Other Transaction Menu
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to other transation menu

    @TEST_PMAN-5990
    Scenario: Click Expand to See the Table Detail
      When admin expand first owner expenditure list
      Then first owner expenditure detail should be visible
      #Open Lampiran
      When admin click lihat lampiran first owner expenditure list
      And admin set active page to 1
      Then lampiran opened in new tab

    @TEST_PMAN-6504
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
        | Administrasi & Iuran Kos        |
        | Amenities Penyewa               |
        | Bahan Pembersih Kos & Dapur     |
        | Gaji & Biaya Operasional Staff  |
        | Pembayaran Listrik              |
        | Pembayaran PDAM                 |
        | Pembayaran Wifi                 |
        | Pengendalian Hama               |
        | Perbaikan AC                    |
        | Perbaikan Fasilitas Bangunan    |
        | Perbaikan Fasilitas Kamar       |
        | Perbaikan Fasilitas Umum        |
        | Perbaikan Wifi                  |
        | Perlengkapan Dapur              |
        | Perlengkapan Kebersihan Kos     |
        | Lainnya                         |
      And tujuan transfer pengeluaran filter should contains option:
        | Aeroo System (Vendor)                               |
        | Agus Haryanto (Vendor)                              |
        | Amando Mitra Lestari (Vendor)                       |
        | Bagiyo Teknik (Vendor)                              |
        | Bambang Wartono (Vendor)                            |
        | Andriyanto Akbar Pratama Katili (Internal Mamikos)  |
        | Aulia As Shiddiq (Internal Mamikos)                 |
        | Ayu Putri (Internal Mamikos)                        |
        | Bima Kunta Wira Negara (Internal Mamikos)           |
        | Carsim (Internal Mamikos)                           |
        | Other (Internal Mamikos)                            |

    @TEST_PMAN-6548
    Scenario Outline: Single Filter Status Konfirmasi Manager
      When admin filter status konfirmasi manager "<status>"
      Then system only display owner expenditure with status konfirmasi manager "<status>"

      Examples:
      | status              |
      | Menunggu Konfirmasi |
      | Dikonfirmasi        |
      | Ditolak             |

    @TEST_PMAN-6550
    Scenario Outline: Single Filter Kategori Biaya
      When admin filter kategori biaya "<kategori>"
      Then system only display owner expenditure contains biaya "<kategori>"

      Examples:
        | kategori                        |
        | Administrasi & Iuran Kos        |
        | Amenities Penyewa               |
        | Pembayaran Wifi                 |
        | Lainnya                         |