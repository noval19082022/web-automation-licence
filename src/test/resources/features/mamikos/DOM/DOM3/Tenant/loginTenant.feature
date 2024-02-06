@regression @loginTenant @DOM3 @essentialTest
Feature: Tenant - Login

  @loginByFB @TEST_COOP-5363
  Scenario: Login - By Facebook
    Given user go to mamikos homepage
    And user login as tenant via facebook:
      | email stag          | email prod          | password           |
      | ncihuciha@gmail.com | ncihuciha@gmail.com | mamikosJAYAJAYA999 |
    Then user redirected to "/#_=_"
    Then user tenant profile picture is shown

  @TEST_COOP-5352 @TESTSET_UG-4895 @TESTSET_UG-6221 @TESTSET_PF-1393 @TESTSET_PF-1960 @Automated @DOM3 @web-covered @noFillPassword
  Scenario: Login - No fill password
    Given user go to mamikos homepage
    When user clicks on Enter button as tenant delete password fill
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    Then user verify login error messages "Password harus diisi."

  @TEST_COOP-5353 @TESTSET_UG-4895 @TESTSET_UG-6221 @TESTSET_PF-1393 @Automated @DOM3 @web-covered @wrongNumber
  Scenario: Login - Wrong number
    Given user go to mamikos homepage
    When user clicks on Enter button as tenant delete phone number fill
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    Then user verify login error messages "Nomor Handphone harus diisi."

  @fromSBMPTNPage @TEST_COOP-5354
  Scenario: Login - From SBMPTN Page
    Given user navigate to SBMPTN page
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    Then user tenant profile picture is shown

  @TEST_COOP-5355 @TESTSET_UG-4895 @TESTSET_UG-6221 @TESTSET_PF-1393 @TESTSET_PF-1960 @Automated @web-covered @loginTenantWithNewPassword
  Scenario: login tenant with new password
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08917287122 | 08100000622 | qwerty111 |
    And user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "qwerty111"
    And user fills password baru "qwerty123"
    And user fills ketik ulang password "qwerty123"
    And user clicks on simpan password button
    And tenant logs out
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08917287122 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "qwerty123"
    And user fills password baru "qwerty111"
    And user fills ketik ulang password "qwerty111"
    And user clicks on simpan password button
    Then user see successfully changed password "Password berhasil diubah"

  @popUpClose @TEST_COOP-5356 @Automated @DOM3 @web-covered
  Scenario: Pop up login - Pop up close
    Given user go to mamikos homepage
    When user masuk sebagai
    Then user verify pop up "Masuk ke Mamikos" "Saya ingin masuk sebagai"

  @popUpClose @TEST_COOP-5356 @Automated @DOM3 @web-covered
  Scenario: Pop up login - Pop up close
    Given user go to mamikos homepage
    When user masuk sebagai
    And user click close on pop up login
    Then user verify pop up "Masuk ke Mamikos" "Saya ingin masuk sebagai" are not appeared

  @fromListingDetailPageClickFavorite @TEST_COOP-5357
  Scenario: Pop up login - Click Favorite
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | ATDOM12 Kos Dom Automation PLM Tipe A Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user can favorite kost not login
    Then user see login pop up in favorite page

  @fromListingDetailPageClickMaps @TEST_COOP-5358
  Scenario: Pop up login - Click Maps
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe G | Kos DC BAR Automation Tipe G |
    Then user want to reached map section and see lihat peta button
    When user want to see more detail kost location
    Then user see login pop up in favorite page

  @TEST_COOP-4660 @DOM3
  Scenario: [Setelan Akun][Profile Picture]Login - Profile Picture is null
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089513193288 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    Then user tenant verify profil picture is null

  @TEST_COOP-4661 @DOM3
  Scenario: [Setelan Akun][Profile Picture]Login - Profile Picture is show
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password  |
      | 0879864312548 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    Then user tenant profile picture is shown

  @TEST_COOP-4662 @DOM3
  Scenario: Login - using Wrong phone number alfabet
    Given user go to mamikos homepage
    When user login with alfabet phone number
      | phone stag | phone prod  | password  |
      | aaaaaaaaaa | aaaaaaaaaaa | qwerty123 |
    Then user verify login error messages "Format Nomor Handphone salah."