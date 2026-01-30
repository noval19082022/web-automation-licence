@LIMO2 @regression @gp-onboarding @owner @DONEMIGRATINGTONEWBOARD @checkrevamplagiselasa
Feature: Owner Dashboard GP-Onboarding

  @continue @TEST_LIMO-3405
  Scenario: [Web Owner][GP-Onboarding] Owner visit “Panduan Fitur di GoldPlus”
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 087133998156 | 0          | qwerty123 |
    And owner go to panduan gold plus page
    Then owner will see that detail text on goldplus guides page:
      | Title                     | Description                                                                                |
      | Naikkan Iklan Anda        | Gunakan MamiAds untuk memperluas jangkauan iklan.                                         |
      | Memantau Performa Kos     | Lihat performa kos Anda setelah menggunakan GoldPlus.                                     |
      | Cek Properti Sekitar      | Anda dapat memantau kondisi bisnis kos sekitar.                                            |
      | Menggunakan MamiPoin      | Lebih banyak point yang Anda dapatkan bersama GoldPlus. Tukarkan dengan hadiah menarik.   |
      | Kelola Tagihan            | Anda bisa melihat catatan tagihan penyewa dan mengirim pengingat pembayaran.               |

  @continue @TEST_LIMO-3406
  Scenario: [Web Owner][GP-Onboarding] Naikkan Iklan Anda - Swiper Left/Previous Button Should Be Disabled
    When owner click on "Naikkan Iklan Anda" guide card
    Then owner can see swiper left or previous button is disabled

  @continue @TEST_LIMO-3407
  Scenario Outline: [Web Owner][GP-Onboarding] Naikkan Iklan Anda - Check MamiAds Guide Swiper Functionality Left To Right
    Then owner can see swiper number <number> is selected
    And owner can see selected swiper with title <number>
    And owner can see swiper text body is "<text_body>"
    When owner click on next button to go to slide number <number> with total number slides are 7
    Examples:
      | number | text_body                          |
      | 1      | Kunjungi Menu MamiAds              |
      | 2      | Beli Saldo MamiAds                 |
      | 3      | Pilih Iklan Properti Anda          |
      | 4      | Pilih Jenis Anggaran               |
      | 5      | Anggaran Aktif Setiap Hari         |
      | 6      | Kendalikan Pengeluaran Saldo       |
      | 7      | Pantau Performa di Statistik Iklan |

  @continue @TEST_LIMO-3408
  Scenario: [Web Owner][GP-Onboarding] Naikkan Iklan Anda - Swiper Right/Next Button Should Be Disabled
    Then owner can see swiper right or next button is disabled

  @continue @TEST_LIMO-3409
  Scenario Outline: [Web Owner][GP-Onboarding] Naikkan Iklan Anda - Check MamiAds Guide Swiper Functionality Right To Left
    Then owner can see swiper number <number> is selected
    And owner can see selected swiper with title <number>
    And owner can see swiper text body is "<text_body>"
    When owner click on previous button to go to slide number <number>
    Examples:
      | number | text_body                          |
      | 7      | Pantau Performa di Statistik Iklan |
      | 6      | Kendalikan Pengeluaran Saldo       |
      | 5      | Anggaran Aktif Setiap Hari         |
      | 4      | Pilih Jenis Anggaran               |
      | 3      | Pilih Iklan Properti Anda          |
      | 2      | Beli Saldo MamiAds                 |
      | 1      | Kunjungi Menu MamiAds              |

  @continue @TEST_LIMO-3410
  Scenario: [Web Owner][GP-Onboarding] Naikkan Iklan Anda - Owner click on "Coba Sekarang"
    When owner clicks on coba sekarang button
    Then owner will see that detail text on popup mamiads:
      | TextPopUp                                                                                                    |
      | Properti Tampil Lebih di Atas                                                                                |
      | Cukup beli saldo MamiAds dan pilih properti yang ingin diiklankan di posisi lebih atas pada hasil pencarian. |
      | Properti Tampil di Banyak Tempat                                                                             |
      | Iklan tayang di berbagai titik strategis di aplikasi dan web Mamikos.                                        |
      | Tentukan Anggaran Harian                                                                                     |
      | Anda dapat membatasi pemakaian saldo MamiAds per harinya sesuai kebutuhan Anda.                              |
      | Pantau Performa Iklan                                                                                        |
      | Lewat Statistik Iklan, Anda dapat melihat perkembangan iklan Properti Anda.                                  |
      | Cara Menggunakan MamiAds                                                                                     |

      #After revamp this case not valid
#  @continue @TEST_LIMO-3411
#  Scenario: [Web Owner][GP-Onboarding] Naikkan Iklan Anda - Swiper Left/Previous Button On MamiAds Onboarding Pop-Up Should Be Disabled
#    Then owner can see swiper left or previous button on gold plus onboarding pop-up is disabled

  @continue @TEST_LIMO-3412
  Scenario Outline: [Web Owner][GP-Onboarding] Naikkan Iklan Anda - Owner Can Use MamiAds Onboarding Pop-Up Swiper From Right To Left
    Then owner can see gp onboarding swiper number <swiper number> is selected
    And owner can see gp onboarding pop-up text head "<text head>" is selected
    And owner can see gp onboarding pop-up text body "<text body>" is selected
    And owner can see gp onboarding pop-up image alt text "<image alt text>" is visible
    When owner click on next button on gp onboarding pop-up to go to slide number <swiper number>
    Examples:
      | swiper number | text head                          | text body                                                      | image alt text                       |
      | 1             | Kunjungi Menu MamiAds              | Klik Kelola pada halaman utama Mamikos, lalu pilih MamiAds.    | illustration mamiads click           |
      | 2             | Beli Saldo MamiAds                 | Klik “Beli Saldo” pada halaman MamiAds.                        | illustration buy mamiads             |
      | 3             | Pilih Iklan Properti Anda          | Anda bebas memilih properti yang ingin diiklankan.             | illustration make property ads       |
      | 4             | Pilih Jenis Anggaran               | Anda dapat membatasi pemakaian saldo MamiAds sesuai kebutuhan. | illustration choose budget type      |
      | 5             | Anggaran Aktif Setiap Hari         | Setiap hari, iklan dinaikkan dengan anggaran yang sama.        | illustration mamiads success         |
      | 6             | Kendalikan Pengeluaran Saldo       | Nonaktifkan MamiAds Anda untuk menghentikan pemakaian saldo.   | illustration mamiads balance control |
      | 7             | Pantau Performa di Statistik Iklan | Lihat perkembangan iklan Anda di sini.                         | illustration mamiads statistic       |

    #After revamp this case not valid
#  @continue @TEST_LIMO-3413
#  Scenario: [Web Owner][GP-Onboarding] Naikkan Iklan Anda - Swiper Right/Next Button On MamiAds Onboarding Pop-Up Should Be Disabled
#    Then owner can see swiper right or next button on gold plus onboarding pop-up is disabled

  @continue @TEST_LIMO-3414
  Scenario Outline: [Web Owner][GP-Onboarding] Naikkan Iklan Anda - Owner Can Use MamiAds Onboarding Pop-Up Swiper Left To Right
    Then owner can see gp onboarding swiper number <swiper number> is selected
    And owner can see gp onboarding pop-up text head "<text head>" is selected
    And owner can see gp onboarding pop-up text body "<text body>" is selected
    And owner can see gp onboarding pop-up image alt text "<image alt text>" is visible
    When onwer click on previous button on gp onboarding pop-up to go to slide number <swiper number>
    Examples:
      | swiper number | text head                          | text body                                                      | image alt text                       |
      | 7             | Pantau Performa di Statistik Iklan | Lihat perkembangan iklan Anda di sini.                         | illustration mamiads statistic       |
      | 6             | Kendalikan Pengeluaran Saldo       | Nonaktifkan MamiAds Anda untuk menghentikan pemakaian saldo.   | illustration mamiads balance control |
      | 5             | Anggaran Aktif Setiap Hari         | Setiap hari, iklan dinaikkan dengan anggaran yang sama.        | illustration mamiads success         |
      | 4             | Pilih Jenis Anggaran               | Anda dapat membatasi pemakaian saldo MamiAds sesuai kebutuhan. | illustration choose budget type      |
      | 3             | Pilih Iklan Properti Anda          | Anda bebas memilih properti yang ingin diiklankan.             | illustration make property ads       |
      | 2             | Beli Saldo MamiAds                 | Klik “Beli Saldo” pada halaman MamiAds.                        | illustration buy mamiads             |
      | 1             | Kunjungi Menu MamiAds              | Klik Kelola pada halaman utama Mamikos, lalu pilih MamiAds.    | illustration mamiads click           |

  @continue @TEST_LIMO-3415
  Scenario: [Web Owner][GP-Onboarding] Owner visit “Panduan Fitur di GoldPlus” and click “Memantau Performa Kos”
    When owner navigates to owner dashboard
    And owner go to panduan gold plus memantau performa kos page
    Then owner will see that detail text on goldplus guides page:
      | TextOnPage                                                                                                     |
      | Pantau Performa Bisnis Kos dengan Statistik GoldPlus                                                           |
      | Statistik GoldPlus memperlihatkan data terkini seputar iklan kos Anda, untuk keputusan bisnis yang lebih baik. |
      | Di Statistik GoldPlus, Anda dapat melihat:                                                                     |
      | Performa Iklan Kos Anda                                                                                        |
      | Anda bisa lihat seberapa banyak kunjungan iklan, chat, booking, dan performa lainnya di kos Anda.              |
      | Gambaran Profil Pencari Kos                                                                                    |
      | Cari tahu pencari kos seperti apa yang mem-booking kos Anda.                                                   |
    And owner will see that detail text on popup mamiads:
      | Cara menggunakan Statistik GoldPlus |

  @continue @TEST_LIMO-3416
  Scenario: [Web Owner][GP-Onboarding] Memantau Performa Kos - Statistik GoldPlus Onboarding Swiper Left/Previous Button Should Be Disabled
    Then owner can see swiper left or previous button is disabled

  @continue @TEST_LIMO-3417
  Scenario Outline: [Web Owner][GP-Onboarding] Memantau Performa Kos - Owner Can Use Statistik GoldPlus Onboarding Pop-Up Swiper Left To Right
    Then owner can see gp onboarding number <number> is selected
    And owner can see gp onboarding text title is "<onboarding text title>"
    And owner can see gp onboarding text body is "<onboarding text body>"
    And owner can see gp onboarding image alt text is "<image alternative text>"
    And owner can see swiper number <number> is selected
    And owner can see selected swiper with title <number>
    And owner can see swiper text body is "<onboarding text title>"
    When owner click on next button to go to slide number <number> with total number slides are 4
    Examples:
      | number | onboarding text title           | onboarding text body                                          | image alternative text       |
      | 1      | Klik menu “Statistik”           | Lihat menu di layar bawah, dan klik “Statistik”.              | illustration click statistic |
      | 2      | Klik “Statistik GoldPlus”       | Ada tiga jenis statistik, pilih “Statistik GoldPlus”.         | illustration click GoldPlus  |
      | 3      | Pilih Nama Kos                  | Klik kos yang Anda ingin lihat statistiknya.                  | illustration select kost     |
      | 4      | Selesai! Cek Statistik Kos Anda | Di halaman ini, Anda bisa melihat performa kos GoldPlus Anda. | illustration check statistic |

  @continue @TEST_LIMO-3418
  Scenario: [Web Owner][GP-Onboarding] Memantau Performa Kos - Statistik GoldPlus Onboarding Swiper Right/Next Button Should Be Disabled
    Then owner can see swiper right or next button is disabled

  @continue @TEST_LIMO-3419
  Scenario Outline: [Web Owner][GP-Onboarding] Memantau Performa Kos - Owner Can Use Statistik GoldPlus Onboarding Pop-Up Swiper Right To Left
    Then owner can see gp onboarding number <number> is selected
    And owner can see gp onboarding text title is "<onboarding text title>"
    And owner can see gp onboarding text body is "<onboarding text body>"
    And owner can see gp onboarding image alt text is "<image alternative text>"
    And owner can see swiper number <number> is selected
    And owner can see selected swiper with title <number>
    And owner can see swiper text body is "<onboarding text title>"
    When owner click on previous button to go to slide number <number>
    Examples:
      | number | onboarding text title           | onboarding text body                                          | image alternative text       |
      | 4      | Selesai! Cek Statistik Kos Anda | Di halaman ini, Anda bisa melihat performa kos GoldPlus Anda. | illustration check statistic |
      | 3      | Pilih Nama Kos                  | Klik kos yang Anda ingin lihat statistiknya.                  | illustration select kost     |
      | 2      | Klik “Statistik GoldPlus”       | Ada tiga jenis statistik, pilih “Statistik GoldPlus”.         | illustration click GoldPlus  |
      | 1      | Klik menu “Statistik”           | Lihat menu di layar bawah, dan klik “Statistik”.              | illustration click statistic |

  @continue @TEST_LIMO-3420
  Scenario: [Web Owner][GP-Onboarding] Memantau Performa Kos - Coba Sekarang Button Functionality
    When owner clicks on coba sekarang button

  @continue @TEST_LIMO-3421
  Scenario Outline: [Web Owner][GP-Onboarding] Memantau Performa Kos - Available Package In Statistik GoldPlus
    When owner can see gp statistic header text as "Statistik GoldPlus"
    Then owner can see gp statistic filter text number <number> is "<package>"
    Examples:
      | number | package |
      | 1      | Semua   |

  @TEST_LIMO-3422
  Scenario: [Web Owner][GP-Onboarding] Memantau Performa Kos - Verify "Semua" As Selected Package List
    Then owner can see gp statistic list active package and it contents elements
    And owner should successfully log out
