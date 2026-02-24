@SS12
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

  @TEST_SS-9517 @continue
  Scenario: [Web][Reward & Poin][Mamipoin Tab] Poin Kamu section for Active Tenant Singgahsini+
    When tenant clicks on MamiPoin link in Singgahsini Plus card
    Then tenant should see Singgahsini Plus summary card
    And tenant should see mamipoin card tier bar title
    And tenant should see tier description text with "Ngekos lama, levelnya naik, poinnya nambah!"
    Then tenant can see mamipoin menu with "Poin Kamu"
    When tenant can see mamipoin menu with "Riwayat Mamipoin"
    Then tenant can see mamipoin menu with "Dapatkan Poin"

  @TEST_SS-10050 @continue
  Scenario: [Web][Singgahsini+ Page][Singgahsini Level]Check copy round up for active card when have number of tiers less than 30
    When tenant clicks on Singgahsini text
    Then tenant can see tier passed description "Lanjut ngekos sampai 27 hari untuk naik ke level"

  @TEST_SS-10051 @continue
  Scenario: [Web][Singgahsini+ Page][Singgahsini Level]Check copy round up when have number of tiers more than 30 hari
    Then tenant can see tier passed description "Lanjut ngekos sampai 3 bulan untuk naik ke level 3"

  @TEST_SS-10228
  Scenario: [Web][Kost Saya][Kontrak]Check popup Hentikan sewa from detail tagihan for kost P1
    When tenant navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    Then tenant can see hentikan sewa singgahsini popup with "Sayang banget kalau kamu berhenti sewa sekarang"
    When tenant can see hentikan sewa singgahsini popup with "Kalau berhenti sekarang, Singgahsini+ kamu akan dijeda."
    And tenant click on berhenti sewa button on popup
    Then tenant can see stop rent contract

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

  @TEST_SS-9518 @continue
  Scenario: [Web][Reward & Poin][Mamipoin Tab] Poin Kamu section for Pause Tenant Singgahsini+
    When tenant clicks on MamiPoin link in Singgahsini Plus card
    Then tenant should see Singgahsini Plus summary card
    And tenant should see mamipoin card tier bar title
    And tenant should see tier description text with "Ngekos lama, levelnya naik, poinnya nambah!"
    Then tenant can see mamipoin menu with "Poin Kamu"
    When tenant can see mamipoin menu with "Riwayat Mamipoin"
    Then tenant can see mamipoin menu with "Dapatkan Poin"

  @TEST_SS-9199
  Scenario: [Web][Kost Saya][Singgahsini +]Check kost saya when previously booking kost SS but admin terminated kost SS
    When user go to mamikos homepage
    And tenant click on icon profil
    And tenant click on profile
    Then tenant should see tier message in Singgahsini plus with "Level & rewards dijeda"
    And tenant navigate to kost saya page
    Then tenant can see "Level kamu saat ini" in singgahsini plus card
    When tenant can see "Level 2: Basic" in singgahsini plus card
    Then tenant can see "Level dijeda. Ngekos lagi di Singgahsini/APIK untuk mengaktifkan kembali." in singgahsini plus card
    When tenant should see Mulai cari dan sewa kos button
    Then tenant clicks on Mulai cari dan sewa kos button

  @TEST_SS-9197
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

  @TEST_SS-9287
  Scenario: [Web][Singgahsini+] Singgahsini+ Page Tab Layout Passed
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | password  |
      | 08100000703 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    And tenant clicks on Singgahsini text
    When tenant can see tier passed
    Then tenant can see tier passed description "Level 1 sudah terlewati. Kumpulkan lebih banyak poin di level berikutnya!"

  @TEST_SS-9288 @continue
  Scenario: [Web][Singgahsini+] Singgahsini+ Page Tab Layout Max Level
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | password  |
      | 08100000701 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    And tenant clicks on Singgahsini text
    When tenant can see "Diamond" label
    Then tenant can see tier passed
    When tenant can see tier active with "Level 7: Diamond"
    Then tenant can see tier passed description "Selamat! Kamu sudah di level tertinggi Singgahsini+. Pertahankan level-mu, ya!"

  @TEST_SS-9694 @continue
  Scenario: [Invoice][Singgahsini+] Invoice for Active Tenant P1
    When user navigate to tagihan kost saya
    And tenant clicks on Bayar button in tagihan list
    Then tenant can see Singgahsini Plus level on invoice page

  @TEST_SS-9570 @continue
  Scenario: [Web][Invoice page][Mamipoin]Tenant cann't redeem MamiPoin via desktop browser
    When user navigate to tagihan kost saya
    And tenant clicks on Bayar button in tagihan list
    When tenant can see disable mamipoin button
    Then tenant can see mamipoin menu with "MamiPoin hanya bisa ditukar di aplikasi Mamikos."

  @TEST_SS-9520 @continue
  Scenario: [Web][Reward & Poin][Mamipoin Tab] Riwayat Mamipoin section
    When user go to mamikos homepage
    And tenant click on icon profil
    And tenant click on profile
    And tenant clicks on Singgahsini text
    And tenant clicks on MamiPoin link in Singgahsini Plus card
    When tenant clicks on riwayat poin link
    Then user verify title in the riwayat poin page is displayed

  @TEST_SS-9521
  Scenario: [Web][Reward & Poin][Mamipoin Tab] Dapatkan Mamipoin section
    When tenant clicks on Singgahsini text
    And tenant clicks on MamiPoin link in Singgahsini Plus card
    When tenant clicks on dapatkan poin link
    Then tenant should see poin "Cara Mudah Mendapatkan MamiPoin"

  @TEST_SS-9200 @continue
  Scenario: [Web][Kost Saya][Singgahsini +]Check kost saya when previously booking kost SS but admin terminated kost SS  and booking kost P2
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | password  |
      | 08100000706 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    When tenant can see "Basic" label
    Then tenant should see tier message in Singgahsini plus with "Level & rewards dijeda"
    Then tenant can not see "Level kamu saat ini" in singgahsini plus card

  @TEST_SS-9693 @continue
  Scenario: [Invoice][Singgahsini+] Invoice for tenant P2
    When user navigate to tagihan kost saya
    And tenant clicks on Bayar button in tagihan list
    Then tenant can not see Singgahsini Plus level on invoice page

  @TEST_SS-10229 @continue
  Scenario: [Web][Kost Saya][Kontrak]Check popup Hentikan sewa from detail tagihan for kost P2
    When tenant navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    Then tenant can not see hentikan sewa singgahsini popup with "Sayang banget kalau kamu berhenti sewa sekarang"

  @TEST_SS-9422
  Scenario: [Web][Profil][Singgahsini+]Tenant check display default copy when tenant booking kost P2
    When user go to mamikos homepage
    And tenant click on icon profil
    And tenant click on profile
    When tenant can see "Basic" label
    And tenant clicks on Singgahsini text
    Then tenant can see tier message description on singgahsini page is visible

  @TEST_SS-10051
  Scenario: [Web][Singgahsini+ Page][Singgahsini Level]Check copy round up when have number of tiers more than 12 Bulan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | password  |
      | 081300000708 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    And tenant clicks on Singgahsini text
    Then tenant can see tier passed description "Level 1 sudah terlewati. Kumpulkan lebih banyak poin di level berikutnya!"
    When tenant can see tier passed description "Level 2 sudah terlewati. Kumpulkan lebih banyak poin di level berikutnya!"
    Then tenant can see tier passed description "Level 3 sudah terlewati. Kumpulkan lebih banyak poin di level berikutnya!"
    When tenant can see tier passed description "Level 4 sudah terlewati. Kumpulkan lebih banyak poin di level berikutnya!"
    Then tenant can see tier passed description "Level 5 sudah terlewati. Kumpulkan lebih banyak poin di level berikutnya!"
    When tenant can see tier passed description "Lanjut ngekos 1 tahun 3 bulan lagi untuk naik level"
