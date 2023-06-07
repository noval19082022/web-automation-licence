@DOM3
Feature: Payment All

  Background: Delete and create contract
    ##delete contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag | phone prod  |
      | 0892202100 | 08119787884 |
    And admin want to batalkan contract if exist

    ##cancel booking if tenant have booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202100 | 083176408442 | qwerty123 |
    And user cancel booking

    ##create contract
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag          | kost name prod       |
      | Desta Automation tobelo | kost payment desta 2 |
    And tenant booking kost for "today"
    And tenant logs out

    ## owner accept
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
    And owner accept booking and select the room
    Then owner should redirect back to pengajuan booking page
    And owner logs out

  @extendContract @TEST_DOM-730
  Scenario: extend contract from admin
    Given admin go to mamikos mamipay admin
    When admin search contract by tenant phone number:
      | phone stag | phone prod  |
      | 0892202100 | 08119787884 |
    And admin search contract by kost level "SinggahSini"
#  this step is comment for whale because the button is hide after ARAC project phase 1 release
#    And admin want to extend contract
#    Then admin will see detail pop up "Custom Extend Contract"
#    And admin fills duration "8" month
#    And admin click extend button
