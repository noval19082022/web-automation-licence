Feature: Create Device ID And Login

  @create_device_id_and_login
  Scenario: Register Device ID And Login
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest0891111020198     |
      | device_uuid       | Mamitest0891111020198uuid |
      | device_platform   | Mamitest                  |
      | phone_number      | 0891111020198             |
      | password | mamikosqa123 |
    When tenant login trough api
    And playwright get tenant data profile
    And playwright make json file for tenant booking from tenant profile data
    Then playwright create booking for tenant
