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
