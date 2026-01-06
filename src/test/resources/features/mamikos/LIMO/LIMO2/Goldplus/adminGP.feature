@LIMO2 @adminGp @regression @DONEMIGRATINGTONEWBOARD

Feature: Admin goldplus package

  @TEST_LIMO-3389 @continue
  Scenario: [Admin][Edit GP Package] User want to Edit GP Package at Bangkerupux with Invalid Value
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    And admin navigate to goldplus package edit form
    And admin edit the price to 110000
    Then admin submit and get warning "Markup Price must greather than or equal to price"

  @TEST_LIMO-3390
  Scenario: [Admin][Edit GP Package] User want to Edit GP Package at Bangkerupux with Valid Value
    And admin edit the price to 79000
    Then admin submit and get success message "Success! GoldPlus package updated."

  @TEST_LIMO-9113 @premium-package-bonus
  Scenario: [Admin][Add GP Package] User check New Field Premium Package (bonus) on Add Package Form
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    When user click on add package button
    Then user check New Field "Premium Package (bonus)"

  @TEST_LIMO-9114 @bundled-premium-package
  Scenario: [Admin][Add GP Package] User select Bundled Premium Package on Add Package Form
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    When user click on add package button
    And user click on dropdown Bundled Premium Package
    Then user see package Bundled Premium:
      | Paket Bundle 5k  |
      | Paket Bundle 8k  |
      | Paket Bundle 10k |
      | Paket Bundle 15k |
    And user select package "Paket Bundle 5k"
    Then Bundle package has been successfully selected

  @TEST_LIMO-9115 @bundled-premium-package-edit
  Scenario: [Admin][Edit GP Package] User change Bundled Premium Package on Edit Package Form
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    When user search ID "3"
    And user click on edit button
    And user click on dropdown Bundled Premium Package
    And user change and select package "Paket Bundle 10k"
    Then Bundle package has been successfully selected

