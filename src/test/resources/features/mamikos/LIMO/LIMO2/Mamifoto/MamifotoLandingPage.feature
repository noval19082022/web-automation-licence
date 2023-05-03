@LIMO2 @Mamifoto

Feature: Check Mamifoto Landing Page

  @TEST_LIMO-3020 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner visits Landing Page of MamiFoto
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 082233545506 | 082144865600 | qwerty123 |

    #Scenario Owner visits Landing Page of MamiFoto from Fitur Promosi Sidebar
    When owner click menu sidebar Mamifoto
    Then owner can see mamifoto page

    #Scenario Owner visits Landing Page of MamiFoto from Info Untuk Anda Card
    When owner back to owner dashboard
    Then owner click info untuk anda for mamifoto
    And owner can see mamifoto page

    #Scenario Owner visits Landing Page of MamiFoto from Tingkatkan Kinerja Kos Section
    When owner back to owner dashboard
    Then owner click section Tingkatkan Kinerja Kost
    And owner can see mamifoto page

    #Scenario Owner click "lihat paket" button MamiFoto
    When owner click Lihat Paket button
    Then owner see pilih paket page

    #Scenario Owner click "Baca Panduan" button MamiFoto
    When owner back to Mamifoto Landing Page
    And owner click Baca Panduan button
    Then owner see detail panduan pop up

    #Scenario Owner click FAQ
    When owner click any faq button
    Then owner see detail FAQ
