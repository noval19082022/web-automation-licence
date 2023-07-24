@regression @pman @pms @detailpropertypms @test

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
      | Nama          | Nomor HP      | Alamat          | Provinsi      | kota/Kabupaten    | Kecamatan | Kecamatan   |
      | Yudha Ferroza | 083342344565  | Jl Sudirman no1 | DI Yogyakarta | Kabupaten Bantul  | Sanden    | Srigading   |
    #Admin edit profil pemilik
    When admin edit profil pemilik
      | Nama          | Nomor HP      | Alamat          | Provinsi      | kota/Kabupaten    | Kecamatan | Kecamatan   |
      | Yudha Ferroza | 083342344565  | Jl Sudirman no1 | DI Yogyakarta | Kabupaten Bantul  | Sanden    | Srigading   |
    Then profil pemilik section match with data
      | Nama          | Nomor HP      | Alamat          | Provinsi      | kota/Kabupaten    | Kecamatan | Kecamatan   |
      | Yudha Ferroza | 083342344565  | Jl Sudirman no1 | DI Yogyakarta | Kabupaten Bantul  | Sanden    | Srigading   |
    #Revert back profil pemilik
    When admin edit profil pemilik
      | Nama          | Nomor HP      | Alamat          | Provinsi      | kota/Kabupaten    | Kecamatan | Kecamatan   |
      | Yudha Ferroza | 083342344565  | Jl Sudirman no1 | DI Yogyakarta | Kabupaten Bantul  | Sanden    | Srigading   |
    Then profil pemilik section match with data
      | Nama          | Nomor HP      | Alamat          | Provinsi      | kota/Kabupaten    | Kecamatan | Kecamatan   |
      | Yudha Ferroza | 083342344565  | Jl Sudirman no1 | DI Yogyakarta | Kabupaten Bantul  | Sanden    | Srigading   |