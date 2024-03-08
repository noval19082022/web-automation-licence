@DOM1
Feature: Probut Discount Management

  @TEST_COOP-6469
  Scenario: [Web][Probut][Discount Management] Upload Discount Not Fill discount_type_mamikos and mamkos_price
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_discount_not_fill_discount_type_mamikos_and_mamkos_price.csv"
    Then admin should be able to see the text "Success! File processed successfully."