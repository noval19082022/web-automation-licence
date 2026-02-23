@LIMO7
Feature: Invalid Voucher After Applied, Invalid Contract Period

  Scenario: Admin Edit Voucher AUTOCHNGEPERIOD and Change Contract Period to Monthly
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to mamikos voucher menu
    And admin input voucher with value "ATCHANGEPERIOD" and click search button:
    And admin master clicks on edit pencil icon
    And admin unselect all contract periods
    And admin select minimum type of contract period "Monthly"
    And admin master clicks on edit mass voucher button in voucher form
    Then System display alert message on mamipay web

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod  |
      | 0888123321888 | 08100000622 |
    And admin akhiri contract
    Then admin should success terminate contract

  @tenantBookingKos
  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0888123321888 | 08100000622 | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                        | kost path prod |
      | kost-halmahera-utara-kost-campur-murah-kost-reykjavik | Kost Reykjavik |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  @ownerAcceptKos
  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0890000000289 | 0890000000289 | Bismillah@01 |
    And owner accept booking from tenant:
      | tenant stag                 |
      | Budi Tromol Coop Automation |
    Then owner should redirect back to pengajuan booking page

  @tenantInputVoucher
  Scenario: Tenant Input Voucher ATCHANGEPERIOD
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0888123321888 | 08100000622 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | ATCHANGEPERIOD    | AUTOCHNGEPERIOD   |
    Then tenant can see voucher is applied

  Scenario: Admin Edit Voucher AUTOCHNGEPERIOD and Change Contract Period to Annually
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to mamikos voucher menu
    And admin input voucher with value "ATCHANGEPERIOD" and click search button:
    And admin master clicks on edit pencil icon
    And admin unselect all contract periods
    And admin select minimum type of contract period "Annually"
    And admin master clicks on edit mass voucher button in voucher form
    Then System display alert message on mamipay web

  @tenantInputVoucherAfterUpdate @TEST_SS-4279
  Scenario: Tenant Input Voucher ATCHANGEPERIOD
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0888123321888 | 08100000622 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | ATCHANGEPERIOD    | AUTOCHNGEPERIOD   |
    Then Voucher code has been used