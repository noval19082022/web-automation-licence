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

  @TEST_LIMO-1171 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Create Broadcast chat]User want to change kost after input message chat
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 081328787342 | 0          | Perempuan |
    And owner navigates to broadcast chat page
    And owner dismiss FTUE Broadcast if exist
    And owner add broadcast chat for kost "desta automation Tobelo Halmahera Utara"
    And owner clicks Kos "desta automation Tobelo Halmahera Utara" and Pilih Kos button
    And owner click button ubah to change kos broadcast
    And owner clicks Kos "kost automation DOM boleh refund Patikraja Banyumas" and Pilih Kos button
    Then owner will see that the text "kost automation DOM boleh refund Patikraja Banyumas" is displayed
    And owner will see that the text "Calon Penyewa yang mendapatkan pesan" is displayed