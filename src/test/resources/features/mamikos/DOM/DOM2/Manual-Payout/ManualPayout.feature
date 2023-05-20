Feature: Inquiry and Create Manual Payout

  @TEST_DOM-428 @Automated @web-covered
  Scenario: [Mamipay][Manual Payout] Search invoice on manual payout menu
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to search invoice number in manual payout menu "79370282/2021/04/0037"
    Then admin will see the search result in manual payout menu is "79370282/2021/04/0037"

  @TEST_DOM-511 @Automated @web-covered
  Scenario: [Mamipay][Manual Payout] Search payout list by account name
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to search account name in manual payout menu "tytyty"
    Then admin will see the search result in manual payout menu is "tytyty"

  @TEST_DOM-507 @Automated @web-covered
  Scenario Outline: [Mamipay][Manual Payout] Filter payout list by type
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to search invoice with select type "<type>"
    Then admin will see the search result in manual payout menu is "<type>"
    Examples:
    | type                   |
    | Disbursement           |
    | Refund                 |
    | Refund Outside MamiPAY |

  @TEST_DOM-497 @Automated @web-covered
  Scenario Outline: [Mamipay][Manual Payout] Filter payout list by status
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to search invoice with select status "<status>"
    Then admin will see the search result in manual payout menu is "<status>"
    Examples:
      | status      |
      | Transferred |
      | Processing  |
      | Failed      |