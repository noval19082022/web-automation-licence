@BBM5  @senin
Feature: BnB feature with background booking kost - reject atur booking

  Scenario: booking kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 08100000090   | 0890867321212 | qwerty123     |
    And tenant navigate to riwayat booking
    And tenant cancel all need confirmation booking request
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag            | kost name prod            |
      | Yamie Panda Kost Deposit Wirobrajan Yogyakarta | Kost Adi Auto FullPaid AddFee Deposit|
    And tenant booking kost for "today"
    And user go to mamikos homepage
    And user logs out as a Tenant user

  @TEST_BBM-910 @automated @partial-regression @web @xray-update
  Scenario: [Atur Booking][Reject Reason] Check reject booking reason Tanggal masuk/check-in kos terlalu dekat and have BSS varian
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod    | password    |
      | 081362464341  | 0890867321212 | 1d0lt3stb4ru   |
    And owner reject booking







