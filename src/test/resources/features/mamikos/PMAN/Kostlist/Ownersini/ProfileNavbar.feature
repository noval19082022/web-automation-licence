@regression @pman @ownersini @Bismillah

Feature: Profile Navbar

  @TEST_PMAN-5491 @pman-prod @continue
  Scenario: Check Redirection to Owner Pillar 2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    |  phone prod    | password     |
      | 089712123030  |  089712123030  | qwerty123    |
#    And owner clicks Kembali ke Mamikos on top right corner Profil
#    Then owner redirect to Owner Dashboard Pillar 2

  @TEST_PMAN-4947 @pman-prod
  Scenario: Check Profil Page
      #Information profil section
    And user clicks Profil menu
#    And the user clicks "Profil" menu
    Then the "Information Profil" is displayed
    #Scenario: Check Facility Section on Profil Page
    Then the "Facility Section" is displayed
    #Scenario: Check Kost Rules Section on Profil Page
    Then the "Kost Rules Section" is displayed
    #Scenario: Check Additional Fee Section on Profil Page
    Then the "Additional Fee Section" is displayed
    #Scenario: Check Additional Information Section on Profil Page
    Then the "Additional Informasion Section" is displayed
    #Scenario: Check Property Photo Section on Profil Page
    Then the "Property Photo section" is displayed