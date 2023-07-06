@BBM8
Feature: Check Detail Tagihan

  @TEST_BBM-57
  Scenario: Check detail tagihan when money disbursed to owner’s bank account for first invoice
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod     | password        |
      | 0890000000289   | 0890000000289  | Bismillah@01    |
    And owner go to bill page of kost "kost bima booking dp biaya lain dan denda automation Tobelo Utara Halmahera Utara" on month of "Juni"
    And user clicks Sudah bayar tab
    And owner go to detail tagihan with tenant name is "Tenant Untuk Full Payment Kos Saya Automation" and jatuh tempo is "Sudah ditransfer ke rekening Anda"
    Then user will see Status Tagihan and money disbursed to owner’s bank "Sudah ditransfer ke rekening Anda"
