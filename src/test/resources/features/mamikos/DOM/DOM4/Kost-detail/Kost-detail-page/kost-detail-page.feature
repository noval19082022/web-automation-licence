#@local #@DOM4
@DOM4
Feature: Kost detail page

  @TEST_COOP-5471 @DOM4 @automated @discovery-platform @kost-details @overview-section @web
  Scenario: [Dweb][Kost Detail]Check property overview section
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe G Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see overview section on detail page
      | kost stag                                   | kost prod                                           |
      | Kos Dom Automation PLM Tipe G Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
#
  @TEST_COOP-5469 @DOM4 @automated @discovery-platform @kost-details @promo-owner @web
  Scenario: [Dweb][Kost Detail] Check promo owner section login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And user want to select kost on promo section
    And tenant set active page to 1
    Then user see promo owner section
    #user want to ask to owner for more detail kost promo
    When user want to get more information about kost promo
    Then user will get "Hubungi Kost" pop up

  @TEST_COOP-5470 @DOM4 @automated @discovery-platform @kost-details @web
  Scenario: [Dweb][Kost Detail] Check promo owner section non login
    Given user go to mamikos homepage
    When user want to select kost on promo section
    Then user see promo owner section
    # user want to ask to owner for more detail kost promo
    When user want to get more information about kost promo
    Then user will see login pop up

  @TEST_COOP-5472 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility room section without login condition
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe G Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user want to see more detail room facility section on the kost detail page
    Then user will see login pop up

  @TEST_COOP-5475 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility room section with login condition
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe G Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user want to see more detail room facility section on the kost detail page
    Then user see all facility room section

  @TEST_COOP-5474 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility bath section
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe B Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility bath section on detail page

  @TEST_COOP-5477 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail]Check facility notes section on kost that has 3 rows of facility notes
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe C Kretek Bantul | Kos BX Automation PLM Tipe C Tobelo Halmahera Utara |
    Then user can see facility notes on detail kos and button is not present

  @TEST_COOP-5479 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility notes section on kost that has 4 rows of facility notes
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe G Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility notes on detail kos and button is present

  @TEST_COOP-5466 @DOM4 @automated @discovery-platform @kost-details @owner-story @web
  Scenario: [Dweb][Kost Detail]Check owner story section on kost that has 3 rows of owner story
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe C Kretek Bantul | Kos BX Automation PLM Tipe B Tobelo Halmahera Utara |
    Then user can see owner story on detail kos and button is not present

  @TEST_COOP-5481 @DOM4 @automated @discovery-platform @kost-details @owner-story @web
  Scenario: [Dweb][Kost Detail]Check owner story section on kost that has 4 rows of owner story
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe H Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see owner story on detail kos and button is present

  @TEST_COOP-5480 @DOM4 @automated @discovery-platform @facility @kost-details @web @flakyDOM
  Scenario: [Dweb][Kost Detail] Check facility share section without login
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe B Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility share section on detail page
    #user want to see more detail facility share
    When user want to see all facility share
    Then user will see login pop up

  @TEST_COOP-5467 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility share section with login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe G Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility share section on detail page
    #user want to see more detail facility share
    When user want to see all facility share
    Then user see all facility share section
#
  @TEST_COOP-5468 @DOM4 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility parking section
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe B Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility parking section on detail page

  @TEST_COOP-5473 @DOM4 @automated @discovery-platform @kost-details @kost-rule @web
  Scenario: [Dweb][Kost Detail] Validate Kos rule element on kos detail
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                             | kost name prod               |
      | Kos DC BAR Automation Tipe G | Kos DC BAR Automation Tipe G |
    Then user can see kos rule list on detail kos

  @TEST_COOP-5476 @DOM4 @automated @discovery-platform @kost-details @map @web
  Scenario: [Dweb][Kost Detail] Check Map section tenant without login
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                             | kost name prod               |
      | Kos DC BAR Automation Tipe G | Kos DC BAR Automation Tipe G |
    Then user want to reached map section and see lihat peta button
    #user want to see map more detail
    When user want to see more detail kost location
    Then user will see login pop up

  @TEST_COOP-5478 @DOM4 @automated @discovery-platform @kost-details @map @web
  Scenario: [Dweb][Kost Detail] Check Map section when tenant login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                              | kost name prod               |
      | Kos Dom Automation PLM Tipe G Kretek Bantul | Kos DC BAR Automation Tipe A |
    Then user want to reached map section and see tanya alamat lengkap button
    #user want to see map more detail
    When user want to ask kost address
    Then chat room appear with latest message "beralamat di "