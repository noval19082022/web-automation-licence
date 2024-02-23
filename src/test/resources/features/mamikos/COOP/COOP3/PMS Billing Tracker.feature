@COOP3 @billingTracker
Feature: Billing Tracker

  @TEST_COOP-3259 @continue
  Scenario: [Billing Tracker][Search]By Nama Penyewa when [Keywords] >= 3
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to billing tracker
    And admin search billing tracker by "Nama Penyewa" and "ed"
    Then admin can see validation "Minimal 3 karakter"
    And admin search billing tracker by "Nama Penyewa" and "edi"
    Then admin can see data search

  @TEST_COOP-3208 @continue
  Scenario: [Billing Tracker][Search]Reset search & filter results
    When admin click on reset button
    And admin filter for "Maya"
    Then admin can see data search
    And admin click on reset button
    Then admin can see data search
    And admin filter for "Okta"
    Then admin can see data search
    And admin click on reset button
    Then admin can see data search

  @TEST_COOP-3244 @TEST_COOP-3242 @continue
  Scenario: [Billing Tracker][Follow up]Mark follow up when data is not follow up
    When admin search billing tracker by "No. HP Penyewa" and "081197878412"
    And admin click on "Tandai Sudah Follow-up"
    Then admin can see bulk "Tandai Belum Follow-up"

  @TEST_COOP-3251 @TEST_COOP-3250
  Scenario: [Billing Tracker][Not follow up]Mark not follow up when data is follow up
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "081197878412"
    Then admin click on "Tandai Belum Follow-up"
