@mtresearch @admin @login
Feature: Admin Login Research

  Scenario: Admin login with automationpman03@mamikos.com
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |

  Scenario: Admin login with pman@mamiteam.com
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag        | email prod        | password         |
      | pman@mamiteam.com | pman@mamiteam.com | pmanM4m1t34m!!   |

  Scenario: Admin login with Automation.pw1@mamikos.com
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |

  Scenario: Admin login with automationpman01@mamikos.com
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |

  Scenario: Admin login with automationpman02@mamikos.com
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
