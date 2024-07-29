@regression @LIMO4 @mamitour
Feature: Purchase Mamitour

  @TEST_LIMO-1125 @purchasemamitour @WEB @AUTOMATED @MAMITOUR
  Scenario: [Web][Mamitour] Purchase Mamitour if doesn't property active
    Given user go to mamikos homepage
    When user login as owner:
    | phone stag    | phone prod    | password  |
    | 0895365623388 | 0895365623388 | qwerty123 |
    And user navigate to mamitour landing page
    And user click on pesan sekarang button
    Then user will see text title with "Belum Ada Properti Aktif" and subtitle with "Tambahkan kos/apartemen terlebih dahulu untuk bisa memesan MamiTour."

  @TEST_LIMO-1126 @purchasemamitour @continue @WEB @AUTOMATED @MAMITOUR
  Scenario: [Web][Mamitour] Purchase Mamitour from Pesan Sekarang button
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 087133998156 | 0             | qwerty123 |
    And user navigate to mamitour landing page
    And user wants to buy mamitour "Paket 3 Bulan"
    Then user will see pesanan diterima popup

  @TEST_LIMO-3696 @continue @WEB @AUTOMATED @MAMITOUR
  Scenario: Check Panduan Mamitour Popup
    When user click on baca panduan button
    Then user will see also close panduan mamitour popup
    And owner should successfully log out

  @TEST_LIMO-3695 @WEB @AUTOMATED @MAMITOUR
  Scenario: Mark As Paid Mamitour from Bangkerupux
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And admin paid all unpaid transaction for "087133998156"
    Then admin verify all unpaid invoice already paid

  @TEST_LIMO-1115 @purchasemamitour @continue @WEB @AUTOMATED @MAMITOUR
  Scenario: [Web][Mamitour] Purchase Multiple Mamitour from Pesan Sekarang button
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 087133998156 | 0             | qwerty123 |
    And user navigate to mamitour landing page
    #first purchase
    And user wants to buy mamitour "Paket 6 Bulan"
    Then user will see also close pesanan diterima popup
    #second purchase
    And user wants to buy mamitour "Paket 12 Bulan"
    Then user will see also close pesanan diterima popup
    And owner should successfully log out

  @TEST_LIMO-3695 @purchasemamitour @WEB @AUTOMATED @MAMITOUR
  Scenario: Mark As Paid Mamitour from Bangkerupux
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And admin paid all unpaid transaction for "087133998156"
    Then admin verify all unpaid invoice already paid

  @TEST_LIMO-3697 @purchasemamitour @continue @WEB @AUTOMATED @MAMITOUR
  Scenario: [Web][Mamitour] Purchase Mamitour Package from Mamitour Landing Page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 087133998156 | 0             | qwerty123 |
    And user navigate to mamitour landing page
    And user want to buy Paket 3 Bulan from mamitour landing page
    Then user will see also close pesanan diterima popup
    And owner should successfully log out

  @TEST_LIMO-3695 @purchasemamitour @WEB @AUTOMATED @MAMITOUR
  Scenario: Mark As Paid Mamitour from Bangkerupux
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And admin paid all unpaid transaction for "087133998156"
    Then admin verify all unpaid invoice already paid
    And mamikos bangkrupux admin should be successfully logged out