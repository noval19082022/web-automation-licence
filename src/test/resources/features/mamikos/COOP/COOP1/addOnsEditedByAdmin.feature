@COOP-4943 @COOP1
Feature: addOns Edited By Admin


  @TEST_COOP-3465 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Edited By Admin] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0891111020198 | 0891111020198 |
    And admin akhiri contract
    Then admin should success terminate contract

  @TEST_COOP-3466 @TESTSET_COOP-4944 @Automated @web @continue
  Scenario: [Add Ons - Edited By Admin] Admin cancel contract
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And user cancel booking

  @TEST_COOP-3467 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Edited By Admin] Tenant booking kos
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag        | kost name prod        |
      | Kost Adi Auto Add Ons | Kost Adi Auto Add Ons |
    And tenant booking kost for "today" and input rent duration equals to 2
    Then tenant should success booking kost

  @TEST_COOP-3468 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Edited By Admin] Owner accept booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag         | tenant prod         |
      | Irvi Tenant Add Ons | Irvi Tenant Add Ons |
    Then owner should redirect back to pengajuan booking page

  @TEST_COOP-3469 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Edited By Admin] Admin Master Add, Add Ons Fee
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number |
      | search value           | 0891111020198       |
      | invoice number         | default             |
      | additional price type  | Add On              |
      | additional price title | adiautomation       |
      | addtional price value  | 100000              |
    Then admin can sees total cost is basic amount + add ons fee + admin fee

  @TEST_COOP-3470 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Edited By Admin] Tenant Pay 1st Month Booking For Add Ons
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230"
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    Then tenant navigate to tagihan kost saya

  @TEST_COOP-3471 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Edited By Admin] Check Add Ons Edited By Admin Master For Recurring/Auto Extend Invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit additional price:
      | search by              | renter_phone_number |
      | search value           | 0891111020198       |
      | invoice number         | default             |
      | additional price type  | Add On              |
      | additional price title | adiautomationNew    |
      | addtional price value  | 150000              |
    Then admin can sees total cost is basic amount + add ons fee + admin fee

  @TEST_COOP-3472 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Edited By Admin] Check Tenant Side After Add Ons Edited By Admin Master For Recurring/Auto Extend Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant can see additional price "adiautomationNew" with price "Rp150.000"
		
