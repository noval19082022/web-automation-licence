@DOM3
Feature: [Test-Execution][DOM] Web - Platform

  @TEST_DOM-400 @Automated @DOM3 @web-covered
  Scenario: [Web][Apartement] Positive Case Tenant Filter Apartment by Time Period
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user filter apartment by time period is "Harian"
    Then user see displays apartment lists by time period is "hari"

		#  Scenario: Positive case tenant filter apartment by time period "Mingguan"
    When user filter apartment by time period is "Mingguan"
    Then user see displays apartment lists by time period is "minggu"

		#  Scenario: Positive case tenant filter apartment by time period "Bulanan"
    When user filter apartment by time period is "Bulanan"
    Then user see displays apartment lists by time period is "bulan"

		#  Scenario: Positive case tenant filter apartment by time period "Tahunan"
    When user filter apartment by time period is "Tahunan"
    Then user see displays apartment lists by time period is "tahun"

  @TEST_DOM-398 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @DOM3 @web-covered
  Scenario: [Test][Admin][SanJunipero] Create New Parent Using Virtual Tour, Allgoldplus. and Mami Checker Kost Type
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux create new san junipero parent
    And admin bangkrupux fills all field on create new san junipero parent "Automation Slug", "All_goldplus", "weekly", "Automation Tittle Tag", "Automation Tittle Header", "Automation Subtittle Header", "Akses 24 jam", "Automation FAQ", "Automation FAQ Answer"
    And admin bangkrupux check the checkbox Active on create new san junipero
    And admin bangkrupux save Sanjunipero on create new san junipero
    Then admin bangkerupux verify success create new sanjunipero "Success! Record success to saved."

  @TEST_DOM-399 @Automated @DOM3 @web-covered
  Scenario: [Web][Apartement] Positive case tenant search apartment by Area
    Given user go to mamikos homepage
    When user go to landing apartment
    Then user redirected to "/apartemen"
    And user search "Bandung" on landing apartment
    Then user will see displays apartment lists by area and city
      | Coblong       |
      | Sumur Bandung |
      | Coblong       |
      | Coblong       |
      | Coblong       |
      | Coblong       |
      | Sumur Bandung |
      | Bandung       |

  @TEST_DOM-397 @Automated @DOM3 @web-covered
  Scenario: [Web][Landing Kos][Popular city] Search Another Category
    Given user go to mamikos homepage
    When user visit search page, and visit popular search based on "Area" for location on "Yogyakarta"
    Then user can see kost list is more than 10

  @TEST_DOM-396 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][FB - Tennat login page]Login with FB
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                          | email prod                          | password    |
      | lingga_ccabvrn_marqansyah@tfbnw.net | lingga_ccabvrn_marqansyah@tfbnw.net | joinmamikos |
    Then navbar after login appears

  @TEST_DOM-395 @Automated @DOM3 @web-covered
  Scenario: [Web][Apartement] Positive Case Tenant Filter Apartment by Furniture
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user filter apartment by furniture is "Furnished"
    Then user see displays apartment lists by furniture is "Furnished"

		#  Scenario: Positive case tenant search apartment filter by furniture "Semi Furnished"
    When user filter apartment by furniture is "Semi Furnished"
    Then user see displays apartment lists by furniture is "Semi Furnished"

		#  Scenario: Positive case tenant search apartment filter by furniture "Not furnished"
    When user filter apartment by furniture is "Not furnished"
    Then user see displays apartment lists by furniture is "Not Furnished"

  @TEST_DOM-393 @Automated @DOM3 @web-covered
  Scenario: [Web][Apartement] Positive Case Tenant Sort Apartment by Price
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user filter apartment by price direction is "Acak"
    Then user see displays apartment lists by price direction is "Acak"

		#  Scenario: Positive case tenant sort the list of apartments from the cheapest
    When user filter apartment by price direction is "Harga Termurah"
    Then user see displays apartment lists by price direction is "Harga Termurah"

		#  Scenario: Positive case tenant sort the list of apartments most expensive
    When user filter apartment by price direction is "Harga Termahal"
    Then user see displays apartment lists by price direction is "Harga Termahal"

  @TEST_DOM-391 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Visit Page - Play Video
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user want to play the video on LandingPage EnaknyaNgekos
    Then user see pop up video player is shown on EnaknyaNgekos LP and can play video it

  @TEST_DOM-390 @Automated @DOM3 @web-covered
  Scenario: [Web][Apartement] Positive Case Tenant Filter Apartment by Unit Type
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user filter apartment by unit type is "1-Room Studio"
    Then user see apartment lists by unit type is "1-Room Studio"

		#  Scenario: Positive case tenant search apartment filter by unit type "1 BR"
    When user filter apartment by unit type is "1 BR"
    Then user see apartment lists by unit type is "1 BR"

		#  Scenario: Positive case tenant search apartment filter by unit type "2 BR"
    When user filter apartment by unit type is "2 BR"
    Then user see apartment lists by unit type is "2 BR"

		#  Scenario: Positive case tenant search apartment filter by unit type "3 BR"
    When user filter apartment by unit type is "3 BR"
    Then user see apartment lists by unit type is "3 BR"

		#  Scenario: Positive case tenant search apartment filter by unit type "4 BR"
    When user filter apartment by unit type is "4 BR"
    Then user see apartment lists by unit type is "4 BR"

  @TEST_DOM-388 @Automated @DOM3 @web-covered
  Scenario: [Web][Apartement] Login as Tenant Can View Profile Picture and Option Dropdown Menu Profile
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                              | email prod                              | password  |
      | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | mamikosqa |
    Then tenant can see profile dropdown option
