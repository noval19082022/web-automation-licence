@regression @pms @detailpropertypms

Feature: Kontrak Kerja Sama

  @continue @TEST_SS-779 @pman2
  Scenario: See and Edit Profil Pemilik
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password        |
      | pman@mamiteam.com | pmanM4m1t34m!!  |
    And admin go to detail property "Khusus Automation"
    When admin see profil pemilik
    Then profil pemilik section match with data
      | Nama          | Nomor HP      | Alamat          | Provinsi      | kota/Kabupaten    | Kecamatan | Kelurahan   |
      | Yudha Ferroza | 083342344565  | Jl Sudirman no1 | DI Yogyakarta | Kabupaten Bantul  | Sanden    | Srigading   |
    #Admin edit profil pemilik
    When admin edit profil pemilik
      | Nama    | Nomor HP      | Alamat                  | Provinsi    | kota/Kabupaten    | Kecamatan | Kelurahan     |
      | Chandra | 084423230606  | Jl Tentara Pelajar No2  | Jawa Tengah | Kabupaten Cilacap | Adipala   | Adireja Wetan |
    Then profil pemilik section match with data
      | Nama    | Nomor HP      | Alamat                  | Provinsi    | kota/Kabupaten    | Kecamatan | Kelurahan     |
      | Chandra | 084423230606  | Jl Tentara Pelajar No2  | Jawa Tengah | Kabupaten Cilacap | Adipala   | Adireja Wetan |
    #Revert back profil pemilik
    When admin edit profil pemilik
      | Nama          | Nomor HP      | Alamat          | Provinsi      | kota/Kabupaten    | Kecamatan | Kelurahan   |
      | Yudha Ferroza | 083342344565  | Jl Sudirman no1 | DI Yogyakarta | Kabupaten Bantul  | Sanden    | Srigading   |
    Then profil pemilik section match with data
      | Nama          | Nomor HP      | Alamat          | Provinsi      | kota/Kabupaten    | Kecamatan | Kelurahan   |
      | Yudha Ferroza | 083342344565  | Jl Sudirman no1 | DI Yogyakarta | Kabupaten Bantul  | Sanden    | Srigading   |

  @continue @TEST_SS-824 @pman2
  Scenario: See and Edit Informasi Transfer Pendapatan
    Then informasi transfer pendapatan should be match with data
      | Nomor Rekening    | Nama Bank   | Cabang    | Nama Pemilik  | Tanggal Transfer  |
      | 10000245429       | Mandiri     | Bantul    | Yudha Ferroza | 5                 |
    #Admin edit informasi transfer pendapatan
    When admin edit informasi transfer pendapatan
      | Nomor Rekening | Nama Bank   | Cabang     | Nama Pemilik  | Tanggal Transfer  |
      | 10002000       | Muamalat    | Yogyakarta | Chandra       | 20                |
    Then informasi transfer pendapatan should be match with data
      | Nomor Rekening | Nama Bank   | Cabang     | Nama Pemilik  | Tanggal Transfer  |
      | 10002000       | Muamalat    | Yogyakarta | Chandra       | 20                |
    #revert back informasi transfer pendapatan
    When admin edit informasi transfer pendapatan
      | Nomor Rekening    | Nama Bank   | Cabang    | Nama Pemilik  | Tanggal Transfer  |
      | 10000245429       | Mandiri     | Bantul    | Yudha Ferroza | 5                 |
    Then informasi transfer pendapatan should be match with data
      | Nomor Rekening    | Nama Bank   | Cabang    | Nama Pemilik  | Tanggal Transfer  |
      | 10000245429       | Mandiri     | Bantul    | Yudha Ferroza | 5                 |

  @continue @TEST_SS-823
  Scenario: See and Edit Detail Kerja Sama
    When admin see detail kerja sama
    Then detail kerja sama should be match with data
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Pemilik Booking | Mamikos Booking | Jangka Waktu  | Awal Kerja Sama | Akhir Kerja Sama  | Biaya Keanggotaan |
      | Apik          | Static Rate       | 20%               | 9           | Full A  | 5%            | Rp4.000.000 | -         | -%               | -           | 75%             | 25%             | 24 Bulan      | 27 October 2023 | 26 October 2025   | Rp25.000          |
    #Admin edit detail kerja sama
    When admin edit detail kerja sama
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Tipe JP | Presentase JP | Jumlah JP | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Jangka Waktu  | Biaya Keanggotaan |
      | Singgahsini   | Commission Rate   | 15%               | Partial | 10            | 2000000   | 6 Bulan   | 5               | 4000000     | 12            | 5000              |
    Then detail kerja sama should be match with data
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Pemilik Booking | Mamikos Booking | Jangka Waktu  | Awal Kerja Sama | Akhir Kerja Sama  | Biaya Keanggotaan |
      | Singgahsini   | Commission Rate   | 15%               | 9           | Partial | 10%           | Rp2.000.000 | 6 Bulan   | 5%              | Rp4.000.000 | 70%             | 30%             | 12 Bulan      | 27 October 2023 | 26 October 2024   | Rp5.000           |
    #revert back detail kerja sama
    When admin edit detail kerja sama
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Tipe JP | Presentase JP | Jumlah JP | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Jangka Waktu  | Biaya Keanggotaan |
      | Apik          | Static Rate       | 20%               | Full A  | 5%            | 4000000   | None      | -               | -%          | 24            | 25000          |
    Then detail kerja sama should be match with data
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Pemilik Booking | Mamikos Booking | Jangka Waktu  | Awal Kerja Sama | Akhir Kerja Sama  | Biaya Keanggotaan |
      | Apik          | Static Rate       | 20%               | 9           | Full A  | 5%            | Rp4.000.000 | -         | -%              | -           | 75%             | 25%             | 24 Bulan      | 27 October 2023 | 26 October 2025   | Rp25.000          |

  @TEST_SS-784 @continue
  Scenario: See and Edit Detail Kerja Sama Hybrid
    #Admin edit detail kerja sama Hybrid
    When admin turn on Hybrid and set mamikos precentage to "10" percent
    Then kontrak kerja sama should contains hybrid rev share
      | Pemilik DBET  | Mamikos DBET  |
      | 90%           | 10%           |
    #revert back contract
    When admin turn off Hybrid
    Then kontrak kerja sama should not contains hybrid rev share


  @TEST_SS-819 @pman2
  Scenario: See Rincian Tipe Kamar dan Harga
    When admin go to pms singgahsini
    And admin go to detail property "Khusus Automation"
    And admin see profil pemilik
    And admin see rincian tipe kamar dan harga
    Then rincian tipe kamar dan harga should match
      | Tipe Kamar  | Gender  | Jumlah Kamar  | Harga OTA | Harga Bulanan  | Harga 3 Bulan  | Harga 6 Bulan | Static Bulanan  | Static 3 Bulan  | Static 6 Bulan  | Publish Bulanan | Publish 3 Bulan | Publish 6 Bulan |
      | Tipe A      | campur  | 3             | Rp110.000 | Rp850.000      | Rp0            | Rp4.050.000   | Rp800.000       | -               | Rp4.000.000     | Rp1.000.000     | -               | Rp6.000.000     |
      | Tipe B      | campur  | 3             | -         | Rp800.000      | Rp0            | Rp4.000.000   | Rp800.000       | -               | Rp4.000.000     | Rp1.000.000     | -               | Rp6.000.000     |
      | Tipe C      | campur  | 3             | -         | Rp800.000      | Rp0            | Rp4.000.000   | Rp800.000       | -               | Rp4.000.000     | Rp1.000.000     | -               | Rp6.000.000     |