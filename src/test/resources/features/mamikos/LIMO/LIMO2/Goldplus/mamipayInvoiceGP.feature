@GPinvoiceList @invoice @listing-monetization @regression @LIMO2 @TEST_LIMO-1338
Feature: [WEB][Mamipay][GP Invoice List] Check search function GP Invoice

  @Automated @GP-Invoice-List @MamiPay @Web @essential-limo @listing-monetization @search-GP-Invoice @continue
  Scenario: Search Invoice Goldplus based on Invoice Number
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice Goldplus based on "Invoice Number" and value "GP2/20210623/00003949/2149"
    Then user will see that the text "GP2/20210623/00003949/2149" is displayed

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Invalid Invoice Number
    When admin search invoice Goldplus based on "Invoice Number" and value "GP2/20210225/00002146/83121111"
    Then admin will get empty table list data

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Owner Phone Number
    When admin search invoice Goldplus based on "Owner Phone Number" and value "0833000008"
    Then user will see that the text "0833000008" is displayed

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Invalid Owner Phone Number
    When admin search invoice Goldplus based on "Owner Phone Number" and value "08330000811"
    Then admin will get empty table list data

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Invoice Code
    When admin search invoice Goldplus based on "Invoice Code" and value "13837"
    Then user will see that the text "13837" is displayed

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Invalid Invoice Code
    When admin search invoice Goldplus based on "Invoice Code" and value "1383711"
    Then admin will get empty table list data

  @continue @search-GP-Invoice
  Scenario: Reset Search Detail
    When admin click button reset
    Then user will see that the text "Pembayaran GoldPlus" is displayed

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Status Transaction Unpaid
    When admin search invoice Goldplus based on Status and value "Unpaid"
    Then user will see that the text "Unpaid" is displayed on the table

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Status Transaction Paid
    When admin search invoice Goldplus based on Status and value "Paid"
    Then user will see that the text "Paid" is displayed on the table

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Status Transaction Expired
    When admin search invoice Goldplus based on Status and value "Expired"
    Then user will see that the text "Expired" is displayed on the table

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Package Goldplus 1
    When admin search invoice Goldplus based on Package and value "gp1"
    Then user will see that the text "GP1" is displayed

  @continue @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on Package Goldplus 2
    When admin search invoice Goldplus based on Package and value "gp2"
    Then user will see that the text "GP2" is displayed

  @search-GP-Invoice
  Scenario: Search Invoice Goldplus based on date
    When user click "Goldplus Invoice List"
    And admin choose date picker "2021-07-16" and "2021-07-17"
    Then user will see that the text "2021-07-16" is displayed