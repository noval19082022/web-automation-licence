@COOP-5027 @COOP3
Feature: SinggahSini Tenant Tracker Uncontrolled Property


  @TEST_COOP-5077 @Automated @web
  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 089612561233 | 089612561233 |

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 089612561233  | 089612561233  | qwerty123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag        | kost name prod        |
      | Kost Adi Auto Regular | Kost Adi Auto Regular |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag           | tenant prod           |
      | Kost Adi Auto Regular | Kost Adi Auto Regular |
    Then owner should redirect back to pengajuan booking page

  Scenario: Tenant Pay 1st Month Booking For Add Ons
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 089612561233  | 089612561233  | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230" without close the page
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    When tenant set active page to 0
    And tenant checkin kost from riwayat booking
    Then tenant navigate to tagihan kost saya

  @TEST_BBM-574 @TEST_BBM-571 @TEST_BBM-556
  Scenario: Check-in Fase and Status for Uncontrolled Property
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to tenant communication menu
    And user choose "Nama Properti" and input "Kost jakarta barat" in the search field on main page
    And user click search button on main page filter
    Then user can see "Data Tidak Ditemukan" on page
		
