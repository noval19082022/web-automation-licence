@DOM4 @essentialTest
Feature: Favorite and Share kost

  @TEST_COOP-5445 @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Favorite] Tenant - Check Redirection without login
    Given tenant navigate to favorite page
    Then user see login pop up in favorite page
  @TEST_COOP-5441 @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Kost Detail][FavoriteKost] Tenant Favourite a kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe B Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can favorite the kost
  @TEST_COOP-5444 @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Kost Detail][FavoriteKost] Tenant Unfavourite a kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe B Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can unfavorite the kost
  @TEST_COOP-5442 @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Kost Detail][FavoriteKost] Non Login User Favourite a kos
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe B Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then Non login user cannot favorite the kost
  @TEST_COOP-5443 @automated @discovery-platform @web @share-kost
  Scenario: [Dweb][Kost Detail][ShareKost] User Share a kos
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe B Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can share the kost