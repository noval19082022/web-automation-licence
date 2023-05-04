@LIMO2 @Mamifoto @TEST_LIMO-3020

Feature: Check Mamifoto Landing Page

  @continue @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner visits Landing Page of MamiFoto
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 082233545506 | 082144865600 | qwerty123 |
    When owner click menu sidebar Mamifoto
    Then owner can see mamifoto page

  @continue
  Scenario: Owner visits Landing Page of MamiFoto from Info Untuk Anda Card
    When owner back to owner dashboard
    And owner click info untuk anda for mamifoto
    Then owner can see mamifoto page

  @continue
  Scenario: Owner visits Landing Page of MamiFoto from Tingkatkan Kinerja Kos Section
    When owner back to owner dashboard
    And owner click section Tingkatkan Kinerja Kost
    Then owner can see mamifoto page

  @continue
  Scenario: Owner click "lihat paket" button MamiFoto
    And owner click Lihat Paket button
    Then owner see pilih paket page

  @continue
  Scenario: Owner click "Baca Panduan" button MamiFoto
    When owner back to Mamifoto Landing Page
    And owner click Baca Panduan button
    Then owner see detail panduan pop up

  @continue
  Scenario: Owner click FAQ
    And owner click any faq button
    Then owner see detail FAQ
