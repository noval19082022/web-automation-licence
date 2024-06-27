Feature: Apartement Tenant

  @TEST_LIMO-228
  Scenario: [Favorit][Mungkin cocok untuk Anda]: Lihat detail properti of apartemen and there is show "rekomendasi"
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod | password  |
      | 08119787888 |            | qwerty123 |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | Silalay 123    |                |
    When user click on favorite btn on the apartment detail
    Then user get success message "Sukses tersimpan"
    And tenant navigate to favorite page
    Then tenant will see that the text "Silalay 123" is displayed
    And tenant should not be able to see the text "Mungkin cocok dengan kamu"
    ## unfavorite step
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | Silalay 123    |                |
    When user click on favorite btn on the apartment detail

