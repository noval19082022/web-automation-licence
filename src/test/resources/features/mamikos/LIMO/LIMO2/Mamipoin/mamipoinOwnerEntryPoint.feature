@listing-monetization @regression @LIMO2 @mamipoinOwnerEntryPoint @mamipoinOwner
Feature: MamiPoin Owner Entry Point

  @TEST_LIMO-2009 @Automated @Web @listing-monetization @mamipoin-owner
  Scenario: [Owner Dashboard] MamiPoin Owner FTUE for new user and point = 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 083188636012 | 0          | qwerty123 |
    And user verify mamipoin on widget < 1
    And owner will see that the text "Pelajari" is displayed
    And user click mamipoin in owner's menu
    And user go back to previous page
    And user verify mamipoin on widget < 1
    And owner should not be able to see the text "Pelajari"

  @TEST_LIMO-2010 @Automated @Web @listing-monetization @mamipoin-owner
  Scenario: [Owner Dashboard] MamiPoin Owner FTUE for new user and point >= 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 083161237683 | 0          | qwerty123 |
    And user verify mamipoin on widget > 0
    And owner will see that the text "Tukar Poin" is displayed
    And user click mamipoin in owner's menu
    And user go back to previous page
    And user verify mamipoin on widget > 0
    And owner should not be able to see the text "Tukar Poin"
