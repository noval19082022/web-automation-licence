@regression @pman @pms @detailpropertypms

Feature: Kontrak Kerja Sama

  @continue @TEST_PMAN-3950
  Scenario: See and Edit Profil Pemilik
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
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

  @continue @TEST_PMAN-3948
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

  @continue @TEST_PMAN-3949
  Scenario: See and Edit Detail Kerja Sama
    When admin see detail kerja sama
    Then detail kerja sama should be match with data
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Pemilik Booking | Mamikos Booking | Jangka Waktu  | Awal Kerja Sama | Akhir Kerja Sama  | Biaya Keanggotaan |
      | Apik          | Static Rate       | 20%               | 9           | Full A  | 5%            | Rp4.000.000 | -         | -               | -           | 75%             | 25%             | 24 Bulan      | 1 November 2021 | 31 October 2023   | Rp25.000          |
    #Admin edit detail kerja sama
    When admin edit detail kerja sama
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Tipe JP | Presentase JP | Jumlah JP | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Jangka Waktu  | Biaya Keanggotaan |
      | Singgahsini   | Commission Rate   | 15%               | Partial | 10            | 2000000   | 6 Bulan   | 5               | 4000000     | 32            | 5000              |
    Then detail kerja sama should be match with data
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Pemilik Booking | Mamikos Booking | Jangka Waktu  | Awal Kerja Sama | Akhir Kerja Sama  | Biaya Keanggotaan |
      | Singgahsini   | Commission Rate   | 15%               | 9           | Partial | 10%           | Rp2.000.000 | 6 Bulan   | 5%              | Rp4.000.000 | 70%             | 30%             | 32 Bulan      | 1 November 2021 | 30 June 2024      | Rp5.000           |
    #revert back detail kerja sama
    When admin edit detail kerja sama
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Tipe JP | Presentase JP | Jumlah JP | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Jangka Waktu  | Biaya Keanggotaan |
      | Apik          | Static Rate       | 20%               | Full A  | 5%            | 4000000   | None      | -               | -           | 24            | 25000          |
    Then detail kerja sama should be match with data
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Pemilik Booking | Mamikos Booking | Jangka Waktu  | Awal Kerja Sama | Akhir Kerja Sama  | Biaya Keanggotaan |
      | Apik          | Static Rate       | 20%               | 9           | Full A  | 5%            | Rp4.000.000 | -         | -               | -           | 75%             | 25%             | 24 Bulan      | 1 November 2021 | 31 October 2023   | Rp25.000          |

  @TEST_PMAN-4041
  Scenario: See and Edit Detail Kerja Sama Hybrid
    #Admin edit detail kerja sama Hybrid
    When admin turn on Hybrid and set mamikos precentage to "10" percent
    Then kontrak kerja sama should contains hybrid rev share
      | Pemilik DBET  | Mamikos DBET  |
      | 90%           | 10%           |
    #revert back contract
    When admin turn off Hybrid
    Then kontrak kerja sama should not contains hybrid rev share