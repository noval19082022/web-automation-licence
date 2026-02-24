@ss @booking-page @SS16

  Feature: Room Limit Alert

    @TEST_SS-6765
    Scenario: Tenant view room limit alert in P1 listing
      Given user go to mamikos homepage
      And user login as tenant via phone number:
        | phone stag   | phone prod   | password    |
        | 087890902024 | 087890902024 | qwerty123   |
      #room available >5 room
      When tenant search kost then go to kost details:
        | kost name stag                            | kost name prod                            |
        | Kost Singgahsini Pangeran Kumbang Tipe A  | Kost Singgahsini Pangeran Kumbang Tipe A  |
      And tenant booking kost for "Tomorrow"
      Then tenant not see room limit alert
      #room available <5 room
      When user go to mamikos homepage
      And tenant search kost then go to kost details:
        | kost name stag                  | kost name prod                  |
        | Kost Apik Marlin Tipe A Lombok  | Kost Apik Marlin Tipe A Lombok  |
      And tenant dismiss promo ngebut pop up
      And tenant booking kost for "Tomorrow"
      Then tenant can see room limit alert

    @TEST_SS-6767
    Scenario: Tenant view room limit alert in P2 listing
      Given user go to mamikos homepage
      And user login as tenant via phone number:
        | phone stag   | phone prod   | password    |
        | 087890902024 | 087890902024 | qwerty123   |
      #room available >5 room
      When tenant search kost then go to kost details:
        | kost name stag            | kost name prod            |
        | Kost Tobelo Asri Village  | Kost Tobelo Asri Village  |
      And tenant booking kost for "Tomorrow"
      Then tenant not see room limit alert
      #room available <5 room
      When user go to mamikos homepage
      When tenant search kost then go to kost details:
        | kost name stag          | kost name prod          |
        | kost satu gp satu saja  | kost satu gp satu saja  |
      And tenant dismiss promo ngebut pop up
      And tenant booking kost for "Tomorrow"
      Then tenant can see room limit alert