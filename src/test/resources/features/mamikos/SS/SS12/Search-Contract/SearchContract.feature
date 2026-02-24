@SS10
Feature: Search Contract

	#popup terminate non kost selection
	#(after tenant paid the order contract)
  @TEST_SS-2851 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @kostAPIK @seePopupTerminateAkhiriContract @web @web-covered
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

  @TEST_SS-2852 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @kostSinggaSini @seeLihatAkhiriKontrakDisable @web @web-covered
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
    And admin akhiri contract
    Then admin should success terminate contract

  @TEST_SS-2853 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @mamiroom @seeDetailPopupForMamirooms @web @web-covered
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

  @TEST_SS-2854 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @searchValidInput @web @web-covered
  Scenario: [BackOffice][search contract] Admin search data tenant with valid input
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Related Invoice Number" and input field "95357497/2023/04/01822"
    And admin want to see log contract
    Then admin will see detail pop up "Data Contract"

  @TEST_SS-2855 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @web @web-covered
  Scenario: [BackOffice][search contract] Admin see sisa deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220211208"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin will see detail pop up "Pastikan data rekening dan kerusakan sudah sesuai"
    And admin input biaya kerusakan "50000"
    Then admin will see additional notes menu deposit

	#admin search data tenant with invalid Renter number
  @TEST_SS-2856 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @InputDamageDetails @automated @discovery-platform @web @web-covered
  Scenario: [BackOffice][search contract] Search data tenant with input Damage Details more than 200 characters
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220211208"
    And admin want to edit deposit
    And admin input detail kerusakan "characters more than 200" on edit deposit page
    Then admin see maximal length "200/200"

  @TEST_SS-2857 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @searchInvalidInput @web @web-covered
  Scenario Outline: [BackOffice][search contract] Search by invalid input
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "<searchBy>" and input field "<input>"
    Then admin will get blank data detail
    Examples:
      | searchBy               | input               |
      | Kost Name              | kost anggun         |
      | Owner Phone Number     | 0856220211208       |
      | Renter Phone Number    | 0856220211208       |
      | Renter Name            | embul owner         |
      | Related Invoice Number | 83900841/2021/12/00 |
      | Related Invoice Code   | 83900841            |

  @TEST_SS-2858 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @searchBasedOnPeriod @web @web-covered
  Scenario: [BackOffice][search contract] Search data tenant based on period
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220220101"
    And admin want to search contract periode for "Last Month"
    And admin search contract by kost level "SinggahSini"
    Then admin redirect to search contract menu detail

  @TEST_SS-2859 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @SearchDataTenantBasedOnKostLevel @automated @discovery-platform @web @web-covered
  Scenario: [BackOffice][search contract] Search data tenant  based on kost level
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    And admin search contract by kost level "Mamikos Goldplus 2"
    Then admin verify see text "Mamikos Goldplus 2"

	#admin search data tenant based on period custome range
  @TEST_SS-2860 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @SearchDataTenantBasedOnPeriod @automated @discovery-platform @web @web-covered
  Scenario: [BackOffice][search contract] Search data tenant based on period with custom range
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    And admin want to search contract periode for "Today"
    Then admin redirect to search contract menu detail
    When admin go to "Search Contract" menu
    And admin want to search contract periode for "Yesterday"
    Then admin redirect to search contract menu detail

	#invoice not paid yet and admin batalkan contract
  @TEST_SS-2861 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @adminBatalkanContract @automated @discovery-platform @web @web-covered
  Scenario: [BackOffice][search contract] batalkan kontrak
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "081197878841"
    And admin want to batalkan contract if exist

		#  Scenario: Cancel booking if tenant have booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 081197878841 | 08119787884 | qwerty123 |
    And user cancel booking

		#  Scenario: Tenant booking and payment for weekly period
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                             | kost path prod       |
      | kost-kabupaten-halmahera-utara-kost-campur-murah-desta-automation-tobelo-halmahera-utara-2 | kost payment desta 2 |
    And tenant booking kost for "today"

		#  Scenario: Owner accept booking from tenant
    Given user go to mamikos homepage
    When user logs out as a Tenant user
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan123 |
    And owner accept booking from tenant:
      | tenant stag | tenant prod |
      | Coba Daftar | Desta       |
    Then owner should redirect back to pengajuan booking page

        #   Scenario: Invoice not paid yet and Admin batalkan contract
    Given admin go to mamikos mamipay admin
    And admin search contract by "Renter Phone Number" and input field "081197878841"
    Then admin cancel contract

        #admin cancel extend invoice
  @TEST_SS-2862 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @cancelExtendContract @discovery-platform @web @web-covered
  Scenario: [Backoffice][search contract] Cancel extend contract
	#	aktivasi kontrak singgahsini
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to reactivate invoice by invoice number "69903537/2023/01/43864"

   # see detail pop up
    And admin search contract by tenant phone number:
      | phone stag   | phone prod  |
      | 081197878841 | 08119787884 |
    And admin search contract by kost level "SinggahSini"
    And admin akhiri contract
    Then admin should success terminate contract

  @TEST_SS-2863 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @seeDataContract @web @web-covered
  Scenario: [Backoffice][search contract] see log detail data contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    And admin want to see log contract
    Then admin will see detail pop up "Data Contract"

  @TEST_SS-2864 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @editDeposit @seeDetailPopupApik @web @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit][kost APIK] See detail pop up
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220211208"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin will see detail pop up "Edit Deposit for Confirm to Finance"

	#input bank name in  pop up "Deposit for confirm to finance"
  @TEST_SS-2865 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @inputBankEditDeposit @web @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] Input Bank in name detail pop up
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin search contract by "Renter Phone Number" and input field "081280003230"
    And admin search contract by "Related Invoice Number" and input field "79304090/2023/12/40705"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin will see Konfirmasi Sisa Deposit button hidden
    And admin want to choose "Bank Aceh Syariah" for transfer deposit
    Then admin see dropdown close and see bank "Bank Aceh Syariah"

	#input nomer rekening in  pop up "Deposit for confirm to finance"
  @TEST_SS-2866 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @inputNomorRekeningDetailEditDeposit @web @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] Input nomer rekening detail pop up
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin search contract by "Renter Phone Number" and input field "081280003230"
    And admin search contract by "Related Invoice Number" and input field "79304090/2023/12/40705"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin will see Konfirmasi Sisa Deposit button hidden
    And admin input nomor rekening on edit deposit page "1550000036"

	#input nama rekening in  pop up "Deposit for confirm to finance"
  @TEST_SS-2867 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @inputNameRekeningDetailEditDeposit @web @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] Input nama rekening detail pop up
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin search contract by "Renter Phone Number" and input field "081280003230"
    And admin search contract by "Related Invoice Number" and input field "79304090/2023/12/40705"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin will see Konfirmasi Sisa Deposit button hidden
    And admin input nama pemilik rekening on edit deposit page "Noval"

	#input detail kerusakan in  pop up "Deposit for confirm to finance"
  @TEST_SS-2868 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @SS10 @automated @discovery-platform @web @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit][kost SinggahSini] Admin See detail pop up
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin search contract by "Renter Phone Number" and input field "081280003230"
    And admin search contract by "Related Invoice Number" and input field "79304090/2023/12/40705"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin will see Konfirmasi Sisa Deposit button hidden

#	click button simpan draf detail pop up "Deposit for confirm to finance"
  @TEST_SS-2869 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @AdminSimpanDraft @automated @discovery-platform @web @web-covered
  Scenario: [BackOffice][Search Contract][Edit deposit] click button simpan draf detail pop up
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin search contract by "Renter Phone Number" and input field "081280003230"
    And admin search contract by "Related Invoice Number" and input field "79304090/2023/12/40705"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin will see Konfirmasi Sisa Deposit button hidden
    And admin want to choose "Bank Aceh Syariah" for transfer deposit
    Then admin see dropdown close and see bank "Bank Aceh Syariah"
    And admin input nomor rekening on edit deposit page "1550000036"
    And admin input nama pemilik rekening on edit deposit page "Noval"
    And admin input transfer date on edit deposit page "2022-02-02"
    And admin input detail kerusakan "rusak" on edit deposit page
    And admin want to simpan draft edit deposit
    Then admin will see detail pop up "Berhasil disimpan sebagai draf"