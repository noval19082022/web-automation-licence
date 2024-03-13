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
    And admin search billing tracker by "Nama Penyewa" and "viv"
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

  @TEST_COOP-3251 @TEST_COOP-3250 @continue
  Scenario: [Billing Tracker][Not follow up]Mark not follow up when data is follow up
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "081197878412"
    Then admin click on "Tandai Belum Follow-up"

  @TEST_COOP-3213 @TEST_COOP-3280 @continue
  Scenario: [Billing Tracker][Notes]Create notes on invoice
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "085832828287"
    Then admin can see tambah catatan button
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "085246224444"
    And admin fill notes tracker with:
      | type  | Pindah tipe kamar |
      | notes | pindah kamar 5    |
    Then admin can see notes with "Pindah tipe kamar"

  @TEST_COOP-3254 @continue
  Scenario: [Billing Tracker][Notes]Create notes for tag = Blast
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "085832828484"
    And admin fill notes tracker with:
      | type  | Blast             |
      | notes | Tutup jam 9 malam |
    Then admin can see notes with "Blast"

  @TEST-COOP-3252 @continue
  Scenario: [Billing Tracker][Notes]Check the display when invoice have many notes > 2 noted
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "085832828484"
    And admin fill notes tracker with:
      | type  | Blast             |
      | notes | Tutup jam 9 malam |
    Then admin can see notes with "Blast"

  @continue
  Scenario: [Billing Tracker][View Data]Check invoice billing when tenant have many recurring invoice
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "081280003230"
    Then Admin can see all invoice recurring from mamipay :
      | Jatuh Tempo | Nama Biaya |
      | 01 Mar      | Recurring  |
      | 07 Mar      | Recurring  |
      | 15 Mar      | Recurring  |

  @continue
  Scenario: [Billing Tracker][Notes]Create notes for many tag on 1 invoice
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "085832828484"
    And admin click on Lihat lebih banyak catatan note dropdown
    Then admin can see notes with "Blast"

  Scenario: [Billing Tracker][Notes]Edit notes
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "085832626262"
    And admin edit note "Pindah tipe kamar"
    Then admin can see notes with "Pindah tipe kamar"
    And admin edit note "Blast"
    Then admin can see notes with "Blast"
