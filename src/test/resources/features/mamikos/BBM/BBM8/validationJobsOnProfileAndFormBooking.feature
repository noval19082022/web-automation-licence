@BBM811 @validationJobs
Feature: Edit profile for jobs as Lainnya

  @TEST_BBM-1513 @continue
  Scenario: Click Ajukan Sewa Button if user has not fill Deskripsi when user choose Lainnya as Pekerjaan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password      |
      | 08100000630   | 08100000630   | qwerty123     |
    And tenant search kost then go to kost details:
      | kost name stag                               | kost name prod                         |
      | kost jawa Tobelo Utara Halmahera Utara       | kost jawa Tobelo Utara Halmahera Utara |
    And tenant booking kost for "Tomorrow"
    Then user can see validation on jobs with "Masukkan pekerjaan untuk memproses pengajuan sewa."

  @TEST_BBM-1510 @continue
  Scenario: Change pekerjaan to Karyawan and fill with invalid data
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                                                  | kost name prod                                            |
      | Kost Irvi Automation Add Ons Tobelo Barat Halmahera Utara       | Kost Irvi Automation Add Ons Tobelo Barat Halmahera Utara |
    And tenant booking kost for "Tomorrow"
    And user click on ubah button on informasi penyewa
    And user choose profession "Lainnya" on ubah informasi penyewa
    Then red hint "Nama pekerjaan wajib diisi." text will show up

  @TEST_BBM-1510 @continue
  Scenario: Change pekerjaan to Karyawan and fill with invalid data
    When user click on ubah button on informasi penyewa
    And user choose profession "Karyawan" on ubah informasi penyewa
    And user click dropdown and fills "aaa" on edit profile
    Then user can see information "There is no data"

  @TEST_BBM-1509
  Scenario: Change pekerjaan to Karyawan
    Given user click on ubah button on informasi penyewa
    When user choose profession "Karyawan" on ubah informasi penyewa
    And user click dropdown and fills "Bukit Asam Tbk" on edit profile
    And user choose pekerjaan "Bukit Asam Tbk" from dropdown
    Then user can see information "Karyawan"


