@LIMO2
Feature: Owner GPSP

  Background: reset gp owner
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number
      | 0898761238 |
      | 0898761239 |

  @TEST_LIMO-1654
  Scenario: [Improve GPSP][Multiple Invoice] Owner Non GP already have invoice unpaid, different day already assign new segment, then owner select package GP
  #check if the whitelist has not detele
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin accsess menu whitelist feature
    And admin search whitelist owner by user_id "99454617"
    Then admin click on delete btn on whitelist menu for order "1"
    And admin try to logout from mamikos

   #Buy Goldplus
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761238 | 0          | qwerty123 |
    And owner navigates to owner dashboard
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And tenant make bill payments using "ovo"
    Then owner see billing details invoice
      | GoldPlus 1 (reg#1m) periode 1 Bulan |
      | Rp79.000                  |
      | Total Pembayaran Rp82.500 |
    And owner navigates to owner dashboard
    Then owner will see that the text "Menunggu Pembayaran" is displayed
    And owner try to logout from mamikos

    # login admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin accsess menu whitelist feature
    And admin wants to add whitelist feature
    And admin input owner id with "99454617"
    And admin select feature with "gp_special_pricing_medium_5"
    And admin click submit button
    Then admin will see that the text "Success! User `99454617` successfully whitelisted for feature `gp_special_pricing_medium_5`" is displayed
    And admin try to logout from mamikos

    #login owner
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761238 | 0          | qwerty123 |
    And user navigates to owner dashboard
    And user click widget GP "Menunggu Pembayaran"
    And user click "Ganti Paket" on pop up "Anda masih memiliki tagihan aktif"
    And user wants to subscribe Goldplus 2
    And owner navigates to "/goldplus/payment"
    Then verify unpaid invoice more than 1
    When user click Lihat Tagihan on riwayat
    Then owner see billing details invoice
      | GoldPlus 2 |
      | GP2        |
    And owner try to logout from mamikos

    # deleted assignment from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin accsess menu whitelist feature
    And admin search whitelist owner by user_id "99454617"
    Then admin click on delete btn on whitelist menu for order "1"
    Then admin will see that the text "Success! User id `99454617` in feature `gp_special_pricing_medium_5` has been deleted" is displayed

  @TEST_LIMO-1641
  Scenario: [Improve GPSP][Upgrade GP] Owner GP 1 wants to upgrade GP with new special price, but removed from assign special price
    # login admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin accsess menu whitelist feature
    And admin wants to add whitelist feature
    And admin input owner id with "99454618"
    And admin select feature with "gp_special_pricing_medium_5"
    And admin click submit button
    And admin try to logout from mamikos

    # login owner 0898761239 (99454618)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761239 | 0          | qwerty123 |
    And owner navigates to owner dashboard
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner select payment using alfamart xendit as payment method from invoice detail
    Then owner will see that the text "Pembayaran Berhasil" is displayed
    Then owner see billing details invoice
      | GP High Segment periode 1 Bulan |
      | Rp130.000                       |
      | Total Pembayaran Rp133.500      |
    And owner navigates to owner dashboard
    Then owner will see that the text "GoldPlus 1" is displayed
    And owner try to logout from mamikos

    # deleted assignment from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin accsess menu whitelist feature
    And admin search whitelist owner by user_id "99454618"
    Then admin click on delete btn on whitelist menu for order "1"
    Then admin will see that the text "Success! User id `99454618` in feature `gp_special_pricing_medium_5` has been deleted" is displayed
    And admin try to logout from mamikos

#    #upgrade GP (visit tbc tenant)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761239 | 0          | qwerty123 |
    And owner navigates to owner dashboard
    And user click chat button in top bar owner home page
    And owner open TBC Lihat Profil at chatroom "Desta Tenant D"
    And owner GP-1 upgrade paket to GP-2 from TBC detail page
    Then payment owner success using ovo as payment method
    Then owner will see that the text "Pembayaran Berhasil" is displayed
    Then owner see billing details invoice
      | Potongan sisa GoldPlus 1  |
      | -Rp125.666                |
      | Total Pembayaran Rp22.834 |
    And owner navigates to owner dashboard
    Then owner will see that the text "GoldPlus 2" is displayed