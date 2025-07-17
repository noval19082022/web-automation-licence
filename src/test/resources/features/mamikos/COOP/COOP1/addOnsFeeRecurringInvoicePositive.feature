@COOP1
Feature: addOns Fee Recurring Invoice Positive


  @SS-4951
  Scenario: [Add Ons - Fee Recurring Invoice Positive Scenario] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0891111020198 | 0891111020198 |
    And admin akhiri contract
    Then admin should success terminate contract

  @SS-4952 @continue
  Scenario: [Add Ons - Fee Recurring Invoice Positive Scenario] Admin cancel contract
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And user cancel booking

  @SS-4953
  Scenario: [Add Ons - Fee Recurring Invoice Positive Scenario] Tenant booking kos
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                   | kost path prod        |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-adi-automation-add-ons | Kost Adi Auto Add Ons |
    And tenant booking kost for "today" and input rent duration equals to 2
    Then tenant should success booking kost

  @SS-4954
  Scenario: [Add Ons - Fee Recurring Invoice Positive Scenario] Owner accept booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag         | tenant prod         |
      | Irvi Tenant Add Ons | Irvi Tenant Add Ons |
    Then owner should redirect back to pengajuan booking page

  @SS-4955
  Scenario: [Add Ons - Add Ons Fee On Recurring Invoice With Booked Status] Admin Master Add, Add Ons Fee
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

  @SS-4956
  Scenario: [Add Ons - Fee Recurring Invoice Positive Scenario] Tenant Pay 1st Month Booking For Add Ons
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0891111020198"
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    Then tenant navigate to tagihan kost saya

  @SS-4957
  Scenario: [Add Ons - Fee Recurring Invoice Positive Scenario] Check On Add Ons Fee That Already Delete By Admin For Recurring/Auto Extend Invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number and go to invoice detail fee:
      | search by      | renter_phone_number |
      | search value   | 0891111020198       |
      | invoice number | default             |
    When admin deletes additional other price with name below :
      | adiautomation |
    Then user can not see additional price with name below :
      | adiautomation |

  @SS-4958
  Scenario: [Add Ons - Fee Recurring Invoice Positive Scenario] Add Ons Recurring Invoice Positive Scenario
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant can not sees price with name "adiautomation" on invoice page