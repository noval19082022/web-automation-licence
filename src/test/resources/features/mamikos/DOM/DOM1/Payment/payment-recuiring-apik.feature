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

  @TEST_COOP-5056
  Scenario: Tenant pay recurring kos Apik using credit card
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878412 | 083176408442 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment from invoice detail using Credit Card with cc number is "4811 1111 1111 1114", expired date month "01" years "25", and ccv is "123"
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @TEST_COOP-5057
  Scenario: Tenant pay recurring kos Apik using Dana
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878412 | 083176408442 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment from invoice detail with DANA
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @TEST_COOP-5058
  Scenario: Tenant pay recurring kos Apik using LinkAja
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878412 | 083176408442 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment from invoice detail using LinkAja
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @TEST_COOP-5059
  Scenario: Tenant pay recurring kos Apik using Mandiri
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878412 | 083176408442 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant pay invoice from invoice detail using mandiri without close the page
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
