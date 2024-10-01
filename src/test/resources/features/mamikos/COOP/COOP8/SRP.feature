@BBM8 @srp
Feature: SRP

  @SS-4381
  Scenario: [WEB] Check total kos in page 20 listing
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Surabaya City       |
      | area result    | Surabaya City       |
    Then user can see total kost in area with "Ditemukan 899 kos-kosan di sekitar Surabaya City, Jawa Timur, Indonesia"
    When tenant can click on load more button
