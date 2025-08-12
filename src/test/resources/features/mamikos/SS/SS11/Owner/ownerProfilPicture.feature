#@SS11 this feature move to LIMO
Feature: Owner - Profile Picture

  @TEST_SS-4944 @Automated @DOM @web-covered
  Scenario: [Setelan Akun][Profile Picture] Profile Picture is null
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod   | password  |
      | 0812345670009 | 083132824758 | qwerty123 |
    Then user verify profile picture is null

  @TEST_SS-3050 @Automated @DOM @web-covered
  Scenario: [Setelan Akun][Profile Picture]Login Owner - Profile Picture is show
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082255251018 | 089654131882 | qwerty123 |
    Then user verify profile picture is show
