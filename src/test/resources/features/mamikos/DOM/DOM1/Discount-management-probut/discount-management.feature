@DOM111
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

  @TEST_COOP-6470
  Scenario: [Web][Probut][Discount Management] Upload Discount Not Fill discount_type_owner And owner_price
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_discount_not_fill_discount_type_owner_and_owner_price.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_COOP-6471
  Scenario: [Web][Probut][Discount Management] Upload Discount mark_up_type is Different With discount_type
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_mark_up_type_is_different_with_discount_type.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_COOP-6472
  Scenario: [Web][Probut][Discount Management] Upload Discount Only Fill owner_price for price_type Yearly
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_only_filled_owner_price_for_price_type_yearly.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_COOP-6473
  Scenario: [Web][Probut][Discount Management] Upload Discount price_type is nominal but discont_type is percentage
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_price_type_is_nominal_but_discont_type_is_percentage.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_COOP-6474
  Scenario: [Web][Probut][Discount Management] Upload Discount Same Discount with Different Price
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_same_discount_with_different_price.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_COOP-6475
  Scenario: [Web][Probut][Discount Management] Upload Discount Same kost_id with Multiple price_type
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_same_kost_id_with_multiple_price_type.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_COOP-6476
  Scenario: [Web][Probut][Discount Management] Upload Discount bulk csv
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_success_bulk.csv"
    Then admin should be able to see the text "Success! File processed successfully."