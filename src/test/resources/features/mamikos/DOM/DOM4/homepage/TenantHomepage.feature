Feature: Homepage

  @Automated @DOM4 @Web @discovery-platform @homepage @header
  Scenario: [Dweb][Homepage]Check cari iklan dropdown items
    Given user go to mamikos homepage
    Then tenant can see ads dropdown option

  @Automated @DOM4 @Web @discovery-platform @homepage @header
  Scenario: [Dweb][Homepage]Check profile dropdown items after login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    Then tenant can see profile dropdown option

  @Automated @DOM4 @Web @discovery-platform @footer @footer-mamikos @homepage
  Scenario: [Dweb][Homepage]Check redirection kebijakan privasi on homepage
    Given user go to mamikos homepage
    And user open kebijakan privasi in footer
    And tenant set active page to 1
    Then user should redirect to kebijakan privasi page

  @Automated @DOM4 @Web @discovery-platform @footer @footer-mamikos @homepage
  Scenario: [Dweb][Homepage]Check redirection syarat dan ketentuan on homepage
    Given user go to mamikos homepage
    And user open syarat dan ketentuan in footer
    And tenant set active page to 1
    Then user should redirect to syarat dan ketentuan link "https://help.mamikos.com/post/syarat-dan-ketentuan-umum"