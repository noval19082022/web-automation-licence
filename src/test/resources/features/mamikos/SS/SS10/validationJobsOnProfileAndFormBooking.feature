@SS8 @validationJobs
Feature: Edit profile for jobs as Lainnya

  @TEST_SS-3340
  Scenario: Click Ajukan Sewa Button if user has not fill Deskripsi when user choose Lainnya as Pekerjaan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod  | password  |
      | 0812000007 | 08100000630 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-murah-kost-jawa-tobelo-utara-halmahera-utara | Kos DC BAR Automation Tipe A |
    And user want to dismiss FTUE
    And tenant fill booking data for "tomorrow" and "Per Bulan"
    And tenant click ajukan sewa button on kost detail page
    Then user can see validation on jobs with "Masukkan nama pekerjaan untuk memproses pengajuan sewa."

  @TEST_SS-3339 @continue
  Scenario: Change pekerjaan to Karyawan and fill with invalid data from booking detail
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08100000630 | 08100000630 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                                                   | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-irvi-automation-add-ons-tobelo-barat-halmahera-utara-1 | Kos DC BAR Automation Tipe A |
    And user want to dismiss FTUE
    And tenant fill booking data for "tomorrow" and "Per Bulan"
    And tenant click ajukan sewa button on kost detail page
    And user click on ubah button on informasi penyewa
    And user choose profession "Lainnya" on ubah informasi penyewa
    Then red hint "Nama pekerjaan wajib diisi." text will show up

  @TEST_SS-3339 @continue
  Scenario: Change pekerjaan to Karyawan and fill with invalid data from booking detail
    When user click on ubah button on informasi penyewa
    And user choose profession "Karyawan" on ubah informasi penyewa
    And user click dropdown and fills "aaa" on edit profile
    Then user can see information "There is no data"

  @TEST_SS-3329 @continue
  Scenario: Change pekerjaan to Karyawan from booking detail
    Given user click on ubah button on informasi penyewa
    When user choose profession "Karyawan" on ubah informasi penyewa
    And user click dropdown and fills "Bukit Asam Tbk" on edit profile
    And user choose pekerjaan "Bukit Asam Tbk" from dropdown
    Then user can see information "Karyawan"

  @TEST_SS-3352 @TEST_SS-3325 @TEST_SS-3327 @continue
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

  @TEST_SS-3351 @continue
  Scenario: Change pekerjaan to Mahasiswa and Karyawan with invalid data instantion from edit profile page
    When tenant navigates to edit profile
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "abcd"
    Then user can see information "There is no data"

  @TEST_SS-3324
  Scenario: Change pekerjaan to Mahasiswa and Karyawan with invalid data instantion from edit profile page
    When user choose profession "Mahasiswa"
    And user fills "abcd" in pilih universitas
    Then user can see information "There is no data"

  @TEST_SS-2666 @uxImprovement
  Scenario: [Web][UX Booking] When update jobs in profile page, must update jobs in campus/institution from booking form
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 08100000627 | 08100000630 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                                                   | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-irvi-automation-add-ons-tobelo-barat-halmahera-utara-1 | Kos DC BAR Automation Tipe A |
    And user want to dismiss FTUE
    And tenant fill booking data for "tomorrow" and "Per Bulan"
    And tenant click ajukan sewa button on kost detail page
    Then user see validation message "Nama perguruan tinggi"
    When user click on ubah button on informasi penyewa
    Then user choose profession "Karyawan" on ubah informasi penyewa
    And user click simpan button
    Then user see validation message "Nama instansi/ perusahaan"