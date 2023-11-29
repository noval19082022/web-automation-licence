@regression @pman @pms @additonal-fee-management @add-master-data

  Feature: Add Additional Fee Master Data

    @continue @TEST_PMAN-8877
    Scenario: Additional fee name max 60 char validation
      Given admin go to pms singgahsini
      And admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
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

    @continue @TEST_PMAN-8878
    Scenario: Existing additional fee name validation
      #input existing nama biaya
      When admin input nama biaya "Parkir Mobil"
      Then show nama biaya error message "Nama biaya ini sudah dibuat sebelumnya. Masukkan nama biaya yang lain."
      #input new nama biaya
      When admin input nama biaya "Automated Biaya PMAN"
      Then nama biaya error message not appear

    @continue @TEST_PMAN-8879
    Scenario: Auto select Ditentukan di Awal if choose Tipe Pembayaran Biaya Tetap
      When admin select tipe pembayaran biaya "Tetap"
      Then waktu penentuan harga biaya ditentukan di awal auto selected
      And waktu penentuan harga biaya disesuaikan dengan tagihan is not visible

    @continue @TEST_PMAN-8880
    Scenario: Auto select Penyewa Bisa Pilih Mandiri Tidak if choose Disesuaikan dengan tagihan
      When admin select tipe pembayaran biaya "Satu Kali"
      And admin select waktu penentuan harga biaya "Disesuaikan dengan Tagihan"
      Then penyewa bisa pilih mandiri is auto select Tidak
      And penyewa bisa pilih mandiri are disabled

    @continue @TEST_PMAN-8433
    Scenario: Add new Additional Fee
      When admin select satuan waktu biaya "Harian"
      And admin submit additional fee
      Then new additional fee "Automated Biaya PMAN" added
        | Tipe Pembayaran | Satuan Biaya  | Waktu Penentuan Harga Biaya | Penyewa Bisa Pilih Mandiri  |
        | Satu Kali       | Harian        | Disesuaikan dengan Tagihan  | Tidak                       |

    @continue @TEST_PMAN-8667
    Scenario: Delete additional fee master data
      When admin delete additional fee "Automated Biaya PMAN"
      Then no additional fee master data with name "Automated Biaya PMAN"

    @TEST_PMAN-8881
    Scenario: Button tambah validation
      When admin add new additional fee
      #All field empty
      Then button tambah disabled
      #Nama Biaya Empty
      When admin select tipe pembayaran biaya "Tetap"
      And admin select satuan waktu biaya "Harian"
      And admin select penyewa bisa pilih mandiri "Ya"
      And admin select fase penyewa pilih biaya "Booking"
      Then button tambah disabled
      #Tipe Pembayaran biaya Empty
      When admin refresh page 0
      When admin input nama biaya "Automated Biaya PMAN"
      And admin select satuan waktu biaya "Harian"
      And admin select penyewa bisa pilih mandiri "Ya"
      And admin select fase penyewa pilih biaya "Booking"
      Then button tambah disabled
      # Waktu penentuan harga biaya Empty
      When admin refresh page 0
      When admin input nama biaya "Automated Biaya PMAN"
      And admin select satuan waktu biaya "Harian"
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
      And admin select satuan waktu biaya "Harian"
      Then button tambah disabled
      #Fase penyewa pilih biaya empty
      When admin refresh page 0
      When admin input nama biaya "Automated Biaya PMAN"
      When admin select tipe pembayaran biaya "Tetap"
      And admin select satuan waktu biaya "Harian"
      And admin select penyewa bisa pilih mandiri "Ya"
      Then button tambah disabled
      #All field is fill
      When admin refresh page 0
      When admin input nama biaya "Automated Biaya PMAN"
      When admin select tipe pembayaran biaya "Tetap"
      And admin select satuan waktu biaya "Harian"
      And admin select penyewa bisa pilih mandiri "Ya"
      And admin select fase penyewa pilih biaya "Booking"
      Then button tambah enable