@SS9
Feature: Blacklist User

  @continue
  Scenario: Admin login into bangkerupux
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |

  @continue @TEST_SS-2827 @TEST_SS-2828
  Scenario Outline: [WEB][Blacklist][Filter] Admin search filter by <dropDown>
    When user access menu blacklist user
    Then user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    Examples:
      | dropDown     | value                    |
      | phone_number | 089536519944             |
      | email        | coop.blacklist@gmail.com |

  @continue @TEST_SS-2826
  Scenario: [WEB][Blacklist] Display User overview before Admin add blacklist user
    When user click blacklist a user button
    And user add with phone number "089536519944"
    Then user see overview blacklist user data

  @continue @TEST_SS-2822
  Scenario: [WEB][Blacklist] Admin Add blacklist user
    When user fill note "Blacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message

  @TEST_SS-2830
  Scenario: [WEB][Blacklist] Admin blacklist user by UserID
    When user click blacklist a user button
    And user add with user ID "99451922"
    And user fill note "Blacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message

  @TEST_SS-2825 @TEST_SS-2821 @TEST_SS-2823
  Scenario: [WEB][Blacklist] After blacklist user try to login via homepage
    Given user go to mamikos homepage
    And user click on button masuk pencari kos
    And user login from kost detail via phone number:
      | phone stag   | phone prod   | password  |
      | 089536519944 | 089536519944 | qwerty123 |
    Then user see message error validation "Ada kendala pada akun Anda. Harap hubungi customer service Mamikos."

  @TEST_SS-2816
  Scenario: [WEB][Blacklist] After blacklist user try login via detail kost
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                 | kost path prod                                                 |
      | kost-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-c | kost-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-c |
    And user want to reached map section and see lihat peta button
    And user want to see more detail kost location
    And user login from kost detail via phone number:
      | phone stag   | phone prod   | password  |
      | 089536519944 | 089536519944 | qwerty123 |
    Then user see message error validation "Ada kendala pada akun Anda. Harap hubungi customer service Mamikos."

  @TEST_SS-2818
  Scenario Outline: [WEB][Blacklist] Admin Unblacklist user
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user access menu blacklist user
    And user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    And user click on unblacklist
    And user fill note "Unblacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message
    Examples:
      | dropDown     | value        |
      | phone_number | 089536519944 |

  @TEST_DOM-3836 @TEST_SS-2829
  Scenario: [WEB][Blacklist] After unblacklist user try to login
    Given user go to mamikos homepage
    Then user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089536519944 | 089536519944 | qwerty123 |

  @TEST_SS-2817
  Scenario Outline: [WEB][Blacklist] Admin Add blacklist user from homepage blacklist user
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user access menu blacklist user
    And user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    And user click blacklist on homepage blacklist
    And user fill note "Blacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message
    When user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    And user click on unblacklist
    And user fill note "Unblacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message
    Examples:
      | dropDown     | value        |
      | phone_number | 089536519944 |

  @TEST_DOM-2639 @TEST_SS-2824
  Scenario Outline: [WEB][Blacklist] After blacklist email user try login via Facebook
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user access menu blacklist user
    When user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    And user click blacklist on homepage blacklist
    And user fill note "Blacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message
    Examples:
      | dropDown | value                    |
      | email    | coop.blacklist@gmail.com |

  @TEST_DOM-2639 @TEST_SS-2819
  Scenario: User try login via Facebook
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                 | email prod               | password   |
      | febiregression21@gmail.com | coop.blacklist@gmail.com | F3b1qwerty |
    Then user see message error validation "Ada kendala pada akun Anda. Harap hubungi customer service Mamikos."

  @TEST_DOM-2639 @TEST_SS-2818
  Scenario Outline: [WEB][Blacklist] Admin Unblacklist user
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user access menu blacklist user
    And user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    And user click on unblacklist
    And user fill note "Unblacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message
    Examples:
      | dropDown | value                    |
      | email    | coop.blacklist@gmail.com |
      | user_id  | 99451922                 |

  @TEST_SS-2820
  Scenario: [WEB][Blacklist][Filter] Admin search filter by userID
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user access menu blacklist user
    Then user choose dropdown "user_id" enter value "99452482" and validate filter result "Gorby Mamiteam"
