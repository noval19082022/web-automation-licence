@SS6
Feature: BnB feature with background create booking twice

  @continue
  Scenario: Login Tenant Trough API
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest0891111020198     |
      | device_uuid       | Mamitest0891111020198uuid |
      | device_platform   | Mamitest                  |
      | phone_number      | 08100000618               |
      | password          | qwerty123                 |
    When tenant login trough api

  @continue
  Scenario: Get Active Contract And Active Booking
    When playwright get tenant booking status with parameter:
      | page   |        |
      | sort   |        |
      | status | booked |
    When playwright get tenant booking status with parameter:
      | page   |           |
      | sort   |           |
      | status | confirmed |
    When playwright get tenant booking status with parameter:
      | page   |          |
      | sort   |          |
      | status | verified |
    When playwright get tenant booking status with parameter:
      | page   |            |
      | sort   |            |
      | status | checked_in |

  @continue
  Scenario: Verify Active Contract And Active Booking
    When playwright check for active contract and active booking

  @continue
  Scenario: Tenant Batalkan Pengajuan Sewa For Add Ons - Extended Contract
    And playwright batalkan pengajuan sewa for tenant

  Scenario: Tenant Booking Kost Twice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08100000618 | 08100000618 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                                         | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-murah-kost-purwokerto-reject-n-waiting-feature-tobelo-utara-halmahera-utara | Kos DC BAR Automation Tipe A |
    And tenant booking kost "Tomorrow" "Per Bulan"
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                                      | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-murah-kost-surabaya-cancel-booking-homepage-tobelo-utara-halmahera-utara | Kos DC BAR Automation Tipe A |
    And tenant booking kost "Tomorrow" "Per Bulan"
    And user go to mamikos homepage
    And user logs out as a Tenant user

  @TEST_SS-3535
  Scenario: Check Kost saya section when tenant have booking with Reject status but have Booking menunggu konfirmasi
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0890000000289 | 0890000000289 | Bismillah@01 |
    And owner navigate to pengajuan booking page
    And owner choose filter kost for "Kost Purwokerto Reject N Waiting Feature Tobelo Utara Halmahera Utara"
    And user clicks on Booking Details button
    And owner reject booking from view detail
    And owner select reason reject kos "Dokumen tidak lengkap"
    And user navigates to owner dashboard
    And owner should successfully log out
    And user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08100000618 | 08100000618 | qwerty123 |
    When tenant navigate to riwayat and draf booking
    And user cancel booking
    Then user redirected to "/user/booking"
    And user go to mamikos homepage
    Then user can see shortcut homepage with "Yah, pengajuan sewamu ditolak"