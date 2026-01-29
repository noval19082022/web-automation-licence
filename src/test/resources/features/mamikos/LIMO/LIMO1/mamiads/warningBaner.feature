@LIMO1 @warningBannerMamiads
Feature: Warning Bannner Mamiads

  @TEST_LIMO-8287 @continue
  Scenario: [Web][Info Warning Banner] Warning banner appears when user visits "MamiAds > Iklan Saya" page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0826666666633 | 0826666666633 | qwerty123 |
   # And user click on Saldo MamiAds at owner dashboard
    And user navigates to mamiads dashboard
    And user click coba sekarang header
    And user close mamiads onboarding popup
    Then user will see that the text "MamiAds hanya untuk menaikkan posisi iklan dengan biaya per klik." is displayed
    And user will see that the text "Lihat Info lanjut" is displayed

  @TEST_LIMO-8288 @continue
  Scenario: [Web][Info Warning Banner] Warning banner still appears on page reload
    Given owner refresh page 0
    Then user will see that the text "MamiAds hanya untuk menaikkan posisi iklan dengan biaya per klik." is displayed
    And user will see that the text "Lihat Info lanjut" is displayed

  @TEST_LIMO-8289 @continue
  Scenario: [Web][Info Warning Banner] The banner does not cover other important elements on the page.
    Then user see waning banner mamiads is exist

  @TEST_LIMO-8291 @continue
  Scenario: [Web][Info Warning Banner] Banner can be closed permanently by clicking the "X" button.
    And user close mamiads warning banner
    And owner refresh page 0
    Then owner should not be able to see the text "MamiAds hanya untuk menaikkan posisi iklan dengan biaya per klik."
    Then user see waning banner mamiads is not exist

  @TEST_LIMO-8297 @continue
  Scenario: [Web][Info Warning Banner] Banner reappears after user re-logins and reinstalling the app
    Given owner should successfully log out
    * user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0826666666633 | 0826666666633 | qwerty123 |
   # And user click on Saldo MamiAds at owner dashboard
    And user navigates to mamiads dashboard
    And user click coba sekarang header
    Then user will see that the text "MamiAds hanya untuk menaikkan posisi iklan dengan biaya per klik." is displayed
    And user will see that the text "Lihat Info lanjut" is displayed
    Then user see waning banner mamiads is exist

  @TEST_LIMO-8292
  Scenario: [Web][Info Warning Banner] Redirect to mamihelp if user click CTA “Lihat Info Lanjut“
    And user click on Lihat Info Lanjut mamiads warning banner
    And owner set active page to 1
    Then user will see that the text "Apa itu MamiAds?" is displayed

