@DOM1
Feature: New Flow Register Owner

  @TEST_DOM-2244 @Automated @DOM @web-covered
   Scenario: [WEB][Register Owner] Navigate To Register Page
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    Then user redirected to "/register-pemilik?source=homepage"

  @TEST_DOM-2245 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] No Input Data
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    Then button daftar will be disable

  @TEST_DOM-2247 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill form with valid data except phone number
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "099999999999", "rheza@mamikos.com", "asdasd123"
    And user fills out registration form without click register "Eko Menggolo", "0123456789", "eko@mamikos.com", "qwerty123"
    Then user verify error messages
      | Nomor handphone harus diawali dengan 08. |

  @gagal @TEST_DOM-2249 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill form with valid data and show password field
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "asdasd123"
    And user click on show password button
    Then user verify password is equal or more than 8 characters

  @TEST_DOM-2256 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill password input with less than 8 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "as"
    Then user verify error messages
      | Password kurang dari 8 karakter |

  @TEST_DOM-2257 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Email Not Surel
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "asdasd123"
    And user fills out registration form without click register "Rheza Haryo", "0812345670007", "rheza@mamiteam", "asdf12346"
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rhezamamikos", "asdf1234"
    Then user verify error messages
      | Gunakan format email seperti: mami@mamikos.com |

  @TEST_DOM-2258 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input wrong email format
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "088888888779", "rheza@mamikos.com", "asdasd123"
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rhezamamikos", "asdf1234"
    Then user verify error messages
      | Gunakan format email seperti: mami@mamikos.com |

  @TEST_DOM-2260 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input name less than 3 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "rh", "0821912328", "rheza@mamikos.com", "asdf1234"
    Then user verify error messages
      | Minimal 3 karakter. |

  @TEST_DOM-2262 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] nput Email Already Used
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@bbb.com", "asdf1234"
    Then user verify error messages
      | Alamat email ini sudah digunakan untuk verifikasi di akun lain. |

  @bagas @gagal @TEST_DOM-2263 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] input email Correct
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "jutawan@mamikos.com", "asdf1234"
    Then user validate email input"jutawan@mamikos.com"

  @TEST_DOM-2264 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Check Email Title and Inputted email is deleted
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    Then user see email title is displayed

  @TEST_DOM-2265 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input name more than 25 char
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara Aye Aye", "0812345670001", "jutawan@mamikos.com", "asdasd123"
    Then user verify name is equal or more than 25 characters

  @TEST_DOM-2266 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number less than 8 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0819129", "rheza@hadehade.com", "asdasd123"
    Then user verify error messages
      | Nomor handphone kurang dari 8 karakter. |

  @TEST_DOM-2267 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number more than 14 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "081113333444449", "rheza@hadehade.com", "asdasd123"
    Then user verify error messages
      | Nomor handphone lebih dari 14 karakter. |

  @TEST_DOM-2268 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number already registered owner
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345678999", "rheza@hadehade.com", "asdasd123"
    Then user verify error messages
      | Nomor handphone ini sudah digunakan untuk verifikasi di akun lain. |

  @TEST_DOM-2269 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number already registered tenant
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0898765432166", "rheza@hadehade.com", "asdasd123"
    Then user verify error messages
      | Nomor handphone ini sudah digunakan untuk verifikasi di akun lain. |


