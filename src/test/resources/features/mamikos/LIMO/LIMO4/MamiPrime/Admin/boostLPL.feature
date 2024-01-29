@LIMO4 @regression
Feature: Admin Boost LPL

  @TEST_LIMO-4334 @continue @boostLpl
  Scenario: [WEB][Admin] As an admin, I would like to read all the listings that are currently being LPL score boosted
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                     | email prod | password  |
      | uncle.limo2@admin-mamiteam.com |            | qwerty123 |
    When admin accsess menu boot LPL
    Then admin can see data kost already boosted with list view

  @TEST_LIMO-4335 @boostLpl @continue
  Scenario: [WEB][Admin]As an admin, I would like to search for a listing that is currently being LPL score boosted
      #search by kost ID
    When admin wants to search kost with kost id "1000034428"
    Then admin succsess see result search
      #search by name kost
    When admin wants to search kost with kost name "Property Android ARAC buat baru android Depok Sleman"
    Then admin succsess see result search by kost name
     #search data not exist
    When admin wants to search kost with kost id "001092477535"
    Then admin see information not found
    When admin wants to search kost with kost name "Property xxx123"
    Then admin see information not found