@LIMO5 @regression
Feature: Entry Point Tenant Background Checker

  @TEST_LIMO-328 @entrypointTBC @continue @WEB @AUTOMATED
  Scenario: [WEB][Chat Owner] Show Tenant Background Checker entry point upon accessing a chat room
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod | password  |
      | 0812345670001 | 0          | qwerty123 |
    And owner wants to accsess chatroom
    Then owner can see entry point TBC Lihat Profil at chatroom "Noval Abis Delete"

  @TEST_LIMO-327 @entrypointTBC @WEB @AUTOMATED
  Scenario: [WEB][Chat] Show Tenant Background Checker onboarding (coachmark) section upon accessing a chat room
    # first time
    And owner can see coachmark tenant background checker
    When owner click "Saya Mengerti"
    Then coachmark is closed

    # open chatroom second time
    When owner navigates to owner dashboard
    * user click chat button in top bar owner home page
    Then owner can see entry point TBC Lihat Profil second time at chatroom "Rega Tenant Tiga"
    And coachmark is closed

  @TEST_LIMO-3703 @WEB @AUTOMATED
  Scenario: [Web][Chat Tenant] Entry point tenant background checker not show
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag      | phone prod  | password     |
      | 0891111020199   | 0           | mamikosqa123 |
    And user click on chat button in top bar tenant home page
    Then tenant can't see entry point TBC Lihat Profil at chatroom "Kost General Irvi Automation"