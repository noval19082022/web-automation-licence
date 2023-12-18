@regression @LIMO1 @LIMO1-staging
Feature: Beli Saldo

  Background: Login Page Mamikos
    Given user go to mamikos homepage

  @TEST_LIMO-274 @belisaldo @continue
  Scenario: Redirection Beli Saldo
    Given user login as owner:
      | phone stag   | phone prod | password |
      | 083176408449 | 0          | qwerty123 |
    When user navigates to mamiads dashboard
    And user click Beli Saldo on mamiads dashboard
    Then user redirected to pembelian saldo mamiads page

  @TEST_LIMO-4086
  Scenario: Favorite Saldo
    When user navigates to mamiads pembelian saldo
    Then favorit saldo is "Rp1.350.000"
