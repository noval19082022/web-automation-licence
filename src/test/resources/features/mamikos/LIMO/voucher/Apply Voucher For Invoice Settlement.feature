@LIMO7
Feature: Apply Voucher For Invoice Settlement

  @TEST_SS-4259 @Automated @SS @Web
  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0890867321211 | 0890867321211 |
    And admin akhiri contract
    Then admin should success terminate contract

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321211 | 0890867321211 | mamikosqa123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                             | kost path prod           |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-adi-auto-with-dp | Kost Adi Auto Voucher DP |
    And tenant booking kost for "tomorrow" and input rent duration equals to 4
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag              | tenant prod              |
      | Kost Adi Auto Voucher DP | Kost Adi Auto Voucher DP |
    Then owner should redirect back to pengajuan booking page

  Scenario: Tenant Pay DP Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321211 | 0890867321211 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0890867321211" without close the page
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice DP from riwayat booking
    And tenant set active page to 2
    And tenant get invoice number

  @continue
  Scenario: Invoice Settlement and Voucher For First Full Paid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321211 | 0890867321211 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page after pay DP
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VTOTALUSAGE       | VTOTALUSAGE       |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Voucher For Recurring
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTORECURRING     | AUTORECURRING     |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Settlement and Voucher For Settlement
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOSETTLEMENT    | AUTOSETTLEMENT    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Settlement and Voucher For First Full Paid and Recurring
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFULLPAIDREC   | AUTOFULLPAIDREC   |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Settlement and Voucher For First Full Paid and Settlement
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDSETTLE   | AUTOFPAIDSETTLE   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Settlement and Voucher For Recurring and Settlement
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTORECSETTLE     | AUTORECSETTLE     |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Settlement and Voucher For First Full Paid, Reccuring, and Settlement
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDRECSET   | AUTOFPAIDRECSET   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Settlement and Voucher For DP
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTODP            | AUTODP            |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Settlement and Voucher For First Full Paid and DP
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDDP       | AUTOFPAIDDP       |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Settlement and Voucher For DP and Settlement
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTODPST          | AUTODPST          |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Settlement and Voucher For DP and Recurring
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTODPRECURRING   | AUTODPRECURRING   |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Settlement and Voucher For First Full Paid, DP, and Settlement
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDDPSET    | AUTOFPAIDDPSET    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Invoice Settlement and Voucher For First Full Paid, DP, and Recurring
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDDPREC    | AUTOFPAIDDPREC    |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Invoice Settlement and Voucher For DP, Settlement, and Recurring
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTODPSETREC      | AUTODPSETREC      |
    Then tenant can see voucher is applied

  Scenario: Invoice Settlement and Voucher For First Paid, DP, Settlement, and Recurring
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOALLPAYRULES   | AUTOALLPAYRULES   |
    Then tenant can see voucher is applied
		
