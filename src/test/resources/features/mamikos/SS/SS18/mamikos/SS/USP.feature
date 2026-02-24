@ss @SS16 @listing-detail @usp

Feature: Garansi Akurat - USP

  @TEST_SS-8043 @continue
  Scenario: Check USP in Singgahsini listing
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                                           | kost name prod                                           |
      | Kost Singgahsini Pangeran Kumbang Tipe A Halmahera Utara | Kost Singgahsini Pangeran Kumbang Tipe A Halmahera Utara |
    And tenant dismiss FTUE booking benefit
    Then tenant can see "Singgahsini" USP

  @TEST_SS-8044 @continue
  Scenario: Check USP in APIK listing
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                 | kost name prod                 |
      | Kost Apik Marlin Tipe A Lombok | Kost Apik Marlin Tipe A Lombok |
    And tenant dismiss promo ngebut pop up
    Then tenant can see "APIK" USP

  @TEST_SS-8047
  Scenario: Update Refund Wording
    Given user go to mamikos homepage
      #kost singgahsini
    When tenant search kost then go to kost details:
      | kost name stag                                           | kost name prod                                           |
      | Kost Singgahsini Pangeran Kumbang Tipe A Halmahera Utara | Kost Singgahsini Pangeran Kumbang Tipe A Halmahera Utara |
    Then tenant can see new refund wording
      #kost apik
    When tenant search kost then go to kost details:
      | kost name stag                 | kost name prod                 |
      | Kost Apik Marlin Tipe A Lombok | Kost Apik Marlin Tipe A Lombok |
    Then tenant can see new refund wording
      #kost andalan
    When tenant search kost then go to kost details:
      | kost name stag                               | kost name prod                                    |
      | Kost Featured Tiga Rini Kopang Lombok Tengah | talaud nih gaesss wkwkwkw Rainis Kepulauan Talaud |
    Then tenant can see new refund wording