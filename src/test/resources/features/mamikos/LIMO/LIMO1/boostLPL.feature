@LIMO1 @regression
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

  @TEST_LIMO-4573 @boostLpl @continue
    Scenario: [WEB][Admin][Boost LPL] As Admin I would like to input kost full occupied
    #admin input kost status verified but full occupied
    When admin input kost name with "Create ios full occupied Tipe C Depok Sleman" at form add boost lpl
    Then the result from kost "Create ios full occupied Tipe C Depok Sleman" not show

  @TEST_LIMO-4572 @boostLpl
    Scenario: [WEB][Admin][Boost LPL] As Admin I would like to input kost not active
    #admin input kost status diperiksa admin
    When admin accsess menu boot LPL
    When admin input kost name with "Property ARAC Admin A" at form add boost lpl
    Then the result from kost "Property ARAC Admin A" not show

    #admin input kost status edited
    When admin accsess menu boot LPL
    When admin input kost name with "Property Fasilitas Kamar Kamar Mandi 5 Semarang Selatan Semarang" at form add boost lpl
    Then the result from kost "Property Fasilitas Kamar Kamar Mandi 5 Semarang Selatan Semarang" not show

    #admin input kost status draft
    When admin accsess menu boot LPL
    When admin input kost name with "Kost Alamat Required Tipe A Arjasari Bandung" at form add boost lpl
    Then the result from kost "Kost Alamat Required Tipe A Arjasari Bandung" not show