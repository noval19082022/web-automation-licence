@regression @BBM2 @TEST_BBM-1326 @TEST_BBM-1327

#  kost used: Kost Adi Auto DP AddFee Deposit
#  (Kost Regular DP with Additional Fee and Deposit)
Feature: Deposit And Additional Fee in Invoice Detail Page for DP And Settlement

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0890867321212 | 0890867321212 |
    And admin terminate contract
    Then admin should success terminate contract

  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 0890867321212 | 0890867321212 | mamikosqa123  |
    And user cancel booking

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 0890867321212 | 0890867321212 | mamikosqa123  |
    And tenant search kost then go to kost details:
      | kost name stag            | kost name prod            |
      | Kost Adi Auto DP AddFee Deposit       | Kost Adi Auto DP AddFee Deposit       |
    And tenant booking kost for "today"
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod      | password      |
      | 08900000000021  | 08900000000021  | mamikosqa123  |
    And owner accept booking
    Then owner should redirect back to pengajuan booking page

  @TEST_BBM-1326
  Scenario: Deposit And Additional Fee in Invoice Detail Page for DP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin clicks on invoice details second index:
      | search by              | renter_phone_number      |
      | search value           | 0890867321212            |
    Then admin can sees total cost is basic amount + admin fee

  @TEST_BBM-1327
  Scenario: Check Deposit And Additional Fee in Invoice Detail Page for Settlement
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin clicks on invoice details first index:
      | search by              | renter_phone_number      |
      | search value           | 0890867321212            |
    Then admin can sees total cost is basic amount + deposit fee + biaya tetap



