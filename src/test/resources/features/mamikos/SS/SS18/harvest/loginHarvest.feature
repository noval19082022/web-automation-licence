@regression @SS16 @SS1-prod @harvest @essentialTest2

Feature: Login Harvest

  @TEST_SS-982
  Scenario: Login using valid account
    When admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    Then admin should redirect to Harvest Dashboard

  @TEST_SS-983
  Scenario: Login using invalid account
    When admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email                        | password       |
      | automationpman10@mamikos.com | pmanM4m1t34m!! |
    Then admin stay in login harvest page
    And show login harvest error message "Terjadi kesalahan, silakan coba lagi."

  @TEST_SS-980
  Scenario: Login validation
      #empty
    When admin navigates to Harvest Dashboard Login
    Then login button is disabled
      #wrong username
    And admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman99@mamikos.com | qwerty123 |
    Then admin stay in login harvest page
    And show login harvest error message "Terjadi kesalahan, silakan coba lagi."
      #wrong password
    And admin login Harvest Dashboard:
      | email                        | password |
      | automationpman01@mamikos.com | asdf123  |
    Then admin stay in login harvest page
    And show login harvest error message "Terjadi kesalahan, silakan coba lagi."

  @TEST_SS-981
  Scenario: Logout
    When admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    And admin logout harvest
    Then admin redirect to login harvest page
    When admin navigates to Harvest Dashboard
    Then admin stay in login harvest page