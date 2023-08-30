@LIMO2 @Mamifoto @MamifotoHistory

Feature: Owner can see MamiFoto Purchase History

 #Scenario Owner see MamiFoto Purchase History page
  @continue @TEST_LIMO-3022 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner visits Landing Page of MamiFoto
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 082233545506 | 082144865600 | qwerty123 |
    When owner click menu sidebar Mamifoto
    Then owner can see mamifoto page
    * owner click riwayat paket button
    * owner see Riwayat MamiFoto purchase page

  @checkDoesntHaveTransaction @continue
  Scenario: Owner didnt have any transaction in Dalam proses Riwayat screen tab
    When owner click tab Dalam Proses at riwayat page
    Then owner see description "Belum Ada Transaksi"

  @checkHistorySuccsessPaid @continue
  Scenario: Owner see MamiFoto detail in MamiFoto Purchase with status "Pembayaran Berhasil"
    When owner click tab Selesai at riwayat page
    * owner click Lihat Detail Transaksi with status "MamiFoto A Non GP Pembayaran Berhasil"
    Then owner see status pembelian page

  @checkBacaPanduan @continue
  Scenario: Owner see "baca panduan" MamiFoto after complete purchase
    And owner click Baca Panduan button
    Then owner see detail panduan pop up

  @checkWAredirect @continue
  Scenario: Owner click "Hubungi Kami" MamiFoto after complete purchase
    When click Hubungi Kami button
    Then owner connected to WA CS Mamikos "https://api.whatsapp.com/send/?phone=6281325111171&text&type=phone_number&app_absent=0"

  @checkOldProphoto
    Scenario: Owner has at least one invoice old Prophoto packages or new MamiFoto packages
    When owner set active page to 0
    * owner click Lihat Detail Transaksi old Pro Photo with status "Pro Photo Pembayaran Berhasil"
    Then owner see status pembelian page
    And owner should successfully log out

  @MamifotoExpired @TEST_LIMO-3787 @declarative @listing-monetization @reviewed @Automated @web @playWright
    Scenario: Owner see MamiFoto detail in MamiFoto Purchase with status "Kadaluarsa"
      Given user go to mamikos homepage
      And user login as owner:
        | phone stag  | phone prod | password |
        | 08766236901 | 0          | 12345678 |
      * owner click menu sidebar Mamifoto
      * owner can see mamifoto page
      * owner click riwayat paket button
      When owner click tab Selesai at riwayat page
      * owner click Lihat Detail Transaksi expired with status "MamiFoto A GP Kadaluwarsa"
      Then owner see expired invoice mamifoto


