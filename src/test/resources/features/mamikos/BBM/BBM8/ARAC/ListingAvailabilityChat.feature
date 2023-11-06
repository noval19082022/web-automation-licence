@regression @listingavailability

  Feature: Listing Availability on Chat Room

    @TEST_COOP-782 @BBM8 @continue
    Scenario: Check "Ajukan Sewa" button if the room is available for today
      Given user go to mamikos homepage
      When user login as tenant via phone number:
        | phone stag     |  phone prod     | password     |
        | 0891111020199  |  0891111020199  | mamikosqa123 |
      And tenant search kost then go to kost details:
        | kost name stag               | kost name prod               |
        | Kost General Irvi Automation | Kost General Irvi Automation |
      And user click chat in kos detail
      And user select question "Halo, ada kos yang masih kosong?"
      And user click send chat from popup
      And user want to dismiss FTUE
      And user click Ajukan Sewa "today" from chat room
      Then user will open new tab and go to Booking form

    @TEST_COOP-784 @waitingList @commingSoon
    Scenario: Check "Ajukan Sewa" button if the room is not available for today and in the future
      Given user go to mamikos homepage
      When user login as tenant via phone number:
        | phone stag     |  phone prod     | password     |
        | 0891111020199  |  0891111020199  | mamikosqa123 |
      And tenant search kost then go to kost details:
        | kost name stag                       | kost name prod                       |
        | Kost Singgahsini Full Ipi Automation | Kost Singgahsini Full Ipi Automation |
      And user click chat in kos detail
      And user select question "Masih ada kamar?"
      And user click send chat from popup
      And user want to dismiss FTUE
      Then user sees the Booking button disable

