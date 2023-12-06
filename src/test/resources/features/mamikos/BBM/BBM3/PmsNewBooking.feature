@regression @createNewBooking @BBM3 @essentialTest3
Feature: PMS - New booking

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

  Scenario: search by name tenant
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill nama tenant "Noval Abis Delete Aja"
    Then admin see informasi penyewa

  Scenario: admin additional price deposit and internet
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Singgahsini Modern Villa Bantul"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    And admin add other cost:
      | Nama Biaya | Harga  |
      | Deposit    | 100000 |
      | Internet   | 200000 |
    Then admin click on save button

  Scenario: Add tenant when the kost has an additional price, deposit & denda
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per Bulan     | today            | 1 Bulan     | Full Payment      |
    And admin click on save button
    Then admin see has fee Informasi Biaya Lain:
      | Nama Biaya | Harga    |
      | Listrik    | Rp50.000 |
      | Parkir     | Rp50.000 |

  Scenario: Add tenant when kost add additional price for kost 3 Bulanan
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And admin create contract tenant new booking
    And admin selected type room
    And admin fill phone number tenant "0892202105"
    Then admin see informasi penyewa
    And admin fill informasi pembayaran:
      | Hitungan Sewa | Tanggal Check-in | Durasi Sewa | Metode Pembayaran |
      | Per 3 Bulan   | today            | 3 Bulan     | Full Payment      |
    And admin click on save button
    Then admin see has fee Informasi Biaya Lain:
      | Nama Biaya | Harga     |
      | Listrik    | Rp150.000 |
      | Parkir     | Rp150.000 |
