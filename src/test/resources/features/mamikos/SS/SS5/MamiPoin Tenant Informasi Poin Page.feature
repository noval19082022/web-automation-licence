@SS-5027 @SS5
Feature: MamiPoin Tenant Informasi Poin Page


  @SS-5057 @continue
  Scenario: MamiPoin Tenant Informasi Poin Page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod    | password  |
      | 08123000002 | 0890867321215 | qwerty123 |
    And tenant navigate to mamipoint expired page
    Then user verify title in the informasi poin page is displayed
    And user verify subtitle in the informasi poin page is displayed
    And user verify table title tanggal kedaluwarsa is displayed
    And user verify table title jumlah mamipoin is displayed

  @SS-5058
  Scenario: Description on Tanggal Kedaluwarsa
    Then user verify expired point on information point page
      | 30 Sep 2025 |

  @SS-5059
  Scenario: MamiPoin Tenant Informasi Poin Page When the User Poin is Empty
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321220 | 0890867321220 | mamikosqa123 |
    And tenant navigate to mamipoint expired page
    Then user verify title in the informasi poin page is displayed
    And user verify subtitle in the informasi poin page is displayed
    And user verify subtitle tidak ada poin yang tersedia is displayed
    And user verify only the header that is sticky or "fixed"
    When user clicks on lihat caranya button
    And user verify title in the dapatkan poin page is displayed
		
