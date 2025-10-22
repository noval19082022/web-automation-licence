@LIMO2 @regression
Feature: Display GPSP on Chat List

  @TEST_LIMO-9265 @GP-entry-point @chat-list @goldplus
  Scenario: Owner observe GP entry point in Chat List
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202533 | 081362464341 | qwerty123 |
    And user Navigasi ke Chat List
    Then user observe GP entry point display
    And Countdown timer appears
    And Price displayed: "Mulai Rp50ribu/bulan"
    And Copy text "Paket murah untuk interaksi lancar dengan calon penyewa! Coba sekarang"

  @TEST_LIMO-9267 @countdown-value-running @chat-list @goldplus
  Scenario: Countdown Timer Synchronization
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202533 | 081362464341 | qwerty123 |
    And user Navigasi ke Chat List
    Then user check countdown value running

  @TEST_LIMO-9268 @countdown-realTime-update @chat-list @goldplus
  Scenario: Real-time Countdown Update
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202533 | 081362464341 | qwerty123 |
    And user Navigasi ke Chat List
    And owner refresh page 0
    And user click chat button in top bar owner home page
    Then user check countdown value running

  @TEST_LIMO-9269 @countdownReturningFromOtherPages @chat-list @goldplus
  Scenario: Check Countdown After Returning from Other Pages
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202533 | 081362464341 | qwerty123 |
    And owner navigates to Akun menu
    And owner back to owner dashboard
    And user Navigasi ke Chat List
    Then user check countdown value running

  @TEST_LIMO-9270 @nonEligibleSegments @chat-list @goldplus
  Scenario: Display for Non-Eligible Segments
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202532 | 081362464341 | qwerty123 |
    And user Navigasi ke Chat List
    Then user check no countdown value running

  @TEST_LIMO-9271
  Scenario: On Pilih paket adjust the design label “Yuk coba, lagi promo”
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202533 | 081362464341 | qwerty123 |
    And owner navigate to list goldplus package
    Then user will see that the text "Yuk coba, lagi promo" is displayed

  @TEST_LIMO-9272
  Scenario: If unpaid invoice still displays a countdown on "pilih paket" GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202533 | 081362464341 | qwerty123 |
    And owner navigate to list goldplus package
    Then user check countdown value running