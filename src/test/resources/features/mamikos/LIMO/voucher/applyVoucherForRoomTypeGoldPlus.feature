@regression @voucher @LIMO8

@TEST-SS-3721 @TEST_SS-3723
Feature: Apply Voucher For Room Type Gold Plus

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag   | phone prod   |
      | 083824996373 | 083824996373 |
    And admin akhiri contract
    Then admin should success terminate contract

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 083824996373 | 083824996373 | qwerty123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                | kost path prod               |
      | kost-kabupaten-rembang-kost-campur-eksklusif-adi-automate-gp1-lasem-rembang-1 | Kos DC BAR Automation Tipe A |
    And tenant booking kost
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password |
      | 0895359416718 | 0895359416718 | P@ssw0rd |
    And owner accept booking and select the room
    Then owner should redirect back to pengajuan booking page

  @continue
  Scenario: Tenant Apply Voucher Applicable for Room Type
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 083824996373 | 083824996373 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VAFORROOMGP11     | VAFORROOMGP11     |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher Not Applicable for Room Type
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VNAFORROOMGP11    | VNAFORROOMGP11    |
    Then Voucher code has been used

  @continue
  Scenario: Tenant Apply Voucher Not Applicable For Other Room Type
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VNAFORROOMGP21    | VNAFORROOMGP21    |
    Then tenant can see voucher is applied

  Scenario: Tenant Apply Voucher Applicable For Other Room Type
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VAFORROOMGP21     | VAFORROOMGP21     |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."