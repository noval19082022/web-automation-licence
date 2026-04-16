@LIMO7
Feature: Apply Voucher For Booking Rule, Invoice Without DP

  @Automated @SS @Web
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
      | kost path stag                                                               | kost path prod        |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-adi-auto-regular-1 | Kost Adi Auto Regular |
    And tenant booking kost for "tomorrow" and input rent duration equals to 4
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag           | tenant prod           |
      | Kost Adi Auto Regular | Kost Adi Auto Regular |
    Then owner should redirect back to pengajuan booking page


  @@continue
  Scenario: Tenant Apply Voucher for First Paid and Total Usage Limit > 0
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321211 | 0890867321211 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VTOTALUSAGE       | VTOTALUSAGE       |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher for First Paid and Daily Usage Limit > 0
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VDAILYUSAGE       | VDAILYUSAGE       |
    Then tenant can see voucher is applied


  @continue
  Scenario: Tenant Apply Voucher Date Not Started Yet
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTONOTSTART      | AUTONOTSTART      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."


  @continue
  Scenario: Tenant Apply Voucher Date Not Started Yet
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTONOTSTART      | AUTONOTSTART      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."


  @continue
  Scenario: Tenant Apply Voucher Already Expired
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOEXPIRED       | AUTOEXPIRED       |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."


  @continue
  Scenario: Tenant Apply Voucher Not Meet Minimum Amount Required
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTONOTMEETTRX    | AUTONOTMEETTRX    |
    Then tenant can see warning message "Belum mencapai minimal transaksi."


  @continue
  Scenario: Tenant Apply Voucher not Meet Min. Contract Duration
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTONOTMEETDUR    | AUTONOTMEETDUR    |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."


  @continue
  Scenario: Tenant Apply Inactive Voucher
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VINACTIVE         | VINACTIVE         |
    Then tenant can see warning message "Kode voucher tidak ditemukan."


  @continue @TEST_SS-4257
  Scenario: Tenant Apply Voucher For First Paid and Reccuring Rule
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOFULLPAIDREC   | AUTOFULLPAIDREC   |
    Then tenant can see voucher is applied


  @continue
  Scenario: Tenant Apply Voucher For First Paid and Settlement Rule
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDSETTLE   | AUTOFPAIDSETTLE   |
    Then tenant can see voucher is applied


  @continue
  Scenario: Tenant Apply Voucher For Reccuring Rule
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTORECURRING     | AUTORECURRING     |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."


  @continue
  Scenario: Tenant Apply Voucher For Settlement Rule
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOSETTLEMENT    | AUTOSETTLEMENT    |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."


  @continue
  Scenario: Tenant Apply Voucher For Reccuring and Settlement Rule
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTORECSETTLE     | AUTORECSETTLE     |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."


  @continue
  Scenario: Tenant Apply Voucher For First Paid, Reccuring and Settlement Rule
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDRECSET   | AUTOFPAIDRECSET   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher For DP
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTODP            | AUTODP            |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."


  @continue
  Scenario: Tenant Apply Voucher For First Paid and DP
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDDP       | AUTOFPAIDDP       |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher For DP And Settlement
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTODPSETTLE      | AUTODPSETTLE      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Tenant Apply Voucher For DP and Recurring
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTODPRECURRING   | AUTODPRECURRING   |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Tenant Apply Voucher For First Paid, DP and Settlement
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDDPSET    | AUTOFPAIDDPSET    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher For First Paid, DP and Recurring
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFPAIDDPREC    | AUTOFPAIDDPREC    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher For DP, Settlement and Recurring
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTODPSETREC      | AUTODPSETREC      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Tenant Apply Voucher For First Paid, DP, Settlement and Recurring
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOALLPAYRULES   | AUTOALLPAYRULES   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher Applicable for Other Kost City
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOOTHERCITY     | AUTOOTHERCITY     |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Tenant Apply Voucher Not Applicable for Other Kost City
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTONOOTHERCITY   | AUTONOOTHERCITY   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher Applicable for Kost Name
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTONAME          | AUTONAME          |
    Then tenant can see voucher is applied


  @continue
  Scenario: Tenant Apply Voucher Not Applicable for Kost Name
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTONONAME        | AUTONONAME        |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Tenant Apply Voucher Applicable for Other Kost Name
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOOTHERNAME     | AUTOOTHERNAME     |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Tenant Apply Voucher Not Applicable for Other Kost Name
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTONOOTHERNAME   | AUTONOOTHERNAME   |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher Applicable for Tenant Email Domain
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VOUCHERDOMAIN     | AUTODOMAIN        |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher Not Applicable for Tenant Email Domain
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTONODOMAIN      | AUTONODOMAIN      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Tenant Apply Voucher Applicable for Other Tenant Email Domain
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOOTHERDOM      | AUTOOTHERDOM      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  Scenario: Tenant Apply Voucher Applicable for Tenant Email
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | AUTOEMAIL         | AUTOEMAIL         |
    Then tenant can see voucher is applied

  Scenario: Tenant Apply Voucher Applicable for Other Tenant Email
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOOTHEREMAIL    | AUTOOTHEREMAIL    |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."
		
