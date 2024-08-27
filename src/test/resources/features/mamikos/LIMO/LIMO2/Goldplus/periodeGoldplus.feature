@regression @LIMO2 @listing-monetization @periodeGP @DONEMIGRATINGTONEWBOARD
Feature: Check Period Goldplus Page

  @TEST_LIMO-3520
  Scenario: [WEB][Owner][Period GP][Non Weekly]Check List Period at GPLT
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 082233545515 | 0          | 12345678 |
    And owner navigates to owner dashboard
    When owner navigate to list package goldplus 2
    Then user verify list of Periode Berlangganan is appear
      | periodGP        | freeMamiAds            | actualPrice | discPrice   |
      | 1 Bulan         | Gratis MamiAds 100.000 | Rp145.000   | Rp150.000   |
      | 2 Bulan         | Gratis MamiAds 20.000  | Rp278.400   | Rp290.000   |
      | 3 Bulan Favorit | Gratis MamiAds 25.000  | Rp417.600   | Rp435.000   |
      | 4 Bulan Favorit | Gratis MamiAds 40.000  | Rp320.000   | Rp450.000   |
      | 6 Bulan         | Gratis MamiAds 60.000  | Rp817.800   | Rp870.000   |
      | 9 Bulan         | Gratis MamiAds 80.000  | Rp1.000.000 | Rp1.200.000 |
      | 12 Bulan        | Gratis MamiAds 120.000 | Rp1.740.000 | Rp2.000.000 |

  @TEST_LIMO-3521
  Scenario: Setting label favorite change to no
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    Then admin successfully remove additional favorite labels 4 Month
    And admin successfully remove additional favorite labels 3 Month

  @TEST_LIMO-3522
  Scenario: [WEB][Owner][Period GP]Check List Period at GPLT when don't have favorite label
    When user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 082233545515 | 0          | 12345678 |
    When owner navigate to list package goldplus 1
    Then user verify list of Periode Berlangganan is appear
      | periodGP | freeMamiAds            | actualPrice | discPrice |
      | 1 Bulan  | Gratis MamiAds 120.000 | Rp79.000    | Rp89.000  |
      | 3 Bulan  | Gratis MamiAds 177.000 | Rp232.260   | Rp237.000 |
      | 4 Bulan  | Gratis MamiAds 236.000 | Rp224.200   | Rp300.000 |
      | 6 Bulan  | Gratis MamiAds 354.000 | Rp455.040   | Rp474.000 |
      | 12 Bulan | Gratis MamiAds 708.000 | Rp862.680   | Rp948.000 |
    And user should not be able to see the text "Favorit"
    And owner should successfully log out

  @continue @TEST_LIMO-3523
  Scenario: Setting label favorite change to yes
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    And admin successfully additional favorite labels 3 Month

  @TEST_LIMO-3524
  Scenario: [WEB][Owner][Period GP]Check List Period at GPLT when favorite label more than 1
    Then admin successfully additional favorite labels 4 Month
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
      | 3 Bulan Favorit | Gratis MamiAds 177.000 | Rp232.260   | Rp237.000 |
      | 4 Bulan         | Gratis MamiAds 236.000 | Rp224.200   | Rp300.000 |
      | 6 Bulan         | Gratis MamiAds 354.000 | Rp455.040   | Rp474.000 |
      | 12 Bulan        | Gratis MamiAds 708.000 | Rp862.680   | Rp948.000 |
    And owner should successfully log out

  @unfavorite @TEST_LIMO-3525
  Scenario: Remove favorite more than 1
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigates to Admin Goldplus Package
    Then admin successfully remove additional favorite labels 4 Month
    And admin successfully remove additional favorite labels 3 Month