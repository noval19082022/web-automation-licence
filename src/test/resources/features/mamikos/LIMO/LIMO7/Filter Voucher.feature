@LIMO7
Feature: Filter Voucher

  Background: Open voucher menu
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to mamikos voucher menu

  @TEST_SS-4269
  Scenario Outline: Filter Mass Voucher - Status
    And admin click on dropdown filter status
    Then admin see "<filter>" filter list option on voucher menu:
    When admin choose to filter "<filter>" and click search button:
    Then admin see voucher with selected filter "<filter>" is displayed:
    Examples:
      | filter     |
      | All        |
      | Active     |
      | Not Active |

  Scenario Outline: Filter Mass Voucher - Rule
    And admin click on dropdown filter rules
    Then admin see "<filter>" filter list option on voucher menu:
    When admin choose to filter "<filter>" and click search button:
    Then admin see voucher with selected filter "<filter>" is displayed:
    Examples:
      | filter         |
      | All            |
      | For First Paid |
      | For DP         |
      | Recurring      |
      | Pelunasan      |

  Scenario Outline: Filter Mass Voucher - Team
    And admin click on dropdown filter team
    Then admin see "<filter>" filter list option on voucher menu:
    When admin choose to filter "<filter>" and click search button:
    Then admin see voucher with selected filter "<filter>" is displayed:
    Examples:
      | filter    |
      | All       |
      | Business  |
      | HR        |
      | Marketing |
      | Other     |

  Scenario Outline: Filter Mass Voucher - Voucher ID / Code / Campaign Name Filter
    And admin input voucher with value "<ID>" and click search button:
    Then admin see voucher with selected filter "<ID>" is displayed:
    And admin input voucher with value "<voucherCode>" and click search button:
    Then admin see voucher with selected filter "<voucherCode>" is displayed:
    And admin input voucher with value "<campaignName>" and click search button:
    Then admin see voucher with selected filter "<campaignName>" is displayed:
    Examples:
      | ID    | voucherCode  | campaignName                     |
      | 81750 | BBMLHFA      | bbm-test-mass-voucher-automation |
      | 80521 | VANONPREMIUM | playwrightAutomation             |
      | 81165 | TESTARIF     | testcampaign                     |

