@regression @LIMO2 @ownerDashboardGP
Feature: Owner Dashboard GP

  @resetGP
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "088112233454"

#  @TEST_LIMO-3601
#  Scenario: See info untuk anda while MARS NON GP with have unreplied chat and quota
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag   | phone prod | password |
#      | 082233545515 | 0          | 12345678 |
#    And user click info untuk anda "calon penyewa menunggu balasan chat. Yuk balas biar cepat di-booking."
#    And user will see that the text "1 chat room" is displayed
#    And owner navigates to owner dashboard

  @TEST_LIMO-3602 @continue @kuotaChatRedirection
  Scenario: See info untuk anda while MARS NON GP with have unreplied chat and doesnt have quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 088112233452 | 0          | qwerty123 |
    Then owner see info untuk anda section GP "Kuota chat habis. 1 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas chat." appears

  @kuotaChatRedirection @TEST_LIMO-3603
  Scenario: check redirection info untuk anda while MARS NON GP with have unreplied chat and doesnt have quota
    And user click info untuk anda "Kuota chat habis. 1 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas chat."
    Then owner navigate to list goldplus package

  @TEST_LIMO-3604 @continue @nonExperimentRedirection
  Scenario: See info untuk anda while MARS NON GP with doesnt have unreplied chat and doesnt have quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 088112233453 | 0          | qwerty123 |
    Then owner see info untuk anda section GP "GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran!" appears

  @TEST_LIMO-3605 @nonExperimentRedirection
  Scenario: check redirection info untuk anda while MARS NON GP with have unreplied chat and doesnt have quota
    And user click info untuk anda "GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran!"
    Then user should redirect to link "https://owner-jambu.kerupux.com/goldplus/submission/packages?redirection_source=infountukanda"

  @TEST_LIMO-3606
  Scenario: See info untuk anda while MARS GP with have unreplied chat Goldplus 1 or Goldplus 2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 088112233454 | 0          | qwerty123 |
    And user wants to subscribe Goldplus 1
    Then payment owner success using ovo as payment method

    # Scenario: MARS for check infp untuk anda at owner dashboard
    When owner navigates to "/"
    * owner click close icon pop up
#    Then validate that owner have "GoldPlus 1"
    And user click info untuk anda "Selamat, Anda bebas kirim chat tanpa kuota sebagai pelanggan GoldPlus."
    Then verify ftue "displayed"
    * verify title ftue is "Hore! Anda bisa chat tanpa kuota" and description "Sebagai pengguna GoldPlus, Anda bisa chat dan menjangkau penyewa sepuasnya tanpa batas kuota."

    # Scenario: Click button FTUE MARS on chatlist page && verify label goldplus
    When user click "Apa itu kuota chat room?"
    * user click "Saya Mengerti"
    Then verify label goldplus on chatlist

  @resetGP
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "088112233454"

  @TEST_LIMO-3608
  Scenario Outline: Owner can't see widget GP and info untuk anda for GP at owner dashboard when doesnt have property active or apartment only
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | <ownerPhone> | <password> |
    Then widget daftar GP is not appears
    And info untuk anda section GP "GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran! " is not appears
    Examples:
    #owner doesnt have property
    #owner only have 1 kost non active
    #owner only have apartement
    #owner only have kost draft
      | ownerPhone   | password  |
      | 0876623622   | qwerty123 |
      | 0876623687   | 12345678  |
      | 085687543611 | 12345678  |