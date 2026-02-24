@SS14 @platfrom
Feature: [Test-Execution][DOM] Web - Platform

  @TEST_SS-5137 @Automated @web-covered
  Scenario: [Test][Admin][SanJunipero] Slug name already exist
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux create new san junipero parent
    And admin bangkrupux fills all field on create new san junipero parent already exist "Automation Slug", "Goldplus_1", "weekly", "Automation Tittle Tag", "Automation Tittle Header", "Automation Subtittle Header", "Kasur", "Automation FAQ", "Automation FAQ Answer"
    And admin bangkrupux check the checkbox Active on create new san junipero
    And admin bangkrupux save Sanjunipero on create new san junipero
    Then admin verify see text "The slug has already been taken."

  @TEST_SS-5138 @Automated @web-covered
  Scenario: [Web][Landing Kos][Popular city] Search Time Period
    Given user go to mamikos homepage
    When user open Popular Area in Yogyakarta
    Then user should redirect to link that contains "/kost/kost-jogja-murah"

  @TEST_SS-4717 @Automated @web-covered
  Scenario: [Web][Landing Kos][Popular campus] Search Kost Type
    Given user go to mamikos homepage
    When  user open Around University in UNDIP
    Then user should redirect to link that contains "/kost/kost-dekat-undip-semarang-murah"

  @TEST_SS-3001 @TESTSET_UG-4894 @TESTSET_PF-1792 @Automated @web-covered
  Scenario: [Web Owner][Bell Notification] Bell icon - lihat semua clicked
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787342 | Perempuan123 |
    And owner navigates to owner dashboard
    And owner dismiss FTUE goldplus
    And owner open notification icon
    And owner wants to see all notification
    Then user redirected to "/ownerpage/notification"

  @TEST_SS-3007 @Automated @web-covered
  Scenario: [Test][Admin][SanJunipero] User able to enable certain landing page
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux deactive first sanjunipero on sanjunipero page
    Then admin bangkerupux will see last updated sanjunipero is current date
    And admin bangkerupux activate first sanjunipero on sanjunipero page
    Then admin bangkerupux will see last updated sanjunipero is current date
    And admin bangkerupux preview action kost on sanjunipero page
    Then admin can see kost list is more than 0

  @TEST_SS-3008 @TEST_DOM-313 @Automated @web-covered
  Scenario: [Tenant][Promo page] Check pagination in promo page
    Given user navigates to promo mamikos
  ## this step is comment because page https://promo.mamikos.com/ is empty
#    When user click next page button
#    Then next promo page will be opened
#    When user click previous page button
#    Then previous promo page will be opened
#    When user click page index "2"
#    Then promo page "2" will be opened

  @TEST_SS-3010 @TESTSET_PF-1393 @Automated @web-covered
  Scenario Outline: [WEB Tenant][Register] error message "Penulisan alamat email salah"
    Given user go to mamikos homepage
    When user want to register as tenant
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "<Email>", "Password123", " "
    Then user will see that the text "<Error Message>" is displayed
    Examples:
      | Email             | Error Message                                  |
      | asdasd.com        | Gunakan format email seperti: mami@mamikos.com |
      | draft@xyz.com.net | Mohon masukkan email yang valid                |

  @TEST_SS-3012 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @web-covered
  Scenario: [Test][Filter][Landing Page][SanJunipero] Check on Gender filter data kost in the landing page
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux preview action kost on sanjunipero page
    And admin open gender filter on landing
    Then user will see that the text "Campur" is displayed
    Then user will see that the text "Putra" is displayed
    Then user will see that the text "Putri" is displayed

  @TEST_SS-3013 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @web-covered
  Scenario: [Test][Filter][Landing Page][SanJunipero] Check on filter data kost in the landing page
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux preview action kost on sanjunipero page
    Then user will see that the text "Semua Tipe Kos" is displayed
    Then user will see that the text "Semua Area" is displayed
    Then user will see that the text "Paling direkomendasikan" is displayed

  @TEST_SS-3016 @TESTSET_PF-1393 @TESTSET_PF-1951 @Automated @web-covered
  Scenario: [WEB Tenant][Register] error message "Nomor handphone harus diawali dengan 08."
    Given user go to mamikos homepage
    When user want to register as tenant
    And user fills out registration form without click register "Rheza Haryo Hanggara", "666", "email@gmail.com", "Password123", " "
    Then user will see that the text "Nomor handphone harus diawali dengan 08." is displayed

  @TEST_SS-3018 @TESTSET_UG-4895 @TESTSET_PF-1792 @Automated @web-covered
  Scenario: [Tenant][Pengaturan page ]Ubah password valid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878412 | 083311231113 | qwerty123 |
    And user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "qwerty123"
    And user fills password baru "qwerty111"
    And user fills ketik ulang password "qwerty111"
    And user clicks on simpan password button
    Then user see successfully changed password "Password berhasil diubah"

  @TEST_SS-3019 @Automated @web-covered
  Scenario: [Tenant][Pengaturan page ] Restore Ubah password valid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878412 | 083311231113 | qwerty111 |
    And user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "qwerty111"
    And user fills password baru "qwerty123"
    And user fills ketik ulang password "qwerty123"
    And user clicks on simpan password button
    Then user see successfully changed password "Password berhasil diubah"

  @TEST_SS-3022 @Automated @web-covered
  Scenario: [Web][Non Login][Pop Up Login] From Listing Detail Page
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                            | kost name prod               |
      | Desta Kost Tobello Tobelo Halmahera Utara | Kos DC BAR Automation Tipe G |
    And user want to reached map section and see lihat peta button
    And user want to see more detail kost location
    Then user will see login pop up

  @TEST_SS-3023 @TESTSET_PF-1792 @Automated @web-covered
  Scenario Outline: [Tenant][Password - Reg tenant]passowrd with symbol&numeric
    Given user go to mamikos homepage
    When user want to register as tenant
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "maman@gmail.com", "<Password>", " "
    Then user verify password more than 8 characters
    Examples:
      | Password   |
      | 12345!@#$% |
      | Perempuan1 |