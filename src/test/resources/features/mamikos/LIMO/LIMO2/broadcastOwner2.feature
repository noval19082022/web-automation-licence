@listing-monetization @regression @LIMO2 @broadcastChat
Feature: Broadcast Chat Owner 2

  @TEST_LIMO-1143
  Scenario: [Broadcast Chat][Chat]user want to received broadcast chat and see the broadcast chat
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08223456789 | 08223456789 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user opens the chatroom in the "1" order on chat list
    Then chat room appear with latest message "automation broadcast, nikmati promo Mamikos untuk booking kos! Cek kosnya dan langsung booking. Jangan sampai terlewatkan, ya."