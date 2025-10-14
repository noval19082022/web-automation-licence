@regression @ownerSurveySettings @LIMO5

Feature: Owner Survey Settings

  @TEST_LIMO-9348
  Scenario: [Survey][Sameday] Default Toggle Sameday Survey disabled (P2)
    Given user navigate to mamikos
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202408 | 081362464341 | qwerty123 |
    And user click on chat menu
    * verify title ftue is "Apa itu fitur Chat" and description "Di fitur chat Anda dapat mengobrol dengan calon penghuni kos Anda"
    When user click "Lanjutkan" on ftue
    Then verify title ftue is "Anda dapat kuota chat room" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room."
    When user click "Cara isi kuota" on ftue
    Then verify title ftue is "Kuota chat gratis per bulan" and description "Kuota dikirim setiap tanggal 1 dan 15. Kuota tidak berlaku akumulasi (tidak dapat dikumpul)."
    When user click "Chat bebas kuota" on ftue
    Then verify title ftue is "Mau chat bebas kuota?" and description "Jika tidak ingin menunggu, Anda bisa daftar GoldPlus untuk chat bebas kuota."
    When user click "Saya Mengerti" on ftue
    And user dismiss Laporan klik FTUE
    And user select filter survey
    And user click on pengaturan survei kos
    Then Kos Survey Settings page is displayed
    Then same-day survey toggle is displayed inactive off

  @TEST_LIMO-9349
  Scenario: [Survey][Sameday] Default Toggle Sameday Survey disabled (P1)
    Given user navigate to mamikos
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202411 | 081362464341 | qwerty123 |
    And user click on chat menu
    * verify title ftue is "Apa itu fitur Chat" and description "Di fitur chat Anda dapat mengobrol dengan calon penghuni kos Anda"
    When user click "Lanjutkan" on ftue
    Then verify title ftue is "Anda dapat kuota chat room" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room."
    When user click "Cara isi kuota" on ftue
    Then verify title ftue is "Kuota chat gratis per bulan" and description "Kuota dikirim setiap tanggal 1 dan 15. Kuota tidak berlaku akumulasi (tidak dapat dikumpul)."
    When user click "Chat bebas kuota" on ftue
    Then verify title ftue is "Mau chat bebas kuota?" and description "Jika tidak ingin menunggu, Anda bisa daftar GoldPlus untuk chat bebas kuota."
    When user click "Saya Mengerti" on ftue
    And user dismiss Laporan klik FTUE
    And user select filter survey
    And user click on pengaturan survei kos
    Then Kos Survey Settings page is displayed
    Then same-day survey toggle is displayed inactive on

  @TEST_LIMO-9350
  Scenario: [Survey][Sameday] Handle from BE show copy text
    Given user navigate to mamikos
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202411 | 081362464341 | qwerty123 |
    And user click on chat menu
    * verify title ftue is "Apa itu fitur Chat" and description "Di fitur chat Anda dapat mengobrol dengan calon penghuni kos Anda"
    When user click "Lanjutkan" on ftue
    Then verify title ftue is "Anda dapat kuota chat room" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room."
    When user click "Cara isi kuota" on ftue
    Then verify title ftue is "Kuota chat gratis per bulan" and description "Kuota dikirim setiap tanggal 1 dan 15. Kuota tidak berlaku akumulasi (tidak dapat dikumpul)."
    When user click "Chat bebas kuota" on ftue
    Then verify title ftue is "Mau chat bebas kuota?" and description "Jika tidak ingin menunggu, Anda bisa daftar GoldPlus untuk chat bebas kuota."
    When user click "Saya Mengerti" on ftue
    And user dismiss Laporan klik FTUE
    And user select filter survey
    And user click on pengaturan survei kos
    Then Kos Survey Settings page is displayed
    And Copy Text "Faktanya, 71% pencari kos mengajukan survei kos untuk hari yang sama" displayed


  @TEST_LIMO-9351
  Scenario: [Survey][Sameday][Owner GP] Displaying an onboarding Pop Up via link "Lihat Lebih Lanjut"
    Given user navigate to mamikos
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202411 | 081362464341 | qwerty123 |
    And user click on chat menu
    * verify title ftue is "Apa itu fitur Chat" and description "Di fitur chat Anda dapat mengobrol dengan calon penghuni kos Anda"
    When user click "Lanjutkan" on ftue
    Then verify title ftue is "Anda dapat kuota chat room" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room."
    When user click "Cara isi kuota" on ftue
    Then verify title ftue is "Kuota chat gratis per bulan" and description "Kuota dikirim setiap tanggal 1 dan 15. Kuota tidak berlaku akumulasi (tidak dapat dikumpul)."
    When user click "Chat bebas kuota" on ftue
    Then verify title ftue is "Mau chat bebas kuota?" and description "Jika tidak ingin menunggu, Anda bisa daftar GoldPlus untuk chat bebas kuota."
    When user click "Saya Mengerti" on ftue
    And user dismiss Laporan klik FTUE
    And user select filter survey
    And user click on pengaturan survei kos
    Then Kos Survey Settings page is displayed
    And user clicks link "Lihat Lebih Lanjut"
    And pop up onboarding survey appears