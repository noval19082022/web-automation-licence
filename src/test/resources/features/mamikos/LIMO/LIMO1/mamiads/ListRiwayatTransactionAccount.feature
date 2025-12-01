@regression @LIMO1
Feature: List Riwayat Transaction Account

  @TEST_LIMO-1380
  Scenario: List Riwayat Transaction Account - Empty
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 085720962106 | qwerty123 |
    And user navigate to mamiads history page
    And user will see title and message on Dalam Proses tab
    And user click "Selesai"
    Then user will see title and message on Selesai tab

  @TEST_LIMO-1401
  Scenario: To make sure red counter badge if owner have on going transaction
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0895365624343 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user verify count of riwayat before beli saldo
    And user open the invoice mamiads if invoice already maximal on riwayat
    And user wants to buy saldo MamiAds "6.000"
    And user navigates to mamiads dashboard
    Then user verify count of riwayat added 1

  @TEST_LIMO-1500
  Scenario: red counter badge if all transaction is complete
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod    | password  |
      | 0891202413 | 0895365624343 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user wants to buy saldo MamiAds "6.000"
    And user navigates to mamiads dashboard
    And user verify count of riwayat before beli saldo
    And user open the invoice mamiads if invoice already maximal on riwayat
    Then user verify count of riwayat added 0
    And user click "Riwayat"
    And user continue payment buy saldo mamiads
    And owner set active page to 1
    And payment user success using ovo as payment method
    And owner set active page to 0
    And user navigates to mamiads dashboard
    Then user will see that the text "Saldo MamiAds" is displayed