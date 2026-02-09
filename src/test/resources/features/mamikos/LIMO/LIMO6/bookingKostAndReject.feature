@LIMO6 @essentialTest2
Feature: BnB feature with background booking kost - reject booking

  Scenario: booking kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod    | password  |
      | 08100000090 | 0890867321212 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                      | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-eksklusif-kost-mini-regression-rajeg-tangerang | Kos DC BAR Automation Tipe A |
    And tenant booking kost for "today"
    And user go to mamikos homepage
    And user logs out as a Tenant user

  @automated @partial-regression @web @xray-update
  Scenario: [Atur Booking][Reject Reason] Check reject booking reason Tanggal masuk/check-in kos terlalu dekat and have BSS varian
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod    | password  |
      | 0891202109 | 0890867321212 | qwerty123 |
    And owner navigate to pengajuan booking page
    And owner choose filter kost for "Kost Mini Regression Rajeg Tangerang"
    And user clicks on Booking Details button
    And owner reject booking from view detail
    And owner select reason reject kos "Tanggal masuk/check-in kos terlalu dekat"
    Then owner can see confirmation Atur Booking popup







