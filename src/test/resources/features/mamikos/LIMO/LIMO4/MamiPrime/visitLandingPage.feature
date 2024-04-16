@regression @LIMO4
Feature: Mamiprime Landing Page

  @TEST_LIMO-5699
  Scenario: Visit landing page
  Given user go to mamikos homepage
  When user login as owner:
    | phone stag | phone prod  | password   |
    | 0890910001 | 0890910001  | qwerty123  |
  And user click on mamiprime widget at owner dashboard
  Then user redirected to mamiprime landing page