@regression @LIMO4
Feature: Owner - Rejected Kos

  @WEB @AUTOMATED
  Scenario: Owner - Rejected Kos
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password   |
      | 083176408311   | 083132824758   | qwerty123  |
    When owner navigates to property saya kos
    And owner search kost "Kost Rejected Del SJkJs xMxOZ" on property saya page
    Then user see kos with name "Kost Rejected Del SJkJs xMxOZ", status "Data Kos Ditolak" and type "Kos Putri"