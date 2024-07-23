@BBM6 @COOP6 @BnBFeature @BnBFeature3
Feature: Homepage - Kost Saya Section

  @TEST_SS-3511 @continue
  #changeOwnersPhoneNumber.feature
  Scenario: change owner's number phone at unique code
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password     |
      | 0890000000289 | Bismillah@01 |
    And user redirected to owner dashboard
    And user navigate to penyewa page
    And user search kost in penyewa menu "unique code"
    And user click Selengkapnya button on "Podcast" contract
    And user click Kirim ulang kode hyperlink
    Then user will redirect to Kirim kode unik ke penyewa page
    And user will see phone number of owner "0892202411" or "0890000001004"
    When user click Ubah nomor HP hyperlink
    And user change owner's phone number into "0890000001004" and click Gunakan
    Then user will see phone number of owner "0890000001004" or "0892202411"
    When user click Ubah nomor HP hyperlink
    And user change owner's phone number into "0892202411" and click Gunakan
    Then user will see phone number of owner "0892202411" or "0892202411"

  @TEST_SS-3477
  #warningDontHaveKosSayaAtSemuaFilter.feature
  Scenario: check warning who don't have kos saya at Semua filter (BBM-895)
    When user navigate to penyewa page
    And user search kost in penyewa menu "kost banda who dont have kos saya Tobelo Utara Halmahera Utara"
    Then user will see wording of warning tenant who don't have kos saya at Semua filter

  @TEST_SS-3534 @continue
  #addTenant.feature
  Scenario: Add Tenant For Full Room (BBM-928)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password     |
      | 0890000000289 | Bismillah@01 |
    And user click menu "Tambah Penyewa" on feature waktunya mengelola property
    And user click continue until start adding contract
    And user select kost "kost flores Tobelo Utara Halmahera Utara" for tenant
    Then owner can sees full pop up restriction
    When owner clicks on change room's data on full room pop up restriction
    Then owner redirected to update room page
    And owner can not sees full room pop up restriction

  @TEST_SS-3532
  #addTenant.feature
  Scenario: Add Tenant For Different Gender (BBM-927)
    Given owner navigates to owner dashboard
    And user click menu "Tambah Penyewa" on feature waktunya mengelola property
    And user choose owner added the contract
    And user select kost "kost madiun buat draft homepage Tobelo Utara Halmahera Utara" for tenant
    And owner input phone number with "083176833355"
    And owner choose first available room and clicks on add renter button
    And owner click button "Tambah Penyewa" on form informasi penyewa
    Then owner can sees different gender restriction pop-up

  @TEST_SS-3544 @automated @kost-saya-revamp-phase1 @web @xray-update
  Scenario: [Homepage ][Kost Saya Section ]Check Draft booking on homepage when have 1 draft for kost Promo Ngebut (BBM-905)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | password     |
      | 0890000000340 | Bismillah@01 |
    And tenant navigate to riwayat and draf booking
    And user click on Draft menu
    And user click delete button on tab one draft booking
    Then tenant cannot see "Kost Garden Abepura" as kost name and kost location
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag      |
      | Kost Garden Abepura |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "tomorrow"
    And user click back button
    Then tenant verify the confirmation cancel booking pop up
    And user click Save Draft Button
    When user go to mamikos homepage
    And user check promo ngebut label
    Then user can see shortcut homepage with "Mau lanjut ajukan sewa di kos ini?"
    And tenant navigate to riwayat and draf booking
    And user click on Draft menu
    And user click delete button on tab one draft booking
    Then tenant cannot see "Kost Garden Abepura" as kost name and kost location

  @TEST_SS-3531 @automated @kost-saya-revamp-phase1 @web @xray-update @bookingerror
  Scenario: [Homepage][Kost Saya Section] Check Kos saya section when Menunggu konfirmasi Total booking = 1 show section for Kost Promo Ngebut
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | password     |
      | 0890000000341 | Bismillah@01 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag      |
      | Kost Garden Abepura |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost "today" "Per Bulan"
    Then tenant should success booking kost
    When user go to mamikos homepage
    Then user can see shortcut homepage with "Pengajuan sewa lagi dicek pemilik"
    And tenant navigate to riwayat and draf booking
    And user cancel booking with reason "Merasa tidak cocok/tidak sesuai kriteria"
    Then tenant navigate to riwayat and draf booking

  @TEST_SS-3427 @automated @kost-saya-revamp-phase1 @web @xray-update @bookingerror
  Scenario: [Homepage ][Kost Saya Section ]Check Kos Saya on Homepage when have Draft booking = 1 (BBM-968)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | password  |
      | 08100000616 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And user click on Draft menu
    And user click delete button on tab one draft booking
    Then tenant cannot see "Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara" as kost name and kost location
    When user go to mamikos homepage
    And user click Mau Coba Dong section at homepage
    Then user will see kos saya is still empty
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                               |
      | Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "tomorrow"
    And user click back button
    Then tenant verify the confirmation cancel booking pop up
    And user click Save Draft Button
    And user go to mamikos homepage
    And user check promo ngebut label
    Then user can see shortcut homepage with "Mau lanjut ajukan sewa di kos ini?"
    And tenant navigate to riwayat and draf booking
    And user click on Draft menu
    And user click delete button on tab one draft booking
    Then tenant cannot see "Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara" as kost name and kost location

  @TEST_SS-3528 @automated @kost-saya-revamp-phase1 @web @xray-update
  Scenario: [Homepage ][Kost Saya Section ]Check homepage when have total waiting confirmation booking = 1 (BBM-882)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | password     |
      | 0890000000339 | Bismillah@01 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                               |
      | Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara |
    And tenant booking kost "today" "Per Bulan"
    Then tenant should success booking kost
    When user go to mamikos homepage
    Then user can see shortcut homepage with "Pengajuan sewa lagi dicek pemilik"
    And tenant navigate to riwayat and draf booking
    And user cancel booking with reason "Merasa tidak cocok/tidak sesuai kriteria"
    Then tenant navigate to riwayat and draf booking