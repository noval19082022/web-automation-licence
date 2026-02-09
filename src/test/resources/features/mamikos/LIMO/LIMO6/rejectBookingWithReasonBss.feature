@LIMO6
Feature: Check reject booking reason Tanggal masuk/check-in kos terlalu dekat and have BSS varian

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
      | phone stag  | phone prod  | password  |
      | 08100000090 | 08100000090 | qwerty123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                      | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-murah-kost-new-dashboard-2026-pasarkemis-tangerang | Kos DC BAR Automation Tipe A |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_SS-3510
  Scenario: Check reject booking reason Tanggal masuk/check-in kos terlalu dekat and have BSS varian
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 0891202601   | 081362464341 | qwerty123    |
    And owner navigate to pengajuan booking page
    And owner choose filter kost for "Kost New Dashboard 2026 Pasarkemis Tangerang"
    And user clicks on Booking Details button
    And owner reject booking from view detail
    And owner select reason reject kos "Tanggal masuk/check-in kos terlalu dekat"
    Then owner can see confirmation Atur Booking popup
    And owner click on make rules booking button
    Then owner can see make rules booking page