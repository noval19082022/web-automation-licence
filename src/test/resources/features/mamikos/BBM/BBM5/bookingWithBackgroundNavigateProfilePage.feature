@BBM5
Feature: BnB feature with background navigate profile page
  
  Scenario: Reject request review kos
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigates to "review"
    And admin reject request review kos "Kost Cyllene Tipe A Tobelo Utara Halmahera Utara"


  @kost-saya-revamp-phase2
  Scenario: [Kos Saya][Chat Pemilik]Check Chat Pemilik on kost saya page (BBM-912)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890000000314 | 08100000622 | Bismillah@01 |
    And tenant navigate to kost saya page
    And user click on chat button in top bar tenant home page
    Then user can see Chat list title

  @TEST_BBM-911
  Scenario: [Kos Saya][Bantuan]Check Bantuan on kost saya page (BBM-911)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890000000314 | 08100000622 | Bismillah@01 |
    And tenant navigate to kost saya page
    And user clicks on Bantuan menu
    And user clicks on "Mengapa saya harus check-in?"
    And user navigates to help page
    And user clicks on "Bagaimana cara check-out di kos?"
    And user navigates to help page
    And user clicks on "Hubungi CS Mamikos (aktif 24 jam)"
   # Then user can see Kategori Bantuan on mamihelp page

  @TEST_BBM-884
  Scenario: [Kost saya][Content] Content Kos Saya (BBM-884)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890000000314 | 08100000622 | Bismillah@01 |
    And tenant navigate to kost saya page
    And user clicks on "Lihat informasi kos"
    Then user can see informasi kos page
    And user verify Kost Review entry point is not displayed
    Then user see activities in My Kos

  @TEST_BBM-908
  Scenario: [Kost saya][Kontrak]Check kontrak section when tenant has contract from dbet (BBM-908)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890000000314 | 08100000622 | Bismillah@01 |
    And user navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    And user click review kost
    And user input review kost with rating 5:
      | review stop rent stag       |
      | Kost sangat aman dan bersih |
    And user stop rent kost with reason "Jarak Kos Terlalu Jauh"
    And user click ajukan berhenti sewa on kontrak saya after review kos
    And user logs out as a Tenant user
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 0890000000382 | 08100000622 | Bismillah@01 |
    And user navigate to penyewa page
    And user search kost in penyewa menu "Kost Cyllene Tipe A Tobelo Utara Halmahera Utara"
    And user click on kontrak sewa button
    And user click on tolak button
    And user click on Ubah kontrak penyewa button
    Then user check prices penyewa owner are same to contract at kos saya "Rp12.000.000 / tahun"