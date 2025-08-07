@SS3
Feature: addOns Created On Invoice Search Contract Flow Extended Contract


  @SS-3772
  Scenario: [Add Ons - Extended Contract] Get And Create Tenant Data Add Ons
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest0891111020198     |
      | device_uuid       | Mamitest0891111020198uuid |
      | device_platform   | Mamitest                  |
      | phone_number      | 0891111020198             |
      | password          | mamikosqa123              |
    When tenant login trough api
    And playwright get tenant data profile
    And playwright get kos detail:
      | songId | 39645784 |
    And playwright make json file for tenant booking from tenant profile data

  @@SS-4877
  Scenario: [Add Ons - Extended Contract] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0891111020198 | 0891111020198 |

  @SS-3775
  Scenario: [Add Ons - Extended Contract] Playwright create booking
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest0891111020198     |
      | device_uuid       | Mamitest0891111020198uuid |
      | device_platform   | Mamitest                  |
      | phone_number      | 0891111020198             |
      | password          | mamikosqa123              |
    And playwright get tenant data profile
    And playwright get kos detail:
      | songId | 58650684 |
    And playwright make json file for tenant booking from tenant profile data
    And playwright create booking for tenant:
      | songId     | 58650684 |
      | roomTypeId | 6194     |

  @SS-3776
  Scenario: [Add Ons - Extended Contract] Owner accept booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag         | tenant prod         |
      | Irvi Tenant Add Ons | Irvi Tenant Add Ons |
    Then owner should redirect back to pengajuan booking page

  @SS-3777
  Scenario: [Add Ons - Extended Contract] Tenant Pay 1st Month Booking For Add Ons
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230"
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking

  @SS-3778
  Scenario: [Add Ons - Extended Contract] Admin Master Add, Add Ons Fee On Auto Extend Invoice With Booked Status
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number |
      | search value           | 0891111020198       |
      | invoice number         | default             |
      | additional price type  | Add On              |
      | additional price title | Laundry             |
      | addtional price value  | 100000              |
    Then admin can sees total cost is basic amount + add ons fee + admin fee

  @SS-3779
  Scenario: [Add Ons - Extended Contract] Tenant Pay Booking 2nd Month For Add Ons Flow Extended Contract
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant pay booking to extended contract using ovo "081280003230"

  @SS-3780
  Scenario: [Add Ons - Extended Contract] Admin Master Verify That Add Ons Successfully Added To Tenant Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag    | phone prod    |
      | 0891111020198 | 0891111020198 |
    And admin clicks on invoice number "2" on first index contract
    And tenant set active page to 1
    Then tenant can see additional price "Laundry" with price "Rp100.000"

  @SS-3783
  Scenario Outline: [Add Ons - Extended Contract] Get Active Contract And Active Booking For Add Ons
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest0891111020198     |
      | device_uuid       | Mamitest0891111020198uuid |
      | device_platform   | Mamitest                  |
      | phone_number      | 0891111020198             |
      | password          | mamikosqa123              |
    When playwright get tenant booking status with parameter:
      | page   |           |
      | sort   |           |
      | status | <booking> |
    Examples:
      | booking    |
      | booked     |
      | confirmed  |
      | verified   |
      | checked_in |

  @SS-3782
  Scenario: [Add Ons - Extended Contract] Verify Active Contract And Active Booking For Add Ons
    When playwright check for active contract and active booking

  @SS-3781
  Scenario: [Add Ons - Extended Contract] Tenant Batalkan Pengajuan Sewa For Add Ons
    And playwright batalkan pengajuan sewa for tenant
		
