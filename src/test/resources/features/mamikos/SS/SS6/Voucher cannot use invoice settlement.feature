@SS15
Feature: Voucher cannot use invoice settlement

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod   |
      | 0888123321888 | 087708777618 |

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password     |
      | 0888123321888 | 087708777618 | mamikosqa123 |
    And user cancel booking

  @tenantBookingKos
  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                | kost path prod            |
      | kost-sleman-kost-campur-eksklusif-kost-wild-rift-settlement-1 | Kost Wild Rift Settlement |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  @ownerAcceptKos
  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    And owner navigate to booking page and accept booking from tenant:
      | tenant stag                 | tenant prod |
      | Budi Tromol Coop Automation | TENANT_NAME |
    And owner back to owner dashboard

  @tenantInputVoucher @continue
  Scenario: Tenant pay kos with voucher
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0888123321888 | 08100000622 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOCHNGEPERIOD   | AUTOCHNGEPERIOD   |
    Then tenant can see voucher is applied

  @tenantPayDPWithVoucher @continue
  Scenario: Tenant pay kos with voucher
    Given user go to mamikos homepage
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0890867321217" without close the page
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @tenantPaySTWithVoucher @TEST_SS-4278
  Scenario: Invoice Settlement and Voucher For First Full Paid
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page after pay DP
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VTOTALUSAGE       | VTOTALUSAGE       |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."