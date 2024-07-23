@regression @LIMO1 @DONEMIGRATINGTONEWBOARD
Feature: Single voucher owner

  @TEST_LIMO-3290
  Scenario: [GP Voucher Admin][Single Voucher]User click Voucher List Tooltip
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When admin want to see Single Voucher List owner for index "1"
    Then admin redirected to Single Voucher List owner
    When admin want to see View Usage List owner for index "1"
    Then admin redirected to View Usage page
    When admin want to see update page for index "1"
    Then admin redirected to Update page