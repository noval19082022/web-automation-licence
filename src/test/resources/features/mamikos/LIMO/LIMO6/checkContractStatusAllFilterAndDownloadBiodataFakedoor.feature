@LIMO6 @checkContractStatusBiodataFaker
Feature: check contract status on all filter and download biodata fakedoor


  @deleteContractOtherPrice @SS80
  Scenario: Delete contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by Renter Phone Number and input field "0892202357"
    And admin cancel contract

  @filterPenyewa @continue @TEST_SS-3540
  Scenario: check contract status on all filter
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And user navigate to penyewa page
    And user search kost in penyewa menu "Kost Singgahsini Noval Tipe A Tobelo Utara Halmahera Utara"
    And user click on dropdown Filter box and select filter:
      | Filter         |
      | Sedang menyewa |
    And user click on dropdown Filter box and select filter:
      | Filter     |
      | Akan masuk |
    Then user click on dropdown Filter box and select filter:
      | Filter                    |
      | Menghentikan kontrak sewa |

  @downloadBiodata @TEST_SS-3529 @TEST_SS-3530
  Scenario: Download biodata fakedoor
    Given user go to mamikos homepage
    And user navigate to penyewa page
    And user search kost in penyewa menu "ARAC"
    And user click download biodata penyewa button
    And user tick on checkbox pop up
    Then user will see information about upcoming feature