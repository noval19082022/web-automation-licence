@regression @LIMO4
Feature: [Owner] Update Content Landing Page & Adjust API Pop Up logic

  @TEST_LIMO-4164 @continue @WEB @AUTOMATED
  Scenario: Update content section "Beragam tempat penayangan iklan"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod  | password   |
      | 0890910001 | 0890910001  | qwerty123  |
    And owner access mamiprime landing page
    Then owner will see that the text "Beragam Tempat Penayangan Iklan" is displayed

  @TEST_LIMO-4537 @continue @WEB @AUTOMATED
  Scenario: Update content section "Q&A"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod  | password   |
      | 0890910001 | 0890910001  | qwerty123  |
    And owner access mamiprime landing page
    Then "Tanya Jawab" are displayed in the biaya tambahan table
      | Tanya Jawab                            |
      | Apa itu layanan MamiPrime?             |
      | Bagaimana cara membeli MamiPrime?      |
      | Apakah harga dan promo MamiPrime yang ditawarkan berlaku selamanya?               |
      | Apakah pembelian MamiPrime berlaku untuk semua properti saya?                     |
      | Apakah saya bisa memilih tempat di mana kos MamiPrime saya akan tayang?           |
      | Apakah paket MamiPrime jumlahnya tidak terbatas?                                  |
      | Berapa lama masa berlangganan Paket Mamikos Prime?                                |
      | Apa yang terjadi jika kos saya sudah penuh sebelum masa aktif MamiPrime berakhir? |
      | Bagaimana cara agar penayangan iklan saya membawa hasil yang maksimal?            |