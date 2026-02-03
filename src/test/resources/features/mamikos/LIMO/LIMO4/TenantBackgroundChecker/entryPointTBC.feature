@LIMO5 @regression
Feature: Entry Point Tenant Background Checker

  @TEST_LIMO-327 @TEST_LIMO-328  @entrypointTBC @WEB @AUTOMATED
  Scenario: [WEB][Chat] Show Tenant Background Checker onboarding (coachmark) and entry point upon section upon accessing a chat room
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0891202409    | 0          | qwerty123 |
    And owner Navigasi ke Chat List
    And owner open chatroom "Rega Tenant" without close FTUE

    # first time
    And owner can see coachmark tenant background checker
    When owner click "Saya Mengerti"
    Then coachmark is closed

    # open chatroom second time without close
    When owner navigates to owner dashboard
    * user click chat button in top bar owner home page
    Then owner can see entry point TBC Lihat Profil second time at chatroom "Rega Tenant"

  @TEST_LIMO-3703 @WEB @AUTOMATED
  Scenario: [Web][Chat Tenant] Entry point tenant background checker not show
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod | password     |
      | 0891111020199 | 0          | mamikosqa123 |
    And user click on chat button in top bar tenant home page
    Then tenant can't see entry point TBC Lihat Profil at chatroom order "1"