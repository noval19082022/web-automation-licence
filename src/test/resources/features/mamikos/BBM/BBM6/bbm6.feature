@BBM6
Feature: BnB feature

  @OwnerBadgesNotLogin @OwnerBadges
  Scenario: Check Owner Badges on Kos Detail when not login tenant (BBM-500)
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost andalusia spanyol eropa timur | kost payment desta 2 |
    Then user reached owner badges section

  @OwnerBadgesWithTenantLogin @OwnerBadges
  Scenario: Check Owner Badges on Kos Detail when login tenant (BBM-498)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost andalusia spanyol eropa timur | kost payment desta 2 |
    Then user reached owner badges section

  @OwnerBadgesWithOwnerLogin @TEST_BBM-499
  Scenario: Check Owner Badges on Kos Detail when login owner (BBM-499)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost andalusia spanyol eropa timur | kost payment desta 2 |
    Then user reached owner badges section

  @activatedDenda
  Scenario: Activated denda and input price, update denda, then delete denda
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kost Singgah Sini B Inter millan Tobelo Utara Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And owner click toggle denda
    And owner input denda amount:
      | Jumlah Denda | late pay | Penalty |
      | 50000        | 7        | Hari    |
    And owner click "Simpan"
    Then user cannot see "Rp50.000" on the list
    And owner click "Ubah"
    And owner input denda amount:
      | Jumlah Denda | late pay | Penalty |
      | 100000       | 5        | Hari    |
    And owner click "Simpan"
    And owner click "Hapus"
    And owner click "Ya, Hapus"

  @denda
  Scenario: Check Penalty's Rules On Daily, Weekly, and Monthly (BBM-909)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kost Singgah Sini B Inter millan Tobelo Utara Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And owner click toggle denda
    And owner input denda amount:
      | Jumlah Denda | late pay | Penalty |
      | 100000       | 31       | Hari    |
    And owner click "Simpan"
    And owner click "Ubah"
    And owner input denda amount:
      | Jumlah Denda | late pay | Penalty |
      | 150000       | 4        | Minggu  |
    And owner click "Simpan"
    And owner click "Ubah"
    And owner input denda amount:
      | Jumlah Denda | late pay | Penalty |
      | 200000       | 12       | Bulan   |
    And owner click "Simpan"
    Then user cannot see "Rp200.000" on the list
    And owner click "Hapus"
    And owner click "Ya, Hapus"

  @additionalPriceDeposit
  Scenario: Activated deposit and input deposit price and save, then delete deposit
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kost Singgah Sini B Inter millan Tobelo Utara Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And owner click toggle deposit
    And owner input deposit amount:
      | Deposit |
      | 100000  |
    And owner click "Simpan"
    Then user cannot see "Rp100.000" on the list
    And owner click "Hapus"
    And owner click "Ya, Hapus"

  @otherPrice
  Scenario: Owner Add Additional Price With 20 Character And Price With Correct Data
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kost Singgah Sini B Inter millan Tobelo Utara Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And owner click toggle other price
    And owner input other price amount:
      | Nama Biaya          | Jumlah Biaya |
      | 1234567890abcdefjkl | 100000       |
    And owner click "Simpan"
    Then owner can sees other price with name 1234567890abcdefjkl and price Rp100.000 show in the list
    And owner click "Hapus"
    And owner click "Ya, Hapus"

  @bookingWithOtherPrice
  Scenario: Check Booking With Other Price On Admin Side
    #admin delete other price
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kost Singgah Sini B Inter millan Tobelo Utara Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And owner click toggle other price
    And owner input other price amount:
      | Nama Biaya          | Jumlah Biaya |
      | 1234567890abcdefjkl | 100000       |
    And owner click "Simpan"
    Then owner can sees other price with name 1234567890abcdefjkl and price Rp100.000 show in the list
    And owner logs out
    #admin reject booking
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag | phone prod    |
      | 0892202357 | 0890867321205 |
    And admin akhiri contract
    #booking kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202357 | 083176408442 | qwerty123 |
    And user cancel booking
    And tenant search kost then go to kost details:
      | kost name stag                                                | kost name prod           |
      | Kost Singgah Sini B Inter millan Tobelo Utara Halmahera Utara | Kost Adi Auto Voucher DP |
    And tenant booking kost for "today" and input rent duration equals to 2
    Then tenant should success booking kost
    And tenant logs out
    #admin approve booking
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin show filter data booking
    And admin filter data booking by tenant phone number:
      | Tenant Phone | Kos Type |
      | 0892202357   | All      |
    And admin click actions button on booking list
    And admin accept booking
    And admin click actions button on booking list
    And admin click detail in actions button
    Then admin sees other price with name "1234567890abcdefjkl" and price "Rp100.000" show in detail booking

  @deleteContractOtherPrice
  Scenario: Delete contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by Renter Phone Number and input field "0892202357"
    And admin cancel contract

  @filterPenyewa @continue
  Scenario: check contract status on all filter
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And user navigate to penyewa page
    And user search kost in penyewa menu "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And user click on dropdown Filter box and select filter:
      | Filter         |
      | Sedang menyewa |
    And user click on dropdown Filter box and select filter:
      | Filter     |
      | Akan masuk |
    Then user click on dropdown Filter box and select filter:
      | Filter                    |
      | Menghentikan kontrak sewa |

  @downloadBiodata
  Scenario: Download biodata fakedoor
    Given user go to mamikos homepage
    And user navigate to penyewa page
    And user search kost in penyewa menu "Kost Singgahsini Noval Tipe C Tobelo Utara Halmahera Utara ARAC Grade A Tobelo Halmahera Utara"
    And user click download biodata penyewa button
    And user tick on checkbox pop up
    Then user will see information about upcoming feature

  @waitingTerminateConfirmation
  Scenario: Cancel and create booking
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag | phone prod |
      | 0892202358 | 0892202358 |
    And admin akhiri contract
    Then admin should success terminate contract

 # Scenario: cancel booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0892202358 | 0892202358 | qwerty123 |
    And user cancel booking

  #Scenario: create booking
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                             | kost name prod |
      | Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara | kost reykjavik |
    And tenant booking kost for "today" and input rent duration equals to 0
    Then tenant should success booking kost
    And tenant logs out

 # Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 089120220103 | 0890000000289 | qwerty123 |
    And owner navigates to owner dashboard
    And owner accept booking via Homepage
    And owner logs out

#  Scenario: Tenant pay kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0892202358 | 0892202358 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0890867321217"
 # Scenario: Tenant check-in kos
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking

  @waitingTerminateConfirmation
  Scenario: check waiting terminated confirmation status
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod  | password  |
      | 0892202358 | 08100000622 | qwerty123 |
    And user navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    And user stop rent kost with reason "Jarak Kos Terlalu Jauh"
    And user click review kost
    And user input review kost with rating 5:
      | review stop rent stag       |
      | Kost sangat aman dan bersih |
    And user click ajukan berhenti sewa on kontrak saya after review kos
    And user logs out as a Tenant user
    When user login as owner:
      | phone stag   | phone prod  | password  |
      | 089120220103 | 08100000622 | qwerty123 |
    And user navigate to penyewa page
    And user search kost in penyewa menu "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And user click on lihat selengkapnya button
    And user click on kontrak sewa button
    Then user will see message request terminated contract

  @checkContentOnWaktuMengelolaKos
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
    And user click "Daftar kontrak penyewa kos"
    And owner back to owner dashboard
    And owner dismiss FTUE goldplus
    And user click "Tambah Penyewa"
    And owner click back previous button
    And owner dismiss FTUE goldplus
    And user click "Pusat Bantuan"
    Then user can see help center page

  @disbursementInfo @continue
  Scenario: Check content and link on info untuk anda for disbursement
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod  | password  |
      | 089120220103 | 08100000622 | qwerty123 |
    And owner navigate to billing management
    And owner search kost in billing management "Kost Singgahsini Noval Tipe C Tobelo Utara Halmahera Utara ARAC Grade A Tobelo Halmahera Utara"
    And owner set Kelola Tagihan filter month to "Oktober" month
    And user clicks Sudah bayar tab
    And user see Kapan uang masuk ke rekening saya? and clicks on disbursement link

  @checkContentLaporanKeuangan
  Scenario: Check content Laporan Keuangan
    Given user go to mamikos homepage
    And owner navigates to financial report
    Then user can see "Buka Laporan Keuangan di Aplikasi" and "Untuk saat ini, fitur Laporan Keuangan hanya dapat"

  @checkOwnerHaveOneKosNotBbk
  Scenario: Check Waktu Mengelola section when owner have one kost not Bbk
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod  | password   |
      | 089604239090 | 08100000622 | widyarini1 |
    And owner navigates to owner dashboard
    And user click "Atur Ketersediaan Kamar"

  @checkWaktuMengelolaWhenOwnerNotHaveBbkKos @TEST_BBM-973
  #ownerNotHaveBbkKos.feature
  Scenario: Check Waktu Mengelola section when owner not have BBK kos (BBM-973)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081227019392 | qwerty123 |
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
    Then user should redirect to link "https://help.mamikos.com/pemilik"

  @TEST_BBM-883
  #chatButuhResponPengajuanSewaLabel.feature
  Scenario: Delete All Need Confirmation Booking Request
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by Renter Phone Number and input field "0890000000332"
    And admin terminate contract
    And admin should success terminate contract
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | password     |
      | 0890000000332 | Bismillah@01 |
    And owner navigates to owner dashboard
    And user cancel booking
    # Scenario: tenant booking kost
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                              |
      | kost bima booking dp biaya lain dan denda automation Tobelo |
    And tenant booking kost for "today"
    Then tenant should success booking kost
    # Scenario: Owner accept booking from tenant
    And user go to mamikos homepage
    And user logs out as a Tenant user
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password     |
      | 0890000000289 | Bismillah@01 |
    And user click chat button in top bar owner home page
    And search chat in chatlist "Chat Butuh Respon Pengajuan Sewa Label"
    Then owner can see label with "Butuh respon pengajuan sewa"

  @addAndMarkRoomKosGP @BNB-2245
  #addRoom.feature
  Scenario: check when owner add and mark room at kos GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0827777777778 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kos Automation BnB Tipe A Tobelo Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    And owner add room with name or room number "Jupiter"
    And user fill room floor in room allotment page with "11011"
    And user tick already inhabited checkbox
    And user untick already inhabited checkbox
    Then verify will be appears and the room is untick again