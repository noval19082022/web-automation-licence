@DOM3 @editProfile
Feature: Edit Profile

	#After create New account tenant
  @TEST_DOM-179 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][Gender - Edit Profile] not choose gender
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221221  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    Then user see message error validation "Wajib diisi"

  @TEST_DOM-187 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][City - Edit Profile ]not select city
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click kota asal dropdown
    Then user click simpan button

  @TEST_DOM-185 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][Education - Edit Profile]Not choose education
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click on last education tenant
    Then user click simpan button

  @TEST_DOM-183 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][No.darurat - Edit Profile ] input valid number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user input phone number darurat more than "0812123123" character
    Then user click simpan button

  @TEST_DOM-182 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][Pekerjaan - Default - Edit profile]check validation pekerjaan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221221  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    Then user see message error validation "Wajib diisi"

  @TEST_DOM-184 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][Pekerjaan - Mahasiswa - Edit Profile]Choose list Universitas
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221221  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Universitas Indonesia" in search dropdown pillih universitas
    Then user see button simpan edit profile disable

  @TEST_DOM-180 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][Pekerjaan - Mahasiswa - Edit Profile]see university
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221221  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user click universitas
    Then user see list universitas

  @TEST_DOM-186 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][DOB - Edit Profile]Blank DOB
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221221  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click icon calendar
    Then user see button simpan edit profile disable

  @TEST_DOM-1831 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][Edit Profile] Change all field data existing
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click icon calendar
    And user select city "kabupaten aceh barat"
    And user choose profession "mahasiswa"
    And user fills "Universitas Indonesia" in search dropdown pillih universitas
    And user click on marital status dropdown "kawin"
    And user click on last education tenant
    And user select "S1"
    And user input phone number darurat more than "0812123123" character
    Then user click simpan button

  @TEST_DOM-365 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][full name - Edit Profile] Change name tenant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user fills fullname "zoro"
    Then user click simpan button

  @TEST_DOM-364 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][full name - Edit Profile]blank name
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user fills fullname ""
    Then user see message error "Nama lengkap wajib diisi"

  @TEST_DOM-361 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][full name - Edit Profile]name with number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user fills fullname "zoro1998"
    Then user click simpan button

  @TEST_DOM-356 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Pekerjaan - Lainnya- Edit Profile]not fill text box
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Lainnya" in search dropdown pillih universitas
    Then user verify button simpan is active

  @TEST_DOM-354 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][DOB - Edit profile]change DOB
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click icon calendar
    Then user click simpan button

  @TEST_DOM-350 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][City - Edit Profile ]Search city
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user select city "Kuningan"
#    Then user click simpan button

  @TEST_DOM-351 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Gender - Edit Profile]change gender
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose dropdown "laki-laki"
    Then user click simpan button

  @TEST_DOM-352 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][City - Edit Profile ]change City
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user select city "kabupaten aceh barat"
    Then user click simpan button

  @TEST_DOM-348 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Karyawan - Lainnya- Edit Profile]fill text box
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "lainnya"
    And user fills instansi "MM"
    Then user verify button simpan is active

  @TEST_DOM-338 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Pekerjaan - Karyawan - Edit Profile]list office name
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown prefession
    Then Dropdown will displayed list office name

  @TEST_DOM-340 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Pekerjaan - Mahasiswa - Edit Profile]type office name not matched with list
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Akmal" in pilih universitas
    Then user verify message "There is no data" in search dropdown

  @TEST_DOM-339 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Pekerjaan - Lainnya- Edit Profile]Change Pekerjaan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "lainnya"
    And user fills instansi "PT Adhi Karya (Persero) Tbk."
    Then user click simpan button

  @TEST_DOM-336 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Pekerjaan - Karyawan - Edit Profile]type office name matched with list
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221220  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Indonesia" in pilih universitas
    Then user verify dropdown results list contains "Indonesia"



