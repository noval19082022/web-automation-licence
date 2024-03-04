@BBM6 @COOP6 @COOP
Feature: BnB feature

  @OwnerBadgesNotLogin @OwnerBadges @TEST_COOP-1358
  Scenario: Check Owner Badges on Kos Detail when not login tenant (BBM-500)
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost Andalusia Spanyol Eropa Timur | kost payment desta 2 |
    Then user reached owner badges section

  @OwnerBadgesWithTenantLogin @OwnerBadges @TEST_COOP-1356
  Scenario: Check Owner Badges on Kos Detail when login tenant (BBM-498)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost Andalusia Spanyol Eropa Timur | kost payment desta 2 |
    Then user reached owner badges section

  @OwnerBadgesWithOwnerLogin @TEST_COOP-1357
  Scenario: Check Owner Badges on Kos Detail when login owner (BBM-499)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 0892202351 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost Andalusia Spanyol Eropa Timur | kost payment desta 2 |
    Then user reached owner badges section

  @activatedDenda
  Scenario: Activated denda and input price, update denda, then delete denda
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kost Singgah Sini B Inter Millan Tobelo Utara Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And owner click toggle denda
    And owner input denda amount:
      | Jumlah Denda | late pay | Penalty |
      | 50000        | 7        | Hari    |
    And owner click "Simpan"
    Then user cannot see "Rp50.000" on the list
    And owner click ubah denda
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
    And owner search kost "Kost Singgah Sini B Inter Millan Tobelo Utara Halmahera Utara" on property saya page
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
      | 100000       | 4        | Minggu  |
    And owner click "Simpan"
    And owner click "Ubah"
    And owner input denda amount:
      | Jumlah Denda | late pay | Penalty |
      | 100000       | 12       | Bulan   |
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
    And owner search kost "Kost Singgah Sini B Inter Millan Tobelo Utara Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And owner click toggle deposit
    And owner input deposit amount:
      | Deposit  |
      | 100000   |
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
    And owner search kost "Kost Singgah Sini B Inter Millan Tobelo Utara Halmahera Utara" on property saya page
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
    And owner search kost "Kost Singgah Sini B Inter Millan Tobelo Utara Halmahera Utara" on property saya page
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
      | Kost Singgah Sini B Inter Millan Tobelo Utara Halmahera Utara | Kost Adi Auto Voucher DP |
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

  @deleteContractOtherPrice @COOP60
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

#  @downloadBiodata
#  Scenario: Download biodata fakedoor
#    Given user go to mamikos homepage
#    And user navigate to penyewa page
#    And user search kost in penyewa menu "ARAC"
#    And user click download biodata penyewa button
#    And user tick on checkbox pop up
#    Then user will see information about upcoming feature

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

  #Scenario: cancel booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0892202358 | 0892202358 | qwerty123 |
    And user cancel booking

#  Scenario: create booking
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod |
      | Kost Singgahsini Noval Tipe C Tobelo Utara Halmahera Utara ARAC Grade A Tobelo Halmahera Utara | kost reykjavik |
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

  @messageRequestTerminatedContract
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
    And user search kost in penyewa menu "ARAC"
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

  @disbursementInfo @continue
  Scenario: Check content and link on info untuk anda for disbursement
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod  | password  |
      | 089120220103 | 08100000622 | qwerty123 |
    And owner navigate to billing management
    And owner search kost in billing management "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And owner set Kelola Tagihan filter month to "Januari" month
    And user clicks Sudah bayar tab
    And user see Kapan uang masuk ke rekening saya? and clicks on disbursement link

  @checkContentLaporanKeuangan @TEST_COOP-1942
  Scenario: Check content Laporan Keuangan
    Given user go to mamikos homepage
    And owner navigates to financial report
    Then user can see "Buka Laporan Keuangan di Aplikasi" and "Untuk saat ini, fitur Laporan Keuangan hanya dapat"

  @checkOwnerHaveOneKosNotBbk @TEST_COOP-1921
  Scenario: Check Waktu Mengelola section when owner have one kost not Bbk
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod  | password   |
      | 081227019399 | 081227019399 | qwerty123 |
    And owner navigates to owner dashboard
    And user click "Atur Ketersediaan Kamar"

  @checkWaktuMengelolaWhenOwnerNotHaveBbkKos @TEST_COOP-1927
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
    Then user should redirect to link "https://help.mamikos.com/pemilik"

  @TEST_COOP-1984
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
      | Kost Bima Booking Dp Biaya Lain Dan Denda Automation Tobelo Utara Halmahera Utara |
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

  @addAndMarkRoomKosGP @COOP-1918 @continue
  #addRoom.feature
  Scenario: check when owner add and mark room at kos GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0827777777778 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kos Automation BnB Tipe A Tobelo Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click on update room
    And owner add room with name or room number "Jupiter"
    And user fill room floor in room allotment page with "11011"
    And user tick already inhabited checkbox
    And owner click simpan on add room pop up
    Then verify will be appears and the room is untick again

  @markRoomAsOccupied @markRoom @TEST_COOP-1918
  #markRoom.feature
  Scenario: Mark BBK And Gold Plus Room As Occupied (BBM-868)
    Given owner click back on added room pop up
    When user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click simpan on add room pop up
    Then owner can sees Pop-Up owner not add renter's data
    When owner click on Add Renter button
    Then owner redirected to Input Renter's Information form with valid kost name

  @occupancyAndBilling @markRoom @TEST_COOP-1917 @continue
  #markRoom.feature
  Scenario: Mark BBK And Non Gold Plus Room As Occupied (BBM-867)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password     |
      | 081362464341 | 1d0lt3stb4ru |
    And owner navigates to property saya kos
    And owner search kost "Yamie Panda Kost Deposit Wirobrajan Yogyakarta" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click on update room
    When user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click simpan on add room pop up
    Then owner can sees room is on "Terisi" status
    When user click edit button in first row of the table
    And user untick already inhabited checkbox
    And owner click simpan on add room pop up
    Then owner can sees room is on "Kosong" status

  @updateRoomToast @markRoom @TEST_COOP-1916
  #updateRoom.feature
  Scenario: Check Update Room's Toast (BBM-869)
    Given owner navigates to property saya kos
    And owner search kost "Dont Starve Together" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click on update room
    And user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click simpan on add room pop up
    Then owner can sees toast "Kamar Terisi Bertambah 1"
    And user click edit button in first row of the table
    And user untick already inhabited checkbox
    And owner click simpan on add room pop up
    Then owner can sees toast "Kamar Kosong Bertambah 1"

  @BNB-3131 @TEST_COOP-1947
  #otherPrice.feature
  Scenario: Delete Active Other Additional Price (BBM-947)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password     |
      | 081362464341 | 1d0lt3stb4ru |
    And user click menu "Atur Harga" on feature waktunya mengelola property
    And user click kos "Ancient Fuelweaver Automation" in update price list
    And user delete active other additional price
    Then tenant can not sees active other price

  @TEST_COOP-1967 @continue
  #changeOwnersPhoneNumber.feature
  Scenario: change owner's number phone at unique code
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password     |
      | 0890000000289 | Bismillah@01 |
    And user navigate to penyewa page
    And user search kost in penyewa menu "unique code"
    And user click Selengkapnya button on "Tenant Unique Code Jangan Diubah" contract
    And user click Kirim ulang kode hyperlink
    Then user will redirect to Kirim kode unik ke penyewa page
    And user will see phone number of owner "0890000001003"
    When user click Ubah nomor HP hyperlink
    And user change owner's phone number into "0890000001004" and click Gunakan
    Then user will see phone number of owner "0890000001004"
    When user click Ubah nomor HP hyperlink
    And user change owner's phone number into "0890000001003" and click Gunakan
    Then user will see phone number of owner "0890000001003"

  @TEST_COOP-1932
  #warningDontHaveKosSayaAtSemuaFilter.feature
  Scenario: check warning who don't have kos saya at Semua filter (BBM-895)
    When user navigate to penyewa page
    And user search kost in penyewa menu "kost banda who dont have kos saya Tobelo Utara Halmahera Utara"
    Then user will see wording of warning tenant who don't have kos saya at Semua filter

  @TEST_COOP-1993 @continue
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

  @TEST_COOP-1991
  #addTenant.feature
  Scenario: Add Tenant For Different Gender (BBM-927)
    Given owner navigates to owner dashboard
    And user click menu "Tambah Penyewa" on feature waktunya mengelola property
    And user choose owner added the contract
    And user select kost "kost biak untuk add tenant automation" for tenant
    And owner input phone number with "083176833355"
    And owner choose first available room and clicks on add renter button
    And owner click button "Tambah Penyewa" on form informasi penyewa
    Then owner can sees different gender restriction pop-up

  @TEST_COOP-2004 @automated @kost-saya-revamp-phase1 @web @xray-update
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

  @TEST_COOP-1990 @automated @kost-saya-revamp-phase1 @web @xray-update @bookingerror
  Scenario: [Homepage ][Kost Saya Section ]Check Kos saya section when Menunggu konfirmasi Total booking = 1 show section for Kost Promo Ngebut
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

  @TEST_COOP-1361 @automated @kost-saya-revamp-phase1 @web @xray-update @bookingerror
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

  @TEST_COOP-1985 @automated @kost-saya-revamp-phase1 @web @xray-update
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

  @TEST_COOP-481 @uxImprovement
  Scenario: [Web][UX Improvement][Pengajuan sewa][Draft]Update wording when save to draft
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | password     |
      | 083311231113  | asdf1234     |
    And tenant search kost then go to kost details:
      | kost name stag                                  |
      | Kos Raya Raney Tipe Raya 3 Danurejan Yogyakarta |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    And user click back button
    Then tenant verify the confirmation cancel booking pop up
