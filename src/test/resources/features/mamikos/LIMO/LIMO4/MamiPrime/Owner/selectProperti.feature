@regression @LIMO4 @mamiprime
Feature: Select property section

  @TEST_LIMO-5760 @continue
  Scenario: [WEB][Mamikos Prime][Section Pilih Properti] Autoselect property when the first listing is full (kamar penuh/kuota daerah penuh)
    #auto select property when room is full occupied at first listing
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082233545519 |              | qwerty123 |
    And owner navigate to pendaftaran mamiprime page
    And owner can see information "Kos Ini Sedang Penuh" at section select periode
    And owner can see description information "Kost Automation GP Weekly Tobelo Halmahera Utara sedang penuh sehingga tidak dapat didaftarkan ke MamiPrime." at section select periode

  @TEST_LIMO-5758
  Scenario: [WEB][Mamikos Prime][Section Pilih Properti] Owner see label kamar penuh if no available room on listing
    Then owner can see "Kost Automation GP Weekly Tobelo Halmahera Utara" has label "Kamar Penuh" at section select property
    And owner should successfully log out

    #auto select property when room is subdistrict is full at first listing
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082233545515 |              | 12345678 |
    And owner navigate to pendaftaran mamiprime page
    Then owner can see "Kost Sparkle Experiment Non GP Wonokromo Surabaya" has label "Kuota Daerah Penuh" at section select property
    And owner can see information "Kuota Daerah Kos Penuh" at section select periode
    And owner can see description information "Saat ini, kuota MamiPrime untuk daerah Kost Sparkle Experiment Non GP Wonokromo Surabaya sudah penuh. Silakan kembali dalam beberapa waktu lagi." at section select periode
    And owner should successfully log out

  @TEST_LIMO-5761
  Scenario: [WEB][Mamikos Prime][Section Pilih Properti] Owner see select periode section if first listing is not full
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082233545517 |              | qwerty123 |
    And user click on mamiprime widget at owner dashboard
    And owner wants to buy mamiprime from header
    Then owner can see "Kost AT Snow Jetis Yogyakarta" doesnt have label "Kuota Daerah Penuh" at section select property
    And owner will see Pilih Periode section will display package prices