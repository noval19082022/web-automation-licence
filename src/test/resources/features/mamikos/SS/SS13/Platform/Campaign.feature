@SS16 @campaigns @web
Feature: [Test-Execution][DOM] Web - Campaign

  @TEST_SS-3000 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Google Play icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user click on Google play on the footer
    And tenant set active page to 1
    Then user redirected to URL "https://play.google.com/store/apps/details?id=com.git.mami.kos&utm_campaign=DAppAndroFooter&utm_source=DownloadAppFooter&utm_medium=DownloadAppFooter&utm_term=DownloadAppFooter"

  @TEST_SS-3002 @TESTSET_UG-6228 @Automated @web-covered @SS160
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Instagram icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open instagram in footer
    And tenant set active page to 1
    Then user redirected to URL "instagram.com/"

  @TEST_SS-3003 @TESTSET_UG-6228 @Automated @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Twitter icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open twitter in footer
    And tenant set active page to 1
    Then user redirected to URL "https://x.com/mamikosapp"

  @TEST_SS-3004 @TESTSET_UG-6228 @Automated @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Facebook icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open facebook in footer
    And tenant set active page to 1
    Then user redirected to URL "https://www.facebook.com/mamikosapp"

  @TEST_SS-3005 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open tentang kami in footer
    And tenant set active page to 1
    Then user redirected to URL "https://mamikos.com/tentang-kami"

  @TEST_SS-5139 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - career
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open job mamikos in footer
    And tenant set active page to 1
    Then user redirected to URL "https://mamikos.com/career"

  @TEST_SS-5140 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - mamiads
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open promosikan kost anda in footer
    And tenant set active page to 1
    Then user redirected to URL "https://mamikos.com/mamiads"

  @TEST_SS-5141 @TEST_DOM-304 @TEST_DOM-303 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - help
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open pusat bantuan in footer
    And tenant set active page to 1
    Then user redirected to URL "https://help.mamikos.com/"

  @TEST_SS-5142 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - info
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open blog mamikos in footer
    And tenant set active page to 1
    Then user redirected to URL "https://mamikos.com/info/"

#  @TEST_SS-5143 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @web-covered
#  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - corporate
#    Given user visit page "/enaknyangekos"
#    When user is on the LandingPage EnaknyaNgekos
#    And user open sewa kost untuk perusahaan in footer
#    And tenant set active page to 1
#    Then user redirected to "https://mamikos.com/info/mamikos-corporate-accommodation/"

  @TEST_SS-5144 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - kebijakan privasi
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open kebijakan privasi in footer
    And tenant set active page to 1
    Then user redirected to URL "https://help.mamikos.com/post/kebijakan-privasi-mamikos"

  @TEST_SS-5144 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open syarat dan ketentuan in footer
    And tenant set active page to 1
    Then user redirected to URL "https://help.mamikos.com/syarat-dan-ketentuan"

  @TEST_SS-5145 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: View Content - click Cari kos Singgahsini
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open singgahsini in footer
    And tenant set active page to 1
    Then user redirected to URL "https://www.singgahsini.id/"

  @TEST_SS-3011 @TESTSET_UG-6228 @Automated @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - Scroll Page
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    Then user verify see button Mulai Cari Kos when scroll into Kenapa #EnaknyaNgekos

  @TEST_CSS-3014 @TESTSET_UG-6228 @Automated @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - click Booking Kos
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user click booking kos button
    Then user redirected to URL "/booking"

  @TEST_SS-3015 @TESTSET_UG-6228 @Automated @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - click Fitur Unggulan
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user clicks on Fitur Unggulan on the header on enaknyangekos page
    Then user will see that the text "Fitur-fitur yang kamu pakai buat #EnaknyaNgekos" is displayed

  @TEST_SS-3017 @TESTSET_UG-6228 @Automated @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - click Produk dan Layanan
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user clicks on Product dan layanan on the header on enaknyangekos page
    Then user will see that the text "Kenapa #EnaknyaNgekos?" is displayed

  @TEST_SS-3024 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Visit Page - click Mulai Cari Kos
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user clicks on Mulai Cari Kos Button on enaknyangekos page
    And tenant set active page to 1
    Then user redirected to URL "/kos/andalan"

  @TEST_SS-2991 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos] Footer - click Email Address
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open e-mail in footer
    Then user will see that the text "Halo, ada yang bisa kami bantu? Mohon isi form di bawah ini dengan lengkap." is displayed

  @TEST_SS-2986 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos] Footer - click App Store icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user want to click on App Store on the footer
    Then user redirected to URL "https://apps.apple.com/"

  @TEST_SS-2992 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos] Footer - click Whatsapp number
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open whatsapp in footer
    Then user redirected to URL "https://api.whatsapp.com/"

  @TEST_SS-2980 @TESTSET_UG-6228 @Automated @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Visit Page - Play Video
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user want to play the video on LandingPage EnaknyaNgekos
    Then user see pop up video player is shown on EnaknyaNgekos LP and can play video it