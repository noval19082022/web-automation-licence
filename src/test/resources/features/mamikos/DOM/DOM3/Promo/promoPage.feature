@promo @DOM3

Feature: Promo page

  @DOM3 @TEST_COOP-5427 @Automated @DOM3 @web-covered
  Scenario: User can copy promo code
    Given user navigates to promo mamikos
    When user click SALIN on any promo
    Then promo code can be copied "SEWASINGGAHSINI"

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
  @regression
  Scenario: User can open promo detail
    Given user navigates to promo mamikos
    When user see the promo title in first promo
    And user click see detail on first promo
    And detail promo page opened with correct title "Lebih Hemat sewa pertama di Kos Singgahisini!"
    Then user see button booking now