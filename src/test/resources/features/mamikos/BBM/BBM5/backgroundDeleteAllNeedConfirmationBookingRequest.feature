@BBM5
Feature: BnB feature with background Delete All Need Confirmation Booking Request

  Background: cancel all
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0892202150 | 0890867321212 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request

  @TEST_COOP-1936 @Automated @kost-saya-revamp-phase1 @web @xray-update
  Scenario: [Home Page][Kost Saya Section ]Check kost saya section when have Cancelled status and have Draft booking
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                                     | kost name prod                        |
      | kost surabaya cancel booking homepage Tobelo Utara Halmahera Utara | Kost Adi Auto FullPaid AddFee Deposit |
    And tenant booking kost for "today"
    Then tenant should success booking kost
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag      | kost name prod                        |
      | kost cibinong bogor | Kost Adi Auto FullPaid AddFee Deposit |
    And tenant booking kost for "Tomorrow"
    And user click back button
    And user click Save Draft Button
    And user go to mamikos homepage
    Then user can see shortcut homepage with "Pengajuan sewa lagi dicek pemilik"
    And user cancel booking with reason "Merasa tidak cocok/tidak sesuai kriteria"
    And user go to mamikos homepage
    Then user can see shortcut homepage with "Mau lanjut ajukan sewa di kos ini?"
    And tenant navigate to riwayat and draf booking
    And user click on Draft menu
    And user click delete button on tab one draft booking
    And user go to mamikos homepage
    And user click Mau Coba Dong section at homepage
    Then tenant navigate to tagihan kost saya

  @TEST_COOP-2005 @Automated @kost-saya-revamp-phase1 @web @xray-update
  Scenario: [Homepage ][Coba cara baru bayar kos]Check when tenant not have booked status (batalkan booking) and draft booking (delete draft)
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                                     | kost name prod                        |
      | kost surabaya cancel booking homepage Tobelo Utara Halmahera Utara | Kost Adi Auto FullPaid AddFee Deposit |
    And tenant booking kost for "today"
    Then tenant should success booking kost
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag               | kost name prod                        |
      | Kos Papalova Rajeg Tangerang | Kost Adi Auto FullPaid AddFee Deposit |
    And tenant booking kost for "Tomorrow"
    And user click back button
    And user click Save Draft Button
    And user go to mamikos homepage
    Then user can see shortcut homepage with "Pengajuan sewa lagi dicek pemilik"
    And tenant navigate to riwayat and draf booking
    And user cancel booking with reason "Merasa tidak cocok/tidak sesuai kriteria"
    And user go to mamikos homepage
    Then user can see shortcut homepage with "Mau lanjut ajukan sewa di kos ini?"
    And tenant navigate to riwayat and draf booking
    And user click on Draft menu
    And user click delete button on tab one draft booking
    And user go to mamikos homepage
    And user click Mau Coba Dong section at homepage
    Then tenant navigate to tagihan kost saya
