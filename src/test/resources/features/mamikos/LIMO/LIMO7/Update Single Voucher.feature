@LIMO7
Feature: Admin - Update Single Voucher

  @continue
  Scenario: Create Single Voucher Prefix Without Fill Email Field
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user create new single voucher with team "OTHER", discount type "Percentage", start date "today" and end date to "" without email:
      | voucher name         | bbm-test-automation |
      | voucher type         | discount            |
      | total targeted email | 10                  |
      | total each quota     | 5                   |
      | discount amount      | 50                  |
      | total each kos quota | 5                   |
      | daily quota          | 1                   |
      | max discount         | 500000              |
      | min transaction      | 100000              |
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

  @TEST_SS-4277 @continue
  Scenario: Update Single Voucher
    Given admin go to mamikos mamipay admin
    And admin search single voucher with name and edit index "1":
      | voucher name stag | voucher name prod |
      | BBM               | BBM               |
    Then user create new mass voucher with:
      | campaign title | Krezi Ollie                               |
      | campaign T&C   | Terbullie gara gara bakso di mass voucher |
    And admin master upload voucher campaign image
    And admin select important rules :
      | Publish |
    And admin master clicks on edit single voucher button in voucher form
    Then admin can sees callout message contains "Voucher bbm-test-automation updated"

  Scenario: Voucher Status Inactive
    Given admin go to mamikos mamipay admin
    And admin search single voucher with name and edit index "1":
      | voucher name stag | voucher name prod |
      | BBM               | BBM               |
    And admin uncheck important rules :
      | Active |
    And admin master clicks on edit single voucher button in voucher form
    Then admin can sees callout message contains "Voucher bbm-test-automation updated"
		
