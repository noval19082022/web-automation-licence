@COOP6 @DbetTenant
Feature: DBET request from Tenant

  Scenario: Check validation when default job as mahasiswa and don't have nama universitas
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    Then user will see that the text "Contoh: Institur Teknologi Bandung" is displayed

  Scenario: Check validation when default job as karyawan and don't have nama instansi
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0892202351 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    Then user will see that the text "Contoh: Bank Central Asia" is displayed

  Scenario: Check validation when default job as lainnya and don't have nama instansi
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0892202352 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    Then user will see that the text "Nama pekerjaan" is displayed

