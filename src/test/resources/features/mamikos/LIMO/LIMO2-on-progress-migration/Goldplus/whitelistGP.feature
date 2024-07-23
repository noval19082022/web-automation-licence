@LIMO2
Feature: Whitelist feature for Goldplus Owner

  @TEST_LIMO-3906
  Scenario: [WEB][Admin]As a admin, I want to be able to set the owner who will get GP weekly package options in Bangkerupux with invalid value
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                     | email prod | password  |
      | uncle.limo2@admin-mamiteam.com |            | qwerty123 |
    And admin accsess menu whitelist feature
    #filled with emphty
    When admin wants to add whitelist feature
    And admin click submit button
    Then admin can see message "The feature name field is required."
    And admin can see message "The user id field is required."

   #filled with feature is emphty
    When admin input owner id with "99452080"
    And admin click submit button
    Then admin can see message "The feature name field is required."

    #filled with char
    When admin select feature with "goldplus_weekly_package"
    * admin input owner id with "abcdhed"
    * admin click submit button
    Then admin can see message "The user id must be an integer."

     #filled with invalid user id
    When admin select feature with "goldplus_weekly_package"
    * admin input owner id with "99098980"
    * admin click submit button
    Then admin can see message "The selected user id is invalid."