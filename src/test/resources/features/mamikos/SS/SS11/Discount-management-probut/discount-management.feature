@SS9
Feature: Probut Discount Management

  @TEST_SS-2717 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount Not Fill discount_type_mamikos and mamkos_price
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_discount_not_fill_discount_type_mamikos_and_mamkos_price.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2718 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount Not Fill discount_type_owner And owner_price
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_discount_not_fill_discount_type_owner_and_owner_price.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2719 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount mark_up_type is Different With discount_type
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_mark_up_type_is_different_with_discount_type.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2720 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount Only Fill owner_price for price_type Yearly
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_only_filled_owner_price_for_price_type_yearly.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2721 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount price_type is nominal but discont_type is percentage
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_price_type_is_nominal_but_discont_type_is_percentage.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2722 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount Same Discount with Different Price
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_same_discount_with_different_price.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2723 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount Same kost_id with Multiple price_type
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_same_kost_id_with_multiple_price_type.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2724 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount bulk csv
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_success_bulk.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2725 @continue
  Scenario: [Web][Probut][Discount Management] Delete Discount bulk csv
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin remove using csv discount management with file names "delete_bulk.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2726 @continue
  Scenario: [Web][Probut][Discount Management] Delete Discount Single Discount Using csv
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin remove using csv discount management with file names "delete_success.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-2727 @continue
  Scenario: [Web][Probut][Discount Management] Delete Discount Kost Not Exist In Discount (Negative Case)
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin remove using csv discount management with file names "delete_kost_discount_not_exist.csv"
    Then admin should be able to see the text "Error! Unable to remove kost ID: 1000036261"

  @TEST_SS-2728 @continue
  Scenario: [Web][Probut][Discount Management] Delete Discount kost id Not Exist (Negative Case)
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin remove using csv discount management with file names "delete_kost_id_not_found.csv"
    Then admin should be able to see the text "Invalid kost ID found: 9000036259"

  @TEST_SS-2729 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount markup_type is Null (Negative case)
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_markup_type_is_null.csv"
    Then admin should be able to see the text "Error! Row 3: The markup_type field is required."

  @TEST_SS-2730 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount price_type is Typo (Negative Case)
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_price_type_is_typo.csv"
    Then admin should be able to see the text "Error! Row 2: The selected price_type is invalid."

  @TEST_SS-2731 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount kost id Not Exist (Negative Case)
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "upload_kost_id_not_found.csv"
    Then admin should be able to see the text "Invalid kost ID found: 9000036260"

  @TEST_SS-2732 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount Only Filled kost_id and price_type (Negative Case)
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "upload_only_kost_id_and_price_type.csv"
    Then admin should be able to see the text "Error! Row 2: The markup_type field is required. Row 2: The markup_price field is required."

  @TEST_SS-2733 @continue
  Scenario: [Web][Probut][Discount Management] Upload Discount price_type is not in Daily, Weekly, Monthly, Quarterly, Semiannually, Yearly (Negative Case)
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_price_type_is_not_in_enumared.csv"
    Then admin should be able to see the text "Error! Row 2: The selected price_type is invalid. Row 3: The selected price_type is invalid."

  @TEST_SS-2734
  Scenario: [Web][Probut][Discount Management] Upload Discount Fill dicount_type_owner filled by nominal but discount_type_mamikos is null
    Given admin go to mamikos bangkrupux admin
    And Admin bangkrupux visit promo ngebut discount management
    And Admin upload csv discount management with file names "update_discount_fill_dicount_type_owner_fill_by_nominal_but_discount_type_mamikos_is_null.csv"
    Then admin should be able to see the text "Success! File processed successfully."

  @TEST_SS-8147
  Scenario: [Web][Discount Management][Search] Search by Listing name
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin search by listing name with "Kost Apik Marlin Tipe A"
    And admin click on search button
    Then admin can see kost name on discount management page

  @TEST_SS-8146
  Scenario: [Web][Discount Management][Discount Link Redirection]Admin check redirection link
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin search by listing name with "Kost Apik Marlin Tipe A"
    And admin click on search button
    Then admin click on redirection link kost name

  @TEST_SS-8143
  Scenario: [Web][Discount Management][Filter]Filter by Mapping Status with Live
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And admin choose filter "mapping-status" with "Live"
    And admin click on search button
    Then admin can see status "Live" on list

  @TEST_SS-8142
  Scenario: [Web][Discount Management][Filter]Filter by Mapping Status with All
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And admin choose filter "mapping-status" with "All Mapping Status"
    And admin click on search button
    Then admin can see status "Live" on list

  @TEST_SS-8144
  Scenario: [Web][Discount Management][Filter]Filter by Mapping Status with Not Live
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And admin choose filter "mapping-status" with "Not Live"
    And admin click on search button
    Then admin can see status "Not Live" on list

  @TEST_SS-8140
  Scenario: [Web][Discount Management][Filter]Filter by Listing status with active
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And admin choose filter "room-status" with "Active"
    And admin click on search button
    Then admin can see status "Active" on list

  @TEST_SS-8139
  Scenario: [Web][Discount Management][Filter]Filter by Listing status with all
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And admin choose filter "room-status" with "All"
    And admin click on search button
    Then admin can see status "Active" on list

  @TEST_SS-8141
  Scenario: [Web][Discount Management][Filter]Filter by Listing status with inactive
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And admin choose filter "room-status" with "Inactive"
    And admin click on search button
    Then admin can see status "Inactive" on list

  @TEST_SS-8136
  Scenario: [Web][Discount Management][Filter]Filter by Persentage for Mamikos
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And Admin search by listing name with "Kost Apik Marlin Tipe A"
    And admin choose filter "discount-source" with "Mamikos"
    And admin input persentage with "10"
    And admin click on search button
    Then admin can see discount with "100,000 (10%)" on list

  @TEST_SS-8135
  Scenario: [Web][Discount Management][Filter]Filter by Persentage for all
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And admin choose filter "discount-source" with "All Discount"
    And admin input persentage with "10"
    And admin click on search button
    Then admin can see discount with "100,000 (10%)" on list

  @TEST_SS-8137
  Scenario: [Web][Discount Management][Filter]Filter by Persentage for Owner
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And Admin bangkrupux visit promo ngebut discount management
    And admin choose filter "discount-source" with "Owner"
    And admin input persentage with "10"
    And admin click on search button
    Then admin can see discount with "50,000 (10%)" on list