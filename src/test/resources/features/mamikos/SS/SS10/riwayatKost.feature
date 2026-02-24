@riwayatKost @SS8
Feature: riwayat kost

  @TEST_SS-3385
  Scenario: check riwayat list and riwayat detail
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password    |
      | 0890000000265 | 0890000000265 | Bismillah01 |
    And tenant navigate to riwayat kos page
    And user click review kost
    Then user will see review page and user click close on review page
    When user click Lihat Detail
    And user click Lihat Fasilitas and close pop up fasilitas
    And user click review kost
    Then user will see review page and user click close on review page
    When user click Lihat Riwayat Transaksi and user click Kembali ke Booking button
    And user click Booking Ulang
    Then user will open new tab and go to Booking form
    When user go to mamikos homepage
    Then user logs out as a Tenant user
    And user close unused browser tab

  @emptyRiwayatKos @TEST_SS-3309
  Scenario: Check riwayat kos when empty condition
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod    | password  |
      | 08100000626 | 0890000000261 | qwerty123 |
    And tenant navigate to riwayat kos page
    Then user will see empty state