@SS12 @NAVBAR_SEARCH_MIGRATE
Feature: Navbar Tenant

  @TEST_SS-3221 @Automated @SS12 @Web @discovery-platform @navbar @navbar-before-login @navbar-search
  Scenario: [Dweb][Navbar] Check Navbar in Search Page Before login
    Given user go to mamikos homepage
    When user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    Then navbar before login appears

  @TEST_SS-3215 @Automated @SS12 @Web @discovery-platform @navbar @navbar-before-login @navbar-other @TEST_COOP-5676
  Scenario: [Dweb][Navbar]Check Navbar in url mamikos-kost Page Before login
    Given user navigates to mamikos-kost
    Then navbar kost before login appears

  @TEST_SS-3201 @Automated @SS12 @Web @discovery-platform @navbar @navbar-before-login @navbar-other @TEST_COOP-5677
  Scenario: [Dweb][Navbar]Check Navbar in url mamikos-booking Page Before login
    Given user navigates to mamikos-booking
    Then navbar kost before login appears

  @TEST_SS-3203 @Automated @SS12 @Web @discovery-platform @navbar @navbar-before-login @navbar-other @TEST_COOP-5678
  Scenario: [Dweb][Navbar]Check Navbar in url mamikos-promo-kost Page Before login
    Given user navigates to mamikos-promo-kost
    Then navbar before login appears

  @TEST_SS-3198 @Automated @SS12 @Web @discovery-platform @navbar @navbar-before-login @navbar-other @TEST_COOP-5679
  Scenario: [Dweb][Navbar]Check Navbar in url mamikos-history Page Before login
    Given user navigates to mamikos-history
    Then Check navbar before login appears in pencari login

  @TEST_SS-3181 @Automated @SS12 @Web @discovery-platform @navbar @navbar-before-login @navbar-kost-detail
  Scenario: [Dweb][Kost Detail][Navbar]Check Navbar in Kost Detail Page Before login
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-b-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user in kost detail navbar before login appears

  @TEST_SS-3217 @Automated @SS12 @Web @discovery-platform @navbar @navbar-after-login @navbar-search
  Scenario: [Dweb][Navbar]Check Navbar in Search Page After login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    Then navbar after login appears

  @TEST_SS-3183 @Automated @SS12 @Web @discovery-platform @navbar @navbar-after-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page After login kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user navigates to mamikos-kost
    Then navbar after login appears

  @TEST_SS-5167 @Automated @SS12 @Web @discovery-platform @navbar @navbar-after-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page After login booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user navigates to mamikos-booking
    Then navbar after login appears

  @TEST_SS-5168 @Automated @SS12 @Web @discovery-platform @navbar @navbar-after-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page After login promo kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user navigates to mamikos-promo-kost
    Then navbar after login appears

  @TEST_SS-5169 @Automated @SS12 @Web @discovery-platform @navbar @navbar-after-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page After login history
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user navigates to mamikos-history
    Then navbar after login appears

  @TEST_SS-3182 @Automated @SS12 @Web @discovery-platform @navbar @navbar-after-login @navbar-kost-detail
  Scenario: [Dweb][Kost Detail][Navbar] Check Navbar in Kost Detail Page After login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-b-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then navbar after login appears

