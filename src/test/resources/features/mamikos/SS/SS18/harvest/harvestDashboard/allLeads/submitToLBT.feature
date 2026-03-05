@regression @SS16 @harvest @harvestDashboard

Feature: Submit to LBT in All Leads Menu

  @TEST_SS-957 @context1 @context2 @continue
  Scenario: Check Edit Table button in All Leads menu
    Given admin set browser context to "context1"
    And bring page to front
    And admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin clicks on Edit Table button
    Then Yes and No buttons in every row are displayed

  @continue
  Scenario: Fill form register Singgahsini
    Given admin set browser context to "context2"
    And bring page to front
    And user navigates to singgahsini.id
    And user open register form
    And user submit daftar singgahsini
      | Nama Lengkap                 | No Handphone | Kos Name                      | Total Kamar | Kota   | Kecamatan | Kelurahan    | Alamat               |
      | Automation Testing Harvest   | 088820203113 | Kost Tes Automation Harvest   | 5           | Bantul | Kretek    | Parangtritis | Jl Jembatan Kretek 1 |
      | Automation Testing Harvest 2 | 088820203113 | Kost Tes Automation Harvest 2 | 3           | Bantul | Kretek    | Parangtritis | Jl Jembatan Kretek 1 |
    Then system show pop up success register
    When user confirm pop up
    Then user should be redirect to singgahsini.id

  @TEST_SS-951 @continue
  Scenario: Check Batalkan Edit button in All Leads Menu without Selects Radio Button
    Given admin set browser context to "context1"
    And bring page to front
    And admin filter ILB only
    Then Yes and No buttons in every row are displayed
    And admin clicks on Batalkan Edit button
    Then all Yes and No buttons in every row are dismiss

  @TEST_SS-1127 @continue
  Scenario: Check Batalkan Edit button in All Leads Menu with Selects Radio Button
    Given admin set browser context to "context1"
    And bring page to front
      #selects Yes on radio button
    And admin clicks on Edit Table button
    And admin selects "Yes" on radio button
    And admin clicks on Batalkan Edit button
    Then confirmation pop up "Batalkan" is displayed
      #selects No on radio button
    When admin clicks on Edit Table button
    And admin selects "No" on radio button
    And admin clicks on Batalkan Edit button
    Then confirmation pop up "Batalkan" is displayed

  @TEST_SS-1128 @continue
  Scenario: Check Actions Buttons in Confirmation Batalkan Pop Up
    Given admin set browser context to "context1"
    And bring page to front
    And admin clicks on Edit Table button
      #selects Yes on radio button and checks action button
    And admin selects "Yes" on radio button
    And admin clicks on Batalkan Edit button
    And admin clicks "Ya, Batalkan" button on confirmation Batalkan pop up
    Then the confirmation "Batalkan" pop up is dismissed
    And all Yes and No buttons in every row are dismiss
      #selects No on radio button and checks action button
    When admin clicks on Edit Table button
    And admin selects "No" on radio button
    And admin clicks on Batalkan Edit button
    And admin clicks "Close" button on confirmation Batalkan pop up
    Then the confirmation "Batalkan" pop up is dismissed
    When admin clicks on Batalkan Edit button
    And admin clicks "Tidak" button on confirmation Batalkan pop up
    Then the confirmation "Batalkan" pop up is dismissed

  @TEST_SS-943 @continue
  Scenario: Check Confirmation Perubahan Belum Tersimpan Pop Up When User Selects Yes
    Given admin set browser context to "context1"
    And bring page to front
      #selects Yes on radio button and clicks filter
    And admin selects "Yes" on radio button
    And admin clicks Filter in Harvest Dashboard
    Then confirmation pop up "Perubahan Belum Tersimpan" is displayed

  @TEST_SS-1129
  Scenario: Check Confirmation Perubahan Belum Tersimpan Pop Up When User Clicks on Filter
    Given admin set browser context to "context1"
    And bring page to front
      #selects Yes on radio button and checks action button
    And admin selects "No" on radio button
    And admin clicks Filter in Harvest Dashboard
    Then confirmation pop up "Perubahan Belum Tersimpan" is displayed