@DOM4
Feature: Navbar Tenant

  @TEST_DOM-1857 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-search
  Scenario: [Dweb][Navbar] Check Navbar in Search Page Before login
    Given user go to mamikos homepage
    When user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    Then navbar before login appears

  @TEST_DOM-1868 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other @TEST_COOP-5676
  Scenario: [Dweb][Navbar]Check Navbar in url mamikos-kost Page Before login
    Given user navigates to mamikos-kost
    Then navbar kost before login appears

  @TEST_DOM-1868 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other @TEST_COOP-5677
  Scenario: [Dweb][Navbar]Check Navbar in url mamikos-booking Page Before login
    Given user navigates to mamikos-booking
    Then navbar kost before login appears

  @TEST_DOM-1859 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other @TEST_COOP-5678
  Scenario: [Dweb][Navbar]Check Navbar in url mamikos-promo-kost Page Before login
    Given user navigates to mamikos-promo-kost
    Then navbar before login appears

  @TEST_DOM-1859 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other @TEST_COOP-5679
  Scenario: [Dweb][Navbar]Check Navbar in url mamikos-history Page Before login
    Given user navigates to mamikos-history
    Then navbar before login appears

  @TEST_DOM-1866 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-kost-detail
  Scenario: [Dweb][Kost Detail][Navbar]Check Navbar in Kost Detail Page Before login
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | ATCOOP12 Kos Dom Automation PLM Tipe B Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user in kost detail navbar before login appears

  @TEST_DOM-1852 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-after-login @navbar-search
  Scenario: [Dweb][Navbar]Check Navbar in Search Page After login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    Then navbar after login appears

  @TEST_DOM-1850 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-after-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page After login 1
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user navigates to mamikos-kost
    Then navbar after login appears

  @TEST_DOM-1850 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-after-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page After login 1
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user navigates to mamikos-booking
    Then navbar after login appears

  @TEST_DOM-1850 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-after-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page After login 1
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user navigates to mamikos-promo-kost
    Then navbar after login appears

  @TEST_DOM-1850 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-after-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page After login 1
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And user navigates to mamikos-history
    Then navbar after login appears

  @TEST_DOM-1847 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-after-login @navbar-kost-detail
  Scenario: [Dweb][Kost Detail][Navbar] Check Navbar in Kost Detail Page After login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089988776655 | 089988776655 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | ATCOOP12 Kos Dom Automation PLM Tipe B Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then navbar after login appears

