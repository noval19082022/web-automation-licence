@regression @pman @roomList @pman-prod

  Feature: Room List Feature

    @TEST_PMAN-3273
    Scenario: Checks Room List Display
      Given admin go to mamikos bangkrupux admin
      When admin login to bangkrupux:
        | email stag                    | email prod                    | password        |
        | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
      And admin access menu "Kost List" sub menu of management level
      And admin search kost by name for check Room List
      And admin clicks on Room List
      Then data in Room List is displayed
        | Room Name Stag  | Floor Stag  | Occupied Stag   | Level Stag  | Room Name Prod  | Floor Prod  | Occupied Prod | Level Prod  |
        | A2              | 1           | No              | Unassigned  | C4              | 1           | Yes           | Unassigned  |
        | A3              | 1           | No              | Unassigned  | C1              | 1           | Yes           | Regular     |
        | A1              | 1           | No              | Unassigned  | C2              | 1           | Yes           | Regular     |
        | -               | -           | -               | -           | C3              | 1           | Yes           | Regular     |