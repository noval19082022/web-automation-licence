@DOM10 @essentialTest2
Feature: Owner - Login

  @TEST_COOP-5276 @Automated @DOM @web-covered @TEST_COOP-5183
  Scenario: [WEB][Login Owner] Login with valid credentials
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_COOP-5277 @Automated @DOM @web-covered
  Scenario: [WEB][Login Owner] Login with invalid password
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password       |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru99 |
    Then user get error message "Nomor dan password tidak sesuai"

  @TEST_COOP-5278 @Automated @DOM @web-covered
  Scenario: [WEB][Login Owner] Owner Want to cancel login
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user verify login form owner
    And user click back button in login page
    And user click button close login form
    Then user verify login form close

  @TEST_COOP-5279 @Automated @DOM @web-covered
  Scenario: New Flow Login Owner - Login From Homepage
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe G | Kos DC BAR Automation Tipe G |
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

  @TEST_COOP-5280
  Scenario: New Flow Login Owner - Login From detail kos
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe G | Kos DC BAR Automation Tipe G |
    Then user want to reached map section and see lihat peta button
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_COOP-6663
  Scenario: Owner Login - using Wrong phone number
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod  | password  |
      | 1111111111 | 11111111111 | qwerty123 |
    Then user verify login error messages "Format Nomor Handphone salah."

  @TEST_COOP-6664
  Scenario: Login owner - From SBMPTN Page
    Given user navigate to SBMPTN page
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_COOP-6665
  Scenario: Owner Login - owner login in landing page
    Given user go to mamikos homepage
    When user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    And user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_COOP-7095
  Scenario: Login Owner - From Popular Area Page
    Given user navigate to popular area page
    When user login as owner in popular area page:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_COOP-7096
  Scenario: Login Owner - From Near Campus Page
    Given user navigate to near campus page
    When user login as owner in popular area page:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"