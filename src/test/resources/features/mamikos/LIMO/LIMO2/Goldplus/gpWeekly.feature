@regression @LIMO2 @gpWeekly
Feature: GP Weekly

  @detailTagihanGoldplus @TEST_LIMO-3488
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "081905128517"

  @TEST_LIMO-3489 @continue
  Scenario: Goldplus Weekly Package
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081905128517 | qwerty123 |
    And owner navigate to list goldplus package
    Then owner see that the text "Mulai Dari" is displayed on goldplus page
    And owner should not be able to see the text "per bulan"

  @TEST_LIMO-3490 @continue
  Scenario: List period GP Weekly
    When owner navigate to list package goldplus 2
    Then user verify list of Goldplus Weekly is appear
      | periodGP | price    |
      | 3 Minggu | Rp100.000|
      | 2 Minggu | Rp17.500 |

  @TEST_LIMO-3491 @continue
  Scenario: Select GP Weekly
    Given owner choose periode goldplus "3 Minggu"
    Then owner see that the text "Pilih Periode GoldPlus 2" is displayed on goldplus page


  @TEST_LIMO-3492 @continue
  Scenario: GoldPlus Weekly Paid
    Given owner click bayar sekarang on detail tagihan page goldplus
    Then owner see that the text "GoldPlus 2" is displayed on goldplus page
    And owner click bayar sekarang on detail tagihan page goldplus
    And payment owner success using ovo as payment method

#  @TEST_LIMO-3493 @continue
#  Scenario: GoldPlus Weekly Paid - Checking Widget
#    Given owner navigates to owner dashboard
#    And owner click close icon pop up
#    Then validate that owner have "GoldPlus 2"

  @TEST_LIMO-3494 @continue
  Scenario: [Owner][GP Recurring] Owner want to cancel GP Recurring via pop up reminder
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When user sets recurring "H3" for number "081905128517"

  @TEST_LIMO-3495
  Scenario: GoldPlus Weekly Recurring - Cancel Recurring
    Given owner navigates to owner dashboard
    And  user can click close button on popup
    When owner wants to access goldplus dashboard
    Then owner will be redirected to invoice recurring

  @TEST_LIMO-3496
  Scenario: [Owner][GP Recurring] Owner want to extend GP via pop up reminder
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When user sets recurring "H1" for number "081905128517"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081905128517 | qwerty123 |
    When owner wants to proccess recurring GP
    Then payment owner success using ovo as payment method
    And owner navigates to owner dashboard
    And owner should not be able to see the text "Perpanjang paket Goldplus yuk!"

  @TEST_LIMO-3497
  Scenario: GoldPlus Weekly - Checking Widget After Terminated
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081905128517 | qwerty123 |
    Then widget daftar goldplus is displayed

  @TEST_LIMO-3498 @continue @detailTagihanGoldplus
  Scenario: [WEB][Detail Tagihan GP] Check wording for GP Shorter period at detail tagihan GP
  #delete or reset data GP
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "082233545519"

     #detail tagihan unpaid
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 082233545519 | qwerty123 |
    And owner choose periode goldplus 2
    * owner click bayar sekarang on detail tagihan page goldplus
    * owner navigates to owner dashboard
    * user click widget GP "Menunggu Pembayaran"
    * user click "Ganti Paket" on pop up "Anda masih memiliki tagihan aktif"
    * user wants to subscribe Goldplus 1
    * owner navigates to "/goldplus/payment"
    * owner select transaction unpaid from history transaction goldplus
    Then owner can see detail tagihan goldplus page with title "Menunggu Pembayaran"
    And owner can see "GoldPlus 1 (1 Minggu)" at section rincian pembayaran goldplus
    #paid GP from page detail tagihan
    Given owner paid transaction from detail tagihan page
    And payment owner success using ovo as payment method

  @TEST_LIMO-3499 @continue @detailTagihanGoldplus
  Scenario: [WEB][GP Shorter][Owner Dashboard] Check pop up intercept when buy GP shorter periode
    Given owner navigates to owner dashboard
 #   Then owner can see pop up goldplus with title "Selamat bergabung di GoldPlus 1!"
 #   And owner can see pop up golplus with desc "Anda mendapatkan kuota chat tanpa batas dan akses ke fitur-fitur khusus GoldPlus yang berguna untuk pemasaran kos Anda."

  @TEST_LIMO-3500 @continue @detailTagihanGoldplus
  Scenario: check wording at page detail tagihan after paid
    Given owner navigates to "/goldplus/payment"
    * owner select transaction paid from history transaction goldplus
    Then owner can see detail tagihan paid goldplus page with title "Lunas"
    And owner can see "GoldPlus 1" at section Paket yang Anda pilih
    And owner can see "GoldPlus 1 (1 Minggu)" at section rincian pembayaran goldplus

  @TEST_LIMO-3501 @detailTagihanGoldplus
  Scenario: [WEB][Detail Tagihan GP] Check wording for GP Shorter period at detail tagihan GP expired
    Given owner navigates to "/goldplus/payment"
    * owner select transaction expired from history transaction goldplus
    Then owner can see detail tagihan goldplus page with title "Dibatalkan"
    And owner can see "GoldPlus 2" at section Paket yang Anda pilih
    And owner can see "GoldPlus 2 (4 Bulan)" at section rincian pembayaran goldplus