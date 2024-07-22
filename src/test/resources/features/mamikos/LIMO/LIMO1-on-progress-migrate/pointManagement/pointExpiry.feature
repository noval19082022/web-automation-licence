#@regression @pointExpiry @LIMO1 @LIMO1-staging

Feature: Manage Point Expiry (Already migrate)

#  @TEST_LIMO-86 https://mamiteam-qa3.atlassian.net/browse/LIMO-3311
  Scenario: [Point Management][Expiry]Update Point Expiry
    Given admin go to mamikos bangkrupux admin
    * admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    * admin access point expiry menu
    And user fill Owner Point Expiry in with "5"
    And user fill Tenant Point Expiry in with "10"
    And user click on Point Expiry Save button
    Then user verify allert success "Success!" and "Point Expiry successfully updated."
    And user fill Owner Point Expiry in with "2"
    And user fill Tenant Point Expiry in with "6"
    And user click on Point Expiry Save button
    Then user verify allert success "Success!" and "Point Expiry successfully updated."