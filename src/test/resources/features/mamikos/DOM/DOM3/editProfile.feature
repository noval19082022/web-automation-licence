@DOM3 @editProfile
Feature: Edit Profile

	#After create New account tenant
  @TEST_DOM-179 @TESTSET_UG-4895 @TESTSET_UG-6226 @AUTOMATED @web @web-covered
  Scenario: [Web Tenant][Gender - Edit Profile] not choose gender
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 089220221221  | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on profile card