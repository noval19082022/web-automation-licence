@LIMO1 @license @login @viu
Feature: License - Admin Login Dashboard

#  @TEST_LICENSE_LOGIN
#  Scenario: [WEB][License] Admin login and access dashboard menu
#    Given the user access URL is "http://localhost:8086/license/signin"
#    When the user logs in as admin:
#      | Username     | Password |
#      | licenseadmin | !nV0Lvi@ |
#    And the user clicks on login button
#    And the user clicks on the Dashboard menu
#    Then the user successfully logs into the dashboard menu

  @TEST_LICENSE_ORGANIZATION_ADD_ROW
  Scenario: [WEB][License] Admin navigate to organization and add row
    Given the user access URL is "http://localhost:8086/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the customer menu
    And the user select menu organisation
    And the user clicks on more button
    And the user select "Delete" button
    And the user clicks on "Delete" button on pop up confirmation

  @TEST_LICENSE_ORGANIZATION_ADD_ROW
  Scenario: [WEB][License] Admin navigate to organization and add row
    Given the user access URL is "http://localhost:8086/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the customer menu
    And the user select menu organisation
    And the user clicks on add row menu
    And the user fill data:
    |Code   |Name  |Organization Level  |Parent Organization  |Business Name      |Country   |Phone Number  |Email          |Postal Code  |NPWP            |Address                      |Tax Invoice Name  |
    |AC-01  |John  |Organisasi          |                     |PT.Super Smart TBK |Indonesia |021-5512345   |john@gmail.com |15400        |000-111-222.999 |Jl. cendrawasi jakarta pusat |John              |
    And the user click on save button