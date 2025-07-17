@COOP2
Feature: Additional Price Other Price On Extended Invoice


  @SS-5019
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Extended Invoice] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag   | phone prod    |
      | 087708777618 | 0890867321212 |

  @SS-5020
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Extended Invoice] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password  |
      | 087708777618 | 0890867321212 | qwerty123 |
    And user cancel booking

  @SS-5021
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Extended Invoice] Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password  |
      | 087708777618 | 0890867321212 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                                             | kost path prod            |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-bagas-automation-hahahehe-tobelo-halmahera-utara | Kost Adi Auto SinggahSini |
    And tenant booking kost
    Then tenant should success booking kost

  @SS-5022
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Extended Invoice] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08916727111 | 08916727111 | qwerty123 |
    And owner accept booking from tenant:
      | tenant stag      | tenant prod          |
      | Nunu And Willump | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @SS-5023
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Extended Invoice] Tenant Pay 1st Month Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 087708777618 | 087708777615 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230"
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant get invoice number

  @SS-5024
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Extended Invoice] Admin Add Additional Price Biaya Lainnya
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number      |
      | search value           | 087708777618             |
      | invoice number         | default                  |
      | additional price type  | default                  |
      | additional price title | Automation Biaya Lainnya |
      | addtional price value  | 200000                   |

  @SS-5025
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Extended Invoice] Tenant Check Additional Price Biaya Lainnya Added By Admin On Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 087708777618 | 087708777618 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant can see additional price "Automation Biaya Lainnya" with price "Rp200.000"

  @SS-5026
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Extended Invoice] Owner Check Additional Price Biaya Lainnya Added By Admin On Manage Bills
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08916727111 | 08916727111 | qwerty123 |
    And owner go to bill page of kost "Test Automation Kost Bagas Automation HahaHehe Tobelo Halmahera Utara" on month of "next"
    And owner go to detail tagihan
    Then owner can see additional price "Automation Biaya Lainnya" with price "Rp200.000"
		
