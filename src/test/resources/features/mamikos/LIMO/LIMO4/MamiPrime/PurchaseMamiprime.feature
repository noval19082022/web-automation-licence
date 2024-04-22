@regression @LIMO4 @purchaseMamiprime
Feature: Purchase Mamiprime

  @TEST_LIMO-5711
  Scenario Outline: [WEB][Mamikos Prime][Beli Paket] Owner doesn't have property active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password   |
      | <phone number> | <phone number> | qwerty123  |
    And user click on mamiprime widget at owner dashboard
    And owner wants to buy mamiprime from header
    Then user will see pop up doesnt have property on mamiprime
    Examples:
      | phone number  |
      | 082220240418  |
      | 082120240419  |
      | 082020240419  |
      | 082220240419  |