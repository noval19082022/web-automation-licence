@regression @LIMO4
Feature: New Owner Create Kost and Apartment

  @backPage @continue
  Scenario: New Owner wants to click back after at page create kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password    |
      | 0876623622   | 0876623622   | qwerty123   |
    And user click menu "Tambah Properti" on feature waktunya mengelola property
    And user click back button in page
    Then check the header menu display on homepage owner

  @icnClose @continue
  Scenario: Click button close on screen "Pilih Jenis Properti"
    When user click menu "Tambah Properti" on feature waktunya mengelola property
    And user click icon close on page pilih jenis properti
    Then check the header menu display on homepage owner

  @formAddKosWhenKos0
  Scenario: Add new kost from Menu Kos (property kos == 0)
    When owner navigates to property saya kos
    And user selects "Kost" option and click on Add Data button
    And user click add new kos button
    Then user should redirect to link "https://owner-jambu.kerupux.com/kos/create?step=1"