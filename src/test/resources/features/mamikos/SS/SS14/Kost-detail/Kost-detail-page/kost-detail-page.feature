#@local #@SS14
@SS12 @KOST_DETAIL_SEARCH_MIGRATE
Feature: Kost detail page

  @TEST_SS-3148 @SS12 @automated @discovery-platform @kost-details @overview-section @web
  Scenario: [Dweb][Kost Detail]Check property overview section
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod                                      |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-g-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see overview section on detail page
      | kost stag                                   | kost prod                                           |
      | Kos Dom Automation PLM Tipe G Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |

  @TEST_SS-3154 @SS12 @automated @discovery-platform @kost-details @promo-owner @web
  Scenario: [Dweb][Kost Detail] Check promo owner section login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    When tenant redirect to kost details:
      | kost path stag                                                               | kost path prod                                      |
      | kost-kabupaten-sleman-kost-campur-murah-kost-rumah-jepang-a-ccc-depok-sleman | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user see promo owner section
    #user want to ask to owner for more detail kost promo
    When user want to get more information about kost promo
    Then user will get "Hubungi Kost" pop up

  @TEST_SS-3147 @SS12 @automated @discovery-platform @kost-details @web
  Scenario: [Dweb][Kost Detail] Check promo owner section non login
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                               | kost path prod                                      |
      | kost-kabupaten-sleman-kost-campur-murah-kost-rumah-jepang-a-ccc-depok-sleman | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user see promo owner section
    # user want to ask to owner for more detail kost promo
    When user want to get more information about kost promo
    Then user will see login pop up

  @TEST_SS-3176 @SS12 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility room section without login condition
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod                                      |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-g-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user want to see more detail room facility section on the kost detail page
    Then user will see login pop up

  @TEST_SS-3166 @SS12 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility room section with login condition
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod                                      |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-g-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user want to see more detail room facility section on the kost detail page
    Then user see all facility room section

  @TEST_SS-3169 @SS12 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility bath section
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-b-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility bath section on detail page

  @TEST_SS-3174 @SS12 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail]Check facility notes section on kost that has 3 rows of facility notes
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-c-kretek-bantul | Kos BX Automation PLM Tipe C Tobelo Halmahera Utara |
    Then user can see facility notes on detail kos and button is not present

  @TEST_SS-3170 @SS12 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility notes section on kost that has 4 rows of facility notes
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod                                      |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-g-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility notes on detail kos and button is present

  @TEST_SS-3155 @SS12 @automated @discovery-platform @kost-details @owner-story @web
  Scenario: [Dweb][Kost Detail]Check owner story section on kost that has 3 rows of owner story
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-c-kretek-bantul | Kos BX Automation PLM Tipe B Tobelo Halmahera Utara |
    Then user can see owner story on detail kos and button is not present

  @TEST_SS-3159 @SS12 @automated @discovery-platform @kost-details @owner-story @web
  Scenario: [Dweb][Kost Detail]Check owner story section on kost that has 4 rows of owner story
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-h-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see owner story on detail kos and button is present

  @TEST_SS-3172 @SS12 @automated @discovery-platform @facility @kost-details @web @flakyDOM
  Scenario: [Dweb][Kost Detail] Check facility share section without login
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-b-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility share section on detail page
    #user want to see more detail facility share
    When user want to see all facility share
    Then user will see login pop up

  @TEST_SS-3156 @SS12 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility share section with login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod                                      |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-g-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility share section on detail page
    #user want to see more detail facility share
    When user want to see all facility share
    Then user see all facility share section
#
  @TEST_SS-3153 @SS12 @automated @discovery-platform @facility @kost-details @web
  Scenario: [Dweb][Kost Detail] Check facility parking section
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-b-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see facility parking section on detail page

  @TEST_SS-3168 @SS12 @automated @discovery-platform @kost-details @kost-rule @web
  Scenario: [Dweb][Kost Detail] Validate Kos rule element on kos detail
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user can see kos rule list on detail kos

  @TEST_SS-3167 @SS14 @automated @discovery-platform @kost-details @map @web
  Scenario: [Dweb][Kost Detail] Check Map section tenant without login
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user want to reached map section and see lihat peta button
    #user want to see map more detail
    When user want to see more detail kost location
    Then user will see login pop up

  @TEST_SS-3175 @SS14 @automated @discovery-platform @kost-details @map @web
  Scenario: [Dweb][Kost Detail] Check Map section when tenant login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod               |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-g-kretek-bantul | Kos DC BAR Automation Tipe A |
    Then user want to reached map section and see tanya alamat lengkap button
    #user want to see map more detail
    When user want to ask kost address
    Then chat room appear with latest message "beralamat di:"