@SS14 @a
Feature: Singgahsini Plus

  @TEST_SS-9190 @continue
  Scenario: [Web][Singgahsini+] Entry Point Singgahsini for tenant non P1 user
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 08100000707 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    Then tenant can see "Baru" label
    When tenant should see Singgahsini Plus summary card
    Then tenant should see tier message in Singgahsini plus with "Makin lama ngekos di Singgahsini/APIK, makin banyak poin yang kamu dapat."
    When tenant clicks on Singgahsini text
    Then tenant can see tier message description on singgahsini page is visible

  @TEST_SS-9193 @continue
  Scenario: [Web][Singgahsini+] Singgahsini+ Page Tab Layout Locked
    Then tenant can see locked tier

  @TEST_SS-9519
  Scenario: [Web][Reward & Poin][Mamipoin Tab] Poin Kamu section for Non Tenant Singgahsini+
    When tenant clicks on Singgahsini text
    And tenant clicks on MamiPoin link in Singgahsini Plus card
    When tenant can see mamipoin menu with "Poin Kamu"
    Then tenant can see mamipoin menu with "Riwayat Mamipoin"
    When tenant can see mamipoin menu with "Dapatkan Poin"
    Then tenant can not see Singgahsini Plus summary card

  @TEST_SS-9191 @continue
  Scenario: [Web][Singgahsini+] Entry Point Singgahsini for tenant P1 user Active
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 08100000704 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    Then tenant can see "Starter" label

  @TEST_SS-9194 @continue
  Scenario: [Web][Singgahsini+] Singgahsini+ Page Tab Layout Active
    When tenant clicks on Singgahsini text
    Then tenant can see tier active with "Level 1: Starter"

  @TEST_SS-9517
  Scenario: [Web][Reward & Poin][Mamipoin Tab] Poin Kamu section for Active Tenant Singgahsini+
    When tenant clicks on MamiPoin link in Singgahsini Plus card
    Then tenant should see Singgahsini Plus summary card
    And tenant should see mamipoin card tier bar title
    And tenant should see tier description text with "Ngekos lama, levelnya naik, poinnya nambah!"
    Then tenant can see mamipoin menu with "Poin Kamu"
    When tenant can see mamipoin menu with "Riwayat Mamipoin"
    Then tenant can see mamipoin menu with "Dapatkan Poin"

  @TEST_SS-9192 @continue
  Scenario: [Web][Singgahsini+] Entry Point Singgahsini for tenant P1 user Paused
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 08100000705 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    Then tenant can see "Baru" label
    When tenant can see "Basic" label
    Then tenant should see tier message in Singgahsini plus with "Level & rewards dijeda"
    When tenant clicks on Singgahsini text
    Then tenant can see paused allert with "Level Singgahsini+ dijeda karena kamu check-out dari Singgahsini/APIK. Balik ngekos untuk aktifkan lagi."

  @TEST_SS-9518
  Scenario: [Web][Reward & Poin][Mamipoin Tab] Poin Kamu section for Pause Tenant Singgahsini+
    When tenant clicks on MamiPoin link in Singgahsini Plus card
    Then tenant should see Singgahsini Plus summary card
    And tenant should see mamipoin card tier bar title
    And tenant should see tier description text with "Ngekos lama, levelnya naik, poinnya nambah!"
    Then tenant can see mamipoin menu with "Poin Kamu"
    When tenant can see mamipoin menu with "Riwayat Mamipoin"
    Then tenant can see mamipoin menu with "Dapatkan Poin"

  @TEST_SS-9197 @continue
  Scenario: [Web][Kost Saya][Singgahsini +]Check Kost saya when tier card for active P1 tenant with progress bar (First Level)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 08100000704 | qwerty123 |
    And tenant open menu kost saya
    Then tenant can see "Level kamu saat ini" in singgahsini plus card
    When tenant can see "Level 1: Starter" in singgahsini plus card
    Then tenant can see "Lanjut ngekos sampai 27 hari untuk naik ke level" in singgahsini plus card
    And tenant clicks on singgahsini card on kost saya
    Then tenant can see tier active with "Level 1: Starter"