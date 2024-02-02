@BBM6 @bnbfeature @kostBookingValidation
Feature: Kost Validation

  @TEST_COOP-1914 @automated @web @xray-update @validationBooking
  Scenario: [Kost Detail][Validation Pop Up]Check validation for booking when tenant not have Job (BBM-538)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     |  phone prod     | password     |
      | 081000000910   |  0891111020199  | qwerty123    |
    And tenant search kost then go to kost details:
      | kost name stag            			    | kost name prod              |
      | Kost Singgahsini Rocket Tipe F Kediri   | Kost Singgahsini Arac Ipi   |
    And user want to dismiss FTUE
    And tenant booking kost for "Tomorrow"
    Then tenant can see "Belum ada data jenis kelamin"

  @TEST_COOP-1905 @automated @web @xray-update @mahasiswaValidation @validationBooking
  Scenario: [Kost Detail][Validation Pop Up]Check validation for Booking kost khusus Karyawan when tenant profile as Mahasiswa
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     |  phone prod     | password     |
      | 0891111020199  |  0891111020199  | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag            			    | kost name prod              |
      | Kost Singgahsini Rocket Tipe F Kediri   | Kost Singgahsini Arac Ipi   |
    And user want to dismiss FTUE
    And tenant booking kost for "Tomorrow"
    Then tenant can see "Kos ini khusus untuk karyawan"
    And user click button "Saya mengerti" on popup validation
    Then tenant click ajukan sewa button on kost detail page
    When tenant can see "Kos ini khusus untuk karyawan"
    And user click button "Buka profil saya" on popup validation
    Then tenant navigates to edit profile
    And user go to mamikos homepage
    Then user logs out as a Tenant user

  @TEST_COOP-1902 @automated @web @xray-update @validationBooking @karyawanValidation
  Scenario: [Kost Detail][Validation Pop Up]Check validation for Booking kost khusus Mahasiswa when tenant profile as Karyawan (BBM-529)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     |  phone prod     | password     |
      | 08100000616  |  0891111020199  | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag            			    | kost name prod              |
      | Kost Singgahsini Rocket Tipe A Kediri   | Kost Singgahsini Arac Ipi   |
    And user want to dismiss FTUE
    And tenant booking kost for "Tomorrow"
    Then tenant can see "Kos ini khusus untuk mahasiswa"
    And user click button "Saya mengerti" on popup validation
    Then tenant click ajukan sewa button on kost detail page
    When tenant can see "Kos ini khusus untuk mahasiswa"
    And user click button "Buka profil saya" on popup validation
    Then tenant navigates to edit profile
    And user go to mamikos homepage
    Then user logs out as a Tenant user

  @TEST_COOP-1903 @automated @web @xray-update @kosMahasiswaTenantLainnya @validationBooking
  Scenario: [Kost Detail][Validation Pop Up]Check validation for Booking kost khusus Mahasiswa / Karyawan when tenant profile as Lainnya (BBM-530)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     |  phone prod     | password     |
      | 08100000623  |  0891111020199  | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag            			    | kost name prod              |
      | Kost Singgahsini Rocket Tipe E Kediri   | Kost Singgahsini Arac Ipi   |
    And user want to dismiss FTUE
    And tenant booking kost for "Tomorrow"
    Then tenant should reach booking form