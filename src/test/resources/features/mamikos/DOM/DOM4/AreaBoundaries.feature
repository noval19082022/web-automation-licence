@DOM4
Feature: Area Boundaries

  @continue
  Scenario: User Can Search Kost Based On Landing Area
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Padang |
      | area result    | Padang Bulan |
    Then user can see the kost list are from "Padang Bulan"

  @continue
  Scenario: User Can See Kost List Is Only 1
    Given user filter price minimal to 750000, and maximal to 750000
    Then user can see kost landing behavior for kost list with just 1 result

  Scenario: User Can Use Reset Filter Button
    Given user reset filter
    Then user can see kost list is more than 1

  @areaboundaries
  Scenario: User Can See Area Boundaries With Result Is 0
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Lumajang |
      | area result    | Kabupaten Wonosobo |
    Then user can see empty state kost landing area