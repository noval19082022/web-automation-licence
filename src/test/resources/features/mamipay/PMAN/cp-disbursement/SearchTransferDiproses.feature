@transfer-diproses @mamipay @cp-disbursement @regression @pman

Feature: CP Disbursement - Search Transfer Diproses Disbursement

  @TEST_PMAN-3302 @continue
  Scenario: Search valid property name
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin open "Transfer Diproses" tab
    When admin search cp disbursement by "Nama Property" using keyword "Khusus Automation"
    Then show all disbursement from property name "Kost Apik Khusus Automation PMAN Halmahera Utara"

  @TEST_PMAN-3304 @continue
  Scenario: Search valid account number
    When admin search cp disbursement by "Nomor Rekening" using keyword "10000245429"
    Then show all disbursement from account number "10000245429"

  @TEST_PMAN-3310 @continue
  Scenario: Filter by Transfer Status Processing
    When admin reset filter cp disbursement
    And admin search cp dibursement by transfer status "Processing"
    Then show all disbursement with status transfered "processing"

  @TEST_PMAN-3311 @continue
  Scenario: Filter by Transfer Status Transferred
    And admin search cp dibursement by transfer status "Transferred"
    Then show all disbursement with status transfered "transferred"

  @TEST_PMAN-8524
  Scenario: Filter by Transfer Status Transferred by System
    And admin search cp dibursement by transfer status "Transferred By System"
    Then show all disbursement with status transfered "auto transferred"