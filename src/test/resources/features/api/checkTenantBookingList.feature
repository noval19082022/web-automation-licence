Feature: Tenant Booking List API

  @gettenantliskbooking
  Scenario: Get Tenant Booking Status
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And playwright collect tenant cookies
    Then playwright get tenant booking status with parameter:
      | page | 1 |
      | sort | |
      | status | booked |