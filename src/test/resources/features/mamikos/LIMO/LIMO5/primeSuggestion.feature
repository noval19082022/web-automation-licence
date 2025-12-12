@LIMO3 @PrimeSuggestion @maintelimo3
Feature: Prime Suggestion

  @TEST_LIMO-4569
  Scenario: [WEB][Prime Sugestion] Display "Rekomendasi buat Kamu" for prime keyword search
    Given user go to mamikos homepage
    When user want to visit search page from homepage
    And user type to search kost with keywords "sleman"
    Then user verify see kost name "MAMAHMUDALIMO Pinolosian Tengah Bolaang Mongondow Selatan" in suggestion prime list

  @TEST_LIMO-4569
  Scenario: [WEB][Prime Suggestion] Display "Nama Kost Terkait" for non-prime keyword search
    Given user go to mamikos homepage
    When user want to visit search page from homepage
    And user type to search kost with keywords "bekasi"
    Then user can not see any prime suggestion list
    Then user verify see kost name "Kost Shireen Bekasi Timur Bekasi" in suggestion nama kost terkait list

  @TEST_LIMO-4573
  Scenario: [WEB][Prime Suggestion] Kost is display on "Nama Kost Terkait" when assign as prime keyword and status active
    Given user go to mamikos homepage
    When user want to visit search page from homepage
    And user type to search kost with keywords "tangerang"
    Then user will see that the text "Kos QuQu 88 Rajeg Tangerang" is displayed
    Then user verify see kost name "Kos QuQu 88 Rajeg Tangerang" in suggestion prime list
    Then user verify see kost name "Kost Tangcity Tangerang Kota Tangerang" in suggestion nama kost terkait list
