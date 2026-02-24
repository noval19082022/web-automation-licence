@SS7
Feature: Check Harga Coret on Kost Detail

  @TEST_SS-3355 @TEST_SS-3354
  Scenario: Check harga coret on kost detail (BBM-1336)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890000000314 | 0890000000314 | Bismillah@01 |
    And tenant redirect to kost details:
      | kost path stag                                                                                 | kost path prod               |
      | kost-kabupaten-lombok-barat-kost-campur-eksklusif-kost-singgahsini-rizki-abadi-tipe-a-lombok-2 | Kos DC BAR Automation Tipe A |
    And tenant dismiss promo ngebut pop up
    And tenant fill booking data for "tomorrow" and "Per Minggu"
    Then user can see harga coret on price section
    When tenant fill booking data for "tomorrow" and "Per Bulan"
    Then user can see harga coret on price section
    When tenant fill booking data for "tomorrow" and "Per 3 Bulan"
    Then user can see harga coret on price section
    When tenant fill booking data for "tomorrow" and "Per 6 Bulan"
    Then user can see harga coret on price section
    When tenant fill booking data for "tomorrow" and "Per Tahun"
    Then user can see harga coret on price section