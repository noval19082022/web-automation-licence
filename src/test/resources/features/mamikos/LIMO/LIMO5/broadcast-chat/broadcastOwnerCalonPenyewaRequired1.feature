@listing-monetization @regression @LIMO5 @broadcastChat @staging-only @broadcastChatOwner
Feature: Broadcast Chat Owner Tenant Booking Required 2

  #test is precondition only
  Scenario: Tenant Booking kos for today
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod    | password  |
      | 08100000622 | 0890867321212 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                              | kost path prod                                                              |
      | kost-kabupaten-sleman-kost-campur-murah-kost-gp-2-automation-depok-sleman-2 | kost-kabupaten-sleman-kost-campur-murah-kost-gp-2-automation-depok-sleman-2 |
    And tenant booking kost for "today"
    Then tenant should success booking kost

  @TEST_LIMO-3641 @continue
  Scenario:[Broadcast Chat][Create Broadcast chat]User Want To Save Template Without Add Message On Template Is Editable
       #reset broadcast chat
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Broadcast for owner with phone number "081197878842"

    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 081197878842 | 0          | qwerty123 |
    And owner navigates to broadcast chat page
    And owner dismiss FTUE Broadcast
    And user click "Buat Broadcast Chat"
    And owner add broadcast chat for kost "kost GP 2 Automation Depok Sleman"
    And owner clicks Kos "kost GP 2 Automation Depok Sleman" and Pilih Kos button
    And owner Masukan Pesan and choose row number 1 from the broadcast chat dashboard
    And owner click "Preview Pesan" button
    Then owner will see that the text "Isi pesan terlebih dahulu." is displayed

  #deleting booking for future proof test
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