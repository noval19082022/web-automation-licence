@LIMO6 @regression @confirmBooking @TEST_SS-3482 @essentialTest2
Feature: [Owner dashboard][Ada yang menunggu]Accept Booking via Homepage (more than 1 waiting booking)

  Scenario Outline: Cancel and create booking
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag            | phone prod            |
      | <tenant phone number> | <tenant phone number> |
    And admin akhiri contract
    Then admin should success terminate contract
    #Scenario: cancel booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag            | phone prod            | password  |
      | <tenant phone number> | <tenant phone number> | qwerty123 |
    And user cancel booking
    #Scenario: create booking
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                        | kost path prod               |
      | kost-halmahera-utara-kost-campur-murah-kost-reykjavik | Kos DC BAR Automation Tipe A |
    And tenant booking kost "tomorrow" "Per Bulan"
    Then tenant should success booking kost

    Examples:
      | tenant phone number |
      | 08100000622         |
      | 0822660001          |

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0890000000289 | 0890000000289 | Bismillah@01 |
    And owner accept booking via Homepage

  @TEST_LIMO-10577
  Scenario: [Owner Dashboard][Pengajuan Sewa] Display counter badge for booking requests needing confirmation
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password    |
      | 0890000000289  | 0890000000289  | Bismillah@01 |
    And owner navigates to owner dashboard
    When owner views the Activities section
    Then owner should see the "Pengajuan Sewa" icon
    And the icon should display a counter badge
    And the counter should show the number of bookings needing confirmation
