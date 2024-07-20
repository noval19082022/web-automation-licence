@pman2 @pms @homepagePMS

Feature: Homepage menu

  @TEST_SS-868 @continue
  Scenario: Check empty state in Homepage menu
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin search property by name "Lalala"
    Then empty state in Homepage menu is displayed

  @TEST_SS-765 @continue
  Scenario: Reset / Clear Keyword in Search Bar
    #clear keyword using property ID
    When admin search property using ID "3143"
    And admin clear keyword in Homepage
    Then search bar is empty
    #clear keyword using property name
    When admin search property by name "khusus automation"
    And admin clear keyword in Homepage
    Then search bar is empty

  @TEST_SS-854 @continue
  Scenario: View Detail Property Page
    When admin go to detail property "3143"
    Then admin redirect to detail property page

  @TEST_SS-851 @continue
  Scenario: View Room Allotment Page
    When admin go to Homepage
    And admin search property using ID "3143"
    And admin go to Ketersediaan Kamar in Homepage action button
    Then admin redirect to room allotment page

  @TEST_SS-842 @continue
  Scenario: Apply Some Filters
    When admin go to Homepage
    And admin Filter data in Homepage
    Then the system is displaying total active filter number is "11"
    And property is displayed

  @TEST_SS-864 @continue
  Scenario: Reset filter
    When admin reset filter in Homepage
    Then the system is displaying total active filter number is "1"

  @TEST_SS-862 @continue
  Scenario: Reset filter using the reset button inside filter modal
    When admin Filter data in Homepage
    Then the system is displaying total active filter number is "11"
    And admin reset filter in Homepage filter modal
    Then the system is displaying total active filter number is "1"

  @TEST_SS-869 @continue
  Scenario: Search using property ID
    #Search property using valid property ID
    When admin reset filter in Homepage
    And admin search property using ID "3143"
    Then property is displayed
    #Search property using invalid property ID
    When admin clear keyword in Homepage
    And admin search property using ID "0101"
    Then empty state in Homepage menu is displayed

  @TEST_SS-767
  Scenario: Search using property name
    #Search property with full name
    When admin search property by name "Kost Apik Khusus Automation PMAN Halmahera Utara"
    Then property is displayed
    #Search property with third word in title
    When admin clear keyword in Homepage
    And admin search property by name "khusus"
    Then property is displayed
    #Search property with fourth word in title
    When admin clear keyword in Homepage
    And admin search property by name "Automation"
    Then empty state in Homepage menu is displayed