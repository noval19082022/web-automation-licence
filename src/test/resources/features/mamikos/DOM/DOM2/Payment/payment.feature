@DOM2
Feature: Payment BackOffice Staging

  @TEST_DOM-623 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] cancel Extend Contract
  # aktivasi kontrak singgahsini
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to reactivate invoice by invoice number "69903537/2023/01/43864"

  # extend contract
    And admin search contract by tenant phone number:
      | phone stag   | phone prod  |
      | 089220220105 | 08119787884 |
    And admin search contract by kost level "SinggahSini"
#  this step is comment for whale because the button is hide after ARAC project phase 1 release
#    And admin want to extend contract
#    Then admin will see detail pop up "Custom Extend Contract"

  @TEST_DOM-624 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] Search Data Tenant Based On Period Yesterday
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    And admin want to search contract periode for "Yesterday"
    Then admin redirect to search contract menu detail

  @TEST_DOM-622 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] See detail pop up Apik
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    And admin search contract by tenant phone number:
      | phone stag   | phone prod    |
      | 089220211208 | 0890867321212 |
    And admin search contract by kost level "APIK"
    And admin want to edit deposit
    Then admin will see detail pop up "Pastikan data rekening dan kerusakan sudah sesuai"

  @TEST_DOM-621 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] input Bank Edit Deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    And admin search contract by tenant phone number:
      | phone stag   | phone prod    |
      | 081280003230 | 0890867321212 |
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    And admin want to choose "Bank Aceh Syariah" for transfer deposit
    Then admin see dropdown close and see bank "Bank Aceh Syariah"

  @TEST_DOM-620 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] Input Damage Details more than 200 characters
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220211208"
    And admin want to edit deposit
    And admin input detail kerusakan "characters more than 200" on edit deposit page
    Then admin see maximal length "200/200"

  @TEST_DOM-619 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] Admin simpan draft
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "081280003230"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    And admin want to choose "Bank Aceh Syariah" for transfer deposit
    Then admin see dropdown close and see bank "Bank Aceh Syariah"
    And admin input nomor rekening on edit deposit page "1550000036"
    And admin input nama pemilik rekening on edit deposit page "Noval"
    And admin input transfer date on edit deposit page "2022-02-02"
    And admin input detail kerusakan "rusak" on edit deposit page
    And admin want to simpan draft edit deposit
    Then admin will see detail pop up "Berhasil disimpan sebagai draf"

  @TEST_DOM-618 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] see Sisa Deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220211208"
    And admin want to edit deposit
    Then admin will see detail pop up "Pastikan data rekening dan kerusakan sudah sesuai"
    And admin input biaya kerusakan "60000"
    Then admin will see additional notes menu deposit

  @TEST_DOM-617 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] see Data Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    And admin want to see log contract
    Then admin will see detail pop up "Data Contract"

  @TEST_DOM-616 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] see Popup Terminate Contract
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

  @TEST_DOM-615 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] search Based On Period
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220220101"
    And admin search contract by kost level "SinggahSini"
    Then admin redirect to search contract menu detail

  @TEST_DOM-614 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] See detail pop up Mamirooms
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "081177778888"
    And admin search contract by kost level "mamirooms"
    And admin want to edit deposit
    Then admin will see detail pop up "Pastikan data rekening dan kerusakan sudah sesuai"

  @TEST_DOM-613 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] Search Data Tenant Based On Kost Level
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    And admin search contract by kost level "Mamikos Goldplus 2"
    Then admin verify see text "Mamikos Goldplus 2"

  @TEST_DOM-612 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] See detail pop up Singgah Sini
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Related Invoice Number" and input field "36282552/2023/05/51559"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin will see Konfirmasi Sisa Deposit button hidden

  @TEST_DOM-611 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] input Name Rekening Detail Edit Deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "081280003230"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin input nama pemilik rekening on edit deposit page "Noval"

  @TEST_DOM-610 @Automated @web-covered
  Scenario Outline: [BackOffice][Search Contract][Edit Deposit] search Valid Input
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "<searchBy>" and input field "<input>"
    Then admin redirect to search contract menu detail
    Examples:
      | searchBy               | input                 |
      | Kost Name              | Kost Princess         |
      | Owner Phone Number     | 083843666900          |
      | Renter Phone Number    | 083139263046          |
      | Renter Name            | Ullrich               |
      | Related Invoice Number | 83900841/2021/12/0043 |

  @TEST_DOM-609 @Automated @web-covered
  Scenario Outline: [BackOffice][Search Contract][Edit Deposit] search invalid Input
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

  @TEST_DOM-608 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit]input Nomor Rekening Detail Edit Deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "081280003230"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    And admin want to choose "Bank Aceh Syariah" for transfer deposit
    Then admin see dropdown close and see bank "Bank Aceh Syariah"
    And admin input nomor rekening on edit deposit page "1550000036"

  @TEST_DOM-607 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] see Lihat Akhiri Kontrak
    # aktivasi kontrak singgahsini
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to reactivate invoice by invoice number "69903537/2023/01/43864"

    And admin search contract by tenant phone number:
      | phone stag   | phone prod   |
      | 089220220105 | 089220220105 |
    And admin search contract by kost level "SinggahSini"
    And admin akhiri contract
    Then admin should success terminate contract

  @TEST_DOM-727 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @TESTSET_PF-1394 @TESTSET_PF-2238 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit deposit] Input detail kerusakan detail pop up more than 200 character
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220211208"
    And admin want to edit deposit
    And admin input detail kerusakan "characters more than 200" on edit deposit page
    Then admin see maximal length "200/200"

  @TEST_DOM-732
  Scenario: [BackOffice][Search Contract][Edit deposit] See Deposit Button for contract terminated
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by "Renter Phone Number" and input field "089220211208"
    Then admin verify see text "terminated"

  @TEST_DOM-640 @Automated @web-covered
  Scenario: [BackOffice][Refund] Input invalid bank name
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin fill bank name "Bank Noval" on refund detail
    Then admin verify see text "No results found"

  @TEST_DOM-638 @Automated @web-covered
  Scenario: [BackOffice][Refund] export Report
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    And admin want to export the refund report
    And admin choose export report for today
#    And admin download the transferred refund report (this step is comment to reduce log on BE side caused by bug)
#    Then user will get message success download and file exported send email (Bug report on ticket https://mamikos.atlassian.net/browse/DOM-4848)

  @TEST_DOM-633 @Automated @web-covered
  Scenario: [BackOffice][Refund] Refund Payment Credit Card
    ## delete contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag | phone prod  |
      | 0892202100 | 08119787884 |
    And admin want to batalkan contract if exist

    ## cancel booking if tenant have booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202100 | 083176408442 | qwerty123 |
    And user cancel booking

    ## create contract
    When user visit page "/room/kost-kabupaten-banyumas-kost-campur-eksklusif-kost-automation-dom-boleh-refund-patikraja-banyumas-2"
    And tenant booking kost for "today"
    And tenant logs out

    ## owner accept
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
    And owner accept booking and select the room
    Then owner should redirect back to pengajuan booking page
    And owner logs out

    ## Scenario: Tenant pay boarding house for weekly rent
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202100 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant select payment method Credit Card with cc number is "4000 0000 0000 1091", expired date month "12" years "99", and ccv is "010"
    And tenant close unused browser tab

    #  Scenario: data booking
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin filter booking transaction using tenant phone "0892202100"
    And admin set allow refund the transaction

    #  Scenario: Admin edit paid amount & uncheck admin fee
    Given admin go to mamikos mamipay admin
    When admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin uncheck admin fee for refund
    And admin edit paid amount credit card "20000" for refund
    And admin change of reason list to pemilik membatalkan for refund
    And admin set to refund the paid invoice
    Then admin verify see text "Refund transaction created."

  @TEST_DOM-639 @Automated @web-covered
  Scenario: [BackOffice][Refund] see Transaction Flip Success
    ## delete contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag | phone prod  |
      | 0892202100 | 08119787884 |
    And admin want to batalkan contract if exist

    ## cancel booking if tenant have booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202100 | 083176408442 | qwerty123 |
    And user cancel booking

    ## create contract
    When user visit page "/room/kost-kabupaten-banyumas-kost-campur-eksklusif-kost-automation-dom-boleh-refund-patikraja-banyumas-2"
    And tenant booking kost for "today"
    And tenant logs out

    ## owner accept
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
    And owner accept booking and select the room
    Then owner should redirect back to pengajuan booking page
    And owner logs out

    ## Scenario: Tenant pay boarding house
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202100 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0892202100"
    And tenant close unused browser tab

    #  Scenario: data booking
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin filter booking transaction using tenant phone "0892202100"
    And admin set allow refund the transaction

    #  Scenario: Admin edit paid amount & uncheck admin fee
    Given admin go to mamikos mamipay admin
    When admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin uncheck admin fee for refund
    And admin edit paid amount credit card "20000" for refund
    And admin change of reason list to pemilik membatalkan for refund
    And admin set rekening number "1234569" and rekening owner "testing automation refund" for refund
    And admin set to refund the paid invoice
    Then admin verify see text "Refund transaction created."

    #  Scenario: Admin payment from bigflip
    Given admin go to big flip bussiness and login for test mode
    * admin verify on flip test mode
    When admin navigate to riwayat transaksi domestic page on big flip test mode
    Then admin set force success transaction on flip

    #  Scenario: Admin see that refund transaction in success
    Given admin go to mamikos mamipay admin
    When admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    Then admin verify transferred transaction for user "testing automation refund" is visible

  @TEST_DOM-636 @Automated @web-covered
  Scenario: [BackOffice][Refund] export Report Before 1 Hour
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    And admin want to export the refund report
    Then admin verify download button is disable
#    And admin choose export report for today
#    And admin download the transferred refund report (this step is comment to reduce log on BE side caused by bug)
#  (Bug report on ticket https://mamikos.atlassian.net/browse/DOM-4848)
#    Then user will get error message

  @TEST_DOM-635 @Automated @web-covered
  Scenario: [BackOffice][Refund] transaction CreditCard On Transferred Tab
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    And admin search transferred refund by tenant Phone Number and input field "083829167577"
    Then admin verify see text "( from Credit Card )"

  @TEST_DOM-634 @Automated @web-covered
  Scenario: [BackOffice][Refund] click Close Button Popup Refund
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin close the refund detail
    Then admin verify see text "Daftar Invoice Refund"

  @TEST_DOM-632 @Automated @web-covered
  Scenario: [BackOffice][Refund] download Receipt Flip On Transferred Tab
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    And admin search transferred refund by tenant Phone Number and input field "083829167577"
    And admin want to download receipt transferred invoice
		#    Then user successed download receipt - (need improvement for popup success from FE)

  @TEST_DOM-631 @Automated @web-covered
  Scenario: [BackOffice][Refund] Refund Payment Ovo
    ## delete contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag | phone prod  |
      | 0892202100 | 08119787884 |
    And admin want to batalkan contract if exist

    ## cancel booking if tenant have booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202100 | 083176408442 | qwerty123 |
    And user cancel booking

    ## create contract
    When user visit page "/room/kost-kabupaten-banyumas-kost-campur-eksklusif-kost-automation-dom-boleh-refund-patikraja-banyumas-2"
    And tenant booking kost for "today"
    And tenant logs out

    ## owner accept
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
    And owner accept booking and select the room
    Then owner should redirect back to pengajuan booking page
    And owner logs out

    ## Scenario: Tenant pay boarding house
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202100 | 083176408442 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0892202100"
    And tenant close unused browser tab

    #  Scenario: data booking
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin filter booking transaction using tenant phone "0892202100"
    And admin set allow refund the transaction

    #  Scenario: Admin edit paid amount & uncheck admin fee
    Given admin go to mamikos mamipay admin
    When admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin uncheck admin fee for refund
    And admin edit paid amount credit card "20000" for refund
    And admin change of reason list to pemilik membatalkan for refund
    And admin set rekening number "1234569" and rekening owner "testing automation refund" for refund
    And admin set to refund the paid invoice
    Then admin verify see text "Refund transaction created."

    #  Scenario: Admin payment from bigflip
    Given admin go to big flip bussiness and login for test mode
    * admin verify on flip test mode
    When admin navigate to riwayat transaksi domestic page on big flip test mode
    Then admin set force success transaction on flip

    #  Scenario: Admin see that refund transaction in success
    Given admin go to mamikos mamipay admin
    When admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    Then admin verify transferred transaction for user "testing automation refund" is visible

  @TEST_DOM-630 @Automated @web-covered
  Scenario: [BackOffice][Refund] direction Tab To Transferred Tab
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    Then admin verify see text "Receipt"

  @TEST_DOM-629 @Automated @web-covered
  Scenario: [BackOffice][Refund] popup refund section bank
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin fill bank name "BANK MANTAP (Mandiri Taspen)" on refund detail
    Then admin verify bank name for refund is "BANK MANTAP (Mandiri Taspen)"

  @TEST_DOM-628 @Automated @web-covered
  Scenario: [BackOffice][Refund] transaction Flip On Transferred Tab
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    And admin search transferred refund by tenant Phone Number and input field "083829167577"
    Then admin verify see text "Flip"

  @TEST_DOM-627 @Automated @web-covered
  Scenario: [BackOffice][Refund] no Input Bank Account
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin set rekening number "" and rekening owner "testing automation refund" for refund
    And admin set to refund the paid invoice
    Then admin verify see text "The refund account field is required when cc transaction id is not present."

  @TEST_DOM-626 @Automated @web-covered
  Scenario: [BackOffice][Refund] no Input Account Name
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin set rekening number "300100500" and rekening owner "" for refund
    And admin set to refund the paid invoice
    Then admin verify see text "The refund account name field is required when cc transaction id is not present."

  @TEST_DOM-625 @Automated @web-covered
  Scenario: [BackOffice][Refund] click Back Button Popup Refund
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin set rekening number "300100500" and rekening owner "test" for refund
    And admin close the refund detail
    Then admin verify see text "Daftar Invoice Refund"

  @TEST_DOM-650 @Automated @web-covered
  Scenario: [BackOffice][Property Level] Create Property Level
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to property management menu
    And admin bangkerupux search property name "payment squad 1" on property management menu
    Then admin verify see text "payment squad 1"

  @TEST_DOM-651 @Automated @web-covered
  Scenario: [BackOffice][Discount Admin Fee] Discount admin fee recuring booking
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Invoice" menu
    And user search by "Renter Phone Number" and input field "089220220201"
    And user click on detail fee button
    Then admin verify see text "GP2 Staging"

  @TEST_DOM-648 @Automated @web-covered
  Scenario: [BackOffice][Add Ons List] Create add ons without fill mandatory fields
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Add Ons List" menu
    And admin bangkerupux create add ons on add ons list menu
    And admin bangkerupux input name "", description "", price "", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: Create add ons without fill add ons name and price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "", description "description", price "", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: create add ons without fill add ons name and description
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "", description "description", price "5000", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "tester", description "", price "5000", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "", description "", price "5000", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

    #  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "tester", description "", price "", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"
#  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "", description "des", price "", notes "test" and create it
    Then admin verify see text "Please complete all mandatory fields"

#  Scenario: Create add ons without fill price
    When admin bangkerupux cancel pop all mandatory required on create add ons
    And admin bangkerupux input name "tester", description "tester", price "5000", notes "test" and create it
    Then admin verify see text "success created new add ons."
    And admin bangkerupux delete add ons that has name "tester"

  @TEST_DOM-643 @Automated @web-covered
  Scenario: [BackOffice][Add Ons List] Click button delete on add ons menu
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Add Ons List" menu
    And admin bangkerupux create add ons on add ons list menu
    And admin bangkerupux input name "delete", description "delete", price "9999", notes "test" and create it
    And admin bangkerupux delete add ons that has name "delete"
    Then admin verify see text "Deleted."

  @TEST_DOM-642 @Automated @web-covered
  Scenario: [BackOffice][Add Ons List] visit form edit add ons
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Add Ons List" menu

    ## create add ons for testing purpose
    And admin bangkerupux create add ons on add ons list menu
    And admin bangkerupux input name "edit add ons", description "edit", price "9999", notes "test" and create it

    #  Scenario: Positive case Edit add ons Name
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux input name "edit add ons nama", description "edit", price "9999", notes "test" and update it
    Then admin verify see text "success updated new add ons."

    #  Scenario: Positive case Edit add ons description
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux input name "edit add ons nama", description "edit description", price "9999", notes "test" and update it
    Then admin verify see text "success updated new add ons."

    #  Scenario: Positive case Edit add ons price
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux input name "edit add ons nama", description "edit description", price "5000", notes "test" and update it
    Then admin verify see text "success updated new add ons."

    #  Scenario: Positive case Edit add ons notes
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux input name "edit add ons nama", description "edit description", price "5000", notes "edit notes" and update it
    Then admin verify see text "success updated new add ons."

    #  Scenario: Positive case Click button cancel on edit page
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux cancel edit add ons
    Then admin verify see text "Add Ons List"

    #  Scenario: Positive case Click button cancel on pop up edit
    When admin go to "Add Ons List" menu
    And admin bangkerupux edit add ons that has name "edit add ons"
    And admin bangkerupux cancel edit add ons pop up
    Then admin verify see text "Edit Add On"

    ## Delete add ons after test
    And admin go to "Add Ons List" menu
    And admin bangkerupux delete add ons that has name "edit add ons"
    Then admin verify see text "Deleted."

  @TEST_DOM-646 @Automated @web-covered
  Scenario: [BackOffice][Discount Admin Fee] Admin edit invoice discount
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to discount admin fee discount menu
    And admin bangkrupux want to edit discount admin fee
    And admin bangkrupux input amount "999" for discount admin fee
    And admin bangkrupux save after input field on edit discount admin fee
    Then admin verify see text "Success."

  @TEST_DOM-645 @Automated @web-covered
  Scenario: [BackOffice][Discount Admin Fee] Admin delete invoice discount
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to discount admin fee discount menu
    And admin bangkerupux create admin fee discount with name discount "hapus langsung" amount "999"
    And admin bangkerupux want to delete admin fee discount that has name "hapus langsung"
    Then admin verify see text "Success."

  @TEST_DOM-641 @Automated @web-covered
  Scenario: [BackOffice][Discount Admin Fee] Admin create invoice discount
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to discount admin fee discount menu
    And admin bangkerupux create admin fee discount with name discount "create invoice discount hapus langsung" amount "999"
    And admin bangkerupux want to delete admin fee discount that has name "create invoice discount hapus langsung"
    Then admin verify see text "Success."

  @TEST_DOM-680 @Automated @web-covered
  Scenario: [Owner][Payment premium] Filter valid owner number premium
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Owner Phone Number" and input field "08119787884"
    Then admin verify see text "Desta Owner"

  @TEST_DOM-679 @Automated @web-covered
  Scenario: [Owner][Payment premium] Filter invalid owner number premium
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Owner Phone Number" and input field "0811978499"
    Then admin bangkerupux get blank data list on package invoice list

  @TEST_DOM-678 @Automated @web-covered
  Scenario: [Owner][Payment premium] Admin search expired invoice number
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux filter the status of package invoice list premium for "expired" transaction
    Then admin bangkerupux see transaction status list on package invoice list is only "expired"

  @TEST_DOM-677 @Automated @web-covered
  Scenario: [Owner][Payment premium] Owner paid premium paket
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp6.000"
    And payment owner success using ovo as payment method

    #  Scenario: Admin check the transaction on Menu Premium Package status paid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Owner Phone Number" and input field "08123450977"
    Then admin verify see text "paid"

  @TEST_DOM-675 @Automated @web-covered
  Scenario: [Owner][Payment premium] Filter valid premium package invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "PRE/20230811/56545/34420"
    Then admin verify see text "PRE/20230811/56545/34420"

  @TEST_DOM-676 @Automated @web-covered
  Scenario: [Owner][Payment premium] Filter by status unpaid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux filter the status of package invoice list premium for "unpaid" transaction
    Then admin bangkerupux see transaction status list on package invoice list is only "unpaid"

  @TEST_DOM-673 @Automated @web-covered
  Scenario: [Owner][Payment premium] Filter Invalid premium package invoice use GP Invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "GP3/20210623/00003930/7590"
    Then admin bangkerupux get blank data list on package invoice list

  @TEST_DOM-672 @Automated @web-covered
  Scenario: [Owner][Payment premium] Owner unpaid premium paket
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp205.000"

    #  Scenario: Admin check the transaction on Menu Premium Package status unpaid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Owner Phone Number" and input field "08123450977"
    Then admin bangkerupux see transaction status on package invoice list is "unpaid"

  @TEST_DOM-674 @Automated @web-covered
  Scenario: [Owner][Payment premium] Filter invalid premium package invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "PRE/20000811/56545/34420"
    Then admin bangkerupux get blank data list on package invoice list

  @TEST_DOM-688 @Automated @web-covered
  Scenario Outline: [BackOffice][Invoice Security] Open Invoice Booking from search invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Invoice" menu
    And admin bangkerupux want to search invoice by "Invoice Number" and input field "<invoice>"
    Then admin bangkerupux click on shorlink invoice on invoice list "<shortlink>"
    Examples:
      | invoice               | shortlink                                   |
      | 34716463/2022/02/0009 | https://pay-jambu.kerupux.com/invoice/fTbwj |
      | 12865544/2022/02/0082 | https://pay-jambu.kerupux.com/invoice/lTRwj |
      | 57653153/2022/02/0003 | https://pay-jambu.kerupux.com/invoice/9H9CP |

  @TEST_DOM-687 @Automated @web-covered
  Scenario Outline: [BackOffice][Invoice Security] Open invoice Paid froms list GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "GoldPlus Invoice List" menu
    And admin bangkerupux want to search invoice by "Invoice Number" and input field "<invoice>"
    Then admin bangkerupux click on shorlink invoice on invoice list "<shortlink>"
    Examples:
      | invoice                    | shortlink                                                                                                                             |
      | GP2/20220217/00005909/3769 | https://pay-jambu.kerupux.com/invoice/select-payment/48481?signature=83511d18f0cb74ebd3c45c6d1ae0c3904672603da4a699ee9b5fb3a945352323 |

  @TEST_DOM-686 @Automated @web-covered
  Scenario Outline: [BackOffice][Invoice Security] Open Invoice Expired Booking from All invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "All Invoice List" menu
    And admin bangkerupux want to search invoice by "Invoice Number" and input field "<invoice>"
    Then admin bangkerupux click on shorlink invoice on invoice list "<shortlink>"
    Examples:
      | invoice                  | shortlink                                                                                                                             |
      | PRE/20220221/50864/80817 | https://pay-jambu.kerupux.com/invoice/select-payment/48611?signature=bab937d125dd83f785beaf0e53fe3405a0aea1aad95f4f8183f3b7c586c38c54 |
      | DP/19024270/2022/02/0185 | https://pay-jambu.kerupux.com/invoice/select-payment/48731?signature=995fe6af375ef93d58afcafa5b34a96766644988aa6e02f67262b12229aaf434 |
      | 44331680/2022/03/0017    | https://pay-jambu.kerupux.com/invoice/select-payment/46750?signature=081102610d26b3bdcaffc1ecd5ad29e277f179b2b6b9978878aab219183a5ff6 |

  @TEST_DOM-685 @Automated @web-covered
  Scenario: [BackOffice][Invoice Security] Open Invoice paid from list premium
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "PRE/20230814/56591/16250"
    Then admin verify see text "paid"
    *    admin bangkerupux click on shorlink invoice on invoice list "https://pay-jambu.kerupux.com/invoice/select-payment/97876?signature=38fcc2e07bfe0cc42dd67e018622e9076333811666c5189d5f6ae9c572c27783"

  @TEST_DOM-684 @Automated @web-covered
  Scenario: BackOffice][Invoice Security] Open invoice unpaid from list premium
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to package invoice list menu on premium invoice
    And admin bangkrupux search package invoice list premium by "Invoice Number" and input field "PRE/20230814/56592/78363"
    Then admin bangkerupux click on shorlink invoice on invoice list "https://pay-jambu.kerupux.com/invoice/select-payment/97907?signature=31cf780c263edeecee662927b00e6ecbab8119c90be8f3272d5e61fa42063a03"

  @TEST_DOM-683 @Automated @web-covered
  Scenario Outline: [BackOffice][Invoice Security] Open invoice unpaid froms list GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "GoldPlus Invoice List" menu
    And admin bangkerupux want to search invoice by "Invoice Number" and input field "<invoice>"
    Then admin bangkerupux click on shorlink invoice on invoice list "<shortlink>"
    Examples:
      | invoice                    | shortlink                                                                                                                             |
      | GP1/20230802/00012139/4597 | https://pay-jambu.kerupux.com/invoice/select-payment/96152?signature=88cf29ef9b9a01dc744213c9006a2417e153201de854e3be2e4ac65922972d9d |
      | GP2/20230801/00012132/6676 | https://pay-jambu.kerupux.com/invoice/select-payment/96000?signature=32b4422fdf70734dc879f1af84df1d4a8eb81a1c7d3f3df115a706e6f67ffd43 |