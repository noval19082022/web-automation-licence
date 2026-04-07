@LIMO2
Feature: Show Paid Product Section (Gold Plus)

  @TEST_LIMO-10671
  Scenario: [Owner][OD][GP] Non GP owner sees GoldPlus entry point and can subscribe
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "082233545506"

    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 082233545506 | 0          | qwerty123 |
    And user click daftar GP button
    And user click "Pilih Paket GoldPlus" button
    Then user will see that the text "Manfaat GoldPlus 1" is displayed
    Then user will see that the text "Manfaat GoldPlus 2" is displayed

  @TEST_LIMO-10672
  Scenario: [Owner][OD][GP] Non GP owner with GPSP eligibility sees special price offer
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
    And user click "Pilih Paket GoldPlus" button
    Then user will see that the text "Manfaat GoldPlus 1" is displayed
    Then user will see that the text "Manfaat GoldPlus 2" is displayed