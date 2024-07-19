@regression @booking @BBM8
Feature: Owner Confirm Booking - Remove Pilih Di Tempat

   @TEST_SS-3311
  Scenario: Cancel and Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password    |
      | 082245501001  | 082245501001  | qwerty123   |
    And user cancel booking
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag             | kost name prod             |
      | Kos Dhiandra Auto Listing Balik Bukit Lampung Barat     | Kos Dhiandra Auto Listing  |
    And tenant booking kost for "today"
    Then tenant should success booking kost

  @TEST_SS-3311
  Scenario: Owner Check Pilih Di Tempat Option
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082291900002 | 082291900002 | qwerty123 |
    And owner go to select the room page from tenant:
      | tenant stag       | tenant prod       |
      | Dhiandra At Siji  | Dhiandra At Siji  |
    Then user can not see pilih di tempat as an option