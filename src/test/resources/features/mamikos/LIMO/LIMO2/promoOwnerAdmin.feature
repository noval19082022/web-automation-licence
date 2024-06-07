@regression @promoOwnerAdmin @LIMO2 @listing-monetization

Feature: Promo Owner Admin BangKerupux

  @TEST_LIMO-3255
  Scenario:
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Kos Promo Owner Automation Tipe Promo Satu Kretek Bantul" on search box
    And admin accsess menu promo owner to create promo owner
    And admin fill "Kos Promo Owner Automation Tipe Promo Satu Kretek Bantul" at search kost form
#    And admin create new promo owner with title "Title Promo Owner" content "Ini adalah promo owner yang disi dari halaman admin" for periode promo "tomorrow"
    And admin fills valid data promo owner as expected
      | title             | content                                             | start-date | end-date               |
      | Title Promo Owner | Ini adalah promo owner yang disi dari halaman admin | tomorrow   | the day after tomorrow |
    And admin clicks on ceate and verify promotion
    Then admin successfully add promo owner

  Scenario:Check promo owner on tenant page
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                           |
      | Kos Promo Owner Automation Tipe Promo Satu Kretek Bantul |
    Then tenant verify the promo displayed is "Promo Teruss"

  Scenario: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Title Promo Owner" on search box
    And admin delete the promo admin