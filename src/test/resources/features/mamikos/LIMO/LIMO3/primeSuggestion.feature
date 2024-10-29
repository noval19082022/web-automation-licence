@LIMO3 @PrimeSuggestion
Feature: Prime Suggestion

  @TEST_LIMO-4569 @maintelimo3
  Scenario: [WEB][Prime Sugestion] Display "Rekomendasi buat Kamu" for prime keyword search
    Given user go to mamikos homepage
    When user want to visit search page from homepage
    And user type to search kost with keywords "sleman"
    Then user verify see kost name "MAMAHMUDALIMO Pinolosian Tengah Bolaang Mongondow Selatan" in suggestion prime list

  @TEST_LIMO-4569
  Scenario: [WEB][Prime Suggestion] Display "Nama Kost Terkait" for non-prime keyword search
    Given user go to mamikos homepage
    When user want to visit search page from homepage
    And user type to search kost with keywords "Jakarta Type B"
    Then user verify see kost name "Jakarta Type B" is not exist in suggestion prime list
    Then user verify see kost name "Jakarta Type B" in suggestion nama kost terkait list

  @TEST_LIMO-4573
  Scenario: [WEB][Prime Suggestion] Kost is display on "Nama Kost Terkait" when assign as prime keyword and status active
    Given user go to mamikos homepage
    When user want to visit search page from homepage
    And user type to search kost with keywords "jakarta type"
    Then user will see that the text "Jakarta Type A Menteng Jakarta Pusat" is displayed
    Then user verify see kost name "Jakarta Type A Menteng Jakarta Pusat" in suggestion prime list
    Then user verify see kost name "Jakarta Type A Menteng Jakarta Pusat" in suggestion nama kost terkait list
