@DOM42
Feature: Homepage

  Scenario: [Dweb][Homepage]Check cari iklan dropdown items
    Given user go to mamikos homepage
    Then tenant can see ads dropdown option

  Scenario: [Dweb][Homepage]Check profile dropdown items after login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    Then tenant can see profile dropdown option

  Scenario: [Dweb][Homepage]Check redirection kebijakan privasi on homepage
    Given user go to mamikos homepage
    And user open kebijakan privasi in footer
    Then user should redirect to kebijakan privasi page

  Scenario: [Dweb][Homepage]Check redirection syarat dan ketentuan on homepage
    Given user go to mamikos homepage
    And user open syarat dan ketentuan in footer
    Then user should redirect to link "https://help.mamikos.com/post/syarat-dan-ketentuan-umum"

  Scenario: [Dweb][Homepage]Check redirection tentang kami on homepage
    Given user go to mamikos homepage
    When user open tentang kami in footer
    Then user should redirect to link that contains "/tentang-kami"

  Scenario: [Dweb][Homepage]Check redirection job mamikos on homepage
    Given user go to mamikos homepage
    When user open job mamikos in footer
    Then user should redirect to link that contains "/career"

  Scenario: [Dweb][Homepage]Check redirection promosikan kost anda on homepage
    Given user go to mamikos homepage
    When user open promosikan kost anda in footer
    Then user should redirect to link that contains "/mamiads"

  Scenario: [Dweb][Homepage]Check redirection pusat bantuan on homepage
    Given user go to mamikos homepage
    When user open pusat bantuan in footer
    Then user should redirect to link "https://help.mamikos.com/"

  Scenario: [Dweb][Homepage]Check redirection facebook on homepage
    Given user go to mamikos homepage
    When user open facebook in footer
    Then user should redirect to link that contains "https://www.facebook.com/mamikosapp/"

  Scenario: [Dweb][Homepage]Check redirection twitter on homepage
    Given user go to mamikos homepage
    When user open twitter in footer
    Then user should redirect to link that contains "https://twitter.com/mamikosapp"

  Scenario: [Dweb][Homepage]Check redirection instagram on homepage
    Given user go to mamikos homepage
    When user open instagram in footer
    Then user should redirect to link that contains "https://www.instagram.com/mamikosapp/"

  Scenario: [Dweb][Homepage]Check redirection e-mail on homepage
    Given user go to mamikos homepage
    When user open e-mail in footer
    Then user should redirect to Form Bantuan page

  Scenario: [Dweb][Homepage]Check redirection whatsapp on homepage
    Given user go to mamikos homepage
    When user open whatsapp in footer
    Then user should redirect to link that contains "https://api.whatsapp.com/send/?phone=6281325111171"

  Scenario: [Dweb][Homepage]Check copyright on footer on homepage
    Given user go to mamikos homepage
    Then user can see copyright is "© 2023 Mamikos.com, All rights reserved"