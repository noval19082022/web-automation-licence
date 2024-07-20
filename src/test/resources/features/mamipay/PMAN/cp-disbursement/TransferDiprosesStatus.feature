@mamipay @cp-disbursement @transfer-diproses @regression @pman

  Feature: CP Disbursement - Transfer Diproses Status

    @TEST_SS-729
    Scenario: Disbursement data contains all status transfer
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
      And admin open menu CP Disbursement
      And admin open "Transfer Diproses" tab
      Then disbursement data contains status "processing"
      And disbursement data contains status "auto transferred"
      And disbursement data contains status "transferred"