@pman @pms @homepage

Feature: Homepage menu

  @TEST_PMAN-3594
  Scenario: Check empty state in Homepage menu
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin search property "Lalala"
    Then empty state in Homepage menu is displayed