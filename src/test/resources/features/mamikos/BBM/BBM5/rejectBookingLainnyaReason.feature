@BBM5
Feature: OB Reject Booking With Lainnya Reason

  @TEST_BBM-2311 @continue
  Scenario: Cancel and Create Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08100000618 | 08100000618 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request

  Scenario: create booking
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag            | kost name prod            |
      | Kost Wild Rift Settlement | Kost Wild Rift Settlement |
    And tenant booking kost
    Then tenant should success booking kost

  Scenario: Owner Reject Booking With Lainnya Reason
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    And owner reject booking from dashboard
    And owner select other reject with custom reason "Saya sudah ada yang punya"

  Scenario: Tenant Check Reject Reason After Owner Reject
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password   |
      | 08100000618  | 08100000618 | qwerty123  |
    And tenant navigate to riwayat and draf booking
    Then user check booking status is rejected by owner with reason "Saya sudah ada yang punya"