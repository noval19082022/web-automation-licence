@SS12 @DOMareaboundaries
Feature: Area Boundaries

  @continue @TEST_SS-3246
  Scenario: User Can Search Kost Based On Landing Area
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Sleman |
      | area result    | Sleman |
    Then user can see the kost list are from "Sleman"

  @continue @TEST_SS-3234
  Scenario: User Can See Kost List Is more than 1
    Given user filter price minimal to 230000, and maximal to 231000
    Then user can see kost landing behavior for kost list with just 1 result

  @emptystateareaboundaries @TEST_SS-3232
  Scenario: User Can See Area Boundaries With Result Is 0
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Sleman |
      | area result    | Sleman |
    Given user filter price minimal to 10000, and maximal to 20000
    Then user can see empty state kost landing area

  @areaboundaries @continue @TEST_SS-3242
  Scenario: User Can See Area Boundaries With Result Are 20
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Sleman |
      | area result    | Sleman |
    Then user can see kost list is more than 16

#  @areaboundaries @continue
#  Scenario: User Can See Lihat Lebih Banyak And Back To Top Button
#    Then user can see Lihat Lebih Banyak And Back To Top Button

  @areaboundaries @TEST_SS-3272
  Scenario: User Can See Use Lihat Lebih Banyak
    Given user click on Lihat Lebih Banyak button
    Then user can see kos lists are expanded

#temporary comment due to back to top button is not visible in the chromium
#  @areaboundaries
#  Scenario: User Can Use Back To Top Button
#    Then user can use Back To Top Button

  @areaboundaries @TEST_SS-3237
  Scenario: User Can Use Cari Berdasarkan Peta Button And Result Are Related To The Predefine Area
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Sleman |
      | area result    | Sleman |
    Then user can see kos list result area are the list below:
      | Ngaglik  |
      | Kecamatan Ngaglik |
      | Kecamatan Ngaglik |
      | Pakem |

  @areaboundaries @TEST_SS-3235
  Scenario: User Can See Zero Result After Use Singgah Sini Filter
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Batam |
      | area result    | Batam |
    When user activate Dikelola Mamikos filter
#    Then user can see kos tidak ditemukan state on kos landing area
    Then user will see that the text "Kos Tidak Ditemukan" is displayed

  @areaboundaries @continue @TEST_SS-3250
  Scenario: [Dweb][Listing Kos][Area Boundaries] User Can Use Price Sorting From Lower To Greater
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Padang |
      | area result    | Padang |
    When user set price sorting from lower to greater
    Then user can see kos list rearrange from cheaper to expensive

  @areaboundaries @TEST_COOP-5638
  Scenario: [Dweb][Listing Kos][Area Boundaries] User Can Use Price Sorting From Greater To Lower
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Padang |
      | area result    | Padang |
    And user set price sorting from greater to lower
    Then user can see kos list rearrange from expensive to cheaper