@regression @LIMO1 @LIMO1-staging @voucher-owner
Feature: Voucher


  @TEST_LIMO-193 @continue @invalidVoucher
  Scenario: Apply voucher doesnt active
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 0895365624343 | 0          | 12345678 |
    When user navigates to mamiads dashboard
    And user click "Coba Sekarang"
    And user close mamiads onboarding popup
    And user wants to buy saldo MamiAds "Rp6.000"
  #Voucher doesn't active (LIMO-193)
    And owner click masukkan voucher
    When user input "MAATNOTACTIVEVOUCHER" as kode voucher
    * user click Pakai button
    Then validate the warning "Kode voucher tidak bisa digunakan."
     And user clear the voucher code

  @TEST_LIMO-177 @continue @invalidVoucher
    Scenario: Input invalid voucher code
    When user input "MAATNOTACTIVEVOUCHER1" as kode voucher
    * user click Pakai button
    Then validate the warning "Kode voucher tidak ditemukan."
    And user clear the voucher code

  @TEST_LIMO-175 @continue @invalidVoucher
  Scenario: Input empty voucher
    When user input "" as kode voucher
    * user click Pakai button
    Then validate the warning "Masukkan kode voucher."
    And user clear the voucher code

  @TEST_LIMO-187 @continue @invalidVoucher
  Scenario: Apply voucher with condition Doens't buy minimal saldo the voucher
    When user input "MAATMINTRXVOUCHERMASS" as kode voucher
    * user click Pakai button
    Then validate the warning "Belum mencapai minimal transaksi."
    And user clear the voucher code

  @TEST_LIMO-181 @continue @invalidVoucher
  Scenario: Apply voucher with condition voucher expired
    When user input "KIPUMASSEXPIREDINV" as kode voucher
    * user click Pakai button
    Then validate the warning "Kode voucher tidak bisa digunakan."
    And user clear the voucher code

  @TEST_LIMO-178 @invalidVoucher
  Scenario: Apply voucher with condition quota voucher 0
    When user input "SANITYAPRIL" as kode voucher
    * user click Pakai button
    Then validate the warning "Kuota voucher ini sudah habis."
    And user clear the voucher code



