@LIMO7
Feature: Apply Voucher Quarterly For Contract Duration

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0890867321205 | 0890867321205 |

  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And user cancel booking

  Scenario: Tenant Booking Kos For 1 Quarter Duration
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                                             | kost path prod           |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-adi-auto-with-dp | Kost Adi Auto Voucher DP |
    And tenant booking kost "tomorrow" "Per 3 Bulan"
    Then tenant should success booking kost

  Scenario: Owner Accept 1 Quarter Booking Duration
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag           | tenant prod           |
      | Adi Auto Voucher Satu | Adi Auto Voucher Satu |
    Then owner should redirect back to pengajuan booking page

  @TEST_SS-4266
  Scenario: Tenant Apply Voucher Quarter Voucher For 1 Quarter Contract Duration
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | SEWAQUARTERLY     | AUTOQUARTERLY     |
    Then tenant can see voucher is applied

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0890867321205 | 0890867321205 |

  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And user cancel booking

  Scenario: Tenant Booking Kost With 1 Year Duration
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                                             | kost path prod           |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-adi-auto-with-dp | Kost Adi Auto Voucher DP |
    And tenant booking kost "tomorrow" "Per Tahun"
    Then tenant should success booking kost

  Scenario: Owner Accept 1 Year Booking Duration
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag           | tenant prod           |
      | Adi Auto Voucher Satu | Adi Auto Voucher Satu |
    Then owner should redirect back to pengajuan booking page

  @TEST_SS-4266
  Scenario: Tenant Apply Voucher Quarter Voucher For 1 Year Contract Duration
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOQUARTERLY     | AUTOQUARTERLY     |
    Then tenant should see voucher error message "Kode voucher tidak bisa digunakan."