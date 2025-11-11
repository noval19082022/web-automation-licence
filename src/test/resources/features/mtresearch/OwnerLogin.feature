@mtresearch @owner @login
Feature: Owner Login Research

  Scenario: Owner login with phone 081362464341
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |

  Scenario: Owner login with phone 08119787884
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08119787884 | 08119787884 | qwerty123 |

  Scenario: Owner login with phone 0888881241
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0888881241 | 0888881241 | qwerty123 |

  Scenario: Owner login with phone 081328787342
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password    |
      | 081328787342  | 081328787342  | Bismillah@01 |

  Scenario: Owner login with phone 08900000000021
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod      | password     |
      | 08900000000021  | 08900000000021  | mamikosqa123 |
