@regression @LIMO4
Feature: Update Room from Dashboard

  @TEST_LIMO-2860 @continue
  Scenario: [Web][Owner Dashboard][Update Room]"Update Kamar" add new rooms and delete from entry point owner dashboard when kost status == Active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password   |
      | 082233545506   | 082233545506   | qwerty123  |
    When user click menu "Atur Ketersediaan Kamar" on feature waktunya mengelola property
    And owner click "Kost Automate Dua Depok Sleman"
    And owner add room with name or room number "61"
    Then user see total room is "Total Kamar 61" in update room page

  @continue
  Scenario: Delete room
    When user delete room name or number in room allotment
    Then user see total room is "Total Kamar 60" in update room page