@regression @LIMO3 @listing-monetization @createKosFotoKamar @essentialTest3 @DONEMIGRATINGTONEWBOARD

Feature: Form Add New Kos

  @TEST_LIMO-849 @continue
  Scenario: [Form add New Kost][Foto Kos]Update, delete, and moved photo kos
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner fills valid data kos as expected
      | kos name             | room type check | room type name | kos type | description kos      | build kos | other note                   |
      | Kos Draft Foto Kamar | yes             | tipe A         | boy      | Kos draft foto kamar | 2020      | Akan dihapus setelah terbuat |
    When owner click Lanjutkan for input kos address
    And owner click on leftlet marker
    And owner click lanjutkan button for next steps
    And user clicks on the close button
    And owner upload valid photo "bangunan tampak depan"
    And owner clicks button change photo
    And owner clicks button delete photo
    And owner upload valid photo "bangunan tampak depan"
    And owner clicks button move photo
    And owner select destination move photo kos
    And owner select destination move photo room on "Foto tampilan dalam bangunan"


  @TEST_LIMO-856
  Scenario: [Form add New Kost][Foto Kamar]Update, delete, and moved room photo
    And owner upload valid photo "bangunan tampak depan"
    And owner upload valid photo "tampak dari jalan"
    And owner click lanjutkan button for next steps
    And owner upload valid photo "depan kamar"
    And owner clicks button change photo
    And owner clicks button delete photo
    And owner upload valid photo "depan kamar"
    And owner clicks button move photo
    And owner select destination move photo kos
    And owner select destination move photo room on "Foto dalam kamar"


  Scenario: Delete new kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed
#












