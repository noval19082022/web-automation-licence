@regression @LIMO2 @listing-monetization @periodeGP
Feature: Check Period Goldplus Page

  @TEST_LIMO-3520
  Scenario: [WEB][Owner][Period GP][Non Weekly]Check List Period at GPLT
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod | password |
      | 0812345678123 | 0          | qwerty123 |
    And owner navigates to owner dashboard
    When owner navigate to list package goldplus 2
    Then user verify list of Periode Berlangganan is appear
      """
      - img "back"
      - paragraph: Pilih Periode Goldplus 2
      - paragraph: Paket Dasar
      - paragraph: Rp145.000 per bulan
      - paragraph: Diskon 3%
      - paragraph: Rp150.000
      - separator
      - paragraph: + Gratis MamiAds 100.000
      - text: Favorit
      - paragraph: Paket Jangka Panjang
      - paragraph: Bisa chat dengan penyewa kapanpun
      - paragraph: Rp1.740.000
      - paragraph: Diskon 13%
      - paragraph: Rp2.000.000
      - paragraph: 12 Bulan
      - paragraph: Rp145.000 per bulan
      - separator
      - paragraph: + Gratis MamiAds 120.000
      - paragraph: Rp1.000.000
      - paragraph: Diskon 17%
      - paragraph: Rp1.200.000
      - paragraph: 9 Bulan
      - paragraph: Rp111.111 per bulan
      - paragraph: Rp817.800
      - paragraph: Diskon 6%
      - paragraph: Rp870.000
      - paragraph: 6 Bulan
      - paragraph: Rp136.300 per bulan
      - separator
      - paragraph: + Gratis MamiAds 60.000
      - paragraph: Rp320.000
      - paragraph: Diskon 29%
      - paragraph: Rp450.000
      - paragraph: 4 Bulan
      - paragraph: Rp80.000 per bulan
      - separator
      - paragraph: + Gratis MamiAds 40.000
      - text: Favorit
      - paragraph: Rp417.600
      - paragraph: Diskon 4%
      - paragraph: Rp435.000
      - paragraph: 3 Bulan
      - paragraph: Rp139.200 per bulan
      - separator
      - paragraph: + Gratis MamiAds 25.000
      - text: Favorit
      - paragraph: Rp278.400
      - paragraph: Diskon 4%
      - paragraph: Rp290.000
      - paragraph: 2 Bulan
      - paragraph: Rp139.200 per bulan
      - separator
      - paragraph: + Gratis MamiAds 20.000
      - button "Pilih Periode"
      """

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
      | phone stag     | phone prod | password |
      | 0812345678123 | 0          | qwerty123 |
    When owner navigate to list package goldplus 1
    Then user verify list of Periode Berlangganan is appear
      """
      - img "back"
      - paragraph: Pilih Periode Goldplus 1
      - paragraph: Paket Dasar
      - paragraph: Rp79.000 per bulan
      - paragraph: Diskon 12%
      - paragraph: Rp90.000
      - separator
      - paragraph: + Gratis MamiAds 120.000
      - text: Favorit
      - paragraph: Paket Jangka Panjang
      - paragraph: Bisa chat dengan penyewa kapanpun
      - paragraph: Rp862.680
      - paragraph: Diskon 9%
      - paragraph: Rp948.000
      - paragraph: 12 Bulan
      - paragraph: Rp71.890 per bulan
      - separator
      - paragraph: + Gratis MamiAds 708.000
      - paragraph: Rp455.040
      - paragraph: Diskon 4%
      - paragraph: Rp474.000
      - paragraph: 6 Bulan
      - paragraph: Rp75.840 per bulan
      - separator
      - paragraph: + Gratis MamiAds 354.000
      - paragraph: Rp224.200
      - paragraph: Diskon 25%
      - paragraph: Rp300.000
      - paragraph: 4 Bulan
      - paragraph: Rp56.050 per bulan
      - separator
      - paragraph: + Gratis MamiAds 236.000
      - paragraph: Rp232.260
      - paragraph: Diskon 2%
      - paragraph: Rp237.000
      - paragraph: 3 Bulan
      - paragraph: Rp77.420 per bulan
      - separator
      - paragraph: + Gratis MamiAds 177.000
      - button "Pilih Periode"
      """
    And owner should not see "Favorit" on Paket Jangka Panjang
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
      | phone stag     | phone prod | password |
      | 0812345678123 | 0          | qwerty123 |
    When owner navigate to list package goldplus 1
    Then user verify list of Periode Berlangganan is appear
      """
      - img "back"
      - paragraph: Pilih Periode Goldplus 1
      - paragraph: Paket Dasar
      - paragraph: Rp79.000 per bulan
      - paragraph: Diskon 12%
      - paragraph: Rp90.000
      - separator
      - paragraph: + Gratis MamiAds 120.000
      - text: Favorit
      - paragraph: Paket Jangka Panjang
      - paragraph: Bisa chat dengan penyewa kapanpun
      - paragraph: Rp862.680
      - paragraph: Diskon 9%
      - paragraph: Rp948.000
      - paragraph: 12 Bulan
      - paragraph: Rp71.890 per bulan
      - separator
      - paragraph: + Gratis MamiAds 708.000
      - paragraph: Rp455.040
      - paragraph: Diskon 4%
      - paragraph: Rp474.000
      - paragraph: 6 Bulan
      - paragraph: Rp75.840 per bulan
      - separator
      - paragraph: + Gratis MamiAds 354.000
      - paragraph: Rp224.200
      - paragraph: Diskon 25%
      - paragraph: Rp300.000
      - paragraph: 4 Bulan
      - paragraph: Rp56.050 per bulan
      - separator
      - paragraph: + Gratis MamiAds 236.000
      - paragraph: Rp232.260
      - paragraph: Diskon 2%
      - paragraph: Rp237.000
      - paragraph: 3 Bulan
      - paragraph: Rp77.420 per bulan
      - separator
      - paragraph: + Gratis MamiAds 177.000
      - text: Favorit
      - button "Pilih Periode"
      """
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