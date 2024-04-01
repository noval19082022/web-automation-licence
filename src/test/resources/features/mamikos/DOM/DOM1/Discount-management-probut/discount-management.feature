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

  @TEST_COOP-6477
  Scenario: [Web][Probut][Discount Management] Delete Discount bulk csv
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin remove using csv discount management with file names "delete_bulk.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_COOP-6478
  Scenario: [Web][Probut][Discount Management] Delete Discount Single Discount Using csv
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin remove using csv discount management with file names "delete_success.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_COOP-6479
  Scenario: [Web][Probut][Discount Management] Delete Discount Kost Not Exist In Discount (Negative Case)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin remove using csv discount management with file names "delete_kost_discount_not_exist.csv"
    Then admin should be able to see the text "Error! Unable to remove kost ID: 1000036261"

  @TEST_COOP-6480
  Scenario: [Web][Probut][Discount Management] Delete Discount kost id Not Exist (Negative Case)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin remove using csv discount management with file names "delete_kost_id_not_found.csv"
    Then admin should be able to see the text "Invalid kost ID found: 9000036259"

  @TEST_COOP-6481
  Scenario: [Web][Probut][Discount Management] Upload Discount markup_type is Null (Negative case)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_markup_type_is_null.csv"
    Then admin should be able to see the text "Error! Row 3: The markup_type field is required."

  @TEST_COOP-6482
  Scenario: [Web][Probut][Discount Management] Upload Discount price_type is Typo (Negative Case)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_price_type_is_typo.csv"
    Then admin should be able to see the text "Error! Row 2: The selected price_type is invalid."

  @TEST_COOP-6483
  Scenario: [Web][Probut][Discount Management] Upload Discount kost id Not Exist (Negative Case)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "upload_kost_id_not_found.csv"
    Then admin should be able to see the text "Invalid kost ID found: 9000036260"

  @TEST_COOP-6485
  Scenario: [Web][Probut][Discount Management] Upload Discount Only Filled kost_id and price_type (Negative Case)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "upload_only_kost_id_and_price_type.csv"
    Then admin should be able to see the text "Error! Row 2: The markup_type field is required. Row 2: The markup_price field is required."