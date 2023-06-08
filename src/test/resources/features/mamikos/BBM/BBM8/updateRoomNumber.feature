@updateRoom
Feature: [Detail Penyewa][Ubah Nomor Kamar]Update Room number
#  sudah di remove
  @TEST_BBM-15
  Scenario: Update Room number with added room number from Tambah Kamar button
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     |  phone prod     | password     |
      | 0890000000289  |  0890000000289  | Bismillah@01 |
    And owner go to Penyewa page of kost "kost bandung owner change phone number unique code Tobelo Utara Halmahera Utara"
    Then user can see room number with "Kamar 3 Lantai 1"
    When user change room number with "2"
    Then user can see room number with "Kamar 1 Lantai 1"
    When user change room number with "3"
    Then user can see room number with "Kamar 3 Lantai 1"