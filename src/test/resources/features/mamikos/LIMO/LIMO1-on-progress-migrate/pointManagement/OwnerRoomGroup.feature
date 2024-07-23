@regression @ownerRoomGroup @LIMO1 @LIMO1-staging @DONEMIGRATINGTONEWBOARD
Feature: Manage Owner Room Group

  @TEST_LIMO-3301 @continue
  Scenario: [Point Management][Owner Room Group] Add New Owner Room Group
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user clicks on Point Management-Owner Room Group menu
    And user clicks on Add Owner Room Group button
    And user create owner room group "1001" until "1050"
    And user click save create owner group button
    Then user verify allert success "Success!" and "Owner Room Group successfully added."
    And user verify new room group added displayed

  @TEST_LIMO-3302 @continue
  Scenario: [Point Management][Manage Point Owner Room Group] Verify New Owner Room Group Updated on Manage Point Setting Page
    When user clicks on Point Management-Owner Setting menu
    Then user verify new room group added displayed

  @TEST_LIMO-3303 @continue
  Scenario: [Point Management][Manage Point Owner Room Group]Add new Room Group with empty field
    When user clicks on Point Management-Owner Room Group menu
    And user clicks on Add Owner Room Group button
    And user click save create owner group button
    Then user see validation
      | The floor field is required. |
      | The ceil field is required.  |

  @TEST_LIMO-3304 @continue
  Scenario: [Point Management][Manage Point Owner Room Group]Add new Room Group with floor field higher than cell field
    When user create owner room group "10000" until "1050"
    And user click save create owner group button
    Then user see validation
      | Floor must be lower or equal than ceil. |

  @TEST_LIMO-3305 @continue
  Scenario: [Point Management][Manage Point Owner Room Group]Edit Room Group
    When user clicks on Point Management-Owner Room Group menu
    And user click edit on room group
    And user create owner room group "1002" until "1051"
    And user click save create owner group button
    Then user verify allert success "Success!" and "Owner Room Group successfully updated."
    And user verify new room group added displayed

  @TEST_LIMO-3306 @continue
  Scenario: [Point Management][Manage Point Owner Room Group] Verify New Owner Room Group added on Manage Point Setting Page
    When user clicks on Point Management-Owner Setting menu
    Then user verify new room group added displayed

  @TEST_LIMO-3307 @continue
  Scenario: [Point Management][Manage Point Owner Room Group] Delete Owner Room Group
    When user clicks on Point Management-Owner Room Group menu
    And user click delete on room group
    Then user verify allert success "Success!" and "Owner Room Group successfully deleted."
    And user verify new room group added not displayed

  @TEST_LIMO-3308 @continue
  Scenario: [Point Management][Manage Point Owner Room Group] Verify New Owner Room Group Updated on Manage Point Setting Page
    When user clicks on Point Management-Owner Setting menu
    Then user verify new room group added not displayed

  @TEST_LIMO-3309 @ownerRoomGroupPagination @continue
  Scenario: [Point Management][Owner Room Group]Owner Room Group Pagination
    When user clicks on Point Management-Owner Room Group menu
    Then user verify the pagination of Owner Room Group

  @TEST_LIMO-3310 @managePointOwnerRoomDisplay
  Scenario: [Point Management][Owner Room Group]Manage Point Owner Room Group display
    When user clicks on Point Management-Owner Room Group menu
    Then user verify Manage Point Owner Room Group page items
      | Add Owner Room Group |
      | ID                   |
      | Group                |
      | Actions              |