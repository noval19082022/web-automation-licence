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

  @SS-5081 @continue
  Scenario: [Billing Tracker][Notes]Create notes on invoice
    When admin click on reset button
    And admin choose month "Mei"
    And admin search billing tracker by "No. HP Penyewa" and "085831212121"
    Then admin can see tambah catatan button
    When admin click on reset button
    And admin choose month "Agustus"
    And admin search billing tracker by "No. HP Penyewa" and "085246223424"
    And admin fill notes tracker with:
      | type  | Pindah tipe kamar |
      | notes | pindah kamar 5    |
    Then admin can see notes with "Pindah tipe kamar"

  @SS-5082 @continue
  Scenario: [Billing Tracker][Notes]Create notes for tag = Blast
    When admin click on reset button
    And admin choose month "Mei"
    And admin search billing tracker by "No. HP Penyewa" and "081045645600"
    And admin fill notes tracker with:
      | type  | Blast             |
      | notes | Tutup jam 9 malam |
    Then admin can see notes with "Blast"

  @SS-5083 @continue
  Scenario: [Billing Tracker][Notes]Check the display when invoice have many notes > 2 noted
    When admin click on reset button
    And admin choose month "Agustus"
    And admin search billing tracker by "No. HP Penyewa" and "085246113222"
    And admin fill notes tracker with:
      | type  | Blast             |
      | notes | Tutup jam 9 malam |
    Then admin can see notes with "Blast"

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

  @SS-5085 @continue @SS-4310 @SS-4309
  Scenario: [Billing Tracker][Notes]Create notes for many tag on 1 invoice
    When admin click on reset button
    And admin choose month "Agustus"
    And admin search billing tracker by "No. HP Penyewa" and "085246113222"
    And admin click on Lihat lebih banyak catatan note dropdown
    Then admin can see notes with "Blast"

  @SS-5086  @continue @SS-4308
  Scenario: [Billing Tracker][Notes]Edit notes
    When admin click on reset button
      And admin choose month "Juni"
    And admin search billing tracker by "No. HP Penyewa" and "083321214884"
    And admin edit note "Pindah tipe kamar"
    Then admin can see notes with "Pindah tipe kamar"
    And admin edit note "Blast"
    Then admin can see notes with "Blast"

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

  @SS-4378 @continue
  Scenario: [Billing Tracker][Productivity] Check filter combination contract status Sudah Checkout
    And admin click on reset button
    When admin choose month "Agustus"
    And admin filter contract status with "Sudah Check-out"
    Then admin can see contract status with "Sudah Check-out"

  @SS-4376 @continue
  Scenario: [Billing Tracker][Productivity] Check filter combination contract status Ajukan Checkout
    When admin click on reset button
    When admin choose month "Juni"
    And admin filter contract status with "Ajukan Check-out"
    Then admin can see contract status with "Ajukan Check-out"

  @SS-4375 @continue
  Scenario: [Billing Tracker][Productivity] Check filter combination contract status Aktif
    When admin click on reset button
    When admin choose month "Agustus"
    And admin filter contract status with "Aktif"
    Then admin can see contract status with "Aktif"

