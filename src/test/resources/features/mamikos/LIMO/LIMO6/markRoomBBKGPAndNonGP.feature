@LIMO6
Feature: Owner - Penyewa Feature

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
    And tenant redirect to kost details:
      | kost path stag                                                                                                                                   | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-putra-murah-kost-singgahsini-noval-tipe-c-tobelo-utara-halmahera-utara-arac-grade-a-tobelo-halmahera-utara-2 | Kos DC BAR Automation Tipe A |
    And tenant booking kost for "today" and input rent duration equals to 0
    Then tenant should success booking kost
    And tenant logs out

 # Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 089120220103 | 0890000000289 | qwerty123 |
    And owner navigates to owner dashboard
    And owner accept booking from tenant:
      | tenant name stag          | tenant name prod          |
      | Owner galak suka survey   | Owner galak suka survey   |
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
    Then tenant checkin kost from riwayat booking

  @messageRequestTerminatedContract @TEST_SS-3539
  Scenario: check waiting terminated confirmation status
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod  | password  |
      | 0892202358 | 08100000622 | qwerty123 |
    And user navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    And user click review kost
    And user input review kost with rating 5:
      | review stop rent stag       |
      | Kost sangat aman dan bersih |
    And user stop rent kost with reason "Alasan Pribadi" and subreason "-"
    And user click ajukan berhenti sewa on kontrak saya after input data diri
    Then tenant can see "Pastikan form sudah diisi dengan benar untuk memudahkan pemilik melakukan konfirmasi." on bank account section
    And tenant click on "Kirim form ke pemilik" button on popup confirmation
    And tenant navigate to kontrak kost saya
    And user logs out as a Tenant user
    When user login as owner:
      | phone stag   | phone prod  | password  |
      | 089120220103 | 08100000622 | qwerty123 |
    And user navigate to penyewa page
    And user search kost in penyewa menu "ARAC"
    And user click on lihat selengkapnya button
    And user click on kontrak sewa button
    Then user will see message request terminated contract

  @disbursementInfo @continue @TEST_SS-3538
  Scenario: Check content and link on info untuk anda for disbursement
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 089120220103 | 0890000000289 | qwerty123 |
    And owner navigate to billing management
    And owner search kost in billing management "Kost Singgahsini Noval Tipe C Tobelo Utara Halmahera Utara ARAC Grade A Tobelo"
    And owner set Kelola Tagihan filter month to "Februari" month
    And user clicks Sudah bayar tab
    And user see Kapan uang masuk ke rekening saya? and clicks on disbursement link

  @checkContentLaporanKeuangan @TEST_SS-3487
  Scenario: Check content Laporan Keuangan
    Given user go to mamikos homepage
    And owner navigates to financial report
    Then user can see "Buka Laporan Keuangan di Aplikasi" and "Untuk saat ini, fitur Laporan Keuangan hanya dapat"

  @TEST_SS-3304
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
    And tenant redirect to kost details:
      | kost path stag                                                                                                                     | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-murah-kost-bima-booking-dp-biaya-lain-dan-denda-automation-tobelo-utara-halmahera-utara | Kos DC BAR Automation Tipe A |
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

  @addAndMarkRoomKosGP @SS-1918 @continue
  #addRoom.feature
  Scenario: check when owner add mark room at kos GP
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

  @markRoomAsOccupied @markRoom @TEST_SS-3463
  #markRoom.feature
  Scenario: Mark BBK And Gold Plus Room As Occupied (BBM-868)
    Given owner click back on added room pop up
    When user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click simpan on add room pop up
    Then owner can sees Pop-Up owner not add renter's data
    When owner click on Add Renter button
    Then owner redirected to input Renter's Information with kos name below:
      | kos name stag                                        | kos name prod                    |
      | Kos Automation BnB Tipe A Tobelo Halmahera Utara | Kos Automation BnB Tipe A |

  @occupancyAndBilling @markRoom @TEST_SS-3462 @continue
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

  @updateRoomToast @markRoom @TEST_SS-3461
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

  @deteleOtherPrice
  #otherPrice.feature
  Scenario: Delete Active Other Additional Price (BBM-947)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password     |
      | 081362464341 | 1d0lt3stb4ru |
    And owner navigates to update kos price with id:
      | stag     | prod     |
      | 89273843 | mock89273843 |
    And user delete active other additional price
    Then tenant can not sees active other price