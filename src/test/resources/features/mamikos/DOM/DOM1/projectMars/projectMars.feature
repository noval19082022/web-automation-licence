@DOM1
Feature: Mars Project

  @TEST_SS-2808 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check functionality FTUE Pop Up Before Send Chat
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 0888881241     | 0888881241     | qamamikos123    |
    And user dismiss FTUE MARS and FTUE Broadcast
    And search chat in chatlist "Gorby A "
    And user dismiss Laporan klik FTUE
    And search chat in chatlist "Tenant Mars"
    And user dismiss FTUE TBC
    And owner enter text "Test FTUE Mars" in chat page
    And user cancel send chat on FTUE Before Chat
    And owner enter text "Test FTUE Mars" in chat page
    Then user still see FTUE before send chat

  @TEST_SS-2809 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Owner runs out of quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password      |
      | 0888881241     | 0888881243     | qamamikos123  |
    And user dismiss FTUE MARS and FTUE Broadcast
    And user dismiss Laporan klik FTUE
    And search chat in chatlist "Vu Zet"
    Then user see attachment button is disabled

  @TEST_SS-2810 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Owner registered as goldplus
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 0888881251     | 083132396282   | qamamikos    |
#    And user dismiss FTUE goldplus
    And user dismiss FTUE MARS and FTUE Broadcast
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS Goldplus and FTUE Broadcast
    And user dismiss Laporan klik FTUE
    And search chat in chatlist "Tenant Mars"
    Then user see attachment button is enabled

  @TEST_SS-2811 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check the appearence of Mars
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 0888881241     | 0888881241     | qamamikos123 |
    And user dismiss FTUE MARS and FTUE Broadcast
    And user dismiss Laporan klik FTUE
    And user see the appearence of Mars chatlist
    And search chat in chatlist "Gorby A"
    Then user see the appearence of Mars chatroom

  @TEST_SS-2812 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Hide owner last seen on kost chatroom
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0888881476    | 083176408442  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag                                    | kost name prod                         |
      | Kost Doraemon The Explorer Cilacap Tengah Cilacap | Kos Dom Automation Distrik Misool Raja |
    And user click chat in kos detail
    And user select question "Boleh tanya-tanya dulu?"
    And user click send chat from popup
    Then user cant see last owner seen

  @TEST_SS-2813 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check autoreply of chat on P2 Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0888881476    | 083176408442  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag                                    | kost name prod                         |
      | Kost Doraemon The Explorer Cilacap Tengah Cilacap | Kos Dom Automation Distrik Misool Raja |
    And user click chat in kos detail
    And user select question "Boleh tanya-tanya dulu?"
    And user click send chat from popup
    Then chat room appear with latest message "Mohon tunggu balasan dari pemilik kos ini."

  @TEST_SS-2814 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check autoreply of chat on P1 Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0888881476    | 083176408442  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag   | kost name prod   |
      | Kos Laris Kretek | Kos Laris Kretek |
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    And user select question "Boleh tanya-tanya dulu?"
    And user click send chat from popup
    Then chat room appear with latest message "Boleh dong. Silakan tanya apapun. Chat ini dibaca langsung oleh pemilik kos."