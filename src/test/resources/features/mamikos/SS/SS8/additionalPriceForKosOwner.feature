@SS7
Feature: Additional price for kos owner

  @activatedDenda @TEST_SS-3478
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

  @denda @TEST_SS-3488
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

  @additionalPriceDeposit @TEST_SS-3476 @TEST_SS-3475 @TEST_SS-3474
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
      | Deposit |
      | 100000  |
    And owner click "Simpan"
    Then user cannot see "Rp100.000" on the list
    And owner click "Hapus"
    And owner click "Ya, Hapus"

  @otherPrice @TEST_SS-3496 @TEST_SS-3491
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

  @bookingWithOtherPrice @TEST_SS-3543
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
    And tenant redirect to kost details:
      | kost path stag                                                                                                     | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-singgah-sini-b-inter-millan-tobelo-utara-halmahera-utara | Kos DC BAR Automation Tipe A |
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
      | Tenant Phone | Kos Type    |
      | 0892202357   | All Testing |
    And admin click actions button on booking list
    And admin accept booking
    And admin click actions button on booking list
    And admin click detail in actions button
    Then admin sees other price with name "1234567890abcdefjkl" and price "Rp100.000" show in detail booking
