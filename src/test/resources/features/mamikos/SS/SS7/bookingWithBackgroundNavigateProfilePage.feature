@SS6

Feature: [Web][Profile page] feature with background navigate profile page

  @TEST_COOP-7717 @Automated @Web
  Scenario: Cancel and create booking
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag | phone prod |
      | 0892202358 | 0892202358 |
    And admin akhiri contract
    Then admin should success terminate contract

  Scenario: cancel booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0892202358 | 0892202358 | qwerty123 |
    And user cancel booking
		
		  #Scenario: create booking
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                        | kost path prod               |
      | kost-kota-payakumbuh-kost-campur-eksklusif-kost-singgahsini-noval-tipe-a-tobelo-utara-halmahera-utara | Kos DC BAR Automation Tipe A |
    And tenant booking kost for "today" and input rent duration equals to 0
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 089120220103 | 0890000000289 | qwerty123 |
    And owner accept booking from tenant:
      | tenant name stag          | tenant name prod          |
      | Tenant Wl Eight           | Tenant Wl Eight           |


  Scenario: Tenant pay kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0892202358 | 0892202358 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0890867321217" without close the page

  Scenario: Tenant check-in kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0892202358 | 0892202358 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking

  @continue @TEST_SS-3523
  Scenario: [Kos Saya][Chat Pemilik]Check Chat Pemilik on kost saya page (COOP-1979)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod  | password  |
      | 0892202358 | 08100000622 | qwerty123 |
    And tenant navigate to kost saya page
    And user click on chat button in top bar tenant home page
    Then user can see Chat list title

  @continue @TEST_SS-3522
  Scenario: [Kos Saya][Bantuan]Check Bantuan on kost saya page (BBM-911)
    And tenant navigate to kost saya page
    And user clicks on Bantuan menu
    And user clicks on "Mengapa saya harus check-in?"
    And user navigates to help page
    And user clicks on "Bagaimana cara check-out di kos?"
    And user navigates to help page
    And user clicks on "Hubungi CS Mamikos (aktif 24 jam)"

  @continue @TEST_SS-3515
  Scenario: [Kost saya][Content] Content Kos Saya (BBM-884)
    And tenant navigate to kost saya page
    And user clicks on "Lihat informasi kos"
    Then user can see informasi kos page
    And user verify Kost Review entry point is not displayed
    Then user see activities in My Kos

  @TEST_SS-3520
  Scenario: [Kost saya][Kontrak]Check kontrak section when tenant has contract from dbet (BBM-908)
    And tenant set active page to 0
    And user navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    And user stop rent kost with reason "Alasan Pribadi" and subreason "-"
    And user click review kost
    And user input review kost with rating 5:
      | review stop rent stag       |
      | Kost sangat aman dan bersih |
    And user click ajukan berhenti sewa on kontrak saya after review kos
    And user logs out as a Tenant user
    When user login as owner:
      | phone stag   | phone prod  | password  |
      | 089120220103 | 08100000622 | qwerty123 |
    And user navigate to penyewa page
    And user search kost in penyewa menu "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And user click on lihat selengkapnya button
    And user click on kontrak sewa button
    And user click on tolak button
    And user click on Ubah kontrak penyewa button
    Then user check prices penyewa owner are same to contract at kos saya "Rp1.100.000 / bulan"

  @rejectReview
  Scenario: Reject request review kos
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigates to "/admin/review"
    And admin reject request review kos "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
		
