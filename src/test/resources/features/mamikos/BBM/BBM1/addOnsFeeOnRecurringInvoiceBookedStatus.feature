@regression @addons @TEST_BBM-1180 @BBM1

Feature: Add Ons Fee On Recurring Invoice With Booked Status

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
      | kost name stag           | kost name prod           |
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
      | Irvi Tenant Add Ons  | Irvi Tenant Add Ons  |
    Then owner should redirect back to pengajuan booking page

  Scenario: Admin Master Add, Add Ons Fee
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
    Then admin can sees total cost is basic amount + add ons fee + admin fee

  @continue
  Scenario: Tenant Pay 1st Month Booking For Add Ons
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230"
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    Then tenant navigate to tagihan kost saya

    Scenario: add ons fee on recurring from add ons that added on first invoice with booked status
      When tenant navigate to tagihan kost saya
      And tenant go to invoice page
      And tenant set active page to 1
      Then tenant can see additional price "adiautomation" with price "Rp100.000"
      When tenant make bill payments using ovo
      Then tenant can see additional price "adiautomation" with price "Rp100.000"


