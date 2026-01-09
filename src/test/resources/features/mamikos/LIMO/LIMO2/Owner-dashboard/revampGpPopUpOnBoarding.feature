@LIMO2 @revampGpOnboarding @finalcheckdulu
Feature: Revamp GP Onboarding

  @resetGP @continue
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "08159787775"

  @TEST_LIMO-9180 @continue
  Scenario: [Revamp GP Onboarding] Target Audience Validation - Owner has never purchased GP 1/2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08159787775 | 0          | qwerty123 |
    And Owner visit Goldplus package without action close the on boarding pop up
    Then Owner see gp onboarding pop up is exist

  @TEST_LIMO-9183 @continue
  Scenario: [Revamp GP Onboarding] Verify Swipeable Content Functionality
    And Owner swap the gp pop up onboarding

  @TEST_LIMO-9184 @continue
  Scenario: [Revamp GP Onboarding] Verify 3 Dots Indicator Display and Behavior
    And Owner swap the gp pop up onboarding 3 times

  @TEST_LIMO-9185 @continue
  Scenario: [Revamp Pilih Paket GP] Verify package GP Display Side by Side
    And Owner tap on pilih paket goldplus from gp onboarding pop up
    Then owner will see that the text "Manfaat GoldPlus 1" is displayed
    Then owner will see that the text "Manfaat GoldPlus 2" is displayed

  @TEST_LIMO-9186 @continue
  Scenario: [Revamp Pilih Paket GP] Verify Backend Content Handling for Package Copies
    Then owner verify list of Pilih Gp Package is appear
       """
      - img "back"
      - paragraph: Paket GoldPlus
      - img
      - paragraph: Paket Simpel
      - separator
      - paragraph: Chat tanpa batas
      - paragraph: Iklan lebih prioritas dari non-GoldPlus
      - paragraph: Lihat profil penyewa dasar
      - paragraph: Daftar Tunggu 10 penyewa
      - text: Baru
      - paragraph: Terima Survei Kos fitur dasar
      - paragraph: Cek Properti Sekitar
      - paragraph: Buat Promo Iklan
      - paragraph: Cashback MamiAds mulai dari 7.500
      - separator
      - paragraph: Mulai dari
      - paragraph: Rp249.000/Bulan
      - text: "-17%"
      - paragraph: Rp299.000
      - button "Pilih Paket"
      - paragraph: Manfaat GoldPlus 1
      - dialog
      - img
      - paragraph: Paket Lengkap
      - text: Favorit
      - separator
      - img
      - paragraph: Chat tanpa batas
      - img
      - paragraph: Iklan lebih prioritas dari GoldPlus 1
      - img
      - paragraph: Lihat profil penyewa lengkap
      - img
      - paragraph: Daftar Tunggu tanpa batas
      - text: Baru
      - img
      - paragraph: Terima Survei Kos fitur penuh
      - img
      - paragraph: Cek Properti Sekitar
      - img
      - paragraph: Buat Promo Iklan
      - img
      - paragraph: Broadcast Chat
      - img
      - paragraph: Cashback MamiAds mulai dari 35.000
      - separator
      - paragraph: Mulai dari
      - paragraph: Rp24.000/Bulan
      - text: "-100%"
      - paragraph: Rp30.000.000
      - button "Pilih Paket"
      - paragraph: Manfaat GoldPlus 2
      - dialog
      - paragraph: Masih bingung?
      - paragraph: Cari tahu lebih banyak di bawah
      - img "book"
      - paragraph: Baca tentang GoldPlus di sini
      - img "chevron-right"
       """

  @TEST_LIMO-9187
  Scenario: [Revamp Pilih Paket GP] Verify GP1 Benefits List Content
    Then owner verify list of Pilih Gp Package is contains
       """
      - img "back"
      - paragraph: Paket GoldPlus
      - img
      - paragraph: Paket Simpel
      - separator
      - paragraph: Chat tanpa batas
      - paragraph: Iklan lebih prioritas dari non-GoldPlus
      - paragraph: Lihat profil penyewa dasar
      - paragraph: Daftar Tunggu 10 penyewa
      - text: Baru
      - paragraph: Terima Survei Kos fitur dasar
      - paragraph: Cek Properti Sekitar
      - paragraph: Buat Promo Iklan
      - paragraph: Cashback MamiAds mulai dari 7.500
      - separator
      - paragraph: Mulai dari
      - paragraph: Rp249.000/Bulan
      - text: "-17%"
      - paragraph: Rp299.000
      - button "Pilih Paket"
      - paragraph: Manfaat GoldPlus 1
       """


  @TEST_LIMO-9181 @continue
  Scenario: [Revamp GP Onboarding] Non Target Audience Verification - Owner has previously owned GP 1/2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08119787890 | 0          | qwerty123 |
    And Owner visit Goldplus package without action close the on boarding pop up
    Then Owner see gp onboarding pop up is not exist

  @TEST_LIMO-9188
  Scenario: [Revamp Pilih Paket GP] Verify MamiAds Copy for GPMA Segment Users
    Then owner will see that the text "Cashback MamiAds mulai dari 35.000" is displayed

  @TEST_LIMO-9189
  Scenario: [Revamp Pilih Paket GP] Verify "Tawaran Terbatas" Display for GPSP Segment
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0815978777129 | 0          | qwerty123 |
    And Owner visit Goldplus package without action close the on boarding pop up
    Then owner will see that the text "Tawaran terbatas!" is displayed
    Then owner verify list of Pilih Gp Package is contains
      """
      - img "back"
      - paragraph: Paket GoldPlus
      - img
      - paragraph: Paket Simpel
      - separator
      - paragraph: Chat tanpa batas
      - paragraph: Iklan lebih prioritas dari non-GoldPlus
      - paragraph: Lihat profil penyewa dasar
      - paragraph: Daftar Tunggu 10 penyewa
      - text: Baru
      - paragraph: Terima Survei Kos fitur dasar
      - paragraph: Cek Properti Sekitar
      - paragraph: Buat Promo Iklan
      - paragraph: Cashback MamiAds mulai dari 7.500
      - separator
      - paragraph:
        - img "promo"
        - text: Tawaran terbatas!
      - paragraph: Mulai dari
      - paragraph: Rp99.000/Bulan
      - text: "-18%"
      - paragraph: Rp120.000
      - button "Pilih Paket"
      - paragraph: Manfaat GoldPlus 1
      """

  @TEST_LIMO-9190 @continue
  Scenario: [Revamp Pilih Paket GP] GPSP Flagging "Paket lengkap murah" on GP2 for Medium 3
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0815978777123 | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    And Owner visit Goldplus package without action close the on boarding pop up
    Then owner will see that the text "Paket lengkap murah" is displayed

  @TEST_LIMO-9191
  Scenario: [Revamp Pilih Paket GP] Verify GP1/GP2 Benefits Detail Navigation
    Then owner will see that the text "Manfaat GoldPlus 1" is displayed
    Then owner will see that the text "Manfaat GoldPlus 2" is displayed
    When owner wants to see Lihat Detail Manfaat Goldplus Satu
    And user clicks on the close button
    When owner wants to see Lihat Detail Manfaat Goldplus Dua
    And user clicks on the close button

  @TEST_LIMO-9217
  Scenario: [Revamp Pilih Paket GP] GPSP Flagging "Yuk coba lagi promo" on GP2 for Medium 3
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0815978777124 | 0          | qwerty123 |
    And Owner visit Goldplus package without action close the on boarding pop up
    And Owner tap on pilih paket goldplus from gp onboarding pop up
    Then owner will see that the text "Yuk coba, lagi promo" is displayed
    Then owner verify list of Pilih Gp Package is contains
      """
      - paragraph:
        - img "promo"
        - text: Yuk coba, lagi promo
      """

  @TEST_LIMO-9218
  Scenario: [Revamp Pilih Paket GP] GPSP Flagging "Yuk coba lagi promo" on GP1 for low1/2/3/4 or medium 1/2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0815978777125 | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    And Owner visit Goldplus package without action close the on boarding pop up
    And Owner tap on pilih paket goldplus from gp onboarding pop up
    Then owner will see that the text "Yuk coba, lagi promo" is displayed
    Then owner verify list of Pilih Gp Package is contains
      """
      - paragraph:
        - img "promo"
        - text: Yuk coba, lagi promo
      """