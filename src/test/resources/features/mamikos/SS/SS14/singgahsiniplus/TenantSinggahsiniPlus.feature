@SS14
Feature: Singgahsini Plus

  @TEST_SS-9190
  Scenario: [Web][Singgahsini+] Entry Point Singgahsini for tenant non P1 user
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 08100000707 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    Then tenant can see "Baru" label
    When tenant should see Singgahsini Plus summary card
    Then tenant should see tier message in Singgahsini plus with "Makin lama ngekos di Singgahsini/APIK, makin banyak poin yang kamu dapat."
    When tenant clicks on Singgahsini text
    Then tenant can see tier message description on singgahsini page is visible

  @TEST_SS-9191 @continue
  Scenario: [Web][Singgahsini+] Entry Point Singgahsini for tenant P1 user Active
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 08100000704 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    Then tenant can see "Starter" label

  @TEST_SS-9194
  Scenario: [Web][Singgahsini+] Singgahsini+ Page Tab Layout Active
    When tenant clicks on Singgahsini text
    Then tenant can see tier active with "Level kamu saat ini"
    When tenant can see tier active with "Level 1: Starter"
    Then tenant can see tier active with "Lanjut ngekos sampai 27 hari untuk naik ke level dan dapat"

  @TEST_SS-9192
  Scenario: [Web][Singgahsini+] Entry Point Singgahsini for tenant P1 user Paused
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 08100000705 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    Then tenant can see "Baru" label
    When tenant can see "Basic" label
    Then tenant should see tier message in Singgahsini plus with "Level & rewards dijeda"
    When tenant clicks on Singgahsini text
    Then tenant can see paused allert with "Level Singgahsini+ dijeda karena kamu check-out dari Singgahsini/APIK. Balik ngekos untuk aktifkan lagi."

