@regression @LIMO1
Feature: Panduan MamiAds


  @TEST_LIMO-286
  Scenario: Open Owner Non GP learn about MamiAds from "MamiAds" screen
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 0819999999934 | 0          | qwerty123 |
    When user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user click "Pelajari di Sini"
    Then user redirected to guides page mamiAds
#  Scenario: [Mamiads dashboard][Panduan Mamiads]: View "Panduan Mamiads" screen 4637
    And user will see that the text "Naikkan Posisi Iklan Properti dengan MamiAds" is displayed


