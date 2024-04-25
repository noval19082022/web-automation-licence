@DOM10 @essentialTest
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
      | Desta Automation Tobelo Halmahera Utara | kost payment desta 2 |
    And tenant booking kost for "today"
    And tenant logs out

    ## owner accept
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
    And owner accept booking and select the room
    And owner logs out

  @extendContract @TEST_COOP-5181
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

  @paymentBni @TEST_COOP-5184
  Scenario: Tenant pay kos BNI
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method using BNI
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentCreditCard @TEST_COOP-5185
  Scenario: Tenant pay kos credit card
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method Credit Card
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentDana @TEST_COOP-5186
  Scenario: Tenant pay kos Dana
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method with DANA
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentLinkAja @TEST_COOP-5188
  Scenario: Tenant pay kos LinkAja
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method using LinkAja
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentMandiri @TEST_COOP-5189
  Scenario: Tenant pay kos mandiri
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using mandiri without close the page
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentOvo @TEST_COOP-5190
  Scenario: Tenant pay kos ovo
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0892202100" without close the page
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentPermata @TEST_COOP-5191
  Scenario: Tenant pay kos permata
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method using "PERMATA"
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentAlfamart @TEST_COOP-4606
  Scenario: Tenant pay kos BBK alfamart
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method using Alfamart
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @paymentBRIMidtrans @TEST_COOP-5041
  Scenario: Tenant pay kos BBK using BRI
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method using BRI from riwayat booking
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @TEST_COOP-5711
  Scenario: Tenant click bayar saya sudah bayar before paid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant click bayar sekarang before paid
    Then user verify error messages
      | Pembayaran Belum Terverifikasi |

  @TEST_COOP-6905
  Scenario: [Invoice] Check Invoice From Kost saya dibayar
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891112020198 | 0891112020198 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant click sudah di bayar
    Then tenant will see invoice "Dibayar"

  @TEST_COOP-6906
  Scenario: [Invoice] Check Invoice From Kost saya Belum Dibayar
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891112020198 | 0891112020198 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    Then tenant will see invoice "Belum Dibayar"