@SS1 @regression @admin @kost-level

Feature: Kost Level

  @TEST_SS-565 @continue
  Scenario: Charging fee can't more than 100%
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    When admin go to kost level menu
      #add charging fee >100%
    And admin add new kost level "Test Charging Fee" with charging fee "200"
    Then show error message pop up "The charging fee cannot be greater than 100"
      #edit charging fee >100%
    When admin go to kost level menu
    And admin search kost level "test upras"
    And admin edit charging fee to "200"
    Then show error message pop up "The charging fee cannot be greater than 100"

  @TEST_SS-597
  Scenario: Checks Kost Level Display
    When admin go to kost level menu
    Then kost level column contains
      | ID                  |
      | Level Name          |
      | Key                 |
      | Benefit             |
      | Criteria            |
      | Status              |
      | Room Level          |

      | Charging            |
        # Sub Column of Charging
      | Fee                 |
      | Type                |

      | Charge for Contract |
        # Sub Column of Charge for Contract
      | Booking             |
      | Consultant          |
      | Owner               |

      | Invoice Type        |
      | Values              |
      | Notes               |
      | Actions             |
    Then show button add kost level
    And show field and button search kost level
    And admin clicks on page number "2" of kost level
    Then system display kost level page number "2" is active