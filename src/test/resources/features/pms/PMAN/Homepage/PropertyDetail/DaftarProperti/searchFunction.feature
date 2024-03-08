@regression @pman2 @pms @searchFunction

  Feature: Search Function in Property List Homepage

    @TEST_PMAN-4480 @continue
    Scenario: Admin Search Property by Property Name
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin search property by one name "khusus"
      And property is displayed
      When admin clear keyword in Homepage
      And admin search property by two name "Khusus Automation"
      And property is displayed

    @TEST_PMAN-9570 @continue
    Scenario: Admin Search Property by Property Id
      When admin clear keyword in Homepage
      And admin search property using ID "3143"
      Then property is displayed

    @TEST_PMAN-9571 @continue
    Scenario: Admin Search Property by Prefix Name
      When admin clear keyword in Homepage
      And admin search property by prefix name "Singgahsini"
      Then empty state in Homepage menu is displayed
      And admin search property by prefix name "Apik"
      Then empty state in Homepage menu is displayed

    @TEST_PMAN-9572 @continue
    Scenario: Admin Search Property by Property Full Name (prefix + property)
      When admin search property by property full name "Kost Apik Khusus Automation PMAN Halmahera Utara"
      Then property is displayed

    @TEST_PMAN-9573 @continue
    Scenario: Admin Search Property by Wrong Keyword
      And admin search property by name "Khususu"
      Then empty state in Homepage menu is displayed

    @TEST_PMAN-9574
    Scenario: Admin does not Input the Keyword
      And admin does not input the keyword
      Then all property is displayed