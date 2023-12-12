@LIMO4 @regression
Feature: Entry point Tenant Background Checker

  @TEST_LIMO-4842 @entrypointTBC @continue
  Scenario: [WEB][Chat Owner] Show Tenant Background Checker entry point upon accessing a chat room
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod | password  |
      | 0812345670001 | 0          | qwerty123 |
    * user click chat button in top bar owner home page
    Then owner can see entry point TBC Lihat Profil at chatroom "Rega Tenant Tiga"

  @TEST_LIMO-4843 @entrypointTBC
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