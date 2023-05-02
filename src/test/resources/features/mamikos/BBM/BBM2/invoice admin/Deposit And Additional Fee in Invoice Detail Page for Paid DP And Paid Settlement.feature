@regression @BBM2 @TEST_BBM-1416 @TEST_BBM-1415

#  kost used: Kost Adi Auto DP AddFee Deposit
#  (Kost Regular DP with Additional Fee and Deposit)
Feature: Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement

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

  Scenario: Tenant Pay Down Payment For Invoice Detail Check After DP And Settlement Are Paid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat booking
    And tenant pay kost from riwayat booking using ovo "081280003230"
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page after pay DP
    And tenant get invoice number

  Scenario: Invoice Detail Settlement Not Yet Paid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number:
      | search by              | renter_phone_number      |
      | search value           | 0890867321212            |
      | invoice number         | default                  |
    Then admin can sees total cost is basic amount + deposit fee + biaya tetap + admin fee

  Scenario: Tenant get invoice number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat booking
    And tenant go to invoice DP from riwayat booking
    And tenant set active page to 1
    And tenant get invoice number

  Scenario: Invoice Detail Settlement Paid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number:
      | search by              | renter_phone_number      |
      | search value           | 0890867321212            |
      | invoice number         | default                  |
    Then admin can sees total cost is basic amount + deposit fee + biaya tetap + admin fee







