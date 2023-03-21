@fixing
Feature: Landing Page

  @DOM4 @landing-page @dikelola-mamikos-filter
  Scenario: [Dweb][Listing Kos][Filter] Check filter dikelola mamikos
    Given user navigates to mamikos kost kost jogja murah
    When user click on Dikelola Mamikos filter
    Then user validate the result kos have Dikelola Mamikos label

  @DOM4 @landing-page @dikelola-mamikos-filter @ribet
  Scenario: [Dweb][Listing Kos][Filter] Deactivate dikelola mamikos filter
    Given user navigates to mamikos kost kost jogja murah
    When user click on Dikelola Mamikos filter
    And user click on Dikelola Mamikos filter
    Then user see Dikelola Mamikos filter is deactivate