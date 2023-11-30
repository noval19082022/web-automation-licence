@DOM1 @essentialTest
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
    And user click back button in login page
    And user click button close login form
    Then user verify login form close

  @TEST_DOM-242 @Automated @DOM @web-covered
  Scenario: New Flow Login Owner - Login From Homepage
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user want to reached map section and see lihat peta button
    #user want to see map more detail
    When user want to see more detail kost location
    Then user will see login pop up

  @TEST_COOP-4875 @Automated @DOM @web-covered
  Scenario: [WEB][Login Owner] using Wrong phone number alfabet
    Given user go to mamikos homepage
    When user login as owner with wrong phone number:
      | phone stag   | phone prod   | password       |
      | qwerty       | qwerty123    | 1d0lt3stb4ru99 |
      Then user verify login error messages "Format Nomor Handphone salah."

  Scenario: New Flow Login Owner - Login From Homepage
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user want to reached map section and see lihat peta button
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"