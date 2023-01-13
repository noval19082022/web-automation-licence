@booking @essential
Feature: Booking

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag   | phone prod   |
      | 0890867321212 | 0890867321212 |
    And admin terminate contract
    Then admin should success terminate contract

  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag      |  phone prod     | password    |
      | 0890867321212    |  0890867321212   | mamikosqa123   |
    And user cancel booking

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    |  phone prod    | password  |
      | 0890867321212  |  0890867321212  | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod                          |
      | Kost Adi Auto SinggahSini | Kost Adi Auto SinggahSini |
    And tenant booking kost
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    |  phone prod    | password     |
      | 08900000000022  |  08900000000022  | mamikosqa123 |
    And owner accept booking
    Then owner should redirect back to pengajuan booking page
