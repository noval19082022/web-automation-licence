@pms @disbursement @regression @pman2

  Feature: Disbursement List

    @TEST_PMAN-4474
    Scenario: Search functionality
      #search empty keyword
      Given admin go to pms singgahsini
      And admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to Disbursement menu
      When admin search disbursement ""
      Then show all disbursement list
      #search prefix name
      When admin search disbursement "Kost Singgahsini"
      Then show all disbursement list
      When admin search disbursement "Kost Apik"
      Then show all disbursement list
      #search property name keyword
      When admin search disbursement "Khusus Automation"
      Then show only disbursment for "Kost Apik Khusus Automation PMAN Halmahera Utara"
      #search full property name
      When admin search disbursement "Kost Apik Khusus Automation PMAN Halmahera Utara"
      Then show only disbursment for "Kost Apik Khusus Automation PMAN Halmahera Utara"
      #search wrong keyword
      When admin search disbursement "lorem ipsum"
      Then show empty list disbursmement