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
    And mamikos bangkrupux admin should be successfully logged out

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


  @TEST_LIMO-1587 @continue @topUp
  Scenario: Adjust Point Topup
    Given admin go to mamikos bangkrupux admin
    * admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    * admin access user point menu
    When user filter user point by keyword "phone number" is "0895359416718"
    * user clicks on Search button
    * user clicks Adjust Point icon
    * user choose adjustment type "Topup"
    * user fills out point amount
    * user fills out note for "topup"
    * user clicks on Submit button on Adjust Point form
    Then user verify allert success "Success!" and "successfully updated."

  @TEST_LIMO-1583 @topUp
  Scenario: Adjust Point Topdown
    * admin access user point menu
    When user filter user point by keyword "phone number" is "0895359416718"
    * user clicks on Search button
    * user clicks Adjust Point icon
    * user choose adjustment type "Topdown"
    * user fills out point amount
    * user fills out note for "topdown"
    * user clicks on Submit button on Adjust Point form
    Then user verify allert success "Success!" and "successfully updated."
    And mamikos bangkrupux admin should be successfully logged out

  @TEST_LIMO-1582 @continue @bulkUserPoint
  Scenario: Manage User Point Display
    Given admin go to mamikos bangkrupux admin
    * admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    * admin access user point menu
    Then user see Bulk Adjust Point button
    * user see Bulk Update Blacklist button
    * user see Keyword Filter
    * user see User Filter
    * user see Status Filter
    * user see Search button
    * user see Name
    * user see Email
    * user see Phone Number
    * user see User
    * user see Total Point
    * user see Status
    * user see Adjust Point icon
    * user see History icon
    * user see Pagination

     #Scenario: Manage Point History display TENG-1445
    When user clicks Total Point header
    * user clicks Total Point header
    * user click history icon on manage user point page
    Then user see at manage user point history contains:
      | Content                     |
      | Squilliam Fancyson as Owner |
      | Email: aditmami1@gmail.com  |
      | Phone: 082328130250         |
      | Date                        |
      | Activity                    |
      | Notes                       |
      | Point                       |
      | Total                       |

     #Scenario: Pagination manage user point filter TENG-1449
    When user choose to filter all activity with value "Admin Adjustment"
    Then history with selected filter value "Admin Adjustment" is displayed

    #Scenario: Pagination manage user point history TENG-1446
    When user click next page button on manage user point
    Then next manage user point page will be opened
    When user click previous page button on manage user point
    Then previous manage user point page will be opened
    When user click page index "2" at user point
    Then manage user point page "2" will be opened

   #Scenario: Pagination manage user point TENG-1442
    * admin access user point menu
    When user click next page button on manage user point
    Then next manage user point page will be opened
    When user click previous page button on manage user point
    Then previous manage user point page will be opened
    When user click page index "2" at user point
    Then manage user point page "2" will be opened

  @TEST_LIMO-1621 @continue @bulkUserPoint
  Scenario: Bulk Update Blacklist
    * admin access user point menu
    * admin click Bulk Update Blacklist
    Then admin see "Bulk Update Blacklist User" pop-up appear
    When admin upload csv file "bulk_blacklist"
    * user click button submit csv bulk blacklist
    Then success Update Blacklist using csv

  @TEST_LIMO-1622 @bulkUserPoint
  Scenario: Bulk Adjust Point
    * admin access user point menu
    * user click Bulk Adjust Point
    Then admin see "Bulk Adjust Point" pop-up appear
    When admin upload csv file "bulk_adjust_point"
    * user click button submit csv bulk adjust point
    Then success Update Blacklist using csv