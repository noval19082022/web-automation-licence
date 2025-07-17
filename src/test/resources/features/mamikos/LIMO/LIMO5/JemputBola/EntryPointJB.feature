@regression @LIMO5
Feature: Entry Point Jemput Bola

  @TEST_LIMO-361 @TEST_LIMO-362 @TEST_LIMO-357 @WEB @AUTOMATED @reviewLater
  Scenario Outline: Check entry point jemput bola apartment and kost mamiads on, off, full & reach daily limit
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0890910001 | 0890910001 | qwerty123 |
    And owner navigate to mamiads dashboard
    And user close mamiads onboarding popup
    Then user will see entry point jemput bola for "<ads name>"
    Examples:
      | ads name                                     |
      | Apart Exfo Mask                              |
      | Kost Test Mamiads On Agung Tanggamus         |
      | Kost Test Mamiads Off Agung Tanggamus        |
      | Kost Test Full Occupied Agung Tanggamus      |
      | Kost Test Reach Daliy Budget Agung Tanggamus |

  @TEST_LIMO-360 @WEB @AUTOMATED
  Scenario: [Web][MamiAds Dashboard][Visit Data Section] Check entry point when mamiAds saldo < 5000
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082320240417 | 082320240417 | qwerty123 |
    And owner navigate to mamiads dashboard
    And user close mamiads onboarding popup
    Then verify the saldo mamiads with condition lessThan 5000
    And user will see entry point jemput bola for "Kost AT Mamiads Insufficient Getasan Semarang"

  @TEST_LIMO-337 @WEB @AUTOMATED
  Scenario: [Web][MamiAds Dashboard][Visit Data Section] Check entry point if listing never active ads
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082220240417 | 082220240417 | qwerty123 |
    And owner navigate to mamiads dashboard
    And user close mamiads onboarding popup
    Then user will see entry point jemput bola for "Kost AT Never Active Ads Kedungjati Grobogan"

  @TEST_LIMO-352 @WEB @AUTOMATED
  Scenario: [Web][MamiAds Dashboard][Visit Data Section] Show label "baru" when owner visit this section for the first time
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082180680001 | 082180680001 | qwerty123 |
    And owner navigate to mamiads dashboard
    And user close mamiads onboarding popup
    Then user will see label baru on JB entry point is "visible"
    When user click on jemput bola entry point
    And user go back to previous page
    Then user will see label baru on JB entry point is "not visible"