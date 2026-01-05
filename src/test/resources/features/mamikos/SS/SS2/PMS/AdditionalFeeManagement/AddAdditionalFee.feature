@regression @SS2 @pms @additonal-fee-management @add-master-data

Feature: Add Additional Fee Master Data

  @continue @TEST_SS-820
  Scenario: Additional fee name max 60 char validation
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to additional fee management menu
    When admin add new additional fee
      #input nama biaya exact 60 char
    And admin input nama biaya "=60 char"
    Then nama biaya error message not appear
      #input nama biaya >60 char
    And admin input nama biaya ">60 char"
    Then show nama biaya error message "Panjang karakter maksimal adalah 60 karakter."
      #input nama biaya <60 char
    When admin input nama biaya "Automated Biaya PMAN"
    Then nama biaya error message not appear

  @continue @TEST_SS-825
  Scenario: Existing additional fee name validation
      #input existing nama biaya
    When admin input nama biaya "Parkir Mobil"
    Then show nama biaya error message "Nama biaya ini sudah dibuat sebelumnya. Masukkan nama biaya yang lain."
      #input new nama biaya
    When admin input nama biaya "Automated Biaya PMAN"
    Then nama biaya error message not appear

  @continue @TEST_SS-780
  Scenario: Auto select Ditentukan di Awal if choose Tipe Pembayaran Biaya Tetap
    When admin select tipe pembayaran biaya "Tetap"
    Then waktu penentuan harga biaya ditentukan di awal auto selected
    And waktu penentuan harga biaya disesuaikan dengan tagihan is not visible

  @continue @TEST_SS-777
  Scenario: Auto select Penyewa Bisa Pilih Mandiri Tidak if choose Disesuaikan dengan tagihan
    When admin select tipe pembayaran biaya "Satu Kali"
    And admin select waktu penentuan harga biaya "Disesuaikan dengan Tagihan"
    Then penyewa bisa pilih mandiri is auto select Tidak
    And penyewa bisa pilih mandiri are disabled

  @continue @TEST_SS-853
  Scenario: Add new Additional Fee
    When admin choose satuan waktu biaya "Harian"
    And admin select kategori asuransi "Tidak"
    And admin submit additional fee
    Then new additional fee "Automated Biaya PMAN" added
      | Tipe Pembayaran | Satuan Biaya Top | Satuan Biaya Bottom | Waktu Penentuan Harga Biaya | Penyewa Bisa Pilih Mandiri |
      | Satu Kali       | Harian           | -                   | Disesuaikan dengan Tagihan  | Tidak                      |

  @continue @TEST_SS-856
  Scenario: Delete additional fee master data
    When admin delete additional fee "Automated Biaya PMAN"
    Then no additional fee master data with name "Automated Biaya PMAN"

  @TEST_SS-785
  Scenario: Button tambah validation
    When admin add new additional fee
      #All field empty
    Then button tambah disabled
      #Nama Biaya Empty
    When admin select tipe pembayaran biaya "Tetap"
    And admin choose satuan waktu biaya "Harian"
    And admin select penyewa bisa pilih mandiri "Ya"
    And admin select fase penyewa pilih biaya "Booking"
    Then button tambah disabled
      #Tipe Pembayaran biaya Empty
    When admin refresh page 0
    When admin input nama biaya "Automated Biaya PMAN"
    And admin choose satuan waktu biaya "Harian"
    And admin select penyewa bisa pilih mandiri "Ya"
    And admin select fase penyewa pilih biaya "Booking"
    Then button tambah disabled
      # Waktu penentuan harga biaya Empty
    When admin refresh page 0
    When admin input nama biaya "Automated Biaya PMAN"
    And admin choose satuan waktu biaya "Harian"
    And admin select penyewa bisa pilih mandiri "Ya"
    And admin select fase penyewa pilih biaya "Booking"
    Then button tambah disabled
      #Satuan waktu biaya empty
    When admin refresh page 0
    When admin input nama biaya "Automated Biaya PMAN"
    When admin select tipe pembayaran biaya "Tetap"
    And admin select penyewa bisa pilih mandiri "Ya"
    And admin select fase penyewa pilih biaya "Booking"
    Then button tambah disabled
      #Penyewa bisa pilih mandiri empty
    When admin refresh page 0
    When admin input nama biaya "Automated Biaya PMAN"
    When admin select tipe pembayaran biaya "Tetap"
    And admin choose satuan waktu biaya "Harian"
    Then button tambah disabled
      #Fase penyewa pilih biaya empty
    When admin refresh page 0
    When admin input nama biaya "Automated Biaya PMAN"
    When admin select tipe pembayaran biaya "Tetap"
    And admin choose satuan waktu biaya "Harian"
    And admin select penyewa bisa pilih mandiri "Ya"
    Then button tambah disabled
      #All field is fill
    When admin refresh page 0
    When admin input nama biaya "Automated Biaya PMAN"
    When admin select tipe pembayaran biaya "Tetap"
    And admin choose satuan waktu biaya "Harian"
    And admin select penyewa bisa pilih mandiri "Ya"
    And admin select fase penyewa pilih biaya "Booking"
    And admin select kategori asuransi "Tidak"
    Then button tambah enable

  @TEST_SS-783
  Scenario: Delete master data that are being used in Biaya Tambahan
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to additional fee management menu
      #create master data
    When admin add new additional fee
    And admin input nama biaya "Automated Biaya PMAN Deleted"
    And admin select tipe pembayaran biaya "Tetap"
    And admin choose satuan waktu biaya "Harian"
    And admin select penyewa bisa pilih mandiri "Ya"
    And admin select fase penyewa pilih biaya "Booking"
    And admin select kategori asuransi "Tidak"
    And admin submit additional fee
      #apply in kontrak kerja sama
    When admin go to Homepage
    And admin go to detail property "Khusus Automation"
    And admin see detail kerja sama
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu"
      | Nama Biaya                   | Ketentuan Bagi Hasil    | Jenis Biaya | Satuan Waktu | Harga Satuan Waktu |
      | Automated Biaya PMAN Deleted | Sesuai Basic Commission | Opsional    | Harian       | 100000             |
    Then additional fee is created in PMS KK
      | Nama Biaya                   | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil    |
      | Automated Biaya PMAN Deleted | Ya  Booking                | Opsional    | Tidak                        | Tetap                 | Sesuai Basic Commission |
      #delete master data
    When admin go to additional fee management menu
    And admin delete additional fee "Automated Biaya PMAN Deleted"
    Then no additional fee master data with name "Automated Biaya PMAN Deleted"
      #check in kontrak kerja sama
    When admin go to Homepage
    And admin go to detail property "Khusus Automation"
    And admin see detail kerja sama
    Then additional fee is deleted from Biaya Tambahan table