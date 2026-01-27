@regression @LIMO2 @listing-monetization @LIMO2-staging @multipleInvoice
Feature: Multiple Invoice

  @TEST_LIMO-3515
  Scenario: scenario reset gp
    ## scenario reset gp
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "081905128517"

    ## scenario buy until unpaid invoice

  @TEST_LIMO-3515 @buyGP  @multiple-invoice @continue  @resetGP  @multiple-invoice
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

##  Let's comment it out for now since the data keeps changing.
#  @TEST_LIMO-2667 @checkInfoUntukAndaMultipleInvoice @continue  @multiple-invoice
#  Scenario: Check redirection info untuk anda 1 unpaid invoice
#    Given user navigates to owner dashboard
#    When user click info untuk anda "Kuota chat habis. 2 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas"
#    Then user verify pop up message "Anda masih memiliki tagihan aktif" is appear

  @TEST_LIMO-3516 @checkBCMultipleInvoice @continue  @multiple-invoice
  Scenario: Check redirection BC 1 unpaid invoice
    Given user navigates to owner dashboard
    When owner navigates to "/broadcast-chat"
    Then verify button on broadcast page

  @TEST_LIMO-3517 @checkAturPromoMultipleInvoice @continue  @multiple-invoice
  Scenario: Check redirection Atur Promo
    Given owner navigates to property saya kos
    When owner search kost "Kos Premium Automation 517" on property saya page
    And owner cek promo owner when not GP
    Then user verify pop up message "Anda masih memiliki tagihan aktif" is appear

  @TEST_LIMO-3518 @checkChatlistMultipleInvoice @continue  @multiple-invoice
  Scenario: Check Lanjut bayar button on chatlist
    Given owner navigates to owner dashboard
    And user dismiss FTUE MARS and FTUE Broadcast
    And user dismiss FTUE survey kost
    And user dismiss Laporan klik FTUE
    And owner click "Bayar" button on chatlist
    Then user verify pop up message "Anda masih memiliki tagihan aktif" is appear

##  Let's comment it out for now since the data keeps changing.
#  @checkChatroomsMultipleInvoice @continue  @multiple-invoice
#  Scenario: Check lanjut bayar button on chatrooms
#    Given owner navigates to owner dashboard
#    When owner click "Lanjut Bayar" button on chatrooms "Raney Upik Berdelapan"
#    Then user verify pop up message "Anda masih memiliki tagihan aktif" is appear

  @TEST_LIMO-3519 @paidTheUnpaidInvoice @continue  @multiple-invoice
  Scenario: Paid the unpaid invoice
    Given owner navigates to "/goldplus/payment"
    When user click Lihat Tagihan on riwayat
    Then payment owner success using ovo as payment method

  @resetGP  @multiple-invoice
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "081905128517"