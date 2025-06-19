@ss @mamipay @terminationOption @checkoutReason @pman

  Feature: Checkout Reason

    @TEST_SS-8094 @continue
    Scenario: Admin can add owner reason without adding subreason
      Given admin go to mamikos mamipay admin
      And admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
      And admin open menu Termination Option
      #Add reason for owner
      When admin add new reason "Automation Reason Owner" show on "Owner"
      Then admin can see toast message "Termination option berhasil ditambahkan!"
      And admin can see reason "Automation Reason Owner" in "Owner" table
      And admin can't see + button in "Automation Reason Owner" row

    @TEST_SS-8626 @continue
    Scenario: Admin can delete owner reason
      When admin delete reason "Automation Reason Owner"
      Then admin can see toast message "Termination option berhasil dihapus!"
      And admin can't see reason "Automation Reason Owner" in "Owner" table

    @TEST_SS-8625 @continue
    Scenario: Admin can add tenant reason without adding subreason
      #Add reason for tenant
      When admin add new reason "Automation Reason Tenant" show on "Tenant"
      Then admin can see toast message "Termination option berhasil ditambahkan!"
      And admin can see reason "Automation Reason Tenant" in "Tenant" table
      And admin can see + button in "Automation Reason Tenant" row

    @TEST_SS-8627 @continue
    Scenario: Admin can delete tenant reason
      When admin delete reason "Automation Reason Tenant"
      Then admin can see toast message "Termination option berhasil dihapus!"
      And admin can't see reason "Automation Reason Tenant" in "Tenant" table

    @TEST_SS-8095 @continue
    Scenario: Admin can add subreason
      When admin add new reason "Automation Reason Tenant" show on "Tenant"
      Then admin can see toast message "Termination option berhasil ditambahkan!"
      And admin can see reason "Automation Reason Tenant" in "Tenant" table
      #add subreason for tenant
      When admin add new subreason "Subreason 1" to "Automation Reason Tenant"
      Then admin can see toast message "Termination option berhasil ditambahkan!"
      And admin can see subreason "Subreason 1" in "Tenant" table
      When admin add new subreason "Subreason 2" to "Automation Reason Tenant"
      Then admin can see toast message "Termination option berhasil ditambahkan!"
      And admin can see subreason "Subreason 2" in "Tenant" table

    @TEST_SS-8096 @continue
    Scenario: Admin can edit Subreason
      When admin edit subreason "Subreason 1" to "Subreason 1-Edit"
      Then admin can see toast message "Termination option berhasil di ubah!"
      And admin can see subreason "Subreason 1-Edit" in "Tenant" table

    @TEST_SS-8097 @continue
    Scenario: Admin can move subreason order
      When admin move "up" subreason "Subreason 2"
      Then subreason order should be
        | Subreason 2      |
        | Subreason 1-Edit |
      When admin move "down" subreason "Subreason 2"
      Then subreason order should be
        | Subreason 1-Edit |
        | Subreason 2      |

    @TEST_SS-8098
    Scenario: Admin can delete Subreason
      When admin delete subreason "Subreason 1-Edit"
      Then admin can see toast message "Termination option berhasil dihapus!"
      And admin can't see subreason "Subreason 1-Edit" in "Tenant" table
      And subreason order should be
        | Subreason 2 |
      #normalization data
      When admin delete reason "Automation Reason Tenant"
      Then admin can see toast message "Termination option berhasil dihapus!"
      And admin can't see reason "Automation Reason Tenant" in "Tenant" table