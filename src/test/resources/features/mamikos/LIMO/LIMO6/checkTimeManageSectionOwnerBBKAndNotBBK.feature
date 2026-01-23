    ## this TC should be disable/take out due to revamp on owner dashboard
Feature: Time manage owner

  @checkContentOnWaktuMengelolaKos @TEST_SS-3466
  Scenario: Check Waktu Mengelola section when owner have one kost not Bbk
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod  | password   |
      | 089604239090 | 08100000622 | widyarini1 |
    And owner navigates to owner dashboard
    And owner dismiss FTUE goldplus
    And user click "Atur Ketersediaan Kamar"
    And owner back to owner dashboard
    And owner dismiss FTUE goldplus
    And user click "Atur Harga"
    And owner back to owner dashboard
    And owner dismiss FTUE goldplus
    And owner waiting the page reload
    And user click "Daftar kontrak penyewa kos"
    And owner back to owner dashboard
    And owner dismiss FTUE goldplus
    And user click "Tambah Penyewa"
    And owner click back previous button
    And owner dismiss FTUE goldplus
    And owner waiting the page reload
    And user click "Pusat Bantuan"
    Then user can see help center page

  @checkOwnerHaveOneKosNotBbk @TEST_SS-3472
  Scenario: Check Waktu Mengelola section when owner have one kost not Bbk
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081227019399 | 081227019399 | qwerty123 |
    And owner navigates to owner dashboard
    And user click "Atur Ketersediaan Kamar"

  @checkWaktuMengelolaWhenOwnerNotHaveBbkKos @TEST_SS-3469
  #ownerNotHaveBbkKos.feature
  Scenario: Check Waktu Mengelola section when owner not have BBK kos (BBM-973)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081227019399 | qwerty123 |
    And owner navigates to owner dashboard
    And user click menu "Atur Ketersediaan Kamar" on feature waktunya mengelola property
    Then user see screen "Update Kamar"
    When owner back to owner dashboard
    And user click menu "Atur Harga" on feature waktunya mengelola property
    Then user see screen "Update Harga"
    When owner back to owner dashboard
    And user click menu "Daftar ke Booking Langsung" on feature waktunya mengelola property
    Then user can see manage booking pop up
    When owner back to owner dashboard
    And user click menu Penyewa on feature waktunya mengelola property
    Then verify the title on mamipay owner onboarding displayed
    When user clicks on Owner Settings button
    And owner back to owner dashboard
    And user click menu "Tambah Penyewa" on feature waktunya mengelola property
    Then verify the title on mamipay owner onboarding displayed
    When user clicks on Owner Settings button
    And owner back to owner dashboard
    And user click menu Pusat Bantuan on feature waktunya mengelola property
    Then user should redirect to link "https://help-waras.kerupux.com/pemilik"