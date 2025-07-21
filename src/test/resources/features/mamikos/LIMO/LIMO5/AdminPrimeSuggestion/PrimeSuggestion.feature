@regression @LIMO5
Feature: Prime suggestion

  @TEST_LIMO-4080
  Scenario: [Admin][Add listing] input listing for appears kos recommendation section
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin click on add kost to prime suggestion button
    And admin input kost name "Kos XDR Rajeg Tangerang Rajeg Tangerang"
    And admin click on search button
    And admin click on select button
    And admin input file csv
    And admin choose status "Active"
    And admin click on create button
    Then admin can see message "Success!"

  @TEST_LIMO-4081
  Scenario: [Admin][Add listing] Reset keyword
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin click on add kost to prime suggestion button
    And admin input kost name "Kos XDR Rajeg Tangerang Rajeg Tangerang"
    And admin click on search button
    And admin click on "Reset" button
    Then admin can see message "Select Kost"

  @TEST_LIMO-4082
  Scenario: [Admin][Add listing] Inactive prime suggestion (listing level)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin click on add kost to prime suggestion button
    And admin input kost name "Kos XDR Rajeg Tangerang Rajeg Tangerang"
    And admin click on search button
    And admin click on select button
    And admin input file csv
    And admin choose status "Inactive"
    And admin click on create button
    Then admin can see message "Success!"

  @TEST_LIMO-4114
  Scenario: [Admin][Filter] Status keyword enable
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin click on filter "active"
    And admin click on search button
    Then admin see list status mamiprime "active"

  @TEST_LIMO-4115
  Scenario: [Admin][Filter] Status keyword enable
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin click on filter "inactive"
    And admin click on search button
    Then admin see list status mamiprime "inactive"

  @TEST_LIMO-4116
  Scenario: [Admin][Filter] Status keyword enable
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin click on filter "terminated"
    And admin click on search button
    Then admin see list status mamiprime "terminated"

  @TEST_LIMO-4112
  Scenario: [Admin][Add keyword] Admin add keyword on listing
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin click on filter "active"
    And admin click on search button
    And admin search kost by name "Kos XDR Rajeg Tangerang"
    And admin click on show keyword button
    And admin click on add keyword button
    And admin search area "Tangerang"
    And admin click on search button
    And admin click on add button
    Then admin can see message "Success!"

  @TEST_LIMO-4113
  Scenario: [Admin][Add keyword] Delete area prime suggestion
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin click on filter "active"
    And admin click on search button
    And admin search kost by name "Kos XDR Rajeg Tangerang"
    And admin click on show keyword button
    And Admin click on delete
    Then admin can see message "Success!"

  @TEST_LIMO-4111
  Scenario: [Admin][Add listing] Terminated prime suggestion (listing level)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin click on filter "active"
    And admin click on search button
    And admin search kost by name "Kos XDR Rajeg Tangerang"
    And admin click on edit prime suggestion
    And admin choose status "Terminated"
    And admin click on save prime suggestion
    Then admin can see message "Success!"
    And admin click on filter "inactive"
    And admin click on search button
    And admin search kost by name "Kos XDR Rajeg Tangerang"
    And admin click on edit prime suggestion
    And admin choose status "Terminated"
    And admin click on save prime suggestion
    Then admin can see message "Success!"

