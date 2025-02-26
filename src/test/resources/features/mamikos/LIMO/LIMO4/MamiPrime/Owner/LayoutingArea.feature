@regression @LIMO4 @layoutingArea
Feature: [Owner] Update Content Landing Page & Adjust API Pop Up logic

  @TEST_LIMO-4164 @continue @WEB @AUTOMATED
  Scenario: Update content section "Beragam tempat penayangan iklan"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0890910001 | 0890910001 | qwerty123 |
    And owner access mamiprime landing page
    Then owner will see that the text "Beragam Tempat Penayangan Iklan" is displayed

  @TEST_LIMO-4537 @continue @WEB @AUTOMATED
  Scenario: Update content section "Q&A"
    Given user go to mamikos homepage
    And owner access mamiprime landing page
    Then "Tanya Jawab" are displayed in the biaya tambahan table
      | Tanya Jawab                                                                       |
      | Apa itu layanan MamiPrime?                                                        |
      | Bagaimana cara membeli MamiPrime?                                                 |
      | Apakah harga dan promo MamiPrime yang ditawarkan berlaku selamanya?               |
      | Apakah pembelian MamiPrime berlaku untuk semua properti saya?                     |
      | Apakah saya bisa memilih tempat di mana kos MamiPrime saya akan tayang?           |
      | Apakah paket MamiPrime jumlahnya tidak terbatas?                                  |
      | Berapa lama masa berlangganan Paket Mamikos Prime?                                |
      | Apa yang terjadi jika kos saya sudah penuh sebelum masa aktif MamiPrime berakhir? |
      | Bagaimana cara agar penayangan iklan saya membawa hasil yang maksimal?            |

  @TEST_LIMO-4538 @WEB @AUTOMATED
  Scenario: Update content section "Q&A"
    Given user go to mamikos homepage
    And owner access mamiprime landing page
    Then "Tanya Jawab" are displayed in the biaya tambahan table
      | Tanya Jawab                                                                       |
      | Apa itu layanan MamiPrime?                                                        |
      | Bagaimana cara membeli MamiPrime?                                                 |
      | Apakah harga dan promo MamiPrime yang ditawarkan berlaku selamanya?               |
      | Apakah pembelian MamiPrime berlaku untuk semua properti saya?                     |
      | Apakah saya bisa memilih tempat di mana kos MamiPrime saya akan tayang?           |
      | Apakah paket MamiPrime jumlahnya tidak terbatas?                                  |
      | Berapa lama masa berlangganan Paket Mamikos Prime?                                |
      | Apa yang terjadi jika kos saya sudah penuh sebelum masa aktif MamiPrime berakhir? |
      | Bagaimana cara agar penayangan iklan saya membawa hasil yang maksimal?            |
    And owner click "Apakah saya bisa memilih tempat di mana kos MamiPrime saya akan tayang?"
    And owner click on text sini
    Then new tab open redirect to "Mamiprime"

  @TEST_LIMO-4539 @WEB @AUTOMATED
  Scenario: Update content section "Q&A"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202414 | 0890910001 | qwerty123 |
    And owner access mamiprime landing page
    And owner wants to buy mamiprime from header
    And owner select option mamiprime "Halaman Pencarian Kos" from mamiprime landing
    Then owner will see that the text "Belum Bisa Membeli MamiPrime" is displayed

  @TEST_LIMO-4540 @WEB @AUTOMATED
  Scenario: Update content section "Q&A"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202401 | 0890910001 | qwerty123 |
    And owner access mamiprime landing page
    And owner wants to buy mamiprime from header
    Then owner will see that the text "Anda Belum Dapat Mendaftar MamiPrime" is displayed
    Then owner will see that the text "Tambahkan properti kos aktif dahulu agar dapat bergabung dengan MamiPrime." is displayed

  @TEST_LIMO-4774 @WEB @AUTOMATED
  Scenario: Update content section "Q&A"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202412 | 0890910001 | qwerty123 |
    And owner access mamiprime landing page
    And owner wants to buy mamiprime from header
    Then owner will see that the text "Anda belum memakai GoldPlus. Pemakaian MamiPrime bersama GoldPlus akan membawa hasil yang optimal." is displayed

  @TEST_LIMO-6910 @WEB @AUTOMATED
  Scenario: Update content section "Q&A"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202102 | 0890910001 | qwerty123 |
    And owner access mamiprime landing page
    And owner wants to buy mamiprime from header
    Then owner select option mamiprime "Halaman Hasil Pencarian" from mamiprime landing
    Then user see auto-select would be the first order

