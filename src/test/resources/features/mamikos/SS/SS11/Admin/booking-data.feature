@SS11 @booking-data
Feature: Booking Remark on Data Booking

  @continue
  Scenario: Admin login and navigate to booking data
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu

  @TEST_SS-10546 @continue
  Scenario: [Web][Data Booking][Remarks]Filter shows only bookings with empty remarks (remarks : "-")
    When admin click show filter button
    And admin click on note category dropdown
    And admin select note category "-"
    And admin click search filter button
    Then admin should see remarks "Remarks : -" in the results

  @TEST_SS-10550 @continue
  Scenario: [Web][Data Booking][Remarks]Filter shows only bookings with non-empty remarks (Akan survey)
    When admin click show filter button
    And admin select "-" from textbox dropdown and choose "Akan Survey"
    And admin click search filter button
    Then admin should see remarks "Remarks : Akan Survey" in the results

  @TEST_SS-10551 @continue
  Scenario: [Web][Data Booking][Remarks]Admin can see different note categories in booking data
    When admin click show filter button
    And admin click on note category dropdown
    And admin select note category "-"
    And admin click search filter button
    Then remarks text "Remarks : -" should be displayed
    When admin click show filter button
    And admin click on note category dropdown
    And admin select note category "Akan Survey"
    And admin click search filter button
    Then remarks text "Remarks : Akan Survey" should be displayed