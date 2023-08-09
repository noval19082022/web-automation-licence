Feature: API - Get Tenant Profile

  @apiduluskuy
  Scenario: Get Tenant Profile
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And playwright collect tenant cookies