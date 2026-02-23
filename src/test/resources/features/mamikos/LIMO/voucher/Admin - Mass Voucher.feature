@LIMO7
Feature: [Web][Voucher] Admin - Mass Voucher

  @TEST_SS-4272 @Automated @continue
  Scenario: Create Mass Voucher Prefix Without Fill Email Field
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user create new mass voucher with team "OTHER", discount type "Percentage", start date "today" and end date to "":
      | voucher name    | bbm-test-mass-voucher-automation |
      | voucher type    | discount                         |
      | discount amount | 50                               |
      | total quota     | 5                                |
      | total kos quota | 5                                |
      | daily quota     | 1                                |
      | max discount    | 500000                           |
      | min transaction | 100000                           |
    And admin master inputs mass voucher code "BBM"
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
      | Active |
    And admin master clicks on add mass voucher button in voucher form
    Then admin can sees callout message is "New mass voucher added!"

  @continue
  Scenario: Update Mass Voucher
    Given admin go to mamikos mamipay admin
    And admin search mass voucher with name and edit index "1":
      | voucher name stag | voucher name prod |
      | BBM               | BBM               |
    And admin master inputs mass voucher code "BBM"
    And admin master clicks on edit mass voucher button in voucher form
    Then admin can sees callout message contains "Voucher BBM updated"
    And admin search mass voucher with name:
      | voucher name stag | voucher name prod |
      | BBM               | BBM               |
    Then admin can sees first index voucher status in mass voucher is "Active"

  @continue
  Scenario: Mass Voucher Status Publish
    Given admin go to mamikos mamipay admin
    And admin search mass voucher with name and edit index "1":
      | voucher name stag | voucher name prod |
      | BBM               | BBM               |
    Then user create new mass voucher with:
      | campaign title | Krezi Ollie                               |
      | campaign T&C   | Terbullie gara gara bakso di mass voucher |
    And admin master upload voucher campaign image
    And admin select important rules :
      | Publish |
    And admin master clicks on edit mass voucher button in voucher form
    Then admin can sees callout message contains "Voucher BBM updated"

  @continue
  Scenario: Mass Voucher Renter Email(CSV)
    Given admin go to mamikos mamipay admin
    And admin search mass voucher with name and edit index "1":
      | voucher name stag | voucher name prod |
      | BBM               | BBM               |
    And admin master upload mass voucher csv file
    And admin master clicks on edit mass voucher button in voucher form
    Then admin can sees callout message contains "Voucher BBM updated"

  Scenario: Mass Voucher Status Inactive
    Given admin go to mamikos mamipay admin
    And admin search mass voucher with name and edit index "1":
      | voucher name stag | voucher name prod |
      | BBM               | BBM               |
    And admin uncheck important rules :
      | Active |
    And admin master clicks on edit mass voucher button in voucher form
    Then admin can sees callout message contains "Voucher BBM updated"
    And admin search mass voucher with name:
      | voucher name stag | voucher name prod |
      | BBM               | BBM               |
    Then admin can sees first index voucher status in mass voucher is "Not Active"
		
