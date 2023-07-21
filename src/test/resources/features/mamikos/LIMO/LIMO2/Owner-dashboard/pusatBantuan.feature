@regression @LIMO2 @pusatbantuanOwner
Feature: [Owner][Pusat Bantuan Owner] Owner accsess page pusat bantuan

  @TEST_LIMO-1737 @Automated @Web @listing-monetization
  Scenario: [Owner][Pusat Bantuan Owner] Owner accsess page pusat bantuan
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag | phone prod | password |
      | 083176408311 | 0          | mamikosignite |
    And user clicks on the close button
    When owner click "Pusat Bantuan"
    Then user should redirect to link "https://help.mamikos.com/pemilik"