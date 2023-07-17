@LIMO2 @Mamifoto
Feature: Owner Purchase Mamifoto

#Scenario Owner GP purchase MamiFoto package
  @TEST_LIMO-3164 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner GP purchase MamiFoto package
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 087133998156 | 0          | qwerty123 |
    When owner wants to select Mamifoto package
    Then verify discount price on the package list
  #verify at detail tagihan page
    When owner select package mamifoto
    Then verify  discount price on the detail tagihan
  #owner paid Mamifoto
    When owner paid MamiFoto
    Then payment owner success using ovo as payment method

  #Scenario Owner Non GP purchase MamiFoto package
  @TEST_LIMO-3021 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [WEB][MamiFoto] Owner purchase MamiFoto package
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag    | phone prod | password  |
      | 0812345670001 | 0          | qwerty123 |
    When owner wants to select Mamifoto package
    Then verify discount price GP doesnt appear on the package list
  #verify at detail tagihan page
    When owner select package mamifoto
    Then verify  discount price GP doesnt appear the detail tagihan
  #owner paid Mamifoto
    When owner paid MamiFoto Non GP
    Then payment owner success using ovo as payment method

#Scenario Owner purchase multiple invoice MamiFoto package
  @TEST_LIMO-3028 @declarative @listing-monetization @reviewed @Automated @web @playWright
  Scenario: [Web][Mamifoto] Multiple purchase mamifoto
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag    | phone prod | password  |
      | 0812345670001 | 0          | qwerty123 |
    When owner wants to select Mamifoto package
    * owner select package mamifoto
    * owner paid MamiFoto Non GP
    * owner click back previous button
    * owner click riwayat paket button
    Then verify unpaid invoice mamifoto is 1
    And owner back to Mamifoto Landing Page

    #multiple invoice mamifoto
    When owner click button lihat paket
    * owner select package mamifoto
    * owner paid MamiFoto Non GP
    * owner click back previous button
    * owner click riwayat paket button
    Then verify unpaid invoice mamifoto is 2

    #paid first invoice unpaid mamifoto
    When owner paid transaction unpaid
    Then payment owner success using ovo as payment method
    * owner click back previous button
    Then verify unpaid invoice mamifoto is 1
    #paid second invoice unpaid mamifoto
    When owner paid transaction unpaid
    Then payment owner success using ovo as payment method
    * owner click back previous button
    Then verify unpaid invoice mamifoto is 0





    

















