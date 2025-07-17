@COOP3
Feature: SinggahSini Tenant Tracker Controlled Property


  @Automated @web
  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0895131932292 | 0895131932292 |

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0895131932292 | 0895131932292 | qwerty123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                          | kost path prod                                   |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-adi-auto-singgahsini-tobelo-halmahera-utara-1 | Kost Adi Auto SinggahSini Tobelo Halmahera Utara |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag   | tenant prod   |
      | Senjatanuklir | Senjatanuklir |
    Then owner should redirect back to pengajuan booking page

  Scenario: Tenant Pay 1st Month Booking For Add Ons
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0895131932292 | 0895131932292 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230" without close the page

  @SS-4242
  Scenario: Booking Fase and Status for Controlled Property
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to tenant communication menu
    And user choose "No. HP Penyewa" and input "0895131932292" in the search field on main page
    And user click search button on main page filter
    And user choose "Booking" on filter tahapan and "Terbayar Lunas" on filter status
    And user click on terapkan button
    And user click search button on main page filter
    Then user verify search result on main page bse contains "Terbayar Lunas"

  Scenario: Tenant Check-in Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0895131932292 | 0895131932292 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    Then tenant navigate to tagihan kost saya

  @SS-4242
  Scenario: Check-in Fase and Status for Controlled Property
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to tenant communication menu
    And user choose "No. HP Penyewa" and input "0895131932292" in the search field on main page
    And user click search button on main page filter
    And user choose "Check-in" on filter tahapan and "Sudah Check-in" on filter status
    And user click on terapkan button
    And user click search button on main page filter
    Then user verify search result on main page bse contains "Sudah Check-in"
		
