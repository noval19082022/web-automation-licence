Feature: API - Get Tenant Profile

  @apiduluskuy
  Scenario Outline: Get Tenant Profile
#    Given user go to mamikos homepage
#    When user login as tenant via phone number:
#      | phone stag   | phone prod   | password   |
#      | <phone stag> | <phone prod> | <password> |
#    And playwright collect tenant cookies
#    And playwright get tenant data profile
    And playwright make json file for tenant booking from tenant profile data
    Examples:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
#      | 087708777615  | 087708777615  | qwerty123    |