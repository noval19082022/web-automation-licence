@DOM1 @essentialTest
Feature: Payment All
  
@continue
  Scenario: Delete and create contract
    #delete contract
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

  @paymentCreditCard @TEST_SS-2745 @continue
  Scenario: [Booking][Invoice] Tenant pay kos credit card
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0895124719 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method Credit Card
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
    And tenant close unused browser tab
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking

  @TEST_SS-2752 @continue
  Scenario: [Invoice] Check Invoice From Kost saya dibayar
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    And tenant click sudah di bayar
    Then tenant will see that the text "Dibayar" is displayed

  @paymentBni @TEST_SS-2744 @continue
  Scenario: [Invoice] Tenant pay kos BNI
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment method using BNI
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
    And tenant close unused browser tab

  @paymentMandiri @TEST_SS-2748 @continue
  Scenario: [Invoice] Tenant pay kos mandiri
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant pay invoice from invoice detail using mandiri without close the page
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
    And tenant close unused browser tab

  @paymentPermata @TEST_SS-2750 @continue
  Scenario: [Invoice] Tenant pay kos permata
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment method from invoice detail using Permata
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
    And tenant close unused browser tab

  @paymentBRIMidtrans @TEST_SS-2735 @continue
  Scenario: [Invoice] Tenant pay kos BBK using BRI
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment method from invoice detail using BRI
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
    And tenant close unused browser tab

  @paymentDana @TEST_SS-2746 @continue
  Scenario: [Invoice] Tenant pay kos Dana
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment from invoice detail with DANA
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
    And tenant close unused browser tab

  @paymentLinkAja @TEST_SS-2747 @continue
  Scenario: [Invoice] Tenant pay kos LinkAja
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment from invoice detail using LinkAja
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
    And tenant close unused browser tab

  @paymentOvo @TEST_SS-2749 @continue
  Scenario: [Invoice] Tenant pay kos ovo
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant pay booking to extended contract using ovo "0892202100"
    And tenant close unused browser tab

  @paymentAlfamart @TEST_SS-3098 @continue
  Scenario: [Invoice] Tenant pay kos BBK alfamart
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment using alfamart xendit as payment method from invoice detail
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success
    And tenant close unused browser tab

  @TEST_SS-2870 @continue
  Scenario: [Invoice] Tenant pay kos using indomaret
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant select payment using indomaret xendit as payment method from invoice detail
    And tenant want to see invoice on riwayat booking after payment
    Then tenant will see payment is success

  @TEST_COOP-6906 @continue
  Scenario: [Invoice] Check Invoice From Kost saya Belum Dibayar
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    Then tenant will see invoice "Belum Dibayar"

  @TEST_SS-2753
  Scenario: [Invoice] Tenant click bayar saya sudah bayar before paid
    Given user go to mamikos homepage
    When tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant click bayar sekarang before paid
    Then user verify error messages
      | Pembayaran Belum Terverifikasi |
    And tenant close unused browser tab

#    @extendContract @TEST_COOP-5181
#  Scenario: extend contract from admin
#    Given admin go to mamikos mamipay admin
#    When admin search contract by tenant phone number:
#      | phone stag | phone prod  |
#      | 0895124719 | 08119787884 |
#    And admin search contract by kost level "SinggahSini"
#    And this step is comment for whale because the button is hide after ARAC project phase 1 release
#    And admin want to extend contract
#    Then admin will see detail pop up "Custom Extend Contract"
#    And admin fills duration "8" month
#    And admin click extend button