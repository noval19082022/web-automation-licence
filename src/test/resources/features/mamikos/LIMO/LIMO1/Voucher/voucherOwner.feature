@regression @LIMO1 @LIMO1-staging @voucher-owner @DONEMIGRATINGTONEWBOARD
Feature: Voucher Owner

  @TEST_LIMO-3291 @continue @invalidVoucher
  Scenario: [Voucher Owner][Apply invalid Voucher] Apply voucher doesnt active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password |
      | 0895365624343 | 0          | 12345678 |
    When user navigates to mamiads dashboard
    And user click "Coba Sekarang"
    And user wants to buy saldo MamiAds "Rp6.000"
  #Voucher doesn't active (LIMO-193)
    And owner click masukkan voucher
    When user input "MAATNOTACTIVEVOUCHER" as kode voucher
    * user click Pakai button
    Then validate the warning "Kode voucher tidak bisa digunakan."
    And user clear the voucher code

  @TEST_LIMO-3292 @continue @invalidVoucher
  Scenario: [Voucher Owner][Apply invalid Voucher] Input invalid voucher code
    When user input "MAATNOTACTIVEVOUCHER1" as kode voucher
    * user click Pakai button
    Then validate the warning "Kode voucher tidak ditemukan."
    And user clear the voucher code

  @TEST_LIMO-3293 @continue @invalidVoucher
  Scenario: [Voucher Owner][Apply invalid Voucher] Input empty voucher
    When user input "" as kode voucher
    * user click Pakai button
    Then validate the warning "Masukkan kode voucher."
    And user clear the voucher code

  @TEST_LIMO-3294 @continue @invalidVoucher
  Scenario: [Voucher Owner][Apply invalid Voucher] Apply voucher with condition Doens't buy minimal saldo the voucher
    When user input "MAATMINTRXVOUCHERMASS" as kode voucher
    * user click Pakai button
    Then validate the warning "Belum mencapai minimal transaksi."
    And user clear the voucher code

  @TEST_LIMO-3295 @continue @invalidVoucher
  Scenario: [Voucher Owner][Apply invalid Voucher] Apply voucher with condition voucher expired
    When user input "KIPUMASSEXPIREDINV" as kode voucher
    * user click Pakai button
    Then validate the warning "Kode voucher tidak bisa digunakan."
    And user clear the voucher code

  @TEST_LIMO-3296 @continue @invalidVoucher
  Scenario: [Voucher Owner][Apply invalid Voucher] Apply voucher with condition quota voucher 0
    When user input "SANITYAPRIL" as kode voucher
    * user click Pakai button
    Then validate the warning "Kuota voucher ini sudah habis."
    And user clear the voucher code

  @TEST_LIMO-3297 @TEST_LIMO-1425
  Scenario: Apply voucher from detail voucher and deleted apply voucher
    And owner back to list voucher
    * user verify "MA AUTOMATION SINGLE VOUCHER" is present on list voucher
    When user click on lihat detail voucher
    Then verify a detail voucher as expected
      | voucherTitle                 | voucherCode                         | voucherExpired                 | voucherTnC                                                                                                    |
      | MA AUTOMATION SINGLE VOUCHER | Kode Voucher: MAATSINGLEVOUCHERNEW1 | Berlaku hingga 27 Oktober 2027 | Voucher hanya digunakan untuk keperluan automation akun 0895365624343Pembelian saldo minimal 5.000Diskon 100% |
#   scenario: apply from detail voucher
    When user click Pakai button
    Then user verify the toast "Voucher Dipakai"
#   scenario: hapus voucher
    When user click hapus voucher
    Then user verify the toast "Voucher Dihapus"
#   scenario: apply from list
    And owner wants to accsess voucher list
    * user verify "MA AUTOMATION SINGLE VOUCHER" is present on list voucher
    When user click Pakai button
    Then user verify the toast "Voucher Dipakai"
    When user click hapus voucher
    Then user verify the toast "Voucher Dihapus"
