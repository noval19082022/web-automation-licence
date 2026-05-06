@license
Feature: License - Admin Login Dashboard

#  @TEST_LICENSE_LOGIN
#  Scenario: [WEB][License] Admin login and access dashboard menu
#    Given the user access URL is "http://localhost:9090/license/signin"
#    When the user logs in as admin:
#      | Username     | Password |
#      | licenseadmin | !nV0Lvi@ |
#    And the user clicks on login button
#    And the user clicks on the Dashboard menu
#    Then the user successfully logs into the dashboard menu

#  @TEST_LICENSE_DELETE_ORGANIZATION_ADD_ROW
#  Scenario: [WEB][License] Admin delete organization
#    Given the user access URL is "http://localhost:9090/license/signin"
#    When the user logs in as admin:
#      | Username     | Password |
#      | licenseadmin | !nV0Lvi@ |
#    And the user clicks on login button
#    And the user clicks on the customer menu
#    And the user select menu organisation
#    And the user clicks on more button
#    And the user select "Delete" button
#    And the user clicks on "Delete" button on pop up confirmation

  @TEST_LICENSE_ORGANIZATION_ADD_ROW
  Scenario: [WEB][License] Admin navigate to organization and add row
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the customer menu
    And the user select menu organisation
    And the user clicks on add row menu
    And the user fill data:
    |Code              |Name                |Organization Level  |Parent Organization  |Business Name  |Country   |Phone Number  |Email          |Postal Code  |NPWP            |Address                      |Tax Invoice Name  |
    |AC-{{timestamp}}  |PT.Super Smart TBK  |Organisasi          |                     |Makanan        |Indonesia |021-5512345   |john@gmail.com |15400        |000-111-222.999 |Jl. cendrawasi jakarta pusat |John              |
    And the user click on save button

#  @TEST_LICENSE_ORGANIZATION_LEVELS_ADD_ROW
#  Scenario: [WEB][License] Admin navigate to organization levels and edit row
#    Given the user access URL is "http://localhost:9090/license/signin"
#    When the user logs in as admin:
#      | Username     | Password |
#      | licenseadmin | !nV0Lvi@ |
#    And the user clicks on login button
#    And the user clicks on the customer menu
#    And the user select menu organisation levels
#    And the user clicks on edit row menu
#    And the user fill data:
#      |Name                  |Level  |Description |
#      |Organization Testing  |10     |Manager     |
#    And the user click on save button

#  @TEST_LICENSE_DELETE_SUBSCRIBER_USERS
#  Scenario: [WEB][License] Admin delete subscriber users
#    Given the user access URL is "http://localhost:9090/license/signin"
#    When the user logs in as admin:
#      | Username     | Password |
#      | licenseadmin | !nV0Lvi@ |
#    And the user clicks on login button
#    And the user clicks on the customer menu
#    And the user select menu subscriber users
#    And the user clicks on view button
#    And the user select "Delete" button
#    And the user clicks on "Delete" button on pop up confirmation

  @TEST_LICENSE_SUBSCRIBER_USER_ADD_ROW
  Scenario: [WEB][License] Admin navigate to subscriber users and add row
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the customer menu
    And the user select menu subscriber users
    And the user clicks on add row menu
    And the user fill data:
      |Username               |Email                   |Phone Number  |Full Name      |
      |Zenix-{{timestamp}}    |{{timestamp}}@gmail.com |0812000111    |Zenix Adrayana |
    And the user click on save button

  @TEST_LICENSE_SUBSCRIBER_USER_ORG_ADD_ROW
  Scenario: [WEB][License] Admin navigate to subscriber users Org and add row
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the customer menu
    And the user select menu subscriber users org
    And the user clicks on add member
    And the user fill data:
      |Member   |Organization       |Role     |Joined At       |
      |Zenix    |PT.Super Smart TBK |Admin    |2026-04-24 23:30|
    And the user click on save button

  @TEST_LICENSE_MARKETING_USER_ADD_ROW
  Scenario: [WEB][License] Admin navigate to marketing and add row
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the customer menu
    And the user select menu marketing
    And the user clicks on add row menu
    And the user fill data:
      |Code                |Name   |Email                  |Phone     |Status    |Notes         |
      |Zenix-{{timestamp}} |Zenix  |{{timestamp}}@gmail.com|021123450 |Active    |Marketing 002 |
    And the user click on save button

  @TEST_LICENSE_MAPPINGACCOUNT_USER_ADD_ROW
  Scenario: [WEB][License] Admin navigate to marketing and add row
    Given the user access URL is "http://localhost:9090/license/signin"
    When the user logs in as admin:
      | Username     | Password |
      | licenseadmin | !nV0Lvi@ |
    And the user clicks on login button
    And the user clicks on the customer menu
    And the user select menu Mapping Akun
    And the user clicks on add row menu
    And the user fill data:
      |Marketing |Root Organization Level 1  |Effective From  |Effective To  |Status    |Notes         |
      |Zenix-002 |PT.Super Smart TBK         |2026-04-24      |2027-04-24    |Active    |Marketing 002 |
    And the user click on save button