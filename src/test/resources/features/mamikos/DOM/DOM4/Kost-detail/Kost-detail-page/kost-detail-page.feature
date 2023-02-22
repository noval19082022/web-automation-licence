#@DOM4
Feature: Kost detail page

  @TEST_DOM-1703 @DOM4 @automated @discovery-platform @kost-details @overview-section @web
  Scenario: [Dweb][Kost Detail]Check property overview section
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see overview section on detail page
      | kost stag                     | kost prod                                           |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |

  @TEST_DOM-1701 @DOM4 @automated @discovery-platform @kost-details @promo-owner @web
  Scenario: [Dweb][Kost Detail] Check promo owner section login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And user want to select kost on promo section
    Then user see promo owner section
    # user want to ask to owner for more detail kost promo
    When user want to get more information about kost promo
    Then user will get "Hubungi Kost" pop up

  @TEST_DOM-1702 @DOM4 @automated @discovery-platform @kost-details @web
  Scenario: [Dweb][Kost Detail] Check promo owner section non login
    Given user go to mamikos homepage
    When user want to select kost on promo section
    Then user see promo owner section
    # user want to ask to owner for more detail kost promo
    When user want to get more information about kost promo
    Then user will see login pop up

  @TEST_DOM-1704 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility room section without login condition
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user want to see more detail room facility section on the kost detail page
    Then user will see login pop up

  @TEST_DOM-1707 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility room section with login condition
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user want to see more detail room facility section on the kost detail page
    Then user see all facility room section

  @TEST_DOM-1706 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility bath section
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility bath section on detail page

  @TEST_DOM-1708 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail]Check facility notes section on kost that has 3 rows of facility notes
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe B | Kos BX Automation PLM Tipe B Tobelo Halmahera Utara |
    Then user can see facility notes on detail kos and button is not present

  @TEST_DOM-1710 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility notes section on kost that has 4 rows of facility notes
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility notes on detail kos and button is present