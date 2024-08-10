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
  Scenario: [GP Voucher Admin][Single Voucher]User click Update Tooltip
    And admin go back to previous page
    When admin want to see update page for index "1"
    Then admin redirected to Update page

  @TEST_LIMO-230 @SingleVoucherList
  Scenario: [GP Voucher Admin][Single Voucher]User add Single Voucher with redeem mamipoint is true and invalid csv
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And Admin go to Single Voucher List Owner
    And Admin want to create single voucher owner
    And Admin select Goldplus on product field create single voucher
    And Admin fill all required campaign field on create single voucher
      | Campaign Name | Start Date | End Date |
      | hehehe        | today      | tomorrow |
    And Admin fill all required voucher field on create single voucher
      | Voucher PrefixCode | Total Voucher | Discount Type | Discount Amount | Upload Owner List | Invoice Type | Double Redeem With MamiPoin |
      | heheheeh           | 1             | fix           | 6666666         | invalid           | recurring    | yes                         |
    And Admin click Create Voucher Single list button
    Then admin will see that the text "Invalid targeted users csv file format" is displayed
    Then admin will see that the text "Total targeted users must equal with total vouchers" is displayed

  @TEST_LIMO-229 @SingleVoucherList
  Scenario: [GP Voucher Admin][Single Voucher]User add Single Voucher with redeem mamipoint is false and invalid csv
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And Admin go to Single Voucher List Owner
    And Admin want to create single voucher owner
    And Admin select Goldplus on product field create single voucher
    And Admin fill all required campaign field on create single voucher
      | Campaign Name | Start Date | End Date |
      | hehehe        | today      | tomorrow |
    And Admin fill all required voucher field on create single voucher
      | Voucher PrefixCode | Total Voucher | Discount Type | Discount Amount | Upload Owner List | Invoice Type | Double Redeem With MamiPoin |
      | heheheeh           | 1             | fix           | 6666666         | invalid           | recurring    | no                          |
    And Admin click Create Voucher Single list button
    Then admin will see that the text "Invalid targeted users csv file format" is displayed
    Then admin will see that the text "Total targeted users must equal with total vouchers" is displayed

  @TEST_LIMO-228 @SingleVoucherList
  Scenario: [GP Voucher Admin][Single Voucher]User add Single Voucher with invoice type is activation and invalid csv
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And Admin go to Single Voucher List Owner
    And Admin want to create single voucher owner
    And Admin select Goldplus on product field create single voucher
    And Admin fill all required campaign field on create single voucher
      | Campaign Name | Start Date | End Date |
      | hehehe        | today      | tomorrow |
    And Admin fill all required voucher field on create single voucher
      | Voucher PrefixCode | Total Voucher | Discount Type | Discount Amount | Upload Owner List | Invoice Type | Double Redeem With MamiPoin |
      | heheheeh           | 1             | fix           | 6666666         | invalid           | activation   | yes                         |
    And Admin click Create Voucher Single list button
    Then admin will see that the text "Invalid targeted users csv file format" is displayed
    Then admin will see that the text "Total targeted users must equal with total vouchers" is displayed