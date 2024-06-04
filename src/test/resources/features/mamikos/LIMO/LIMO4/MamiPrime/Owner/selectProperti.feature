@regression @LIMO4 @mamiprime
Feature: Select property section

  @TEST_LIMO-5760
  Scenario: [WEB][Mamikos Prime][Section Pilih Properti] Autoselect property when the first listing is full (kamar penuh/kuota daerah penuh)
    #select property when room is full occupied
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082233545519 |              | qwerty123 |
    And owner navigate to pendaftaran mamiprime page
    Then owner can see "Kost Automation GP Weekly Tobelo Halmahera Utara" has label "Kamar Penuh" at section select property

