@regression @LIMO5
Feature: Update Room from Dashboard

  @TEST_LIMO-899 @WEB @AUTOMATED @continue @updateRoomDashboard
  Scenario: [Web][Owner Dashboard][Update Room]"Update Kamar" add new rooms and delete from entry point owner dashboard when kost status == Active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082233545506 | 082233545506 | qwerty123 |
    And owner click sidebar menu "Manajemen Kos"
    When user click menu "Ketersediaan Kamar" on feature waktunya mengelola property
    And owner click "Kost Automate Dua Depok Sleman"
    And owner add room with name or room number "61"
    And owner click simpan on add room pop up
    Then user see total room is "Total Kamar 61" in update room page

  @TEST_LIMO-3464 @WEB @AUTOMATED @updateRoomDashboard
  Scenario: Delete room
    When user delete room name or number in room allotment
    Then user see total room is "Total Kamar 60" in update room page

  @TEST_LIMO-3465 @WEB @AUTOMATED @updateRoomDashboard
  Scenario: [Web][Owner Dashboard][Update Room]"Update Kamar" search for invalid room number, add new rooms and delete from entry point owner dashboard when kost status == Active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08119787884 |            | Perempuan |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "Desta Paris Test VVIP" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    When user enter text "199" on search bar in room allotment and hit enter
    And owner should not be able to see the text "199"
    And owner add room with name or room number "199"
    And owner click "Simpan"
    Then owner will see that the text "199" is displayed
    When user delete room name or number in room allotment
    And user enter text "199" on search bar in room allotment and hit enter
    Then owner should not be able to see the text "199"