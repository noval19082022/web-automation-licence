@SS10
Feature: Inquiry and Create Manual Payout

  @TEST_SS-2936 @Automated @web-covered @continue
  Scenario: [Mamipay][Manual Payout] Search invoice on manual payout menu
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to search invoice number in manual payout menu "79370282/2021/04/0037"
    Then admin will see the search result in manual payout menu is "79370282/2021/04/0037"

  @TEST_SS-2937 @Automated @web-covered @continue
  Scenario: [Mamipay][Manual Payout] Search payout list by account name
    Given admin go to mamikos mamipay admin
    And admin want to search account name in manual payout menu "tytyty"
    Then admin will see the search result in manual payout menu is "tytyty"

  @TEST_SS-2938 @Automated @web-covered @continue
  Scenario Outline: [Mamipay][Manual Payout] Filter payout list by type <type>
    Given admin go to mamikos mamipay admin
    And admin want to search invoice in manual payout menu with select type "<type>"
    Then admin will see the search result in manual payout menu is "<type>"
    Examples:
      | type                   |
      | Disbursement           |
      | Refund                 |
      | Refund Outside MamiPAY |

  @TEST_SS-2939 @TEST_SS-2935 @Automated @web-covered @continue
  Scenario Outline: [Mamipay][Manual Payout] Filter payout list by status <status>
    Given admin go to mamikos mamipay admin
    And admin want to search invoice in manual payout menu with select status "<status>"
    Then admin will see the search result in manual payout menu is "<status>"
    Examples:
      | status      |
      | Transferred |
      | Processing  |
      | Failed      |

  @TEST_SS-2940 @Automated @web-covered @continue
  Scenario: [Mamipay][Manual Payout]Search based on create date
    Given admin go to mamikos mamipay admin
    And admin want to search invoice in manual payout menu with start date from "2022-04-12" to "2022-04-12"
    Then admin verify transaction based on create date from "2022-04-12 15:26:30" to "2022-04-12 11:45:22"

  @TEST_SS-2941 @Automated @web-covered
  Scenario: [Mamipay][Manual Payout]Create payout without input mandatory data
    Given admin go to mamikos mamipay admin
    And admin want to create payout without input the mandatory data
    Then admin see warning cannot input payout data

  @TEST_SS-2943 @Automated @web-covered @continue
  Scenario: [Mamipay][Manual Payout]Create payout with amount less than 10000
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag              | email prod              | password  |
      | uncle.coop2@mamikos.com | uncle.coop2@mamikos.com | qwerty123 |
    And admin want to create payout with amount less than 10000
    Then admin see warning minimal amount

  @TEST_SS-2944 @Automated @web-covered @continue
  Scenario: [Mamipay][Manual Payout] Create manual payout with <type> type
    Given admin go to mamikos mamipay admin
    And admin want to create payout with type "Disbursement"
    Then admin see payout ready to processed message
    And admin want to create payout with type "Deposit Return"
    Then admin see payout ready to processed message
    And admin want to create payout with type "Refund"
    Then admin see payout ready to processed message
    And admin want to create payout with type "Refund Outside MamiPAY"
    Then admin see payout ready to processed message
    And admin want to create payout with type "Refund Charging"
    Then admin see payout ready to processed message
    And admin want to create payout with type "Payout to Tenant"
    Then admin see payout ready to processed message
    And admin want to create payout with type "Additional Payout to Owner"
    Then admin see payout ready to processed message
    And admin cancel payout transaction
    And admin see payout canceled message

  @TEST_SS-2942 @Automated @web-covered
  Scenario: [Mamipay][Manual Payout]Create payout with invoice still not allow transfer
    Given admin go to mamikos mamipay admin
    And admin want to create invalid payout data
    Then admin see warning not allowed input payout data

  @TEST_SS-2946 @Automated @web-covered @createAndChangeManualPayout @continue
  Scenario: [Mamipay][Manual Payout] Change invoice number
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag              | email prod              | password  |
      | uncle.coop1@mamikos.com | uncle.coop1@mamikos.com | qwerty123 |
    And admin want to change invoice number into "18806898/2021/07/0002"
    Then admin see payout data successfully updated message

  @TEST_SS-2947 @Automated @web-covered @createAndChangeManualPayout @continue
  Scenario: [Mamipay][Manual Payout] Change bank name, account, amount, and reason
    Given admin go to mamikos mamipay admin
    And admin want to create payout with type "Payout to Tenant"
    Then admin see payout ready to processed message
    And admin want to edit bank name, account, amount, and reason payout
    Then admin see payout ready to processed message

  @TEST_SS-2948 @Automated @web-covered@createAndChangeManualPayout
  Scenario: [Mamipay][Manual Payout] Click transfer on payout transaction
    Given admin go to mamikos mamipay admin
    And admin want to transfer on manual payout menu
    Then admin see processing payout message