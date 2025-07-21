@pms @disbursement @regression @pman2

Feature: Disbursement List

  @TEST_SS-798
  Scenario: Search functionality
      #search empty keyword
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to Disbursement menu
    When admin search disbursement ""
    Then show all disbursement list
      #search prefix name
    When admin search disbursement "Kost Singgahsini"
    Then show all disbursement list
    When admin search disbursement "Kost Apik"
    Then show all disbursement list
      #search property name keyword
    When admin select disbursement period "Periode 1"
    And admin search disbursement "Khusus Automation"
    Then show only disbursment for "Kost Apik Khusus Automation PMAN Halmahera Utara"
      #search full property name
    When admin search disbursement "Kost Apik Khusus Automation PMAN Halmahera Utara"
    Then show only disbursment for "Kost Apik Khusus Automation PMAN Halmahera Utara"
      #search wrong keyword
    When admin search disbursement "lorem ipsum"
    Then show empty list disbursmement

  @TEST_SS-7725 @continue
  Scenario: Filter Jadwal Transfer Monthly 1st
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to Disbursement menu
    When admin select filter transfer period "Periode 1 (Tanggal 1)"
    Then filter transfer is "Transfer Bulanan"
    And filter transfer period is "Periode 1 (Tanggal 1)"
    And admin can see total transfer amount in "Periode 1"

  @TEST_SS-7726 @continue
  Scenario: Filter Jadwal Transfer Monthly 16th
    When admin select filter transfer period "Periode 2 (Tanggal 16)"
    Then filter transfer is "Transfer Bulanan"
    And filter transfer period is "Periode 2 (Tanggal 16)"
    And admin can see total transfer amount in "Periode 2"

  @TEST_SS-7727 @continue
  Scenario: Filter Jadwal Transfer Weekly 1st
    When admin select filter transfer "Transfer Mingguan"
    And admin select filter transfer period "Tanggal 1 (Cut Off: 23-30/31)"
    Then filter transfer is "Transfer Mingguan"
    And filter transfer period is "Tanggal 1 (Cut Off: 23-30/31)"
    And admin can see total transfer amount in "Transfer Tanggal 1"

  @TEST_SS-7728 @continue
  Scenario: Filter Jadwal Transfer Weekly 8th
    When admin select filter transfer period "Tanggal 8 (Cut Off: 1-7)"
    Then filter transfer is "Transfer Mingguan"
    And filter transfer period is "Tanggal 8 (Cut Off: 1-7)"
    And admin can see total transfer amount in "Transfer Tanggal 8"

  @TEST_SS-7729 @continue
  Scenario: Filter Jadwal Transfer Weekly 16th
    When admin select filter transfer period "Tanggal 16 (Cut Off: 8-15)"
    Then filter transfer is "Transfer Mingguan"
    And filter transfer period is "Tanggal 16 (Cut Off: 8-15)"
    And admin can see total transfer amount in "Transfer Tanggal 16"

  @TEST_SS-7730
  Scenario: Filter Jadwal Transfer Weekly 23th
    When admin select filter transfer period "Tanggal 23 (Cut Off: 16-22)"
    Then filter transfer is "Transfer Mingguan"
    And filter transfer period is "Tanggal 23 (Cut Off: 16-22)"
    And admin can see total transfer amount in "Transfer Tanggal 23"