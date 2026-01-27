@regression @LIMO1 @LIMO1-staging @DONEMIGRATINGTONEWBOARD @QuickAllocation
Feature: Quick Allocation on Properti Saya

  @TEST_LIMO-3379
  Scenario: Verify ads ON but full occupancy
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 083176408449 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And owner choose filter iklan saya to "Iklan Aktif"
    Then user cek status toggle iklan "Kos Jajajadooo Segun Sorong" is "Naik"
    * user verify the toggle iklan "Kos Jajajadooo Segun Sorong" is "on"
    * user verify the wording iklan kamar penuh "Kos Jajajadooo Segun Sorong" is "Kamar Penuh. Silahkan nonaktifkan jika tidak ingin menaikkan posisi iklan ini"
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

  @TEST_LIMO-5733
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

  @TEST_LIMO-1388
  Scenario: Cancel Quick Allocation on Listing has never been promoted before
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 082233545507 | 0          | 12345678 |
    And owner navigates to property saya kos
    When owner search kost "Kost Automation GP 2 Depok Sleman" on property saya page
    Then verify quick allocation section while never allocate
    And user cancel quick allocate the ads never allocate

  @TEST_LIMO-1385
  Scenario: Owner cancel reactivates ads for a listing that was previously toggled on (status off by owner)
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 085951394565 | 0          | qwerty123 |
    And owner navigates to property saya kos
    And owner Deactive ads quick alocation if active "Kos Quick Allocate Tipe Daily Tobelo Halmahera Utara"
    When owner search kost "Kos Quick Allocate Tipe Daily Tobelo Halmahera Utara" on property saya page
    Then verify quick allocation section while ads last allocation "daily"
    When user cancel quick allocate the ads ever allocate
    And user close mamiads onboarding popup
    Then verify redirect to mamiads dashboard
    * user cek status toggle iklan "Kos Quick Allocate Tipe Daily Tobelo Halmahera Utara" is "Tidak Naik"

    #cancel allocate ads maximal allocation
    And owner navigates to property saya kos
    And owner Deactive ads quick alocation if active "Kos Quick Allocate Tipe Maksimal Tobelo Halmahera Utar"
    When owner search kost "Kos Quick Allocate Tipe Maksimal Tobelo Halmahera Utara" on property saya page
    When user cancel quick allocate the ads ever allocate
    Then verify redirect to mamiads dashboard
    * user cek status toggle iklan "Kos Quick Allocate Tipe Maksimal Tobelo Halmahera Utara" is "Tidak Naik"

  @TEST_LIMO-1386
  Scenario Outline: Reactive allocation and nonaktif allocation ads while ever allocation
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 085951394565 | 0          | qwerty123 |
    And owner navigates to property saya kos
    And owner Deactive ads quick alocation if active "<kosName>"
    When owner search kost "<kosName>" on property saya page
    Then verify quick allocation section while ads last allocation "<allocationType>"
    When user reactive the allocation of ads
    Then verify the ads Aktif MamiAds with "<allocationType>" allocation
    When user nonactive the allocation of ads
    Then verify quick allocation section while ads last allocation "<allocationType>"
    Examples:
      | kosName                                                 | allocationType |
      | Kos Quick Allocate Tipe Daily Tobelo Halmahera Utara    | daily          |
      | Kos Quick Allocate Tipe Maksimal Tobelo Halmahera Utara | maksimal       |

  @TEST_LIMO-1505
  Scenario: [Property Saya][MamiAds][Saldo > 5000]: If full occupancy update room available
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 085951394565 | 0          | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kos Quick Allocate Tipe Full Occupancy Tobelo Halmahera Utara" on property saya page
    When user click Lihat Selengkapnya button for edit
    * user verify the wording ads is "Kamar Sudah Penuh."

  @TEST_LIMO-1503
  Scenario: [Property Saya Kos][MamiAds][Saldo mamiads 0]: Owner ever allocate and ever paid mamiads
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 082233545511 | 0          | 12345678 |
    And owner navigates to property saya kos
    When owner search kost "Kost A 123 Depok Sleman" on property saya page
    Then user verify the alokasi title is "Beli Saldo MamiAds"
    * user verify the wording ads is "Pakai MamiAds, bisa naikkan posisi iklan Anda lho. Beli sekarang!"
    When user click Lihat Selengkapnya button for edit
    Then user verify the alokasi title is "Beli Saldo MamiAds"
    * user verify the wording ads is "Pakai MamiAds, bisa naikkan posisi iklan Anda lho. Beli sekarang!"
    * user verify the redirection to list mamiads balance