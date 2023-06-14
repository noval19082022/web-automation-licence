@regression @BBM2 @TEST_BBM-1329 @TEST_BBM-1330

#  kost used: Kost Adi Auto FullPaid AddFee Deposit
#  (Kost Regular FullPaid with Additional Fee and Deposit)
Feature: Deposit And Additional Fee in Invoice Detail Page for Full Payment

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0890867321212 | 0890867321212 |

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 0890867321212 | 0890867321212 | mamikosqa123  |
    And user cancel booking

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag            | kost name prod            |
      | Kost Adi Auto FullPaid AddFee Deposit       | Kost Adi Auto FullPaid AddFee Deposit       |
    And tenant booking kost for "today"
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod      | password      |
      | 08900000000021  | 08900000000021  | mamikosqa123  |
    And owner accept booking
    Then owner should redirect back to pengajuan booking page

  Scenario: Tenant Get Invoice Number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant get invoice number from riwayat booking

  Scenario: Deposit And Additional Fee In Invoice Detail Page For Full Payment
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number and go to invoice detail fee:
      | search by              | renter_phone_number      |
      | search value           | 0890867321212            |
      | invoice number         | default                  |
    Then admin can sees total cost is basic amount + deposit fee + additional fee + admin fee
    When admin deletes additional other price with name below :
      | Listrik |
    Then admin can sees total cost is basic amount + deposit fee + admin fee



