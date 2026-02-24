@SS7 @kostSaya
Feature: Kost Saya

  @TEST_SS-3524 @fasilitasKost @kost-saya @continue
  Scenario: [Kos Saya][Fasilitas]Check Lihat semua fasilitas
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password  |
      | 081000006116 | 0891111020199 | qwerty123 |
    And tenant navigate to kost saya page
    When tenant click Lihat informasi kos
    Then tenant will redirect to lihat informasi kos page
    And tenant will see "Kost Apik Addams A Halmahera Utara" on informasi kos
    And tenant will see "Peraturan umum di kos" on informasi kos
    And tenant will see "Fasilitas yang bisa kamu dapatkan" on informasi kos
    When user click Lihat semua fasilitas button
    And tenant will see "Fasilitas kamar mandi" on informasi kos
    Then tenant will see "Fasilitas umum" on informasi kos

  @TEST_SS-3536 @forum @kost-saya
  Scenario: [Kost Saya][Forum ]When tenant click Forum and not interested (BBM-893)
    When tenant navigate to kost saya page
    And tenant clicks on forum menu
    Then tenant will see pop up for upcoming forum
    When tenant clicks on Oke button
    And tenant clicks on forum menu
    And tenant tick on checkbox popup upcoming
    When tenant clicks on Oke button
    And tenant clicks on forum menu
    Then tenant will see information "Kami akan memberitahu Anda saat fitur ini sudah tersedia."