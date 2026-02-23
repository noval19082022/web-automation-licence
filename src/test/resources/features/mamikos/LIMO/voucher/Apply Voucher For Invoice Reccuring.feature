@regression @voucher @LIMO8


Feature: Apply Voucher For Invoice Reccuring

  @continue @TEST_SS-3694
  Scenario: Invoice Reccuring and Voucher For First Full Paid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VTOTALUSAGE       | VTOTALUSAGE       |
    Then Voucher code has been used

  @continue
  Scenario: Invoice Reccuring and Voucher For First Full Paid and Recurring
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VBOOKINGANDRECC1  | VBOOKINGANDRECC1  |
    Then tenant can see voucher is applied

  @continue @TEST_3695
  Scenario: Invoice Reccuring and Voucher For First Full Paid and Settlement
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VBOOKINGANDSETT1  | VBOOKINGANDSETT1  |
    Then Voucher code has been used

  @continue @TEST_SS-3697
  Scenario: Invoice Reccuring and Voucher For Recurring
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VRECONLY1         | VRECONLY1         |
    Then tenant can see voucher is applied

  @continue @TEST_SS-3698
  Scenario: Invoice Reccuring and Voucher For Settlement
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VSETTONLY1        | VSETTONLY1        |
    Then Voucher code has been used

  @continue
  Scenario: Invoice Reccuring and Voucher For Recurring and Settlement
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VRECCANDSETT1     | VRECCANDSETT1     |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Reccuring and Voucher For First Full Paid, Reccuring, and Settlement
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VBOOKRECCSETT1    | VBOOKRECCSETT1    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Reccuring and Voucher For First DP
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VDPONLY1          | VDPONLY1          |
    Then Voucher code has been used

  @continue
  Scenario: Invoice Reccuring and Voucher For First DP and First Full Paid
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VFPANDDP1         | VFPANDDP1         |
    Then Voucher code has been used

  @continue
  Scenario: Invoice Reccuring and Voucher For First DP and Settlement
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VDPANDSETT1       | VDPANDSETT1       |
    Then Voucher code has been used

  @continue
  Scenario: Invoice Reccuring and Voucher For First DP and Recurring
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VDPANDRECC1       | VDPANDRECC1       |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Reccuring and Voucher For First Full Paid, For First DP, and Settlement
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VFPDPANDSETT1     | VFPDPANDSETT1     |
    Then Voucher code has been used

  @continue
  Scenario: Invoice Reccuring and Voucher For First Full Paid, For First DP, and Recurring
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VFPDPANDREC1      | VFPDPANDREC1      |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Reccuring and Voucher For First DP, Settlement, and Recurring
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VDPSETTANDREC1    | VDPSETTANDREC1    |
    Then tenant can see voucher is applied

  @TEST_SS-3669
  Scenario: Invoice Reccuring and Voucher For First Full Paid, For First DP, Settlement, and Recurring
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VALLPRULES1       | VALLPRULES1       |
    Then tenant can see voucher is applied