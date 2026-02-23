@LIMO7
Feature: Voucher Discount - Partner Voucher

  @TEST_SS-4274 @Automated @SS @Web @continue
  Scenario: Delete existing voucher code
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user access Partner voucher page
    And user edit voucher "adiautomate" in index "1" and set voucher code is ""
    And admin master clicks on edit Partner voucher button in voucher form
    Then failed update voucher and display text validation "The Voucher Code field is required."

  @continue
  Scenario: Update unique voucher campaign data & published check box
    Given admin go to mamikos mamipay admin
    And user access Partner voucher page
    And user edit voucher "adiautomate" in index "1" and set voucher title is "test"
    And admin select important rules :
      | Publish |
    And admin master clicks on edit Partner voucher button in voucher form
    Then admin can sees callout message contains "Voucher Partner [adiautomate] has been successfully updated"

  @continue
  Scenario: Update unique voucher data with voucher code already exist
    Given admin go to mamikos mamipay admin
    And user access Partner voucher page
    And user edit voucher "adiautomate" in index "1" and set voucher code is "imagelaravelpartner"
    And admin master clicks on edit Partner voucher button in voucher form
    Then failed update voucher and display text validation "Voucher Codes [imagelaravelpartner] already exists in other campaign."

  @continue
  Scenario: Update unique voucher data
    Given admin go to mamikos mamipay admin
    And user access Partner voucher page
    And user edit voucher "ADIAUTOMATE" in index "1" and set voucher code is "ADIAUTOMATE12345678"
    And admin master clicks on edit Partner voucher button in voucher form
    Then admin can sees callout message contains "Voucher Partner [adiautomate] has been successfully updated"
    And user edit voucher "ADIAUTOMATE12345678" in index "1" and set voucher code is "ADIAUTOMATE"
    And admin master clicks on edit Partner voucher button in voucher form
    Then admin can sees callout message contains "Voucher Partner [adiautomate] has been successfully updated"

  @continue
  Scenario: Add/update published voucher without fill campaign field
    Given admin go to mamikos mamipay admin
    And user access Partner voucher page
    And user create new partner voucher:
      | voucher code | testAutomation |
      | total quota  | 2              |
    And admin select important rules :
      | Publish |
    And admin master clicks on add Partner voucher button in voucher form
    Then user see validation error field is required
      | The Campaign Title field is required.                 |
      | The Campaign Image field is required.                 |
      | The Campaign Terms & Conditions field is required.    |
      | The Campaign Name / Partner Name field is required.   |
      | The Start Date field is required.                     |
      | Manual Target require one of field in TARGET section. |

  @continue
  Scenario: Add/update voucher without fill required field
    Given admin go to mamikos mamipay admin
    And user access Partner voucher page
    And user add bulk add voucher partners
    And admin master clicks on add Partner voucher button in voucher form
    Then user see validation error field is required
      | The Campaign Name / Partner Name field is required.   |
      | The Voucher Code field is required.                   |
      | The Start Date field is required.                     |
      | The Total Quota field is required.                    |
      | Manual Target require one of field in TARGET section. |

  @continue
  Scenario: Voucher code number less than email/user id
    Given admin go to mamikos mamipay admin
    And user access Partner voucher page
    And user edit voucher "ADIAUTOMATE" in index "1" and set voucher code is "voucherTest1,voucherTest2,voucherTest3"
    And admin master clicks on edit Partner voucher button in voucher form
    Then user see validation error field is required
      | Voucher General cannot have more than 1 code.        |
      | Email count must be the same with voucher code count |

  Scenario: Add or Update voucher with more than 1 voucher code
    Given admin go to mamikos mamipay admin
    And user access Partner voucher page
    And user edit voucher "cobalagi1" in index "1" and set voucher code is "cobalagi1,cobalagi1,cobalagi1"
    And admin master clicks on edit Partner voucher button in voucher form
    Then admin can sees callout message contains "Voucher Partner [cobalagi] has been successfully updated"
		
