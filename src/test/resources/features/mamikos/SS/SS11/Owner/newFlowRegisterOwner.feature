@SS9 @essentialTest2
Feature: New Flow Register Owner

  @TEST_SS-2804 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Navigate To Register Page
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    Then user redirected to "/register-pemilik?source=homepage"

  @TEST_SS-2803 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] No Input Data
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    Then button daftar will be disable

  @TEST_SS-2802 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill form with valid data except phone number
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "099999999999", "rheza@mamikos.com", "asdasd123", "asdasd123"
    And user fills out registration form without click register "Eko Menggolo", "0123456789", "eko@mamikos.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone harus diawali dengan 08. |

  @TEST_SS-2801 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill form with valid data and show password field
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "asdasd123", "asdasd123"
    And user click on show password button
    Then user verify password is equal or more than 8 characters

  @TEST_SS-2800 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill password input with less than 8 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "as", ""
    Then user verify error messages
      | Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z). |

  @TEST_SS-2799 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Email Not Surel
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "asdasd123", "asdasd123"
    And user fills out registration form without click register "Rheza Haryo", "0812345670007", "rheza@mamiteam", "asdf12346", "asdasd123"
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rhezamamikos", "asdf1234", "asdasd123"
    Then user verify error messages
      | Gunakan format email seperti: mami@mamikos.com |

  @TEST_SS-2798 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input wrong email format
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "088888888779", "rheza@mamikos.com", "asdasd123", "asdasd123"
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rhezamamikos", "asdf1234", "asdasd123"
    Then user verify error messages
      | Gunakan format email seperti: mami@mamikos.com |

  @TEST_SS-2797 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input name less than 3 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "rh", "0821912328", "rheza@mamikos.com", "asdf1234", "asdasd123"
    Then user verify error messages
      | Minimal 3 karakter. |

  @TEST_SS-2796 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Email Already Used
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@bbb.com", "asdf1234", "asdasd123"
    Then user verify error messages
      | Alamat email ini sudah digunakan untuk verifikasi di akun lain. |

  @TEST_SS-2795 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] input email Correct
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "jutawan@mamikos.com", "asdf1234", "asdasd123"
    Then user validate email input

  @TEST_SS-2794 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Check Email Title and Inputted email is deleted
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    Then user see email title is displayed

  @TEST_SS-2793 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input name more than 25 char
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara Aye Aye", "0812345670001", "jutawan@mamikos.com", "asdasd123", "asdasd123"
    Then user verify name is equal or more than 25 characters

  @TEST_SS-2792 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number less than 8 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0819129", "rheza@hadehade.com", "asdasd123", "asdasd123"
    Then user verify error messages
      | Nomor handphone kurang dari 8 karakter. |

  @TEST_SS-2791 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number more than 14 characters
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "081113333444449", "rheza@hadehade.com", "asdasd123", "asdasd123"
    Then user verify error messages
      | Nomor handphone lebih dari 14 karakter. |

  @TEST_SS-2790 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number already registered owner
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345678999", "rheza@hadehade.com", "asdasd123", "asdasd123"
    Then user verify error messages
      | Nomor handphone ini sudah digunakan untuk verifikasi di akun lain. |

  @TEST_SS-2789 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input Phone number already registered tenant
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0898765432166", "rheza@hadehade.com", "asdasd123", "asdasd123"
    Then user verify error messages
      | Nomor handphone ini sudah digunakan untuk verifikasi di akun lain. |

  @TEST_SS-2784 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Fill password input using alfabet only
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "asqwertyqqq", "asqwertyqqq"
    Then user verify error messages
      | Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z). |

  @TEST_SS-2785 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] password confirmation not match
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "0812345670001", "rheza@mamikos.com", "qwerty1233", "asqwertyqqq"
    Then user verify error messages
      | Masukkan password yang sama dengan password baru. |

  @TEST_SS-2786 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input phone number using special character
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "gizkara", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone hanya dapat diisi dengan angka. |

  @TEST_SS-2787 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input phone number using alfabet
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "@@@", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone hanya dapat diisi dengan angka. |

  @TEST_SS-2788 @Automated @DOM @web-covered
  Scenario: [WEB][Register Owner] Input name using special character
    Given user go to mamikos homepage
    When user clicks on Enter button
    And user clicks on Register button
    And user fills out registration form without click register "B@g4Z", "at@test.com", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Masukkan karakter alfabet. |

  @TEST_SS-2805
  Scenario: Register Owner - user register in landing page
    Given user go to mamikos homepage
    When user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    When user clicks on Enter button
    And user clicks on Register button
    Then user redirected to "/register-pemilik?source=list%20kos%20result"

  @TEST_SS-2806
  Scenario: Register Owner - Owner register from kost detail
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    When user clicks on Enter button
    And user clicks on Register button
    Then user redirected to "register-pemilik?source=property%20detail%20page"

  @TEST_SS-2807
  Scenario: Register owner - From SBMPTN Page
    Given user navigate to SBMPTN page
    When user clicks on Enter button
    And user clicks on Register button
    Then user redirected to "register-pemilik?source="

  @TEST_SS-2673
  Scenario: Register owner - From Popular Area Page
    Given user navigate to popular area page
    When user click on enter button owner in popular area page
    And user clicks on Register button
    Then user redirected to "register-pemilik?source="

  @TTEST_SS-2674
  Scenario: Register owner - From Near Campus Page
    Given user navigate to near campus page
    When user click on enter button owner in popular area page
    And user clicks on Register button
    Then user redirected to "register-pemilik?source="
