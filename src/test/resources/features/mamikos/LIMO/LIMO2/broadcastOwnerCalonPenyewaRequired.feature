@listing-monetization @regression @LIMO5 @broadcastChat @staging-only @lawackmaintenance
Feature: Broadcast Chat Owner

  #test is precondition only
  Scenario: Tenant Booking kos for today
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 08100000622   | 0890867321212 | qwerty123     |
    And tenant redirect to kost details:
      | kost path stag                                               | kost path prod               |
      | kost-kota-yogyakarta-kost-campur-murah-kos-fathul-khair-jetis-yogyakarta | kost-kota-yogyakarta-kost-campur-murah-kos-fathul-khair-jetis-yogyakarta |
    And tenant booking kost for "today"
    Then tenant should success booking kost

  @TEST_LIMO-3630 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][View Receiver] User want to back from page view receiver
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    When owner navigates to broadcast chat page
    When owner add broadcast chat for kost "Kos Fathul Khair Jetis Yogyakarta"
    And owner clicks Kos "Kos Fathul Khair Jetis Yogyakarta" and Pilih Kos button
    And owner Masukan Pesan and choose row number 1 from the broadcast chat dashboard
    And user click back arrow button on BC page
    And user clicks on Tidak Jadi button
    And user click back arrow button on BC page
    And owner clicks on Keluar button
    Then user redirected to "/broadcast-chat/kos"

  #deleting booking for future proof test
  @continue
  Scenario: Batalkan Booking
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest08100000622     |
      | device_uuid       | Mamitest08100000622uuid |
      | device_platform   | Mamitest                  |
      | phone_number      | 08100000622             |
      | password          | qwerty123              |
    When tenant login trough api

  @continue
  Scenario Outline: Get Active Contract And Active Booking For Add Ons - Extended Contract
    When playwright get tenant booking status with parameter:
      | page   |           |
      | sort   |           |
      | status | <booking> |
    Examples:
      | booking    |
      | booked     |
      | confirmed  |
      | verified   |
      | checked_in |

  @continue
  Scenario: Verify Active Contract And Active Booking For Add Ons - Extended Contract
    When playwright check for active contract and active booking

  @continue
  Scenario: Tenant Batalkan Pengajuan Sewa For Add Ons - Extended Contract
    And playwright batalkan pengajuan sewa for tenant