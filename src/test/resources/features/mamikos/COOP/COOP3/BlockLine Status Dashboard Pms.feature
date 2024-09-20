@COOP3
Feature: BlockLine Status Dashboard Pms

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag | phone prod   |
      | 0892202358 | 087708777615 |

  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202358 | 087708777615 | qwerty123 |
    And user cancel booking

  Scenario: Add tenant when the kost has an additional price, deposit & denda
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202358"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    And admin click on save button
    And admin click on ya simpan button

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod     | password  |
      | 089120220103 | 08900000000021 | qwerty123 |
    And owner navigates to owner dashboard
    And owner accept booking from tenant:
      | tenant stag     | tenant prod        |
      | Tenant Wl Eight | Hagaromo Otsutsuki |
    Then owner should redirect back to pengajuan booking page

  @SS-5052
  Scenario: Block line status Waiting for payment
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    Then admin see block line status "Waiting for payment"

  Scenario: Tenant Pay 1st Month Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0892202358 | 0890867321212 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0890867321212" without close the page

  @SS-5052
  Scenario: Block line status Waiting for check-in
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    Then admin see block line status "Waiting for check-in"

  Scenario: Tenant check-in kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0892202358 | 0890867321212 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking

  @SS-5052
  Scenario: Block line status Stay - Booking
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    Then admin see block line status "Stay - Booking"
		
