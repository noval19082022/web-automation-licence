@regression @booking @SS10
Feature: Owner Confirm Booking - Remove Pilih Di Tempat

  @TEST_SS-3311
  Scenario: Cancel and Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 082245501001 | 082245501001 | qwerty123 |
    And user cancel booking
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                     | kost path prod               |
      | kost-kabupaten-lampung-barat-kost-campur-murah-kos-dhiandra-auto-listing-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
    And tenant booking kost for "today"
    Then tenant should success booking kost

  @TEST_SS-3311
  Scenario: Owner Check Pilih Di Tempat Option
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082291900002 | 082291900002 | qwerty123 |
    And owner go to select the room page from tenant:
      | tenant stag      | tenant prod      |
      | Dhiandra At Siji | Dhiandra At Siji |
    Then user can not see pilih di tempat as an option