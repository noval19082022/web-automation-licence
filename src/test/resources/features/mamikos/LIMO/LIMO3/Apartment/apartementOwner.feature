@regression @LIMO-3 @listing-monetization


Feature: Apartment - Owner Page

  @TEST_LIMO-2720 @apartementOwner
  Scenario: Check apartement owner page
    #doesnt have apartment
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0876623622 | 0          | qwerty123 |
    When owner navigates to property saya apartemen
    Then owner can see emphty property

  @apartementOwner
  Scenario: Check seacrh apartement at owner page
    #diperiksa Admin
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 082233545517 | 0          | qwerty123 |
    When owner navigates to property saya apartemen
    And owner search apart "Apartemen Automation Diperiksa Admin" on property saya page
    Then verify status apartemen "Diperiksa Admin"

    #ditolak
    When owner navigates to property saya apartemen
    And owner search apart "Apartemen Automation Web Ditolak" on property saya page
    Then verify status apartemen "Ditolak"
    And owner can see "Alasan ditolak :" at apartment card

    #aktif
    When owner navigates to property saya apartemen
    And owner search apart "Apartemen Automations 01 Web" on property saya page
    Then verify status apartemen "Aktif"
    And owner can see button update kamar






