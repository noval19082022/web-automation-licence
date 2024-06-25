@regression @LIMO4 @mamiprime
Feature: Detail Pemesanan

  @TEST_LIMO-5686 @continue
  Scenario: [Web][Mamiprime][Pendaftaran Mamiprime] Check condition when owner not GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083355251030 | 083355251030 | qwerty123 |
    And owner navigate to pendaftaran mamiprime page
    Then owner will see additional information related to GP

  @TEST_LIMO-5682 @continue
  Scenario: [Web][Mamiprime][Pendaftaran Mamiprime] Doesn't select any periode
    Then Validate Lanjut Bayar button on periode mamiprime is disable

  @TEST_LIMO-5682 @continue
  Scenario: [Web][Mamiprime][Pendaftaran Mamiprime] Selected property and selected periode
    When owner only choose period "7 Hari" with price "Rp356.250"
    Then Validate Lanjut Bayar button on periode mamiprime is enable

  @TEST_LIMO-5682 @continue
  Scenario: [Web][Mamiprime][Pendaftaran Mamiprime] Select periode 14 Days
    When owner only choose period "14 Hari" with price "Rp712.500"
    Then Validate Lanjut Bayar button on periode mamiprime is enable

  @TEST_LIMO-5682 @continue
  Scenario: [Web][Mamiprime][Pendaftaran Mamiprime] Select periode 30 Days
    When owner only choose period "30 Hari" with price "Rp1.275.000"
    Then Validate Lanjut Bayar button on periode mamiprime is enable

  @TEST_LIMO-5682
  Scenario: [Web][Mamiprime][Pendaftaran Mamiprime] Select periode 60 Days
    When owner only choose period "60 Hari" with price "Rp3.000.000"
    Then Validate Lanjut Bayar button on periode mamiprime is enable