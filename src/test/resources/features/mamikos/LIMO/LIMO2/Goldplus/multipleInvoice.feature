@regression @LIMO2 @listing-monetization @multiple-invoice @LIMO2-staging
Feature: Multiple Invoice

  @TEST_LIMO-2667 @oneUnpaidInvoice @nonExperiment @continue
    Scenario: Check redirection while only have 1 unpaid invoice GPLT
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 085951394565  | qwerty123 |
    And user wants to subscribe Goldplus 2
    And user navigates to owner dashboard
    And user click info untuk anda "GoldPlus 2 diskon 15% hanya dengan voucher di halaman pembayaran!"
    Then owner will see that the text "Pilih Periode Berlangganan" is displayed

    #multiple invoice from Broadcast chat while on process buy GP1
    When owner navigates to "/broadcast-chat"
    Then user verify Lihat Invoice visible
    When owner navigates to "/cek-properti-sekitar"
    Then user see Title on page "cek properti sekitar" is "Buka Cek Properti Sekitar di Aplikasi" with message:
    """
    Untuk saat ini, fitur Cek Properti Sekitar hanya dapat
    digunakan di aplikasi Mamikos di Android dan iOS.
    """
    When owner navigates to property saya kos
    And owner search kost "Kos Adelia 4565 Tipe A" on property saya page
    And owner atur promo owner
    Then owner see jenis pembayaran "GoldPlus 2 periode 4 Bulan"
    When owner navigates to "/goldplus/payment"
    Then verify unpaid invoice is 1

  @TEST_LIMO-2331 @moreThanOneUnpaidInvoice @nonExperiment @continue
  Scenario: Multiple invoice from GP dashboard
    Given user navigates to owner dashboard
    When user click widget GP "Menunggu Pembayaran"
    And user click "Lihat Tagihan" on pop up "Anda masih memiliki tagihan aktif"
    Then owner see jenis pembayaran "GoldPlus 2 periode 4 Bulan"
    When owner navigates to "/goldplus/payment"
    Then verify unpaid invoice is 1
    When user navigates to owner dashboard
    And user click widget GP "Menunggu Pembayaran"
    And user click "Ganti Paket" on pop up "Anda masih memiliki tagihan aktif"
    And user wants to subscribe Goldplus 1
    And owner navigates to "/goldplus/payment"
    Then verify unpaid invoice is 2

  @TEST_LIMO-2325 @paidOneInvoice @nonExperiment @continue
  Scenario: Paid 1 of unpaid invoice GP
    Given user click Lihat Tagihan on riwayat
    When payment owner success using ovo as payment method

  @continue
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "085951394565"

  @TEST_LIMO-2327 @experimentOwner @oneUnpaidInvoice @continue
  Scenario: Multiple invoice owner experiment while 1 unpaid invoice
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 081905128517  | qwerty123 |
    And user wants to subscribe Goldplus 1
    And user navigates to owner dashboard
    And user click info untuk anda "Kuota chat habis. 1 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas chat."
    Then owner see jenis pembayaran "GoldPlus 1 periode 4 Bulan"
    When owner navigates to "/goldplus/payment"
    Then verify unpaid invoice is 1
    When owner navigates to "/broadcast-chat"
    Then verify button on broadcast page

  @TEST_LIMO-2338 @experimentOwner @moreThanOneUnpaidInvoice @continue
  Scenario: Multiple invoice owner experiment while unpaid invoice more than 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
        | 081905128517  | qwerty123 |
    Given user navigates to owner dashboard
    When user click widget GP "Menunggu Pembayaran"
    And user click "Ganti Paket" on pop up "Anda masih memiliki tagihan aktif"
    And user wants to subscribe Goldplus 1
    And user navigates to owner dashboard
    And user click info untuk anda "Kuota chat habis. 1 pencari kos menunggu balasan, pakai GoldPlus agar bisa balas chat."
    Then user verify pop up message "Anda masih memiliki tagihan aktif" is appear
    When owner click close icon pop up
    And owner verify intercept tagihan pop up on chatlist
    And owner click close icon pop up
    And owner navigates to owner dashboard
    And owner verify intercept tagihan pop up on chatroom
    And user click "Lihat Tagihan" on pop up "Anda masih memiliki tagihan aktif"
    Then verify unpaid invoice is 2

  @TEST_LIMO-3915 @multipleGPWeekly @ownerExperiment @continue
  Scenario: Multiple invoice with Buy GP weekly
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 081905128517  | qwerty123 |
    Given user navigates to owner dashboard
    When user click widget GP "Menunggu Pembayaran"
    And user click "Ganti Paket" on pop up "Anda masih memiliki tagihan aktif"
    And user wants to subscribe Goldplus 1 weekly
    Then owner see jenis pembayaran "GoldPlus 1 periode 1 Minggu"
    When owner navigates to "/goldplus/payment"
    Then owner paid the riwayat periode "1 Minggu"
    When payment owner success using ovo as payment method


  @continue
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "081905128517"















