@SS11
Feature: Edit Profile

	#After create New account tenant
  @TEST_SS-3125 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web  @web-covered @TEST_COOP-5211
  Scenario: [Web Tenant][Gender - Edit Profile] not choose gender
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221221 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    Then user will see that the text "Wajib diisi" is displayed

  @TEST_SS-3121 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web  @web-covered
  Scenario: [Web Tenant][City - Edit Profile ]not select city
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click kota asal dropdown
    Then user click simpan button

  @TEST_SS-3118 @AUTOMATED @web  @web-covered
  Scenario: [Web Tenant][Education - Edit Profile]Not choose education
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click on last education tenant
    Then user click simpan button

  @AUTOMATED @web  @web-covered @TEST_SS-3117
  Scenario: [Web Tenant][No.darurat - Edit Profile ] input valid number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user input phone number darurat more than "0812123123" character
    Then user click simpan button

  @AUTOMATED @web  @web-covered @TEST_SS-3134
  Scenario: [Web Tenant][Pekerjaan - Default - Edit profile]check validation pekerjaan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221221 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    Then user will see that the text "Wajib diisi" is displayed

  @AUTOMATED @web  @web-covered @TEST_SS-3140
  Scenario: [Web Tenant][Pekerjaan - Mahasiswa - Edit Profile]Choose list Universitas
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221221 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Universitas Indonesia" in search dropdown pillih universitas
    Then user see button simpan edit profile disable

  @AUTOMATED @web  @web-covered @TEST_COOP-5210 @TEST_SS-3124
  Scenario: [Web Tenant][Pekerjaan - Mahasiswa - Edit Profile]see university
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221221 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user click universitas
    Then user see list universitas

  @TEST_SS-3139 @AUTOMATED @web  @web-covered
  Scenario: [Web Tenant][DOB - Edit Profile]Blank DOB
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221221 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click icon calendar
    Then user see button simpan edit profile disable

  @TEST_SS-3131 @AUTOMATED @web  @web-covered
  Scenario: [Web Tenant][Edit Profile] Change all field data existing
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
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

  @TEST_SS-3137 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated  @web-covered
  Scenario: [Tenant][full name - Edit Profile] Change name tenant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user fills fullname "zoro"
    Then user click simpan button

  @TEST_SS-3135 @Automated  @web-covered @TEST_COOP-5221
  Scenario: [Tenant][full name - Edit Profile]blank name
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user fills fullname ""
    Then user see message error "Nama lengkap wajib diisi"

  @TEST_SS-3133 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated  @web-covered @TEST_COOP-5219
  Scenario: [Tenant][full name - Edit Profile]name with number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user fills fullname "zoro1998"
    Then user click simpan button

  @TEST_SS-3128 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Lainnya- Edit Profile]not fill text box
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Lainnya" in search dropdown pillih universitas
    Then user verify button simpan is active

  @TEST_SS-3129 @Automated  @web-covered
  Scenario: [Tenant][DOB - Edit profile]change DOB
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click icon calendar
    Then user click simpan button

  @TEST_SS-3122 @Automated  @web-covered
  Scenario: [Tenant][City - Edit Profile ]Search city
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user select city "Kuningan"
    Then user click simpan button

  @TEST_SS-3126 @Automated  @web-covered
  Scenario: [Tenant][Gender - Edit Profile]change gender
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose dropdown "laki-laki"
    Then user click simpan button

  @TEST_SS-3127 @Automated  @web-covered
  Scenario: [Tenant][City - Edit Profile ]change City
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user select city "kabupaten aceh barat"
    Then user click simpan button

  @TEST_SS-3110 @Automated  @web-covered
  Scenario: [Tenant][Karyawan - Lainnya- Edit Profile]fill text box
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "lainnya"
    And user fills instansi "MM"
    Then user verify button simpan is active

  @TEST_SS-3112 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Karyawan - Edit Profile]list office name
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown profession
    Then Dropdown will displayed list office name

  @TEST_SS-3114 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Mahasiswa - Edit Profile]type office name not matched with list
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Akmal" in pilih universitas
    Then user verify message "There is no data" in search dropdown

  @TEST_SS-3113 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Lainnya- Edit Profile]Change Pekerjaan
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "lainnya"
    And user fills instansi "PT Adhi Karya (Persero) Tbk."
    Then user click simpan button

  @TEST_SS-3111 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Karyawan - Edit Profile]type office name matched with list
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Indonesia" in pilih universitas
    Then user verify dropdown results list contains "Indonesia"

  @TEST_SS-3119 @Automated  @web-covered
  Scenario: [Tenant][Mahasiswa - Lainnya- Edit Profile]fill text box
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Lainnya" in search dropdown pillih universitas
    And user fill "A" on custom university input
    Then user verify button simpan is active

  @TEST_SS-3106 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Karyawan - Edit Profile]Choose list office
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "PT Adhi Karya (Persero) Tbk"
    Then user click simpan button

  @TEST_SS-3107 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Karyawan - Edit Profile]Change office name
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "Adira Dinamika Multi Finance Tbk"
    Then user click simpan button

  @TEST_SS-3142 @Automated  @web-covered
  Scenario: [Tenant][profesion - Edit Profile ]choose profesion lainnya
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click dropdown pilih instansi "lainnya"
    And user fills instansi "Wirausaha"
    Then user click simpan button

  @TEST_SS-3138 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Mahasiswa - Edit Profile]type university name not matched with list
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Akmal" in pilih universitas
    Then user verify message "There is no data" in search dropdown

  @TEST_SS-3141 @Automated  @web-covered
  Scenario: [Tenant][profesion - Edit Profile ]Not choose profesion
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Lainnya"
    Then user see button simpan edit profile disable

  @TEST_SS-3136 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Mahasiswa - Edit Profile]type university name matched with list
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Mahasiswa"
    And user fills "Indonesia" in pilih universitas
    Then user verify dropdown results list contains "Indonesia"

  @TEST_SS-3132 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Mahasiswa - Edit Profile]Select Mahasiswa and choose universitas indonesia
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Universitas Indonesia" in search dropdown pillih universitas
    Then user click simpan button

  @TEST_SS-3120 @Automated  @web-covered
  Scenario Outline: [Tenant][Status - Edit profile]Change marital status
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click on marital status dropdown
    And user select marital status "<marital status>"
    Then user click simpan button
    Examples:
      | marital status      |
      | Belum Kawin         |
      | Kawin Memiliki Anak |

  @TEST_SS-3116 @Automated  @web-covered
  Scenario: [Tenant][Status - Edit Profile]Not choose marital status
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089513193288 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click on marital status dropdown
    Then user see marital status

  @TEST_SS-3115 @Automated  @web-covered
  Scenario: [Tenant][Education - Edit Profile]last education
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user click on last education tenant
    And user select "S1"
    Then user click simpan button

  @TEST_SS-3109 @Automated  @web-covered
  Scenario: [Tenant][No.darurat - Edit Profile ]input number darurat < 8
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user input phone number darurat more than "0812" character
    Then user see validation message "Nomor Kontak Darurat minimal mengandung 8 karakter."

  @TEST_SS-3108 @Automated  @web-covered
  Scenario: [Tenant][No.darurat - Edit Profile ]input number darurat > 14
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user input phone number darurat more than "0812123123000014" character
    Then user see validation message "Nomor Kontak Darurat tidak boleh lebih dari 14 karakter."

  @TEST_SS-3123 @Automated  @web-covered
  Scenario: [Tenant][Pekerjaan - Karyawan - Edit Profile] Dropdown list office name
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown profession
    Then Dropdown will displayed list office name

  @TEST_SS-3143
  Scenario: [Tenant][profesion - Edit Profile]fill profession as Karyawan using more than 50 characters
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089786127612 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Karyawan"
    And user click dropdown pilih instansi "lainnya"
    And user fills instansi "PT mencari cinta sejatiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii."
    Then user verify error messages
      | Maksimal 50 karakter. |

  @TEST_SS-3144
  Scenario: [Tenant][profesion - Edit Profile]fill profession as Mahasiswa using more than 50 characters
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089786127612 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Mahasiswa"
    And user click dropdown pilih instansi "lainnya"
    And user fill "universitas mencari cinta sejatiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii." on custom university input
    Then user verify error messages
      | Maksimal 50 karakter. |

  @TEST_SS-3145
  Scenario: [Tenant][profesion - Edit Profile]fill profession as Lainnya using more than 50 characters
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089786127612 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "Lainnya"
    And user fills masukan deskripsi pekerjaan "PT mencari cinta sejatiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii."
    Then user verify error messages
      | Maksimal 50 karakter. |