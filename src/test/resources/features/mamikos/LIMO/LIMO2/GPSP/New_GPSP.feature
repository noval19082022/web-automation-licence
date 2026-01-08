@LIMO2 @GpspNewOwner
Feature: GPSP Exposure on OD


#  081597877123/qwerty123
  @TEST_LIMO-9300 @TEST_LIMO-9301 @TEST_LIMO-9302 @TEST_LIMO-9303 @TEST_LIMO-9305 @TEST_LIMO-9308
  Scenario: [Owner][GPSP][OD] Display correct GP card variant for each segment
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 081597877123 | 0          | qwerty123 |
    Then owner will see that the text "Khusus Pengguna Baru" is displayed
    And owner will see that the text "Tawaran berakhir dalam" is displayed
    And owner see GPSP promo countdown
    And owner check countdown value running
    Then owner wants to accses dashboard GP
    And Owner see gp onboarding pop up is exist

  @TEST-LIMO-9299
  Scenario: [Owner][GPSP][OD] Override display for active GP subscription
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08159787775 | 0          | qwerty123 |
    Then owner check no countdown value running
