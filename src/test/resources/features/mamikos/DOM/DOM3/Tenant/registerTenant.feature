@DOM3 @essentialTest
Feature: New Flow Register Tenant

  @navigateToRegisterPageTenant @TEST_COOP-5612 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - Navigate To Register Page
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    Then user redirected to "/register-pencari?source=homepage"

  @noInputDataTenant @TEST_COOP-5613 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - No Input Data
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register " ", " ", " ", " ", " "
    Then user verify error messages
      | Masukkan nama lengkap.    |
      | Masukkan nomor handphone. |
      | Masukkan alamat email.    |
    Then user verify password error messages
      | Masukkan password.        |
    Then user verify confirm password error messages
      | Masukkan password.        |

  @blankNameTenant @TEST_COOP-5614 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - Blank name
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register " ", "08210391239921", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Masukkan nama lengkap. |

  @wrongNameTenant @TEST_COOP-5615 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario Outline: Register Tenant - Input name with symbol/number & Input name less than 3 char
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "<Name>", "08210391239921", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | <Error Message> |
      | <Error Message> |
    Examples:
      | Name       | Error Message              |
      | !@#$%3212  | Masukkan karakter alfabet. |
      | rh         | Minimal 3 karakter.        |

  @noInputPhone @TEST_COOP-5616 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - No input phone number
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", " ", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Masukkan nomor handphone. |

  @phoneNumberNotUsing08AsPrefix @DOM3 @TEST_COOP-5617
  Scenario: Register Tenant - Input phone number not using 08 as prefix
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "666", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone harus diawali dengan 08. |

  @nameMoreThan20Characters @TEST_COOP-5618 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - Name more than 20 characters
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara Aye Aye", "08210391239921", "at@test.com", "qwerty123", "qwerty123"
    Then user verify name is equal or more than 20 characters

  @phoneLessThan8Char @TEST_COOP-5619 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - Phone less than 8 characters
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara Aye Aye", "0821", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone kurang dari 8 karakter. |

  @phoneMoreThan14Char @TEST_COOP-5620 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - Phone more than 14 characters
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara Aye Aye", "081239182938123", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone lebih dari 14 karakter. |

  @noInputPassword @TEST_COOP-5621 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - No input password
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "at@test.com", " ", " "
    Then user verify password error messages
      | Masukkan password.        |

  @passwordLessThan8Char @TEST_COOP-5622 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - Input password less than 8 characters
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "at@test.com", "asd", "asd"
    Then user verify error messages
      | Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z). |

  @passwordMoreThan8 @TEST_COOP-5623 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario Outline: Register Tenant - Input password more than 8 characters & Input password not using numeric and symbols
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "at@test.com", "<Password>", " "
    Then user verify password more than 8 characters
    Examples:
      | Password    |
      | qwerty1233  |
      | 12345!@#$%  |

  @showPasswordInputTenant @TEST_COOP-5624 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - Check eye icon
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "at@test.com", "qwerty123", "confirmPassword"
    And user click on show password button
    Then user verify password is equal or more than 8 characters

  @noInputEmail @TEST_COOP-5626 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: Register Tenant - No input email
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", " ", "qwerty123", "confirmPassword"
    Then user verify error messages
      | Masukkan alamat email. |

  @wrongFormatEmail @TEST_COOP-5631 @TESTSET_PF-1393 @Automated @DOM3 @web-covered
  Scenario Outline: Register Tenant - Input email with wrong format
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "<Email>", "qwerty123", "confirmPassword"
    Then user verify error messages
      | <Error Message> |
      | <Error Message> |
    Examples:
      | Email             | Error Message |
      | asdasd.com        | Gunakan format email seperti: mami@mamikos.com |
      | draft@xyz.com.net | Mohon masukkan email yang valid                |

  @inputRegisteredEmail @TEST_COOP-5632 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario Outline: Register Tenant - Input registered email (Owner & Tenant)
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "<Email>", "qwerty123", "confirmPassword"
    Then user verify error messages
      | Alamat email ini sudah digunakan untuk verifikasi di akun lain. |
    Examples:
      | Email             |
      | rheza@mamikos.com |
      | rheza@rrr.com     |

  @inputNumberRegistered @TEST_COOP-5633 @Automated @DOM3 @web-covered
  Scenario: [Web Tenant][Register]input tenant number registered
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza", "08119787884", "at@test.com", "qwerty123", "confirmPassword"
    Then user verify error messages
      | Nomor handphone ini sudah digunakan untuk verifikasi di akun lain.|

  @TEST_COOP-4876 @Automated @DOM3 @web-covered
  Scenario: [Web Tenant][Register]Register Tenant - Input password using alfabet only
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "at@test.com", "asdqwertyqqq", "confirmPassword"
    Then user verify error messages
      | Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z). |

  @TEST_COOP-5634
  Scenario: Register Tenant - password confirmation not match
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Gizkara", "08210391239921", "at@test.com", "qwerty123", "confirmPassword"
    Then user verify error messages
      | Masukkan password yang sama dengan password baru. |

  @TEST_COOP-5635
  Scenario: [Web Tenant][Register]Register Tenant - Input phone number using special character
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "@@@@@", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone hanya dapat diisi dengan angka. |

  @TEST_COOP-5636
  Scenario: [Web Tenant][Register]Register Tenant - Input phone number using alfabet
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "Rheza Haryo Hanggara", "gizkara", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Nomor handphone hanya dapat diisi dengan angka. |

  @TEST_COOP-5637
  Scenario: [Web Tenant][Register]Register Tenant - Input tenant name more than 50 character
    Given user go to mamikos homepage
    When user clicks on Enter button Tenant
    And user clicks on Register button
    And user fills out registration form without click register "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "08210391239921", "at@test.com", "qwerty123", "qwerty123"
    Then user verify error messages
      | Maksimal 50 karakter. |

  @TEST_COOP-6667
  Scenario: Register Tenant - user register in landing page
    Given user go to mamikos homepage
    When user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    And user clicks on Enter button Tenant
    And user clicks on Register button
    Then user redirected to "/register-pencari?source=list%20kos%20result"

  @TEST_COOP-6716
  Scenario: Register Tenant - tenant register from kost detail
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe G | Kos DC BAR Automation Tipe G |
    And user clicks on Enter button Tenant
    And user clicks on Register button
    Then user redirected to "/register-pencari?source=property%20detail%20page"

  @TEST_COOP-6903
  Scenario: Register Tenant - From SBMPTN Page
    Given user navigate to SBMPTN page
    And user clicks on Enter button Tenant
    And user clicks on Register button
    Then user redirected to "register-pencari?source="