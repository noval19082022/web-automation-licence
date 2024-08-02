@regression @LIMO1 @DONEMIGRATINGTONEWBOARD
Feature: Single voucher owner

  @TEST_LIMO-3290 @continue @SingleVoucherList
  Scenario: [GP Voucher Admin][Single Voucher]User click Voucher List Tooltip
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When admin want to see Single Voucher List owner for index "1"
    Then admin redirected to Single Voucher List owner
    When admin want to see View Usage List owner for index "1"
    Then admin redirected to View Usage page
    And admin go back to previous page

  @TEST_LIMO-232 @continue @SingleVoucherList
  Scenario: [GP Voucher Admin][Single Voucher]User click History Tooltip
    Given admin go to mamikos mamipay admin
    And Admin go to Single Voucher List Owner
    When admin want to see Voucher History page for index "1"
    Then admin verify see text "Voucher Code List"

  @TEST_LIMO-231 @SingleVoucherList
  Scenario: [GP Voucher Admin][Single Voucher]User click History Tooltip
    And admin go back to previous page
    When admin want to see update page for index "1"
    Then admin redirected to Update page
