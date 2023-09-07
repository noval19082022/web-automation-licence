Feature: New Progress bar on Profile

	@TEST_BBM-4612 @Manual @update-user-profile @TEST_BBM-4610
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
