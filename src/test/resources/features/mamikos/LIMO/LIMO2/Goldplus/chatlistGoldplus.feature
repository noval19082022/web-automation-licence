@regression @LIMO2 @listing-monetization @GpChatListOwnerExperiment
Feature: Owner Experiment- GP Chat List

  @TEST_LIMO-3391 @MARS @MARS-LIMO @listing-monetization @web @automated
  Scenario: [Owner Experiment][GP Chat List] Owner GP open chat list for the first time
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod | password  |
      | 08167382940591 | 0          | qwerty123 |
    * owner wants to accsess chatroom
    Then owner will see card box contains "Kini, Anda bisa balas chat sepuasnya, bebas batas kuota"
    * verify title ftue is "Hore! Anda bisa chat tanpa kuota" and description "Sebagai pengguna GoldPlus, Anda bisa chat dan menjangkau penyewa sepuasnya tanpa batas kuota."
    When user click "Apa itu kuota chat room?"
    Then verify title ftue is "Kuota chat room di Mamikos" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room"
    * user click "Saya Mengerti"

  @TEST_LIMO-3392 @MARS @MARS-LIMO @listing-monetization @web @automated
  Scenario: [Owner Experiment][GP Chat List] Non GP with an empty chat list
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod | password  |
      | 08167382940592 | 0          | qwerty123 |
    * owner wants to accsess chatroom
    Then owner will see card box contains "Sisa Kuota"
    * verify title ftue is "Apa itu fitur Chat" and description "Di fitur chat Anda dapat mengobrol dengan calon penghuni kos Anda"
    When user click "Lanjutkan" on ftue
    Then verify title ftue is "Anda dapat kuota chat room" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room."
    When user click "Cara isi kuota" on ftue
    Then verify title ftue is "Kuota chat gratis per bulan" and description "Kuota dikirim setiap tanggal 1 dan 15. Kuota tidak berlaku akumulasi (tidak dapat dikumpul)."
    When user click "Chat bebas kuota" on ftue
    Then verify title ftue is "Mau chat bebas kuota?" and description "Jika tidak ingin menunggu, Anda bisa daftar GoldPlus untuk chat bebas kuota."
    When user click "Saya Mengerti" on ftue
    And user dismiss Laporan klik FTUE
   # Then user verify last ftue is "Anda hanya bisa balas chat room sesuai kuota Anda. Kuota tidak berlaku akumulasi (tidak dapat dikumpul)."
    * owner will see chat list page empty state