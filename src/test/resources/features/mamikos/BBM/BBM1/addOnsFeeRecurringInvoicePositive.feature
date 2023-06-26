@regression @addons @TEST_BBM-1095 @BBM1

Feature: Add Ons - Fee Recurring Invoice Positive Scenario

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0890867321212 | 0890867321212 |
    And admin akhiri contract
    Then admin should success terminate contract

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag           | kost name prod            |
      | Kost Adi Auto Add Ons    | Kost Adi Auto Add Ons    |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag          | tenant prod          |
      | Adi Auto Addons Satu | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  Scenario: Admin Master Add, Add Ons Fee On Auto Extend Invoice With Booked Status
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number      |
      | search value           | 0890867321212            |
      | invoice number         | default                  |
      | additional price type  | Add On                   |
      | additional price title | adiautomation            |
      | addtional price value  | 100000                   |
    Then admin can sees total cost is basic amount + add ons fee + admin fee

  Scenario: Tenant Pay 1st Month Booking For Add Ons
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230"
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    Then tenant navigate to tagihan kost saya

  @BBM-1101
  Scenario: Check On Add Ons Fee That Already Delete By Admin For Recurring/Auto Extend Invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number and go to invoice detail fee:
      | search by              | renter_phone_number      |
      | search value           | 0890867321212            |
      | invoice number         | default                  |
    When admin deletes additional other price with name below :
      | adiautomation |
    Then user can not see additional price with name below :
      | adiautomation |

  Scenario: Add Ons Recurring Invoice Positive Scenario
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant can not sees price with name "adiautomation" on invoice page