@regression @addons @BBM1

@TEST_BBM-1088 @TEST_BBM-1089 @TEST_BBM-1090 @TEST_BBM-1091
Feature: Add Ons - Kost With DP

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0891111020198 | 0891111020198 |
    And admin akhiri contract
    Then admin should success terminate contract

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                   | kost name prod                  |
      | Kost Adi Auto With DP Add Ons    | Kost Adi Auto With DP Add Ons   |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag          | tenant prod          |
      | Irvi Tenant Add Ons  | Irvi Tenant Add Ons  |
    Then owner should redirect back to pengajuan booking page

  Scenario: Tenant Pay 1st Month Booking For Add Ons
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230" without close the page
    And tenant set active page to 0
    Then tenant navigate to riwayat and draf booking

  Scenario: Admin Master Add, Add Ons Kost With DP To Settlement Invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number      |
      | search value           | 0891111020198            |
      | invoice number         | default                  |
      | additional price type  | Add On                   |
      | additional price title | adiautomation            |
      | addtional price value  | 100000                   |
    Then admin deletes additional other price with name below :
      | adiautomation |

  @BBM-1418
  Scenario: Check Add Ons Fee That Already Deleted For Unpaid ST/Booked Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice DP from riwayat booking
    And tenant set active page to 1
    Then tenant can not sees price with name "adiautomation" on invoice page


