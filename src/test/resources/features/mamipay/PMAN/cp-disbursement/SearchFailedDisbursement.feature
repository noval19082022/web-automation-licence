@transfer-gagal @mamipay @cp-disbursement @regression @pman

Feature: CP Disbursement - Search Failed Disbursement

  @TEST_PMAN-8818
  Scenario: Show disbursement ID Failed Disbursement
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin open "Transfer Gagal" tab
    Then all disbursement have id

  @TEST_PMAN-3314 @continue
  Scenario: Search using invalid property name
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin open "Transfer Gagal" tab
    When admin search cp disbursement by "Nama Property" using keyword "abc123"
    Then show "Transfer Gagal" empty page

  @TEST_PMAN-3313 @continue
  Scenario: Search using valid property name
    When admin search cp disbursement by "Nama Property" using keyword "Khusus Automation"
    Then show all disbursement from property name "Kost Apik Khusus Automation PMAN Halmahera Utara"

  @TEST_PMAN-3317 @continue
  Scenario: Search valid account name
    When admin search cp disbursement by "Nama Pemilik Rekening" using keyword "Yudha Ferroza"
    Then show all disbursement from account name "Yudha Ferroza"

  @TEST_PMAN-3315 @continue
  Scenario: Search valid account number
    When admin search cp disbursement by "Nomor Rekening" using keyword "10000245429"
    Then show all disbursement from account number "10000245429"

  @TEST_PMAN-3316 @continue
  Scenario: Search invalid account number
    When admin search cp disbursement by "Nomor Rekening" using keyword "abc123"
    Then show "Transfer Gagal" empty page

  @TEST_PMAN-3323
  Scenario: Reset Search and Filter
    When admin reset filter cp disbursement
    Then filter reset to default
