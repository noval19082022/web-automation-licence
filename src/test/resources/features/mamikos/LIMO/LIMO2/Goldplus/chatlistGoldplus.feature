@regression @LIMO25 @listing-monetization
Feature: Owner Experiment- GP Chat List


  Scenario: [Owner Experiment][GP Chat List] Owner GP open chat list for the first time
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod | password  |
      | 08167382940591 | 0          | qwerty123 |
    * owner click close icon pop up
    * user click chat button in top bar owner home page
    Then owner will see card box contains "Kini, Anda bisa balas chat sepuasnya, bebas batas kuota"
    * verify title ftue is "Hore! Anda bisa chat tanpa kuota" and description "Sebagai pengguna GoldPlus, Anda bisa chat dan menjangkau penyewa sepuasnya tanpa batas kuota."
    When user click "Apa itu kuota chat room?"
    * verify title ftue is "Kuota chat room di Mamikos" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room"
    * user click "Saya Mengerti"