@login
Feature: Login Tenant

  @tenant @owner @lari
  Scenario: Login Tenant With Phone Number
#    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    |  phone prod    | password  |
      | 087708777615  |  087708777615  | qwerty123 |
    When user logins as owner

  @owner
  Scenario: Login as owner
    When user logins as owner

#  Scenario: Login Tenant With Phone Number
#    Given user go to mamikos homepage
#    When user login as tenant via facebook
#    Then tenant redirect back to homepage
#
#  Scenario: Login Tenant With Phone Number
#    Given user go to mamikos homepage
#    When user login as tenant via google
#    Then tenant redirect back to homepage