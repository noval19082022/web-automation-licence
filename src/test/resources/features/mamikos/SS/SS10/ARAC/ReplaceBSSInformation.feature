@regression @replaceBSSInfo @SS8

Feature: Replace BSS Information

  @TEST_SS-3360
  Scenario: Check Calendar if there is any vacant rooms today
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                                                               | kost path prod               |
      | kost-kabupaten-badung-kost-campur-eksklusif-kost-general-irvi-automation-abiansemal-badung-1 | Kos DC BAR Automation Tipe A |
    And tenant open calendar from kost detail
    Then tenant will see BSS Information "Berikut adalah tanggal check-in (mulai ngekos) yang tersedia."