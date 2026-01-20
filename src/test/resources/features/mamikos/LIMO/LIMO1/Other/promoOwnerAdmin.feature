@promo @regression @promoOwnerAdmin @LIMO1

Feature: Promo Owner Admin BangKerupux

  @TEST_LIMO-3656
  Scenario: As Admin, wants to create promo iklan for owner at admin page
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

  @TEST_LIMO-3657
  Scenario:Check promo owner on tenant page
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                           |
      | Kos Promo Owner Automation Tipe Promo Satu Kretek Bantul |
    Then tenant verify the promo displayed is "Title Promo Owner"

  Scenario: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Kost Beth Harmon Tipe A Kretek Bantul" on search box
    And admin delete the promo admin

  @TEST_LIMO-3658
  Scenario: As Admin, wants to create promo iklan for owner at admin page with confirmation false not visible on tenant
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin accsess menu promo owner to create promo owner
    And admin fill "Kost Beth Harmon Tipe A Kretek Bantul" at search kost form
    And admin fills valid data promo owner as expected
      | title             | content                                             | start-date | end-date               |
      | Title Promo Owner | Ini adalah promo owner yang disi dari halaman admin | tomorrow   | the day after tomorrow |
    And admin clicks on ceate promotion
    Then admin successfully add promo owner
    When admin search the title promo "Kost Beth Harmon Tipe A Kretek Bantul" on search box
    Then admin verify the status promo is No verification admin
    When admin click on action show and edit promo owner
    Then admin verify the confirmation is "false"

  Scenario:Check promo owner on tenant page
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                        |
      | Kost Beth Harmon Tipe A Kretek Bantul |
    Then user not see promo owner on "kost" detail

  Scenario: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Kost Beth Harmon Tipe A Kretek Bantul" on search box
    And admin delete the promo admin

  @TEST_LIMO-3659
  Scenario Outline: As Admin, wants to create promo iklan for owner at admin page with confirmation true and not visible on tenant
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin accsess menu promo owner to create promo owner
    And admin fill "<propertyName>" at search kost form
    And admin fills valid data promo owner as expected
      | title             | content                                             | start-date | end-date               |
      | Title Promo Owner | Ini adalah promo owner yang disi dari halaman admin | tomorrow   | the day after tomorrow |
    And admin clicks on ceate and verify promotion
    Then admin successfully add promo owner
    When admin search the title promo "<propertyName>" on search box
    And admin click on action show and edit promo owner
    Then admin verify the confirmation is "true"
    Examples:
      | propertyName                               |
      | Kos Upik Scamander Tipe Puan Selo Boyolali |
      | Apartemen Upik Enam Nol Delapan            |

  Scenario:Check promo owner on tenant page
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                             |
      | Kos Upik Scamander Tipe Puan Selo Boyolali |
    Then user not see promo owner on "kost" detail

#  Scenario: Check promo owner on detail apartemen tenant page
#    Given user go to mamikos homepage
#    And tenant search apart then go to apartemen details:
#      | apart name stag                 |
#      | Apartemen Upik Enam Nol Delapan |
#    Then user not see promo owner on "apartemen" detail

  Scenario Outline: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "<propertyName>" on search box
    And admin delete the promo admin
    Examples:
      | propertyName                               |
      | Kos Upik Scamander Tipe Puan Selo Boyolali |
      | Apartemen Upik Enam Nol Delapan            |

  @TEST_LIMO-92 @RunPromoOwnerDuplicate @continue
  Scenario: As Admin, wants to create promo iklan for owner at admin page when owner already have promo ongoing
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin accsess menu promo owner to create promo owner
    And admin fill "Kost komplit desta Tobelo Halmahera Utara" at search kost form
    And admin fills valid data promo owner as expected
      | title                               | content                                             | start-date | end-date               |
      | Title Promo Owner LIMO 92 duplicate | Ini adalah promo owner yang disi dari halaman admin | tomorrow   | the day after tomorrow |
    And admin clicks on ceate and verify promotion
    Then admin successfully add promo owner
    When admin search the title promo "Kost komplit desta Tobelo Halmahera Utara" on search box
    And admin will see that the text "Title Promo Owner LIMO 92 duplicate" is displayed

  @RunPromoOwnerDuplicate
  Scenario: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Title Promo Owner LIMO 92 duplicate" on search box
    And admin delete the promo admin

  @TEST_LIMO-93 @RunPromoOwnerSameday @continue
  Scenario: As Admin, wants to create promo iklan for owner at admin page with start date == end date and have another promo
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin accsess menu promo owner to create promo owner
    And admin fill "Kost komplit desta Tobelo Halmahera Utara" at search kost form
    And admin fills valid data promo owner as expected
      | title                             | content                                             | start-date | end-date |
      | Title Promo Owner LIMO 93 sameday | Ini adalah promo owner yang disi dari halaman admin | tomorrow   | tomorrow |
    And admin clicks on ceate and verify promotion
    Then admin successfully add promo owner
    When admin search the title promo "Kost komplit desta Tobelo Halmahera Utara" on search box
    And admin will see that the text "Title Promo Owner LIMO 93 sameday" is displayed

  @RunPromoOwnerSameday
  Scenario: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Title Promo Owner LIMO 93 sameday" on search box
    And admin delete the promo admin

  @TEST_LIMO-94 @RunPromoOwnerConfirmTrue @continue
  Scenario: As Admin, wants to create promo iklan for owner at admin page with confirmation true but have another promo
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin accsess menu promo owner to create promo owner
    And admin fill "Kost komplit desta Tobelo Halmahera Utara" at search kost form
    And admin fills valid data promo owner as expected
      | title                             | content                                             | start-date | end-date |
      | Title Promo Owner LIMO 94 confirm | Ini adalah promo owner yang disi dari halaman admin | tomorrow   | tomorrow |
    And admin clicks on ceate and verify promotion
    Then admin successfully add promo owner
    When admin search the title promo "Kost komplit desta Tobelo Halmahera Utara" on search box
    And admin will see that the text "Title Promo Owner LIMO 94 confirm" is displayed
    And admin click on action show and edit promo owner
    Then admin verify the confirmation is "true"

  @RunPromoOwnerConfirmTrue
  Scenario: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Title Promo Owner LIMO 94 confirm" on search box
    And admin delete the promo admin

  @TEST_LIMO-95 @RunPromoOwnerConfirmFalse @continue
  Scenario: As Admin, wants to create promo iklan for owner at admin page with confirmation false but have another promo
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin accsess menu promo owner to create promo owner
    And admin fill "Kost komplit desta Tobelo Halmahera Utara" at search kost form
    And admin fills valid data promo owner as expected
      | title                                   | content                                             | start-date | end-date |
      | Title Promo Owner LIMO 95 false confirm | Ini adalah promo owner yang disi dari halaman admin | tomorrow   | tomorrow |
    And admin clicks on ceate promotion
    Then admin successfully add promo owner
    When admin search the title promo "Kost komplit desta Tobelo Halmahera Utara" on search box
    And admin will see that the text "Title Promo Owner LIMO 95 false confirm" is displayed
    Then admin verify the status promo is No verification admin
    When admin click on action show and edit promo owner
    Then admin verify the confirmation is "false"

  @RunPromoOwnerConfirmFalse
  Scenario: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Title Promo Owner LIMO 95 false confirm" on search box
    And admin delete the promo admin