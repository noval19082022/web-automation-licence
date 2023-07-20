@newowner-dashboard @regression @LIMO2 @listing-monetization @ownerDashboardGP
Feature: Owner Dashboard GP


  @TEST_LIMO-1628 @GP @GP2 @automated @listing-monetization @web
  Scenario: [Owner Dashboard][Widget GP] Check when owner already active Goldplus
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08713399866 | 0          | qwerty123 |
    Then validate that owner have "GoldPlus 2"

  @TEST_LIMO-1662 @GP @automated @listing-monetization @web @web-covered
  Scenario: [Owner][GP Widget]Check GP Widget "Sedang Diproses"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 086465400654 | 0          | qwerty123 |
    Then validate that owner have "Sedang Diproses"
