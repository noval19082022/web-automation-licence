@regression @mamipoinTenant @BBM3

Feature: MamiPoin Tenant Dapatkan Poin Page

  @TEST_BBM-416 @TEST_BBM-414 @continue
  Scenario: Tenant already on Dapatkan Poin page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321215 | 0890867321215 | mamikosqa123 |
    And tenant navigate to mamipoint guideline page
    Then user verify title in the dapatkan poin page is displayed
    And user verify tab petunjuk in the dapatkan poin page is displayed
    And user verify tab syarat dan ketentuan in the dapatkan poin page is displayed
    And user verify link pusat bantuan in the dapatkan poin page is displayed

  @BBM-422 @continue
  Scenario: Headline on Dapatkan Poin Page
    Then user verify dapatkan poin headline "Cara Mudah Mendapatkan MamiPoin"
    And user verify dapatkan poin subtitle "Kamu bisa mengumpulkan MamiPoin dengan melakukan aktivitas-aktivitas		berikut."

  @BBM-423 @continue
  Scenario: Content on Dapatkan Poin Page
    Then user verify content on dapatkan poin page

  @BBM-425 @continue
  Scenario: Scroll down behavior
    Then user verify only the header that is sticky or "fixed"

  @BBM-419 @BBM-421 @continue
  Scenario: Syarat dan ketentuan link redirection
    When user click on tab Syarat dan Ketentuan
    Then user verify "Syarat dan Ketentuan" has "active" attribute

  @BBM-417 @continue
  Scenario: Pusat Bantuan redirection
    When tenant navigate to mamipoint guideline page
    Then user verify title in the dapatkan poin page is displayed
    When user clicks link on pusat bantuan
    Then user redirected to "https://jambu.kerupux.com/user/mamipoin/guideline"
