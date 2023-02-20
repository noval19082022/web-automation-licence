#@DOM4
Feature: Kost detail page

  @TEST_DOM-1703 @DOM4 @automated @discovery-platform @kost-details @overview-section @web
  Scenario: [Dweb][Kost Detail]Check property overview section
    Given user go to mamikos homepage
    When user want to search kost from homepage
      | kost stag                     | kost prod                                           |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see overview section on detail page
      | kost stag                     | kost prod                                           |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |