@LIMO1 @Mamifoto @MamifotoDoesntHavePropertyActive
Feature: Entry Point Mamifoto when does not have property active

  @continue @TEST_LIMO-3570 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner dont have property active visits Landing Page of MamiFoto
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202415 | 082144865601 | qwerty123 |
    And owner dismiss active pop-ups
    When owner click Mamifoto button
    Then owner can see mamifoto page

  @continue @TEST_LIMO-3571
  Scenario: check section Tingkatkan Konerja kost is appear
    When owner back to owner dashboard
    And owner dismiss active pop-ups
    Then owner click section Tingkatkan Kinerja Kost
    And owner can see mamifoto page

  @TEST_LIMO-3572
  Scenario: check section Info Untuk Anda for Mamifoto is appear
    When owner back to owner dashboard
    And owner dismiss active pop-ups
    Then owner click info untuk anda for mamifoto non property
    And owner can see mamifoto page

  @TEST_LIMO-3579 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner dont have property active purchase MamiFoto package
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202501 | 082144865601 | qwerty123 |
    And owner dismiss active pop-ups
    When owner click Mamifoto button
    When owner click Lihat Paket button
    And owner select package mamifoto
    Then owner see pop up doesnt have property








