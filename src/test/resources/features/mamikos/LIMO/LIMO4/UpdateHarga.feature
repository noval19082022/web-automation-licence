@regression @LIMO41 @EX-LG
Feature: Update Harga

  @TEST_LIMO-2798 @continue
  Scenario: [WEB][Update Harga] Access page "Update Harga" from entry point kost list when kost status == Inactive with update price
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password    |
      | 083176408311   | 083176408311   | qwerty123   |
    And owner click "Nanti Saja"
    And owner navigates to property saya kos
    And owner search kost "Mamites Kos coba baru" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And user clicks update price button
    Then user see pop up success update price "Harga berhasil diupdate"

  @continue
  Scenario: user refresh page with out update price
    Then user see daily price is 50000
    And user see weekly price is 500000
    And user see monthly price is 1900000
    And user see three monthly price is 5000000
    And user see six monthly price is 10000000
    And user see yearly price is 20000000
    When owner navigates to property saya kos
    And owner search kost "Automation Kos" on property saya page
    Then user see kos with name "Automation Kos", status "Aktif" and type "Kos Putra"

  @TEST_LIMO-2895 @continue
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

  @continue
  Scenario: user refresh page with update price
    Then user see daily price is 100001
    And user see weekly price is 700000
    And user see monthly price is 2800000
    And user see three monthly price is 7500000
    And user see six monthly price is 15000000
    And user see yearly price is 30000000

  @TEST_LIMO-2905 @continue
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

  @TEST_LIMO-2734 @continue
  Scenario: [WEB][Update Harga] Owner can't update price when "promo ngebut" active
    When owner navigates to property saya kos
    And owner search kost "Kose Putra Automation" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    Then user see infobar in update price with text "Anda sedang mengikuti promo ngebut, harga tidak dapat diubah sampai promo berakhir"
    And user see monthly price field is disabled
    When user close infobar promo ngebut in update price