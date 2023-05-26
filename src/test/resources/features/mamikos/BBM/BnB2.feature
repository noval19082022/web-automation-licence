@BBM5  @rabu
Feature: BnB feature with background booking kost - reject atur booking

  Scenario: booking kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 08100000090   | 0890867321212 | qwerty123     |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag            | kost name prod            |
      | Kost ARAC1 Danurejan Yogyakarta | Kost Adi Auto FullPaid AddFee Deposit|
    And tenant booking kost for "today"
    And user go to mamikos homepage
    And user logs out as a Tenant user

  @TEST_BBM-910 @automated @partial-regression @web @xray-update
  Scenario: [Atur Booking][Reject Reason] Check reject booking reason Tanggal masuk/check-in kos terlalu dekat and have BSS varian
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 089604239098  | 0890867321212 | widyarini1   |
    And owner navigate to pengajuan booking page
    And user clicks on Booking Details button
    And owner reject booking from view detail
    And owner select reason reject kos "Tidak boleh pasutri"
    Then owner can see confirmation Atur Booking popup
    And owner click on make rules booking button
    Then owner can see make rules booking page







