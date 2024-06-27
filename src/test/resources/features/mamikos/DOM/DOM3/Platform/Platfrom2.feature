@DOM3 @platfrom
Feature: [Test-Execution][DOM] Web - Platform
  
  @TEST_COOP-5392 @Automated @DOM3 @web-covered
  Scenario: [Test][Admin][SanJunipero] Slug name already exist
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux create new san junipero parent
    And admin bangkrupux fills all field on create new san junipero parent already exist "Automation Slug", "All_goldplus", "weekly", "Automation Tittle Tag", "Automation Tittle Header", "Automation Subtittle Header", "Akses 24 jam", "Automation FAQ", "Automation FAQ Answer"
    And admin bangkrupux check the checkbox Active on create new san junipero
    And admin bangkrupux save Sanjunipero on create new san junipero
    Then admin verify see text "The slug has already been taken."

  @TEST_COOP-5393 @Automated @DOM3 @web-covered
  Scenario: [Web][Landing Kos][Popular city] Search Time Period
    Given user go to mamikos homepage
    When user open Popular Area in Yogyakarta
    Then user should redirect to link that contains "/kost/kost-jogja-murah"

  @TEST_COOP-5394 @Automated @DOM3 @web-covered
  Scenario: [Web][Landing Kos][Popular campus] Search Kost Type
    Given user go to mamikos homepage
    When  user open Around University in UNDIP
    Then user should redirect to link that contains "/kost/kost-dekat-undip-semarang-murah"

  @TEST_COOP-5398 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Google Play icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user click on Google play on the footer
    And tenant set active page to 1
    Then user redirected to "https://play.google.com/store/apps/details?id=com.git.mami.kos&utm_campaign=DAppAndroFooter&utm_source=DownloadAppFooter&utm_medium=DownloadAppFooter&utm_term=DownloadAppFooter"

  @TEST_COOP-5399 @TESTSET_UG-4894 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Bell Notification] Bell icon - lihat semua clicked
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787342 | Perempuan |
    And owner open notification icon
    And owner wants to see all notification
    Then user redirected to "/ownerpage/notification"

  @TEST_COOP-5400 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Instagram icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open instagram in footer
    And tenant set active page to 1
    Then user redirected to "https://www.instagram.com/mamikosapp/"

  @TEST_COOP-5401@TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Twitter icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open twitter in footer
    And tenant set active page to 1
    Then user redirected to "https://x.com/mamikosapp"

  @TEST_COOP-5402 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Facebook icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open facebook in footer
    And tenant set active page to 1
    Then user redirected to "https://web.facebook.com/mamikosapp"

  @TEST_COOP-5403 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open tentang kami in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/tentang-kami"

  @TEST_COOP-5403 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open job mamikos in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/career"

  @TEST_COOP-5403 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open promosikan kost anda in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/mamiads"

  @TEST_COOP-5403 @TEST_DOM-304 @TEST_DOM-303 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open pusat bantuan in footer
    And tenant set active page to 1
    Then user redirected to "https://help.mamikos.com/"

  @TEST_COOP-5403 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open blog mamikos in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/info/"

  @TEST_COOP-5403 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open sewa kost untuk perusahaan in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/info/mamikos-corporate-accommodation/"

  @TEST_COOP-5403 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open kebijakan privasi in footer
    And tenant set active page to 1
    Then user redirected to "https://help.mamikos.com/post/kebijakan-privasi-mamikos"

  @TEST_COOP-5403 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open syarat dan ketentuan in footer
    And tenant set active page to 1
    Then user redirected to "https://help.mamikos.com/category/umum/syarat-dan-ketentuan"

  @TEST_COOP-5407 @Automated @DOM3 @web-covered
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

  @TEST_COOP-5408 @TEST_DOM-313 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Promo page] Check pagination in promo page
    Given user navigates to promo mamikos
  ## this step is comment because page https://promo.mamikos.com/ is empty
#    When user click next page button
#    Then next promo page will be opened
#    When user click previous page button
#    Then previous promo page will be opened
#    When user click page index "2"
#    Then promo page "2" will be opened

  @TEST_COOP-5409 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: View Content - click Cari kos Singgahsini
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open singgahsini in footer
    And tenant set active page to 1
    Then user redirected to "https://singgahsini.id/"

  @TEST_COOP-5410 @TESTSET_PF-1393 @Automated @DOM3 @web-covered
  Scenario Outline: [WEB Tenant][Register] error message "Penulisan alamat email salah"
    Given user go to mamikos homepage
    When user want to register as tenant
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "<Email>", "Password123", " "
    Then user will see that the text "<Error Message>" is displayed
    Examples:
      | Email             | Error Message                                  |
      | asdasd.com        | Gunakan format email seperti: mami@mamikos.com |
      | draft@xyz.com.net | Mohon masukkan email yang valid                |

  @TEST_COOP-5411 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - Scroll Page
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    Then user verify see button Mulai Cari Kos when scroll into Kenapa #EnaknyaNgekos

  @TEST_COOP-5412 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @DOM3 @web-covered
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

  @TEST_COOP-5413 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @DOM3 @web-covered
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

  @TEST_COOP-5414 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - click Booking Kos
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user click booking kos button
    Then user redirected to "/booking"

  @TEST_COOP-5415 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - click Fitur Unggulan
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user clicks on Fitur Unggulan on the header on enaknyangekos page
    Then user will see that the text "Fitur-fitur yang kamu pakai buat #EnaknyaNgekos" is displayed

  @TEST_COOP-5416 @TESTSET_PF-1393 @TESTSET_PF-1951 @Automated @DOM3 @web-covered
  Scenario: [WEB Tenant][Register] error message "Nomor handphone harus diawali dengan 08."
    Given user go to mamikos homepage
    When user want to register as tenant
    And user fills out registration form without click register "Rheza Haryo Hanggara", "666", "email@gmail.com", "Password123", " "
    Then user will see that the text "Nomor handphone harus diawali dengan 08." is displayed

  @TEST_COOP-5417 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - click Produk dan Layanan
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user clicks on Product dan layanan on the header on enaknyangekos page
    Then user will see that the text "Kenapa #EnaknyaNgekos?" is displayed

  @TEST_COOP-5418 @TESTSET_UG-4895 @TESTSET_PF-1792 @Automated @web-covered
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

  @TEST_COOP-5419 @Automated @web-covered
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

  @TEST_COOP-5420 @Automated @DOM3 @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner redirection
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787342 | Perempuan |
    And owner go to event banner section
    And owner click on banner on dari mamikos section
    Then user redirected to "https://docs.google.com/forms/d/e/1FAIpQLSdGrn3lbLwSWxdb4tJ1hVJI7qi0nYW77sVXB0YsMXaA4tORKA/viewform"

  @TEST_COOP-5421 @Automated @DOM3 @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner check content
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787342 | Perempuan |
    And owner go to event banner section
    Then user will see that the text "Dari Mamikos" is displayed

  @TEST_COOP-5422 @Automated @DOM3 @web-covered
  Scenario: [Web][Non Login][Pop Up Login] From Listing Detail Page
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                             | kost name prod               |
      | Desta Kost Tobello Tobelo Halmahera Utara  | Kos DC BAR Automation Tipe G |
    And user want to reached map section and see lihat peta button
    And user want to see more detail kost location
    Then user will see login pop up

  @TEST_COOP-5423 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario Outline: [Tenant][Password - Reg tenant]passowrd with symbol&numeric
    Given user go to mamikos homepage
    When user want to register as tenant
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "maman@gmail.com", "<Password>", " "
    Then user verify password more than 8 characters
    Examples:
      | Password   |
      | 12345!@#$% |
      | Perempuan1 |

  @TEST_COOP-5424 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Visit Page - click Mulai Cari Kos
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user clicks on Mulai Cari Kos Button on enaknyangekos page
    And tenant set active page to 1
    Then user redirected to "/kos/andalan"

  @TEST_COOP-5425 @TESTSET_UG-6249 @TESTSET_PF-1400 @TESTSET_PF-1956 @Automated @DOM3 @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner same order priority
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/event"
    And admin bangkerupux set event banner "1" to order "1"
    And admin bangkerupux updated the event banner
    Then user will see that the text "Success! Event Updated" is displayed
    And admin bangkerupux set event banner "2" to order "1"
    And admin bangkerupux updated the event banner
    Then user will see that the text "Success! Event Updated" is displayed

  @TEST_COOP-5426 @TESTSET_UG-6249 @TESTSET_PF-1400 @TESTSET_PF-1956 @Automated @DOM3 @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner different order priority
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/event"
    And admin bangkerupux set event banner "1" to order "8"
    And admin bangkerupux updated the event banner
    Then user will see that the text "Success! Event Updated" is displayed
    And admin bangkerupux set event banner "2" to order "9"
    And admin bangkerupux updated the event banner
    Then user will see that the text "Success! Event Updated" is displayed