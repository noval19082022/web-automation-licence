@DOM1
Feature: Blacklist User

  @continue
  Scenario: Admin login into bangkerupux
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |

  @continue @TEST_COOP-5158
  Scenario Outline: [WEB][Blacklist][Filter] Admin search filter by <dropDown>
    Given admin go to mamikos bangkrupux admin
    When user access menu blacklist user
    Then user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    Examples:
      | dropDown     | value                                   |
      | phone_number | 089536519944                            |
      | email        | lisagor_jiuogfi_rosenthalwitz@tfbnw.net |

  @continue @TEST_COOP-5156
  Scenario: [WEB][Blacklist] Display User overview before Admin add blacklist user
    When user click blacklist a user button
    And user add with phone number "089536519944"
    Then user see overview blacklist user data

  @TEST_COOP-5152
  Scenario: [WEB][Blacklist] Admin Add blacklist user
    When user fill note "Blacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message

  @TEST_COOP-5155
  Scenario: [WEB][Blacklist] After blacklist user try to login via homepage
    Given user go to mamikos homepage
    And user click on button masuk pencari kos
    And user login from kost detail via phone number:
      | phone stag    | phone prod    | password     |
      | 089536519944  | 089536519944  | qwerty123    |
    Then user see message error validation "Ada kendala pada akun Anda. Harap hubungi customer service Mamikos."

  @TEST_COOP-5145
  Scenario: [WEB][Blacklist] After blacklist user try login via detail kost
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    And user want to reached map section and see lihat peta button
    And user want to see more detail kost location
    And user login from kost detail via phone number:
      | phone stag    | phone prod    | password     |
      | 089536519944  | 089536519944  | qwerty123    |
    Then user see message error validation "Ada kendala pada akun Anda. Harap hubungi customer service Mamikos."

  @TEST_COOP-5148
  Scenario Outline: [WEB][Blacklist] Admin Unblacklist user
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And user access menu blacklist user
    And user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    And user click on unblacklist
    And user fill note "Unblacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message
    Examples:
      | dropDown     | value                                   |
      | phone_number | 089536519944                            |

  @TEST_DOM-3836 @TEST_COOP-5159
  Scenario: [WEB][Blacklist] After unblacklist user try to login
    Given user go to mamikos homepage
    Then user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089536519944 | 089536519944 | qwerty123 |

  @continue @TEST_COOP-5146
  Scenario Outline: [WEB][Blacklist] Admin Add blacklist user from homepage blacklist user
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
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
      | dropDown     | value                                   |
      | phone_number | 089536519944                            |

  @TEST_DOM-2639 @TEST_COOP-5154 @continue
  Scenario Outline: [WEB][Blacklist] After blacklist email user try login via Facebook
    When user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    And user click blacklist on homepage blacklist
    And user fill note "Blacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message
    Examples:
      | dropDown     | value                                   |
      | email        | lisagor_jiuogfi_rosenthalwitz@tfbnw.net |

  @TEST_DOM-2639 @TEST_COOP-5149
  Scenario: User try login via Facebook
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                               |  email prod                               | password  |
      | lisagor_jiuogfi_rosenthalwitz@tfbnw.net  |  lisagor_jiuogfi_rosenthalwitz@tfbnw.net  | mamikosqa |
    Then user see message error validation "Ada kendala pada akun Anda. Harap hubungi customer service Mamikos."

  @TEST_DOM-2639 @TEST_COOP-5148
  Scenario Outline: [WEB][Blacklist] Admin Unblacklist user
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And user access menu blacklist user
    And user choose dropdown "<dropDown>" enter value "<value>" and validate filter result "<value>"
    And user click on unblacklist
    And user fill note "Unblacklist by Automation"
    And user click button submit
    Then user see blacklist updated success message
    Examples:
      | dropDown     | value                                   |
      | email        | lisagor_jiuogfi_rosenthalwitz@tfbnw.net |