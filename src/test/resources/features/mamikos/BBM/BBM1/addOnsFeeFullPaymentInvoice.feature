@regression @addons @BBM1 @TEST_BBM-996 @TEST_BBM-997 @TEST_BBM-998
Feature: Add Ons - Fee Full Payment Invoice

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
    And tenant booking kost for "today" and input rent duration equals to 2
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

  @continue
  Scenario: Admin Master Add, Add Ons Fee To Full Payment Invoice
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

  Scenario: Edit Add Ons Free Amount With Char Through Detail Fee
    When admin edit additional fee price amount to "20011rrr"
    Then admins can sees error message