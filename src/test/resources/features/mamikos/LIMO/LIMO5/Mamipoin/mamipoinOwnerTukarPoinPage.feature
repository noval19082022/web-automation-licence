@listing-monetization @mamipoinOwnerEntryPoint @mamipoinOwner
Feature: [Owner Dashboard]MamiPoin Owner Tukar Poin Page

  @TEST_LIMO-2012 @Automated @Web @listing-monetization @mamipoin-owner
  Scenario: [Owner Dashboard]MamiPoin Owner Tukar Poin Page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password     |
      | 08776633551 | 0          | mamikosqa123 |
    And user click mamipoin in owner's menu
    Then user verify MamiPoin onboarding is appear
    When user clicks on tukar poin button
    Then user verify tukar poin onboarding is appear
    And user verify title in the tukar poin page is displayed
    And user verify logo in the tukar poin page is displayed
    And user verify the amount of MamiPoin Anda is "123.456 Poin"
    And user verify bantuan button is displayed