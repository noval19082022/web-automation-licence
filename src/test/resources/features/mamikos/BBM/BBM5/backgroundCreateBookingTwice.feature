@BBM5
Feature: BnB feature with background create booking twice

  Scenario: Tenant Booking Kost Twice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 08100000618   | 08100000618   | qwerty123     |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                                        | kost name prod            |
      | Kost Purwokerto Reject n Waiting Feature Tobelo Utara Halmahera Utara | Kost Purwokerto Reject n Waiting Feature Tobelo Utara Halmahera Utara|
    And tenant booking kost for "today"
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag    | kost name prod    |
      | kost reykjavik    | kost reykjavik    |
    And tenant booking kost for "Tomorrow"
    And user go to mamikos homepage
    And user logs out as a Tenant user

#  @TEST_BBM-891
#  Scenario: Check Kost saya section when tenant have booking with Reject status but have Booking menunggu konfirmasi
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag     | phone prod    | password     |
#      | 0890000000289  | 0890000000289 | Bismillah@01 |
#    And owner navigate to pengajuan booking page
#    And owner choose filter kost for "Kost Purwokerto Reject n Waiting Feature Tobelo Utara Halmahera Utara"
#    And user clicks on Booking Details button
#    And owner reject booking from view detail
#    And owner select reason reject kos "Dokumen tidak lengkap"
#    And user navigates to owner dashboard
#    And owner should successfully log out
#    And user go to mamikos homepage
#    And user login as tenant via phone number:
#      | phone stag    | phone prod    | password      |
#      | 08100000618   | 08100000618   | qwerty123     |
#    Then user can see shortcut homepage with "Pengajuan sewa lagi dicek pemilik"
#    When tenant navigate to riwayat and draf booking
#    And user cancel booking
#    Then user redirected to "/user/booking"