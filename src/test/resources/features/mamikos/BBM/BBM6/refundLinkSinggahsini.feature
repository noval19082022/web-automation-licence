@BBM6
Feature: Check TnC Refund for kost Singgah sini, apik and ELite

  @TEST_COOP-990 @TEST_COOP-1355 @TEST_COOP-1354 @TEST_COOP-1223
  Scenario: [TnC Refund] [Detail Booking & Kost saya] Check TnC Refund for kost Singgah sini, apik and ELite
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     | phone prod    | password   |
      | 0810000097320  | 0810000097320 | qwerty123  |
    And tenant navigate to riwayat and draf booking
    And tenant click button lihat selengkapnya riwayat booking
    And user click on link refund
    And tenant set active page to 1
    Then user can see "syarat-dan-ketentuan-tinggal-di-singgahsini-dan-apik" on mamihelp page
    When tenant navigate to kost saya page
    And user click on link refund
    Then user can see "syarat-dan-ketentuan-tinggal-di-singgahsini-dan-apik" on mamihelp page