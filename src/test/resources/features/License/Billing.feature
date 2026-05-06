@billing
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
#      |Code                  |Name                              |Currency  |Description     |
#      |IDR-{{timestamp}}     |Invoice Testing {{timestamp}}     |IDR       |IDR 1.000.000   |
#    And the user click on save button
    And the user select price list code "IDR-20260506162449"
    And the user clicks on add items
    And the user clicks on add item
    And the user fill data:
      |Charge Type |Reference  |Billing Cycle  |Amount    | Initial Amount  |
      |Module      |Sales      |MONTHLY        |1.000.000 | 500.000         |
    And the user click on save button

  @TEST_LICENSE_BILLING_MASTER_SUBSCRIPTIONS_ADD_PRESET
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
      |PT.Super Smart TBK   |Invoice Testing  |Invoice Testing 20260506162449 |MONTHLY        | Active | 2026-04-24 | 2026-04-24 |

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
      |PT.Super Smart TBK  |Sales            |IDR-20260506162449 | PLAN   |
    And the user click on save button

