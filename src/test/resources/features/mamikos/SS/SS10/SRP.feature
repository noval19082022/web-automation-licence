@SS8 @srp
Feature: SRP

  @SS-4381
  Scenario: [WEB] Check total kos in page 20 listing
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Pandaan Arta Jaya       |
      | area result    | Pandaan Arta Jaya       |
    Then user can see total kost in area with "Ditemukan 382 kos-kosan di sekitar Pandaan Arta Jaya, Keputran, Kota Surabaya, Jawa Timur, Indonesia"
    When tenant can click on load more button

  @SS-4389
  Scenario: [WEB]User click cluster on map and produces < 240 kos
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Pandaan            |
      | area result    | Pandaan Artha Jaya |
    Then user can see total kost in area with "Ditemukan 32 kos-kosan di sekitar Pandaan Artha Jaya, Jalan Urip Sumoharjo, Pesantren, Pandaan, Pasuruan, Jawa Timur, Indonesia"
    When user click on cluster number "3" on maps
    Then user can see total kost in area with "Ditemukan 3 kos-kosan di sekitar Pandaan Artha Jaya, Jalan Urip Sumoharjo, Pesantren, Pandaan, Pasuruan, Jawa Timur, Indonesia"
    When user click on cluster number "Rp300rb" on maps

  @SS-4388
  Scenario: [WEB]User zoom in and out map and produces < 240 kos
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | Pandaan            |
      | area result    | Pandaan Artha Jaya |
    When user click on "zoom in" on maps
    Then user can see total kost in area with "Ditemukan 21 kos-kosan di sekitar Pandaan Artha Jaya, Jalan Urip Sumoharjo, Pesantren, Pandaan, Pasuruan, Jawa Timur, Indonesia"
    When user click on "zoom out" on maps
    Then user can see total kost in area with "Ditemukan 32 kos-kosan di sekitar Pandaan Artha Jaya, Jalan Urip Sumoharjo, Pesantren, Pandaan, Pasuruan, Jawa Timur, Indonesia"

  @SS-4384
  Scenario: [WEB]User click cluster on map and produces >= 240 kos
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | UNDIP                          |
      | area result    | Universitas Diponegoro (UNDIP) |
    Then user can see total kost in area with "Ditemukan 677 kos-kosan di sekitar Universitas Diponegoro (UNDIP), Jl. Prof. Soedarto No.13, Tembalang, Kec. Tembalang, Kota Semarang, Jawa Tengah 50275"
    When user click on cluster number "13" on maps
    Then user can see total kost in area with "Ditemukan 13 kos-kosan di sekitar Universitas Diponegoro (UNDIP), Jl. Prof. Soedarto No.13, Tembalang, Kec. Tembalang, Kota Semarang, Jawa Tengah 50275"
    When user click on cluster number "Rp600rb" on maps

  @SS-4387
  Scenario: [WEB]User zoom in and out map and produces >= 240 kos
    Given user go to mamikos homepage
    When user search and go to kost landing based on area:
      | search keyword | UNDIP                          |
      | area result    | Universitas Diponegoro (UNDIP) |
    When user click on "zoom in" on maps
    Then user can see total kost in area with "Ditemukan 349 kos-kosan di sekitar Universitas Diponegoro (UNDIP), Jl. Prof. Soedarto No.13, Tembalang, Kec. Tembalang, Kota Semarang, Jawa Tengah 50275"
    When user click on "zoom out" on maps
    Then user can see total kost in area with "Ditemukan 677 kos-kosan di sekitar Universitas Diponegoro (UNDIP), Jl. Prof. Soedarto No.13, Tembalang, Kec. Tembalang, Kota Semarang, Jawa Tengah 50275"
