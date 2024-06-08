@COOP3
Feature: Pms New Booking


  @TEST_COOP-5036 @Automated @web @continue
  Scenario: Phone number tenant verified
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa

    @continue
  Scenario: search by name tenant
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill nama tenant "Noval Abis Delete Aja"
    Then admin see informasi penyewa
@continue
  Scenario: admin additional price deposit and internet
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya         | Harga  |
      | Listrik Pascabayar | 150000 |
      | Parkir Mobil       | 50000  |
    Then admin click on save button

    @continue
  Scenario: Add tenant when the kost has an additional price, deposit & denda
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya         | Harga  |
      | Listrik Pascabayar | 150000 |
      | Parkir Mobil       | 50000  |
    And admin click on save button
    Then admin see has fee Informasi Biaya Lain:
      | Nama Biaya         | Harga  |
      | Listrik Pascabayar | 150000 |
      | Parkir Mobil       | 50000  |

      @continue
  Scenario: Add tenant when kost add additional price for kost 3 Bulanan
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per 3 Bulan   | today            | 3 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya         | Harga  |
      | Listrik Pascabayar | 150000 |
      | Parkir Mobil       | 50000  |
    And admin click on save button
    Then admin see has fee Informasi Biaya Lain:
      | Nama Biaya         | Harga  |
      | Listrik Pascabayar | 150000 |
      | Parkir Mobil       | 50000  |

  @TEST_COOP-1052 @Automated @web @continue
  Scenario: Phone number tenant not verified
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0893202101"
    Then admin verify see text "Data tidak ditemukan"

  @TEST_COOP-1039 @Automated @web @continue
  Scenario: admin add tenant when room already full
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Mamitest Socrota"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    Then admin verify see text "Pilih metode pembayaran"

  @TEST_COOP-1064 @continue
  Scenario: Add tenant when kost add additional price for kost 3 Bulanan
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per 3 Bulan   | today            | 3 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya         | Harga  |
      | Listrik Pascabayar | 150000 |
      | Parkir Mobil       | 50000  |
    And admin click on save button
    Then admin see has fee Informasi Biaya Lain:
      | Nama Biaya         | Harga  |
      | Listrik Pascabayar | 150000 |
      | Parkir Mobil       | 50000  |

  @TEST_COOP-1052 @Automated @web @continue
  Scenario: Phone number tenant not verified
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0893202101"
    Then admin verify see text "Data tidak ditemukan"

  @TEST_COOP-1039 @Automated @web @continue
  Scenario: admin add tenant when room already full
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Mamitest Socrota"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    Then admin verify see text "Pilih metode pembayaran"

  @TEST_COOP-1064 @continue
  Scenario: admin additional price deposit and internet
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya  | Harga  |
      | Deposit     | 100000 |
      | Mamiservice | 150000 |
    Then admin click on save button

  Scenario: admin additional price deposit and internet
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya  | Harga  |
      | Deposit     | 100000 |
      | Mamiservice | 150000 |
    Then admin click on save button