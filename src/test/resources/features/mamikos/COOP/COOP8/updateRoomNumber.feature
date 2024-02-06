@updateRoom @BBM8
Feature: Update Room number

  @TEST_COOP-686
  Scenario: Remove Update Room Number on Detail Penyewa Page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    |  phone prod   | password    |
      | 082291900002  | 082291900002  | qwerty123   |
    And owner go to Penyewa page of kost "Kos Dhiandra Auto Listing Balik Bukit Lampung Barat"
    Then user can not see update room number button