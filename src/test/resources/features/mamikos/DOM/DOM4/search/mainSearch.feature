Feature: Main Search

  @TEST_DOM-1844 @Automated @DOM4 @Web @discovery-platform @search @search-suggest
  Scenario: [Dweb][Search]5 Suggestion List should appear
    Given user go to mamikos homepage
    When user search for random keyword:
      | search stag   | search prod|
      | semarang    | semarang   |
    Then should display the result list of keyword "semarang"

  @TEST_DOM-1853 @Automated @DOM4 @Web @discovery-platform @search @search-except-suggest
  Scenario: [Dweb][Search] Typing exception character
    Given user go to mamikos homepage
    When user search for random keyword:
      | search stag   | search prod|
      | asdfadjsade    | asdfadjsade   |
    Then should display the result exception "Tidak menemukan nama tempat / nama kost yang sesuai."

  @TEST_DOM-1849 @Automated @DOM4 @Web @discovery-platform @search @search-clear-text
  Scenario: [Dweb][Search] Reset text on searchbar
    Given user go to mamikos homepage
    When user search for random keyword:
      | search stag   | search prod|
      | jakarta    | jakarta   |
    Then user see searchbar is empty

  @TEST_DOM-1848 @Automated @DOM4 @Web @discovery-platform @search @search-auto-area
  Scenario: [Dweb][Search] Select Autocomplete for "Area"
    Given user go to mamikos homepage
    When user search for random keyword:
      | search stag   | search prod|
      | sindu    | sindu   |
    Then user click the search result based on area

  @TEST_DOM-1846 @Automated @DOM4 @Web @discovery-platform @search @search-auto-nama
  Scenario: [Dweb][Search] Select Autocomplete for "Nama"
    Given user go to mamikos homepage
    When user search property by name and select the matching result to go to kos details page
      | kost stag  | kost prod   |
      | Ran        | Ran         |
    Then user click the search result based on name

  @TEST_DOM-1871 @Automated @DOM4 @Web @discovery-platform @search @search-area-list
  Scenario: [Dweb][Search] Search Kos - Area List have correct dropdown
    Given user go to mamikos homepage
    When user clicks Search
    Then After user click City name, city name will expand and Area name listed below it.
      | Bali chevron-down | Balikpapan chevron-down         | Banyumas           | Cilegon    | Tasikmalaya |
      | Kuta               | Balikpapan Kota                | Purwokerto Barat   | Purwakarta | Cibeureum   |
      | Renon             | Balikpapan Utara                | Purwokerto Timur   | Jombang    | Tawang      |
      | Seminyak          | Balikpapan Tengah               | Purwokerto Selatan | Grogol     | Mangkubumi  |
      | Jimbaran          | Balikpapan Selatan              | Purwokerto Utara   | Citangkil  | Cihideung   |