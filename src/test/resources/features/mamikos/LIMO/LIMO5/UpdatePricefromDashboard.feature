@regression @LIMO5
Feature: Update Price from Dashboard

  @TEST_LIMO-907 @WEB @AUTOMATED
  Scenario Outline: [Update Harga][Dashboard]Access page "Update Harga" from entry point dashboard when kost status == Active with update price
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08713399866 | 08713399866 | qwerty123 |
    When owner navigates to property saya kos
    And owner search kost "Kos Fathul Khair Tipe bala bala Jetis Yogyakarta" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And user click kos "Kos Fathul Khair Tipe bala bala Jetis Yogyakarta" in update price list
    And user click see other prices
    When user input daily price with "<Daily Price>"
    And user input weekly price with "<Weekly Price>"
    And user input monthly price with "<Monthly Price>"
    And user input three monthly price with "<Three Monthly Price>"
    And user input six monthly price with "<Six Monthly Price>"
    And user input yearly price with "<Yearly Price>"
    And user click continue input data on pop up
    And user clicks update price button
    Then user see pop up success update price "Harga berhasil diupdate"
    Examples:
      | Daily Price | Weekly Price | Monthly Price | Three Monthly Price | Six Monthly Price | Yearly Price |
      | 1000000     | 1500000      | 2500000       | 3000000             | 3500000           | 4000000      |
      | 150000      | 500000       | 3000000       | 9000000             | 18000000          | 36000000     |