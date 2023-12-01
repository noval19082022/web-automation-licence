@regression @LIMO1 @TEST_LIMO-3650
Feature: Visit Landing Page Mamitour

  @continue
  Scenario: [Web][Mamitour] Visit landing page mamitour from owner dashboard
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0826666666633 | 0826666666633 | qwerty123    |
    And user access mamitour from owner dashboard
    Then user redirected to mamitour landing page
    And user will see that the text "Simulasi keliling kos pakai MamiTour" is displayed
    And user will see that the text "Nikmati Manfaat MamiTour untuk Kos Anda" is displayed
    And user will see that the text "Lengkapi Kos dengan Virtual Tour" is displayed
    And user will see that the text "Proses Menggunakan MamiTour" is displayed
    And user will see that the text "Paket MamiTour" is displayed
    And user will see that the text "Tanya Jawab" is displayed
    And user will see that the text "Ingin tahu lebih jauh?" is displayed

  Scenario: [Web][Mamitour] Visit landing page mamitour from fitur promosi
    When owner back to owner dashboard
    And user access mamitour from fitur promosi
    Then user redirected to mamitour landing page
    And user will see that the text "Simulasi keliling kos pakai MamiTour" is displayed
    And user will see that the text "Nikmati Manfaat MamiTour untuk Kos Anda" is displayed
    And user will see that the text "Lengkapi Kos dengan Virtual Tour" is displayed
    And user will see that the text "Proses Menggunakan MamiTour" is displayed
    And user will see that the text "Paket MamiTour" is displayed
    And user will see that the text "Tanya Jawab" is displayed
    And user will see that the text "Ingin tahu lebih jauh?" is displayed
