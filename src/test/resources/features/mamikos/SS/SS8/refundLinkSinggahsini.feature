@SS7
Feature: Check TnC Refund for kost Singgah sini, apik and ELite

  @TEST_SS-3421 @TEST_SS-3365
  Scenario: [TnC Refund] [Detail Booking & Kost saya] Check TnC Refund for kost Singgah sini, apik and ELite
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000097320 | 0810000097320 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button lihat selengkapnya riwayat booking
    And user click on link refund
    And tenant set active page to 1
    Then user can see "syarat-dan-ketentuan-tinggal-di-singgahsini-dan-apik" on mamihelp page
    When tenant navigate to kost saya page
    And user click on link refund
    And tenant set active page to 2
    Then user can see "syarat-dan-ketentuan-tinggal-di-singgahsini-dan-apik" on mamihelp page