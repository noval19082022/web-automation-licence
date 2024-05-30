@COOP-4993 @COOP2
Feature: Additional Price Biaya Lainnya Settlement Invoice


  @TEST_COOP-3618 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Settlement Invoice] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag   | phone prod    |
      | 087708777615 | 0890867321212 |

  @TEST_COOP-3619 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Settlement Invoice] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  @TEST_COOP-3620 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Settlement Invoice] Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag        | kost name prod            |
      | Kost Bagas Dp Only Automation Tobelo Halmahera | Kost Adi Auto SinggahSini |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_COOP-3621 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Settlement Invoice] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08916727111    | 08916727111    | qwerty123 |
    And owner accept booking from tenant:
      | tenant stag        | tenant prod          |
      | Hagaromo Otsutsuki | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @TEST_COOP-3622 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Settlement Invoice] Tenant Pay DP Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 087708777615 | 087708777615 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "08126000444" without close the page
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice DP from riwayat booking
    And tenant set active page to 2
    And tenant get invoice number

  @TEST_COOP-3623 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Settlement Invoice] Admin Add Additional Price Biaya Lainnya
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

  @TEST_COOP-3624 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Settlement Invoice] Tenant Check Additional Price Biaya Lainnya Added By Admin On First Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 087708777615 | 087708777615 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page after pay DP
    And tenant set active page to 0
    Then tenant can see additional price "Automation Biaya Lainnya" with price "Rp200.000"

  @TEST_COOP-3625 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Lainnya On Settlement Invoice] Owner Check Additional Price Biaya Lainnya Added By Admin On Manage Bills
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08916727111    | 08916727111    | qwerty123    |
    And owner go to bill page of kost "Kost Bagas Dp Only Automation Tobelo Halmahera" on month of "current"
    And owner go to detail tagihan with jatuh tempo is "Belum bayar - Jatuh tempo sekarang"
    Then owner can see additional price "Automation Biaya Lainnya" with price "Rp200.000"
		
