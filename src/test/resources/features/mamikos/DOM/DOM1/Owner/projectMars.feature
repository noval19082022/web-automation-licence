@DOM1
Feature: Mars Project

  Scenario: [Web][Mars] Check functionality FTUE Pop Up Before Send Chat
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 083838716xxx   | 085697221868   | qamamikos    |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS and FTUE Broadcast
    And search chat in chatlist "Akbar Susilo"
    And owner enter text "Test FTUE Mars" in chat page
    And user cancel send chat on FTUE Before Chat
    And owner enter text "Test FTUE Mars" in chat page
    Then user still see FTUE before send chat

  Scenario: [Web][Mars] Owner runs out of quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 083838716xxx   | 085697221869   | qamamikos    |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS and FTUE Broadcast
    And search chat in chatlist "Akbar Susilo"
    Then user see attachment button is disabled

  Scenario: [Web][Mars] Owner registered as goldplus
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 083838716xxx   | 083132396282   | qamamikos    |
    And user dismiss FTUE goldplus
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS Goldplus and FTUE Broadcast
    And search chat in chatlist "Akbar Susilo"
    Then user see attachment button is enabled
