@newowner-dashboard @regression @LIMO2 @listing-monetization @ownerDashboardGP
Feature: Owner Dashboard GP

  @TEST_LIMO-1723 @continue
  Scenario: See info untuk anda while MARS NON GP with have unreplied chat and quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 082233545515 | 0          | 12345678 |
    Then owner click "1 calon penyewa menunggu balasan chat. Yuk balas biar cepat di-booking."
    * user will see that the text "Sisa kuota mingguan" is displayed
    * user will see that the text "1 chat room" is displayed
  @checkRedirectionInfoUntukAnda @continue
    Scenario: check redirection info untuk anda while MARS NON GP with have unreplied chat and quota
    And owner navigates to "/"
    Then owner click "BARU: Chat tanpa batas dengan berlangganan paket GoldPlus!"
    * user should redirect to link "https://mamikos.com/info/mamikos-goldplus-2/"