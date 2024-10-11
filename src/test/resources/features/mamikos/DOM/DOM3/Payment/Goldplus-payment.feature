@DOM3
Feature: Payment Goldplus staging

  Background: Admin reset GP owner
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "089145645609"

  @payWithAlfamart @TEST_SS-3089
  Scenario: Owner Purchase GP using alfamart
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner select payment using alfamart xendit as payment method from invoice detail
    Then owner will see that the text "Pembayaran Berhasil" is displayed

  @paymentPermata @TEST_SS-3090
  Scenario: Owner Purchase GP using permata
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner select payment method from invoice detail using "PERMATA"
    And owner navigates to "/goldplus/payment"
    And owner click filter "Selesai" in Pembayaran Tagihan Goldplus page
    Then owner will see that the text "Lunas" is displayed


  @payWithLinkAja @TEST_SS-3091
  Scenario: Owner Purchase GP using linkaja
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner select payment from invoice detail using LinkAja
    And owner set active page to 0
    And owner navigates to "/goldplus/payment"
    And owner click filter "Selesai" in Pembayaran Tagihan Goldplus page
    Then owner will see that the text "Lunas" is displayed

  @payWithDana @TEST_SS-3092
  Scenario: Owner Purchase GP using dana
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner select payment from invoice detail with DANA
    And owner set active page to 0
    And owner navigates to "/goldplus/payment"
    And owner click filter "Selesai" in Pembayaran Tagihan Goldplus page
    Then owner will see that the text "Lunas" is displayed

  @payWithCreditCard @TEST_SS-3093
  Scenario: Owner Purchase GP using credit card
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner select payment from invoice detail using Credit Card
    And owner navigates to "/goldplus/payment"
    And owner click filter "Selesai" in Pembayaran Tagihan Goldplus page
    Then owner will see that the text "Lunas" is displayed

  @payWithBni @TEST_SS-3094
  Scenario: Owner Purchase GP using bni
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner select payment method from invoice detail using BNI
    And owner navigates to "/goldplus/payment"
    And owner click filter "Selesai" in Pembayaran Tagihan Goldplus page
    Then owner will see that the text "Lunas" is displayed

  @payWithBri @TEST_SS-3095
  Scenario: Owner Purchase GP using bri
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner select payment method from invoice detail using BRI
    And owner navigates to "/goldplus/payment"
    And owner click filter "Selesai" in Pembayaran Tagihan Goldplus page
    Then owner will see that the text "Lunas" is displayed

  @payWithMandiri @TEST_SS-3096
  Scenario: Owner Purchase GP using mandiri
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner pay invoice from invoice detail using mandiri without close the page
    And owner navigates to "/goldplus/payment"
    And owner click filter "Selesai" in Pembayaran Tagihan Goldplus page
    Then owner will see that the text "Lunas" is displayed

  @payBniWithVoucher
  Scenario: Owner Purchase GP using bni
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | GPFIX5K           | VTOTALUSAGE       |
    And owner select payment method from invoice detail using BNI
    And owner navigates to "/goldplus/payment"
    And owner click filter "Selesai" in Pembayaran Tagihan Goldplus page
    Then owner will see that the text "Lunas" is displayed

  @invalidVoucherGP
  Scenario: user input manually invalid voucher
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | GPFIX10K          | VTOTALUSAGE       |
    Then tenant can see warning message "Kode voucher tidak ditemukan."

  @closePopUpInvoice
  Scenario: user want to close popup voucher
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And user click button masukan on voucher
    And user can click close button on popup
    Then owner will see that the text "Voucher Anda" is displayed

  @viewDetailVoucher
  Scenario: user want to close popup voucher
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And user click button masukan on voucher
    And user can click close button on popup
    And user click on lihat detail voucher
    Then owner will see that the text "Kode Voucher: COBATESMINIMUM" is displayed

  @deleteVoucherGp
  Scenario: User want to delete voucher after input voucher in GP invoice
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089145645609 | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | GPFIX5K           | VTOTALUSAGE       |
    And owner click "Hapus"
    Then user verify the toast "Voucher Dihapus"


