@regression @loginTenant @SS14 @essentialTest @LOGIN_SEARCH_MIGRATE
Feature: Tenant - Login

  @loginByFB @TEST_SS-2977
  Scenario: [Login Tenant] By Facebook
    Given user go to mamikos homepage
    And user login as tenant via facebook:
      | email stag          | email prod          | password           |
      | ncihuciha@gmail.com | ncihuciha@gmail.com | mamikosJAYAJAYA999 |
    Then user tenant profile picture is shown

  @TEST_SS-3052 @Automated @web-covered @noFillPassword
  Scenario: [Login Tenant] No fill password
    Given user go to mamikos homepage
    When user clicks on Enter button as tenant delete password fill
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    Then user verify login error messages "Password harus diisi."

  @TEST_SS-3053 @Automated @web-covered @wrongNumber
  Scenario: [Login Tenant] Wrong number
    Given user go to mamikos homepage
    When user clicks on Enter button as tenant delete phone number fill
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    Then user verify login error messages "Nomor Handphone harus diisi."

  @fromSBMPTNPage @TEST_SS-3054
  Scenario: [Login Tenant] From SBMPTN Page
    Given user navigate to SBMPTN page
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    Then user tenant profile picture is shown

  @TEST_SS-3055 @Automated @web-covered @loginTenantWithNewPassword
  Scenario: [Login Tenant] Login with new password
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

#  @popUpClose @TEST_COOP-5356 @Automated @web-covered
#  Scenario: Pop up login - Pop up close
#    Given user go to mamikos homepage
#    When user masuk sebagai
#    Then user verify pop up "Masuk ke Mamikos" "Saya ingin masuk sebagai"

  @TEST_SS-3056 @TESTSET_UG-6221 @TESTSET_PF-1792 @Automated @web-covered
  Scenario: [Web][Login][Pop Up Login] Pop up Close
    Given user go to mamikos homepage
    When user masuk sebagai
    And user click close on pop up login
    Then user verify pop up "Masuk ke Mamikos" "Saya ingin masuk sebagai" are not appeared

  @fromListingDetailPageClickFavorite @TEST_SS-3057
  Scenario: Pop up login - Click Favorite
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-a-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user can favorite kost not login
    Then user see login pop up in favorite page

  @fromListingDetailPageClickMaps @TEST_SS-3058
  Scenario: Pop up login - Click Maps
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user want to reached map section and see lihat peta button
    When user want to see more detail kost location
    Then user see login pop up in favorite page

  @TEST_SS-3049
  Scenario: [Setelan Akun][Profile Picture]Login - Profile Picture is null
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089513193288 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    Then user tenant verify profil picture is null

  @TEST_SS-5153
  Scenario: [Setelan Akun][Profile Picture]Login Tenant - Profile Picture is show
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password  |
      | 0879864312548 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    Then user tenant profile picture is shown

  @TEST_SS-3051
  Scenario: [Login Tenant] using Wrong phone number alfabet
    Given user go to mamikos homepage
    When user login with alfabet phone number
      | phone stag | phone prod  | password  |
      | aaaaaaaaaa | aaaaaaaaaaa | qwerty123 |
    Then user verify login error messages "Format Nomor Handphone salah."

  @TEST_SS-3059
  Scenario: [Login Tenant] login in landing page
    Given user go to mamikos homepage
    When user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    And user login as tenant via phone number:
      | phone stag    | phone prod  | password  |
      | 0879864312548 | 08100000622 | qwerty123 |
    Then user tenant profile picture is shown

  @TEST_SS-3060
  Scenario: [Login Tenant] - tenant login by click lihat fasilitas kamar
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod                                      |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-g-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user want to see more detail room facility section on the kost detail page
    And user login from kost detail via phone number:
      | phone stag    | phone prod  | password  |
      | 0879864312548 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    Then user tenant profile picture is shown

  @TEST_SS-3061
  Scenario: [Login Tenant] - tenant login by click lihat fasilitas umum
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                               | kost path prod                                                             |
      | kost-kabupaten-halmahera-utara-kost-campur-murah-kost-komplit-desta-tobelo-halmahera-utara-1 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    And user want to see more detail facility umum
    And user login from kost detail via phone number:
      | phone stag    | phone prod  | password  |
      | 0879864312548 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    Then user tenant profile picture is shown

  @TEST_SS-3062
  Scenario: [Login Tenant] - tenant login with facebook in landing page
    Given user go to mamikos homepage
    When user search keyword:
      | search stag | search prod |
      | UGM         | UGM         |
    And user login as tenant via facebook:
      | email stag          | email prod          | password           |
      | ncihuciha@gmail.com | ncihuciha@gmail.com | mamikosJAYAJAYA999 |
    And user navigate to kost saya page
    Then user tenant profile picture is shown

  @TEST_SS-3063
  Scenario: [Login Tenant] - tenant login with facebook in detail kos
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    And user login as tenant via facebook:
      | email stag          | email prod          | password           |
      | ncihuciha@gmail.com | ncihuciha@gmail.com | mamikosJAYAJAYA999 |
    And user navigate to kost saya page
    Then user tenant profile picture is shown

  @TEST_SS-4288
  Scenario: Login Tenant - From Popular Area Page
    Given user navigate to popular area page
    When user login as tenant via phone number in popular area page
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    Then user tenant profile picture is shown

  @TEST_SS-4289
  Scenario: Login Tenant - From Near Campus Page
    Given user navigate to near campus page
    When user login as tenant via phone number in popular area page
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    Then user tenant profile picture is shown

  @TEST_SS-4292
  Scenario: Login Facebook Tenant - From Popular Area Page
    Given user navigate to popular area page
    When user login as tenant via facebook from popular area page:
      | email stag          | email prod          | password           |
      | ncihuciha@gmail.com | ncihuciha@gmail.com | mamikosJAYAJAYA999 |
    Then user tenant profile picture is shown

  @TEST_SS-4293
  Scenario: Login Facebook Tenant - From Near Campus Page
    Given user navigate to near campus page
    When user login as tenant via facebook from popular area page:
      | email stag          | email prod          | password           |
      | ncihuciha@gmail.com | ncihuciha@gmail.com | mamikosJAYAJAYA999 |
    Then user tenant profile picture is shown