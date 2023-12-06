@DOM4 @flashsale
Feature: Flash Sale

  @TEST_DOM-161
  Scenario: Check Flash Sale Section On Homepage
    Given user go to mamikos homepage
    When user scroll into promo kost section
    Then user will see promo ngebut info on kost card

  @TEST_DOM-157
  Scenario: User can visit promo ngebut landing page
    Given user navigates to promo ngebut landing page
    Then user can see flash sale landing page
    Then user will see promo ngebut info on kost card

  @TEST_DOM-159
  Scenario: User can visit promo ngebut landing area
    Given user navigates to promo ngebut landing area
    Then user can see flash sale landing area
    Then user will see promo ngebut info on kost card

  @TEST_DOM-4048
  Scenario: User can use Cari Kos Promo Ngebut button
    Given user navigates to promo ngebut landing page
    When user go to promo landing area from Cari Kos Promo Ngebut button
    Then user will see promo ngebut info on kost card
    Then user can see url link is for Cari Kos Promo Ngebut

  @TEST_DOM-5230
  Scenario: User can use Cari Sekarang button
    Given user navigates to promo ngebut landing page
    When user go to promo landing area from Cari Sekarang button
    Then user can see url link is for Cari Sekarang
    Then user will see promo ngebut info on kost card

  @TEST_DOM-5231
  Scenario: User can see promo ngebut pop-up on kos details
    Given user navigates to promo ngebut landing area
    When user go to kost details from promo ngebut list
    Then user can see promo ngebut pop-up

  @TEST_COOP-3290
  Scenario: [Home Page][WEB]Promo ngebut Nominal discount and atribute (with section)
    Given user go to mamikos homepage
    When user will see promo ngebut info on kost card
    Then user can see Promo Ngebut discount in nominal amount with normal price with strikethrough and "(Bulan pertama)" text on homepage