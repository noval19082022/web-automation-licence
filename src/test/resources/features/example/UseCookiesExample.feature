@cookiesexp
Feature: Cookies Example

  Scenario: Login As Tenant And Get Cookies
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08100000618 | 08100000618 | qwerty123 |
    Then user collected browser cookies session

  Scenario: Use Login Cookies
    Given user go to mamikos homepage
    When user use cookies to login