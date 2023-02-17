@DOM4
Feature: Kost detail page

#  @TEST_DOM-1703 @DOM4 @automated @discovery-platform @kost-details @overview-section @web
  Scenario: [Dweb][Kost Detail]Check property overview section
    Given user go to mamikos homepage
    When user search property by name and select the matching result to go to kos details page
      | kost stag                     | kost prod                                           |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user can see overview section on detail page
      | kost stag                     | kost prod                                           |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |

#  @TEST_DOM-1701 @DOM4 @automated @discovery-platform @kost-details @promo-owner @web
#  Scenario: [Dweb][Kost Detail] Check promo owner section login
#    Given user navigates to "mamikos /"
#    And user clicks on Enter button
#    And user login in as Tenant via phone number as "DC Automation"
#    When user reach homepage, and scroll to promotion section
#    And user click promo kos thumbnail and redirect to detail promo kos
#    And I should reached kos detail page
#    Then user see promo owner section
#    And user click button "Lihat Selengkapnya" at promo owner
#    And user see pop up promo owner
#    And user click text "Tanya pemilik kost terlebih dahulu"
#    And user see "Hubungi Kost" pop up
#  @TEST_DOM-1702 @DOM4 @automated @discovery-platform @kost-details @web
#  Scenario: [Dweb][Kost Detail] Check promo owner section non login
#    Given user navigates to "mamikos /"
#    When user reach homepage, and scroll to promotion section
#    And user click promo kos thumbnail and redirect to detail promo kos
#    And I should reached kos detail page
#    Then user see promo owner section
#    And user click button "Lihat Selengkapnya" at promo owner
#    And user see pop up promo owner
#    And user click text "Tanya pemilik kost terlebih dahulu"
#    And user see login pop up
#  @TEST_DOM-1704 @DOM4 @automated @discovery-platform @facility @kost-details @web
#  Scenario: [Dweb][Kost Detail] Check facility room section without login condition
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "PLM A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    And user can see facility room section on detail page
#    And user click see all facility room
#    Then user see login pop up
#  @TEST_DOM-1707 @DOM4 @automated @discovery-platform @facility @kost-details @web
#  Scenario: [Dweb][Kost Detail] Check facility room section with login condition
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user login in as Tenant via phone number as "DC Automation"
#    And user clicks search bar
#    And I search property with name "PLM A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    And user can see facility room section on detail page
#    Then user click see all facility room
#    And user see all facility room section
#  @TEST_DOM-1706 @DOM4 @automated @discovery-platform @facility @kost-details @web
#  Scenario: [Dweb][Kost Detail] Check facility bath section
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "PLM A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then user can see facility bath section on detail page
#  @TEST_DOM-1708 @DOM4 @automated @discovery-platform @facility @kost-details @web
#  Scenario: [Dweb][Kost Detail]Check facility notes section on kost that has 3 rows of facility notes
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "PLM B" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then user can see facility notes on detail kos
#    And user see the more facility notes button is not present
#  @TEST_DOM-1710 @DOM4 @automated @discovery-platform @facility @kost-details @web
#  Scenario: [Dweb][Kost Detail] Check facility notes section on kost that has 4 rows of facility notes
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "PLM A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then user can see facility notes on detail kos
#    And user can see more facility notes button
#    And user click on see more facility notes button
#  @TEST_DOM-1700 @DOM4 @automated @discovery-platform @kost-details @owner-story @web
#  Scenario: [Dweb][Kost Detail]Check owner story section on kost that has 3 rows of owner story
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "PLM B" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then user can see owner story on detail kos
#    And user see the more owner story button is not present
#  @TEST_DOM-1713 @DOM4 @automated @discovery-platform @kost-details @owner-story @web
#  Scenario: [Dweb][Kost Detail]Check owner story section on kost that has 4 rows of owner story
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "PLM A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then user can see owner story on detail kos
#    And user can see more owner story button
#    And user click on see more owner story button
#  @TEST_DOM-1712 @DOM4 @automated @discovery-platform @facility @kost-details @web @flakyDOM
#  Scenario: [Dweb][Kost Detail] Check facility share section without login
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "PLM A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then user can see facility share section on detail page
#    When user click see all facility share
#    Then user see login pop up
#  @TEST_DOM-1698 @DOM4 @automated @discovery-platform @facility @kost-details @web
#  Scenario: [Dweb][Kost Detail] Check facility share section with login
#    Given user navigates to "mamikos /"
#    And user clicks on Enter button
#    And user login in as Tenant via phone number as "DC Automation"
#    When user clicks search bar
#    And I search property with name "PLM A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then user can see facility share section on detail page
#    When user click see all facility share
#    Then user see all facility share section
#  @TEST_DOM-1699 @DOM4 @automated @discovery-platform @facility @kost-details @web
#  Scenario: [Dweb][Kost Detail] Check facility parking section
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "PLM A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    And user can see facility parking section on detail page
#  @TEST_DOM-1705 @DOM4 @automated @discovery-platform @kost-details @kost-rule @web
#  Scenario: [Dweb][Kost Detail] Validate Kos rule element on kos detail
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "DC A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then user can see kos rule list on detail kos
#    And user can see button "Lihat semua peraturan"
#    And user can see kos rule image on detail kos
#  @TEST_DOM-1709 @DOM4 @automated @discovery-platform @kost-details @map @web
#  Scenario: [Dweb][Kost Detail] Check Map section tenant without login
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "DC A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then I should reached map section and see button "Lihat peta" text
#    And user see POI at map section
#    When I click see map button
#    Then user see login pop up
#  @TEST_DOM-1711 @DOM4 @automated @discovery-platform @kost-details @map @web
#  Scenario: [Dweb][Kost Detail] Check Map section when tenant login
#    Given user navigates to "mamikos /"
#    And user clicks on Enter button
#    When user login in as Tenant via phone number as "DC Automation"
#    And user clicks search bar
#    And I search property with name "DC A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then I should reached map section and see button "Tanya alamat lengkap" text
#    And user see POI at map section
#    When user click ask address
#    Then chat room appear with latest message "Kos DC BAR Automation Tipe A beralamat di: "