@BBM6
Feature: Reject Booking From Owner Dashboard

  Scenario Outline: Cancel and create booking
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag            | phone prod            |
      | <tenant phone number> | <tenant phone number> |
    #Scenario: cancel booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag             | phone prod            | password   |
      | <tenant phone number>  | <tenant phone number> | qwerty123  |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request
    #Scenario: create booking
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag | kost name prod |
      | kost reykjavik | kost reykjavik |
    And tenant booking kost "tomorrow" "Per Bulan"
    And user go to mamikos homepage
    And user logs out as a Tenant user

    Examples:
      | tenant phone number |
      | 083894304420        |
      | 0822660001          |

  @TEST_BBM-14
  Scenario: [Owner dashboard][Ada yang menunggu]Reject Booking via Homepage (more than 1 waiting booking)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0890000000289 | 0890000000289 | Bismillah@01 |
    Then owner can see pengajuan sewa detail on dashboard
    When owner reject booking from dashboard
    And owner select reason reject kos "Tidak boleh bawa anak"
    And owner navigates to owner dashboard
    Then owner can see pengajuan sewa detail on dashboard