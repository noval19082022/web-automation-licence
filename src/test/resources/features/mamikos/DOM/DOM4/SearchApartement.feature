@DOM4
Feature: Search Apartment

  @searchapartment @continue @TEST_DOM-1872
  Scenario: User Search Apartment Not Found
    Given user go to landing apartment
    When user search "Aceh" on landing apartment
    Then user can see no apartment list

  @searchapartment @TEST_DOM-1870
  Scenario: User Search Apartment By Keyword
    When user search "Jakarta" on landing apartment
    Then user can see apartment list