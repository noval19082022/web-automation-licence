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

  @TEST_DOM-432 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @kostSinggaSini @seeLihatAkhiriKontrakDisable @web @web-covered
  Scenario: [BackOffice][popup terminate][kost singgahsini] Admin See detail pop up
    # aktivasi kontrak singgahsini
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to reactivate invoice by invoice number "69903537/2023/01/43864"

    # see detail pop up
    And admin search contract by tenant phone number:
      | phone stag   | phone prod   |
      | 089220220105 | 089220220105 |
    And admin search contract by kost level "SinggahSini"
    Then admin want to akhiri contract but akhiri kontrak button is disabled

  @TEST_DOM-433 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @mamiroom @seeDetailPopupForMamirooms @web @web-covered
  Scenario: [BackOffice][popup terminate][mamirooms] Admin See detail pop up
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag   | phone prod   |
      | 081177778888 | 081177778888 |
    And admin search contract by kost level "Mamirooms"
    And admin want to edit deposit
    Then admin will see detail pop up "Pastikan data rekening dan kerusakan sudah sesuai"

  @TEST_DOM-430 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @searchValidInput @web @web-covered
  Scenario: [BackOffice][search contract] Admin search data tenant with valid input
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Related Invoice Number" and input field "95357497/2023/04/01822"
    And admin want to see log contract
    Then admin will see detail pop up "Data Contract"

  @TEST_DOM-402 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @web @web-covered
  Scenario: [BackOffice][search contract] Admin see sisa deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220211208"
    And admin want to edit deposit
    Then admin will see detail pop up "Pastikan data rekening dan kerusakan sudah sesuai"
    And admin input biaya kerusakan "50000"
    Then admin will see sisa deposit
