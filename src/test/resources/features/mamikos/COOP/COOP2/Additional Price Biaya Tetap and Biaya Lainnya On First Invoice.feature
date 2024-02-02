@COOP-4993 @COOP2
Feature: Additional Price Biaya Tetap and Biaya Lainnya On First Invoice

  @TEST_COOP-3586 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0890867321212 | 0890867321212 |

  @TEST_COOP-3587 @TESTSET_COOP-4944 @Automated @web @continue
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  @TEST_COOP-3588 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                   | kost name prod            |
      | Kost Adi Auto SinggahSini Tobelo Halmahera Utara | Kost Adi Auto SinggahSini |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_COOP-3589 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag          | tenant prod          |
      | Adi Auto Addons Satu | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @TEST_COOP-3590 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Tenant Get Invoice Number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant get invoice number from riwayat booking

  @TEST_COOP-3591 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Add Biaya Tetap + Biaya Lainnya On First Invoice From Mamipay
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number |
      | search value           | 0890867321212       |
      | invoice number         | default             |
      | additional price type  | default             |
      | additional price title | Automation          |
      | addtional price value  | 50000               |

  @TEST_COOP-3592 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Tenant Check Additional Price Biaya Tetap and Lainnya Added By Admin On Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And user open riwayat booking
    Then tenant can sees total cost is equal to basic amount, admin fee plus additional price below
      | 50000 |

  @TEST_COOP-3593 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Owner Check Additional Price Biaya Tetap and Biaya Lainnya Added By Admin On Manage Bills] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000021 | mamikosqa123 |
    And owner goes to bills details
      | kost name stag      | kost name prod      |
      | Kost Adi Auto SinggahSini Tobelo Halmahera Utara | Kost Adi Auto Fpaid |
    And owner go to detail tagihan with tenant name is "Adi Auto Addons Satu" and jatuh tempo is "Belum bayar - Jatuh tempo sekarang"
    Then owner can sees total amount is basic amount plus other price
      | 50000 |
		
