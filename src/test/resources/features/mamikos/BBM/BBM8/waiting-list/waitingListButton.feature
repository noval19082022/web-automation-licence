@BBM8 @waitingList
Feature: Waiting List - Kost Detail

  @TEST_COOP-4300 @waiting-list @web
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P1 when have tipe Lain(tipe lain available)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020199 | 0891111020199 | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag                         | kost name prod              |
      | Kost Apik Mars pelangi Halmahera Utara | Kost Singgahsini Arac Penuh |
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
      | Kost Singgahsini Yosua Tipe A Halmahera utara | Kost Singgahsini Arac Penuh |
    And tenant can see kamar penuh
    Then tenant can see "Ikut daftar tunggu" button

  @TEST_COOP-4302 @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P1 when have kost recomendation
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod              |
      | Kost Fahmi Singgahsini Ketiga Indralaya | Kost Singgahsini Arac Penuh |
    Then tenant can see kamar penuh
    Then tenant can see "Ikut daftar tunggu" button
    When tenant can see "Lihat kost lain" button
    And tenant click on "Lihat kos lain" button
    Then tenant see "kamu mungkin menyukainya" section

  @TEST_COOP-4303  @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P1 when doesn't have room type and recomendation kos
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                       | kost name prod                       |
      | Kost Singgahsini Full Ipi Automation | Kost Singgahsini Full Ipi Automation |
    And tenant can see kamar penuh
    Then tenant can see "Ikut daftar tunggu" button

  @TEST_COOP-4304 @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P2 when have tipe Lain
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                | kost name prod                       |
      | Rega Satu Parangtritis Type G | Kost Singgahsini Full Ipi Automation |
    Then tenant can see kamar penuh
    When tenant can see "Tanya pemilik" button
    Then tenant can see "Lihat tipe lain" button
    And tenant click on "Lihat tipe lain" button
    Then tenant see "lihat tipe" section

  @TEST_COOP-4305    @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list  for kost P2 when have recomendation kost
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                      | kost name prod                       |
      | Kost Putra Pak Sunarto Sewon Bantul | Kost Singgahsini Full Ipi Automation |
    When tenant can see "Tanya pemilik" button
    When tenant can see "Lihat kost lain" button
    And tenant click on "Lihat kos lain" button
    Then tenant see "kamu mungkin menyukainya" section

  @TEST_COOP-4306    @waiting-list @web
  Scenario: [Web][Waiting List ][Kost detail]Check button waiting list for kost P2 when doesn't room type and kost recomendation
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag             | kost name prod                       |
      | Kost Rini Dua Menou Nabire | Kost Singgahsini Full Ipi Automation |
    And tenant can see kamar penuh
    Then tenant can see "Tanya pemilik" button

  @TEST_COOP-4311 @waiting-list @web @continue
  Scenario: [Web][Waiting List ][Kost detail]Check kost detail when already submit waiting list and acces another kost with fully room
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0810000235 | 0891111020199 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                         | kost name prod              |
      | Kost Apik Mars pelangi Halmahera Utara | Kost Singgahsini Arac Penuh |
    Then tenant can succes waiting list submitted with "Kamu ada di daftar tunggu. Kami akan hubungi jika ada kamar kosong."
    When tenant can see "Lihat tipe lain" button
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod              |
      | Kost Fahmi Singgahsini Ketiga Indralaya | Kost Singgahsini Arac Penuh |
    Then tenant can see kamar penuh
    When tenant can see "Ikut daftar tunggu" button
    Then tenant can see "Lihat kost lain" button

  @TEST_COOP-4312 @waiting-list @web
  Scenario: [Web][Waiting List ][Kost detail]Check kost detail when already submit waiting list and acces another kost with available room
    When tenant search kost then go to kost details:
      | kost name stag                      | kost name prod              |
      | Kost Apik Mars ungu Halmahera Utara | Kost Singgahsini Arac Penuh |
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