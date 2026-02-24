@promo @SS11

Feature: Promo page

#  @SS11 @TEST_SS-3027 @Automated @SS11 @web-covered @nonAktif
#  Scenario: User can copy promo code
#    Given user navigates to promo mamikos
#    When user click SALIN on any promo
#    Then promo code can be copied "SINGGAHEXPRESS"

  @regression @TEST_SS-3008
  Scenario: Check pagination in promo page
    Given user navigates to promo mamikos
#    When user click next page button
#    And next promo page will be opened
#    And user click previous page button
#    And previous promo page will be opened
#    And user click page index "2"
#    Then promo page "2" will be opened

  @regression @TEST_SS-3006 @SS11 @web-covered
  Scenario: User can open promo detail
    Given user navigates to promo mamikos
    When user see the promo title in first promo
    And user click see detail on first promo
    Then user see promo title
    And user see promo description