@LIMO7
Feature: [Web][Voucher]Admin - Single Voucher

  @TEST_SS-4275 @LIMO-235
  Scenario: Create Targeted Voucher Fill Email Field
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user create new single voucher with team "OTHER", discount type "Percentage", start date "today" and end date to "":
      | voucher name         | teng-test-automation                         |
      | voucher type         | discount                                     |
      | total targeted email | 2                                            |
      | total each quota     | 5                                            |
      | discount amount      | 50                                           |
      | total each kos quota | 5                                            |
      | daily quota          | 1                                            |
      | max discount         | 500000                                       |
      | min transaction      | 100000                                       |
      | targeted email       | putriani.laila@gmail.com,tenantsla@gmail.com |
    And admin master inputs prefix voucher code "BBM"
    And admin master tick payment rules :
      | For First DP         |
      | For First Settlement |
      | For First Full Paid  |
      | For Recurring        |
    And admin select contract rules :
      | From Booking Funnel |
      | From Consultant     |
      | From Tenant         |
      | From Owner          |
    And admin select important rules :
      | Active      |
      | For Testing |
    And admin master clicks on add single voucher button in voucher form
    Then admin can sees callout message is "New targeted voucher added!"
		
