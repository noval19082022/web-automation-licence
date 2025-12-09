@regression @LIMO3 @listing-monetization @createKosBBKandMamipayNotActive @essentialTest3 @DONEMIGRATINGTONEWBOARD

Feature: Create new kos with owner that doesn't activate mamipay and BBK

  @TEST_LIMO-3669 @CreateKosWithRemoteTrue
  Scenario: [Add New Kost][Mamipay]Check T&C remote condition with status true
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 085275574593 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner fills valid data kos as expected
      | kos name             | room type check | room type name | kos type | description kos                   | build kos | other note                   |
      | Kost noBBK noMamipay | no              |                | boy      | kos harusnya Kost noBBK noMamipay | 2020      | Akan dihapus setelah terbuat |
    And owner set rules kos:
      | Ada jam malam |
    And owner upload rule kos
    And owner upload valid rule kos
    Then verify warning upload gagal disappear
    When owner click Lanjutkan for input kos address
    And owner click on leftlet marker
    And owner click lanjutkan button for next steps
    And user clicks on the close button
    And owner invalid upload photo "bangunan tampak depan"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner invalid upload photo "tampilan dalam bangunan"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner invalid upload photo "tampak dari jalan"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner click lanjutkan button for next steps
    And owner invalid upload photo "depan kamar"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner invalid upload photo "dalam kamar"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner invalid upload photo "kamar mandi"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner click lanjutkan button for next steps
    And user check facilities under "Fasilitas Umum"
      | Dapur |
    And user check facilities under "Fasilitas Kamar"
      | AC |
    And user check facilities under "Fasilitas Kamar Mandi"
      | Bathup |
      | Gayung |
    And user check facilities under "Parkir"
      | Parkir Mobil |
    And owner click lanjutkan button for next steps
    And owner select size room "3 x 4"
    And owner input total room and room available as expected
      | total room | room available |
      | 15         | 10             |
    And owner click lanjutkan button for next steps
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 500000        | no                      |                   | no                |             |              |                     |                   |              |
    And owner click lanjutkan button for next steps
    Then verify the title on mamipay owner onboarding displayed
    When owner click Lanjutkan button
    Then owner see next button disable
    When owner navigates to owner dashboard
    And owner navigates to property saya kos
    Then user see kos with valid name, status "Draft" and type "Kos Putra"
    And owner click close icon pop up
    And user delete first kos on the list