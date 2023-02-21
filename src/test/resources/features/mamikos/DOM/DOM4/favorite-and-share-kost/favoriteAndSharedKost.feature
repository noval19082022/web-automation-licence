Feature: Favorite and Share kost

  @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Favorite] Tenant - Check Redirection without login
    Given tenant navigate to favorite page
    Then user see login pop up in favorite page

  Scenario: [Dweb][Kost Detail][FavoriteKost] Tenant Favourite a kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |
    When tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can favorite the kost

  Scenario: [Dweb][Kost Detail][FavoriteKost] Tenant Unfavorite a kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 081223344550  | 083176408442  | qwerty123    |
    When tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can unfavorite the kost