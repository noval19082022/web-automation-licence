Feature: Login Owner

  @TEST_COOP-5183 @user @saktiloginowner
  Scenario: Login Owner Success
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    |  phone prod    | password     |
      | 081362464341  |  081362464341  | 1d0lt3stb4ru |
