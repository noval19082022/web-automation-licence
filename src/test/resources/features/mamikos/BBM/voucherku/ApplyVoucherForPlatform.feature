@BBM7
Feature: Apply Voucher For Platform

  Scenario: Tenant Input Voucher Platform for Android and iOS
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOANDROIDXIOS   | AUTOANDROIDXIOS   |
    Then tenant can see warning message "Hanya berlaku di aplikasi Android dan iOS."
    When scenario is "continue"

  Scenario: Tenant Input Voucher Platform for iOS
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOIOS           | AUTOIOS           |
    Then tenant can see warning message "Hanya berlaku di aplikasi iOS."
    When scenario is "continue"

  Scenario: Tenant Input Voucher Platform for Android
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOANDROID       | AUTOANDROID       |
    Then tenant can see warning message "Hanya berlaku di aplikasi Android."
    When scenario is "continue"

  Scenario: Tenant Input Voucher Platform for Web, Android, and iOS
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOWEBADRIOS     | AUTOWEBADRIOS     |
    Then tenant can see voucher is applied
    When scenario is "continue"

  Scenario: Tenant Input Voucher Platform for Web
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOWEB           | AUTOWEB           |
    Then tenant can see voucher is applied
    When scenario is "end"