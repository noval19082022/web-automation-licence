@LIMO2 @Mamifoto @TEST_LIMO-3022

Feature: Owner can see MamiFoto Purchase History

 #Scenario Owner see MamiFoto Purchase History page
  @continue @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner visits Landing Page of MamiFoto
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 082233545506 | 082144865600 | qwerty123 |
    When owner click menu sidebar Mamifoto
    Then owner can see mamifoto page
    * owner click riwayat paket button
    * owner see Riwayat MamiFoto purchase page

  @continue
  Scenario: Owner see MamiFoto detail in MamiFoto Purchase with status "Pembayaran Berhasil"
    When owner click tab Selesai at riwayat page
    * owner click Lihat Detail Transaksi with status "Pembayaran Berhasil"
    Then owner see status pembelian page

  @continue
  Scenario: Owner see "baca panduan" MamiFoto after complete purchase
    And owner click Baca Panduan button
    Then owner see detail panduan pop up

  @continue
  Scenario: Owner click "Hubungi Kami" MamiFoto after complete purchase
    When click Hubungi Kami button
    Then owner connected to WA CS Mamikos "https://api.whatsapp.com/send/?phone=6281325111171&text&type=phone_number&app_absent=0"