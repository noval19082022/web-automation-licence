@ss @DOM1
Feature: Voucher Kost Detail

  @TEST_SS-8407 @continue
  Scenario: [Web][Kost Detail][Voucher]Check voucher when have voucher  available (Kost SS)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 0812000008 | 0890867321203 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                                | kost path prod               |
      | kost-kabupaten-lombok-barat-kost-campur-eksklusif-kost-singgahsini-rizki-abadi-tipe-a-lombok-2 | Kos DC BAR Automation Tipe A |
    Then tenant can see "Voucher Khusus Singgahsini" section
    And tenant click on "Voucher Khusus Singgahsini" section
    Then tenant can see voucher list

  @TEST_SS-8408
    Scenario: [Web][Kost Detail][Voucher]Check voucher when  have voucher  available (Kost Apik)
    Given tenant redirect to kost details:
      | kost path stag                                                                                | kost path prod               |
      | kost-kabupaten-lombok-barat-kost-campur-eksklusif-kost-apik-marlin-tipe-a-lombok-2 | Kos DC BAR Automation Tipe A |
    Then tenant can see "Voucher Khusus APIK" section
    And tenant click on "Voucher Khusus APIK" section
    Then tenant can see voucher list
