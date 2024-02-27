@DOM1 @essentialTest2
Feature: New Flow Register Owner

  @TEST_COOP-5179 @Automated @DOM @web-covered
   Scenario: [WEB][Register Owner] Navigate To Register Page
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    Then user redirected to "/register-pemilik?source=homepage"

  @TEST_COOP-5178 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] No Input Data
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    Then button daftar will be disable

  @TEST_COOP-5177 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill form with valid data except phone number
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "099999999999", "rheza@mamikos.com", "asdasd123", "asdasd123"
    And user fills out registration form without click register "Eko Menggolo", "0123456789", "eko@mamikos.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone harus diawali dengan 08. |

  @TEST_COOP-5176 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill form with valid data and show password field
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "asdasd123", "asdasd123"
    And user click on show password button
    Then user verify password is equal or more than 8 characters

  @TEST_COOP-5175 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill password input with less than 8 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "as", ""
    Then user verify error messages
      | Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z). |

  @TEST_COOP-5174 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Email Not Surel
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "asdasd123", "asdasd123"
    And user fills out registration form without click register "Rheza Haryo", "0812345670007", "rheza@mamiteam", "asdf12346", "asdasd123"
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rhezamamikos", "asdf1234", "asdasd123"
    Then user verify error messages
      | Gunakan format email seperti: mami@mamikos.com |

  @TEST_COOP-5173 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input wrong email format
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "088888888779", "rheza@mamikos.com", "asdasd123", "asdasd123"
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rhezamamikos", "asdf1234", "asdasd123"
    Then user verify error messages
      | Gunakan format email seperti: mami@mamikos.com |

  @TEST_COOP-5172 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input name less than 3 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "rh", "0821912328", "rheza@mamikos.com", "asdf1234", "asdasd123"
    Then user verify error messages
      | Minimal 3 karakter. |

  @TEST_COOP-5171 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] nput Email Already Used
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@bbb.com", "asdf1234", "asdasd123"
    Then user verify error messages
      | Alamat email ini sudah digunakan untuk verifikasi di akun lain. |

  @TEST_COOP-5170 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] input email Correct
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "jutawan@mamikos.com", "asdf1234", "asdasd123"
    Then user validate email input

  @TEST_COOP-5169 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Check Email Title and Inputted email is deleted
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    Then user see email title is displayed

  @TEST_COOP-5168 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input name more than 25 char
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara Aye Aye", "0812345670001", "jutawan@mamikos.com", "asdasd123", "asdasd123"
    Then user verify name is equal or more than 25 characters

  @TEST_COOP-5167 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number less than 8 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0819129", "rheza@hadehade.com", "asdasd123", "asdasd123"
    Then user verify error messages
      | Nomor handphone kurang dari 8 karakter. |

  @TEST_COOP-5166 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number more than 14 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "081113333444449", "rheza@hadehade.com", "asdasd123", "asdasd123"
    Then user verify error messages
      | Nomor handphone lebih dari 14 karakter. |

  @TEST_COOP-5165 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number already registered owner
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345678999", "rheza@hadehade.com", "asdasd123", "asdasd123"
    Then user verify error messages
      | Nomor handphone ini sudah digunakan untuk verifikasi di akun lain. |

  @TEST_COOP-5164 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number already registered tenant
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0898765432166", "rheza@hadehade.com", "asdasd123", "asdasd123"
    Then user verify error messages
      | Nomor handphone ini sudah digunakan untuk verifikasi di akun lain. |

    @TEST_COOP-4877 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill password input using alfabet only
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "asqwertyqqq", "asqwertyqqq"
    Then user verify error messages
      | Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z). |

  @TEST_COOP-5160 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] password confirmation not match
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "qwerty1233", "asqwertyqqq"
    Then user verify error messages
      | Masukkan password yang sama dengan password baru. |

    @TEST_COOP-5161 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input phone number using special character
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "gizkara", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone hanya dapat diisi dengan angka. |

    @TEST_COOP-5162 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input phone number using alfabet
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "@@@", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone hanya dapat diisi dengan angka. |

   @TEST_COOP-5163 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input name using special character
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "B@g4Z", "at@test.com", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Masukkan karakter alfabet. |

  @TEST_COOP-6717
  Scenario: Register Owner - user register in landing page
    Given user go to mamikos homepage
    When user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    When user clicks on Enter button
    And user clicks on Register button
    Then user redirected to "/register-pemilik?source=list%20kos%20result"

  @TEST_COOP-6718
  Scenario: Register Owner - Owner register from kost detail
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe G | Kos DC BAR Automation Tipe G |
    When user clicks on Enter button
    And user clicks on Register button
    Then user redirected to "/register-pemilik?source=list%20kos%20result"