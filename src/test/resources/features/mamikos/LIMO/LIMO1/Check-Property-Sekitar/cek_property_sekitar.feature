@LIMO1 @DONEMIGRATINGTONEWBOARD
Feature: Cek Properti Sekitar

  @LIMO-2717
  Scenario: [Fitur Promosi][Cek Properti Sekitar] Make sure owner will redirect to Cek Properti Sekitar page
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag    | password  |
      | 0812345670001 | qwerty123 |
    When owner accsess cek properti sekitar
    And redirected to cek properti sekitar page
    Then user will see that the text "Buka Cek Properti Sekitar di Aplikasi" is displayed
    Then user will see that the text "Untuk saat ini, fitur Cek Properti Sekitar hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed

  @TEST_LIMO-9250
  Scenario: Check filter kamar tersedia
    Given user navigates to ugm kost listing
    When user sets top kos Rooms Available filter
    And user can see total kost in area with "Ditemukan 572 kos-kosan di sekitar UGM"