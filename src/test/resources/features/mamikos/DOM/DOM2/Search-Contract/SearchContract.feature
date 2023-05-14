Feature: Search Contract

	#popup terminate non kost selection
	#(after tenant paid the order contract)
  @TEST_DOM-431 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @kostAPIK @seePopupTerminateAkhiriContract @web @web-covered
  Scenario: [BackOffice][popup terminate][kost APIK] Admin See detail pop up
    # aktivasi kontrak apik
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to reactivate invoice by invoice number "43568812/2023/05/75761"

    # see detail pop up
    And admin search contract by tenant phone number:
      | phone stag   | phone prod  |
      | 081197878841 | 08119787884 |
    And admin search contract by kost level "APIK"
    And admin akhiri contract
    Then admin should success terminate contract
