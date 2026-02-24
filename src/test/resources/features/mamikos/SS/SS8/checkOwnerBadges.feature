@SS7
Feature: Check Owner Badges


  @OwnerBadgesNotLogin @OwnerBadges @TEST_SS-3424
  Scenario: Check Owner Badges on Kos Detail when not login tenant (BBM-500)
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                     | kost path prod               |
      | kost-klaten-kost-campur-murah-kost-andalusia-spanyol-eropa-timur-1 | Kos DC BAR Automation Tipe A |
    Then user reached owner badges section

  @OwnerBadgesWithTenantLogin @OwnerBadges @TEST_SS-3422
  Scenario: Check Owner Badges on Kos Detail when login tenant (BBM-498)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                     | kost path prod               |
      | kost-klaten-kost-campur-murah-kost-andalusia-spanyol-eropa-timur-1 | Kos DC BAR Automation Tipe A |
    Then user reached owner badges section

  @OwnerBadgesWithOwnerLogin @TEST_SS-3423
  Scenario: Check Owner Badges on Kos Detail when login owner (BBM-499)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202351 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                     | kost path prod               |
      | kost-klaten-kost-campur-murah-kost-andalusia-spanyol-eropa-timur-1 | Kos DC BAR Automation Tipe A |
    Then user reached owner badges section