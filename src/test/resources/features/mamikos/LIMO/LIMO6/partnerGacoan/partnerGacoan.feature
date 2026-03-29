@LIMO8 @PartnerGacoan
Feature: Partner Gacoan
#
#  @TEST_LIMO-10829 @TEST_LIMO-11459
#  Scenario: [Partner] Explore Gacoan partner
#    Given admin gacoan visit partner portal page
#    When admin gacoan login into partner portal:
#      | user     | password  |
#      | qatampan | qwerty123 |
#    Then admin gacoan able to see the listing catalog
#    And admin gacoan try to check the filter and sorting
#    Then the filter and sorting should be works
#    And admin gacoan select first kost on the listing catalog
#    Then admin gacoan will redirect into booking form
#    When admin gacoan fill all required field using phone number "random"
#    And admin gacoan able to submit the booking
#    And admin logout from partner page

  @TEST_LIMO-11459
  Scenario: [Partner] Explore Gacoan partner
    Given admin gacoan visit partner portal page
    When admin gacoan login into partner portal:
      | user     | password  |
      | qatampan | qwerty123 |
    And admin gacoan select first kost on the listing catalog
    Then admin gacoan will redirect into booking form
    When admin gacoan fill all required field using phone number "081197878846"
    Then admin will see that the text "Nomor sudah terdaftar." is displayed

  @TEST_LIMO-11461
  Scenario: [Partner] Explore Gacoan partner
    Given admin gacoan visit partner portal page
    When admin gacoan login into partner portal:
      | user     | password  |
      | qatampan | qwerty123 |
    And admin gacoan select first kost on the listing catalog
    Then admin gacoan will redirect into booking form
    When admin gacoan fill all required field using phone number "81197878846111111"
    Then admin will see that the text "Nomor HP harus diawali dengan 08" is displayed