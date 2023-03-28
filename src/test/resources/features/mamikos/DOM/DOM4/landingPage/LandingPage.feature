Feature: Landing Page

  @DOM4 @landing-page @dikelola-mamikos-filter
  Scenario: [Dweb][Listing Kos][Filter] Check dikelola mamikos filter
    Given user navigates to mamikos kost kost jogja murah
    When user activate Dikelola Mamikos filter
    Then user validate the result kos have Dikelola Mamikos label

  @DOM4 @landing-page @dikelola-mamikos-filter
  Scenario: [Dweb][Listing Kos][Filter] Deactivate dikelola mamikos filter
    Given user navigates to mamikos kost kost jogja murah
    When user activate Dikelola Mamikos filter
    And user activate Dikelola Mamikos filter
    Then user see Dikelola Mamikos filter is deactivate

  @DOM4 @landing-page @promo-ngebut-filter
  Scenario: [Dweb][Listing Kos][Filter] Check promo ngebut filter
    Given user navigates to mamikos kost kost jogja murah
    And user sets Promo Ngebut filter
    Then user validated the result kos have Promo Ngebut label