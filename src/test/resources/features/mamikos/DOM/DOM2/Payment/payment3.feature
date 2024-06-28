@DOM2 @BackofficeStagging3
Feature: Payment Backoffice Staging 3 - Add on List & Payment Premium

  @TEST_COOP-5573 @Automated @web-covered
  Scenario Outline: [BackOffice][Invoice Security] Open Invoice Expired Booking from All invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag | email prod | password  |
      | <email>    | <email>    | qwerty123 |
    And admin open menu all invoice list
    And admin bangkerupux want to search invoice by "Invoice Number" and input field "<invoice>"
    Then admin bangkerupux click on shorlink invoice on invoice list "<shortlink>"
    Examples:
      | email                   | invoice                  | shortlink                                                                                                                             |
      | uncle.coop2@mamikos.com | PRE/20220221/50864/80817 | https://pay-jambu.kerupux.com/invoice/select-payment/48611?signature=bab937d125dd83f785beaf0e53fe3405a0aea1aad95f4f8183f3b7c586c38c54 |
      | uncle.coop2@mamikos.com | DP/19024270/2022/02/0185 | https://pay-jambu.kerupux.com/invoice/select-payment/48731?signature=995fe6af375ef93d58afcafa5b34a96766644988aa6e02f67262b12229aaf434 |
      | uncle.coop2@mamikos.com | 44331680/2022/03/0017    | https://pay-jambu.kerupux.com/invoice/select-payment/46750?signature=081102610d26b3bdcaffc1ecd5ad29e277f179b2b6b9978878aab219183a5ff6 |

  @TEST_COOP-5554 @Automated @web-covered
  Scenario: [BackOffice][Property Level] Create Property Level
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to property management menu
    And admin bangkerupux search property name "payment squad 1" on property management menu
    Then admin verify see text "payment squad 1"

  @TEST_COOP-5555 @Automated @web-covered @continue
  Scenario: [BackOffice][Discount Admin Fee] Discount admin fee recuring booking
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to Search Invoice menu
    And user search by "Renter Phone Number" and input field "089220220201"
    And user click on detail fee button
    Then admin verify see text "GP2 Staging"

  @TEST_COOP-5556 @Automated @web-covered @continue
  Scenario: [BackOffice][Add Ons List] Create add ons without fill mandatory fields
    Given admin go to mamikos mamipay admin
    And admin go to "Add Ons List" menu
    And admin bangkerupux create add ons on add ons list menu
    And admin bangkerupux input name "", description "", price "", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: Create add ons without fill add ons name and price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "", description "description", price "", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: create add ons without fill add ons name and description
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "", description "description", price "5000", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "tester", description "", price "5000", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "", description "", price "5000", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

    #  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "tester", description "", price "", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"
#  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "", description "des", price "", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "tester", description "tester", price "5000", notes "test" and create it
    Then admin verify see text "success created new add ons."
    And admin bangkerupux delete add ons that has name "tester"

  @TEST_COOP-5557 @Automated @web-covered @continue
  Scenario: [BackOffice][Add Ons List] Click button delete on add ons menu
    Given admin go to mamikos mamipay admin
    And admin go to "Add Ons List" menu
    And admin bangkerupux create add ons on add ons list menu
    And admin bangkerupux input name "delete", description "delete", price "9999", notes "test" and create it
    And admin bangkerupux delete add ons that has name "delete"
    Then admin verify see text "Deleted."

  @TEST_COOP-5558 @Automated @web-covered @continue
  Scenario: [BackOffice][Add Ons List] visit form edit add ons
    Given admin go to mamikos mamipay admin
    And admin go to "Add Ons List" menu

    ## create add ons for testing purpose
    And admin bangkerupux create add ons on add ons list menu
    And admin bangkerupux input name "edit add ons", description "edit", price "9999", notes "test" and create it

    #  Scenario: Positive case Edit add ons Name
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux input name "edit add ons nama", description "edit", price "9999", notes "test" and update it
    Then admin verify see text "success updated new add ons."

    #  Scenario: Positive case Edit add ons description
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux input name "edit add ons nama", description "edit description", price "9999", notes "test" and update it
    Then admin verify see text "success updated new add ons."

    #  Scenario: Positive case Edit add ons price
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux input name "edit add ons nama", description "edit description", price "5000", notes "test" and update it
    Then admin verify see text "success updated new add ons."

    #  Scenario: Positive case Edit add ons notes
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux input name "edit add ons nama", description "edit description", price "5000", notes "edit notes" and update it
    Then admin verify see text "success updated new add ons."

    #  Scenario: Positive case Click button cancel on edit page
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux cancel edit add ons
    Then admin verify see text "Add Ons List"

    #  Scenario: Positive case Click button cancel on pop up edit
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux cancel edit add ons pop up
    Then admin verify see text "Edit Add On"

    ## Delete add ons after test
    And admin go to "Add Ons List" menu
    And admin bangkerupux delete add ons that has name "edit add ons"
    Then admin verify see text "Deleted."

  @TEST_COOP-5559 @Automated @web-covered @continue
  Scenario: [BackOffice][Discount Admin Fee] Admin edit invoice discount
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to discount admin fee discount menu
    And admin bangkrupux want to edit discount admin fee
    And admin bangkrupux input amount "999" for discount admin fee
    And admin bangkrupux save after input field on edit discount admin fee
    Then admin verify see text "Success."

  @TEST_COOP-5560 @Automated @web-covered @continue
  Scenario: [BackOffice][Discount Admin Fee] Admin delete invoice discount
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to discount admin fee discount menu
    And admin bangkerupux create admin fee discount with name discount "hapus langsung" amount "999"
    And admin bangkerupux want to delete admin fee discount that has name "hapus langsung"
    Then admin verify see text "Success."

  @TEST_COOP-5561 @Automated @web-covered @continue
  Scenario: [BackOffice][Discount Admin Fee] Admin create invoice discount
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to discount admin fee discount menu
    And admin bangkerupux create admin fee discount with name discount "create invoice discount hapus langsung" amount "999"
    And admin bangkerupux want to delete admin fee discount that has name "create invoice discount hapus langsung"
    Then admin verify see text "Success."

  @TEST_COOP-5572 @Automated @web-covered @continue
  Scenario Outline: [BackOffice][Invoice Security] Open invoice Paid froms list GP
    Given admin go to mamikos mamipay admin
    And admin go to "GoldPlus Invoice List" menu
    And admin bangkerupux want to search invoice by "Invoice Number" and input field "<invoice>"
    Then admin bangkerupux click on shorlink invoice on invoice list "<shortlink>"
    Examples:
      | invoice                    | shortlink                                                                                                                             |
      | GP2/20220217/00005909/3769 | https://pay-jambu.kerupux.com/invoice/select-payment/48481?signature=83511d18f0cb74ebd3c45c6d1ae0c3904672603da4a699ee9b5fb3a945352323 |


  @TEST_COOP-5562 @Automated @web-covered @continue
  Scenario: [Owner][Payment premium] Filter valid owner number premium
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Owner Phone Number" and input field "08119787884"
    Then admin verify see text "Desta"

  @TEST_COOP-5563 @Automated @web-covered @continue
  Scenario: [Owner][Payment premium] Filter invalid owner number premium
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Owner Phone Number" and input field "0811978499"
    Then admin bangkerupux get blank data list on package invoice list

  @TEST_COOP-5564 @Automated @web-covered
  Scenario: [Owner][Payment premium] Admin search expired invoice number
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux filter the status of package invoice list premium for "expired" transaction
    Then admin bangkerupux see transaction status list on package invoice list is only "expired"

  @TEST_COOP-5565 @Automated @web-covered
  Scenario: [Owner][Payment premium] Owner paid premium paket
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp6.000"
    And payment owner success using ovo as payment method

    #  Scenario: Admin check the transaction on Menu Premium Package status paid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Owner Phone Number" and input field "08123450977"
    Then admin verify see text "paid"

  @TEST_COOP-5566 @Automated @web-covered @continue
  Scenario: [Owner][Payment premium] Filter valid premium package invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "PRE/20230811/56545/34420"
    Then admin verify see text "PRE/20230811/56545/34420"

  @TEST_COOP-5567 @Automated @web-covered @continue
  Scenario: [Owner][Payment premium] Filter by status unpaid
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux filter the status of package invoice list premium for "unpaid" transaction
    Then admin bangkerupux see transaction status list on package invoice list is only "unpaid"

  @TEST_COOP-5568 @Automated @web-covered
  Scenario: [Owner][Payment premium] Filter Invalid premium package invoice use GP Invoice
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "GP3/20210623/00003930/7590"
    Then admin bangkerupux get blank data list on package invoice list

  @TEST_COOP-5569 @Automated @web-covered
  Scenario: [Owner][Payment premium] Owner unpaid premium paket
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp205.000"

    #  Scenario: Admin check the transaction on Menu Premium Package status unpaid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Owner Phone Number" and input field "08123450977"
    Then admin bangkerupux see transaction status on package invoice list is "unpaid"

  @TEST_COOP-5570 @Automated @web-covered @continue
  Scenario: [Owner][Payment premium] Filter invalid premium package invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "PRE/20000811/56545/34420"
    Then admin bangkerupux get blank data list on package invoice list

  @TEST_COOP-5574 @Automated @web-covered @continue
  Scenario: [BackOffice][Invoice Security] Open Invoice paid from list premium
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "PRE/20230814/56591/16250"
    Then admin verify see text "paid"
    *    admin bangkerupux click on shorlink invoice on invoice list "https://pay-jambu.kerupux.com/invoice/select-payment/97876?signature=38fcc2e07bfe0cc42dd67e018622e9076333811666c5189d5f6ae9c572c27783"

  @TEST_COOP-5575 @Automated @web-covered @continue
  Scenario: BackOffice][Invoice Security] Open invoice unpaid from list premium
    Given admin go to mamikos mamipay admin
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "PRE/20230814/56592/78363"
    Then admin bangkerupux click on shorlink invoice on invoice list "https://pay-jambu.kerupux.com/invoice/select-payment/97907?signature=31cf780c263edeecee662927b00e6ecbab8119c90be8f3272d5e61fa42063a03"

  @TEST_COOP-5576 @Automated @web-covered @continue
  Scenario Outline: [BackOffice][Invoice Security] Open invoice unpaid froms list GP
    Given admin go to mamikos mamipay admin
    And admin mamipay go to goldplus invoice list menu
    And admin bangkerupux want to search invoice by "Invoice Number" and input field "<invoice>"
    Then admin bangkerupux click on shorlink invoice on invoice list "<shortlink>"
    Examples:
      | invoice                    | shortlink                                                                                                                              |
      | GP1/20231027/00013487/9781 | https://pay-jambu.kerupux.com/invoice/select-payment/105542?signature=129b2a3a5865d121d8ffe62b6061a248b6aa1a3a05edc2b8b59fa6a7263a2980 |
      | GP2/20231128/00014167/0327 | https://pay-jambu.kerupux.com/invoice/select-payment/108709?signature=afff013fe01147293721330c179fb70c1b749a6301578b1b4054fd3381bd75fc |

  @TEST_COOP-5579 @Automated @web-covered
  Scenario: [BackOffice][Discount Admin Fee] Recurring booking discount admin fee
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089220220201 | 083176408442 | qwerty123 |
    And user visit page "/user/riwayat-transaksi/65093"
    Then user will see that the text "Tagihan 16 Feb 2022" is displayed
    When user click "Lihat Rincian"
    Then user will see that the text "GP2 Staging" is displayed

  @TEST_COOP-5571 @Automated @web-covered
  Scenario Outline: [BackOffice][Invoice Security] Open Invoice Booking from search invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag | email prod | password  |
      | <email>    | <email>    | qwerty123 |
    And admin go to Search Invoice menu
    And admin bangkerupux want to search invoice by "Invoice Number" and input field "<invoice>"
    Then admin bangkerupux click on shorlink invoice on invoice list "<shortlink>"
    Examples:
      | email                   | invoice               | shortlink                                   |
      | uncle.coop2@mamikos.com | 34716463/2022/02/0009 | https://pay-jambu.kerupux.com/invoice/fTbwj |
      | uncle.coop1@mamikos.com | 12865544/2022/02/0082 | https://pay-jambu.kerupux.com/invoice/lTRwj |
      | uncle.coop2@mamikos.com | 57653153/2022/02/0003 | https://pay-jambu.kerupux.com/invoice/9H9CP |