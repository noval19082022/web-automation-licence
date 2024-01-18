@DOM2 @BackofficeStagging2
Feature: Payment Backoffice Staging 2 - Refund

  @TEST_COOP-5538 @Automated @web-covered
  Scenario: [BackOffice][Refund] Input invalid bank name
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin fill bank name "Bank Noval" on refund detail
    Then admin verify see text "No results found"

  @TEST_COOP-5539 @Automated @web-covered
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

  @TEST_COOP-5540 @Automated @web-covered
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
    And tenant select payment method Credit Card with cc number is "4811 1111 1111 1114", expired date month "01" years "25", and ccv is "123"
    And tenant close unused browser tab
    And tenant logs out

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

  @TEST_COOP-5541 @Automated @web-covered
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
    And tenant logs out

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

    ## flip step is comment impacted otp login on bigflip
#    #  Scenario: Admin payment from bigflip
#    Given admin go to big flip bussiness and login for test mode
#    * admin verify on flip test mode
#    When admin navigate to riwayat transaksi domestic page on big flip test mode
#    Then admin set force success transaction on flip
#
#    #  Scenario: Admin see that refund transaction in success
#    Given admin go to mamikos mamipay admin
#    When admin navigate to mamipay refund page
#    And admin visit transferred list on refund page
#    Then admin verify transferred transaction for user "testing automation refund" is visible

  @TEST_COOP-5542 @Automated @web-covered
  Scenario: [BackOffice][Refund] export Report
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    And admin want to export the refund report
    And admin choose export report for today
#  (this tc is comment to reduce log on BE side caused by bug)
#  (Bug report on ticket https://mamikos.atlassian.net/browse/DOM-4848)
#    And user click button download
#    Then user will get message success download and file exported send email

  @TEST_COOP-5543 @Automated @web-covered
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

  @TEST_COOP-5544 @Automated @web-covered
  Scenario: [BackOffice][Refund] transaction CreditCard On Transferred Tab
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    And admin search transferred refund by tenant Phone Number and input field "083829167577"
    Then admin verify see text "( from Credit Card )"

  @TEST_COOP-5545 @Automated @web-covered
  Scenario: [BackOffice][Refund] click Close Button Popup Refund
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin close the refund detail
    Then admin verify see text "Daftar Invoice Refund"

  @TEST_COOP-5546 @Automated @web-covered
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

  @TEST_COOP-5547 @Automated @web-covered
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
    And tenant logs out

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

        ## flip step is comment impacted otp login on bigflip
#    #  Scenario: Admin payment from bigflip
#    Given admin go to big flip bussiness and login for test mode
#    * admin verify on flip test mode
#    When admin navigate to riwayat transaksi domestic page on big flip test mode
#    Then admin set force success transaction on flip
#
#    #  Scenario: Admin see that refund transaction in success
#    Given admin go to mamikos mamipay admin
#    When admin navigate to mamipay refund page
#    And admin visit transferred list on refund page
#    Then admin verify transferred transaction for user "testing automation refund" is visible

  @TEST_COOP-5548 @Automated @web-covered
  Scenario: [BackOffice][Refund] direction Tab To Transferred Tab
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    Then admin verify see text "Receipt"

  @TEST_COOP-5549 @Automated @web-covered
  Scenario: [BackOffice][Refund] popup refund section bank
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin pick one invoice on list to refund
    And admin fill bank name "BANK MANTAP (Mandiri Taspen)" on refund detail
    Then admin verify bank name for refund is "BANK MANTAP (Mandiri Taspen)"

  @TEST_COOP-5550 @Automated @web-covered
  Scenario: [BackOffice][Refund] transaction Flip On Transferred Tab
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
    And admin visit transferred list on refund page
    And admin search transferred refund by tenant Phone Number and input field "083829167577"
    Then admin verify see text "Flip"

  @TEST_COOP-5551 @Automated @web-covered
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

  @TEST_COOP-5552 @Automated @web-covered
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

  @TEST_COOP-5553 @Automated @web-covered
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

  @TEST_COOP-1447
  Scenario: [BackOffice][Refund] Set transaction refund Failed
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
    And tenant logs out

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

        ## flip step is comment impacted otp login on bigflip
#    #  Scenario: Admin payment from bigflip
#    Given admin go to big flip bussiness and login for test mode
#    * admin verify on flip test mode
#    When admin navigate to riwayat transaksi domestic page on big flip test mode
#    Then admin set failed transaction on flip

  @TEST_COOP-5578
  Scenario: [BackOffice][Refund Menu][Failed Tab] resend from failed tab
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin navigate to mamipay refund page
        ## this step is comment impacted otp login on bigflip, and this tc is depend on
        ## Scenario: [BackOffice][Refund] Set transaction refund Failed
#    And admin visit failed list on refund page
#    And admin pick one invoice on failed list
#    And admin set to refund the paid invoice
#    Then admin verify see text "Refund transaction created."