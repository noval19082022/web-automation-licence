@DOM1 @essentialTest
Feature: Payment All

  Background: Delete and create contract
    ##delete contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag | phone prod  |
      | 0895124719 | 08119787884 |
    And admin want to batalkan contract if exist

    ##cancel booking if tenant have booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And user cancel booking

    ##create contract
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag          | kost name prod       |
      | Desta Automation tobelo | kost payment desta 2 |
    And tenant booking kost for "today"
    And tenant logs out

    ## owner accept
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
    And owner accept booking and select the room
    Then owner should redirect back to pengajuan booking page
    And owner logs out

  @extendContract @TEST_DOM-730
  Scenario: extend contract from admin
    Given admin go to mamikos mamipay admin
    When admin search contract by tenant phone number:
      | phone stag | phone prod  |
      | 0895124719 | 08119787884 |
    And admin search contract by kost level "SinggahSini"
#  this step is comment for whale because the button is hide after ARAC project phase 1 release
#    And admin want to extend contract
#    Then admin will see detail pop up "Custom Extend Contract"
#    And admin fills duration "8" month
#    And admin click extend button

  @paymentBni @TEST_DOM-536
  Scenario: Tenant pay kos BNI
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method using BNI
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentCreditCard @TEST_DOM-573
  Scenario: Tenant pay kos credit card
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method Credit Card with cc number is "4811 1111 1111 1114", expired date month "01" years "25", and ccv is "123"
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentDana @TEST_DOM-577
  Scenario: Tenant pay kos Dana
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method with DANA
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentLinkAja @TEST_DOM-574
  Scenario: Tenant pay kos LinkAja
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method using LinkAja
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentMandiri @TEST_DOM-487
  Scenario: Tenant pay kos mandiri
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using mandiri without close the page
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentOvo @TEST_DOM-484
  Scenario: Tenant pay kos ovo
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0892202100" without close the page
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentPermata @TEST_DOM-486
  Scenario: Tenant pay kos permata
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method using "PERMATA"
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentAlfamart @COOP-4606
  Scenario: Tenant pay kos BBK alfamart
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method using Alfamart
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success