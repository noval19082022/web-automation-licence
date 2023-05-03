@DOM1
Feature: Owner - Login

  @TEST_DOM-2241 @Automated @DOM @web-covered
  Scenario: [WEB][Login Owner] Login with valid credentials
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_DOM-2242 @Automated @DOM @web-covered
  Scenario: [WEB][Login Owner] Login with invalid password
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password       |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru99 |
    Then user get error message "Nomor dan password tidak sesuai"

  @TEST_DOM-2243 @Automated @DOM @web-covered
  Scenario: [WEB][Login Owner] Owner Want to cancel login
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user verify login form owner
    And user click back button in login owner
    And user click button close login form
    Then user verify login form close

#  @TEST_DOM-242 @Automated @DOM @web-covered
#  Scenario: New Flow Login Owner - Login From Homepage
#    Given user navigates to "mamikos /room/kost-bantul-kost-campur-eksklusif-kos-danraneymu-mamitest-1?redirection_source=list%20kos%20result"
#    When I should reached kos detail page
#    And user scroll to view maps
#    And user click view maps
#    Then verify popup login displayed
