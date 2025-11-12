@mtresearch @tenant @login
Feature: Tenant Login Research

  Scenario: Tenant login with phone 0891111020198
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |

  Scenario: Tenant login with phone 087708777615
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 087708777615 | 087708777615 | mamikosqa123 |

  Scenario: Tenant login with phone 0810000006
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0810000006  | 0810000006  | qwerty123 |

  Scenario: Tenant login with phone 08100000622
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 08100000622  | 08100000622  | qwerty123 |

  Scenario: Tenant login with phone 0890867321216
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     | phone prod     | password     |
      | 0890867321216  | 0890867321216  | mamikosqa123 |
