@SS8 @kelolaTagihan
Feature: Check Detail Tagihan

  @TEST_SS-4000
  Scenario: Check detail tagihan when money disbursed to owner’s bank account for first invoice
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0890000000289 | 0890000000289 | Bismillah@01 |
    And owner navigate to billing management
    And owner search kost in billing management "kost bima booking dp biaya lain dan denda automation Tobelo Utara Halmahera Utar"
    And owner set Kelola Tagihan filter month to "Januari" month
    And user clicks Sudah bayar tab
    And owner go to detail tagihan
    And owner clicks on lihat status tagihan
    Then owner can see status tagihan "Telah Anda terima. Silakan cek rekening."