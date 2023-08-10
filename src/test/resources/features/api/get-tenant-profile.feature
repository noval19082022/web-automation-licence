Feature: API - Get Tenant Profile

  @apiduluskuy
  Scenario Outline: Get Tenant Profile
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password   |
      | <phone stag> | <phone prod> | <password> |
    And playwright collect tenant cookies
    And playwright get tenant data profile
    And playwright make json file for tenant booking from tenant profile data
    Examples:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
#      | 087708777615  | 087708777615  | qwerty123    |

  @apiduluskuy
  Scenario Outline: Create Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password   |
      | <phone stag> | <phone prod> | <password> |
    And tenant search kost then go to kost details:
      | kost name stag           | kost name prod            |
      | Kost Adi Auto Add Ons    | Kost Adi Auto Add Ons     |
    And tenant booking kost for "today" and input rent duration equals to 2
    And playwright collect tenant cookies
    And playwright create booking for tenant
    Examples:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
#      | 087708777615  | 087708777615  | qwerty123    |