@SS15
Feature: Pms New Booking


  @SS-5088 @Automated @web @continue
  Scenario: Phone number tenant verified
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa

  @SS-5089 @continue
  Scenario: search by name tenant
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill nama tenant "Gattuso"
    Then admin see informasi penyewa

  @SS-5090 @continue
  Scenario: admin additional price Listrik Pascabayar and Parkir Mobil
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

  @SS-5091 @continue
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

  @SS-5092 @continue
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

  @SS-5093 @Automated @web @continue
  Scenario: Phone number tenant not verified
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0893202101"
    Then admin verify see text "Data tidak ditemukan"

  @SS-5094 @Automated @web @continue
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

  @@SS-5095 @continue
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

  @SS-5096 @Automated @web @continue
  Scenario: Phone number tenant not verified
    Given admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0893202101"
    Then admin verify see text "Data tidak ditemukan"

  @SS-5097 @Automated @web @continue
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

  @SS-5098
  Scenario: admin additional price deposit and Mamiservice
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

#  Scenario: admin additional price deposit and internet
#    Given admin go to pms singgahsini
#    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
#    And admin create contract tenant new booking
#    And admin selected type room
#    And admin fill phone number tenant "0892202105"
#    Then admin see informasi penyewa
#    And admin fill informasi pembayaran:
#      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
#      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
#    And admin add other cost:
#      | Nama Biaya  | Harga  |
#      | Deposit     | 100000 |
#      | Mamiservice | 150000 |
#    Then admin click on save button