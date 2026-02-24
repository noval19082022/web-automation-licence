@SS7 @DbetTenant
Feature: DBET request from Tenant

  @TEST_COOP-3042
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

  @TEST_COOP-721
  Scenario: Check validation when default job as karyawan and don't have nama instansi
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202351 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    Then user will see that the text "Contoh: Bank Central Asia" is displayed

  @TEST_COOP-6656
  Scenario: Check validation when default job as lainnya and don't have nama instansi
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202352 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    Then user will see that the text "Nama pekerjaan" is displayed

  @TEST_COOP-728
  Scenario: Check validation when choose jobs as mahasiswa with fill nama universitas
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202350 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    Then user will see that the text "Nama pekerjaan" is displayed
    And user click on "Mahasiswa" button
    And user click on dropdown profession in informasi penyewa request DBET tenant
    And user fills "Universitas Syiah Kuala" in pilih universitas penyewa request DBET tenant
    And user click simpan button
    Then user will see that the text "Formulir Data Penyewa" is displayed

  @TEST_COOP-729
  Scenario: Check validation when choose jobs as mahasiswa without fill nama universitas
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202350 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    Then user will see that the text "Nama pekerjaan" is displayed
    And user click on "Mahasiswa" button
    And user click simpan button
    Then user will see that the text "Formulir Data Penyewa" is displayed

  @TEST_COOP-709
  Scenario: Check validation when choose jobs as karyawan with fill nama instansi
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202353 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    And user click on "Lainnya" button
    And user fills pekerjaan lainnya "IRT" in informasi penyewa request DBET tenant
    And user click simpan button
    Then user will see that the text "Formulir Data Penyewa" is displayed

  @TEST_COOP-705
  Scenario: Check validation when choose jobs as lainnya with fill nama pekerjaan less then 2 character
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202353 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    And user click on "Lainnya" button
    And user fills pekerjaan lainnya "A" in informasi penyewa request DBET tenant
    Then user will see that the text "Minimal 2 karakter." is displayed

  @TEST_COOP-706
  Scenario: Check validation when choose jobs as lainnya with fill nama perkejaan more then 50 character
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202353 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    And user click on "Lainnya" button
    And user fills pekerjaan lainnya "fvasghfaksfgksjfgksjdgfksjfgksjgfkjdsgfkjsjdfhgjsdh" in informasi penyewa request DBET tenant
    Then user will see that the text "Maksimal 50 karakter." is displayed

  @TEST_COOP-703
  Scenario: Check validation when default job as mahasiswa and have nama universitas
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0812131415 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    Then user will see it has job name

  @TEST_COOP-712
  Scenario: Check validation when default job as karyawan and have nama instansi
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 089245645620 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    Then user will see it has job name

  @TEST_SS-4009
  Scenario: [Dbet Tenant] Tenant add Booking request for Kost Putra and tenant upload ID verification when gender tenant as Perempuan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202359 | 083176408442 | qwerty123 |
    And user go to formulir data penyewa
    And user click on "Selanjutnya" button
    And user click on "Selanjutnya" button
    And user click on "Mulai isi data" button
    And user click on pilih "0" informasi penyewa
    #And user want to upload ID verification
    And user click on "Simpan" button
    And user click on pilih "1" informasi penyewa
    And user click on "Kamar 3" button
    And user click on "Simpan" button
    And user click on pilih "2" informasi penyewa
    And user click on "Per Bulan" button
    And user click on "Simpan" button
    And user click on "Kirim Data" button
    And user click on "Saya Mengerti" button
    And owner logs out

  @TEST_COOP-3032
  Scenario: Check notification and information on homepage when owner accept booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089604239091 | 081362464341 | qwerty123 |
    And owner open notification icon
    And owner will see that the text "Konfirmasikan data penyewa ini Kost Rini Featured Maret Kartasura Sukoharjo" is displayed
    And user click on "Kontrak Sewa Menunggu" button
    And user click on "Tolak" button
    And user click on "Ya" button

  @TEST_COOP-3034
  Scenario: Check notification and information on homepage when owner Reject booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202359 | 081362464341 | qwerty123 |
    And user click Notifikasi on header
    Then user will see that the text "Pemilik menolak data Anda" is displayed

  @TEST_COOP-3019
  Scenario: Owner send form to tenant when Kartu Identitas and Jatuh Tempo ON
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089604239091 | 081362464341 | qwerty123 |
    And user navigate to add contract tenant page
    And user click on "Minta penyewa untuk mengisi" button
    And user click on "Rini punya tipe C" button
    And user click on toggle foto kartu identitas
    And user click on toggle jatuh tempo
    And user click on "Selanjutnya" button
    And user click on "Selesai" button
    Then user see user's name "Halo, Rini" in owner dashboard
