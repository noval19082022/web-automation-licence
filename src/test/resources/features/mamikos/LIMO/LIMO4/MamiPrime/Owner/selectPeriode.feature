@regression @LIMO4 @mamiprime
Feature: Detail Pemesanan

  @TEST_LIMO-5686
  Scenario: [Web][Mamiprime][Pendaftaran Mamiprime] Check condition when owner not GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083355251030 | 083355251030 | qwerty123 |
    And owner navigate to pendaftaran mamiprime page
    Then owner will see additional information related to GP
