@regression @LIMO5 @mamitour
Feature: Visit Landing Page Mamitour

  @TEST_LIMO-3693 @continue @WEB @AUTOMATED @MAMITOUR
  Scenario: [Web][Mamitour] Visit landing page mamitour from owner dashboard
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0826666666633 | 0826666666633 | qwerty123 |
    And user access mamitour from owner dashboard
    Then user redirected to mamitour landing page
    And user will see title "Simulasi keliling kos pakai MamiTour" on landing page mamitour
    And user will see title "Nikmati Manfaat MamiTour untuk Kos Anda" on landing page mamitour
    And user will see title "Lengkapi Kos dengan Virtual Tour" on landing page mamitour
    And user will see title "Proses Menggunakan MamiTour" on landing page mamitour
    And user will see title "Paket MamiTour" on landing page mamitour
    And user will see title "Tanya Jawab" on landing page mamitour
    And user will see title "Ingin tahu lebih jauh?" on landing page mamitour

#  @TEST_LIMO-3694 @WEB @AUTOMATED @MAMITOUR -> this scenario already not available
#  Scenario: [Web][Mamitour] Visit landing page mamitour from fitur promosi
#    When owner back to owner dashboard
#    And user access mamitour from fitur promosi
#    Then user redirected to mamitour landing page
#    And user will see title "Simulasi keliling kos pakai MamiTour" on landing page mamitour
#    And user will see title "Nikmati Manfaat MamiTour untuk Kos Anda" on landing page mamitour
#    And user will see title "Lengkapi Kos dengan Virtual Tour" on landing page mamitour
#    And user will see title "Proses Menggunakan MamiTour" on landing page mamitour
#    And user will see title "Paket MamiTour" on landing page mamitour
#    And user will see title "Tanya Jawab" on landing page mamitour
#    And user will see title "Ingin tahu lebih jauh?" on landing page mamitour