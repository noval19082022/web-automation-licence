@regression @LIMO5 @updatePrice @cektimeouts
Feature: Update Harga

  @TEST_LIMO-909 @continue @updatePrice @WEB @AUTOMATED
  Scenario: [WEB][Update Harga] Access page "Update Harga" from entry point kost list when kost status == Inactive with update price
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408311 | 083176408311 | qwerty123 |
    And owner use direct url access to update kos price:
      | env  | kost id  |
      | stag | /20609677 |
      | prod | /         |
    And user clicks update price button
    Then user see pop up success update price "Harga berhasil diupdate"

  @TEST_LIMO-3461 @continue @updatePrice @WEB @AUTOMATED
  Scenario: User refresh page with out update price
    When user click see other prices
    Then user see daily price is "50000"
    And user see weekly price is "500000"
    And user see monthly price is "1900000"
    And user see three monthly price is "5000000"
    And user see six monthly price is "10000000"
    And user see yearly price is "20000000"
    When owner navigates to property saya kos
    And owner search kost "Automation Kos" on property saya page
    Then user see kos with name "Automation Kos", status "Aktif" and type "Kos Putra"

  @TEST_LIMO-886 @continue @updatePrice @WEB @AUTOMATED
  Scenario: [WEB][Update Harga] Access page "Update Harga" from entry point kost list when kost status == Active with update price
    When user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And user click see other prices
    And user input daily price with "100001"
    And user input weekly price with "700000"
    And user input monthly price with "2800000"
    And user input three monthly price with "7500000"
    And user input six monthly price with "15000000"
    And user input yearly price with "30000000"
    And user clicks update price button
    Then user see pop up success update price "Harga berhasil diupdate"

  @TEST_LIMO-3460 @continue @updatePrice @WEB @AUTOMATED
  Scenario: User refresh page with update price
    Then user see daily price is "100001"
    And user see weekly price is "700000"
    And user see monthly price is "2800000"
    And user see three monthly price is "7500000"
    And user see six monthly price is "15000000"
    And user see yearly price is "30000000"

  @TEST_LIMO-881 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Harga] Access page "Update Harga" from entry point kost list when kost status == Active without update price
    When owner navigates to property saya kos
    And owner search kost "Kost Tester" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And user click see other prices
    And user memorize daily, weekly, monthly, three monthly, six monthly, and yearly price
    And user clicks update price button
    Then user see pop up success update price "Harga berhasil diupdate"
    And user see daily, weekly, monthly, three monthly, six monthly, and yearly price is same with previous price

  @TEST_LIMO-770 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Harga] Owner can't update price when "promo ngebut" active
    When owner navigates to property saya kos
    And owner search kost "Kose Putra Automation" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    Then user see infobar in update price with text "Anda sedang mengikuti promo ngebut, harga tidak dapat diubah sampai promo berakhir"
    And user see monthly price field is disabled
    When user close infobar promo ngebut in update price

  @TEST_LIMO-882 @WEB @AUTOMATED
  Scenario Outline: [WEB][Update Harga] Update Price with Invalid value
    When owner navigates to property saya kos
    And owner search kost "Mamites Kos coba baru" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And user clicks update price button
    And user click see other prices
    And user input monthly price with "<Monthly Price 1>"
    And user input daily price with "<Daily Price 1>"
    And user input weekly price with "<Weekly Price 1>"
    And user input three monthly price with "<Three Monthly Price 1>"
    And user input six monthly price with "<Six Monthly Price 1>"
    And user input yearly price with "<Yearly Price 1>"
    Then user see warning price with:
      | warningMessage                                            |
      | Harga per bulan min. Rp50.000 dan maks. Rp100.000.000.    |
      | Harga per hari min. Rp10.000 dan maks. Rp10.000.000.      |
      | Harga per minggu min. Rp50.000 dan maks. Rp50.000.000.    |
      | Harga per 3 bulan min. Rp100.000 dan maks. Rp100.000.000. |
      | Harga per 6 bulan min. Rp100.000 dan maks. Rp100.000.000. |
      | Harga per tahun min. Rp100.000 dan maks. Rp100.000.000.   |
    And user see button update price disable
    And user input daily price with "<Daily Price 2>"
    And user input weekly price with "<Weekly Price 2>"
    And user input monthly price with "<Monthly Price 2>"
    And user input three monthly price with "<Three Monthly Price 2>"
    And user input six monthly price with "<Six Monthly Price 2>"
    And user input yearly price with "<Yearly Price 2>"
    Then user see warning price with:
      | warningMessage                                            |
      | Harga per bulan min. Rp50.000 dan maks. Rp100.000.000.    |
      | Harga per hari min. Rp10.000 dan maks. Rp10.000.000.      |
      | Harga per minggu min. Rp50.000 dan maks. Rp50.000.000.    |
      | Harga per 3 bulan min. Rp100.000 dan maks. Rp100.000.000. |
      | Harga per 6 bulan min. Rp100.000 dan maks. Rp100.000.000. |
      | Harga per tahun min. Rp100.000 dan maks. Rp100.000.000.   |
    And user see button update price disable
    And user input daily price with "<Daily Price 3>"
    And user input weekly price with "<Weekly Price 3>"
    And user input monthly price with "<Monthly Price 3>"
    And user input three monthly price with "<Three Monthly Price 3>"
    And user input six monthly price with "<Six Monthly Price 3>"
    And user input yearly price with "<Yearly Price 3>"
    Then user see warning price with:
      | warningMessage                                            |
      | Harga per bulan min. Rp50.000 dan maks. Rp100.000.000.    |
      | Harga per hari min. Rp10.000 dan maks. Rp10.000.000.      |
      | Harga per minggu min. Rp50.000 dan maks. Rp50.000.000.    |
      | Harga per 3 bulan min. Rp100.000 dan maks. Rp100.000.000. |
      | Harga per 6 bulan min. Rp100.000 dan maks. Rp100.000.000. |
      | Harga per tahun min. Rp100.000 dan maks. Rp100.000.000.   |
    And user see button update price disable
    Examples:
      | Daily Price 1 | Weekly Price 1 | Monthly Price 1 | Three Monthly Price 1 | Six Monthly Price 1 | Yearly Price 1 | Daily Price 2 | Weekly Price 2 | Monthly Price 2 | Three Monthly Price 2 | Six Monthly Price 2 | Yearly Price 2 | Daily Price 3 | Weekly Price 3 | Monthly Price 3 | Three Monthly Price 3 | Six Monthly Price 3 | Yearly Price 3 |
      | 0             | 0              | 0               | 0                     | 0                   | 0              | 9999          | 49999          | 49999           | 99999                 | 99999               | 99999          | 10000001      | 50000001       | 100000001       | 100000001             | 100000001           | 100000001      |

  @TEST_LIMO-776 @WEB @AUTOMATED
  Scenario Outline: [WEB][Update Harga] Update price kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408311 | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kost Tester" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And user clicks update price button
    And user click see other prices
    And user input monthly price with "<Monthly Price>"
    And user input daily price with "<Daily Price>"
    And user input weekly price with "<Weekly Price>"
    And user input three monthly price with "<Three Monthly Price>"
    And user input six monthly price with "<Six Monthly Price>"
    And user input yearly price with "<Yearly Price>"
    And user clicks update price button
    Then user see pop up success update price "Harga berhasil diupdate"
    And user see daily price is "<Daily Price>"
    And user see weekly price is "<Weekly Price>"
    And user see monthly price is "<Monthly Price>"
    And user see three monthly price is "<Three Monthly Price>"
    And user see six monthly price is "<Six Monthly Price>"
    And user see yearly price is "<Yearly Price>"
    Examples:
      | Daily Price | Weekly Price | Monthly Price | Three Monthly Price | Six Monthly Price | Yearly Price |
      | 1000000     | 1500000      | 2500000       | 3000000             | 3500000           | 4000000      |
      | 150000      | 500000       | 3000000       | 9000000             | 18000000          | 36000000     |