@SS7 @refundLinkKosReguler
Feature: [Detail Booking][FAQ]Tenant see refund policy on Detail Booking  (Pilar 2)

  @TEST_SS-3845
  Scenario: Tenant see refund policy on Detail Booking (Pilar 2)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089000000611 | 089000000611 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button lihat selengkapnya riwayat booking
    And user click on link refund
    And tenant set active page to 1
    Then user can see "bagaimana-cara-mengajukan-refund" on mamihelp page
    When tenant navigate to tagihan kost saya
    And user click on link refund
    And tenant set active page to 2
    Then user can see "bagaimana-cara-mengajukan-refund" on mamihelp page