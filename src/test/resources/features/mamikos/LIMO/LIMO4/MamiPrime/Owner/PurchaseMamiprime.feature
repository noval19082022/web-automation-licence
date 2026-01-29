@regression @LIMO4 @purchaseMamiprime
Feature: Purchase Mamiprime

  @TEST_LIMO-644 @WEB @AUTOMATED
  Scenario Outline: [WEB][Mamikos Prime][Beli Paket] Owner doesn't have property active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password  |
      | <phone number> | <phone number> | qwerty123 |
    And user redirected to URL "https://owner-jambu.kerupux.com/prime"
    And owner wants to buy mamiprime from header
    Then user will see pop up doesnt have property on mamiprime
    Examples:
      | phone number |
      | 082220240418 |
      | 082120240419 |

  @TEST_LIMO-628 @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Beli Paket] Owner only have apartment active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 082320240418 | 082320240418 | qwerty123 |
    And user click on mamiprime widget at owner dashboard
    And owner wants to buy mamiprime from header
    Then user will see pop up doesnt have property on mamiprime

  @TEST_LIMO-624 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Detail Tagihan] Ubah Periode
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 082233545512 | 0          | 12345678 |
    And owner navigate to pendaftaran mamiprime page
    Then owner select option mamiprime "Halaman Hasil Pencarian" from mamiprime landing
    And owner already choose period "7 Hari" with price "Rp164.500"
    And owner wants to change "MamiPrime - Halaman Hasil Pencarian (7 Hari)" at detail tagihan page

  @TEST_LIMO-3563 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Detail Tagihan] set different period after click ubah
    When owner already choose period "14 Hari" with price "Rp308.000"
    Then owner can see package prime selected is "MamiPrime - Halaman Hasil Pencarian (14 Hari)"

  @TEST_LIMO-625 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Pendaftaran Mamiprime] Detail Tagihan
    Then owner can see property name in detail tagihan mamiprime

  @TEST_LIMO-3564 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Detail Tagihan] Bayar Sekarang
    When owner click bayar sekarang at detail tagihan mamiprime
    Then owner will see that the text "MamiPrime - Halaman Hasil Pencarian (14 Hari)" is displayed

  @TEST_LIMO-641 @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Universal Invoice] Owner wants to paid prime invoice
    When payment owner success using ovo as payment method

  @dataPrepareScenario @WEB @AUTOMATED
  Scenario: Reset Mamiprime
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin wants to reset mamiprime for owner with property ID "1000030951"

  @TEST_LIMO-4557 @WEB @AUTOMATED
  Scenario: Listing full room available and check label "kamar penuh and aktif"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202407 | 0          | qwerty123 |
    And owner navigate to pendaftaran mamiprime page
    And owner select option mamiprime "Halaman Pencarian Kos" from mamiprime landing
    Then owner will see that the text "Kamar Penuh" is displayed
    Then owner will see that the text "Aktif" is displayed

  @TEST_LIMO-4560 @WEB @AUTOMATED
  Scenario: auto-select would be the 1st order of listing that is available
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202405 | 0          | qwerty123 |
    And owner navigate to pendaftaran mamiprime page
    And owner select option mamiprime "Halaman Pencarian Kos" from mamiprime landing
    Then owner see auto-select would be the first order

  @TEST_LIMO-4927 @WEB @AUTOMATED
  Scenario: Section on “pendaftaran mamiprime“ display a maximum of 5 only keywords
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202405 | 0          | qwerty123 |
    And owner navigate to pendaftaran mamiprime page
    And owner select option mamiprime "Halaman Pencarian Kos" from mamiprime landing
    Then "Keyword" are displayed in the register mamiprime
      | Keyword   |
      | tegalan   |
      | Tanjung p |
      | Tegal A   |
      | Tj.p      |
      | Telukna   |

  @TEST_LIMO-4782 @WEB @AUTOMATED
  Scenario: Click on Hubungi kami on page Lihat kata kunci
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202405 | 0          | qwerty123 |
    And owner navigate to pendaftaran mamiprime page
    And owner select option mamiprime "Halaman Pencarian Kos" from mamiprime landing
    And owner click "Lihat kata kunci lainnya"
    And owner click on Hubungi Kami
    And owner set active page to 1
    Then user should redirect to link "https://help-waras.kerupux.com/hubungi-kami"

#  @TEST_LIMO-4784 @WEB @AUTOMATED
#  Scenario: Click on Chat dengan CS on page Mamihelp
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag | phone prod   | password  |
#      | 0891202405 | 0            | qwerty123 |
#    And owner navigate to pendaftaran mamiprime page
#    And owner select option mamiprime "Halaman Pencarian Kos" from mamiprime landing
#    And owner click "Lihat kata kunci lainnya"
#    And owner click on Hubungi Kami
#    And owner set active page to 1
#    And user click text "Langsung chat di sini dengan customer service kami."
#    Then user see Contact us pop up is appear

  @TEST_LIMO-4786 @WEB @AUTOMATED
  Scenario: Click on Whatsapp on page Mamihelp
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202405 | 0          | qwerty123 |
    And owner navigate to pendaftaran mamiprime page
    And owner select option mamiprime "Halaman Pencarian Kos" from mamiprime landing
    And owner click "Lihat kata kunci lainnya"
  ## currently its comment due to brwser security issue (https://mamikos-squad.slack.com/archives/CKPEQGK45/p1753772548384249)
#    And owner click on Hubungi Kami
#    And owner set active page to 1
#    And user click text "Hubungi customer service lewat WhatsApp Anda (chat only)."
#    And owner set active page to 2
#    Then user should redirect to link that contains "https://api.whatsapp.com/send/?phone=6281325111171&text&type=phone_number&app_absent=0"