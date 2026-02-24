@SS13
Feature: Click Button Ubah Metode Pembayaran After Paid

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

  @cancelBooking @continue
  Scenario: cancel booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod | password     |
      | 0888123321888 | 0892202105 | mamikosqa123 |
    And user cancel booking

  @tenantBookingKos
  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                        | kost path prod |
      | kost-halmahera-utara-kost-campur-murah-kost-reykjavik | Kost Reykjavik |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  @ownerAcceptKos
  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod     | password     |
      | 0890000000289 | 08900000000021 | Bismillah@01 |
    And owner accept booking from tenant:
      | tenant stag                 | tenant prod         |
      | Budi Tromol Coop Automation | Irvi Tenant Add Ons |
    Then owner should redirect back to pengajuan booking page

  @tenantPayWithVoucher @continue @TEST_SS-4391
  Scenario: click "Ubah Metode Pembayaran" After Paid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0888123321888 | 08100000622 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0890867321217" without close the page
    And tenant click on ubah metode pembayaran
    Then tenant will see that the text "Pastikan Anda belum melakukan pembayaran" is displayed

  Scenario: Check Invoice From Kost Saya
    Given user go to mamikos homepage
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    And tenant navigate to tagihan kost saya
    And tenant click item card billing has been paid
    Then tenant will see that the text "Rincian Tagihan" is displayed

