@essential
Feature: Login Tenant

  @tenant @owner @larilagi
  Scenario: Login Tenant With Phone Number
    Given tenant open browser page "0"
    When user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag    |  phone prod    | password  |
      | 087708777615  |  087708777615  | qwerty123 |
    When owner open browser page "0"
    When user login as owner:
      | phone stag    |  phone prod    | password     |
      | 081362464341  |  081362464341  | 1d0lt3stb4ru |

  @owner @example3 @example4 @lari
  Scenario: Login as owner
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    |  phone prod    | password     |
      | 081362464341  |  081362464341  | 1d0lt3stb4ru |

#  Scenario: Login Tenant With Phone Number
#    Given user go to mamikos homepage
#    When user login as tenant via facebook
#    Then tenant redirect back to homepage
#
#  Scenario: Login Tenant With Phone Number
#    Given user go to mamikos homepage
#    When user login as tenant via google
#    Then tenant redirect back to homepage