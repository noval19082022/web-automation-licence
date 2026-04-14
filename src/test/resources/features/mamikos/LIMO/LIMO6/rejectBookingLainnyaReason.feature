@LIMO6
Feature: OB Reject Booking With Lainnya Reason

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag  | phone prod  |
      | 08100000618 | 08100000618 |

  @continue
  Scenario: Cancel and Create Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08100000618 | 08100000618 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request

  Scenario: create booking
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                  | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-murah-kost-new-dashboard-2026-tipe-xx-pasarkemis-tangerang | Kos DC BAR Automation Tipe A |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_SS-3344
  Scenario: Owner Reject Booking With Lainnya Reason
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202601 | 081362464341 | qwerty123 |
    And owner navigates to owner dashboard
    And owner select other reject with custom reason "Saya sudah ada yang punya"

  Scenario: Tenant Check Reject Reason After Owner Reject
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08100000618 | 08100000618 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    Then user check booking status is rejected by owner with reason "Saya sudah ada yang punya"