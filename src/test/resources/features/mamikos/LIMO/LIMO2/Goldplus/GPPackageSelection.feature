@regression @goldPlus @goldplusRegister @LIMO2 @listing-monetization @DONEMIGRATINGTONEWBOARD
Feature: Revamp GP Package Options

  @TEST_LIMO-8950 @Automated @LIMO2
  Scenario: [Revamp GP] Package Display for Medium - High Segment User
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                     | email prod | password  |
      | uncle.limo2@admin-mamiteam.com |            | qwerty123 |
    And admin accsess menu whitelist feature
    When admin search whitelist owner by user_id "99453319"
    And admin click edit button for owner
    And admin select feature with "gp_special_pricing_low_1"
    And admin save whitelist changes
    Then admin can see message "Success!"
    And admin logout from bangkrupux
    And admin close unused browser tab
    When user go to mamikos homepage
    And user login as owner:
      | phone stag | phone prod | password  |
      | 0891202303 | 0891202303 | qwerty123 |
    And owner navigates to owner dashboard
    And user click daftar GP button
    And user select package GP 1
    Then long-term packages displayed first sorted from longest to shortest period
    And basic packages GP 1 month displayed after long-term packages
    Then GP packages are displayed with following data:
      | duration     | price              | discount | original_price| favorit | free_mamiads |
      | 12 Bulan     | Rp862.680          | 9        | Rp948.000     | false   | 708000       |
      | 6 Bulan      | Rp455.040          | 4        | Rp474.000     | false   | 354000       |
      | 4 Bulan      | Rp224.200          | 25       | Rp300.000     | false   | 236000       |
      | 3 Bulan      | Rp70.000           | 1        | Rp71.000      | false   | 0            |
      | 2 Bulan      | Rp50.000           | 0        |               | false   | 0            |
      | Paket Dasar  | Rp99.000 per bulan | 18       | Rp120.000     | true    | 0            |

  @TEST_LIMO-8950 @Automated @LIMO2
  Scenario:  [Revamp GP] Package Display for Low Segment User
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                     | email prod | password  |
      | uncle.limo2@admin-mamiteam.com |            | qwerty123 |
    And admin accsess menu whitelist feature
    When admin search whitelist owner by user_id "99453223"
    And admin click edit button for owner
    And admin select feature with "gp_special_pricing_low_1"
    And admin save whitelist changes
    Then admin can see message "Success!"
    And admin logout from bangkrupux
    And admin close unused browser tab
    When user go to mamikos homepage
    And user login as owner:
      | phone stag | phone prod | password  |
      | 0891202302 | 0891202303 | qwerty123 |
    And owner navigates to owner dashboard
    And user click daftar GP button
    And user select package GP 1
    And Basic packages GP 1 month displayed before long-term packages
    Then Long-term packages displayed second sorted from longest to shortest period
    Then GP packages are displayed with following data:
      | duration     | price              | discount | original_price| favorit | free_mamiads |
      | Paket Dasar  | Rp99.000 per bulan | 18       | Rp120.000     | true    | 0            |
      | 12 Bulan     | Rp862.680          | 9        | Rp948.000     | false   | 708000       |
      | 6 Bulan      | Rp455.040          | 4        | Rp474.000     | false   | 354000       |
      | 4 Bulan      | Rp224.200          | 25       | Rp300.000     | false   | 236000       |
      | 3 Bulan      | Rp70.000           | 1        | Rp71.000      | false   | 0            |
      | 2 Bulan      | Rp50.000           | 0        |               | false   | 0            |

  @TEST_LIMO-8957 @Automated @LIMO2
  Scenario:  [Revamp GP] User segment is not defined
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202202 | 0891202303 | qwerty123 |
    And owner navigates to owner dashboard
    And user click daftar GP button
    And user select package GP 1
    Then GP packages are displayed with following data:
      | duration     | price              | discount | original_price| favorit | free_mamiads |
      | Paket Dasar  | Rp79.000 per bulan | 12       | Rp90.000      | true    | 120000       |
      | 12 Bulan     | Rp862.680          | 9        | Rp948.000     | false   | 708000       |
      | 6 Bulan      | Rp455.040          | 4        | Rp474.000     | false   | 354000       |
      | 4 Bulan      | Rp224.200          | 25       | Rp300.000     | false   | 236000       |
      | 3 Bulan      | Rp232.260          | 2        | Rp237.000     | false   | 177000       |
