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

#	#admin search data tenant with valid invoice
#  @TEST_DOM-430 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @searchValidInput @web @web-covered
#  Scenario: [BackOffice][search contract] Admin search data tenant with valid input
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    And user search by "Related Invoice Number" and input field "95357497/2023/04/01822"
#    And user click search button
#    And user click see log button
#    Then user will see detail data contract
##		Then user will see detail data tenant (detail tenant, detail kost, contract period, invoice url, from booking, added by consultant, ramaining checkout, harga sewa, deposit, status kontrak, action button)
#	#admin search data tenant with valid Renter number
#  @TEST_DOM-402 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @web @web-covered
#  Scenario: [BackOffice][search contract] Admin see sisa deposit
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "089220211208"
#    And user click search button
#    And user click edit deposit button
#    Then user will see detail pop up edit deposit Apik "Edit Deposit for Confirm to Finance"
#    And user input biaya kerusakan "50000"
#    Then user will see sisa deposit
#	#admin search data tenant with invalid Renter number
#  @TEST_DOM-403 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @InputDamageDetails @automated @discovery-platform @web @web-covered
#  Scenario: [BackOffice][search contract] Search data tenant with input Damage Details more than 200 characters
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "089220211208"
#    And user click search button
#    And user click edit deposit button
#    And user Input damage details "characters more than 200"
#    Then user see maximal length "200"
#	#admin search data tenant with invalid tenant name
#  @TEST_DOM-411 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @searchInvalidInput @web @web-covered
#  Scenario Outline: [BackOffice][search contract] Search by invalid input
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "<searchBy>" and input field "<input>"
#    And user click search button
#    Then user will get blank data detail
#    Examples:
#      | searchBy              | input               |
#      | Kost Name             | kost anggun         |
#      | Owner Phone Number    | 0856220211208       |
#      | Renter Phone Number   | 0856220211208       |
#      | Renter Name           | embul owner         |
#      | Related Invoice Number| 83900841/2021/12/00 |
#      | Related Invoice Code  | 83900841            |
#	#admin search data tenant based on period
#  @TEST_DOM-415 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @searchBasedOnPeriod @web @web-covered
#  Scenario: [BackOffice][search contract] Search data tenant  based on period
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "089220220101"
#    And user fills kost level "SinggahSini"
#    And user click search button
#    Then user redirect to search contract menu detail
#	#admin search data tenant based on kost level
#  @TEST_DOM-416 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @SearchDataTenantBasedOnKostLevel @automated @discovery-platform @web @web-covered
#  Scenario: [BackOffice][search contract] Search data tenant  based on kost level
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    When user fills kost level "Mamikos Goldplus 2"
#    And user click search button
#    Then user verify that detail kos is "Mamikos Goldplus 2"
#	#admin search data tenant based on period custome range
#  @TEST_DOM-419 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @SearchDataTenantBasedOnPeriod @automated @discovery-platform @web @web-covered
#  Scenario: [BackOffice][search contract] Search data tenant based on period with custom range
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    Then user choose contract date period
#    And user select date period "Today"
#    And user click search button
#    Then user choose contract date period
#    And user select date period "Yesterday"
#    And user click search button
#    Then user Navigate "Search Contract" page
#	#invoice not paid yet and admin batalkan contract
#  @TEST_DOM-421 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @adminBatalkanContract @automated @discovery-platform @web @web-covered
#  Scenario: [BackOffice][search contract] batalkan kontrak
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user access search contract menu
#    And user search for "payment" and cancel contract
#
#		#  Scenario: Cancel booking if tenant have booking
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user login in as Tenant via phone number as "PF batalkan kontrak"
#    When user navigates to "mamikos /user/booking/"
#    And user cancel booking
#
#		#  Scenario: Tenant booking and payment for weekly period
#    Given user navigates to "mamikos /"
#    When user clicks search bar
#    And I search property with name "payment" and select matching result to go to kos details page
#    And user choose boarding date is "today" and clicks on Booking button on Kost details page
#    And user select payment period "Per Minggu"
#    And user selects T&C checkbox and clicks on Book button
#    Then system display successfully booking
#
#		#  Scenario: Owner accept booking from tenant
#    Given user navigates to "mamikos /"
#    When user logs out as a Tenant user
#    And user clicks on Enter button
#    And user fills out owner login as "payment" and click on Enter button
#    And user navigates to booking request and filter booking need confirmation
#    And user clicks accept button on payment booking
#    And select first room available and clicks on next button
#    And user enters deposit fee, penalty fee, additional costs, down payment, and click on save button
#    And user navigates to "mamikos /"
#    And user logs out as a Tenant user
#
#		#   Scenario: Invoice not paid yet and Admin batalkan contract
#    Given user navigates to "backoffice"
##			When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    And user Navigate "Search Contract" page
#    And user search for "payment" and cancel contract
#    Then user see popup succsessful batalkan and status contract change to cancelled
#	#admin cancle extend invoice
#  @TEST_DOM-413 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @cancelExtendContract @discovery-platform @web @web-covered
#  Scenario: [Backoffice][search contract] Cancel extend contract
#	#		aktivasi kontrak singgahsini
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And admin open menu all invoice
#    And admin select invoice number
#    And admin input invoice number "69903537/2023/01/43864"
#    And admin click button cari invoice
#    And admin click change status
#    And admin change paid to unpaid
#    And admin submit change
#    And admin click change status
#    And admin change unpaid to paid
#    And admin input date and time "2023-02-04 16:35:11"
#    And admin submit change
#
##		Given user navigates to "backoffice"
##		    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "089220220105"
#    And user fills kost level "SinggahSini"
#    And user click search button
#    And user click button extend contract
#    Then user redirect to search contract menu detail
#	#admin check log  data contract
#  @TEST_DOM-401 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @seeDataContract @web @web-covered
#  Scenario: [Backoffice][search contract] see log detail data contract
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    And user click see log button
#    Then user will see detail data contract
#	## See detail pop up "Deposit for confirm to finance"
#	#
#	#  2. Selection kost :
#	#
#	#* mamiroom
#	#* APIK
#	#* ELITE
#	#
#	#3. Edit Deposit visible if :
#	#
#	#* Kost already payment
#	#* Kost already terminate by admin
#  @TEST_DOM-429 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @editDeposit @seeDetailPopupApik @web @web-covered
#  Scenario: [BackOffice][Search Contract][Edit Deposit][kost APIK] See detail pop up
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "089220211208"
#    And user click search button
#    And user click edit deposit button
#    Then user will see detail pop up edit deposit Apik "Edit Deposit for Confirm to Finance"
#	#input bank name in  pop up "Deposit for confirm to finance"
#  @TEST_DOM-417 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @inputBankEditDeposit @web @web-covered
#  Scenario: [BackOffice][Search Contract][Edit Deposit] Input Bank in name detail pop up
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "081280003230"
#    And user fills kost level "SinggahSini"
#    And user click search button
#    And user click edit deposit button
#    Then user will see Konfirmasi Sisa Deposit button hidden
#    And user click drop down bank name and choose one bank
#    Then user see dropdown will be close
#	#input nomer rekening in  pop up "Deposit for confirm to finance"
#  @TEST_DOM-418 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @inputNomorRekeningDetailEditDeposit @web @web-covered
#  Scenario: [BackOffice][Search Contract][Edit Deposit] Input nomer rekening detail pop up
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "081280003230"
#    And user fills kost level "SinggahSini"
#    And user click search button
#    And user click edit deposit button
#    Then user will see Konfirmasi Sisa Deposit button hidden
#    And user input nomor rekening "1550000036"
#	#input nama rekening in  pop up "Deposit for confirm to finance"
#  @TEST_DOM-420 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @inputNameRekeningDetailEditDeposit @web @web-covered
#  Scenario: [BackOffice][Search Contract][Edit Deposit] Input nama rekening detail pop up
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "081280003230"
#    And user fills kost level "SinggahSini"
#    And user click search button
#    And user click edit deposit button
#    Then user will see Konfirmasi Sisa Deposit button hidden
#    And user input nama pemilik rekening "Noval"
#	#input detail kerusakan in  pop up "Deposit for confirm to finance"
#  @TEST_DOM-412 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @DOM2 @automated @discovery-platform @web @web-covered
#  Scenario: [BackOffice][Search Contract][Edit Deposit][kost SinggahSini] Admin See detail pop up
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "081280003230"
#    And user fills kost level "SinggahSini"
#    And user click search button
#    And user click edit deposit button
#    Then user will see Konfirmasi Sisa Deposit button hidden
#	#click button simpan draf detail pop up "Deposit for confirm to finance"
#  @TEST_DOM-735 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @AdminSimpanDraft @DOM2 @automated @discovery-platform @web @web-covered
#  Scenario: [BackOffice][Search Contract][Edit deposit] click button simpan draf detail pop up
#    Given user navigates to "backoffice"
#    When user login  as a Admin via credentials
#    And user click on Search Contract Menu form left bar
#    Then user Navigate "Search Contract" page
#    And user search by "Renter Phone Number" and input field "081280003230"
#    And user fills kost level "SinggahSini"
#    And user click search button
#    And user click edit deposit button
#    Then user will see Konfirmasi Sisa Deposit button hidden
#    And user input nomor rekening "1550000036"
#    And user input nama pemilik rekening "Noval"
#    And user input transfer date
#    And user click on simpan Draft button
#    Then user will see message "Berhasil disimpan sebagai draf"
