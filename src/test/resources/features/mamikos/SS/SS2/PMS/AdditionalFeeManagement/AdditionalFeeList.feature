@regression @SS2 @pms @additonal-fee-management @master-data-list

Feature: Additional Fee Master Data List

  @TEST_SS-752 @continue
  Scenario: Check Biaya Tambahan Tetap, Satuan Waktu only, Ditentukan di Awal, Penyewa Tidak bisa pilih mandiri
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to additional fee management menu
    #add additional fee master data
    When admin add new additional fee
    When admin input nama biaya "Tetap waktu only"
    And admin select tipe pembayaran biaya "Tetap"
    And admin choose satuan waktu biaya "Harian"
    And admin choose satuan waktu biaya "Mingguan"
    And admin choose satuan waktu biaya "Bulanan"
    And admin select penyewa bisa pilih mandiri "Tidak"
    And admin select kategori asuransi "Tidak"
    And admin submit additional fee
    Then new additional fee "Tetap waktu only" added
      | Tipe Pembayaran | Satuan Biaya Top          | Satuan Biaya Bottom | Waktu Penentuan Harga Biaya | Penyewa Bisa Pilih Mandiri |
      | Tetap           | Harian, Mingguan, Bulanan | -                   | Ditentukan di Awal          | Tidak                      |
    #delete additional fee master data
    When admin delete additional fee "Tetap waktu only"
    Then no additional fee master data with name "Tetap waktu only"

  @TEST_SS-766 @continue
  Scenario: Check Biaya Tambahan Satu Kali, Satuan Waktu, Disesuaikan Tagihan, Penyewa tidak bisa pilih mandiri
    When admin add new additional fee
    When admin input nama biaya "Disesuaikan Tagihan"
    And admin select tipe pembayaran biaya "Satu Kali"
    And admin select waktu penentuan harga biaya "Disesuaikan dengan Tagihan"
    And admin choose satuan waktu biaya "Harian"
    And admin choose satuan waktu biaya "Mingguan"
    And admin choose satuan waktu biaya "Bulanan"
    And admin select kategori asuransi "Tidak"
    And admin submit additional fee
    Then new additional fee "Disesuaikan Tagihan" added
      | Tipe Pembayaran | Satuan Biaya Top          | Satuan Biaya Bottom | Waktu Penentuan Harga Biaya | Penyewa Bisa Pilih Mandiri |
      | Satu Kali       | Harian, Mingguan, Bulanan | -                   | Disesuaikan dengan Tagihan  | Tidak                      |
    #delete additional fee master data
    When admin delete additional fee "Disesuaikan Tagihan"
    Then no additional fee master data with name "Disesuaikan Tagihan"

  @TEST_SS-764 @continue
  Scenario: Check Biaya Tambahan Tetap, Satuan Besaran only, Ditentukan di Awal, Penyewa Booking bisa pilih mandiri
    When admin add new additional fee
    When admin input nama biaya "Tetap besaran only"
    And admin select tipe pembayaran biaya "Tetap"
    And admin select waktu penentuan harga biaya "Ditentukan di Awal"
    And admin choose satuan waktu biaya "Kilogram (kg)"
    And admin choose satuan waktu biaya "Item/pcs"
    And admin choose satuan waktu biaya "Per orang"
    And admin select penyewa bisa pilih mandiri "Ya"
    And admin select fase penyewa pilih biaya "Booking"
    And admin select kategori asuransi "Tidak"
    And admin submit additional fee
    Then new additional fee "Tetap besaran only" added
      | Tipe Pembayaran | Satuan Biaya Top                   | Satuan Biaya Bottom | Waktu Penentuan Harga Biaya | Penyewa Bisa Pilih Mandiri | Fase Penyewa Pilih Biaya |
      | Tetap           | Kilogram (kg), Item/pcs, Per orang | -                   | Ditentukan di Awal          | Ya                         | Booking                  |
    #delete additional fee master data
    When admin delete additional fee "Tetap besaran only"
    Then no additional fee master data with name "Tetap besaran only"

  @TEST_SS-772 @continue
  Scenario: Check Biaya Tambahan Satu Kali, Satuan Besaran dan Waktu, Ditentukan di Awal, Penyewa Stay bisa pilih mandiri
    When admin add new additional fee
    When admin input nama biaya "Satu Kali waktu dan besaran"
    And admin select tipe pembayaran biaya "Satu Kali"
    And admin select waktu penentuan harga biaya "Ditentukan di Awal"
    And admin choose satuan waktu biaya "Harian"
    And admin choose satuan waktu biaya "Mingguan"
    And admin choose satuan waktu biaya "Bulanan"
    And admin choose satuan besaran biaya "Kilogram (kg)"
    And admin choose satuan besaran biaya "Item/pcs"
    And admin choose satuan besaran biaya "Per orang"
    And admin select penyewa bisa pilih mandiri "Ya"
    And admin select fase penyewa pilih biaya "Stay"
    And admin select kategori asuransi "Tidak"
    And admin submit additional fee
    Then new additional fee "Satu Kali waktu dan besaran" added
      | Tipe Pembayaran | Satuan Biaya Top          | Satuan Biaya Bottom                | Waktu Penentuan Harga Biaya | Penyewa Bisa Pilih Mandiri | Fase Penyewa Pilih Biaya |
      | Satu Kali       | Harian, Mingguan, Bulanan | Kilogram (kg), Item/pcs, Per orang | Ditentukan di Awal          | Ya                         | Stay                     |
    #delete additional fee master data
    When admin delete additional fee "Satu Kali waktu dan besaran"
    Then no additional fee master data with name "Satu Kali waktu dan besaran"

  @TEST_SS-768
  Scenario: Check Biaya Tambahan Satu Kali, Satuan Besaran dan Waktu, Ditentukan di Awal, Penyewa Stay dan Booking bisa pilih mandiri
    When admin add new additional fee
    When admin input nama biaya "Penyewa Stay dan Booking"
    And admin select tipe pembayaran biaya "Satu Kali"
    And admin select waktu penentuan harga biaya "Ditentukan di Awal"
    And admin choose satuan waktu biaya "Harian"
    And admin choose satuan waktu biaya "Mingguan"
    And admin choose satuan waktu biaya "Bulanan"
    And admin choose satuan besaran biaya "Kilogram (kg)"
    And admin choose satuan besaran biaya "Item/pcs"
    And admin choose satuan besaran biaya "Per orang"
    And admin select penyewa bisa pilih mandiri "Ya"
    And admin select fase penyewa pilih biaya "Stay"
    And admin select fase penyewa pilih biaya "Booking"
    And admin select kategori asuransi "Tidak"
    And admin submit additional fee
    Then new additional fee "Penyewa Stay dan Booking" added
      | Tipe Pembayaran | Satuan Biaya Top          | Satuan Biaya Bottom                | Waktu Penentuan Harga Biaya | Penyewa Bisa Pilih Mandiri | Fase Penyewa Pilih Biaya |
      | Satu Kali       | Harian, Mingguan, Bulanan | Kilogram (kg), Item/pcs, Per orang | Ditentukan di Awal          | Ya                         | Stay dan Booking         |
    #delete additional fee master data
    When admin delete additional fee "Penyewa Stay dan Booking"
    Then no additional fee master data with name "Penyewa Stay dan Booking"

  @TEST_SS-743 @continue
  Scenario: Max list per page
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to additional fee management menu
    Then admin can view 10 additional fee per page

  @TEST_SS-6530
  Scenario: Master data list appearance
    Then all id using prefix "AF"
    And tipe pembayaran "Tetap" color is correct
    And tipe pembayaran "Satu Kali" color is correct
    And waktu penentuan harga biaya "Ditentukan di Awal" color is correct
    And waktu penentuan harga biaya "Disesuaikan dengan Tagihan" color is correct
    And penyewa bisa pilih mandiri "Ya" color is correct
    And penyewa bisa pilih mandiri "Tidak" color is correct