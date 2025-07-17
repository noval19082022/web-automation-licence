@essential @finalcontextimplement
Feature: Login Tenant

#  @continue @context1
  Scenario: Login Tenant With Phone Number
#    Given tenant set browser context to "context1"
    When user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 087708777615 | 087708777615 | qwerty123 |

#  @context2
  Scenario: Login as owner
#    Given owner set browser context to "context2"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |

#  Scenario: Login Tenant With Phone Number
#    Given user go to mamikos homepage
#    When user login as tenant via facebook
#    Then tenant redirect back to homepage
#
#  Scenario: Login Tenant With Phone Number
#    Given user go to mamikos homepage
#    When user login as tenant via google
#    Then tenant redirect back to homepage