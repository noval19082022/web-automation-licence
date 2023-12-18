@COOP-5027 @COOP3
Feature: PMS New DBET


  @TEST_COOP-5037 @TESTSET_COOP-4944 @Automated @web
  Scenario: [PMS-DBET][DBET Form]Check validation on on all field
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Apik Addams Halmahera Utara"
    And admin create contract tenant dbet
    And admin selected type room
    And admin click on save button
    Then admin can see "Data wajib diisi" on phone number

  @TEST_COOP-1185
  Scenario: [PMS-DBET][Phone number]Check validation on Phone number
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Apik Addams Halmahera Utara"
    And admin create contract tenant dbet
    And admin selected type room
    And admin fill phone number tenant "011"
    Then admin can see "Nomor handphone harus diawali dengan 08" on phone number
    When admin fill phone number tenant "081"
    Then admin can see "Minimal 8 karakter" on phone number
    When admin fill phone number tenant "081h"
    Then admin can see "Hanya dapat diisi dengan angka" on phone number

  @TEST_COOP-1191
  Scenario: [PMS-DBET][Phone number]Check validation on Tenant Name
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Apik Addams Halmahera Utara"
    And admin create contract tenant dbet
    And admin selected type room
    And admin click on save button
    Then admin can see "Data wajib diisi" on tenant name
    And admin fill nama tenant "Maya 12"
    Then admin can see "Masukkan karakter alfabet" on tenant name

  @TEST_COOP-1192
  Scenario: [PMS-DBET][Phone number]Check validation on Email
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to room allotment page "Kost Apik Addams Halmahera Utara"
    And admin create contract tenant dbet
    And admin selected type room
    And admin fill email tenant "tenanttujuh"
    And admin click on save button
    Then admin can see "Penulisan alamat email salah" on email
		
