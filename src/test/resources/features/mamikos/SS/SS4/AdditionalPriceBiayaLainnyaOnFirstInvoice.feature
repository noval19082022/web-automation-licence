@COOP-4993 @SS4
Feature: Additional Price Biaya Lainnya On First Invoice


  @SS-4992
  Scenario: [Add Ons - Additional Price Biaya Lainnya On First Invoice] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag   | phone prod    |
      | 087708777615 | 0890867321212 |

  @SS-4993
  Scenario: [Add Ons - Additional Price Biaya Lainnya On First Invoice] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  @SS-4994
  Scenario: [Add Ons - Additional Price Biaya Lainnya On First Invoice] Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                                                                   | kost path prod            |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-bagas-auto-paid-tobelo-halmahera-utara | Kost Adi Auto SinggahSini |
    And tenant booking kost
    Then tenant should success booking kost

  @SS-4995
  Scenario: [Add Ons - Additional Price Biaya Lainnya On First Invoice] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089172812122 | 089172812122 | qwerty123 |
    And owner accept booking from tenant:
      | tenant stag        | tenant prod          |
      | Hagaromo Otsutsuki | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @SS-4996
  Scenario: [Add Ons - Additional Price Biaya Lainnya On First Invoice] Tenant Get Invoice Number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant get invoice number from riwayat booking

  @SS-4997
  Scenario: [Add Ons - Additional Price Biaya Lainnya On First Invoice] Admin Add Additional Price Biaya Lainnya To First Invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number      |
      | search value           | 087708777615             |
      | invoice number         | default                  |
      | additional price type  | default                  |
      | additional price title | Automation Biaya Lainnya |
      | addtional price value  | 200000                   |

  @SS-4998
  Scenario: [Add Ons - Additional Price Biaya Lainnya On First Invoice] Tenant Check Additional Price Biaya Lainnya Added By Admin On First Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 087708777615 | 087708777615 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice page from riwayat booking
    And tenant set active page to 1
    Then tenant can see additional price "Automation Biaya Lainnya" with price "Rp200.000"

  @SS-4999
  Scenario: [Add Ons - Additional Price Biaya Lainnya On First Invoice] Owner Check Additional Price Biaya Lainnya Added By Admin On Manage Bills
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089172812122 | 089172812122 | qwerty123 |
    And owner go to bill page of kost "Test Automation kost Bagas Auto Paid Tobelo Halmahera Utara" on month of "current"
    And owner go to detail tagihan with tenant name is "Hagaromo Otsutsuki" and jatuh tempo is "Belum bayar - Jatuh tempo sekarang"
    Then owner can see additional price "Automation Biaya Lainnya" with price "Rp200.000"
		
