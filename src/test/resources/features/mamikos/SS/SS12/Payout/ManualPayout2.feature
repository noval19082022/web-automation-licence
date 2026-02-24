@SS10
Feature: Inquiry and Create Manual Payout

  @TEST_SS-2945 @Automated @web-covered @createAndChangeManualPayout @continue
  Scenario: [Mamipay][Manual Payout] Change payout type to owner
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag              | email prod | password  |
      | uncle.coop1@mamikos.com | <email>    | qwerty123 |
    And admin want to change payout type into "Refund Outside MamiPAY"
    Then admin see payout data successfully updated message
    And admin want to change payout type into "Payout to Tenant"
    Then admin see payout data successfully updated message
    And admin want to change payout type into "Additional Payout to Owner"
    Then admin see payout data successfully updated message
    And admin want to change payout type into "Refund Charging"
    Then admin see payout data successfully updated message
    And admin want to change payout type into "Disbursement"
    Then admin see payout data successfully updated message
    And admin want to change payout type into "Refund"
    Then admin see payout data successfully updated message

  @TEST_SS-2933 @TEST_SS-2934 @Automated @web-covered
  Scenario: [Mamipay][Manual Payout] Sort payout list by <sorting direction> data
    Given admin go to mamikos mamipay admin
    And admin mamipay visit manual payout page
    And admin mamipay want to sort manual payout by "newest"
    And admin mamipay want to sort manual payout by "oldest"