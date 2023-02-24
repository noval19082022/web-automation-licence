@localhost
Feature: Kost detail page 2

  @TEST_DOM-1875 @Automated @DOM4 @Web @discovery-platform @kost-details @report-section
  Scenario: [Dweb][Kost Detail]Check report kos section tenant without login
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe B | Kos DC BAR Automation Tipe B |
    Then user can see kos report section
    #report action
    When user want to report this kos
    Then user will see login pop up

  @TEST_DOM-1882 @Automated @DOM4 @Web @discovery-platform @kost-details @report-section
  Scenario: [Dweb][Kost Detail]Check report kos section tenant login and already have send report kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user can see kos report section
    #report action
    When user want to report this kos
    And user send text "try to report this kos for testing" in form kos report
    Then user will see display pop up confirmation already have send report kos

  @TEST_DOM-1884 @Automated @DOM4 @Web @discovery-platform @kost-details @owner-lower-section
  Scenario: [Dweb][Kost Detail] Check Owner lower section
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    And user can see owner information section
    Then user want to see more detail owner information section

  @TEST_DOM-1883 @Automated @DOM4 @Web @discovery-platform @gallery @kost-details @owner-lower-section
  Scenario: [Dweb][Kost Detail] Check Detail Gallery Photo
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user want to display detail gallery

  @TEST_DOM-1885 @Automated @DOM4 @Web @discovery-platform @kost-details @recommendation
  Scenario: [Dweb][Kost Detail] Check Recommendation Kos
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user want to see the other kost on recommendation section
    #explore kost recomendation
    When user see description recomendation kos "Kamu mungkin menyukainya"
    And user want to explore kost recomendation section
    Then user see listing kos recommendation arround kos with detail "Kos di sekitar" and filter by mix gender

#  @TEST_DOM-1876 @Automated @DOM4 @Web @discovery-platform @kost-details @property-price
#  Scenario: [Dweb][Kost Detail] Check right panel, duration and price
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "DC A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then user sees total price property
#    When user sees form booking date
#    Then user validates description "Bisa di hari H setelah pengajuan sewa."
#    And user validates description "2 bulan setelah pengajuan sewa."
#    And user sees date
#    And user sees alert message "Pastikan tanggal yang kamu masukkan benar"
#    When user sees form booking duration
#    And user select date "tomorrow" and rent type "Per bulan"
##		Then user validates the title is suitable with duration that chosen
#    Then user sees booking button
##	Low Prio Testcase and often failure
##	@TEST_DOM-1874 @Automated @DOM4 @Web @breadcrumbs @discovery-platform @kost-details
##	Scenario: [Dweb][Kost Detail] Check level of breadcrumbs and redirection
##		Given user navigates to "mamikos /"
##		When user clicks search bar
##		And user search for keyword "Medan"
##		And user click one of the listing
##		Then user sees breadcrumbs level is correct "Home" > "Medan" > "Kost Property"
##		And user click town level breadcrumb, it will navigates to landing search page
##		And user click home level breadcrumbs, it will navigates to Homepage
#  @TEST_DOM-1877 @Automated @DOM4 @Web @apik-badgekos @discovery-platform @kost-details
#  Scenario: [Dweb][Kost Detail] Check APIK Badge Kos
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And user search for Kost with name "chatKostName11" and selects matching result
#    And I should reached kos detail page
#    Then user can see apik badge kos
#
#  @TEST_DOM-1880 @Automated @DOM4 @Web @discovery-platform @kost-details @singgahsini-badgekos
#  Scenario: [Dweb][Kost Detail] Check Singgahsini Badge Kos
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And user search for Kost with name "chatKostName12" and selects matching result
#    And I should reached kos detail page
#    Then user can see singgahsini badge kos
#
#  @TEST_DOM-1879 @Automated @DOM4 @Web @discovery-platform @kost-details @owner-badges
#  Scenario:  [Dweb][Kost Detail] Check Owner badges section
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "DC A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    Then I should reached owner badges section
#    And I see owner statement
#    And I see Owner name, last online status,  Owner Profile picture, Number of success booking transaction
#
#  @TEST_DOM-1881 @Automated @DOM4 @Web @discovery-platform @kost-benefit @kost-details
#  Scenario: [Dweb][Kost Detail] Check Kost Benefit section
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "DC A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    And user should reached benefit section
#    Then user see benefit title, benefit description
#
#  @TEST_DOM-3811 @Automated @DOM4 @Web @discovery-platform @review-kost
#  Scenario: [Dweb][Kost Detail] Check Tenant Review section
#    Given user navigates to "mamikos /"
#    And user clicks on Enter button
#    When user login in as Tenant via phone number as "DC Automation"
#    And user clicks search bar
#    And I search property with name "DC A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    And I should reached owner lower section
#    Then user see review kos detail page section
#    And user validate the elements of review section
#
#  @TEST_DOM-3812 @Automated @DOM4 @Web @discovery-platform @review-kost
#  Scenario: [Dweb][Kost Detail] Click see all Tenant Review
#    Given user navigates to "mamikos /"
#    And user clicks on Enter button
#    When user login in as Tenant via phone number as "DC Automation"
#    And user clicks search bar
#    And I search property with name "DC A" and select matching result to go to kos details page
#    And I should reached kos detail page
#    And I should reached owner lower section
#    And user see review kos detail page section
#    And user click on see all review
#    Then user validate the elements of review modal
#    And user close review modal