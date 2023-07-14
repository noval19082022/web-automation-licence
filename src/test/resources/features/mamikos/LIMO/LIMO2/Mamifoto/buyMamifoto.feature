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








