@SS12
Feature: Search Apartment

  @searchapartment @continue @TEST_SS-3177
  Scenario: User Search Apartment Not Found
    Given user go to landing apartment
    When user search "Aceh" on landing apartment
    Then user can see no apartment list

  @searchapartment @TEST_SS-3180
  Scenario: User Search Apartment By Keyword
    When user search "Jakarta" on landing apartment
    Then user can see apartment list

  @searchapartment @TEST_SS-3151
  Scenario Outline: [DWeb-Apartment][Search]: User want search any apartment by <Area>
    Given user go to mamikos homepage
    When user want to visit apartment list page from ads Dropdown
    When user select apartement by area on "<Area>"
    Then user will see that the text "1 - 18 Unit Apartemen dari" is displayed
    Examples:
      | Area         |
      | Yogyakarta   |
      | Jakarta Bara |