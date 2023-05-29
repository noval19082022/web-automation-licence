@rajawalichatRoom @BBM8
Feature: Rajawali Chat Room

  @TEST_BBM-1496
  Scenario: Check if User can click on Kost Name in Rajawali Chat Room
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod              |password   |
      | qaeautomation3@mamikos.com   | laksana@mamikos.com     |qwerty123  |
    And user go to Rajawali Chat Room
    And user click on the Group Chat
    And user click on Kos Name from chat list
    Then user able to see Kos Name
    When admin set active page to 1
    Then user will directed to Kos Detail in new tab
