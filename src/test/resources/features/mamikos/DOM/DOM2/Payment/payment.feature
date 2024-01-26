@DOM2 @BackofficeStagging
Feature: Payment BackOffice Staging 1 - Search Contract and Edit Deposit

  Background: set active browser
    Given admin close unused browser tab

  @TEST_COOP-5519 @Automated @web-covered @continue
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

  @TEST_COOP-5520 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] Search Data Tenant Based On Period Yesterday
    Given admin go to mamikos mamipay admin
    When admin go to "Search Contract" menu
    And admin want to search contract periode for "Yesterday"
    Then admin redirect to search contract menu detail

  @TEST_COOP-5521 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] See detail pop up Apik
    Given admin go to mamikos mamipay admin
    When admin go to "Search Contract" menu
    And admin search contract by tenant phone number:
      | phone stag   | phone prod    |
      | 089220211208 | 0890867321212 |
    And admin search contract by kost level "APIK"
    And admin want to edit deposit
    Then admin will see detail pop up "Pastikan data rekening dan kerusakan sudah sesuai"

  @TEST_COOP-5522 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] input Bank Edit Deposit
    Given admin go to mamikos mamipay admin
    When admin go to "Search Contract" menu
    And admin search contract by tenant phone number:
      | phone stag   | phone prod    |
      | 081280003230 | 0890867321212 |
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    And admin want to choose "Bank Aceh Syariah" for transfer deposit
    Then admin see dropdown close and see bank "Bank Aceh Syariah"

  @TEST_COOP-5523 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] Input Damage Details more than 200 characters
    Given admin go to mamikos mamipay admin
    When admin search contract by Renter Phone Number and input field "089220211208"
    And admin want to edit deposit
    And admin input detail kerusakan "characters more than 200" on edit deposit page
    Then admin see maximal length "200/200"

  @TEST_COOP-5524 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] Admin simpan draft
    Given admin go to mamikos mamipay admin
    When admin search contract by Renter Phone Number and input field "081280003230"
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

  @TEST_COOP-5525 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] see Sisa Deposit
    Given admin go to mamikos mamipay admin
    When admin search contract by Renter Phone Number and input field "089220211208"
    And admin want to edit deposit
    Then admin will see detail pop up "Pastikan data rekening dan kerusakan sudah sesuai"
    And admin input biaya kerusakan "60000"
    Then admin will see additional notes menu deposit

  @TEST_COOP-5526 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] see Data Contract
    Given admin go to mamikos mamipay admin
    When admin go to "Search Contract" menu
    And admin want to see log contract
    Then admin will see detail pop up "Data Contract"

  @TEST_COOP-5527 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] see Popup Terminate Contract
     # aktivasi kontrak singgahsini
    Given admin go to mamikos mamipay admin
    When admin want to reactivate invoice by invoice number "69903537/2023/01/43864"

    # see detail pop up
    And admin search contract by tenant phone number:
      | phone stag   | phone prod   |
      | 089220220105 | 089220220105 |
    And admin search contract by kost level "SinggahSini"
    And admin akhiri contract
    Then admin should success terminate contract

  @TEST_COOP-5528 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] search Based On Period
    Given admin go to mamikos mamipay admin
    When admin search contract by Renter Phone Number and input field "089220220101"
    And admin search contract by kost level "SinggahSini"
    Then admin redirect to search contract menu detail

  @TEST_COOP-5529 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] See detail pop up Mamirooms
    Given admin go to mamikos mamipay admin
    When admin search contract by Renter Phone Number and input field "081177778888"
    And admin search contract by kost level "mamirooms"
    And admin want to edit deposit
    Then admin will see detail pop up "Pastikan data rekening dan kerusakan sudah sesuai"

  @TEST_COOP-5530 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] Search Data Tenant Based On Kost Level
    Given admin go to mamikos mamipay admin
    When admin go to "Search Contract" menu
    And admin search contract by kost level "Mamikos Goldplus 2"
    Then admin verify see text "Mamikos Goldplus 2"

  @TEST_COOP-5531 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] See detail pop up Singgah Sini
    Given admin go to mamikos mamipay admin
    When admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin will see Konfirmasi Sisa Deposit button hidden

  @TEST_COOP-5532 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] input Name Rekening Detail Edit Deposit
    Given admin go to mamikos mamipay admin
    When admin search contract by Renter Phone Number and input field "081280003230"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    Then admin input nama pemilik rekening on edit deposit page "Noval"

  @TEST_COOP-5533 @Automated @web-covered @continue
  Scenario Outline: [BackOffice][Search Contract][Edit Deposit] search Valid Input
    Given admin go to mamikos mamipay admin
    When admin search contract by "<searchBy>" and input field "<input>"
    Then admin redirect to search contract menu detail
    Examples:
      | searchBy               | input                 |
      | Kost Name              | Kost Princess         |
      | Owner Phone Number     | 083843666900          |
      | Renter Phone Number    | 083139263046          |
      | Renter Name            | Ullrich               |
      | Related Invoice Number | 83900841/2021/12/0043 |

  @TEST_COOP-5534 @Automated @web-covered @continue
  Scenario Outline: [BackOffice][Search Contract][Edit Deposit] search invalid Input
    Given admin go to mamikos mamipay admin
    When admin search contract by "<searchBy>" and input field "<input>"
    Then admin will get blank data detail
    Examples:
      | searchBy               | input               |
      | Kost Name              | kost anggun         |
      | Owner Phone Number     | 0856220211208       |
      | Renter Phone Number    | 0856220211208       |
      | Renter Name            | embul owner         |
      | Related Invoice Number | 83900841/2021/12/00 |
      | Related Invoice Code   | 83900841            |

  @TEST_COOP-5535 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit]input Nomor Rekening Detail Edit Deposit
    Given admin go to mamikos mamipay admin
    When admin search contract by Renter Phone Number and input field "081280003230"
    And admin search contract by kost level "SinggahSini"
    And admin want to edit deposit
    And admin want to choose "Bank Aceh Syariah" for transfer deposit
    Then admin see dropdown close and see bank "Bank Aceh Syariah"
    And admin input nomor rekening on edit deposit page "1550000036"

  @TEST_COOP-5536 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit Deposit] see Lihat Akhiri Kontrak
    # aktivasi kontrak singgahsini
    Given admin go to mamikos mamipay admin
    When admin want to reactivate invoice by invoice number "69903537/2023/01/43864"

    And admin search contract by tenant phone number:
      | phone stag   | phone prod   |
      | 089220220105 | 089220220105 |
    And admin search contract by kost level "SinggahSini"
    And admin akhiri contract
    Then admin should success terminate contract

  @TEST_COOP-5537 @TESTSET_PAY-3276 @TESTSET_PAY-5269 @TESTSET_PF-1394 @TESTSET_PF-2238 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Contract][Edit deposit] Input detail kerusakan detail pop up more than 200 character
    Given admin go to mamikos mamipay admin
    When admin search contract by Renter Phone Number and input field "089220211208"
    And admin want to edit deposit
    And admin input detail kerusakan "characters more than 200" on edit deposit page
    Then admin see maximal length "200/200"

  @TEST_COOP-1421
  Scenario: [BackOffice][Search Contract][Edit deposit] See Deposit Button for contract terminated
    Given admin go to mamikos mamipay admin
    When admin search contract by Renter Phone Number and input field "089220211208"
    Then admin verify see text "terminated"
