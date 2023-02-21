Feature: Navbar Tenant

  @TEST_DOM-1857 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-search
  Scenario: [Dweb][Navbar] Check Navbar in Search Page Before login
    Given user go to mamikos homepage
    When user search keyword:
      | search stag   | search prod|
      | UGM    | UGM   |
    Then navbar before login appears

  @TEST_DOM-1868 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page Before login 1
    Given user navigates to mamikos-kost
    Then navbar kost before login appears

  @TEST_DOM-1868 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page Before login 1
    Given user navigates to mamikos-booking
    Then navbar kost before login appears

  @TEST_DOM-1859 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page Before login 2
    Given user navigates to mamikos-promo-kost
    Then navbar before login appears

  @TEST_DOM-1859 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page Before login 2
    Given user navigates to mamikos-history
    Then navbar before login appears

  @TEST_DOM-1866 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-kost-detail
  Scenario: [Dweb][Kost Detail][Navbar]Check Navbar in Kost Detail Page Before login
    Given user go to mamikos homepage
    When user search property name and select matching result to go kos detail
      | favorite stag                     | favorite prod                                       |
      | Kos Dom Automation PLM Tipe A     | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user in kost detail navbar before login appears