@skuyloginownerlewatapi
Feature: Owner API

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
    And playwright get owner available room for kos with id:
      | kos id | 58650684 |
    And playwright get room allotment or available room for kos with id:
      | kos id | 58650684 |