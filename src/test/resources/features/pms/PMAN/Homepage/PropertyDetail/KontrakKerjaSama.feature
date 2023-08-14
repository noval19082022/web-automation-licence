@regression @pman @pms @detailpropertypms

Feature: Kontrak Kerja Sama
  Background: Open Detail Property
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to detail property "Khusus Automation"

  @TEST_PMAN-3950
  Scenario: See and Edit Kontrak Kerja Sama - Profil Pemilik
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

  @TEST_PMAN-3948
  Scenario: See and Edit Kontrak Kerja Sama - Informasi Transfer Pendapatan
    When admin see profil pemilik
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