@listing-monetization @regression @LIMO5 @broadcastChat2
Feature: Broadcast Chat Owner 2

  @TEST_LIMO-3639
  Scenario: [Broadcast Chat][Chat]user want to received broadcast chat and see the broadcast chat
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08223456789 | 08223456789 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user opens the chatroom in the "1" order on chat list
    Then chat room appear with latest message "Automation Broadcast, nikmati promo Mamikos untuk booking kos! Cek kosnya dan langsung booking. Jangan sampai terlewatkan, ya."

  @TEST_LIMO-3640 @Broadcast-chat @GP2 @automated @listing-monetization @web @broadcast-chat2-lagi
  Scenario: [Broadcast Chat][Create Broadcast chat]User want to change kost after input message chat
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password     |
      | 081328787342 | 0          | Perempuan123 |
    And owner navigates to broadcast chat page
    And owner dismiss FTUE Broadcast
    And owner add broadcast chat for kost "kost automation DOM boleh refund Patikraja Banyumas"
    And owner clicks Kos "kost automation DOM boleh refund Patikraja Banyumas" and Pilih Kos button
    And owner click button ubah to change kos broadcast
    And owner add broadcast chat for kost "kost jambu jambu lpl Patikraja Banyumas"
    And owner clicks Kos "kost jambu jambu lpl Patikraja Banyumas" and Pilih Kos button
    Then owner will see that the text "kost jambu jambu lpl Patikraja Banyumas" is displayed
#    And owner will see that the text "Calon Penyewa yang mendapatkan pesan" is displayed

  @TEST_LIMO-3642 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Select Kost]User Search kost with condition full room not yet have a chat
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password     |
      | 081328787342 | 0          | Perempuan123 |
    And owner navigates to broadcast chat page
    And owner dismiss FTUE Broadcast
    And owner add broadcast chat for kost "kost lpl staging Patikraja Kabupatn Banyumas"
    Then owner will see that the text "Penuh" is displayed
    And owner click back arrow button on BC page
    And owner add broadcast chat for kost "desta automation Tobelo Halmahera Utara"
    And owner clicks Kos "desta automation Tobelo Halmahera Utara" and Pilih Kos button
    Then owner will see that the text "Kos belum memiliki calon penerima" is displayed

  @TEST_LIMO-3643 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Select Kost]User validate list kost is showed all
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password     |
      | 081328787342 | 0          | Perempuan123 |
    And owner navigates to broadcast chat page
    And owner dismiss FTUE Broadcast
    And owner tap on add broadcast chat
    Then owner will see that the text "kost automation DOM boleh refund Patikraja Banyumas" is displayed
    * owner will see that the text "Kost LPL P2 02 Patikraja Banyumas" is displayed
    * owner will see that the text "Kost LPL P2 01 Patikraja Banyumas" is displayed

  @TEST_LIMO-3644 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Select Message]User back from Select Message Page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password     |
      | 081328787342 | 0          | Perempuan123 |
    And owner navigates to broadcast chat page
    And owner dismiss FTUE Broadcast
    And owner add broadcast chat for kost "kost automation DOM boleh refund Patikraja Banyumas"
    And owner clicks Kos "kost automation DOM boleh refund Patikraja Banyumas" and Pilih Kos button
    And owner Masukan Pesan and choose row number 1 from the broadcast chat dashboard
    Then user verify input broadcast message is visible
    And owner edit template message on Broadcast Chat to row number 2
    Then the selected message should be visible on the details page of the broadcast:
	 """
	 +Calon Penyewa
        +Calon Penyewa akan disesuaikan dengan nama penyewa yang terdaftar di Mamikos.
	, nikmati promo Mamikos untuk booking kos! Cek kosnya dan langsung booking. Jangan sampai terlewatkan, ya.
	"""
    Then user verify input broadcast message is not visible

  @TEST_LIMO-3645 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat][Update GP]user update status GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password     |
      | 081328787342 | 0          | Perempuan123 |
    And owner navigates to broadcast chat page
    And owner dismiss FTUE Broadcast
    Then owner will see that the text "Broadcast Chat" is displayed

  @TEST_LIMO-185 @Broadcast-chat @GP2 @automated @listing-monetization @web
  Scenario: [Broadcast Chat Owner][Chat]User visit broadcast chat page for the first time
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089696109343 | 0          | qwerty123 |
    And owner navigates to broadcast chat page
    Then owner will see that the text "Fitur gratis khusus pengguna GoldPlus 2 untuk memasarkan kos Anda lebih luas melalui chat Mamikos." is displayed
    And owner dismiss FTUE Broadcast
    Then owner should not be able to see the text "Yuk, berlangganan paket Mamikos GoldPlus 2 untuk memakai Broadcast Chat."
    Then owner will see that the text "Belum Ada Chat" is displayed
    Then owner will see that the text "Broadcast chat yang telah Anda kirim akan terekam di halaman ini." is displayed
