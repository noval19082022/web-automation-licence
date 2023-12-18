@COOP-4943 @COOP1
Feature: addOns Kost With DP


  @TEST_COOP-3510 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Kost With DP] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0891111020198 | 0891111020198 |
    And admin akhiri contract
    Then admin should success terminate contract

  @TEST_COOP-3509 @TESTSET_COOP-4944 @Automated @web @continue
  Scenario: [Add Ons - Kost With DP] Admin cancel contract
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And user cancel booking

  @TEST_COOP-3508 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Kost With DP] Tenant booking kos
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag        | kost name prod        |
      | Kost Adi Auto DP Only | Kost Adi Auto Add Ons |
    And tenant booking kost for "today" and input rent duration equals to 2
    Then tenant should success booking kost

  @TEST_COOP-3507 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Kost With DP] Owner accept booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag         | tenant prod         |
      | Irvi Tenant Add Ons | Irvi Tenant Add Ons |
    Then owner should redirect back to pengajuan booking page

  @TEST_COOP-3511 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Kost With DP] Tenant Pay DP Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 0891111020198 | 087708777615 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "085699988800"
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice DP from riwayat booking
    And tenant set active page to 1
    And tenant get invoice number


  @TEST_COOP-3513 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Kost With DP] Admin Master Add, Add Ons Kost With DP To Settlement Invoice
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
    Then admin deletes additional other price with name below :
      | adiautomation |

  @TEST_COOP-3512 @TESTSET_COOP-4944 @Automated @web
  Scenario: [Add Ons - Kost With DP] Check Add Ons Fee That Already Deleted For Unpaid ST/Booked Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice DP from riwayat booking
    And tenant set active page to 1
    Then tenant can not sees price with name "adiautomation" on invoice page