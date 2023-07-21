@newowner-dashboard @regression @LIMO2 @listing-monetization @ownerDashboardGP
Feature: Owner Dashboard GP

  @TEST_LIMO-1723
  Scenario: See info untuk anda while MARS NON GP with have unreplied chat and quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 082233545515 | 0          | 12345678 |
    Then user verify text "1 calon penyewa menunggu balasan chat. Yuk balas biar cepat di-booking." on section info untuk anda is appear
    * user will see that the text "Sisa kuota mingguan" is displayed
    * user verify kuota chat is "1 chat room"
    Then user verify text "BARU: Chat tanpa batas dengan berlangganan paket GoldPlus!" on section info untuk anda is appear
    * user should redirect to link "https://mamikos.com/info/mamikos-goldplus-2/"


