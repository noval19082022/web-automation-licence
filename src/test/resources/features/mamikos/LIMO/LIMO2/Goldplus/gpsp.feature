@LIMO2 @GPSPOWNER
Feature: Owner GPSP

  Background: reset gp owner
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number
      | 0898761238 |
      | 0898761239 |

  Scenario: [Improve GPSP][Multiple Invoice] Check if the whitelist has not detele
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin accsess menu whitelist feature
    And admin search whitelist owner by user_id "99454617"
    Then admin click on delete btn on whitelist menu for order "1"

  @TEST_LIMO-1654
  Scenario: [Improve GPSP][Multiple Invoice] Owner Non GP already have invoice unpaid, different day already assign new segment, then owner select package GP
   #Buy Goldplus
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761238 | 0          | qwerty123 |
    And owner navigates to owner dashboard
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    Then owner see billing details invoice
      | GoldPlus 1 (3 Bulan)       |
      | Rp232.260                  |
      | Total Pembayaran Rp235.760 |
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
    And user wants to subscribe Goldplus 1
    And payment owner success using ovo as payment method
    Then owner see billing details invoice
      | GoldPlus 1 (2 Bulan)            |
      | Rp244.400                       |
      | Total Pembayaran Rp247.900      |
    And owner navigates to owner dashboard
    And owner click close icon pop up
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
    # cleanup existing whitelist entry if exists
    And admin search whitelist owner by user_id "99454618"
    And admin click on delete btn on whitelist menu for order "1"
    # add whitelist
    And admin wants to add whitelist feature
    And admin input owner id with "99454618"
    And admin select feature with "gp_special_pricing_medium_5"
    And admin click submit button
    Then admin will see that the text "Success! User `99454618` successfully whitelisted for feature `gp_special_pricing_medium_5`" is displayed
    And admin try to logout from mamikos

#Duplicate feature
#    # login owner 0898761239 (99454618)
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag | phone prod | password  |
#      | 0898761239 | 0          | qwerty123 |
#    And owner navigates to owner dashboard
#    And owner waiting the page reload
#    And user click daftar GP button
#    And user wants to subscribe Goldplus 1
#    And owner select payment using alfamart xendit as payment method from invoice detail
#    Then owner will see that the text "Pembayaran Berhasil" is displayed
#    Then owner see billing details invoice
#      | GP High Segment periode 1 Bulan |
#      | Rp130.000                       |
#      | Total Pembayaran Rp133.500      |
#    And owner navigates to owner dashboard
#    Then owner will see GoldPlus logo image "logo-goldplus-gradient-1.webp"
#    And owner try to logout from mamikos
#
#    # deleted assignment from admin
#    Given admin go to mamikos bangkrupux admin
#    When admin login to bangkrupux:
#      | email stag                 | email prod                 | password  |
#      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin accsess menu whitelist feature
#    And admin search whitelist owner by user_id "99454618"
#    Then admin click on delete btn on whitelist menu for order "1"
#    Then admin will see that the text "Success! User id `99454618` in feature `gp_special_pricing_medium_5` has been deleted" is displayed
#    And admin try to logout from mamikos
#
##    #upgrade GP (visit tbc tenant)
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag | phone prod | password  |
#      | 0898761239 | 0          | qwerty123 |
#    And owner navigates to owner dashboard
#    And user click chat button in top bar owner home page
#    And owner open TBC Lihat Profil at chatroom "Desta Tenant D"
#    And owner GP-1 upgrade paket to GP-2 from TBC detail page
#    Then payment owner success using ovo as payment method
#    Then owner will see that the text "Pembayaran Berhasil" is displayed
#    Then owner see billing details invoice
#      | Potongan sisa GoldPlus 1  |
#      | -Rp125.666                |
#      | Total Pembayaran Rp22.834 |
#    And owner navigates to owner dashboard
#    Then owner will see that the text "GoldPlus 2" is displayed
#
#  @TEST_LIMO-1640 @TEST_LIMO-1639
#  Scenario: [Improve GPSP][Upgrade GP] Owner GP 1 wants to upgrade GP with new/old special price
#    #login admin
#    Given admin go to mamikos bangkrupux admin
#    When admin login to bangkrupux:
#      | email stag                 | email prod                 | password  |
#      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin accsess menu whitelist feature
#    And admin wants to add whitelist feature
#    And admin input owner id with "99454618"
#    And admin select feature with "gp_special_pricing_medium_5"
#    And admin click submit button
#    Then admin will see that the text "successfully whitelisted for feature `gp_special_pricing_medium_5" is displayed
#    And admin try to logout from mamikos
#
#    #login owner
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag | phone prod | password  |
#      | 0898761239 | 0          | qwerty123 |
#    And owner navigates to owner dashboard
#    And owner waiting the page reload
#    And user click daftar GP button
#    And user wants to subscribe Goldplus 1
#    And owner select payment using alfamart xendit as payment method from invoice detail
#    Then owner will see that the text "Pembayaran Berhasil" is displayed
#    Then owner see billing details invoice
#      | GP High Segment periode 1 Bulan |
#      | Rp130.000                       |
#      | Total Pembayaran Rp133.500      |
#    And owner navigates to owner dashboard
#    Then owner will see GoldPlus logo image "logo-goldplus-gradient-1.webp"
#    And owner try to logout from mamikos
#
#    #upgrade GP
#    When owner navigates to owner dashboard
#    And user click chat button in top bar owner home page
#    And owner open TBC Lihat Profil at chatroom "Desta Tenant D"
#    And owner GP-1 upgrade paket to GP-2 from TBC detail page
#    Then payment owner success using ovo as payment method
#    Then owner will see that the text "Pembayaran Berhasil" is displayed
#    Then owner see billing details invoice
#      | Potongan sisa GoldPlus 1 |
#      | -Rp125.806               |
#      | Total Pembayaran Rp7.694 |
#    And owner navigates to owner dashboard
#    Then owner will see that the text "GoldPlus 2" is displayed
#    And admin try to logout from mamikos
#
#    # deleted assignment from admin
#    Given admin go to mamikos bangkrupux admin
#    When admin login to bangkrupux:
#      | email stag                 | email prod                 | password  |
#      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin accsess menu whitelist feature
#    And admin search whitelist owner by user_id "99454618"
#    Then admin click on delete btn on whitelist menu for order "1"
#    Then admin will see that the text "feature `gp_special_pricing_medium_5` has been deleted" is displayed

  @TEST_LIMO-1638
  Scenario: [Improve GPSP][Recurring GP] When owner already GP with new special price, before recurring admin deleted assigment
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

    # login owner
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761239 | 0          | qwerty123 |
    And owner navigates to owner dashboard
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    Then payment owner success using ovo as payment method
    Then owner will see that the text "Pembayaran Berhasil" is displayed
    Then owner see billing details invoice
      | GoldPlus 1 (2 Bulan) |
      | Rp244.400                       |
      | Total Pembayaran Rp247.900      |
    And owner navigates to owner dashboard
    Then owner will see GoldPlus logo image "logo-goldplus-gradient-1.webp"
    And owner try to logout from mamikos

    # deleted assignment from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin accsess menu whitelist feature
    And admin search whitelist owner by user_id "99454618"
    Then admin click on delete btn on whitelist menu for order "1"
    Then admin will see that the text "feature `gp_special_pricing_medium_5` has been deleted" is displayed

    # admin send recurring after delete gp premium
    ##recurring GP H-7
    And admin mamipay wants to create gold plus recurring for phone number
      | day | phone_number |
      | H7  | 0898761239   |
    Then admin will see that the text "The Order cannot be recurred!" is displayed

    ##recurring GP H-3 (cause H-3 ,scheduler running for recurring weekly)
    And admin mamipay wants to create gold plus recurring for phone number
      | day | phone_number |
      | H3  | 0898761239   |
    Then admin will see that the text "The Order cannot be recurred!" is displayed

  @TEST_LIMO-1637
  Scenario: [Improve GPSP][Recurring GP] When owner already GP with new special price, then get invoice recurring with new special price
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

    # login owner
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761239 | 0          | qwerty123 |
    And owner navigates to owner dashboard
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    Then payment owner success using ovo as payment method
    Then owner will see that the text "Pembayaran Berhasil" is displayed
    Then owner see billing details invoice
      | GoldPlus 1 (2 Bulan) |
      | Rp244.400                       |
      | Total Pembayaran Rp247.900      |
    And owner navigates to owner dashboard
    Then owner will see GoldPlus logo image "logo-goldplus-gradient-1.webp"
    And owner try to logout from mamikos

    #recurring owner
    And admin mamipay wants to create gold plus recurring for phone number
      | day | phone_number |
      | H7  | 0898761239   |

#    When owner already recurring
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761239 | 0          | qwerty123 |
    Then owner will see that the text is displayed
      | Masa aktif GoldPlus akan habis.                      |
      | Ayo, segera perpanjang paket GoldPlus Anda sekarang. |
    And owner wants to paid invoice recurring from recurring pop up
    Then owner see billing details invoice
      | GoldPlus 1 (2 Bulan)  |
      | Rp247.900                  |
      | Total Pembayaran Rp247.900 |
    And payment owner success using ovo as payment method
    And owner navigates to owner dashboard
    Then owner will see GoldPlus logo image "logo-goldplus-gradient-1.webp"

  @TEST_LIMO-1636
  Scenario: [Improve GPSP][Activation GP] When owner already have unpaid invoice GP with new special price, then deleted from assign new special price
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

   #login owner
   #Buy Goldplus
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761239 | 0          | qwerty123 |
    And owner navigates to owner dashboard
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    Then owner see billing details invoice
      | GoldPlus 1 (2 Bulan) |
      | Rp247.900                   |
      | Total Pembayaran Rp247.900  |
    And owner navigates to owner dashboard
    Then owner will see that the text "Menunggu Pembayaran" is displayed
    And owner try to logout from mamikos

    #deleted assign from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin accsess menu whitelist feature
    And admin search whitelist owner by user_id "99454618"
    Then admin click on delete btn on whitelist menu for order "1"
    Then admin will see that the text "feature `gp_special_pricing_medium_5` has been deleted" is displayed
    And owner try to logout from mamikos

    #cek invoice
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0898761239 | 0          | qwerty123 |
    And owner navigates to owner dashboard
    And user click widget GP "Menunggu Pembayaran"
    And user click "Lihat Tagihan" on pop up "Anda masih memiliki tagihan aktif"
    And payment owner success using ovo as payment method
    Then owner see billing details invoice
      | GoldPlus 1 (2 Bulan) |
      | Rp247.900                   |
      | Total Pembayaran Rp247.900  |
    And owner navigates to owner dashboard
    Then owner will see GoldPlus logo image "logo-goldplus-gradient-1.webp"