@regression @LIMO2 @listing-monetization @periodeGP
Feature: Check Period Goldplus Page

  @TEST_LIMO-2326 @TEST_LIMO-3918
  Scenario: [WEB][Owner][Period GP][Non Weekly]Check List Period at GPLT
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag   | phone prod | password |
      | 082233545515 | 0          | 12345678 |
    And owner navigates to owner dashboard
    When owner navigate to list package goldplus 2
    Then user verify list of Periode Berlangganan is appear
      | periodGP        | freeMamiAds            | actualPrice | discPrice   |
      | 1 Bulan         | Gratis MamiAds 100.000 | Rp129.000   | Rp150.000   |
      | 2 Bulan         | Gratis MamiAds 20.000  | Rp249.000   | Rp300.000   |
      | 3 Bulan         | Gratis MamiAds 50.000  | Rp168.150   | Rp177.000   |
      | 4 Bulan Favorit | Gratis MamiAds 40.000  | Rp320.000   | Rp450.000   |
      | 6 Bulan         | Gratis MamiAds 60.000  | Rp870.000   | Rp900.000   |
      | 9 Bulan         | Gratis MamiAds 80.000  | Rp100.000   | Rp120.000   |
      | 12 Bulan        | Gratis MamiAds 120.000 | Rp1.583.400 | Rp1.740.000 |

  Scenario: Setting label favorite change to no
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    Then admin successfully remove additional favorite labels 4 Month
    And admin successfully remove additional favorite labels 3 Month

  @TEST_LIMO-3147
  Scenario: [WEB][Owner][Period GP]Check List Period at GPLT when don't have favorite label
    When user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 082233545515 | 0          | 12345678 |
    When owner navigate to list package goldplus 1
    Then user verify list of Periode Berlangganan is appear
      | periodGP | freeMamiAds            | actualPrice | discPrice |
      | 1 Bulan  | Gratis MamiAds 120.000 | Rp79.000    | Rp89.000  |
      | 3 Bulan  | Gratis MamiAds 177.000 | Rp168.150   | Rp300.000 |
      | 4 Bulan  | Gratis MamiAds 236.000 | Rp224.200   | Rp300.000 |
      | 6 Bulan  | Gratis MamiAds 354.000 | Rp318.600   | Rp354.000 |
      | 12 Bulan | Gratis MamiAds 708.000 | Rp862.680   | Rp948.000 |
    And user should not be able to see the text "Favorit"
    And owner should successfully log out

  @continue
    #scenario change label favorite
  Scenario: Setting label favorite change to yes
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    Then admin successfully sets favorite label to active

  @TEST_LIMO-3146
  Scenario: [WEB][Owner][Period GP]Check List Period at GPLT when favorite label more than 1
    #Scenario: Setting label favorite more than 1
    Then admin successfully adds additional favorite labels
    And mamikos bangkrupux admin should be successfully logged out

    #Scenario: check list periode
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 082233545515 | 0          | 12345678 |
    When owner navigate to list package goldplus 1
    Then user verify list of Periode Berlangganan is appear
      | periodGP        | freeMamiAds            | actualPrice | discPrice |
      | 1 Bulan         | Gratis MamiAds 120.000 | Rp79.000    | Rp89.000  |
      | 3 Bulan Favorit | Gratis MamiAds 177.000 | Rp168.150   | Rp300.000 |
      | 4 Bulan Favorit | Gratis MamiAds 236.000 | Rp224.200   | Rp300.000 |
      | 6 Bulan         | Gratis MamiAds 354.000 | Rp318.600   | Rp354.000 |
      | 12 Bulan        | Gratis MamiAds 708.000 | Rp862.680   | Rp948.000 |
    And owner should successfully log out

    #scenario change label favorite
  @unfavorite
  Scenario: Remove favorite more than 1
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    Then admin successfully remove additional favorite labels 4 Month
    And admin successfully remove additional favorite labels 3 Month