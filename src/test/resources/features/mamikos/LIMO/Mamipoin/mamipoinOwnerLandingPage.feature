@listing-monetization @mamipoinOwnerEntryPoint @mamipoinOwner
Feature: [Owner Dashboard] MamiPoin Owner Landing Page

  @TEST_LIMO-2011 @Automated @Web @listing-monetization @mamipoin-owner
  Scenario: [Owner Dashboard] MamiPoin Owner Landing Page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 083188636012| 0          | qwerty123 |
    And user click mamipoin in owner's menu
    Then user verify MamiPoin onboarding is appear
    And user verify title in the mamipoin owner landing page is displayed
    And user verify tukar poin button is displayed
    And user verify riwayat hadiah button is displayed
    And user verify riwayat poin owner button is displayed
    And user verify syarat dan ketentuan button is displayed