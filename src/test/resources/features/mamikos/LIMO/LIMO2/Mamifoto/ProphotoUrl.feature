@LIMO2 @Mamifoto
Feature: Check when accsess prophoto Landing Page

  @TEST_LIMO-3163 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: User Non Login access MamiFoto Landing Page from Url
    Given user go to mamikos homepage
    When owner navigates to old prophoto page
    Then owner should redirect to login page "/login-pemilik?redirection_source=prophoto"

  @TEST_LIMO-3889 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: Owner access MamiFoto Landing Page from Url
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 082233545506 | 0          | qwerty123 |
    When owner navigates to old prophoto page
    Then owner can see mamifoto page

  @TEST_LIMO-3890 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: Tenant access MamiFoto Landing Page from Url
    Given user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag   | phone prod | password  |
      | 081223344550 | 0          | qwerty123 |
    When owner navigates to old prophoto page
    Then user go to mamikos homepage