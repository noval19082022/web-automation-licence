@COOP1
Feature: addOns Fee Recurring Invoice Negative


  @SS-4945
  Scenario: [Add Ons - Fee Recurring Invoice Negative Scenario] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0891111020198 | 0891111020198 |
    And admin akhiri contract
    Then admin should success terminate contract

  @SS-4946 @continue
  Scenario: [Add Ons - Fee Recurring Invoice Negative Scenario] Admin cancel contract
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And user cancel booking

  @SS-4947
  Scenario: [Add Ons - Fee Recurring Invoice Negative Scenario] Tenant booking kos
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                    | kost path prod        |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-adi-automation-add-ons  | Kost Adi Auto Add Ons |
    And tenant booking kost for "today" and input rent duration equals to 2
    Then tenant should success booking kost

  @SS-4948
  Scenario: [Add Ons - Fee Recurring Invoice Negative Scenario] Owner accept booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag         | tenant prod         |
      | Irvi Tenant Add Ons | Irvi Tenant Add Ons |
    Then owner should redirect back to pengajuan booking page

  @SS-4949 @continue
  Scenario: [Add Ons - Fee Recurring Invoice Negative Scenario] Tenant Pay 1st Month Booking For Add Ons
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

  @SS-4950
  Scenario: [Add Ons - Fee Recurring Invoice Negative Scenario] Tenant Check-in To Kost For Add Ons Fee Recurring Auto Extend Invoice And Check Add Ons Requirement
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant can not sees add on price on payment page
    And tenant pay booking to extended contract using ovo "0891111020198" without close the page
    Then tenant can not sees add on price on payment page after pay
