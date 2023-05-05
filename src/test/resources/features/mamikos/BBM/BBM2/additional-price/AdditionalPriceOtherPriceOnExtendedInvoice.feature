@BBM2 @lawackrun
Feature: Additional Price Biaya Lainnya On Extended Invoice

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag   | phone prod   |
      | 087708777615 | 087708777615 |
    And admin akhiri contract
    Then admin should success terminate contract

  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 087708777615 | 087708777615 | qwerty123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 087708777615 | 087708777615 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag            | kost name prod            |
      | Kost Adi Auto SinggahSini | Kost Adi Auto SinggahSini |
    And tenant booking kost for "today"
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag        | tenant prod        |
      | Hagaromo Otsutsuki | Hagaromo Otsutsuki |
    Then owner should redirect back to pengajuan booking page

  Scenario: Tenant Pay 1st Month Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 087708777615 | 087708777615 | qwerty123 |
    And tenant navigate to riwayat booking
    And tenant pay kost from riwayat booking using ovo "081280003230"
    And tenant navigate to riwayat booking
    And tenant checkin kost from riwayat booking
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant get invoice number

  Scenario: Admin Add Additional Price Biaya Lainnya
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number      |
      | search value           | 087708777615             |
      | invoice number         | default                  |
      | additional price type  | default                  |
      | additional price title | Automation Biaya Lainnya |
      | addtional price value  | 200000                   |

  Scenario: Tenant Check Additional Price Biaya Lainnya Added By Admin On Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 087708777615 | 087708777615 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant can see additional price "Automation Biaya Lainnya" with price "Rp200.000"

  Scenario: Owner Check Additional Price Biaya Lainnya Added By Admin On Manage Bills
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner go to bill page of kost "Kost Adi Auto SinggahSini" on month of "next"
    And owner go to detail tagihan
    Then owner can see additional price "Automation Biaya Lainnya" with price "Rp200.000"