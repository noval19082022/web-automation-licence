@LIMO4 @apartmentTenantDetails
Feature: Apartment Tenant

  @TEST_LIMO-3663 @continue
  Scenario: [Favorit][Mungkin cocok untuk Anda]: Lihat detail properti of apartemen and there is show "rekomendasi"
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod | password  |
      | 08119787888 |            | qwerty123 |
    And tenant redirect to apartment details:
      | environment | apartment path                                      |
      | stag        | /apartemen-kalibata-city/silalay-123-1room-studio-1 |
      | prod        | /apartemen-kalibata-city/silalay-123-1room-studio-1 |
    When user click on favorite btn on the apartment detail
    Then user get success message "Sukses tersimpan"
    And tenant navigate to favorite page
    Then tenant will see that the text "Silalay 123" is displayed
    And tenant should not be able to see the text "Mungkin cocok dengan kamu"

  @TEST_LIMO-3664
  Scenario: [Favorit][Mungkin cocok untuk Anda]: Show "Rekomendasi" based on terakhir dilihat tenant while tenant NEVER favorit properti
    Given user go to mamikos homepage
    And tenant redirect to apartment details:
      | environment | apartment path                                      |
      | stag        | /apartemen-kalibata-city/silalay-123-1room-studio-1 |
      | prod        | /apartemen-kalibata-city/silalay-123-1room-studio-1 |
    When user click on unfavorite btn on the apartment detail
    And tenant navigate to favorite page
    Then tenant should not be able to see the text "Silalay 123"
    And tenant should not be able to see the text "Mungkin cocok dengan kamu"