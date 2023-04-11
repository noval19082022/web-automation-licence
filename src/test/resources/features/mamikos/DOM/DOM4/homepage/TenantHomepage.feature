@DOM-4724
Feature: Homepage

	@TEST_DOM-4621 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check cari iklan dropdown items
		Given user go to mamikos homepage
		Then tenant can see ads dropdown option
	@TEST_DOM-4622 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check profile dropdown items after login
		Given user go to mamikos homepage
		When user login as tenant via phone number:
		  | phone stag   | phone prod   | password  |
		  | 081223344550 | 083176408442 | qwerty123 |
		Then tenant can see profile dropdown option
	@TEST_DOM-4623 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection kebijakan privasi on homepage
		Given user go to mamikos homepage
		And user open kebijakan privasi in footer
		Then user should redirect to kebijakan privasi page
	@TEST_DOM-4624 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection syarat dan ketentuan on homepage
		Given user go to mamikos homepage
		And user open syarat dan ketentuan in footer
		Then user should redirect to link "https://help.mamikos.com/post/syarat-dan-ketentuan-umum"
	@TEST_DOM-4625 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection tentang kami on homepage
		Given user go to mamikos homepage
		When user open tentang kami in footer
		Then user should redirect to link that contains "/tentang-kami"
	@TEST_DOM-4626 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection job mamikos on homepage
		Given user go to mamikos homepage
		When user open job mamikos in footer
		Then user should redirect to link that contains "/career"
	@TEST_DOM-4627 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection promosikan kost anda on homepage
		Given user go to mamikos homepage
		When user open promosikan kost anda in footer
		Then user should redirect to link that contains "/mamiads"
	@TEST_DOM-4628 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection pusat bantuan on homepage
		Given user go to mamikos homepage
		When user open pusat bantuan in footer
		Then user should redirect to link "https://help.mamikos.com/"
	@TEST_DOM-4629 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection facebook on homepage
		Given user go to mamikos homepage
		When user open facebook in footer
		Then user should redirect to link that contains "https://www.facebook.com/mamikosapp/"
	@TEST_DOM-4630 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection twitter on homepage
		Given user go to mamikos homepage
		When user open twitter in footer
		Then user should redirect to link that contains "https://twitter.com/mamikosapp"
	@TEST_DOM-4631 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection instagram on homepage
		Given user go to mamikos homepage
		When user open instagram in footer
		Then user should redirect to link that contains "https://www.instagram.com/mamikosapp/"
	@TEST_DOM-4632 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection e-mail on homepage
		Given user go to mamikos homepage
		When user open e-mail in footer
		Then user should redirect to Form Bantuan page
	@TEST_DOM-4633 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check redirection whatsapp on homepage
		Given user go to mamikos homepage
		When user open whatsapp in footer
		Then user should redirect to link that contains "https://api.whatsapp.com/send/?phone=6281325111171"
	@TEST_DOM-4634 @Automated @DOM4 @Web @discovery-platform @homepage
	Scenario: [Dweb][Homepage]Check copyright on footer on homepage
		Given user go to mamikos homepage
		Then user can see copyright is "© 2023 Mamikos.com, All rights reserved"