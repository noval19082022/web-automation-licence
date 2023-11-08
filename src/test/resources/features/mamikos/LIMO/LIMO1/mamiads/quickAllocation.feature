@regression @LIMO1 @LIMO1-staging
Feature: Quick Allocation on Properti Saya


  @TEST_LIMO-261
  Scenario: Verify ads ON but full occupancy
    #quickAllocation from mamiAds dashboard
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 083176408449 | 0          | qwerty123 |
    When user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And owner select filter active mamiads
    Then user cek status toggle iklan "Kos Jajajadooo Segun Sorong" is "Naik"
    And user verify the toggle iklan "Kos Jajajadooo Segun Sorong" is "on"
    And user verify the wording iklan penuh "Kos Jajajadooo Segun Sorong" is "Kamar Penuh. Silahkan nonaktifkan jika tidak ingin menaikkan posisi iklan ini"
    #quickAllocation from kos page
    When owner navigates to property saya kos
    And owner search kost "Kos Jajajadooo Segun Sorong" on property saya page
    And user click Lihat Selengkapnya button for edit
    Then user verify the alokasi title is "MamiAds Aktif"
    And user verify the toggle is "on"
    And user verify the wording ads is "Kamar penuh."
    And user click Lihat Selengkapnya button for edit
    Then user verify the alokasi title is "MamiAds Aktif"
    And user verify the toggle is "on"
    And user verify the wording ads is "Kamar penuh."