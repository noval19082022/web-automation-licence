@DOM4 @flashsale
Feature: Flash Sale

  @TEST_COOP-5387
  Scenario: Check Flash Sale Section On Homepage
    Given user go to mamikos homepage
    When user scroll into promo kost section
    Then user will see promo ngebut info on kost card

  @TEST_COOP-5388
  Scenario: User can visit promo ngebut landing page
    Given user navigates to promo ngebut landing page
    Then user can see flash sale landing page
    Then user will see promo ngebut info on kost card

  @TEST_COOP-5386
  Scenario: User can visit promo ngebut landing area
    Given user navigates to promo ngebut landing area
    Then user can see flash sale landing area
    Then user will see promo ngebut info on kost card

  @TEST_COOP-5385
  Scenario: User can use Cari Kos Promo Ngebut button
    Given user navigates to promo ngebut landing page
    When user go to promo landing area from Cari Kos Promo Ngebut button
    Then user will see promo ngebut info on kost card
    Then user can see url link is for Cari Kos Promo Ngebut

  @TEST_COOP-5404
  Scenario: User can use Cari Sekarang button
    Given user navigates to promo ngebut landing page
    When user go to promo landing area from Cari Sekarang button
    Then user can see url link is for Cari Sekarang
    Then user will see promo ngebut info on kost card

  @TEST_COOP-5406
  Scenario: User can see promo ngebut pop-up on kos details
    Given user navigates to promo ngebut landing area
    When user go to kost details from promo ngebut list
    Then user can see promo ngebut pop-up

  @TEST_COOP-3290
  Scenario: [Home Page][WEB]Promo ngebut Nominal discount and atribute (first month)
    Given user go to mamikos homepage
    When user will see promo ngebut info on kost card
    Then user can see Promo Ngebut discount in nominal amount with normal price with strikethrough and "(Bulan pertama)" text on homepage

  @TEST_COOP-3292 @continue
  Scenario: [Home Page][WEB]Promo ngebut Nominal discount and atribute (other than first month)
    Given user go to mamikos homepage
    When user will see promo ngebut info on kost card
    Then user can see Promo Ngebut discount in nominal amount without normal price with strikethrough and "sewa 3 bulan" text on homepage

  @TEST_COOP-4948
  Scenario: [Home Page][WEB]Visit Detail Kost that has Promo ngebut From Homepage (first month)
    Given user go to mamikos homepage
    When user will see promo ngebut info on kost card
    Then user can see Promo Ngebut discount in nominal amount with normal price with strikethrough and "(Bulan pertama)" text on homepage
    And user visit kost detail that has promo bulan pertama from homepage
    Then user will see that the text "(Bulan pertama)" is displayed

  @TEST_COOP-4949
  Scenario: [Home Page][WEB]Visit Detail Kost that has Promo ngebut From Homepage (other than first month)
    Given user go to mamikos homepage
    When user will see promo ngebut info on kost card
    Then user can see Promo Ngebut discount in nominal amount without normal price with strikethrough and "sewa 3 bulan" text on homepage
    And user visit kost detail that has promo other than bulan pertama from homepage
    Then user will see that the text "sewa 3 bulan" is displayed