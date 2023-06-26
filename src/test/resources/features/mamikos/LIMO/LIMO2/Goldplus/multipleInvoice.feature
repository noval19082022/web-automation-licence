@regression @LIMO2 @listing-monetization @multiple-invoice @LIMO2-staging
Feature: Multiple Invoice

  @TEST_LIMO-2667
    Scenario: Check redirection while only have 1 unpaid invoice GPLT
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 085951394565  | qwerty123 |
    When user wants to subscribe Goldplus 2
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
    Then owner will see that the text "Paket GoldPlus " is displayed
    When owner navigates to "/goldplus/payment"
    Then verify unpaid invoice is 1

  @TEST_LIMO-2331
  Scenario: Multiple invoice from GP dashboard
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 085951394565  | qwerty123 |
    And user click widget GP "Menunggu Pembayaran"
    And user click "Lihat Tagihan" on pop up "Anda masih memiliki tagihan aktif"
    Then owner will see that the text "Paket GoldPlus 2 periode 4 bulan" is displayed
    When owner navigates to "/goldplus/payment"
    Then verify unpaid invoice is 1
    When user navigates to owner dashboard
    And user click widget GP "Menunggu Pembayaran"
    And user click "Ganti Paket" on pop up "Anda masih memiliki tagihan aktif"
    And user wants to subscribe Goldplus 1
    And owner navigates to "/goldplus/payment"
    Then verify unpaid invoice is 2

  @TEST_LIMO-2325
  Scenario: Paid 1 of unpaid invoice GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 085951394565  | qwerty123 |
    And owner navigates to "/goldplus/payment"
    And user click Lihat Tagihan on riwayat
    Then payment owner success using ovo as payment method