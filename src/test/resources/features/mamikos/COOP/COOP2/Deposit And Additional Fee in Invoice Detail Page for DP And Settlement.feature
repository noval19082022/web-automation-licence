@COOP2
Feature: Deposit And Additional Fee in Invoice Detail Page for DP And Settlement


  @SS-5019
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for DP And Settlement] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag   | phone prod    |
      | 087708777618 | 0890867321212 |

  @SS-5020
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for DP And Settlement] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password  |
      | 087708777618 | 0890867321212 | qwerty123 |
    And user cancel booking

  @SS-5027
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for DP And Settlement] Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod    | password  |
      | 087708777618 | 0890867321212 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                                                    | kost name prod            |
      | Test Regression Kost Bagas Automation Add Tobelo Halmahera Utara  | Kost Adi Auto SinggahSini |
    And tenant booking kost
    Then tenant should success booking kost

  @SS-5028
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for DP And Settlement] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08716267788    | 08716267788    | qwerty123 |
    And owner accept booking from tenant:
      | tenant stag      | tenant prod          |
      | Nunu And Willump | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @SS-5029
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for DP And Settlement] Deposit And Additional Fee in Invoice Detail Page for DP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin clicks on invoice details second index:
      | search by    | renter_phone_number |
      | search value | 0890867321212       |
    Then admin can sees total cost is basic amount + admin fee

  @SS-5030
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for DP And Settlement] Check Deposit And Additional Fee in Invoice Detail Page for Settlement
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin clicks on invoice details first index:
      | search by    | renter_phone_number |
      | search value | 087708777618        |
    Then admin can sees total cost is basic amount + deposit fee + additional fee + admin fee