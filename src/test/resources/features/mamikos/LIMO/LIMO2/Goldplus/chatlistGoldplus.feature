@regression @LIMO2 @listing-monetization
Feature: Owner Experiment- GP Chat List

  @TEST_LIMO-1814 @MARS @MARS-LIMO @listing-monetization @web @automated
  Scenario: [Owner Experiment][GP Chat List] Owner GP open chat list for the first time
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod | password  |
      | 08167382940591 | 0          | qwerty123 |
    And owner click close icon pop up
    * user click chat button in top bar owner home page
    Then owner will see card box contains "Kini, Anda bisa balas chat sepuasnya, bebas batas kuota"
    * verify title ftue is "Hore! Anda bisa chat tanpa kuota" and description "Sebagai pengguna GoldPlus, Anda bisa chat dan menjangkau penyewa sepuasnya tanpa batas kuota."
    When user click "Apa itu kuota chat room?"
    Then verify title ftue is "Kuota chat room di Mamikos" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room"
    * user click "Saya Mengerti"

  @TEST_LIMO-1815 @TEST_LIMO-2612 @MARS @MARS-LIMO @listing-monetization @web @automated
  Scenario: [Owner Experiment][GP Chat List] Non GP with an empty chat list
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod | password  |
      | 08167382940592 | 0          | qwerty123 |
    * user click chat button in top bar owner home page
    Then owner will see card box contains "Sisa kuota mingguan"
    * owner will see card box contains "Daftar GoldPlus"
    * verify title ftue is "Apa itu fitur Chat" and description "Di fitur chat Anda dapat mengobrol dengan calon penghuni kos Anda"
    When user click "Lanjutkan"
    Then verify title ftue is "Sistem kuota chat room" and description "Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room."
    When user click "Cara isi kuota"
    Then verify title ftue is "Cara pertama isi kuota" and description "Tunggu setiap minggu. Anda hanya bisa balas 1 chat room per minggu. Kuota tidak berlaku akumulasi (tidak dapat dikumpul)."
    When user click "Lihat cara kedua"
    Then verify title ftue is "Cara kedua isi kuota" and description "Terlalu lama menunggu setiap minggu? Daftar paket GoldPlus untuk balas chat bebas kuota."
    When user click "Saya Mengerti"
    Then user verify last ftue is "Anda hanya bisa balas 1 chat room per minggu. Kuota tidak berlaku akumulasi (tidak dapat dikumpul)."
    * owner will see chat list page empty state