@regression @LIMO4 @EX-LG
Feature: Homepage

  @navbarAfter @continue
  Scenario: Positive case Check Navbar login as owner
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password   |
      | 083176408311   | 083132824758   | qwerty123  |
    Then check the header menu display on homepage owner
    And user see username in top right shows as "abcdefghijklmnopqrst"

  @redirectionElementNavbar @continue
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
    When owner navigates to property saya kos
    Then user will be verify dropdown in property saya

  @ownerPage @listingGP @continue
  Scenario: Click "halaman pemilik" will redirect to Owner page
    When user navigates to owner dashboard
    And user click mamikos.com logo
    And user click profile on header
    Then user see dropdown with button owner page and exit
    When  user click owner page button
    Then user should redirect to link "https://owner-jambu.kerupux.com/"

  @ownerChatCS @listingGP @continue
  Scenario: Click "Chat CS" should open Contact Us Pop Up
    When owner navigates to property saya kos
    And user click Chat CS button
    Then user see Contact us pop up is appear

  @ownerSubMenu @continue
  Scenario: Sub menu on owner page redirect to the right page
    When owner navigates to property saya kos
    Then user should redirect to link "https://jambu.kerupux.com/ownerpage/kos"
    When owner navigates to property saya apartemen
    Then user should redirect to link "https://jambu.kerupux.com/ownerpage/apartment"

  @OwnerGreeting @listingGP @continue
  Scenario: Click username direct to setelan akun
    When user navigates to owner dashboard
    Then user see user's name "Halo, abcdefghijklmnopqrst" in owner dashboard
    When user click username in owner dashboard
    Then user redirected to "/ownerpage/settings"

  @OwnerProfileHeader @listingGP
  Scenario: Click profile name in top right will open dropdown menu
    When user click back button in page
    And user click owner username on header
    Then user see owner's name & phone number, text link "Setelan Akun" & "Logout"

  @OwnerDoesntHaveKost @listingGP
  Scenario: Check Add Kost button when owner doesn't have kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod     | password    |
      | 0876623622   | 0876623622     | qwerty123   |
    And user click menu "Tambah Properti" on feature waktunya mengelola property
    Then user should redirect to link "https://owner-jambu.kerupux.com/choose-property-type"

  @OwnerNameMoreThan30 @listingGP
  Scenario: If profile name more than 30 char show ellipsis
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod     | password    |
      | 082233545506   | 0812345670008  | qwerty123   |
    Then user see username in top right shows as "Rega Automate Dua Nama Panjang..."
    And owner should successfully log out

  @widgetWaktunyaMengelolaPropertiKosNonActive
  Scenario: Widget Waktunya Mengelola Properti - Kos non active 1 & Apartemen 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod     | password      |
      | 0895332021435   | 0895332021435  | digantilagi   |
    Then user see widget waktunya mengelola properti is as expected
      | title                      | subtitle                       |
      | Atur Ketersediaan Kamar    | Mengelola data kamar kos       |
      | Atur Harga                 | Update harga sewa di iklan kos |
      | Daftar ke Booking Langsung | Mengaktifkan fitur Booking     |
      | Penyewa                    | Daftar kontrak penyewa kos     |
      | Tambah Penyewa             | Menambah kontrak penyewa       |
      | Pusat Bantuan              | Info bantuan seputar Mamikos   |

  @widgetWaktunyaMengelolaPropertiKosActive
  Scenario: Widget Waktunya Mengelola Properti - Kos active 1 & Apartemen 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod    | password      |
      | 083185622167   | 083185622167  | qwerty123     |
    Then user see widget waktunya mengelola properti is as expected
      | title                   | subtitle                       |
      | Atur Ketersediaan Kamar | Mengelola data kamar kos       |
      | Atur Harga              | Update harga sewa di iklan kos |
      | Ubah Peraturan Masuk Kos| Aturan untuk calon penyewa     |
      | Penyewa                 | Daftar kontrak penyewa kos     |
      | Tambah Penyewa          | Menambah kontrak penyewa       |
      | Pusat Bantuan           | Info bantuan seputar Mamikos   |

  @functionBackatHomeSetprice @continue
  Scenario: Check function back at home widget (Set Price)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod    | password    |
      | 083176408449   | 083176408449  | qwerty123   |
    And user click menu "Atur Harga" on feature waktunya mengelola property
    When user click back button in page
    Then user should redirect to link "https://owner-jambu.kerupux.com/"

  @functionBackatHomeSetAvailableRoom
  Scenario: Check function back at home widget (Set Set Available Room)
    When user click menu "Atur Ketersediaan Kamar" on feature waktunya mengelola property
    And user click back button in page
    Then user should redirect to link "https://owner-jambu.kerupux.com/"

  @widgetWaktunyaMengelolaPropertiKos0orVerification
  Scenario Outline: Widget Waktunya Mengelola Properti - Kos active 0/verification & Apartemen 0/1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod    | password    |
      | <user>         | <user>        | qwerty123   |
    Then user see widget waktunya mengelola properti is as expected
      | title           | subtitle                     |
      | Tambah Properti | Buat Kos/Apartemen Anda      |
      | Pusat Bantuan   | Info bantuan seputar Mamikos |
    Examples:
      | user           |
      | 0876623622     |
      | 0876623611     |
      | 083151487757   |