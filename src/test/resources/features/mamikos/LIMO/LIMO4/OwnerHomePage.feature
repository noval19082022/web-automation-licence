@regression @LIMO4 @LIMO-Homepage-owner @flaky
Feature: Owner Homepage

  @TEST_LIMO-3445 @navbarAfter @continue @WEB @AUTOMATED
  Scenario: Positive case Check Navbar login as owner
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408311 | 083132824758 | qwerty123 |
    Then check the header menu display on homepage owner
    And user see username in top right shows as "abcdefghijklmnopqrst"

  @TEST_LIMO-3453 @redirectionElementNavbar @continue @WEB @AUTOMATED
  Scenario: Redirection element header after login
    When user click mamikos.com logo
    And user click booking kos button
    Then user should redirect to link "https://jambu.kerupux.com/booking"
    When user click back button in page
    And user click promosi iklan anda button
    Then user should redirect to link "https://jambu.kerupux.com/mamiads"
    When user click back button in page
    And user clicks pusat bantuan on nav bar owner
    Then user should redirect to link "https://help.mamikos.com/pemilik"

  @TEST_LIMO-3451 @ownerPage @listingGP @continue @WEB @AUTOMATED
  Scenario: Click "halaman pemilik" will redirect to Owner page
    When user navigates to owner dashboard
    And user click mamikos.com logo
    And user click profile on header
    Then user see dropdown with button owner page and exit
    When  user click owner page button
    Then user should redirect to link "https://owner-jambu.kerupux.com/"

  @TEST_LIMO-3456 @ownerChatCS @listingGP @continue @WEB @AUTOMATED
  Scenario: Click "Chat CS" should open Contact Us Pop Up
    When owner navigates to property saya kos
    And user click Chat CS button
    Then user see Contact us pop up is appear

  @TEST_LIMO-3446 @ownerSubMenu @continue @WEB @AUTOMATED
  Scenario: Sub menu on owner page redirect to the right page
    When owner navigates to property saya kos
    Then user should redirect to link "https://jambu.kerupux.com/ownerpage/kos"
    When owner navigates to property saya apartemen
    Then user should redirect to link "https://jambu.kerupux.com/ownerpage/apartment"

#  @TEST_LIMO-3443 @OwnerGreeting @listingGP @continue @WEB @AUTOMATED
#  Scenario: Click username direct to setelan akun
#    When user navigates to owner dashboard
#    Then user see user's name "Halo, abcdefghijklmnopqrst" in owner dashboard
#    When user click username in owner dashboard
#    Then user redirected to "/ownerpage/settings"

  @TEST_LIMO-3454 @OwnerProfileHeader @listingGP @WEB @AUTOMATED
  Scenario: Click profile name in top right will open dropdown menu
    When user navigates to owner dashboard
    And user click owner username on header
    Then user see owner's name & phone number, text link "Setelan Akun" & "Logout"

  @TEST_LIMO-3444 @OwnerDoesntHaveKost @listingGP @WEB @AUTOMATED
  Scenario: Check Add Kost button when owner doesn't have kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0876623622 | 0876623622 | qwerty123 |
    Then user will see that the text "Pasang Iklan Pertama" is displayed

  @TEST_LIMO-3452 @OwnerNameMoreThan30 @listingGP @WEB @AUTOMATED
  Scenario: If profile name more than 30 char show ellipsis
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 082233545506 | 0812345670008 | qwerty123 |
    Then user see username in top right shows as "Rega Automate Dua Nama Panjang..."
    And owner should successfully log out

#  @TEST_LIMO-3449 @widgetWaktunyaMengelolaPropertiKosNonActive @WEB @AUTOMATED
#  Scenario: Widget Waktunya Mengelola Properti - Kos non active 1 & Apartemen 0
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag    | phone prod    | password    |
#      | 0895332021435 | 0895332021435 | digantilagi |
#    Then user see widget waktunya mengelola properti is as expected
#      | title                      | subtitle                                     |
#      | Atur Ketersediaan Kamar    | Mengelola data kamar kos                     |
#      | Daftar Tunggu              | Calon penyewa yang tertarik saat kamar penuh |
#      | Atur Harga                 | Update harga sewa di iklan kos               |
#      | Daftar ke Booking Langsung | Mengaktifkan fitur Booking                   |
#      | Penyewa                    | Daftar kontrak penyewa kos                   |
#      | Tambah Penyewa             | Menambah kontrak penyewa                     |
#      | Pusat Bantuan              | Info bantuan seputar Mamikos                 |
#
#  @TEST_LIMO-3447 @widgetWaktunyaMengelolaPropertiKosActive @WEB @AUTOMATED
#  Scenario: Widget Waktunya Mengelola Properti - Kos active 1 & Apartemen 0
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag   | phone prod   | password  |
#      | 083185622167 | 083185622167 | qwerty123 |
#    Then user see widget waktunya mengelola properti is as expected
#      | title                    | subtitle                                     |
#      | Atur Ketersediaan Kamar  | Mengelola data kamar kos                     |
#      | Daftar Tunggu            | Calon penyewa yang tertarik saat kamar penuh |
#      | Atur Harga               | Update harga sewa di iklan kos               |
#      | Ubah Peraturan Masuk Kos | Aturan untuk calon penyewa                   |
#      | Penyewa                  | Daftar kontrak penyewa kos                   |
#      | Tambah Penyewa           | Menambah kontrak penyewa                     |
#      | Pusat Bantuan            | Info bantuan seputar Mamikos                 |

#  @TEST_LIMO-3450 @functionBackatHomeSetprice @continue @WEB @AUTOMATED
#  Scenario: Check function back at home widget (Set Price)
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag   | phone prod   | password  |
#      | 083176408449 | 083176408449 | qwerty123 |
#    And user click menu "Atur Harga" on feature waktunya mengelola property
#    When user click back button in page
#    Then user should redirect to link "https://owner-jambu.kerupux.com/"

#  @TEST_LIMO-3455 @functionBackatHomeSetAvailableRoom @WEB @AUTOMATED
#  Scenario: Check function back at home widget (Set Set Available Room)
#    When user click menu "Ketersediaan Kamar" on feature waktunya mengelola property
#    And user click back button in page
#    Then user should redirect to link "https://owner-jambu.kerupux.com/"

#  @TEST_LIMO-3448 @widgetWaktunyaMengelolaPropertiKos0orVerification @WEB @AUTOMATED
#  Scenario Outline: Widget Waktunya Mengelola Properti - Kos active 0/verification & Apartemen 0/1
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag | phone prod | password  |
#      | <user>     | <user>     | qwerty123 |
#    Then user see widget waktunya mengelola properti is as expected
#      | title           | subtitle                                     |
#      | Daftar Tunggu   | Calon penyewa yang tertarik saat kamar penuh |
#      | Tambah Properti | Buat Kos/Apartemen Anda                      |
#    Examples:
#      | user         |
#      | 0876623622   |
#      | 0876623611   |
#      | 083151487757 |