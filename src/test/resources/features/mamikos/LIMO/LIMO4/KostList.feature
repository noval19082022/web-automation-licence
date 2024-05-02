@regression @LIMO4 @EX-LG

Feature: Kost List

  @ComponentActiveKos @TEST_LIMO-5813
  Scenario: Check components of active kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password   |
      | 083176408311   | 083132824758   | qwerty123  |
    And owner navigates to property saya kos
    And owner search kost "Kose Putri AutomationEeJwe Ibu Halmahera Barat" on property saya page
    Then user see kos with name "Kose Putri AutomationEeJwe Ibu Halmahera Barat", status "Aktif" and type "Kos Putra"
    When user click see kos button
    Then user should redirect to link "https://jambu.kerupux.com/room/kost-kabupaten-halmahera-barat-kost-putra-murah-kose-putri-automationeejwe-ibu-halmahera-barat-1"
    When user click back button in page
    And owner search kost "Kose Putri AutomationEeJwe Ibu Halmahera Barat" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner can see favorited section
    And user click review in kost list
    Then user should redirect to link "https://jambu.kerupux.com/ownerpage/statistics/53684421#review"