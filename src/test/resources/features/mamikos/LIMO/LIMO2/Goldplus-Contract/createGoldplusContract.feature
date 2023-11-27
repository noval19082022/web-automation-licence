@listing-monetization @regression @LIMO2
Feature: Create Contract Goldplus at Mamipay

  @createContractGPInvalid @TEST_LIMO-2453
  Scenario: [Admin][GP Contract]User want to Create GoldPlus Contract  with Invalid Value
    #Admin Want To Create GP Contract with Empty value
    Given admin go to mamikos mamipay admin
    * admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    * admin accsess menu Goldplus Contract
    When user click create new contract button
    * user input phone number with " "
    * user confirmed to create GP Contract and invoice
    Then user see warning notification "The phone number field is required."
    And user see warning notification "The package field is required."

    #Owner Want To Create GP Contract with Invalid value
    When user input phone number with "asdfgh"
    And user confirmed to create GP Contract and invoice
    Then user see warning notification "The selected phone number is invalid."
    And user see warning notification "The package field is required."

    #Owner Want To Create GP Contract without selecting goldplus package
    When user input phone number with "082233545511"
    And user confirmed to create GP Contract and invoice
    Then user see warning notification "The package field is required."

    #Owner Want To Create GP Contract with owner already have goldplus contract
    When user input phone number with "082233545512"
    And user selected goldplus package with "GoldPlus 1 periode 1 Bulan"
    And user confirmed to create GP Contract and invoice
    Then user see warning notification "User 082233545512 already has active goldplus contract."