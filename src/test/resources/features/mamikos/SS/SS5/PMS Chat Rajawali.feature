@SS3
Feature: Chat Rajawali On PMS Tenant Tracker

 @TEST_SS-8866 @continue
 Scenario: [Web][PMS Tenant Tracker][Chat Rajawali]Admin check Chat rajawali on Tenant Tracker
   Given admin go to pms singgahsini
   When admin login pms :
     | email             | password        |
     | pman@mamiteam.com | pmanM4m1t34m!!  |
   And admin go to tenant communication menu
   And user choose "Nama Penyewa" and input "Tenant Belum Update" in the search field on main page
   And user click search button on main page filter
   Then admin can see rajawali chat

   @TEST_SS-8868
     Scenario: [Web][PMS Tenant Tracker][Chat Rajawali]Admin open Chat rajawali but not login bangker
     When admin go to tenant communication menu
     And user choose "Nama Penyewa" and input "Tenant Belum Update" in the search field on main page
     And user click search button on main page filter
     And admin click on rajawali chat
     And user close unused browser tab
     Then admin go to mamikos bangkrupux admin

   @TEST_SS-8871
   Scenario: [Web][PMS Tenant Tracker][Chat Rajawali]Admin open rajawali when different Owner
     Given admin go to pms singgahsini
     When admin login pms :
       | email             | password        |
       | pman@mamiteam.com | pmanM4m1t34m!!  |
     And admin go to tenant communication menu
     And user choose "Nama Penyewa" and input "Tenant Belum Update" in the search field on main page
     And user click search button on main page filter
     And admin click on rajawali chat
     And user close unused browser tab
     Then admin go to mamikos bangkrupux admin
     When admin login to bangkrupux:
       | email stag                   | email prod                   | password  |
       | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
     And admin go to pms singgahsini
     And admin go to tenant communication menu
     And admin click on rajawali chat
     Then admin can see rajawali chat


