@LIMO6 @maintenancecheckkamis
Feature: Mars Project

  @TEST_SS-2808 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check functionality FTUE Pop Up Before Send Chat
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password     |
      | 0888881241 | 0888881241 | qamamikos123 |
    * owner wants to accsess chatroom
    And owner dismiss active pop-ups
    Then owner will see card box contains "Sisa Kuota"
    * owner will see card box contains "Daftar"
    * verify title ftue is "Apa itu fitur Chat" and description "Di fitur chat Anda dapat mengobrol dengan calon penghuni kos Anda"
    When user click "Lanjutkan" on ftue
    Then verify title ftue is "Anda dapat kuota chat room" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room."
    When user click "Cara isi kuota" on ftue
    Then verify title ftue is "Kuota chat gratis per bulan" and description "Kuota dikirim setiap tanggal 1 dan 15. Kuota tidak berlaku akumulasi (tidak dapat dikumpul)."
    When user click "Chat bebas kuota" on ftue
    Then verify title ftue is "Mau chat bebas kuota?" and description "Jika tidak ingin menunggu, Anda bisa daftar GoldPlus untuk chat bebas kuota."
    When user click "Saya Mengerti" on ftue
    And user dismiss Laporan klik FTUE
    And search chat in chatlist "Itenant"
    Then user see the appearence of Mars chatroom

  @TEST_SS-2809 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Owner runs out of quota
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password     |
      | 0888881241 | 0888881243 | qamamikos123 |
    And user dismiss FTUE MARS and FTUE Broadcast
    And user dismiss Laporan klik FTUE
    And search chat in chatlist "Itenant"
    Then user see attachment button is disabled

  @TEST_SS-2810 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Owner registered as goldplus
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0888881251 | 083132396282 | qamamikos |
    * owner wants to accsess chatroom
    Then owner will see card box contains "Kini, Anda bisa balas chat sepuasnya, bebas batas kuota"
    * verify title ftue is "Hore! Anda bisa chat tanpa kuota" and description "Sebagai pengguna GoldPlus, Anda bisa chat dan menjangkau penyewa sepuasnya tanpa batas kuota."
    When user click "Apa itu kuota chat room?"
    Then verify title ftue is "Kuota chat room di Mamikos" and description "Kini berlaku sistem kuota chat. Kuota bisa dipakai untuk saling berbalas chat dengan penyewa di chat room"
    * user click "Saya Mengerti"
    And user dismiss FTUE MARS Goldplus and FTUE Broadcast
    And user dismiss Laporan klik FTUE
    And search chat in chatlist "Tenant Mars"
    Then user see attachment button is enabled

  @TEST_SS-2811 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check the appearence of Mars
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password     |
      | 0888881241 | 0888881241 | qamamikos123 |
    And user dismiss FTUE MARS and FTUE Broadcast
    And user dismiss Laporan klik FTUE
    And user see the appearence of Mars chatlist
    And search chat in chatlist "Itenant"
    Then user see the appearence of Mars chatroom

  @TEST_SS-2812 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Hide owner last seen on kost chatroom
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0888881476 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                          | kost path prod                         |
      | kost-sleman-kost-putri-murah-kost-doraemon-depok-sleman | Kos Dom Automation Distrik Misool Raja |
    And user click on chat button in top bar tenant home page
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    And tenant enter text "Boleh tanya-tanya dulu?" in chat page
    Then user cant see last owner seen
    
  @TEST_SS-2813 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check autoreply of chat on P2 Kost when user already send message
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0888881476 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                                 | kost path prod                         |
      | kost-kabupaten-cilacap-kost-campur-eksklusif-kost-doraemon-the-explorer-cilacap-tengah-cilacap | Kos Dom Automation Distrik Misool Raja |
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    Then chat room appear with latest message "Boleh tanya-tanya dulu?"

  @TEST_SS-2814 @Automated @MARS-DOM @Web @discovery-platform
  Scenario: [Web][Mars] Check autoreply of chat on P1 Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0888881476 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                       | kost path prod   |
      | kost-bantul-kost-campur-eksklusif-kos-laris-kretek-1 | Kos Laris Kretek |
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    And user select chat preset question "Boleh tanya-tanya dulu?"
    Then chat room appear with latest message "Boleh dong. Silakan tanya apapun. Chat ini dibaca langsung oleh pemilik kos."