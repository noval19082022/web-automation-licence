@DOM1
Feature: Mars Project

  @TEST_COOP-5248 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check functionality FTUE Pop Up Before Send Chat
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 0888881241     | 0888881241     | qamamikos123    |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS and FTUE Broadcast
    And search chat in chatlist "Tenant Mars"
    And user dismiss FTUE TBC
    And owner enter text "Test FTUE Mars" in chat page
    And user cancel send chat on FTUE Before Chat
    And owner enter text "Test FTUE Mars" in chat page
    Then user still see FTUE before send chat
  @TEST_COOP-5249 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Owner runs out of quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password      |
      | 0888881243     | 0888881243     | qamamikos123  |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS and FTUE Broadcast
    And search chat in chatlist "Tenant Mars"
    Then user see attachment button is disabled
  @TEST_COOP-5250 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Owner registered as goldplus
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 0888881251     | 083132396282   | qamamikos    |
#    And user dismiss FTUE goldplus
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS Goldplus and FTUE Broadcast
    And search chat in chatlist "Tenant Mars"
    Then user see attachment button is enabled
  @TEST_COOP-5251 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check the appearence of Mars
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 0888881241     | 0888881241     | qamamikos123 |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS and FTUE Broadcast
    And user see the appearence of Mars chatlist
    And search chat in chatlist "Tenant Mars"
    Then user see the appearence of Mars chatroom
  @TEST_COOP-5252 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Hide owner last seen on kost chatroom
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0888881473    | 083176408442  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag                                    | kost name prod                         |
      | Kost Doraemon The Explorer Cilacap Tengah Cilacap | Kos Dom Automation Distrik Misool Raja |
    And user click chat in kos detail
    And user select question "Boleh tanya-tanya dulu?"
    And user click send chat from popup
    Then user cant see last owner seen
  @TEST_COOP-5253 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check autoreply of chat on P2 Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0888881473    | 083176408442  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag                                    | kost name prod                         |
      | Kost Doraemon The Explorer Cilacap Tengah Cilacap | Kos Dom Automation Distrik Misool Raja |
    And user click chat in kos detail
    And user select question "Boleh tanya-tanya dulu?"
    And user click send chat from popup
    Then chat room appear with latest message "Mohon tunggu balasan dari pemilik kos ini."
  @TEST_COOP-5254 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check autoreply of chat on P1 Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0888881473    | 083176408442  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag   | kost name prod   |
      | Kos Laris Kretek | Kos Laris Kretek |
    And user click chat in kos detail
    And user select question "Boleh tanya-tanya dulu?"
    And user click send chat from popup
    Then chat room appear with latest message "Boleh dong. Silakan tanya apapun. Chat ini dibaca langsung oleh pemilik kos."