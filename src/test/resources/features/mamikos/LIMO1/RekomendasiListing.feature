Feature: Rekomendasi Listing

  @TEST_LIMO-305
  Scenario: Tenant never lihat detail properti
    Given user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag    | password  |
      | 0812233445566 | qwerty123 |
    Then verify message "Belum ada kos yang di favorit." di Favorit page
    And verify no rekomendasi on kos saya page

