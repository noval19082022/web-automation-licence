@regression @LIMO4 @mamitour
Feature: Mamitour History

  @TEST_LIMO-3666
  Scenario Outline: [Web][Mamitour] Riwayat MamiTour
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password  |
      | <phone number> | <phone number> | qwerty123 |
    And user navigate to mamitour landing page
    Then user will "<status>" Lihat Riwayat button
    Examples:
      | phone number   | status   |
      | 0826666666633  | see      |
      | 0895365623388  | not see  |

  @TEST_LIMO-3667
  Scenario: [Web][Mamitour] See have transaction dalam proses tab and do not have transaction on selesai tab
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408449 | 083176408449 | qwerty123 |
    And user access mamitour from owner dashboard
    And user click on Lihat Riwayat Button
    And user click on tab selesai
    Then user will see empty state text "Belum Ada Transaksi" as title and "Transaksi yang telah selesai akan muncul di halaman ini." as subtitle
    When user click on tab dalam proses
    Then user verify there is transaction

  @TEST_LIMO-5685
  Scenario: [Web][Mamitour] See do not have transaction dalam proses tab and have transaction on selesai tab
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0826666666633 | 0826666666633 | qwerty123 |
    And user access mamitour from owner dashboard
    And user click on Lihat Riwayat Button
    And user click on tab dalam proses
    Then user will see empty state text "Belum Ada Transaksi" as title and "Transaksi yang masih dalam proses akan muncul di halaman ini." as subtitle
    When user click on tab selesai
    Then user verify there is transaction