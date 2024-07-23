@BBM6 @COOP6
Feature: UX improvment booking

  @TEST_SS-2668 @uxImprovement
  Scenario: [Web][UX Improvement][Pengajuan sewa][Draft]Update wording when save to draft
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | password |
      | 083311231113 | asdf1234 |
    And tenant search kost then go to kost details:
      | kost name stag                                  |
      | Kos Raya Raney Tipe Raya 3 Danurejan Yogyakarta |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    And user click back button
    Then tenant verify the confirmation cancel booking pop up

  @TEST_SS-2665 @TEST_SS-2667 @uxImprovement @continue
  Scenario: [Web][UX Booking] Update wording content Belum bisa mengajukan sewa
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | password |
      | 08100000211 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                                        |
      | Kost Singgahsini Mertua Idaman Tipe A Halmahera Utara |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    Then tenant can see "Lihat riwayat pengajuan sewa" button

  @TEST_SS-2671
  Scenario: [Web][UX Improvement][Pengajuan sewa][Draft]Update wording on Draft and Last seen
    When tenant navigate to riwayat and draf booking
    And user click on Draft menu
    Then tenant can see ajukan sewa text button
    When user click on "Baru Dilihat" button
    Then tenant can see ajukan sewa text button