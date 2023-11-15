@regression @LIMO1 @LIMO1-staging
Feature: Quick Allocation on Properti Saya


  @TEST_LIMO-261
  Scenario: Verify ads ON but full occupancy
    #quickAllocation from mamiAds dashboard
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 083176408449 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    When owner select filter active mamiads
    Then user cek status toggle iklan "Kos Jajajadooo Segun Sorong" is "Naik"
    * user verify the toggle iklan "Kos Jajajadooo Segun Sorong" is "on"
    * user verify the wording iklan penuh "Kos Jajajadooo Segun Sorong" is "Kamar Penuh. Silahkan nonaktifkan jika tidak ingin menaikkan posisi iklan ini"
    #quickAllocation from kos page
    When owner navigates to property saya kos
    And owner search kost "Kos Jajajadooo Segun Sorong" on property saya page
    And user click Lihat Selengkapnya button for edit
    Then user verify the alokasi title is "MamiAds Aktif"
    * user verify the toggle is "on"
    *  user verify the wording ads is "Kamar penuh."
    When user click Lihat Selengkapnya button for edit
    Then user verify the alokasi title is "MamiAds Aktif"
    * user verify the toggle is "on"
    * user verify the wording ads is "Kamar penuh."

  @TEST_LIMO-254
  Scenario: [Property Saya Kos][MamiAds][Saldo<5000]: Owner ever allocate and ever paid mamiads
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 083176950241 | 0          | qwerty123 |
    And owner navigates to property saya kos
    When owner search kost "Kos Caye Raney Tipe B Tobelo Halmahera Utara" on property saya page
    Then user verify the alokasi title is "Beli Saldo MamiAds"
    * user verify the wording ads is "Pakai MamiAds, bisa naikkan posisi iklan Anda lho. Beli sekarang!"
    When user click Lihat Selengkapnya button for edit
    Then user verify the alokasi title is "Beli Saldo MamiAds"
    * user verify the wording ads is "Pakai MamiAds, bisa naikkan posisi iklan Anda lho. Beli sekarang!"
    * user verify the redirection to list mamiads balance