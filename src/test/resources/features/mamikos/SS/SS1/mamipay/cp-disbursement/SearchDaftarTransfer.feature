@daftar-transfer @mamipay @cp-disbursement @regression @SS1

Feature: CP Disbursement - Search Daftar Transfer Disbursement

  @TEST_SS-844
  Scenario: Show disbursement ID Daftar Transfer
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    Then all disbursement have id

  @TEST_SS-708 @continue
  Scenario: Search using invalid property name
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin search cp disbursement by "Nama Property" using keyword "abc123"
    Then show "Daftar Transfer" empty page

  @TEST_SS-710 @continue
  Scenario: Search using valid property name
    When admin search cp disbursement by "Nama Property" using keyword "Khusus Automation"
    Then show all disbursement from property name "Kost Apik Khusus Automation PMAN Halmahera Utara"

  @TEST_SS-700 @continue
  Scenario: Search using invalid account name
    When admin search cp disbursement by "Nama Pemilik Rekening" using keyword "abc123"
    Then show "Daftar Transfer" empty page

  @TEST_SS-702 @continue
  Scenario: Search using valid account name
    When admin search cp disbursement by "Nama Pemilik Rekening" using keyword "Yudha Ferroza"
    Then show all disbursement from account name "Yudha Ferroza"

  @TEST_SS-712 @continue
  Scenario: Search using invalid account number
    When admin search cp disbursement by "Nomor Rekening" using keyword "abc123"
    Then show "Daftar Transfer" empty page

  @TEST_SS-715
  Scenario: Search using valid account number
    When admin search cp disbursement by "Nomor Rekening" using keyword "10000245429"
    Then show all disbursement from account number "10000245429"