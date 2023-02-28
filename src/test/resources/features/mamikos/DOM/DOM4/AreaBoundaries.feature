@DOM4
Feature: Area Boundaries

  @areaboundaries @continue
  Scenario: User Can Search Kost Based On Landing Area
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Padang |
      | area result    | Padang Bulan |
    Then user can see the kost list are from "Padang Bulan"

  @areaboundaries @continue
  Scenario: User Can See Kost List Is Only 1
    Given user filter price minimal to 750000, and maximal to 750000
    Then user can see kost landing behavior for kost list with just 1 result

  @areaboundaries
  Scenario: User Can Use Reset Filter Button
    Given user reset filter
    Then user can see kost list is more than 1