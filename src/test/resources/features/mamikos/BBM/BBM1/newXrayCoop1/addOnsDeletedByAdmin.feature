@COOP-4943 @COOP1
Feature: [Test Execution] AT Web Staging - COOP1


	@TEST_COOP-3436 @TESTSET_COOP-4944 @Automated @web
	Scenario: [Add Ons - Deleted by Admin] Admin Batalkan Contract
		Given admin go to mamikos mamipay admin
		    When admin login to mamipay:
		      | email stag                   | email prod                   | password  |
		      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
		    And admin search contract by tenant phone number:
		      | phone stag    | phone prod    |
		      | 0891111020198 | 0891111020198 |
		    And admin akhiri contract
		    Then admin should success terminate contract
		
	@TEST_COOP-3437 @TESTSET_COOP-4944 @Automated @web
	Scenario: [Add Ons - Deleted by Admin] Cancel Booking if Tenant Have Booking
		Given user go to mamikos homepage
		    When user login as tenant via phone number:
		      | phone stag    | phone prod    | password     |
		      | 0891111020198 | 0891111020198 | mamikosqa123 |
		    And user cancel booking
		
	@TEST_COOP-3438 @TESTSET_COOP-4944 @Automated @web
	Scenario: [Add Ons - Deleted by Admin] Tenant Booking Kost
		Given user go to mamikos homepage
		    When user login as tenant via phone number:
		      | phone stag   | phone prod   | password       |
		      | 0891111020198 | 0891111020198 | mamikosqa123 |
		    And tenant search kost then go to kost details:
		      | kost name stag            | kost name prod            |
		      | Kost Adi Auto Add Ons     | Kost Adi Auto Add Ons     |
		    And tenant booking kost for "today" and input rent duration equals to 2
		    Then tenant should success booking kost
		
	@TEST_COOP-3439 @TESTSET_COOP-4944 @Automated @web
	Scenario: [Add Ons - Deleted by Admin] Owner Accept Booking
		Given user go to mamikos homepage
		    When user login as owner:
		      | phone stag     | phone prod     | password     |
		      | 08900000000021 | 08900000000021 | mamikosqa123 |
		    And owner accept booking from tenant:
		      | tenant stag         | tenant prod         |
		      | Irvi Tenant Add Ons | Irvi Tenant Add Ons |
		    Then owner should redirect back to pengajuan booking page
		
	@TEST_COOP-3440 @TESTSET_COOP-4944 @Automated @web
	Scenario: [Add Ons - Deleted by Admin] Check Add Ons Delete By Admin Master
		Given admin go to mamikos mamipay admin
		    When admin login to mamipay:
		      | email stag                   | email prod                   | password  |
		      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
		    And admin add additional price:
		      | search by              | renter_phone_number      |
		      | search value           | 0891111020198            |
		      | invoice number         | default                  |
		      | additional price type  | Add On                   |
		      | additional price title | adiautomation            |
		      | addtional price value  | 100000                   |
		    Then admin can sees total cost is basic amount + add ons fee + admin fee
		    When admin deletes additional other price with name below :
		      | adiautomation |
		    Then user can not see additional price with name below :
		      | adiautomation |
		
