@DOM4 @flashsale
Feature: Flash Sale

  Scenario: Check Flash Sale Section On Homepage
    Given user go to mamikos homepage
    Then user see flash sale section

  Scenario: User can visit promo ngebut landing page
    Given user navigates to promo ngebut landing page
    Then user can see flash sale landing page


  Scenario: User can visit promo ngebut landing area
    Given user navigates to promo ngebut landing area
    Then user can see flash sale landing area

  Scenario: User can use Cari Kos Promo Ngebut button
    Given user navigates to promo ngebut landing page
    When user go to promo landing area from Cari Kos Promo Ngebut button
    Then user can see url link is for Cari Kos Promo Ngebut

  Scenario: User can use Cari Sekarang button
    Given user navigates to promo ngebut landing page
    When user go to promo landing area from Cari Sekarang button
    Then user can see url link is for Cari Sekarang

  Scenario: User can see promo ngebut pop-up on kos details
    Given user navigates to promo ngebut landing area
    When user go to kost details from promo ngebut list
    Then user can see promo ngebut pop-up