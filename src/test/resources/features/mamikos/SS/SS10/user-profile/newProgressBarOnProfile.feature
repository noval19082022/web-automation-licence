@SS8 @newProgress
Feature: New Progress bar on Profile

  @TEST_SS-3318 @Manual @update-user-profile @TEST_SS-3315
  Scenario: [Profile][Informasi Pribadi]Tenant only complete for mandatory profile
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023100 | 0810000023100 | qwerty123 |
    And user navigate to kost saya page
    Then user see percentage based on field that was filled "40%4 / 10 data profil terisi"
    And user logs out as a Tenant user

  @TEST_SS-3317 @update-user-profile @TEST_SS-3331
  Scenario: [Profile][Informasi Pribadi]Tenant Batal to complete their profile information
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023100 | 0810000023100 | qwerty123 |
    And user navigate to kost saya page
    Then user see percentage based on field that was filled "40%4 / 10 data profil terisi"
    And user click on profile card
    And user select city "Kuningan"
    And user input phone number darurat more than "0812123123" character
    And user click on batal button
    Then user see percentage based on field that was filled "40%4 / 10 data profil terisi"
    And user logs out as a Tenant user

  @TEST_SS-3319 @update-user-profile @TEST_SS-3332
  Scenario: [Profile][Informasi Pribadi]Check the display and mandatory on profile page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023200 | 0810000023200 | qwerty123 |
    And user navigate to kost saya page
    Then user see percentage based on field that was filled "10%1 / 10 data profil terisi"
    And user click on profile card
    Then user will see that the text "Wajib diisi" is displayed
    And user choose profession "lainnya"
    Then user will see that the text "Wajib diisi" is displayed
    And user choose profession "mahasiswa"
    Then user see button simpan edit profile disable
    And user logs out as a Tenant user

  @TEST_SS-3316
  Scenario: [Profile][Informasi Pribadi]Check profile when tenant first time login to mamikos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023200 | 0810000023200 | qwerty123 |
    And user navigate to kost saya page
    Then user see percentage based on field that was filled "10%1 / 10 data profil terisi"
    And user logs out as a Tenant user

  @TEST_SS-3313
  Scenario: [Profile Page][User Profile]Check red dot at navbar when tenant not complete fill the profile information
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023200 | 0810000023200 | qwerty123 |
    Then user can see reddot on "profile picture"
    And user click on profile picture
    Then user can see reddot on "profile menu"
    When user navigate to kost saya page
    Then user logs out as a Tenant user

  @TEST_SS-3312
  Scenario: [Profile Page][User Profile]Check red dot when tenant only input mandatory field
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023100 | 0810000023100 | qwerty123 |
    Then user can see reddot on "profile picture"
    And user click on profile picture
    Then user can see reddot on "profile menu"
    When user navigate to kost saya page
    Then user logs out as a Tenant user

  @TEST_SS-3321
  Scenario: [Profile Page][User Profile]Check ret dot when tenant hasn’t verified the account and completed the profile information
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023300 | 0810000023300 | qwerty123 |
    Then user can see reddot on "profile picture"
    And user click on profile picture
    Then user can see reddot on "profile menu"
    When user navigate to kost saya page
    Then user logs out as a Tenant user

  @TEST_SS-3320 @reddot1
  Scenario: [Profile Page][User Profile][Profile Page][User Profile]Check red dot at navbar when tenant verified the account but not completed the profile infomation
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023400 | 0810000023400 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "karyawan"
    Then user click simpan button
    And user navigate to kost saya page
    Then user can see reddot on "profile picture"
    And user click on profile picture
    Then user can see reddot on "profile menu"
    When user navigate to kost saya page
    Then user logs out as a Tenant user

  @TEST_SS-4964 @reddot1
  Scenario: [Profile Page][User Profile][Profile Page][User Profile]Check red dot at navbar when tenant verified the account and completed the profile infomation
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023400 | 0810000023400 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user choose profession "mahasiswa"
    And user fills "Universitas Indonesia" in search dropdown pillih universitas
    And user click simpan button
    And user navigate to kost saya page
    Then user can not see reddot on profile picture
    When user navigate to kost saya page
    Then user logs out as a Tenant user

  @TEST_SS-3314
  Scenario: [Profile][Informasi Pribadi]Tenant complete their profile information
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000023400 | 0810000023400 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card
    And user fills "Universitas Udayana" in search dropdown pillih universitas
    And user click simpan button
    And user navigate to kost saya page
    Then user can not see percentage user profile
    And user logs out as a Tenant user