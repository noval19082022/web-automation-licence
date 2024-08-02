@COOP3 @billingTracker
Feature: Billing Tracker

  @SS-5077 @continue
  Scenario: [Billing Tracker][Search]By Nama Penyewa when [Keywords] >= 3
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to billing tracker
    And admin search billing tracker by "Nama Penyewa" and "ed"
    Then admin can see validation "Minimal 3 karakter"
    And admin search billing tracker by "Nama Penyewa" and "bag"
    Then admin can see data search

  @SS-5078 @continue
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

  @SS-5079 @continue
  Scenario: [Billing Tracker][Follow up]Mark follow up when data is not follow up
    When admin search billing tracker by "No. HP Penyewa" and "081197878412"
    And admin click on "Tandai Sudah Follow-up"
    Then admin can see bulk "Tandai Belum Follow-up"

  @SS-5080 @continue
  Scenario: [Billing Tracker][Not follow up]Mark not follow up when data is follow up
    When admin click on reset button
    And admin search billing tracker by "No. HP Penyewa" and "081197878412"
    Then admin click on "Tandai Belum Follow-up"

  @SS-5084 @continue
  Scenario: [Billing Tracker][View Data]Check invoice billing when tenant have many recurring invoice
    When admin click on reset button
    And admin choose month "Maret"
    And admin search billing tracker by "No. HP Penyewa" and "081280003230"
    Then Admin can see all invoice recurring from mamipay :
      | Jatuh Tempo | Nama Biaya |
      | 01 Mar      | Recurring  |
      | 07 Mar      | Recurring  |
      | 15 Mar      | Recurring  |

  @SS-5087 @continue
  Scenario: [Billing Tracker][Tenant phone number]Check phone number is same to tenant not verified phone number
    When admin click on reset button
    And admin choose month "Agustus"
    And admin search billing tracker by "No. HP Penyewa" and "085246113222"
    Then admin click on "081045645600" link button

  @SS-4307 @continue
  Scenario: [Billing Tracker][Title billing tracker]Check expands for Billing team announcement title
    When admin go to billing tracker
    And admin click on expand billing announcement
    Then admin can see bse tab list