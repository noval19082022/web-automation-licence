Feature: Tenant Apply Invalid Kost Voucher

  @voucher
  Scenario: Admin Activate Voucher AUTOKOSTINV
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher and "not apply" it to kost:
      | voucher name stag | voucher name prod | kost name stag            | kost name prod            |
      | AUTOKOSTINV       | AUTOKOSTINV       | Kost Adi Auto SinggahSini | Kost Adi Auto SinggahSini |
    Then admin can see message voucher is updated
