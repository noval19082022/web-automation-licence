@DOM4 @areaboundaries
Feature: Area Boundaries

  @continue @TEST_COOP-5653
  Scenario: User Can Search Kost Based On Landing Area
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Bogor       |
      | area result    | Bogor       |
    Then user can see the kost list are from "Bogor"

  @continue @TEST_COOP-5643
  Scenario: User Can See Kost List Is Only 1
    Given user filter price minimal to 1900000, and maximal to 1900000
    Then user can see kost landing behavior for kost list with just 1 result

  @continue @TEST_COOP-5654
  Scenario: User Can Use Reset Filter Button
    Given user reset filter
    Then user can see kost list is more than 1

  @emptystateareaboundaries @TEST_COOP-5642
  Scenario: User Can See Area Boundaries With Result Is 0
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Bogor           |
      | area result    | Bogor |
    Given user filter price minimal to 10000000, and maximal to 10000000
    Then user can see empty state kost landing area

  @areaboundaries @continue @TEST_COOP-5644
  Scenario: User Can See Area Boundaries With Result Are 20
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Bogor |
      | area result    | Bogor |
    Then user can see kost list is more than 16

#  @areaboundaries @continue
#  Scenario: User Can See Lihat Lebih Banyak And Back To Top Button
#    Then user can see Lihat Lebih Banyak And Back To Top Button

  @areaboundaries @continue @TEST_COOP-5656
  Scenario: User Can See Use Lihat Lebih Banyak
    Given user click on Lihat Lebih Banyak button
    Then user can see kos lists are expanded

#temporary comment due to back to top button is not visible in the chromium
#  @areaboundaries
#  Scenario: User Can Use Back To Top Button
#    Then user can use Back To Top Button

  @areaboundaries @TEST_COOP-5641
  Scenario: User Can Use Cari Berdasarkan Peta Button And Result Are Related To The Predefine Area
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Bogor |
      | area result    | Bogor |
    Then user can see kos list result area are the list below:
      | Tanah Sereal |
      | Bogor        |
      | Bogor Utara  |
      | Bogor Barat  |
      | Sukaraja     |
      | Jasinga      |

  @areaboundaries @TEST_COOP-5640
  Scenario: User Can See Zero Result After Use Singgah Sini Filter
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Batam   |
      | area result    | Batam   |
    When user activate Dikelola Mamikos filter
    Then user can see kos tidak ditemukan state on kos landing area

  @areaboundaries @continue @TEST_COOP-5639
  Scenario: User Can Use Price Sorting From Lower To Greater
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Padang   |
      | area result    | Padang   |
    When user set price sorting from lower to greater
    Then user can see kos list rearrange from cheaper to expensive

  @areaboundaries @TEST_COOP-5638
  Scenario: User Can Use Price Sorting From Greater To Lower
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Padang   |
      | area result    | Padang   |
    And user set price sorting from greater to lower
    Then user can see kos list rearrange from expensive to cheaper