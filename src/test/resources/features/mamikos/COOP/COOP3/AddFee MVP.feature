@COOP3 @AddfeeMvp
Feature: PMS - Add fee MVP

  Scenario: Terminated contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0812000008    | 0812000008    |

  Scenario: Tenant cancel Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000008 | 0812000008 | qwerty123 |
    And user cancel booking

  @TEST_COOP-6967
  Scenario: [PMS] Create new booking or DBET when kost doesn't have PMS KK Add fee
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
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

  @TEST_COOP-6968
  Scenario: [BangKerupux][Data Booking] Admin confirm booking when kost doesnt have Add fee
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin show filter data booking
    And admin filter data booking by tenant phone number:
      | Tenant Phone | Kos Type |
      | 0812000008   | All      |
    And admin click actions button on booking list
    And admin accept booking for kost add fee
    When admin can see "Tidak ada biaya tambahan yang tersedia di kos ini. Silakan buka PMS KK untuk menambahkan biaya tambahan opsional"
    Then admin can see "Untuk menambahkan biaya yang akan ditagihkan ke tenant, harap tambahkan biaya kos ke PMS KK terlebih dahulu"
    And admin click on next button accept booking for kost add fee

  @TEST_COOP-6945
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

  @TEST_COOP-7343
  Scenario: Terminated contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0812000007    | 0812000007    |

  @TEST_COOP-7343
  Scenario: Tenant cancel Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000007 | 0812000007 | qwerty123 |
    And user cancel booking

  @TEST_COOP-7343
  Scenario: [AddFee][PMS] Check Biaya tambahan on New booking when setting KK with tipe pembayaran satu kali
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
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

  @TEST_COOP-7344
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