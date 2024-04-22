@COOP6 @BBM6
Feature: Check Owner Badges


  @OwnerBadgesNotLogin @OwnerBadges @TEST_COOP-1358
  Scenario: Check Owner Badges on Kos Detail when not login tenant (BBM-500)
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost Andalusia Spanyol Eropa Timur | kost payment desta 2 |
    Then user reached owner badges section

  @OwnerBadgesWithTenantLogin @OwnerBadges @TEST_COOP-1356
  Scenario: Check Owner Badges on Kos Detail when login tenant (BBM-498)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost Andalusia Spanyol Eropa Timur | kost payment desta 2 |
    Then user reached owner badges section

  @OwnerBadgesWithOwnerLogin @TEST_COOP-1357
  Scenario: Check Owner Badges on Kos Detail when login owner (BBM-499)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202351 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost Andalusia Spanyol Eropa Timur | kost payment desta 2 |
    Then user reached owner badges section