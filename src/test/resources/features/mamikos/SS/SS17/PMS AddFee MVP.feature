@SS15 @AddfeeMvp
Feature: PMS - Add fee MVP

  @TEST_SS-5069
  Scenario: Terminated contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag | phone prod |
      | 0812000008 | 0812000008 |

  @TEST_SS-5070
  Scenario: Tenant cancel Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000008 | 0812000008 | qwerty123 |
    And user cancel booking

  @TEST_SS-5071
  Scenario: [PMS] Create new booking or DBET when kost doesn't have PMS KK Add fee
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Bale Mantu Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0812000008"
    Then admin see informasi penyewa
    When admin can see "Tidak ada biaya tambahan yang tersedia di kos ini. Silakan buka PMS KK untuk menambahkan biaya tambahan opsional"
    Then admin can see "Untuk menambahkan biaya yang akan ditagihkan ke tenant, harap tambahkan biaya kos ke PMS KK terlebih dulu."
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    And admin click on save button
    And admin click on ya simpan button

  @TEST_SS-5072
  Scenario: [BangKerupux][Data Booking] Admin confirm booking when kost doesnt have Add fee
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin show filter data booking
    And admin filter data booking by tenant phone number:
      | Tenant Phone | Kos Type    |
      | 0812000008   | All Testing |
    And admin click actions button on booking list
    And admin accept booking for kost add fee
    When admin can see "Tidak ada biaya tambahan yang tersedia di kos ini. Silakan buka PMS KK untuk menambahkan biaya tambahan opsional"
    Then admin can see "Untuk menambahkan biaya yang akan ditagihkan ke tenant, harap tambahkan biaya kos ke PMS KK terlebih dahulu"
    And admin click on next button accept booking for kost add fee

  @TEST_SS-5073
  Scenario: [Mamipay][Detail fee] Admin check addfee for kost p1 doesn't have pms KK
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number and go to invoice detail fee:
      | search by      | renter_phone_number |
      | search value   | 0812000008          |
      | invoice number | default             |
    And admin click on add fee button
    Then admin cant see "Biaya Tambahan Opsional di Kos"

  @TEST_SS-5074
  Scenario: [AddFee][PMS] Check Biaya tambahan on New booking when setting KK with tipe pembayaran satu kali
 # Scenario: Terminated contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag | phone prod |
      | 0812000007 | 0812000007 |

 # Scenario: Tenant cancel Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000007 | 0812000007 | qwerty123 |
    And user cancel booking

    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Bundaran Aloha Sidoarjo"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0812000007"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    Then admin can see add fee with price "Disesuaikan dengan Tagihan"
    And admin click on save button
    Then admin click on ya simpan button

  @TEST_SS-5075
  Scenario: [AddFee][BangKerupux] Check Biaya tambahan on confirm booking when booking for kost KK with tipe pembayaran satu kali
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin show filter data booking
    And admin filter data booking by tenant phone number:
      | Tenant Phone | Kos Type |
      | 0812000007   | All      |
    And admin click actions button on booking list
    And admin accept booking for kost add fee
    Then admin can see add fee with price "Disesuaikan dengan Tagihan"
    And admin click on next button accept booking for kost add fee

  @TEST_SS-5076
  Scenario: [PMS][New booking/DBET] Admin create biaya tambahan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000008 | 0812000007 | qwerty123 |
    And user cancel booking
    And user go to mamikos homepage
    And tenant logs out
    When admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Lapangan Tembak Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0812000008"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya      | Harga |
      | Parkir Mobil    | 10000 |
      | Alat Elektronik | 50000 |
    And admin click on save button
    Then admin see has fee Informasi Biaya Lain:
      | Nama Biaya      | Harga |
      | Parkir Mobil    | 10000 |
      | Alat Elektronik | 50000 |
    Then admin click on ya simpan button

  @TEST_SS-4354
  Scenario: [PMS][New booking] Create new booking or DBEt for 3Bulanan and added biaya tambahan for have Hitungan per Bulan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000008 | 0812000007 | qwerty123 |
    And user cancel booking
    And user go to mamikos homepage
    And tenant logs out
    When admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Lapangan Tembak Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0812000008"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 3 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya      | Harga |
      | Parkir Mobil    | 10000 |
      | Alat Elektronik | 50000 |
    And admin click on save button

  @TEST_SS-4332
  Scenario:[PMS][New Booking/DBET] Admin create more than one biaya tambahan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000008 | 0812000007 | qwerty123 |
    And user cancel booking
    And user go to mamikos homepage
    And tenant logs out
    When admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Lapangan Tembak Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0812000008"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 3 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya   | Harga |
      | Parkir Mobil | 10000 |
      | Bawa Blender | 50000 |
      | Bawa Kulkas  | 50000 |
      | Laundry      | 5000  |
    And admin click on save button
    Then admin click on ya simpan button

  @TEST_SS-4333
  Scenario: [Bangkerupux][Data booking] Admin check data biaya tambahan create from PMS
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin show filter data booking
    And admin filter data booking by tenant phone number:
      | Tenant Phone | Kos Type    |
      | 0812000008   | All Testing |
    And admin click actions button on booking list
    And admin accept booking for kost add fee
    Then admin can see add fee from pms with:
      | Name         |
      | Parkir Mobil |
      | Bawa Blender |

  @TEST_SS-4331
  Scenario: [PMS][New booking/DBET] Admin check list addfee must same with PMS-kk in dropdown
    When admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Lapangan Tembak Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0812000008"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 3 Bulan     | Full Payment      |
    Then admin can see addfee KK with:
      | addfee name     |
      | Alat Elektronik |
      | Bawa Blender    |
      | Bawa Kulkas     |
      | Laundry         |
      | Parkir Mobil    |

  Scenario: Terminated contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag | phone prod |
      | 0813000002 | 0813000002 |

  @TEST_SS-4349
  Scenario: [PMS][Reschedule] Create Reschedule when that booking has biaya tambahan
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Omah Ngembel Pajangan"
    And admin create contract tenant "reschedule"
    And admin selected type room
    And admin input contract id with "71305"
    And admin fill checkin with "tomorrow"
    Then admin can see other cost:
      | Nama Biaya                     |
      | Benefit Asuransi & Biaya Admin |
      | Parkir Mobil                   |
    And admin click on save button
    And admin click on confirm save button

  @TEST_SS-4352
  Scenario: [Bangkerupux][Confirm booking admin check confirm booking from reschedule and relocation
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin show filter data booking
    And admin filter data booking by tenant phone number:
      | Tenant Phone | Kos Type |
      | 0813000002   | All      |
    And admin click actions button on booking list
    And admin accept booking for kost add fee
    Then admin can see "Benefit Asuransi & Biaya Admin" on confirm booking page
    When admin can see "Rp25.000" on confirm booking page
    Then admin can see "Parkir Mobil" on confirm booking page
    When admin can see "Rp10.000" on confirm booking page
    And admin click on next button accept booking for kost add fee

  @TEST_SS-4350
  Scenario: [PMS][Relocation] Create Relocation when that booking has biaya tambahan
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag | phone prod |
      | 0813000002 | 0813000002 |
    When user go to mamikos homepage
    Then user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0813000002 | 0812000007 | qwerty123 |
    And user cancel booking

#    Scenario: Relocation
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Omah Ngembel Pajangan"
    And admin create contract tenant "relocation"
    And admin selected type room
    And admin input contract id with "71305"
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 3 Bulan     | Full Payment      |
    And admin click on save button

  @TEST_SS-4351
  Scenario: [Bangkerupux][Confirm booking] Admin check confirm booking form for Kost P2
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag | phone prod |
      | 0813000002 | 0813000002 |
    When user go to mamikos homepage
    Then user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0813000002 | 0812000007 | qwerty123 |
    And user cancel booking
    When user go to mamikos homepage
    Then tenant redirect to kost details:
      | kost path stag                                   | kost path prod               |
      | kost-jayapura-kost-putri-murah-kost-riniya-papua | Kos DC BAR Automation Tipe A |
    And tenant booking kost for "today"
    And user go to mamikos homepage
    And user logs out as a Tenant user

#    Scenario: confirm booking
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin show filter data booking
    And admin filter data booking by tenant phone number:
      | Tenant Phone | Kos Type |
      | 0813000002   | All      |
    And admin click actions button on booking list
    And admin accept booking for kost add fee
    Then admin click on next button accept booking for kost add fee