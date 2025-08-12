@SS @riwayatHadiah
Feature: Owner - Riwayat Hadiah [Dropped - revamp]

  @TEST_SS-3880
  Scenario: Reward List Status Success
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And user click mamipoin in owner's menu
    Then user verify MamiPoin onboarding is appear
    And user click lihat status on riwayat hadiah
    Then user see status changed to "Berhasil"
