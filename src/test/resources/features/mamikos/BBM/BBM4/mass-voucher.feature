@regression @BBM40 @voucher @voucher-admin

Feature: Admin - Mass Voucher

  @TEST_BBM-822
  Scenario: Create Mass Voucher Prefix Without Fill Email Field
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user create new mass voucher with team "OTHER", discount type "Percentage", start date "today" and end date to "yesterday":
      | voucher name      | bbm-test-mass-voucher-automation  |
      | code              | BBM                               |
      | voucher type      | discount                          |
      | discount amount   | 50                                |
      | total quota       | 5                                 |
      | daily quota       | 1                                 |
      | max discount      | 500000                            |
      | min transaction   | 100000                            |
    And admin master tick payment rules :
      | For First DP               |
      | For First Settlement       |
      | For First Full Paid        |
      | For Recurring              |
#    And admin select contract rules :
#      | booking               |
#      | consultant            |
#      | owner                 |
#      | tenant                |
#    Then admin can sees callout message is "New mass voucher added!"
