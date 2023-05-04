@LIMO2 @Mamifoto

Feature: Entry Point Mamifoto when doesnt have property active

  @continue @TEST_LIMO-3201 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner dont have property active visits Landing Page of MamiFoto
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 086412300123 | 082144865601 | qwerty123 |
    When owner click menu sidebar Mamifoto
    Then owner can see mamifoto page

  @continue
  Scenario: check section Tingkatkan Konerja kost is appear
    When owner back to owner dashboard
    Then owner click section Tingkatkan Kinerja Kost
    And owner can see mamifoto page

  @continue
  Scenario: check section Info Untuk Anda for Mamifoto is appear
    When owner back to owner dashboard
    Then owner click info untuk anda for mamifoto non property
    And owner can see mamifoto page

  @continue
  Scenario: Owner dont have property active click "lihat paket" button MamiFoto
    When owner click Lihat Paket button
    And owner select package mamifoto
    Then owner see pop up doesnt have property








