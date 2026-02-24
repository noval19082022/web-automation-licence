@SS14 @EventBanner
Feature: [Test-Execution][DOM] Web - Event Banner

  @TEST_SS-3020 @Automated @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner redirection
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787342 | Perempuan123 |
    And owner go to event banner section
    And owner click on banner on dari mamikos section
    Then user redirected to URL "https://docs.google.com/forms/d/e/1FAIpQLSdGrn3lbLwSWxdb4tJ1hVJI7qi0nYW77sVXB0YsMXaA4tORKA/"

  @TEST_SS-3021 @Automated @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner check content
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787342 | Perempuan123 |
    And owner go to event banner section
    Then user will see that the text "Dari Mamikos" is displayed

  @TEST_SS-3025 @TESTSET_UG-6249 @TESTSET_PF-1400 @TESTSET_PF-1956 @Automated @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner same order priority
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/event"
    And admin bangkerupux set event banner "1" to order "1"
    And admin bangkerupux updated the event banner
    Then user will see that the text "Success! Event Updated" is displayed
    And admin bangkerupux set event banner "2" to order "1"
    And admin bangkerupux updated the event banner
    Then user will see that the text "Success! Event Updated" is displayed

  @TEST_SS-3026 @TESTSET_UG-6249 @TESTSET_PF-1400 @TESTSET_PF-1956 @Automated @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner different order priority
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/event"
    And admin bangkerupux set event banner "1" to order "8"
    And admin bangkerupux updated the event banner
    Then user will see that the text "Success! Event Updated" is displayed
    And admin bangkerupux set event banner "2" to order "9"
    And admin bangkerupux updated the event banner
    Then user will see that the text "Success! Event Updated" is displayed