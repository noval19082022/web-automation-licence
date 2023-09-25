@BBM4 @filtervouchercheck
Feature: Filter Voucher

  @TEST_BBM-841 @TEST_BBM-843 @continue
  Scenario: Login Admin For Filter Mass Voucher - Status
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |

  @TEST_BBM-841 @TEST_BBM-843 @continue
  Scenario Outline: Filter Mass Voucher - Status
    Given admin go to mamikos mamipay admin
    When admin navigate to mamikos voucher menu
    And admin click on dropdown filter status
    Then admin see "<filter>" filter list option on voucher menu:
    When admin choose to filter "<filter>" and click search button:
    Then admin see voucher with selected filter "<filter>" is displayed:
    Examples:
      | filter |
      | All    |
      | Active |
      | Not Active |

  @TEST_BBM-839 @continue
  Scenario Outline: Filter Mass Voucher - Rule
    Given admin go to mamikos mamipay admin
    When admin navigate to mamikos voucher menu
    And admin click on dropdown filter rules
    Then admin see "<filter>" filter list option on voucher menu:
    When admin choose to filter "<filter>" and click search button:
    Then admin see voucher with selected filter "<filter>" is displayed:
    Examples:
      | filter |
      | All |
      | For First Paid |
      | For DP |
      | Recurring |
      | Pelunasan |

  @TEST_BBM-840 @continue
  Scenario Outline: Filter Mass Voucher - Team
    Given admin go to mamikos mamipay admin
    When admin navigate to mamikos voucher menu
    And admin click on dropdown filter team
    Then admin see "<filter>" filter list option on voucher menu:
    When admin choose to filter "<filter>" and click search button:
    Then admin see voucher with selected filter "<filter>" is displayed:
    Examples:
      | filter |
      | All |
      | Business |
      | HR |
      | Marketing |
      | Other |

  @TEST_BBM-829 @TEST_BBM-831
  Scenario Outline: Filter Mass Voucher - Voucher ID / Code / Campaign Name Filter
    Given admin go to mamikos mamipay admin
    When admin navigate to mamikos voucher menu
    And admin input voucher with value "<ID>" and click search button:
    Then admin see voucher with selected filter "<ID>" is displayed:
    And admin input voucher with value "<voucherCode>" and click search button:
    Then admin see voucher with selected filter "<voucherCode>" is displayed:
    And admin input voucher with value "<campaignName>" and click search button:
    Then admin see voucher with selected filter "<campaignName>" is displayed:
    Examples:
      | ID    | voucherCode    | campaignName    |
      | 81750 | BBMLHFA | bbm-test-mass-voucher-automation |
      | 80521 | VANONPREMIUM | playwrightAutomation |
      | 81165 | TESTARIF | testcampaign |