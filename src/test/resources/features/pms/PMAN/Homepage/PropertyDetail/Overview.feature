@regression @pman @pms @detailpropertypms

Feature: Overview

  @TEST_PMAN-4621 @continue
  Scenario: See and Edit Profil Pemilik
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to detail property "Khusus Automation"
    Then profil property should match
      | ID    | Nama Property                                     | Jenis Produk  | Tipe                    | Syarat Pekerjaan Penyewa      | Syarat Agama Penyewa            | Alamat                          | Peta Lokasi                                             |
      | 3143  | Kost Apik Khusus Automation PMAN Halmahera Utara  | Apik          | Tipe A, Tipe B, Tipe C  | Mahasiswa, Karyawan, Pelajar  | Hindu, Islam, Katolik, Kristen  | Jl Poros Halmahera No 28 RT 02  | https://www.google.com/maps/place/1.7213294,127.9733685 |
    #Edit Profile Properti
    When admin edit profil property
      | Nama Properti                           | Syarat Pekerjaan Penyewa      | Syarat Agama Penyewa  | Alamat                | Peta Lokasi                                                                                                                                                                       |
      | Khusus Automation CORE Halmahera Utara  | Mahasiswa                     | Islam                 | Laut Halmahera KM 15  | https://www.google.com/maps/place/1%C2%B046'14.6%22N+127%C2%B057'16.6%22E/@1.7707222,127.9524339,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x7c7580344c9cec8!8m2!3d1.7707222!4d127.9546226  |
    Then profil property should match
      | ID    | Nama Property                                     | Jenis Produk  | Tipe                  | Syarat Pekerjaan Penyewa  | Syarat Agama Penyewa  | Alamat                | Peta Lokasi                                             |
      | 3143  | Kost Apik Khusus Automation CORE Halmahera Utara  | Apik          | Tipe A, Tipe B, Tipe C  | Mahasiswa                 | Islam                 | Laut Halmahera KM 15  | https://www.google.com/maps/place/1.7707222,127.9546226 |
    #Revert back Profile Properti
    When admin edit profil property
      | Nama Properti                           | Syarat Pekerjaan Penyewa      | Syarat Agama Penyewa            | Alamat                          | Peta Lokasi                                                                                                                                                                       |
      | Khusus Automation PMAN Halmahera Utara  | Mahasiswa, Karyawan, Pelajar  | Hindu, Islam, Katolik, Kristen  | Jl Poros Halmahera No 28 RT 02  | https://www.google.com/maps/place/1%C2%B043'16.8%22N+127%C2%B058'24.1%22E/@1.7213294,127.9733685,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x9dafe5079738e943!8m2!3d1.7213294!4d127.9733685 |
    Then profil property should match
      | ID    | Nama Property                                     | Jenis Produk  | Tipe                    | Syarat Pekerjaan Penyewa      | Syarat Agama Penyewa            | Alamat                          | Peta Lokasi                                             |
      | 3143  | Kost Apik Khusus Automation PMAN Halmahera Utara  | Apik          | Tipe A, Tipe B, Tipe C  | Mahasiswa, Karyawan, Pelajar  | Hindu, Islam, Katolik, Kristen  | Jl Poros Halmahera No 28 RT 02  | https://www.google.com/maps/place/1.7213294,127.9733685 |

  @TEST_PMAN-4620
  Scenario: See and Edit Penanggung Jawab
    When admin see penanggung jawab section
    Then penanggung jawab should be match
      | BSE       | BD      | AS      | Hospitality |
      | Okta BSE  | Budiman | Fitri   | Dimas       |
    #Edit penanggung jawab
    When admin edit penanggung jawab
      | BSE       | BD        | AS      | Hospitality |
      | Maya BSE  | Karentest | Indri   | Gilang      |
    Then penanggung jawab should be match
      | BSE       | BD        | AS      | Hospitality |
      | Maya BSE  | Karentest | Indri   | Gilang      |
    #Revert back penanggung jawab
    When admin edit penanggung jawab
      | BSE       | BD      | AS      | Hospitality |
      | Okta BSE  | Budiman | Fitri   | Dimas       |
    Then penanggung jawab should be match
      | BSE       | BD      | AS      | Hospitality |
      | Okta BSE  | Budiman | Fitri   | Dimas       |