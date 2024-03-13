@COOP-5027 @COOP3
Feature: MamiPoin Tenant Informasi Poin Page


  @TEST_COOP-5032 @TESTSET_COOP-4944 @Automated @web @continue
  Scenario: MamiPoin Tenant Informasi Poin Page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 08999444999 | 0890867321215 | qwerty123 |
    And tenant navigate to mamipoint expired page
    Then user verify title in the informasi poin page is displayed
    And user verify subtitle in the informasi poin page is displayed
    And user verify table title tanggal kedaluwarsa is displayed
    And user verify table title jumlah mamipoin is displayed

  @TENG-187
  Scenario: Description on Tanggal Kedaluwarsa
    Then user verify expired point on information point page
      | 31 Agt 2024 |

  @TEST_TENG-200 @TEST_BBM-413 @TEST_TENG-201 @TEST_BBM-405
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
		
