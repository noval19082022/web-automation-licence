Feature: Invalid Voucher After Applied, Invalid Profession

  Scenario: Activate voucher AUTOPROFESSION
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher with name and set profession:
      | voucher name stag | voucher name prod | profession |
      | AUTOPROFESSION      | AUTOPROFESSION      | Mahasiswa |
    Then admin can see message voucher is updated
    When scenario is "continue"