@transfer-diproses @mamipay @cp-disbursement @regression @SS1

Feature: CP Disbursement - Search Transfer Diproses Disbursement

  @TEST_SS-833
  Scenario: Show disbursement ID Transfer Diproses
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin open "Transfer Diproses" tab
    Then all disbursement have id

  @TEST_SS-710 @continue
  Scenario: Search valid property name
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin open menu CP Disbursement
    And admin open "Transfer Diproses" tab
    When admin search cp disbursement by "Nama Property" using keyword "Khusus Automation"
    Then show all disbursement from property name "Kost Apik Khusus Automation PMAN Halmahera Utara"

  @TEST_SS-704 @continue
  Scenario: Search valid account number
    When admin search cp disbursement by "Nomor Rekening" using keyword "10000245429"
    Then show all disbursement from account number "10000245429"

  @TEST_SS-718 @continue
  Scenario: Filter by Transfer Status Processing
    When admin reset filter cp disbursement
    And admin search cp dibursement by transfer status "Processing"
    Then show all disbursement with status transfered "processing"

  @TEST_SS-716 @continue
  Scenario: Filter by Transfer Status Transferred
    When admin search cp dibursement by transfer status "Transferred"
    Then show all disbursement with status transfered "transferred"

  @TEST_SS-852
  Scenario: Filter by Transfer Status Transferred by System
    When admin search cp dibursement by transfer status "Transferred By System"
    Then show all disbursement with status transfered "auto transferred"