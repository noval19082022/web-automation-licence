@SS12 @essentialTest @FAVORITE_SEARCH_MIGRATE
Feature: Favorite and Share kost

  @TEST_SS-3216 @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Favorite] Tenant - Check Redirection without login
    Given tenant navigate to favorite page
    Then user see login pop up in favorite page

  @TEST_SS-3281 @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Kost Detail][FavoriteKost] Tenant Favourite a kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-b-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can favorite the kost

  @TEST_SS-3212 @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Kost Detail][FavoriteKost] Tenant Unfavourite a kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-b-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can unfavorite the kost

  @TEST_SS-3286 @automated @discovery-platform @favorite @web
  Scenario: [Dweb][Kost Detail][FavoriteKost] Non Login User Favourite a kos
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-b-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then Non login user cannot favorite the kost

  @TEST_SS-3220 @automated @discovery-platform @web @share-kost
  Scenario: [Dweb][Kost Detail][ShareKost] User Share a kos
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-b-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can share the kost