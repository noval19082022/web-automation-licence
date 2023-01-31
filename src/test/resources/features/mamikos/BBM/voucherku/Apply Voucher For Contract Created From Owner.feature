@regression @BBM7 @voucher

@TEST_BBM-712 @TEST_BBM-702 @TEST_BBM-665 @TEST_BBM-666
Feature: Apply Voucher For Contract Created From Owner

#  BBM-686
  @continue
  Scenario: Tenant Apply Voucher with Contract Rules from from Consultant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321226 | 0890867321226 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOOWNER         | AUTOOWNER         |
    Then tenant can see voucher is applied

#  BBM-684
  @continue
  Scenario: Tenant Apply Voucher with Contract Rules from Owner
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOCONSULTANT    | AUTOCONSULTANT    |
    Then Voucher code has been used

#  BBM-677
  @continue
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOBOOKFUNNEL    | AUTOBOOKFUNNEL    |
    Then Voucher code has been used

  @continue
  Scenario: Tenant Apply Voucher with Contract Rules from Tenant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNNELCONS    | AUTOFUNNELCONS    |
    Then Voucher code has been used

  @continue
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel and Consultant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNNELOWNER   | AUTOFUNNELOWNER   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel and Owner
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOCONSOWNER     | AUTOCONSOWNER     |
    Then tenant can see voucher is applied

#  BBM-675
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel, Owner, and Consultant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNOWNCONS    | AUTOFUNOWNCONS    |
    Then tenant can see voucher is applied