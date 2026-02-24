@SS7 @ketersediaanKamar
Feature: Change the room on Data Ketersedian Kamar

  @TEST_SS-3363
  Scenario: [Data Ketersediaan Kamar][Edit Kost Room]Change the room name/number when room status is occupied with contract
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user access menu kost Additional
    And user search "testbagas Pasawahan Kuningan" in kost additional
    And user click on atur ketersediaan button
    When user click the edit button in room with status is occupied with room name "1"
    And user update room status to "Kosong" and click the update button
    Then user can see alert "Kamar dengan aktif tenant kontrak tidak bisa diubah." on atur kamar page

  @TEST_SS-3362
  Scenario: [Data Ketersediaan Kamar][Edit Kost Room]Change the room name/number when room status is occupied without contract
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user access menu kost Additional
    And user search "testbagas Pasawahan Kuningan" in kost additional
    And user click on atur ketersediaan button
    When user click the edit button in room with status is occupied with room name "2"
    And user update lantai name to "2"
    Then user can see alert "Success!" on atur kamar page
    When user click the edit button in room with status is occupied with room name "2"
    And user update lantai name to "1"
    Then user can see alert "Success!" on atur kamar page

  @TEST_SS-4879
  Scenario: [Data Ketersediaan Kamar][Delete Kost Room]Delete button is remain locked when when room status is occupied with contract
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user access menu kost Additional
    And user search "testbagas Pasawahan Kuningan" in kost additional
    And user click on atur ketersediaan button
    And user search room id "330228" and delete room
    Then user can see popup delete confirmation