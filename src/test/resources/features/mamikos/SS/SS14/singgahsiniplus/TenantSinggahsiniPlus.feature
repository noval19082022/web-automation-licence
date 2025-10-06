@SS14 @a
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

  @TEST_SS-9191
  Scenario: [Web][Singgahsini+] Entry Point Singgahsini for tenant P1 user Active
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 08100000704 | qwerty123 |
    And tenant click on icon profil
    And tenant click on profile
    Then tenant can see "Starter" label
    When tenant clicks on Singgahsini text



