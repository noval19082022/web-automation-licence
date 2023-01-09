Feature: Login Owner

  @user @saktiloginowner
  Scenario: Login Owner Success
    Given user go to mamikos homepage
    When user logins as owner
    Then user can sees owner's page