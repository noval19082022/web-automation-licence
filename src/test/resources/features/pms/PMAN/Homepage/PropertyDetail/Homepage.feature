@pman @pms @homepage

Feature: Homepage menu

  @TEST_PMAN-3594 @continue
  Scenario: Check empty state in Homepage menu
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin search property "Lalala"
    Then empty state in Homepage menu is displayed

  @TEST_PMAN-3597 @continue
  Scenario: View Detail Property Page
    When admin go to detail property "3143"
    Then admin redirect to detail property page

  @TEST_PMAN-3598 @continue
  Scenario: View Room Allotment Page
    When admin go to Homepage
    And admin search property using ID "3143"
    And admin go to Ketersediaan Kamar in Homepage action button
    Then admin redirect to room allotment page

  @TEST_PMAN-3583
  Scenario: Apply Some Filters
    When admin go to Homepage
    And admin Filter data in Homepage
    Then property is displayed