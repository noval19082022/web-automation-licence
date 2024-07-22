@regression @userPoint @LIMO1 @LIMO1-staging

Feature: Manage User Point

#  @TEST_LIMO-63 @continue @userPoint
  Scenario: [Point Management][User Point] Filter User Point By Keyword
    Given admin go to mamikos bangkrupux admin
    * admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    * admin access user point menu
    When user filter user point by keyword "tenant name" is "Amanda"
    * user clicks on Search button
    Then system display list user point contains "Amanda"