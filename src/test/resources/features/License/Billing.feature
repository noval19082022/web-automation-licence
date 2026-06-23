@billing @allTestcase
Feature: Billing

  @TEST_LICENSE_BILLING_USER_PLAN_ADD_PLAN
  Scenario: [WEB][License] Admin navigate to billing and add plan
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the billing menu
    And the user select menu plan
    And the user clicks on add plan menu
    And the user fill data:
      |Code                  |Name                  |Description     |
      |Invoice-{{timestamp}} |Invoice Testing       |Automation      |
    And the user click on save button

  @TEST_LICENSE_BILLING_USER_PRICE_LIST_ADD_PLAN
  Scenario: [WEB][License] Admin navigate to price list and add row
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the billing menu
    And the user select menu price list
#    And the user clicks on add row menu
#    And the user fill data:
#      |Code        |Name                              |Currency  |Description     |
#      |IDR-1234    |Invoice Testing {{timestamp}}     |IDR       |IDR 1.000.000   |
#    And the user click on save button
    And the user select price list code "IDR-1234"
    And the user clicks on add items
    And the user clicks on add item
    And the user fill data:
      |Charge Type |Reference       |Billing Cycle  |Amount    | Initial Amount  |
      |Plan        |Invoice Testing |MONTHLY        |1.000.000 | 500.000         |
    And the user click on save button
    And the user clicks on add item
    And the user fill data:
      |Charge Type |Reference  |Billing Cycle  |Amount    | Initial Amount  |
      |Module      |Sales      |MONTHLY        |0         | 0               |
    And the user click on save button
    And the user clicks on add item
    And the user fill data:
      |Charge Type |Reference             |Billing Cycle  |Amount    | Initial Amount  |
      |Module      |Involvia System Admin |MONTHLY        |0         | 0               |
    And the user click on save button
    And the user clicks on add item
    And the user fill data:
      |Charge Type |Reference   |Billing Cycle  |Amount    | Initial Amount  |
      |Module      |Master Data |MONTHLY        |0         | 0               |
    And the user click on save button
    And the user clicks on add item
    And the user fill data:
      |Charge Type |Reference       |Billing Cycle  |Amount    | Initial Amount  |
      |Module      |Cash Management |MONTHLY        |0         | 0               |
    And the user click on save button
    And the user clicks on add item
    And the user fill data:
      |Charge Type |Reference   |Billing Cycle  |Amount    | Initial Amount  |
      |Module      |Delivery    |MONTHLY        |0         | 0               |
    And the user click on save button
    And the user clicks on add item
    And the user fill data:
      |Charge Type |Reference           |Billing Cycle  |Amount    | Initial Amount  |
      |Module      |Warehouse management|MONTHLY       |0         | 0               |
    And the user click on save button

  @TEST_LICENSE_BILLING_MASTER_SUBSCRIPTIONS_ADD_PRESET_ADD_MODULE
  Scenario: [WEB][License] Admin navigate to master subscriptions module and add prset
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the billing menu
    And the user select menu master subscriptions module
    And the user clicks on add preset menu
    And the user fill data:
      |Code             |Name             |Description                    |
      |AC-{{timestamp}} |Invoice Testing  |Data Testing Jangan Dihapus    |
    And the user click on save button
    And the user click on modules button
    And the user click on add module button
    And the user fill data:
      |Module                |Source  |
      |Involvia System Admin |PLAN    |
    And the user click on save button
    And the user click on modules button
    And the user click on add module button
    And the user fill data:
      |Module                |Source  |
      |Warehouse management  |PLAN    |
    And the user click on save button
    And the user click on modules button
    And the user click on add module button
    And the user fill data:
      |Module                |Source  |
      |Delivery              |PLAN    |
    And the user click on save button
    And the user click on modules button
    And the user click on add module button
    And the user fill data:
      |Module                |Source  |
      |Sales                 |PLAN    |
    And the user click on save button
    And the user click on modules button
    And the user click on add module button
    And the user fill data:
      |Module                |Source  |
      |Cash Management       |PLAN    |
    And the user click on save button
    And the user click on modules button
    And the user click on add module button
    And the user fill data:
      |Module                |Source  |
      |Master Data           |PLAN    |
    And the user click on save button

  @TEST_LICENSE_BILLING_USER_SUBSCRIPTIONS_ADD_SUBSCRIPTIONS
  Scenario: [WEB][License] Admin navigate to Subscriptions and add Subscriptions
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the billing menu
    And the user select menu Subscriptions
    And the user clicks on add Subscriptions menu
    And the user fill data:
      |Organization         |Plan             |Price List                     |Billing Cycle  | Status | Start Date | End Date   |
      |PT.Super Smart TBK   |Invoice Testing  |Invoice Testing 20260506180604 |MONTHLY        | Active | 2026-04-24 | 2026-04-24 |
    And the user click on save button

  @TEST_LICENSE_BILLING_USER_SUBSCRIPTIONS_MODULES_ADD_ROW
  Scenario: [WEB][License] Admin navigate to Subscriptions and add Subscriptions
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the billing menu
    And the user select menu Subscription Modules
    And the user clicks on add row menu
    And the user fill data:
      |Select organization |Module           |Price Item         | Source |
      |PT.Super Smart TBK  |Sales            |IDR-20260506180715 | PLAN   |
    And the user click on save button

  @TEST_LICENSE_BILLING_USER_SUBSCRIPTIONS_MODULES_APPLY_MASTER_RESET
  Scenario: [WEB][License] Admin navigate to Subscriptions and add Subscriptions
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the billing menu
    And the user select menu Subscription Modules
    And the user fill data:
      |Select organization |Subscription       |
      |PT.Super Smart TBK  |PT.Super Smart TBK |
    And the user click on apply master reset button

  @TEST_LICENSE_BILLING_INVOICE
  Scenario: [WEB][License] Admin navigate to billing invoice
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the billing invoice menu
    And the user fill data:
      |Select organization |Subscription           |Due Date   | Tax % | Recipient Email | Catatan               |
      |PT.Super Smart TBK  |PT.Super Smart TBK     |2026-05-9  | 10    | john@gmail.com  | Billing Bapak john    |
    And the user click on terbitkan invoice button
    And the user clck on bayar button
    And the user fill data:
      |Method         |Payment Reference  | Bukti Transfer |
      |BANK_TRANSFER  |BANK MANDIRI       | 100-00000001   |
    And the user clck on simpan pembayaran button


  @TEST_LICENSE_BILLING_PROPOSAL
  Scenario: [WEB][License] Admin navigate to billing proposal
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the proposal penawaran menu
    And the user fill data:
      |Select organization |Subscription           |Due Date   | Tax % | Recipient Email | Catatan               |
      |PT.Super Smart TBK  |PT.Super Smart TBK     |2026-05-9  | 10    | john@gmail.com  | Billing Bapak john    |
    And the user click on terbitkan proposal button

  @TEST_LICENSE_GENERATE_LICENCE
  Scenario: [WEB][License] Admin navigate to generate licence
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on license ops 2
    And the user clicks on the generate license menu
    And the user fill data:
      |Select organization |
      |PT.Super Smart TBK  |
    And the user click on generate activation code button

