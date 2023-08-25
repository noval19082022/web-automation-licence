Feature: Create Device ID And Login

  @create_device_id_and_login
  Scenario: Register Device ID And Login
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest0891111020198     |
      | device_uuid       | Mamitest0891111020198uuid |
      | device_platform   | Mamitest                  |