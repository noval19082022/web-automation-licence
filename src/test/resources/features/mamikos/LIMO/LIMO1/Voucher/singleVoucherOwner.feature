@regression @LIMO1

Feature: Single voucher owner

  @TEST_LIMO-1216
  Scenario: admin check redirect menu action at single owner voucher
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When admin want to see Single Voucher List owner for index "1"
    Then admin redirected to Single Voucher List owner
    When admin want to see View Usage List owner for index "1"
    Then admin redirected to View Usage page
    When admin want to see update page for index "1"
    Then admin redirected to Update page