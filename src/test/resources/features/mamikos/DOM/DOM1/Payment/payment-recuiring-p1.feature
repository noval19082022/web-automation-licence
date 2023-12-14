@DOM3
Feature: Payment Recurring kost APIK

  @TEST_COOP-5055
  Scenario: Tenant pay recurring kos Apik using BNI
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878412 | 083176408442 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment method from invoice detail using BNI
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
