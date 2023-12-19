@regression @goldPlus @LIMO2 @listing-monetization @checkfailedSelasaII
Feature: Dashboard GP

  @TEST_LIMO-36 @continue @checkAllFilter @dashboardGP
  Scenario: Check section Kos GoldPlus Anda at dashboard GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 087133998156 | 0          | qwerty123 |
    And owner wants to accses dashboard GP
    Then user will see that the text "Kos GoldPlus Anda" is displayed
    * user will see that the text "Informasi mengenai paket GoldPlus yang Anda miliki." is displayed
    * user will see that the text "Properti Terdaftar GoldPlus" is displayed
    * user click "Lihat Selengkapnya"
    * user will see that the text "Paket GoldPlus Anda" is displayed
    * user see status goldplus is "Goldplus 1"

  @checkAllFilter @continue @dashboardGP
  Scenario: Check all Filter Page Paket GoldPlus Anda (Semua, Aktif, Menunggu Pembayaran Sedan Diproses)
    When user click "Aktif"
    Then user see status goldplus is "Goldplus 1"
    When user click "Menunggu Pembayaran"
    Then user will see that the text "Kos GoldPlus Tidak Ditemukan" is displayed
    * user will see that the text "Saat ini belum ada kos GoldPlus Anda yang Menunggu pembayaran." is displayed
    When user click "Sedang Diproses"
    Then user will see that the text "Kos GoldPlus Tidak Ditemukan" is displayed
    * user will see that the text "Saat ini belum ada kos GoldPlus Anda yang Sedang Diproses." is displayed

  @TEST_LIMO-49 @dashboardGP @listTagihanGP
  Scenario: Check list tagihan GP from dashboard GP
    When owner click back to dashboard GP
    And user scroll to section pembayaran tagihan goldplus
    Then user will see that the text "Pembayaran Tagihan Goldplus" is displayed
    * user will see that the text "Tagihan pembayaran paket GoldPlus Anda dan cara perpanjangan paket." is displayed
    * user will see that the text "Menunggu Pembayaran" is displayed
    * owner click lihat selengkapnya at section tagihan
    * user will see that the text "Tidak Ada yang Perlu Dibayar" is displayed
    * user will see that the text "Semua tagihan yang belum dibayar dan tagihan mendatang akan muncul di halaman ini." is displayed
    When user click tab selesai
    Then user see list detail tagihan goldplus