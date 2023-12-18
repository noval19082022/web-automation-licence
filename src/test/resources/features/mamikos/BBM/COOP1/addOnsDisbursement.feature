@COOP-4943 @COOP1
Feature: addOns Disbursement


  @TEST_COOP-3459 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Disbursement] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0891111020198 | 0891111020198 |
    And admin akhiri contract
    Then admin should success terminate contract

  @TEST_COOP-3460 @TESTSET_COOP-4944 @Automated @web @continue
  Scenario: [Add Ons - Disbursement] Admin cancel contract
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And user cancel booking

  @TEST_COOP-3461 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Disbursement] Tenant booking kos
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag        | kost name prod        |
      | Kost Adi Auto Add Ons | Kost Adi Auto Add Ons |
    And tenant booking kost for "today" and input rent duration equals to 2
    Then tenant should success booking kost

  @TEST_COOP-3462 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Disbursement] Owner accept booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag         | tenant prod         |
      | Irvi Tenant Add Ons | Irvi Tenant Add Ons |
    Then owner should redirect back to pengajuan booking page

  @TEST_COOP-3463 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Disbursement] Tenant Pay 1st Month Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230" without close the page
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking

  @TEST_COOP-3464 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Disbursement] Admin Master Add, Add Ons Fee To Full Payment Invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number |
      | search value           | 0891111020198       |
      | invoice number         | default             |
      | additional price type  | Add On              |
      | additional price title | Laundry             |
      | addtional price value  | 100000              |
    Then admin can sees total cost is basic amount + add ons fee + admin fee
		
