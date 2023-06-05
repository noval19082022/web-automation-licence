@regression @BBM2 @TEST_BBM-1339
#  kost used: Kost Adi Auto Fpaid
#  (Kost Regular FullPaid without Additional Fee and Deposit)
Feature: Additional Price Biaya Tetap and Biaya Lainnya On First Invoice

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
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag      | kost name prod      |
      | Kost Adi Auto Fpaid | Kost Adi Auto Fpaid |
    And tenant booking kost
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

  Scenario: Tenant Get Invoice Number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant get invoice number from riwayat booking

  Scenario: Add Biaya Tetap + Biaya Lainnya On First Invoice From Mamipay
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number |
      | search value           | 0890867321212       |
      | invoice number         | default             |
      | additional price type  | default             |
      | additional price title | Automation          |
      | addtional price value  | 50000               |

  Scenario: Tenant Check Additional Price Biaya Tetap and Lainnya Added By Admin On Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And user open riwayat booking
    Then tenant can sees total cost is equal to basic amount, admin fee plus additional price below
      | 50000 |

  Scenario: Owner Check Additional Price Biaya Tetap and Biaya Lainnya Added By Admin On Manage Bills
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner goes to bills details
      | kost name stag      | kost name prod      |
      | Kost Adi Auto Fpaid | Kost Adi Auto Fpaid |
    And owner go to detail tagihan with tenant name is "Adi Auto Addons Satu" and jatuh tempo is "Belum bayar - Jatuh tempo sekarang"
    Then owner can sees total amount is basic amount plus other price
      | 50000 |