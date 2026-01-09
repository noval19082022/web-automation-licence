@SS14
Feature: Homepage

  @TEST_SS-3299 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check cari iklan dropdown items
    Given user go to mamikos homepage
    Then tenant can see ads dropdown option

  @TEST_SS-3298 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check profile dropdown items after login
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    Then tenant can see profile dropdown option

  @TEST_SS-3295 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection kebijakan privasi on homepage
    Given user go to mamikos homepage
    And user open kebijakan privasi in footer
    Then user should redirect to link that contains "kebijakan-privasi"

  @TEST_SS-3294 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection syarat dan ketentuan on homepage
    Given user go to mamikos homepage
    And user open syarat dan ketentuan in footer
    Then user should redirect to link that contains "syarat-dan-ketentuan"

  @TEST_SS-3303 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection tentang kami on homepage
    Given user go to mamikos homepage
    When user open tentang kami in footer
    Then user should redirect to link that contains "/tentang-kami"

  @TEST_SS-3300 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection job mamikos on homepage
    Given user go to mamikos homepage
    When user open job mamikos in footer
    Then user should redirect to link that contains "/career"

  @TEST_SS-3274 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection promosikan kost anda on homepage
    Given user go to mamikos homepage
    When user open promosikan kost anda in footer
    Then user should redirect to link that contains "/mamiads"

  @TEST_SS-3276 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection pusat bantuan on homepage
    Given user go to mamikos homepage
    When user open pusat bantuan in footer
    Then user should redirect to link "https://help.mamikos.com/"

  @TEST_SS-3277 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection facebook on homepage
    Given user go to mamikos homepage
    When user open facebook in footer
    Then user should redirect to link that contains "https://www.facebook.com/mamikosapp"

  @TEST_SS-3288 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection twitter on homepage
    Given user go to mamikos homepage
    When user open twitter in footer
    Then user should redirect to link that contains "https://x.com/mamikosapp"

  @TEST_SS-3284 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection instagram on homepage
    Given user go to mamikos homepage
    When user open instagram in footer
    Then user should redirect to link that contains "https://www.instagram.com"

  @TEST_SS-3280 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection e-mail on homepage
    Given user go to mamikos homepage
    When user open e-mail in footer
    Then user should redirect to link that contains "https://mamikos.com/tentang-kami?opencomplaintform=1"

  @TEST_SS-3287 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection whatsapp on homepage
    Given user go to mamikos homepage
    When user open whatsapp in footer
    Then user should redirect to link that contains "https://api.whatsapp.com/send/?phone=%2B6281325111171"

  @TEST_SS-3285 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check copyright on footer on homepage
    Given user go to mamikos homepage
    Then user can see copyright is "© 2026 Mamikos.com. All rights reserved"

  @TEST_SS-3302 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection Lihat semua on owner promo section
    Given user go to mamikos homepage
    When user see all owner promo
    Then user should redirect to link that contains "/promo-kost?city="

#	@TEST_COOP-4856 @Automated @SS14 @Web @discovery-platform @homepage
#	Scenario: [Dweb][Homepage]Check redirection Lihat semua on promo ads section
#		Given user go to mamikos homepage
#		When user see all promo ads
#		Then user should redirect to link "https://promo.mamikos.com/"

  @TEST_SS-3275 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection Download App menu on header
    Given user go to mamikos homepage
    When user open Download App menu
    Then user should redirect to link "https://play.google.com/store/apps/details?id=com.git.mami.kos"

  @TEST_SS-3151 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection Booking Kos menu on header
    Given user go to mamikos homepage
    When user open Booking Kos menu
    Then user should redirect to link that contains "/booking"

  @TEST_SS-3296 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection Popular Area - Jakarta
    Given user go to mamikos homepage
    When user open Popular Area in Jakarta
    Then user should redirect to link that contains "/kost/kost-jakarta-murah"

  @TEST_SS-3301 @Automated @SS14 @Web @discovery-platform @homepage
  Scenario: [Dweb][Homepage]Check redirection Around University - UGM
    Given user go to mamikos homepage
    When user open Around University in UGM
    Then user should redirect to link that contains "/kost/kost-dekat-ugm-murah"

  @TEST_SS-3152
  Scenario: Hompage-Lihat semua kost sekitar kampus
    Given user go to mamikos homepage
    When user go to lihat semua Sekitar Kampus
    Then Lihat semua kost sekitar kampus , there's this city :
      | city stag              | city prod              |
      | Jogja                  | Jogja                  |
      | Jakarta                | Jakarta                |
      | Bandung                | Bandung                |
      | Surabaya               | Surabaya               |
      | Kampus Favorit Lainnya | Kampus Favorit Lainnya |
      | Malang                 | Malang                 |
      | Semarang               | Semarang               |

  @TEST_SS-3149
  Scenario: Homepage - Lihat semua area kost populer
    Given user go to mamikos homepage
    When user go to lihat semua Area kost terpopuler
    Then Lihat semua kost sekitar kampus , there's this city :
      | city stag           | city prod           |
      | Kosan di Yogyakarta | Kosan di Yogyakarta |
      | Kosan di Surabaya   | Kosan di Surabaya   |
      | Kosan di Jakarta    | Kosan di Jakarta    |
      | Kosan di Bali       | Kosan di Bali       |
      | Kosan di Bandung    | Kosan di Bandung    |
      | Kosan di Malang     | Kosan di Malang     |
      | Kosan di Semarang   | Kosan di Semarang   |