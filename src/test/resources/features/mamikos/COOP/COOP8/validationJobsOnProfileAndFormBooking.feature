@BBM8 @validationJobs
Feature: Edit profile for jobs as Lainnya

  @TEST_COOP-798
  Scenario: Click Ajukan Sewa Button if user has not fill Deskripsi when user choose Lainnya as Pekerjaan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 08100000630   | 08100000630   | qwerty123     |
    And tenant search kost then go to kost details:
      | kost name stag                               | kost name prod                         |
      | kost jawa Tobelo Utara Halmahera Utara       | kost jawa Tobelo Utara Halmahera Utara |
    And user want to dismiss FTUE
    And tenant fill booking data for "tomorrow" and "Per Bulan"
    And tenant click ajukan sewa button on kost detail page
    Then user can see validation on jobs with "Masukkan nama pekerjaan untuk memproses pengajuan sewa."

  @TEST_COOP-797 @continue
  Scenario: Change pekerjaan to Karyawan and fill with invalid data from booking detail
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 08100000630   | 08100000630   | qwerty123     |
    And tenant search kost then go to kost details:
      | kost name stag                                                  | kost name prod                                            |
      | Kost Irvi Automation Add Ons Tobelo Barat Halmahera Utara       | Kost Irvi Automation Add Ons Tobelo Barat Halmahera Utara |
    And user want to dismiss FTUE
    And tenant fill booking data for "tomorrow" and "Per Bulan"
    And tenant click ajukan sewa button on kost detail page
    And user click on ubah button on informasi penyewa
    And user choose profession "Lainnya" on ubah informasi penyewa
    Then red hint "Nama pekerjaan wajib diisi." text will show up

  @TEST_COOP-797 @continue
  Scenario: Change pekerjaan to Karyawan and fill with invalid data from booking detail
    When user click on ubah button on informasi penyewa
    And user choose profession "Karyawan" on ubah informasi penyewa
    And user click dropdown and fills "aaa" on edit profile
    Then user can see information "There is no data"

  @TEST_COOP-771 @continue
  Scenario: Change pekerjaan to Karyawan from booking detail
    Given user click on ubah button on informasi penyewa
    When user choose profession "Karyawan" on ubah informasi penyewa
    And user click dropdown and fills "Bukit Asam Tbk" on edit profile
    And user choose pekerjaan "Bukit Asam Tbk" from dropdown
    Then user can see information "Karyawan"

  @TEST_COOP-855 @TEST_COOP-767 @TEST_COOP-769 @continue
  Scenario: User able to change Profesi to Mahasiswa, Karyawan and Lainnya from edit profile page
    When tenant navigates to edit profile
    And user choose profession "Lainnya"
    And tenant fill job description with "Wiraswasta"
    And user click simpan button
    Then tenant success update profile
    When tenant navigates to edit profile
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "Bukit Asam Tbk"
    And user click simpan button
    Then tenant success update profile
    When tenant navigates to edit profile
    And user choose profession "Mahasiswa"
    And user fills "Universitas Lampung" in search dropdown pillih universitas
    And user click simpan button
    Then tenant success update profile

  @TEST_COOP-854 @continue
  Scenario: Change pekerjaan to Mahasiswa and Karyawan with invalid data instantion from edit profile page
    When tenant navigates to edit profile
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "abcd"
    Then user can see information "There is no data"

  @TEST_COOP-766
  Scenario: Change pekerjaan to Mahasiswa and Karyawan with invalid data instantion from edit profile page
    When user choose profession "Mahasiswa"
    And user fills "abcd" in pilih universitas
    Then user can see information "There is no data"

