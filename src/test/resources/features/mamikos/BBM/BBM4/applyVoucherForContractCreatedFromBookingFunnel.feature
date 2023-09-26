@regression @BBM4 @voucher

@TEST_BBM-734 @TEST_BBM-735 @TEST_BBM-723 @TEST_BBM-770 @TEST_BBM-771 @TEST_BBM-772 @TEST_BBM-781
Feature: Apply Voucher For Contract Created From Booking Funnel

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0890867321205 | 0890867321205 |
    And admin akhiri contract
    Then admin should success terminate contract

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag    | kost name prod        |
      | Kos Loyal Kretek  | Kos Loyal Kretek |
    And tenant booking kost for "today" and input rent duration equals to 2
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod      | password |
      | 0895359416718   | 0895359416718   | P@ssw0rd |
    And owner accept booking from tenant:
      | tenant stag       | tenant prod         |
      | Kos Loyal Kretek  | Kos Loyal Kretek    |
    Then owner should redirect back to pengajuan booking page

  @continue
  @BBM-734
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VCTRFROMBF1       | VCTRFROMBF1   |
    Then tenant can see voucher is applied

  @continue
  @BBM-735
  Scenario: Tenant Apply Voucher with Contract Rules from Consultant
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VCTRFROMCONS1     | VCTRFROMCONS1      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  @BBM-723
  Scenario: Tenant Apply Voucher with Contract Rules from Owner
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VCTRFROMOWNER1    | VCTRFROMOWNER1      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  @BBM-724
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel and Consultant
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VCTRFROMBFC1       | VCTRFROMBFC1       |
    Then tenant can see voucher is applied

  @continue
  @BBM-770
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel and Owner
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VCTRFROMBFO1      | VCTRFROMBFO1       |
    Then tenant can see voucher is applied

  @continue
  @BBM-771
  Scenario: Tenant Apply Voucher with Contract Rules from Consultant and Owner
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VCTRFROMCO1       | VCTRFROMCO1      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."

  @continue
  @BBM-772
  Scenario: Tenant Apply Voucher with Contract Rules from Booking Funnel, Owner, and Consultant
    When tenant set active page to 1
    And tenant input voucher:
      | voucher name stag | voucher name prod |
      | VCTRFROMBFCO1     | VCTRFROMBFCO1       |
    Then tenant can see voucher is applied

  @BBM-781
  Scenario: Tenant Apply Voucher with Contract Rules from Tenant Funnel
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOFUNNEL        | AUTOFUNNEL      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."






