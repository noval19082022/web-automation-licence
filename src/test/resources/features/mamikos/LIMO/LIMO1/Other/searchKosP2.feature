@regression @LIMO1
Feature: Search Kos area

  @TEST_LIMO-4165
  Scenario: Search kos with area 3 suggestion
    Given user go to mamikos homepage
    When user click on search kos
    And user input area "kalimantan"
    Then user will see that the text "Kalimantan Timur" is displayed
    Then user will see that the text "Kalimantan Barat" is displayed
    Then user will see that the text "Kalimantan Selatan" is displayed

  @TEST_LIMO-4164
  Scenario: Search kos text disappears after input
    Given user go to mamikos homepage
    When user click on search kos
    And user input area "jakarta"
    Then user no longer see text "Pilih salah satu di bawah ini"

  @TEST_LIMO-4166
  Scenario: Check last 2 suggestions will appear in section “Area Terkait Lainnya”
    Given user go to mamikos homepage
    When user click on search kos
    And user input area "jakarta"
    Then user will see that the text "Jakarta Barat" is displayed
    Then user will see that the text "Jakarta Selatan" is displayed
    And user click on "Lokasi Terkait Lainnya"
    Then user see display 2 suggestion kos

  @TEST_LIMO-4167
  Scenario: Check new icon for section "saran area sekitar"
    Given user go to mamikos homepage
    When user click on search kos
    And user input area "jakarta"
    Then user will see that the text "Kost Rawasari Jakarta Pusat Murah" is displayed