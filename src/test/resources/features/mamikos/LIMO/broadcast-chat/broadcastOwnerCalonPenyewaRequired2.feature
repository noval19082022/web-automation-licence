@broadcastChat @owner @staging @broadcastChat
Feature: Broadcast Chat Owner Tenant Booking Required 3

  Scenario: Tenant Booking kos for today
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod    | password  |
      | 08100000622 | 0890867321212 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                | kost path prod                                                                |
      | kost-kabupaten-banyumas-kost-campur-murah-kost-lpl-p2-01-patikraja-banyumas-2 | kost-kabupaten-banyumas-kost-campur-murah-kost-lpl-p2-01-patikraja-banyumas-2 |
    And tenant booking kost for "today"
    Then tenant should success booking kost

  @TEST_LIMO-3640 @Broadcast-chat @GP2 @automated @listing-monetization @web @broadcast-chat2-lagi
  Scenario: [Broadcast Chat][Create Broadcast chat]User want to change kost after input message chat
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 081328787342 | 0          | Perempuan |
    And owner navigates to broadcast chat page
    And owner dismiss FTUE Broadcast
    And owner add broadcast chat for kost "Kost LPL P2 01 Patikraja Banyumas"
    And owner clicks Kos "Kost LPL P2 01 Patikraja Banyumas" and Pilih Kos button
    And owner click button ubah to change kos broadcast
    And owner add broadcast chat for kost "Kost LPL P2 02 Patikraja Banyumas"
    And owner clicks Kos "Kost LPL P2 02 Patikraja Banyumas" and Pilih Kos button
    Then owner will see that the text "Kost LPL P2 02 Patikraja Banyumas" is displayed

  @continue
  Scenario: Batalkan Booking
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest08100000622     |
      | device_uuid       | Mamitest08100000622uuid |
      | device_platform   | Mamitest                |
      | phone_number      | 08100000622             |
      | password          | qwerty123               |
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

  Scenario: Tenant Batalkan Pengajuan Sewa For Add Ons - Extended Contract
    And playwright batalkan pengajuan sewa for tenant