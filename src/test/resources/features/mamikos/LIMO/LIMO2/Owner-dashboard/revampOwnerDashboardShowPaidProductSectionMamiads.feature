@LIMO2
Feature: Show Paid Product Section (Mamiads)

  @TEST_LIMO-10679
  Scenario: [Owner][OD][MA] New owner sees MamiAds entry point and behavior
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 081597877123 | 0          | qwerty123 |
    Then user will see that the text "Beli saldo, banyak pilihan & diskon!" is displayed


