@regression @LIMO5 @GPNoval
Feature: Prime suggestion

@TEST_LIMO-4080
  Scenario: [Admin][Edit GP Package] User want to Edit GP Package at Bangkerupux with Invalid Value
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
    And admin click on preview button
    And admin choose status "Active"
    And admin click on create button
    Then admin can see message "An active contract already exists for this room type."

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
    And admin click on preview button
    And admin choose status "Inactive"
    And admin click on create button
    Then admin can see message "Success!"

  @TEST_LIMO-4111
  Scenario: [Admin][Add listing] Inactive prime suggestion (listing level)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to admin prime suggestion
    And admin search kost by name "Kos XDR Rajeg Tangerang"
    And admin click on edit prime suggestion
    And admin choose status "Terminated"
    And admin click on save prime suggestion
    Then admin can see message "Success!"
