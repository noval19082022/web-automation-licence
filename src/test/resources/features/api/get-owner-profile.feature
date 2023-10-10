@skuyloginownerlewatapi
Feature: Get Owner Profile

  Scenario: Create Owner DeviceId
    When playwright create register device id for owner with parameters:
      | device_identifier | Mamitest08900000000021     |
      | device_uuid       | Mamitest08900000000021uuid |
      | device_platform   | Mamitest                   |
      | phone_number      | 08900000000021             |
      | password          | mamikosqa123               |
    When owner login trough api
    And playwright get owner profile
    And playwright get owner room booking detail
    And playwright get owner booking list with parameters:
      | offset |   |
      | group  |   |
      | limit  | 1 |
    And playwright get owner booking accept details
    And playwright get owner available room for kos with id:
      | kos id | 1      |
    And playwright set accept booking data for owner
    And playwright create body accept booking for owner