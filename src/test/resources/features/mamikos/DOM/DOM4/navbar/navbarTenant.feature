Feature: Navbar Tenant

  @bagas @TEST_DOM-1857 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-search
  Scenario: [Dweb][Navbar] Check Navbar in Search Page Before login
    Given user go to mamikos homepage
    When user search keyword:
      | search stag   | search prod|
      | UGM    | UGM   |
    Then navbar before login appears

  @bagas @TEST_DOM-1868 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page Before login 1
    Given user navigates to mamikos-kost
    Then navbar kost before login appears

  @bagas @TEST_DOM-1868 @Automated @DOM4 @Web @discovery-platform @navbar @navbar-before-login @navbar-other
  Scenario: [Dweb][Navbar]Check Navbar in url Page Before login 1
    Given user navigates to mamikos-booking
    Then navbar kost before login appears