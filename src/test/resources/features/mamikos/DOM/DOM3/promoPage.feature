@promo

Feature: Promo page

#  this promo cant be applicable because on promo.mamikos.com There are no promotions available yet

  @DOM3 @TEST_DOM-311 @Automated @DOM3 @web-covered
  Scenario: User can copy promo code
    Given user navigates to promo mamikos
#    When user click SALIN on any promo
#    Then promo code can be copied "MABA100RB"

  @regression
  Scenario: Check pagination in promo page
    Given user navigates to promo mamikos
#    When user click next page button
#    And next promo page will be opened
#    And user click previous page button
#    And previous promo page will be opened
#    And user click page index "2"
#    Then promo page "2" will be opened
#
#  @regression
#  Scenario: User can open promo detail
    Given user navigates to promo mamikos
#    And user see the promo title in first promo
#    When user click see detail on first promo
#    Then detail promo page opened with correct title
#    And user see button booking now