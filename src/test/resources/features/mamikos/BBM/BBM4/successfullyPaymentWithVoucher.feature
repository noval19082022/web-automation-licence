@regression @BBM4 @voucher

Feature: Successfully Payment with Voucher

Scenario: Admin Batalkan Contract
  Given admin go to mamikos mamipay admin
  When admin login to mamipay:
    | email stag                   | email prod                   | password  |
    | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
  And admin search contract by tenant phone number:
    | phone stag    | phone prod    |
    | 0888123321888 | 0890867321217 |
  And admin akhiri contract
  Then admin should success terminate contract

  @cancelBooking
  @continue
  Scenario: cancel booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod | password  |
      | 0888123321888 | 0892202105 | mamikosqa123 |
    And user cancel booking

  @tenantBookingKos
  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag    | kost name prod    |
      | kost reykjavik    | kost reykjavik    |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  @ownerAcceptKos
  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0890000000289 | 0890000000289 | Bismillah@01 |
    And owner accept booking via Homepage
    And owner back to owner dashboard
    Then owner can see pengajuan sewa detail on dashboard

  @tenantInputVoucher
  @continue
  Scenario: Tenant pay kos with voucher
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0888123321888 | 08100000622 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | TIRTAYASA4        | AUTOCHNGEPERIOD |
    Then tenant can see voucher is applied

  @tenantPayWithVoucher
  Scenario: Tenant pay kos with voucher
    Given user go to mamikos homepage
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0888123321888" without close the page
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success