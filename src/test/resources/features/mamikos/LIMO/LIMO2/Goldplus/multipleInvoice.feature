@regression @LIMO2 @listing-monetization @multiple-invoice @LIMO2-staging
Feature: Multiple Invoice

  @TEST_LIMO-2338 @buyGP @multipleInvoice @continue
  Scenario: Buy GP until 2 unpaid invoice
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081905128517 | qwerty123 |
    And user wants to subscribe Goldplus 1
    And user navigates to owner dashboard
    And user click widget GP "Menunggu Pembayaran"
    And user click "Ganti Paket" on pop up "Anda masih memiliki tagihan aktif"
    And user wants to subscribe Goldplus 1
    And owner navigates to "/goldplus/payment"
    Then verify unpaid invoice is 2

  @TEST_LIMO-2667 @checkInfoUntukAndaMultipleInvoice @continue
  Scenario: Check redirection info untuk anda 1 unpaid invoice
    Given user navigates to owner dashboard
    When user click info untuk anda "Kuota chat habis. 2 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas"
    Then user verify pop up message "Anda masih memiliki tagihan aktif" is appear

  @checkBCMultipleInvoice @continue
  Scenario: Check redirection BC 1 unpaid invoice
    Given user navigates to owner dashboard
    When owner navigates to "/broadcast-chat"
    Then verify button on broadcast page

  @checkAturPromoMultipleInvoice @continue
  Scenario: Check redirection Atur Promo
    Given owner navigates to property saya kos
    When owner search kost "Kos Premium Automation 517" on property saya page
    And owner atur promo owner
    Then user verify pop up message "Anda masih memiliki tagihan aktif" is appear

  @TEST_LIMO-2336 @checkChatlistMultipleInvoice @continue
  Scenario: Check Lanjut bayar button on chatlist
    Given owner navigates to owner dashboard
    When owner click lanjut bayar button on chatlist
    Then user verify pop up message "Anda masih memiliki tagihan aktif" is appear

  @checkChatroomsMultipleInvoice @continue
  Scenario: Check lanjut bayar button on chatrooms
    Given owner navigates to owner dashboard
    When owner click lanjut bayar button on chatrooms "Raney Upik Bertiga"
    Then user verify pop up message "Anda masih memiliki tagihan aktif" is appear

  @paidTheUnpaidInvoice @continue
  Scenario: Paid the unpaid invoice
    Given owner navigates to "/goldplus/payment"
    When user click Lihat Tagihan on riwayat
    Then payment owner success using ovo as payment method

  @continue
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "081905128517"