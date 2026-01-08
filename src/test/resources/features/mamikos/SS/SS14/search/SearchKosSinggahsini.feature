@search @LIMO6
Feature: Display P1 Listing in Kos Suggestion (Search Kos Singgahsini and APIK)

  @Automated @Web @search @TEST_LIMO-4347 @TEST_LIMO-4348 @TEST_LIMO-4349 @TEST_LIMO-4352 @TEST_LIMO-4353
  Scenario Outline: [Dweb][Search] User can search singgahsini with various keyword variations
    Given user go to mamikos homepage
    When user non login
    And user click on search kos
    And user input area "<keyword>"
    Then user see listing "singgahsini" displayed on section recommendation kos

    Examples:
      | keyword           |
      | kost singgah sini |
      | kos singgah sini  |
      | kost singgahsini  |
      | kos singgahsini   |
      | kostsinggahsini   |
      | singgah sini |
      | singgahsini  |
      | Singgahsini rawamangun |
      | Singgah sini rawamangun|
      | wisma singgah sini |
      | wisma singgahsini  |

  @Automated @Web @search @TEST_LIMO-4350 @TEST_LIMO-4351
  Scenario Outline: [Dweb][Search] User can search apik with various keyword variations
    Given user go to mamikos homepage
    When user non login
    And user click on search kos
    And user input area "<keyword>"
    Then user see listing "apik" displayed on section recommendation kos

    Examples:
      | keyword  |
      | kost apik |
      | kos apik  |
      | kostapik  |
      | kost Apik |
      | kos Apik  |
      | kostApik  |
      | Apik      |
      | apik      |


