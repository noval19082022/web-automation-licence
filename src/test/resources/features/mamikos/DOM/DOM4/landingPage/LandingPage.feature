Feature: LandingPage

	@TEST_DOM-4168 @Automated @DOM4 @dikelola-mamikos @dikelola-mamikos-filter @discovery-communication @landing-page
	Scenario: [Dweb][Listing Kos][Filter] Check dikelola mamikos filter
		Given user navigates to mamikos kost kost jogja murah
		    When user activate Dikelola Mamikos filter
		    Then user validate the result kos have Dikelola Mamikos label
	@TEST_DOM-4171 @Automated @DOM4 @dikelola-mamikos @dikelola-mamikos-filter @discovery-communication @landing-page
	Scenario: [Dweb][Listing Kos][Filter] Deactivate dikelola mamikos filter
		Given user navigates to mamikos kost kost jogja murah
		    When user activate Dikelola Mamikos filter
		    And user activate Dikelola Mamikos filter
		    Then user see Dikelola Mamikos filter is deactivate
	@TEST_DOM-4263 @Automated @DOM4 @discovery-platform @landing-page @promo-ngebut-filter
	Scenario: [DWeb][Listing Kos][Filter] Check promo ngebut filter
		Given user navigates to mamikos kost kost jogja murah
		    And user sets Promo Ngebut filter
		    Then user validated the result kos have Promo Ngebut label
