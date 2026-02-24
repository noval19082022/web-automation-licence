@SS14 @platfrom @PLATFORM_SEARCH_MIGRATE
Feature: [Test-Execution][DOM] Web - Platform

  @TEST_SS-2974 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @web-covered
  Scenario: [Test][Admin][SanJunipero] Create New Parent Using Virtual Tour, Allgoldplus. and Mami Checker Kost Type
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux create new san junipero parent
    And admin bangkrupux fills all field on create new san junipero parent "Automation Slug", "Goldplus_1", "weekly", "Automation Tittle Tag", "Automation Tittle Header", "Automation Subtittle Header", "Kasur", "Automation FAQ", "Automation FAQ Answer"
    And admin bangkrupux check the checkbox Active on create new san junipero
    And admin bangkrupux save Sanjunipero on create new san junipero
    Then admin bangkerupux verify success create new sanjunipero "Success! Record success to saved."

  @TEST_SS-2976 @Automated @web-covered
  Scenario: [Web][Landing Kos][Popular city] Search Another Category
    Given user go to mamikos homepage
    When user visit search page, and visit popular search based on "Area" for location on "Yogyakarta"
    Then user can see kost list is more than 10

  @TEST_SS-2977 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @web-covered
  Scenario: [Tenant][FB - Tennat login page]Login with FB
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag          | email prod          | password           |
      | ncihuciha@gmail.com | ncihuciha@gmail.com | mamikosJAYAJAYA999 |
    Then navbar after login appears

  @TEST_SS-2993 @Automated @web-covered
  Scenario: [Web][Pop up login] Tenant - Click Maps
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                                 | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-desta-kost-tobello-tobelo-halmahera-utara | Kos DC BAR Automation Tipe G |
    Then user want to reached map section and see lihat peta button
    When user want to see more detail kost location
    And user click back button in login page
    And user want to report this kos
    Then user will see login pop up

  @TEST_SS-2994 @TESTSET_UG-4895 @TESTSET_PF-1792 @Automated @web-covered
  Scenario: [Tenant][Pengaturan page  - Change password]hidden for login social
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag          | email prod          | password           |
      | ncihuciha@gmail.com | ncihuciha@gmail.com | mamikosJAYAJAYA999 |
    And user visit page "/user/pengaturan"
    Then user should not be able to see the text "Ubah Password"

  @TEST_SS-5134 @Automated @web-covered
  Scenario: [Login][Owner] Login From Detail Page
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                                 | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-desta-kost-tobello-tobelo-halmahera-utara | Kos DC BAR Automation Tipe G |
    And user want to reached map section and see lihat peta button
    And user want to see more detail kost location
    Then user will see login pop up

  @TEST_SS-5135 @Automated @web-covered
  Scenario: [Web][login]: Tenant - Can see maps
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant redirect to kost details:
      | kost path stag                                                                                 | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-desta-kost-tobello-tobelo-halmahera-utara | Kos DC BAR Automation Tipe G |
    And user want to reached map section and see tanya alamat lengkap button
    Then user want to ask kost address

  @TEST_SS-2996 @Automated @web-covered
  Scenario: [Test][Landing Page][SanJunipero] Check room list
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag              | email prod              | password  |
      | uncle.coop1@mamikos.com | uncle.coop1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux preview action kost on sanjunipero page
    Then admin can see kost list is more than 0

  @TEST_SS-2997 @Automated @web-covered
  Scenario: [Web][Owner] Choose Add New Kos
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787343 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    Then user redirected to "https://owner-jambu.kerupux.com/kos/create?step=1"

  @TEST_SS-5136 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @web-covered
  Scenario: [Test][Admin][SanJunipero] User able to activate or deactivate certain landing page
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag              | email prod              | password  |
      | uncle.coop1@mamikos.com | uncle.coop1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux deactive first sanjunipero on sanjunipero page
    Then admin bangkerupux will see last updated sanjunipero is current date
    And admin bangkerupux activate first sanjunipero on sanjunipero page
    Then admin bangkerupux will see last updated sanjunipero is current date

  @TEST_SS-2998 @Automated @web-covered
  Scenario: [Web][non login]: Login pop-up options appear
    Given user go to mamikos homepage
    When user visit page "/room/kost-kabupaten-halmahera-utara-kost-campur-eksklusif-desta-kost-tobello-tobelo-halmahera-utara"
    And user want to reached map section and see lihat peta button
    And user want to see more detail kost location
    Then user will see login pop up

  @TEST_SS-2999 @TESTSET_UG-6221 @TESTSET_PF-1792 @Automated @web-covered
  Scenario: [Web][Login][Pop Up Login] From Listing Detail Page
    Given user go to mamikos homepage
    When user visit page "/room/kost-sleman-kost-campur-murah-kost-apik-desta-tipe-b-tamvan-2"
    Then user want to reached map section and see lihat peta button

