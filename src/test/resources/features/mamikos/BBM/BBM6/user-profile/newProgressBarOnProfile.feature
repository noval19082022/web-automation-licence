@BBM8
Feature: New Progress bar on Profile

	@TEST_BBM-4612 @Manual @update-user-profile @TEST_BBM-4611
	Scenario: [Profile][Informasi Pribadi]Tenant only complete for mandatory profile
		Given user go to mamikos homepage
		When user login as tenant via phone number:
		| phone stag     | phone prod     | password  |
		| 0810000023100  | 0810000023100  | qwerty123 |
		And user navigate to kost saya page
		Then user see percentage based on field that was filled "40% 4 / 10 data profil terisi"

	@TEST_BBM-4613 @update-user-profile
	Scenario: [Profile][Informasi Pribadi]Tenant Batal to complete their profile information
		Given user go to mamikos homepage
		When user login as tenant via phone number:
			| phone stag     | phone prod     | password  |
			| 0810000023100  | 0810000023100  | qwerty123 |
		And user navigate to kost saya page
		Then user see percentage based on field that was filled "40% 4 / 10 data profil terisi"
		And user click on profile card
		And user select city "Kuningan"
		And user input phone number darurat more than "0812123123" character
		And user click on batal button
		Then user see percentage based on field that was filled "40% 4 / 10 data profil terisi"

	@TEST_BBM-4609 @update-user-profile
	Scenario: [Profile][Informasi Pribadi]Check the display and mandatory on profile page
		Given user go to mamikos homepage
		When user login as tenant via phone number:
			| phone stag     | phone prod     | password  |
			| 0810000023200  | 0810000023200  | qwerty123 |
		And user navigate to kost saya page
		Then user see percentage based on field that was filled "10% 1 / 10 data profil terisi"
		And user click on profile card
		Then user see message error validation "Wajib diisi"
		And user choose profession "lainnya"
		Then user see button simpan edit profile disable

	@TEST_BBM-4610
	Scenario: [Profile][Informasi Pribadi]Check profile when tenant first time login to mamikos
		Given user go to mamikos homepage
		When user login as tenant via phone number:
			| phone stag     | phone prod     | password  |
			| 0810000023200  | 0810000023200  | qwerty123 |
		And user navigate to kost saya page
		Then user see percentage based on field that was filled "10% 1 / 10 data profil terisi"

	@TEST_BBM-4615 @reddot
	Scenario: [Profile Page][User Profile]Check red dot at navbar when tenant not complete fill the profile information
		Given user go to mamikos homepage
		When user login as tenant via phone number:
			| phone stag     | phone prod     | password  |
			| 0810000023200  | 0810000023200  | qwerty123 |
		Then user can see reddot on "profile picture"
		And user click on profile picture
		Then user can see reddot on "profile menu"

	@TEST_BBM-4616 @reddot
	Scenario: [Profile Page][User Profile]Check red dot when tenant only input mandatory field
		Given user go to mamikos homepage
		When user login as tenant via phone number:
			| phone stag     | phone prod     | password  |
			| 0810000023100  | 0810000023100  | qwerty123 |
		Then user can see reddot on "profile picture"
		And user click on profile picture
		Then user can see reddot on "profile menu"

	@TEST_BBM-4617 @reddot
	Scenario: [Profile Page][User Profile]Check ret dot when tenant hasn’t verified the account and completed the profile information
		Given user go to mamikos homepage
		When user login as tenant via phone number:
			| phone stag     | phone prod     | password  |
			| 0810000023300  | 0810000023300  | qwerty123 |
		Then user can see reddot on "profile picture"
		And user click on profile picture
		Then user can see reddot on "profile menu"

	@TEST_BBM-4618 @reddot
	Scenario: [Profile Page][User Profile][Profile Page][User Profile]Check red dot at navbar when tenant verified the account but not completed the profile infomation
		Given user go to mamikos homepage
		When user login as tenant via phone number:
			| phone stag     | phone prod     | password  |
			| 0810000023400  | 0810000023400  | qwerty123 |
		Then user can see reddot on "profile picture"
		And user click on profile picture
		Then user can see reddot on "profile menu"