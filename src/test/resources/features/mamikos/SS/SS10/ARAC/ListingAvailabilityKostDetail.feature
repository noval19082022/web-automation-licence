@regression @listingavailability @SS8
Feature: Listing Availability on Kost Detail

  @TEST_SS-3364
  Scenario: Check "Ajukan Sewa" button if the room is available for today
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 082245501002 | 082245501002 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                     | kost path prod               |
      | kost-kabupaten-lampung-barat-kost-campur-murah-kos-dhiandra-auto-listing-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
    And user want to dismiss FTUE
    And tenant fill booking data for "today" and "Per Bulan"
    Then tenant should see ajukan sewa button is "enable"
    When tenant booking kost after fill date and rent type
    Then tenant should success booking kost
    And tenant navigate to riwayat and draf booking
    And user cancel booking