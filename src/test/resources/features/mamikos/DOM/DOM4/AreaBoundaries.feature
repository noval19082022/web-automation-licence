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

  Scenario: User Can See Area Boundaries With Result Is 0
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Lumajang |
      | area result    | Kabupaten Wonosobo |
    Then user can see empty state kost landing area

  @areaboundaries @continue
  Scenario: User Can See Area Boundaries With Result Are 20
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Bogor |
      | area result    | Bogor |
    Then user can see kost list is more than 16

  @areaboundaries @continue
  Scenario: User Can See Lihat Lebih Banyak And Back To Top Button
    Then user can see Lihat Lebih Banyak And Back To Top Button

  @areaboundaries @continue
  Scenario: User Can See Use Lihat Lebih Banyak
    Given user click on Lihat Lebih Banyak button
    Then user can see kos lists are expanded

  @areaboundaries
  Scenario: User Can Use Back To Top Button
    Then user can use Back To Top Button

  @areaboundaries
  Scenario: User Can Use Cari Berdasarkan Peta Button And Result Are Related To The Predefine Area
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Bogor |
      | area result    | Bogor |
    Then user can see kos list result area are the list below:
      | Tanah Sereal |
      | Bogor |
      | Bogor Utara |

  @areaboundaries
  Scenario: User Can See Zero Result After Use Singgah Sini Filter
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Padang |
      | area result    | Padang Bulan |
    When user use filter "Dikelola Mamikos"
    Then user can see kos tidak ditemukan state on kos landing area

  @areaboundaries1 @continue
  Scenario: User Can Use Price Sorting From Lower To Greater
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Depok |
      | area result    | Depok City |
    When user set price sorting from lower to greater
    Then user can see kos list rearrange from cheaper to expensive

  @areaboundaries1
  Scenario: User Can Use Price Sorting From Greater To Lower
    When user set price sorting from greater to lower
    Then user can see kos list rearrange from expensive to cheaper