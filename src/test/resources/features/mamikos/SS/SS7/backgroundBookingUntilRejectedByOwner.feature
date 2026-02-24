@SS6
Feature: BnB feature with background booking until rejected by owner

  Background: Tenant Booking And Reject By Owner
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08922024500 | 08100000618 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                           | kost path prod               |
      | kost-kota-depok-kost-putri-murah-kost-gowongan-jaya-pancoran-mas-depok-2 | Kos DC BAR Automation Tipe A |
    And tenant booking kost for "today"
    And user go to mamikos homepage
    And user logs out as a Tenant user
    When user login as owner:
      | phone stag | phone prod    | password  |
      | 0891202302 | 0890000000289 | qwerty123 |
    And owner navigate to pengajuan booking page
    And owner choose filter kost for "Kost Gowongan Jaya Pancoran Mas Depok"
    And user clicks on Booking Details button
    And owner reject booking from view detail
    And owner select reason reject kos "Dokumen tidak lengkap"
    And user navigates to owner dashboard
    And owner logs out

  @TEST_SS-3426
  Scenario: [Home Page][Kost Saya Section ]Check Kost saya section when tenant have booking with Reject status (BBM-967)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08922024500 | 08100000618 | qwerty123 |
    Then user can see shortcut homepage with "Yah, pengajuan sewamu ditolak"

  @TEST_SS-3485
  Scenario: [Home Page][Kost Saya Section ]Check kost saya section on homepage when tenant have booking with reject status (BBM-903)  > 1 booking request
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08922024500 | 08100000618 | qwerty123 |
    Then user can see shortcut homepage with "Yah, pengajuan sewamu ditolak"
    When user can see Lihat pengajuan sewa lainnya text
    And user click on Lihat pengajuan sewa lainnya button
    Then user should reached history booking page
