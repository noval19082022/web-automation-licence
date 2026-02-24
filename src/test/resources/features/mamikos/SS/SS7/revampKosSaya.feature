@regression @mauCobaDong @SS6
Feature: Revamp kos saya

  @mauCobaDong @TEST_COOP-1068
  Scenario: click Mau Coba Dong at homepage
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220230101 | 08100000622 | qwerty123 |
    And user click Mau Coba Dong section at homepage
#    Then user will see kos saya is still empty