@mamipay @invoice-manual @SS1

Feature: Invoice Manual

  @TEST_SS-840 @continue
  Scenario: Back from Create Invoice Manual
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin input nama penyewa in buat invoice manual
      | property name                                       | tenant name   |
      | Kost Singgahsini Junior Satu Tipe C Halmahera Utara | Yudha Chandra |
      #back if no biaya added yet
    When admin click back button in buat invoice manual page
    Then exit buat invoice confirmation pop up should be appear
    And admin close buat invoice confirmation pop up
      #back if there is biaya added
    When admin add invoice manual
      | Nama Biaya   | Durasi | Satuan Waktu | Periode Awal |
      | Parkir Mobil | 3      | harian       | today        |
    When admin click back button in buat invoice manual page
    Then exit buat invoice confirmation pop up should be appear
    When admin check confirmation functionality and confirm exit
    Then admin redirect to invoice manual page

  @TEST_SS-655 @continue
  Scenario: Auto Fill Tenant No HP and Room Number
    Given admin go to mamikos mamipay admin
    When admin input nama penyewa in buat invoice manual
      | property name                                       | tenant name   |
      | Kost Singgahsini Junior Satu Tipe C Halmahera Utara | Yudha Chandra |
    Then tenant information should be auto fill
      | No HP        | No Kamar |
      | 081242455775 | C2       |

  @TEST_SS-589 @continue
  Scenario: Disable Buat dan Kirim Button
    Then the Buat dan Kirim button is disabled

  @continue @TEST_SS-738
  Scenario: Buat dan Kirim Invoice Manual
    When admin add invoice manual
      | Nama Biaya   | Durasi | Satuan Waktu | Periode Awal |
      | Parkir Mobil | 3      | harian       | today        |
    When admin check pop up button and confirm it
    Then invoice manual "Parkir Mobil" created
      | Nama Listing                                        | Jumlah Biaya | Status Invoice |
      | Kost Singgahsini Junior Satu Tipe C Halmahera Utara | Rp30.000     | Unpaid         |
    And show detail biaya if hovered
      | Nama Biaya            | Jumlah Biaya |
      | Parkir Mobil (3 Hari) | Rp30.000     |

  @TEST_SS-608
  Scenario: Check invoice data in invoice page
    When admin clicks invoice number with unpaid status
    Then invoice detail is displayed in new tab

  @continue @TEST_SS-559
  Scenario: Search invoice manual by Nomor Invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin search by "Nomor Invoice without change Search By" with value "MI/49220517/2022/09/69386"
    Then the result is displayed according the value "MI/49220517/2022/09/69386", "Indah Trivena Tampubolon", "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"

  @continue @TEST_SS-817
  Scenario: Search invoice manual by Nama Penyewa
    When admin search by "Nama Penyewa" with value "Indah Trivena Tampubolon"
    Then the result is displayed according the value "MI/49220517/2022/09/69386", "Indah Trivena Tampubolon", "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"

  @continue @TEST_SS-855
  Scenario: Search invoice manual by Nama Listing
    When admin search by "Nama Listing" with value "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"
    Then the result is displayed according the value "MI/49220517/2022/09/69386", "Indah Trivena Tampubolon", "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"

  @continue @TEST_SS-867
  Scenario: Search Nama Listing per word with value "khus"
    When admin search by "Nama Listing" with value "khus"
    Then the result is displayed according the value Search per word "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"

  @continue @TEST_SS-863
  Scenario: Search Nomor Invoice per word with value "12345"
    When admin search by "Nomor Invoice" with value "12345"
    Then the result is displayed according the value Search per word "Data yang dicari tidak ditemukan"

  @TEST_SS-843
  Scenario: Search Nama Penyewa per word with value "asdf yoohoo"
    When admin search by "Nama Penyewa" with value "asdf yoohoo"
    Then the result is displayed according the value Search per word "Data yang dicari tidak ditemukan"

  @continue @TEST_SS-709
  Scenario: Check Status Invoice "Paid" in filter
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When click Invoice Manual menu
    When admin clicks "Main Reset" button on Filter
    And admin clicks Filter in Invoice Manual
    And admin ticks "Paid" on the "Status Invoice" dropdown
    Then "Paid" Status Invoice is displayed

  @continue @TEST_SS-845
  Scenario: Check Status Invoice "Unpaid" in filter
    When admin clicks "Main Reset" button on Filter
    And admin clicks Filter in Invoice Manual
    And admin ticks "Unpaid" on the "Status Invoice" dropdown
    Then "Unpaid" Status Invoice is displayed

  @continue @TEST_SS-837
  Scenario: Check Status Invoice "Expired" in filter
    When admin clicks "Main Reset" button on Filter
    And admin clicks Filter in Invoice Manual
    And admin ticks "Expired" on the "Status Invoice" dropdown
    Then "Expired" Status Invoice is displayed

  @TEST_SS-713 @continue
  Scenario: Filter Tanggal Mulai and Tanggal Akhir
    When admin clicks "Main Reset" button on Filter
    And admin clicks Filter in Invoice Manual
    And admin selects the date for "today"
    And admin selects the date for "tomorrow"
    Then the Tanggal Invoice Dibuat "today" is displayed according to the filter

  @continue @TEST_SS-581
  Scenario: Search and Filter Invoice Manual
    When admin clicks "Main Reset" button on Filter
    And admin search by "Nama Listing" with value "Kost Singgahsini Junior Satu Tipe C Halmahera Utara"
    And admin clicks Filter in Invoice Manual
    And admin ticks "Unpaid" on the "Status Invoice" dropdown without clicks Terapkan
    And admin ticks "Master Data" on the "Jenis Biaya" dropdown without clicks Terapkan
    And admin selects the date for "today" with clicks Terapkan
    Then the "Kost Singgahsini Junior Satu Tipe C Halmahera Utara", "Unpaid", "Biaya Tambahan", "today" are displayed according to the search and filter

  @continue @TEST_SS-711
  Scenario: Filter Invoice Manual
    When admin refresh page and clicks Filter in Invoice Manual
      #Default Filter Unpaid
    And admin clicks "Terapkan" button on Filter
    Then "Unpaid" Status Invoice is displayed
    When admin clicks "Reset" button on Filter
    Then the counter on filter is disappears

  @continue @TEST_SS-567
  Scenario: Ubah Status Invoice from Unpaid to Paid
    When admin clicks Filter in Invoice Manual
    And admin ticks "Unpaid" on the "Status Invoice" dropdown
    And admin go to last page
      #check Kembali when set Tanggal and Time
    And choose action "Ubah Status"
    And admin clicks Kembali button
    Then status invoice manual "Unpaid"
      #check Close when set Tanggal and Time
    When choose action "Ubah Status"
    And admin clicks close button
    Then status invoice manual "Unpaid"
      #check Status Invooice when clicks Simpan
    When choose action "Ubah Status"
    And admin set tanggal pembayaran "selected today"
    And admin set waktu pembayaran "1000"
    Then Status Invoice is "Paid" and paid date at "today", "10:00"

  @TEST_SS-703
  Scenario: Ubah Status Invoice from Expired to Paid
    When admin clicks "Reset" button on Filter
    And admin clicks Filter in Invoice Manual
    And admin ticks "Expired" on the "Status Invoice" dropdown
    And admin go to last page
      #check Kembali when set Tanggal and Time
    And choose action "Ubah Status"
    And admin clicks Kembali button
    Then status invoice manual "Expired"
      #check Close when set Tanggal and Time
    When choose action "Ubah Status"
    And admin clicks close button
    Then status invoice manual "Expired"
      #check Status Invoice when clicks Simpan
    When choose action "Ubah Status"
    And admin set tanggal pembayaran "selected today"
    And admin set waktu pembayaran "1000"
    Then Status Invoice is "Paid" and paid date at "today", "10:00"