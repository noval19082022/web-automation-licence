@booking @rejectBooking @LIMO6
Feature: OB Owner Reject Booking Full Room

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant kost name:
      | kostName stag          | kostName prod          |
      | Kost New Dashboard 2026 Pasarkemis Tangerang | Dont Starve To Get Her |
    And admin terminate contract
    Then admin should success terminate contract

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0890000000131 | 0890000000131 | qwerty123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                      | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-murah-kost-new-dashboard-2026-pasarkemis-tangerang | Kos DC BAR Automation Tipe A |
    And tenant booking kost
    Then tenant should success booking kost

  @continue @TEST_SS-3506
  Scenario: Owner Reject Booking Full Room
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 0891202601 | 081362464341   | qwerty123 |
    And owner navigates to owner dashboard
    And owner reject booking with reason "Kamar tidak tersedia untuk penyewa"

  Scenario: Owner set room kost Kosong
    When owner navigates to property saya kos
    And owner search kost "Kost New Dashboard 2026 Pasarkemis Tangerang" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click update kamar kost
    And owner set status kamar is kosong
