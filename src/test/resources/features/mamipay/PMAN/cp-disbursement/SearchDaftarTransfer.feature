@daftar-transfer @mamipay @cp-disbursement @regression @pman

  Feature: CP Disbursement - Search Daftar Transfer Disbursement

    @TEST_PMAN-7764
    Scenario: Show disbursement ID Daftar Transfer
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
      And admin open menu CP Disbursement
      Then all disbursement have id

    @TEST_PMAN-3294 @continue
    Scenario: Search using invalid property name
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
      And admin open menu CP Disbursement
      And admin search cp disbursement by "Nama Property" using keyword "abc123"
      Then show "Daftar Transfer" empty page

    @TEST_PMAN-3293 @continue
    Scenario: Search using valid property name
      When admin search cp disbursement by "Nama Property" using keyword "Khusus Automation"
      Then show all disbursement from property name "Kost Apik Khusus Automation PMAN Halmahera Utara"

    @TEST_PMAN-3298 @continue
    Scenario: Search using invalid account name
      When admin search cp disbursement by "Nama Pemilik Rekening" using keyword "abc123"
      Then show "Daftar Transfer" empty page

    @TEST_PMAN-3297 @continue
    Scenario: Search using valid account name
      When admin search cp disbursement by "Nama Pemilik Rekening" using keyword "Yudha Ferroza"
      Then show all disbursement from account name "Yudha Ferroza"

    @TEST_PMAN-3296 @continue
    Scenario: Search using invalid account number
      When admin search cp disbursement by "Nomor Rekening" using keyword "abc123"
      Then show "Daftar Transfer" empty page

    @TEST_PMAN-3295
    Scenario: Search using valid account number
      When admin search cp disbursement by "Nomor Rekening" using keyword "10000245429"
      Then show all disbursement from account number "10000245429"