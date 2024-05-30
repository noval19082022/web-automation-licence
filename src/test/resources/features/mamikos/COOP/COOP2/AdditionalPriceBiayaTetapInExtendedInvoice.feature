@COOP-4993 @COOP2
Feature: Additional Price Biaya Tetap In Extended Invoice


  @TEST_COOP-3663 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On Extended Invoice] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag   | phone prod    |
      | 087708777615 | 0890867321212 |

  @TEST_COOP-3664 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On Extended Invoice] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  @TEST_COOP-3665 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On Extended Invoice] Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag                                        | kost name prod            |
      | Kost Bagas Automation HahaHehe Tobelo Halmahera Utara | Kost Adi Auto SinggahSini |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_COOP-3666 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On Extended Invoice] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08916727111    | 08916727111    | qwerty123    |
    And owner accept booking from tenant:
      | tenant stag        | tenant prod          |
      | Hagaromo Otsutsuki | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @TEST_COOP-3667 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On Extended Invoice] Tenant Pay 1st Month Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 087708777615 | 087708777615 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230" without close the page
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant get invoice number

  @TEST_COOP-3668 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On Extended Invoice] Admin Add Additional Price Biaya Tetap
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number    |
      | search value           | 087708777615           |
      | invoice number         | default                |
      | additional price type  | fixed                  |
      | additional price title | Automation Biaya Tetap |
      | addtional price value  | 200000                 |

  @TEST_COOP-3669 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On Extended Invoice] Tenant Check Additional Price Biaya Tetap Added By Admin On Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 087708777615 | 087708777615 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant can see additional price "Automation Biaya Tetap" with price "Rp200.000"

  @TEST_COOP-3670 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On Extended Invoice] Owner Check Additional Price Biaya Tetap Added By Admin On Manage Bills
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08916727111    | 08916727111    | qwerty123 |
    And owner go to bill page of kost "Kost Bagas Automation HahaHehe Tobelo Halmahera Utara" on month of "next"
    And owner go to detail tagihan
    Then owner can see additional price "Automation Biaya Tetap" with price "Rp200.000"
		
