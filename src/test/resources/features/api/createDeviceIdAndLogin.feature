@create_device_id_and_login
Feature: Create Device ID And Login
  #songId = roomId / on PMS listing id

  @continue
  Scenario: Register Device ID And Login
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest0891111020198     |
      | device_uuid       | Mamitest0891111020198uuid |
      | device_platform   | Mamitest                  |
      | phone_number      | 0891111020198             |
      | password          | mamikosqa123              |
    When tenant login trough api

  @continue
  Scenario: Playwright Create Booking
    And playwright get tenant data profile
    And playwright get kos detail:
      | songId | 39645784 |
    And playwright make json file for tenant booking from tenant profile data
    And playwright create booking for tenant:
      | songId     | 39645784 |
      | roomTypeId | 6230     |

  @continue
  Scenario Outline: Get Tenant Pengajuan Sewa Status
    And playwright get tenant booking status with parameter:
      | page   | 1        |
      | sort   |          |
      | status | <status> |
    Examples:
      | status     |
      | booked     |
      | confirmed  |
      | verified   |
      | checked_in |

  @continue
  Scenario: Tenant Batalkan Booking
    And playwright batalkan pengajuan sewa for tenant