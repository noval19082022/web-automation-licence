@essentialTest2

Feature: [PMAN] Essential Test Ownersini

  @TEST_SS-723
  Scenario: Check Access Point SS Dashboard which Owner has Pillar 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 085577872323 | 085600867992 | qwerty123 |
    And owner clicks Kembali ke Mamikos on top right corner Profil
    Then owner redirect to Owner Dashboard Pillar 2
    When owner clicks Dashboard Singgahsini on top right corner Profil
    Then owner redirect to Owner Dashboard Pillar 1

  @TEST_SS-806
  Scenario: Check Access Point SS Dashboard which Owner does not have Pillar 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password     |
      | 0890000003434 | Bismillah@01 |
    And owner clicks on top right corner Profil Pillar 2
    Then Dashboard Singgahsini button is not displayed

  @TEST_SS-762
  Scenario: Check Redirection to Owner Pillar 2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089712123030 | 089712123030 | qwerty123 |
    And owner clicks Kembali ke Mamikos on top right corner Profil
    Then owner redirect to Owner Dashboard Pillar 2

  @TEST_SS-722
  Scenario: Owner P1 log out from Ownersini Dashboard
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089712123030 | 089712123030 | qwerty123 |
    And owner logout from ownersini dashboard
    Then owner redirect to login pemilik page

  @TEST_SS-810
  Scenario: Owner P1 log out from Owner Dashboard P2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089712123030 | 089712123030 | qwerty123 |
    And owner clicks Kembali ke Mamikos on top right corner Profil
    Then owner redirect to Owner Dashboard Pillar 2
    When owner logs out
    Then owner redirect to login pemilik page