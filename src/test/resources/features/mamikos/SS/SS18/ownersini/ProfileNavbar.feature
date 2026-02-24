@regression @SS16 @ownersini @profilNavbar

Feature: Profile Navbar

  @TEST_SS-762 @SS1-prod @continue
  Scenario: Check Redirection to Owner Pillar 2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089712123030 | 089712123030 | qwerty123 |
    And owner clicks Kembali ke Mamikos on top right corner Profil
    Then owner redirect to Owner Dashboard Pillar 2

  @TEST_SS-750 @SS1-prod @continue
  Scenario: Check Profil Page
    When owner clicks Dashboard Singgahsini on top right corner Profil
    Then owner redirect to Owner Dashboard Pillar 1
    #Information profil section
    When user clicks Profil menu
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

  @TEST_SS-794
  Scenario: Check Room Type
    When user clicks Tipe Kamar menu
    Then the Room Type and Room Total section in Room Type is displayed