@regression @pman2 @pman2-prod @pms @disbursement @disbursementNote

Feature: Disbursement note PMS

  @TEST_SS-758 @continue
  Scenario: Valid notes when character NOT NULL & <=1500
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to Disbursement menu
    And admin select disbursement period "Periode 1"
    And admin go to detail transfer "Khusus Automation"
      #admin inputs Characters in Keterangan section
    And admin inputs characters "note <= 1500"
    Then Keterangan Tambahan value "note <= 1500" is displayed

  @TEST_SS-640 @continue
  Scenario: Invalid notes when character NULL
    When admin does not input charaters
    Then the Simpan button is disable

  @TEST_SS-633
  Scenario: Invalid notes when character > 1500
    When admin inputs characters "note > 1500"
    Then error message is displayed