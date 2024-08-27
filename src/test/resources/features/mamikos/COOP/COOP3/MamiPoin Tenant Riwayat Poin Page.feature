@COOP-5027 @COOP3
Feature: MamiPoin Tenant Riwayat Poin Page


  @SS-5063 @continue
  Scenario: Tenant already on Riwayat Poin page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321215 | 0890867321215 | mamikosqa123 |
    And tenant navigate to mamipoin history page
    Then user verify title in the riwayat poin page is displayed
    And user verify filter in the riwayat poin page is displayed
      | Semua            |
      | Poin Diterima    |
      | Poin Ditukar     |
      | Poin Kedaluwarsa |
    And user verify "b-tab__box-active" class on selected filter "Semua"

  @SS-5064 @continue
  Scenario: MamiPoin Grouped by Month
    Then user verify point history grouped by months
      | Januari 2024 |

  @SS-5065 @continue
  Scenario: Filter Poin Diterima
    When user click "Poin Diterima" filter
    Then user verify "b-tab__box-active" class on selected filter "Poin Diterima"

  @SS-5066 @continue
  Scenario: Filter Poin Ditukar
    When user click "Poin Ditukar" filter
    Then user verify "b-tab__box-active" class on selected filter "Poin Ditukar"

  @SS-5067
  Scenario: Filter Poin Kedaluwarsa
    When user click "Poin Kedaluwarsa" filter
    Then user verify "b-tab__box-active" class on selected filter "Poin Kedaluwarsa"

  @SS-5068
  Scenario: MamiPoin Tenant Riwayat Poin Page When the User Poin is Empty
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321220 | 0890867321220 | mamikosqa123 |
    And tenant navigate to mamipoin history page
    Then user verify title in the riwayat poin page is displayed
    And user verify filter in the riwayat poin page is displayed
      | Semua            |
      | Poin Diterima    |
      | Poin Ditukar     |
      | Poin Kedaluwarsa |
    And user verify title riwayat masih kosong is displayed
    And user verify subtitle riwayat masih kosong is displayed
		
