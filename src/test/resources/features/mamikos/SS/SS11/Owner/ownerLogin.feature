@SS11 @essentialTest2
Feature: Owner - Login

  @TEST_SS-2756 @Automated @DOM @web-covered @TEST_COOP-5183
  Scenario: [WEB][Login Owner] Login with valid credentials
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_SS-2757 @Automated @DOM @web-covered
  Scenario: [WEB][Login Owner] Login with invalid password
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password       |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru99 |
    Then user get error message "Nomor dan password tidak sesuai"

  @TEST_SS-2758 @Automated @DOM @web-covered
  Scenario: [WEB][Login Owner] Owner Want to cancel login
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user verify login form owner
    And user click back button in login page
    And user click button close login form
    Then user verify login form close

  @TEST_SS-2760 @Automated @DOM @web-covered
  Scenario: [Web][New Flow][Login Owner] Login From detail kos
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user want to reached map section and see lihat peta button
    #user want to see map more detail
    When user want to see more detail kost location
    Then user will see login pop up

  @TEST_SS-2754 @Automated @DOM @web-covered
  Scenario: [WEB][Login Owner] using Wrong phone number alfabet
    Given user go to mamikos homepage
    When user login as owner with wrong phone number:
      | phone stag | phone prod | password       |
      | qwerty     | qwerty123  | 1d0lt3stb4ru99 |
    Then user verify login error messages "Format Nomor Handphone salah."

  @TEST_SS-2760
  Scenario: [Web][New Flow][Login Owner] Login From detail kos
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user want to reached map section and see lihat peta button
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_SS-2761
  Scenario: [WEB][Login Owner] Using Wrong phone number
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod  | password  |
      | 1111111111 | 11111111111 | qwerty123 |
    Then user verify login error messages "Format Nomor Handphone salah."

  @TEST_SS-2762
  Scenario: [WEB][Login Owner] - From SBMPTN Page
    Given user navigate to SBMPTN page
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_SS-2763
  Scenario: [WEB][Login Owner] owner login in landing page
    Given user go to mamikos homepage
    When user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    And user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_SS-4290
  Scenario: [WEB][Login Owner] From Popular Area Page
    Given user navigate to popular area page
    When user login as owner in popular area page:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"

  @TEST_SS-4291
  Scenario: [WEB][Login Owner] - From Near Campus Page
    Given user navigate to near campus page
    When user login as owner in popular area page:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    Then user redirected to "owner"