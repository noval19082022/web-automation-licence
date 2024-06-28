@COOP-4993 @COOP2
Feature: Deposit And Additional Fee in Invoice Detail Page for Full Payment


  @TEST_COOP-4276 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Full Payment] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0890867321212 | 0890867321212 |

  @TEST_COOP-4277 @TESTSET_COOP-4944 @Automated @web @continue
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Full Payment] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  @TEST_COOP-4278 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Full Payment] Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                                                  | kost name prod                                                  |
      | Test Regression Kost Bagas Auto FullPaid AddFee Deposit Tobelo Halmahera Utara  | Kost Bagas Auto FullPaid AddFee Deposit Tobelo Halmahera Utara  |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_COOP-4279 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Invoice admin - eposit And Additional Fee in Invoice Detail Page for Full Payment] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08716267788    | 08716267788    | qwerty123 |
    And owner accept booking from tenant:
      | tenant stag          | tenant prod          |
      | Adi Auto Addons Satu | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @TEST_COOP-4280 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Full Payment] Tenant Get Invoice Number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant get invoice number from riwayat booking

  @TEST_COOP-4281 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Full Payment] admin can sees total cost
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number and go to invoice detail fee:
      | search by      | renter_phone_number |
      | search value   | 0890867321212       |
      | invoice number | default             |
    Then admin can sees total cost is basic amount + deposit fee + additional fee + admin fee
    When admin deletes additional other price with name below :
      | Listrik |
    Then admin can sees total cost is basic amount + deposit fee + admin fee
		
