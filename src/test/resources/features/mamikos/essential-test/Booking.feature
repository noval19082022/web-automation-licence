Feature: Booking

  @user @booking
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