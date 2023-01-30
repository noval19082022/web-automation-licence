@regression @BBM7 @voucher

@TEST_BBM-677 @TEST_BBM-684 @TEST_BBM-686 @TEST_BBM-675
Feature: Apply Voucher For Contract Created By Consultant

#  BBM-686
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
    When scenario is "continue"

#  BBM-684
  Scenario: Tenant Apply Voucher with Contract Rules from Owner
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOOWNER         | AUTOOWNER         |
    Then Voucher code has been used
    When scenario is "continue"

#  BBM-677
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOBOOKFUNNEL    | AUTOBOOKFUNNEL    |
    Then Voucher code has been used
    When scenario is "continue"

  Scenario: Tenant Apply Voucher with Contract Rules from Tenant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOTENANT        | AUTOTENANT        |
    Then Voucher code has been used
    When scenario is "continue"

  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel and Consultant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNNELCONS    | AUTOFUNNELCONS    |
    Then tenant can see voucher is applied
    When scenario is "continue"

  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel and Owner
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNNELOWNER   | AUTOFUNNELOWNER   |
    Then Voucher code has been used
    When scenario is "continue"

#  BBM-675
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel, Owner, and Consultant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNOWNCONS    | AUTOFUNOWNCONS    |
    Then tenant can see voucher is applied
    When scenario is "end"

