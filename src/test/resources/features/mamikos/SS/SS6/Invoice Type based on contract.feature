@SS13
Feature: Invoice Type based on contract

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0890867321228 | 0890867321228 |

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321228 | 0890867321228 | mamikosqa123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                       | kost path prod                                       |
      | kost-bantul-kost-campur-eksklusif-kos-loyal-kretek-1 | kost-bantul-kost-campur-eksklusif-kos-loyal-kretek-1 |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password |
      | 0895359416718 | 0895359416718 | P@ssw0rd |
    And owner accept booking from tenant:
      | tenant stag                   | tenant prod                   |
      | Adi Auto Voucher Base On User | Adi Auto Voucher Base On User |
    Then owner should redirect back to pengajuan booking page

  @TEST_SS-4261
  Scenario: Tenant Apply Voucher Invoice Type based on contract
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321228 | 0890867321228 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VBCONTFORFIRST    | VBCONTFORFIRST    |
    Then tenant can see voucher is applied