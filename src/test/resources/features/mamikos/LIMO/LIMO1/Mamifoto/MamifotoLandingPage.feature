@LIMO1 @Mamifoto
Feature: Check Mamifoto Landing Page

  @TEST_LIMO-3587 @continue @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner visits Landing Page of MamiFoto From Owner Dashboard
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag | phone prod | password  |
      | 0891202415 | 0          | qwerty123 |
    And owner dismiss active pop-ups
    When owner click Mamifoto button
    Then owner can see mamifoto page

  @continue @TEST_LIMO-3588
  Scenario: Owner visits Landing Page of MamiFoto from Info Untuk Anda Card
    When owner back to owner dashboard
    And owner dismiss active pop-ups
    And owner click info untuk anda for mamifoto
    Then owner can see mamifoto page

  @continue @TEST_LIMO-3590
  Scenario: Owner click "lihat paket" button MamiFoto
    And owner click Lihat Paket button
    Then owner see pilih paket page

  @continue @TEST_LIMO-3591
  Scenario: Owner click "Baca Panduan" button MamiFoto
    When owner back to Mamifoto Landing Page
    And owner click Baca Panduan button
    Then owner see detail panduan pop up

  @FAQMamifoto @TEST_LIMO-3592
  Scenario: Owner click FAQ
    And owner click any faq button
    Then owner see detail FAQ
    And owner should successfully log out