@SS6 @antiFraud
Feature: AntiFraud

  @TEST_SS-5120 @continue
  Scenario: [Web][Chat room] Click  "Gimana Mamikos mencegah penipuan? " Redirection to Mamihelp
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 0892202409 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user opens the chatroom in the "1" order on chat list
    And user click text "Gimana Mamikos mencegah penipuan?"
    Then new tab open redirect to "Antifraud"
    And tenant close unused browser tab

  @TEST_SS-5122 @continue
  Scenario: [Web][Chat room] Click "cara pembayaran yang lebih aman." Redirection to Mamihelp (warning box)
    Given user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user opens the chatroom in the "1" order on chat list
    And user click text "cara pembayaran yang lebih aman."
    Then new tab open redirect to "Antifraud"
    And tenant close unused browser tab

  @TEST_SS-5123 @continue
  Scenario: [Web][Chat room] Change Copy in Dialog Box
    Given user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user opens the chatroom in the "1" order on chat list
    Then user will see that the text "Segala bentuk pembayaran di luar platform Mamikos menjadi tanggung jawab masing-masing pengguna." is displayed

  @TEST_SS-5124 @continue
  Scenario: [Web][Chat room] Reopen chat room tenant
    Given user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user opens the chatroom in the "1" order on chat list
    And user click back button chatroom
    And user opens the chatroom in the "1" order on chat list
    Then user will see that the text "Ada pembayaran di luar Mamikos? Untuk keamanan bersama, mohon gunakan" is displayed

  @TEST_SS-5125
  Scenario: [Web][Chat room] [Web][Chat room] Close Warning Box
    Given user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user opens the chatroom in the "1" order on chat list
    Then user will see that the text "Ada pembayaran di luar Mamikos? Untuk keamanan bersama, mohon gunakan" is displayed
    And user can click close button on popup

  @TEST_SS-5126
  Scenario: [Web][Chat room] Repeated suspicious Keyword
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | password  |
      | 08100000213 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user opens the chatroom in the "1" order on chat list
    And tenant enter text "Survey" in chat page
    Then user will see that the text "Ada pembayaran di luar Mamikos? Untuk keamanan bersama, mohon gunakan" is displayed