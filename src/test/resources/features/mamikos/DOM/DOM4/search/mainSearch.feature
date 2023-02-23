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
      | Kuta              | Balikpapan Kota                 | Purwokerto Barat   | Purwakarta | Cibeureum   |
      | Renon             | Balikpapan Utara                | Purwokerto Timur   | Jombang    | Tawang      |
      | Seminyak          | Balikpapan Tengah               | Purwokerto Selatan | Grogol     | Mangkubumi  |
      | Jimbaran          | Balikpapan Selatan              | Purwokerto Utara   | Citangkil  | Cihideung   |

  @TEST_DOM-1869 @Automated @DOM4 @Web @discovery-platform @search @search-pupular-list
  Scenario: [Dweb][Search] Search Kos - Popular area have correct city
    Given user go to mamikos homepage
    When user clicks Search
    Then under popular search, there's this city :
      | city stag       | city prod      |
      | Yogyakarta      | Yogyakarta     |
      | Jakarta         | Jakarta        |
      | Bandung         | Bandung        |
      | Surabaya        | Surabaya       |
      | Jakarta Selatan | Jakarta Selatan |
      | Malang          | Malang         |
      | Semarang        | Semarang       |
      | Makassar        | Makassar       |
      | Medan           | Medan          |

  @TEST_DOM-1862 @Automated @DOM4 @Web @discovery-platform @search @search-popular-city
  Scenario: [Dweb][Search] Search Kos in popular area have correct search result
    Given user go to mamikos homepage
    When user clicks Search
    Then under popular search, there's this city :
      | city stag      | city prod      |
      | Malang         | Malang         |
    Then listing that appear have location
      | city stag      | city prod      |
      | Malang         | Malang         |

  @TEST_DOM-1862 @Automated @DOM4 @Web @discovery-platform @search @search-popular-city
  Scenario: [Dweb][Search] Search Kos in popular area have correct search result
    Given user go to mamikos homepage
    When user clicks Search
    And user click area city
      | city stag           | city prod      |
      | Bali chevron-down   | Bali           |
    Then under area city click
      | city stag      | city prod      |
      | Kuta           | Seminyak       |


  @TEST_DOM-1860 @Automated @DOM4 @Web @discovery-platform @search @search-check-appearance-apartment
  Scenario Outline: [Dweb][Search] Check appearance of Apartemen property on listing with keyword city
    Given user go to mamikos homepage
    When user search for random keyword:"<city>"
    Then listing that appear have no "Apartemen" property
    Examples:
      | city            |
      | Jakarta         |
      | Jakarta Selatan |
      | Surabaya        |
      | Bandung         |
      | Yogyakarta      |
      | Jakarta Pusat   |
      | Semarang        |
      | Jakarta Barat   |
      | Malang          |
      | UGM             |
      | Tebet           |
      | Kontrakan       |
      | Bekasi          |
      | UNDIP           |

  @TEST_DOM-1858 @Automated @DOM4 @Web @discovery-platform @search @search-result
  Scenario: [Dweb][Search] Check search result
    Given user go to mamikos homepage
    When user clicks Search
    Then title listing that appear have location in "Malang"

   @TEST_DOM-1864 @Automated @DOM4 @Web @discovery-platform @search @search-popular-campus-list
  Scenario: [Dweb][Search] Search Kos - Popular campus
    Given user go to mamikos homepage
    When user click search area based on campus
    Then user verify popular campus
      | campus stag      |campus prod      |
      | UGM              |UGM              |
      | UNPAD Jatinangor |UNPAD Jatinangor |
      | STAN Jakarta     |STAN Jakarta     |
      | UNAIR            |UNAIR            |
      | UB               |UB               |
      | UNY              |UNY              |
      | UI               |UI               |
      | UNDIP            |UNDIP            |
      | ITB              |ITB              |
      | UMY              |UMY              |

  @TEST_DOM-1863 @Automated @DOM4 @Web @discovery-platform @search @search-campus-city
  Scenario: [Dweb][Search]Search Kos - Campus Lists By City
    Given user go to mamikos homepage
    When user click search area based on campus
    Then user verify campus lists by cities
      | Bali chevron-down | Jakarta Pusat chevron-down    |
      | Undiksha          | UI Salemba                    |


  @TEST_DOM-1856 @Automated @DOM4 @Web @discovery-platform @search @search-popular-campus-result
  Scenario: [Dweb][Search]Search Kos - Popular campus result
    Given user go to mamikos homepage
    When user click search area based on campus
    And user click button kampus
      | campus stag      |campus prod      |
      | UNDIP            | UNDIP           |
    Then title listing that appear have location campus in "Semarang"








