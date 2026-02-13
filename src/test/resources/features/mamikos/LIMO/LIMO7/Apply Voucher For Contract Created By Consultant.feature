@regression @LIMO7 @voucher

@TEST_SS-3691 @TEST_SS-3701
Feature: Apply Voucher For Contract Created By Consultant

#  COOP-2535
  @continue @TEST_SS-3951
  Scenario: Tenant Apply Voucher with Contract Rules from from Consultant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321225 | 0890867321225 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOKOSTINV2      | AUTOKOSTINV2      |
    Then tenant can see voucher is applied

#  COOP-2534
  @continue @TEST_SS-3881
  Scenario: Tenant Apply Voucher with Contract Rules from Owner
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOOWNER         | AUTOOWNER         |
    Then Voucher code has been used

#  COOP-2532
  @continue @TEST_SS-3607
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | BOOKFROMOWNER    | AUTOBOOKFUNNEL    |
    Then Voucher code has been used

  @continue
  Scenario: Tenant Apply Voucher with Contract Rules from Tenant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOTENANT        | AUTOTENANT        |
    Then Voucher code has been used

  @continue
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel and Consultant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNNELCONS    | AUTOFUNNELCONS    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel and Owner
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNNELOWNER   | AUTOFUNNELOWNER   |
    Then Voucher code has been used

#  COOP-2531
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel, Owner, and Consultant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNOWNCONS    | AUTOFUNOWNCONS    |
    Then tenant can see voucher is applied