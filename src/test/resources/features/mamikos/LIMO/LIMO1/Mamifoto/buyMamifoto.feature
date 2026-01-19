@LIMO1 @Mamifoto @essentialTest2 @DONEMIGRATINGTONEWBOARD
Feature: Owner Purchase Mamifoto

  @TEST_LIMO-3560 @declarative @listing-monetization @reviewed @Automated @web @playWright
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

  @TEST_LIMO-3561 @continue
  Scenario: [WEB][MamiFoto] Owner Non GP purchase MamiFoto package
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

  @TEST_LIMO-3562
  Scenario: [Web][Mamifoto] Owner purchase multiple invoice MamiFoto package
    #paid invoice unpaid
    When owner navigates to owner dashboard
    And owner click Mamifoto button
    And owner click riwayat paket button
    And owner paid transaction unpaid
    #Owner purchase multiple invoice
    When owner navigates to owner dashboard
    And owner wants to select Mamifoto package
    And owner select package mamifoto
    And owner paid MamiFoto Non GP
    And owner click back previous button
    And owner click riwayat paket button
    Then verify unpaid invoice mamifoto is 1
    And owner back to Mamifoto Landing Page
    #multiple invoice mamifoto
    When owner click button lihat paket
    And owner select package mamifoto
    And owner paid MamiFoto Non GP
    And owner click back previous button
    And owner click riwayat paket button
    Then verify unpaid invoice mamifoto is 2
    #paid first invoice unpaid mamifoto
    When owner paid transaction unpaid
    Then verify unpaid invoice mamifoto is 0