@BBM3 @regression
Feature: Reschedule and Relocation

  Background: Admin go to duration section form via booking now
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   | qwerty123 |
    And admin go to data booking menu
    And admin click booking now button
    And admin select room with kost name "Kost Adi Auto SinggahSini"
    And admin fill the input field on booking form with:
      | search by       | value          |
      | by Phone Number | 0890867321227  |
    And admin click search button on booking now
    And admin click next button on booking now

  @TEST_BBM-1155 @TEST_BBM-1154
  Scenario: Success Reschedule
    When admin fill duration booking form with:
      | booking type          | Reschedule  |
      | old contract id       | 39877       |
      | rent count            | Weekly      |
      | checkin date          | 2030-08-25  |
      | duration of the lease | 1 Minggu    |
    And admin click next button on booking now
    And admin click submit button
    Then admin should see success message "Success! Successfully created booking" on data booking page
    When admin process to reject booking
    And admin reject booking with "Dokumen tidak lengkap" as the reason
    Then admin should see success message "Success! Booking ditolak" on data booking page

  @TEST_BBM-1156
  Scenario: Success Relocation
    When admin fill duration booking form with:
      | booking type          | Relocation  |
      | old contract id       | 39877       |
      | rent count            | Weekly      |
      | checkin date          | 2030-08-25  |
      | duration of the lease | 1 Minggu    |
    And admin click next button on booking now
    And admin click submit button
    Then admin should see success message "Success! Successfully created booking" on data booking page
    When admin process to reject booking
    And admin reject booking with "Dokumen tidak lengkap" as the reason
    Then admin should see success message "Success! Booking ditolak" on data booking page

  @TEST_BBM-1153
  Scenario: Reschedule and Contract ID is invalid
    When admin fill booking type with "Reschedule" and contract id with "0"
    Then admin should see check contract id alert message is "Cannot continue : contract not valid"

  @TEST_BBM-1152
  Scenario: Reschedule and Contract ID is still active
    When admin fill booking type with "Reschedule" and contract id with "37309"
    Then admin should see check contract id alert message is "Cannot continue : contract owned by other user"