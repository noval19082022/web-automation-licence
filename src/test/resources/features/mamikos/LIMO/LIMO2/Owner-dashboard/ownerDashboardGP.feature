@newowner-dashboard @regression @LIMO2 @listing-monetization @ownerDashboardGP
Feature: Owner Dashboard GP

  @TEST_LIMO-1723
  Scenario: See info untuk anda while MARS NON GP with have unreplied chat and quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 082233545515 | 0          | 12345678 |
    Then owner click "1 calon penyewa menunggu balasan chat. Yuk balas biar cepat di-booking."
    And user will see that the text "Sisa kuota mingguan" is displayed
    And user will see that the text "1 chat room" is displayed
    When owner navigates to owner dashboard
    Then owner should successfully log out

  @TEST_LIMO-1725 @continue
  Scenario: See info untuk anda while MARS NON GP with have unreplied chat and doesnt have quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 088112233452 | 0          | qwerty123 |
    Then user will see that the text "Kuota chat habis. 1 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas chat." is displayed

  @checkRedirectionInfoUntukAndaDoesntHaveQuota @continue
  Scenario: check redirection info untuk anda while MARS NON GP with have unreplied chat and doesnt have quota
    When owner click "Kuota chat habis. 1 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas chat. "
    Then user should redirect to link "https://owner-jambu.kerupux.com/goldplus/submission/packages"
    And owner should successfully log out

  @TEST_LIMO-1724 @continue
  Scenario: See info untuk anda while MARS NON GP with doesnt have unreplied chat and doesnt have quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 088112233453 | 0          | qwerty123 |
    Then user will see that the text "GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran! " is displayed

  @checkRedirectionInfoUntukAndaDoesntHaveQuota @continue
  Scenario: check redirection info untuk anda while MARS NON GP with have unreplied chat and doesnt have quota
    When owner click "GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran! "
    Then user should redirect to link "https://owner-jambu.kerupux.com/goldplus/submission/packages?redirection_source=infountukanda"
    And owner should successfully log out

  @TEST_LIMO-1742
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
    Then validate that owner have "GoldPlus 1"
    When owner click "Selamat, Anda bebas kirim chat tanpa kuota sebagai pelanggan GoldPlus."
    Then verify ftue "displayed"
    * verify title ftue is "Hore! Anda bisa chat tanpa kuota" and description "Sebagai pengguna GoldPlus, Anda bisa chat dan menjangkau penyewa sepuasnya tanpa batas kuota."

    # Scenario: Click button FTUE MARS on chatlist page && verify label goldplus
    When user click "Apa itu kuota chat room?"
    * user click "Saya Mengerti"
    * user click close icon tooltip broadcast chat on chatlist
    Then verify label goldplus on chatlist

    @resetGP
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "088112233454"
