@COOP-4993 @COOP2
Feature: Additional Price Biaya Tetap On First Invoice


  @TEST_COOP-3676 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On First Invoice] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag   | phone prod    |
      | 087708777615 | 0890867321212 |

  @TEST_COOP-3677 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On First Invoice] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  @TEST_COOP-3678 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On First Invoice] Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag      | kost name prod            |
      | Kost Adi Auto Fpaid | Kost Adi Auto SinggahSini |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_COOP-3679 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On First Invoice] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag        | tenant prod          |
      | Hagaromo Otsutsuki | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @TEST_COOP-3680 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On First Invoice] Tenant Get Invoice Number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password     |
      | 087708777615 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant get invoice number from riwayat booking

  @TEST_COOP-3681 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On First Invoice] Admin Add Additional Price Biaya Tetap To First Invoice
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

  @TEST_COOP-3682 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On First Invoice] Tenant Check Additional Price Biaya Tetap Added By Admin On First Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 087708777615 | 087708777615 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice page from riwayat booking
    And tenant set active page to 1
    Then tenant can see additional price "Automation Biaya Tetap" with price "Rp200.000"

  @TEST_COOP-3683 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap On First Invoice] Owner Check Additional Price Biaya Tetap Added By Admin On Manage Bills
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner go to bill page of kost "Kost Adi Auto Fpaid" on month of "current"
    And owner go to detail tagihan with jatuh tempo is "Belum bayar - Jatuh tempo sekarang"
    Then owner can see additional price "Automation Biaya Tetap" with price "Rp200.000"
		
