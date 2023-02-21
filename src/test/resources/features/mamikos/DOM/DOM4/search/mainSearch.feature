Feature: Main Search

  @TEST_DOM-1844 @Automated @DOM4 @Web @discovery-platform @search @search-suggest
  Scenario: [Dweb][Search]5 Suggestion List should appear
    Given user go to mamikos homepage
    When user search for random keyword:
      | search stag   | search prod|
      | semarang    | semarang   |
    Then should display the result list of keyword "semarang"

  @TEST_DOM-1853 @Automated @DOM4 @Web @discovery-platform @search @search-except-suggest
  Scenario: [Dweb][Search] Typing exception character
    Given user go to mamikos homepage
    When user search for random keyword:
      | search stag   | search prod|
      | asdfadjsade    | asdfadjsade   |
    Then should display the result exception "Tidak menemukan nama tempat / nama kost yang sesuai."

  @TEST_DOM-1849 @Automated @DOM4 @Web @discovery-platform @search @search-clear-text
  Scenario: [Dweb][Search] Reset text on searchbar
    Given user go to mamikos homepage
    When user search for random keyword:
      | search stag   | search prod|
      | jakarta    | jakarta   |
    Then user see searchbar is empty