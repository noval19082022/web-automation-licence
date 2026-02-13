@LIMO7 @voucher

Feature: Voucher Saya Page

  @continue @TEST_SS-4153 @TEST_SS-4155
  Scenario: Voucher List Display and Scrolling
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0819090909 | 0819090909 | qwerty123 |
    And tenant navigates to voucher saya page
    Then user see voucher list header
    And user see "Tersedia" tab on voucher saya page
    And user see "Terpakai" tab on voucher saya page
    And user see "Kedaluwarsa" tab on voucher saya page
    And user see Promo Lainnya
    And  user see voucher card
    And user see voucher list image
    And user see voucher list Expired Date
    And user see voucher list Kode Voucher label
    And user see voucher list Voucher code
    And user see voucher list Salin button
    When user click "Terpakai" tab on voucher saya page
    And user see voucher list Terpakai label
    And user see voucher list disabled Kode Voucher label
    And user see voucher list disabled Voucher code
    When user click "Kedaluwarsa" tab on voucher saya page
    Then user see voucher list Kedaluwarsa label
    And user see voucher list disabled Kode Voucher label on kadaluwarsa page
    And user see voucher list disabled Voucher code on kadaluwarsa page

  @TEST_SS-4154
  Scenario: Voucher Detail Display, Scrolling, and Salin Button Functionality
    When tenant navigates to voucher saya page
    And user click Salin button from voucher list
    Then user see kode berhasil disalin toast in voucher list
    When user click first voucher on list
    Then user redirected to "/user/voucherku/detail"
    When user click Salin button from voucher detail
    Then user see kode berhasil disalin toast in voucher detail
    And user see voucher detail Image banner
    And user see voucher detail Campaign Title
    And user see voucher detail Expired Date
    And user see voucher detail Syarat dan Ketentuan label
    And user see voucher detail Syarat dan Ketentuan description
    And user see voucher detail Kode Voucher label
    And user see voucher detail Voucher code
    And user see voucher detail Ticket icon
    When tenant navigates to voucher saya page
    And user click "Terpakai" tab on voucher saya page
    When user clicks Voucher Card in Terpakai tab
    Then user redirected to "/user/voucherku/detail"
    And user see disabled Salin button in voucher detail
    And user see voucher detail Image banner
    And user see voucher detail Campaign Title
    And user see voucher detail Terpakai Label
    And user see voucher detail Syarat dan Ketentuan label
    And user see voucher detail Syarat dan Ketentuan description
    And user see voucher detail disabled Kode Voucher label
    And user see voucher detail disabled Voucher code
    And user see voucher detail Ticket icon
    When tenant navigates to voucher saya page
    And user click "Kedaluwarsa" tab on voucher saya page
    When user clicks Voucher Card in Kedaluwarsa tab
    Then user redirected to "/user/voucherku/detail"
    And user see voucher detail Image banner
    And user see voucher detail Campaign Title
    And user see voucher detail Kedaluwarsa Label
    And user see voucher detail Syarat dan Ketentuan label
    And user see voucher detail Syarat dan Ketentuan description
    And user see voucher detail disabled Kode Voucher label
    And user see voucher detail disabled Voucher code
    And user see voucher detail Ticket icon
    And user logs out as a Tenant user

  @TEST_SS-4155
  Scenario: Empty State Landing Page displayed
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 089767561234 | 089767561234 | mamikosqa123 |
    And tenant navigates to voucher saya page
    When user click "Tersedia" tab on voucher saya page
    Then user see Tersedia Empty State Landing Page
    When user click "Terpakai" tab on voucher saya page
    And user see Terpakai Empty State Landing Page
    When user click "Kedaluwarsa" tab on voucher saya page
    Then user see Kedaluwarsa Empty State Landing Page
