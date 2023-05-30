@BBM8
Feature: Check reject booking reason Tanggal masuk/check-in kos terlalu dekat and have BSS varian

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant kost name:
      | kostName stag               | kostName prod            |
      | Kost Wanawana papua         | Kost Wanawana papua      |
    And admin terminate contract
    Then admin should success terminate contract

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   |  phone prod   | password  |
      | 08100000090  |  08100000090  | qwerty123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag            | kost name prod            |
      | Kost Wanawana papua       | Kost Wanawana papua       |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_BBM-910
  Scenario: Check reject booking reason Tanggal masuk/check-in kos terlalu dekat and have BSS varian
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 089604239098  | 0890867321212 | widyarini1   |
    And owner navigate to pengajuan booking page
    And user clicks on Booking Details button
    And owner reject booking from view detail
    And owner select reason reject kos "Tanggal masuk/check-in kos terlalu dekat"
    Then owner can see confirmation Atur Booking popup
    And owner click on make rules booking button
    Then owner can see make rules booking page