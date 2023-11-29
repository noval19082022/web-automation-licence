@regression @LIMO1
Feature: MamiAds Dashboard

  @TEST_LIMO-314
  Scenario: empty state if owner each filter while owner didn't have property
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0819999999934 | 0          | qwerty123 |
    When user navigates to mamiads dashboard