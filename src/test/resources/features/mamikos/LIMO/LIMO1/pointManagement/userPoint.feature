@regression @userPoint @LIMO1 @LIMO1-staging

Feature: Manage User Point

  @TEST_LIMO-1588 @continue @userPoint
  Scenario: Filter User Point By Keyword
    Given admin go to mamikos bangkrupux admin
    * admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    * admin access user point menu
    When user filter user point by keyword "tenant name" is "Amanda"
    * user clicks on Search button
    Then system display list user point contains "Amanda"

  @TEST_LIMO-1619 @userPoint @continue
  Scenario: Filter User Point By User
    When admin access user point menu
    * user select filter User "owner"
    * user clicks on Search button
    Then system display list user point as "Owner"
    When user select filter User "tenant"
    * user clicks on Search button
    Then system display list user point as "Tenant"

  @TEST_LIMO-1620 @userPoint @continue
  Scenario: Filter User Point By Status
    When admin access user point menu
    * user select filter Status "Blacklist"
    * user clicks on Search button
    Then system display list user point as "Blacklist"
    When user select filter Status "Whitelist"
    * user clicks on Search button
    Then system display list user point as "Whitelist"

  @TEST_LIMO-1590 @userPoint @continue
  Scenario: Sorting Total Point
    When admin access user point menu
    * user clicks Total Point header
    Then user verify total point sorted "ascending"
    When user clicks Total Point header
    Then user verify total point sorted "descending"

  @TEST_LIMO-1585
  Scenario: Blacklist and Whitelist User Point
    Given admin go to mamikos bangkrupux admin
    * admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    * admin access user point menu
    When user filter user point by keyword "phone number" is "08766236902"
    * user clicks on Search button
    * user set the default status to Whitelist
    * user "Blacklist" user point and click "No, Go Back" on pop up confirmation
    Then system display list user point as "Whitelist"
    When user "Blacklist" user point and click "Yes, Do It!" on pop up confirmation
    * user filter user point by keyword "phone number" is "08766236902"
    * user clicks on Search button
    Then system display list user point as "Blacklist"
    * user filter user point by keyword "phone number" is "08766236902"
    * user clicks on Search button
    When user "Whitelist" user point and click "No, Go Back" on pop up confirmation
    Then system display list user point as "Blacklist"
    When user "Whitelist" user point and click "Yes, Do It!" on pop up confirmation
    * user filter user point by keyword "phone number" is "08766236902"
    * user clicks on Search button
    Then system display list user point as "Whitelist"