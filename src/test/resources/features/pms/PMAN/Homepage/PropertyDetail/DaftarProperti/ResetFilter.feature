@regression @pman2 @pms

Feature: Reset Filter in Homepage

  @TEST_PMAN-3584
  Scenario: Filter by BSE
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin clicks on Filter button
    And admin filter by BSE "Maya BSE"
    And admin selects Kota "Kabupaten Bandung"
    And admin clicks Terapkan button
    Then the system is displaying property with BSE "Maya BSE"
    And the system is displaying kota "Kabupaten Bandung"

    When admin reset filter in Homepage
    Then the system is displaying reset filter
