@regression @LIMO1
Feature: List Riwayat Transaction Account

  @TEST_LIMO-276
  Scenario: List Riwayat Transaction Account - Empty
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 085720962106  | qwerty123 |
    And user navigate to mamiads history page
    And user will see title and message on Dalam Proses tab
    And user click "Selesai"
    Then user will see title and message on Selesai tab

  @TEST_LIMO-59
  Scenario: To make sure red counter badge if owner have on going transaction
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 083176408449  | 0895365624343 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user verify count of riwayat before beli saldo
    And user open the invoice mamiads if invoice already maximal on riwayat
    And user wants to buy saldo MamiAds "6.000"
    And user navigates to mamiads dashboard
    Then user verify count of riwayat added 1