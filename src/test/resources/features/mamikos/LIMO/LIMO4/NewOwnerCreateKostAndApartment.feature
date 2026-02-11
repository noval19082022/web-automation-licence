@regression @LIMO4 @newOwnerCreateApartment
Feature: New Owner Create Kost and Apartment

  @TEST_LIMO-3441 @backPage @continue
  Scenario: New Owner wants to click back after at page create kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0876623622 | 0876623622 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And user click back button in page
    Then check the header menu display on homepage owner

  @TEST_LIMO-3442 @icnClose @continue
  Scenario: Click button close on screen "Pilih Jenis Properti"
    And owner click tambah data iklan "Kost"
    And user click icon close on page pilih jenis properti
    Then check the header menu display on homepage owner

  @TEST_LIMO-3440 @formAddKosWhenKos0
  Scenario: Add new kost from Menu Kos (property kos == 0)
    When owner navigates to property saya kos
    And user selects "Kost" option and click on Add Data button
    And user click add new kos button
    Then user should redirect to link "https://owner-jambu.kerupux.com/kos/create?step=1"