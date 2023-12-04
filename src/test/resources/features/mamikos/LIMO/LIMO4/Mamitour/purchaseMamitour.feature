@regression @LIMO1 @mamitour
Feature: Purchase Mamitour

  @TEST_LIMO-3659
  Scenario: [Web][Mamitour] Purchase Mamitour if doesn't property active
    Given user go to mamikos homepage
    When user login as owner:
    | phone stag    | phone prod    | password  |
    | 0895365623388 | 0895365623388 | qwerty123 |
    And user access mamitour from owner dashboard
    And user click on pesan sekarang button
    Then user will see text title with "Belum Ada Properti Aktif" and subtitle with "Tambahkan kos/apartemen terlebih dahulu untuk bisa memesan MamiTour."