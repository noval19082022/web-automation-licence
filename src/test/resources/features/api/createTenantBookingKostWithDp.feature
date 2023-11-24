@bookingkostapidp
Feature: Booking Kost With DP

  @continue
  Scenario: Get And Create Tenant Data Add Ons - Extended Contract
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

  @continue
  Scenario Outline: Get Active Contract And Active Booking For Add Ons - Extended Contract
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

  @continue
  Scenario: Verify Active Contract And Active Booking For Add Ons - Extended Contract
    When playwright check for active contract and active booking

  @continue
  Scenario: Tenant Batalkan Pengajuan Sewa For Add Ons - Extended Contract
    And playwright batalkan pengajuan sewa for tenant

  @continue @apiflow
  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0891111020198 | 0891111020198 |

  @continue
  Scenario: Playwright Create Booking
    And playwright get tenant data profile
    And playwright get kos detail:
      | songId | 58650684 |
    And playwright make json file for tenant booking from tenant profile data
    And playwright create booking for tenant:
      | songId     | 39645784 |
      | roomTypeId | 6230     |