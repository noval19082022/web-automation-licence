@regression @replaceBSSInfo @BBM8

Feature: Replace BSS Information

  @TEST_BBM-3638
  Scenario: Check Calendar if there is any vacant rooms today
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     |  phone prod     | password     |
      | 0891111020198  |  0891111020198  | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kost General Irvi Automation | Kost General Irvi Automation |
    And tenant open calendar from kost detail
    Then tenant will see BSS Information "Berikut adalah tanggal check-in (mulai ngekos) yang tersedia."

