@LIMO2 @adminGp @regression

Feature: Admin goldplus package

  @TEST_LIMO-2186 @continue
  Scenario: [Admin][Edit GP Package] User want to Edit GP Package at Bangkerupux with Invalid Value
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    And admin navigate to goldplus package edit form
    And admin edit the price to 110000
    Then admin submit and get warning "Markup Price must greather than or equal to price"

  @TEST_LIMO-2185
  Scenario: [Admin][Edit GP Package] User want to Edit GP Package at Bangkerupux with Valid Value
    And admin edit the price to 79000
    Then admin submit and get success message "Success! GoldPlus package updated."
    
