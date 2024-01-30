@regression @LIMO4 @mamitour @TEST_LIMO-5768
Feature: Detail Pemesanan

  @continue
  Scenario: [Web][Mamitour] Check default state of detail pemesanan
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 087133998156 | 0             | qwerty123 |
    And user navigate to mamitour landing page
    And user click on pesan sekarang button
    Then user verify default state of detail pemesanan

  Scenario: [Web][Mamitour] Check total price when add extra lantai and ruangan
    When user choose "Paket 3 Bulan" mamitour
    And user click on add extra 2 lantai and 0 ruangan
    Then user verify total price is "Rp855.000"
    When user click on remove extra 2 lantai and 0 ruangan
    Then user verify total price is "Rp705.000"
    When user click on add extra 0 lantai and 2 ruangan
    Then user verify total price is "Rp765.000"
    When user click on remove extra 0 lantai and 2 ruangan
    Then user verify total price is "Rp705.000"
    When user click on add extra 1 lantai and 1 ruangan
    Then user verify total price is "Rp810.000"
