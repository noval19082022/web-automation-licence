@regression @listingavailability @SS10

Feature: Listing Availability on Chat Room

  @TEST_SS-3333
  Scenario: Check "Ajukan Sewa" button if the room is available for today
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020199 | 0891111020199 | mamikosqa123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Tanjakan Indah Rajeg Tangerang"
    And user click Ajukan Sewa "today" from chat room
    Then user will open new tab and go to Booking form

  @TEST_SS-3335 @waitingList @commingSoon
  Scenario: Check "Ajukan Sewa" button if the room is not available for today and in the future
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020199 | 0891111020199 | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                                                                      | kost path prod               |
      | kost-kota-denpasar-kost-campur-murah-kost-singgahsini-full-ipi-automation-denpasar-utara-denpasar-2 | Kos DC BAR Automation Tipe A |
    And tenant can see kamar penuh
    Then tenant can see "Ikut daftar tunggu" button

