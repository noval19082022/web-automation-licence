@BBM8 @waitingList
Feature: Waiting List - Kost Detail

  @TEST_COOP-4300 @waiting-list @web
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P1 when have tipe Lain(tipe lain available)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020199 | 0891111020199 | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag                 | kost name prod              |
      | Kost Apik Rimbun Tipe D Bantul | Kost Singgahsini Arac Penuh |
    Then tenant can see kamar penuh
    When tenant can see "Ikut daftar tunggu" button
    Then tenant can see "Lihat tipe lain" button
    And tenant click on "Lihat tipe lain" button
    Then tenant see "lihat tipe" section

  @TEST_COOP-4301 @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P1 when have tipe Lain(tipe lain not available)
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                | kost name prod              |
      | Kost Singgahsini Yosua Tipe A Halmahera Utara | Kost Singgahsini Arac Penuh |
    And tenant can see kamar penuh
    Then tenant can see "Ikut daftar tunggu" button

  @TEST_COOP-4302 @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P1 when have kost recomendation
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod              |
      | Kost Fahmi Singgahsini Ketiga Indralaya Utara Ogan Ilir | Kost Singgahsini Arac Penuh |
    Then tenant can see kamar penuh
    Then tenant can see "Ikut daftar tunggu" button
    When tenant can see "Lihat kost lain" button
    And tenant click on "Lihat kos lain" button
    Then tenant see "kamu mungkin menyukainya" section

  @TEST_COOP-4303 @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P1 when doesn't have room type and recomendation kos
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                       | kost name prod                       |
      | Kost Singgahsini Full Ipi Automation Denpasar Utara Denpasar | Kost Singgahsini Full Ipi Automation |
    And tenant can see kamar penuh
    Then tenant can see "Ikut daftar tunggu" button

  @TEST_COOP-4304 @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P2 when have tipe Lain
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                | kost name prod                       |
      | Rega Satu Parangtritis Type G | Kost Singgahsini Full Ipi Automation Denpasar Utara Denpasar |
    Then tenant can see kamar penuh
    When tenant can see "Tanya pemilik" button
    Then tenant can see "Lihat tipe lain" button
    And tenant click on "Lihat tipe lain" button
    Then tenant see "lihat tipe" section

  @TEST_COOP-4305 @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P2 when have recomendation kost
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                      | kost name prod                       |
      | Kost Putra Pak Sunarto Sewon Bantul | Kost Singgahsini Full Ipi Automation Denpasar Utara Denpasar |
    When tenant can see "Tanya pemilik" button
    When tenant can see "Lihat kost lain" button
    And tenant click on "Lihat kos lain" button
    Then tenant see "kamu mungkin menyukainya" section

  @TEST_COOP-4306 @waiting-list @web @BBM8
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list for kost P2 when doesn't room type and kost recomendation
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag             | kost name prod                       |
      | Kost Rini Dua Menou Nabire | Kost Singgahsini Full Ipi Automation Denpasar Utara Denpasar |
    And tenant can see kamar penuh
    Then tenant can see "Tanya pemilik" button

  @TEST_COOP-4311 @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check kost detail when already submit waiting list and acces another kost with fully room
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0810000235 | 0891111020199 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                 | kost name prod              |
      | Kost Apik Rimbun Tipe D Bantul | Kost Singgahsini Arac Penuh |
    Then tenant can succes waiting list submitted with "Kamu ada di daftar tunggu. Kami akan hubungi jika ada kamar kosong."
    When tenant can see "Lihat tipe lain" button
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod              |
      | Kost Fahmi Singgahsini Ketiga Indralaya Utara Ogan Ilir | Kost Singgahsini Arac Penuh |
    Then tenant can see kamar penuh
    When tenant can see "Ikut daftar tunggu" button
    Then tenant can see "Lihat kost lain" button

  @TEST_COOP-4312 @waiting-list @web
  Scenario: [Web][Waiting List ][Kost detail]Check kost detail when already submit waiting list and acces another kost with available room
    When tenant search kost then go to kost details:
      | kost name stag                      | kost name prod              |
      | Kost Apik Mars Ungu Halmahera Utara | Kost Singgahsini Arac Penuh |
    And user want to dismiss FTUE
    Then tenant should see ajukan sewa button is "enable"
    And user logs out as a Tenant user

  @TEST_COOP-4313 @waiting-list @web
  Scenario: [Web][Waiting List ][Kost detail]Check kost detail when already submit waiting list and property as vacant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password  |
      | 081000006116 | 0891111020199 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                                     | kost name prod              |
      | Kost Singgahsini Kedai Kopi Tipe B Halmahera Utara | Kost Singgahsini Arac Penuh |
    And user want to dismiss FTUE
    Then tenant should see ajukan sewa button is "enable"
    And user logs out as a Tenant user

  @TEST_COOP-4307 @waiting-list @web
  Scenario: Check waiting list button when tennat have active contract and that kost have available room
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 081000006116 | 08100000622 | qwerty123 |
    And tenant navigate to kost saya page
    And tenant will see that the text "Tenant Satu Enam" is displayed
    And tenant search kost then go to kost details:
      | kost name stag                                     | kost name prod  |
      | Kost Singgahsini Kedai Kopi Tipe B Halmahera Utara | Kost Arac Penuh |
    Then tenant can see "Ajukan sewa button" button
    And tenant can see "Tanya pemilik" button

  @TEST_COOP-4308 @waiting-list @web
  Scenario: Check waiting list button when tenant have active contract and that kost fully occupied listing
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 081000006116 | 08100000622 | qwerty123 |
    And tenant navigate to kost saya page
    And tenant will see that the text "Tenant Satu Enam" is displayed
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod  |
      | Kost Fahmi Singgahsini Ketiga Indralaya Utara Ogan Ilir | Kost Arac Penuh |
    Then tenant can see "Lihat kost lain" button
    And tenant can see "Ikut daftar tunggu" button

  @TEST_COOP-4309 @waiting-list @web @BBM8
  Scenario: Check waiting list button when have active contract and room not fully for another tenant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 081000006116 | 08100000622 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod  |
      | Kost Fahmi Singgahsini Ketiga Indralaya Utara Ogan Ilir | Kost Arac Penuh |
    And tenant click "Ikut Daftar Tunggu"
    And tenant click "Secepatnya"
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag  | kost name prod  |
      | Kost Airlangga Berdikari 1 | Kost Arac Penuh |
    Then tenant can see "Ajukan sewa button" button
    And tenant can see "Tanya pemilik" button

  @TEST_COOP-4314 @waiting-list @web
  Scenario: Submit waiting list when tennat not login user
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod  |
      | Kost Fahmi Singgahsini Ketiga Indralaya Utara Ogan Ilir | Kost Arac Penuh |
    And tenant click "Ikut Daftar Tunggu"
    Then tenant will see that the text "Login Pencari Kos" is displayed

  @TEST_COOP-4316 @waiting-list @web
  Scenario:Check popup on boarding on kost detail when available room - first time open kost detail
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                                             | kost name prod  |
      | Kost Apik Chrysant Elok Tipe A Kelapa Gading Jakarta Utara | Kost Arac Penuh |
    Then user want to dismiss FTUE

  @TEST-COOP-4327 @waiting-list
  Scenario: [Web][Waiting List ][Waiting List Form]Cancel submit waiting list - Kembali ke iklan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 08100000610 | 08100000622 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                                          | kost name prod  |
      | Kost Fahmi Singgahsini Ketiga Indralaya Utara Ogan Ilir | Kost Arac Penuh |
    And tenant click "Ikut Daftar Tunggu"
    And tenant click on close waiting list button
    Then tenant can see "Ikut daftar tunggu" button
    And user logs out as a Tenant user
