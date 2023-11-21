@regression @pman @ownersini @logout-redirection

  Feature: Ownersini - Logout Redirection

    @TEST_PMAN-8797
    Scenario: Owner not login yet but access ownersini
      When user navigates to ownersini
      Then user redirect to login pemilik page

    @TEST_PMAN-7762
    Scenario: Owner P1 log out from Ownersini Dashboard
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    |  phone prod    | password     |
        | 089712123030  |  089712123030  | qwerty123    |
      And owner logout from ownersini dashboard
      Then owner redirect to login pemilik page

    @TEST_PMAN-8798
    Scenario: Owner P1 log out from Owner Dashboard P2
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    |  phone prod    | password     |
        | 089712123030  |  089712123030  | qwerty123    |
      And owner clicks Kembali ke Mamikos on top right corner Profil
      Then owner redirect to Owner Dashboard Pillar 2
      When owner logs out
      Then owner redirect to login pemilik page

    @TEST_PMAN-8799
    Scenario: Owner P2 log out
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    |  phone prod    | password     |
        | 081362464341  |  081362464341  | 1d0lt3stb4ru |
      And owner logs out
      Then owner redirect to homepage mamikos