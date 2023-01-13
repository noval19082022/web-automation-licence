@booking @essential
Feature: Booking

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag   | phone prod   |
      | 087708777615 | 087708777615 |
    And admin revoke contract

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    |  phone prod    | password  |
      | 087708777615  |  087708777615  | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod                          |
      | Kos Wild Rift DOTF Tegalrejo Yogyakarta | Kos Wild Rift DOTF Tegalrejo Yogyakarta |
    And tenant booking kost
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    |  phone prod    | password     |
      | 081362464341  |  081362464341  | 1d0lt3stb4ru |
    And owner accept booking
    Then owner should redirect back to pengajuan booking page
