@pman @pms @owner-expenditure

  Feature: Table Transaction Owner Expenditure List
    Background: Open Other Transaction Menu
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to other transation menu

    @TEST_PMAN-5990
    Scenario: Click Expand to See the Table Detail
      When admin expand first owner expenditure list
      Then first owner expenditure detail should be visible
      #Open Lampiran
      When admin click lihat lampiran first owner expenditure list
      And admin set active page to 1
      Then lampiran opened in new tab