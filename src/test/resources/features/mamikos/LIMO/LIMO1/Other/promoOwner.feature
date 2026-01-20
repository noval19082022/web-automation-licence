@promo @regression @promoOwner @LIMO1 @listing-monetization @aturPromoOwner @DONEMIGRATINGTONEWBOARD
Feature: Atur promo owner

  @TEST_LIMO-3646 @deletePromoFromAdmin @editPeriodeValidPromo
  Scenario: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Update promo owner AT" on search box
    And admin delete the promo admin

  @TEST_LIMO-3647 @createNewPromo @promoAktif @continue
  Scenario: Create new promo owner
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | password  |
      | 08713399866 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kos Fathul Khair Jetis Yogyakarta" on property saya page
    And owner atur promo owner
    And owner set active page to 1
    Then verify status promo is "Belum Ada"
    When owner create new promo owner with title "Update promo owner AT" for periode promo "tomorrow"
    Then verify judul promo "Update promo owner AT"
    When owner refresh page 1
    Then verify status promo is "Menunggu Verifikasi"

  @TEST_LIMO-3648 @editPromoMenungguVerifikasi @promoAktif @continue
  Scenario: Edit promo while status promo menunggu verifikasi
    Given owner edit promo kost owner with title "Update promo owner AT"
    Then verify judul promo "Update promo owner AT"
    When owner refresh page 1
    Then verify status promo is "Menunggu Verifikasi"

  @TEST_LIMO-3649 @editPeriodePromo @startDateMoreThanEndDate @promoAktif
  Scenario: Edit start date promo more than end date promo
    And owner edit promo kost owner with start date "the day after tomorrow" and end date "tomorrow"
    Then verify warning "Tanggal berakhir tidak boleh sebelum tanggal mulai." is displayed

  @TEST_LIMO-3650 @verifiedPromoOwner @promoAktif
  Scenario: Verifikasi Promo Owner from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Update promo owner AT" on search box
    Then admin verified the promo owner "Update promo owner AT"

  @TEST_LIMO-3651 @checkPromoAfterVerifiedAdmin @unvefiedPromoOwner
  Scenario: Check Promo Owner after verified by admin
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | password  |
      | 08713399866 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kos Fathul Khair Jetis Yogyakarta" on property saya page
    And owner atur promo owner
    And owner set active page to 1
    And verify status promo is "Aktif"

  @TEST-LIMO-3652 @unvefiedPromoOwner
  Scenario: Admin unverified promo
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Update promo owner AT" on search box
    Then admin unverified the promo owner

  @TEST-LIMO-3653 @checkPromoAfterUnverifiedAdmin @editPeriodeValidPromo @continue
  Scenario: Check Promo Owner after unverified by admin
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | password  |
      | 08713399866 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kos Fathul Khair Jetis Yogyakarta" on property saya page
    And owner atur promo owner
    And owner set active page to 1
    And verify status promo is "Menunggu Verifikasi"

  @TEST_LIMO-3654 @editPeriodePromo @validPeriodePromo @editPeriodeValidPromo
  Scenario: Edit valid periode promo
    And owner edit promo kost owner with start date "the day after tomorrow" and end date "the day after tomorrow"
    When owner click edit promo button
    And verify status promo is "Menunggu Verifikasi"

  @TEST_LIMO-3655 @deletePromoFromAdmin @editPeriodeValidPromo
  Scenario: Delete promo owner
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigates to Promo Owner
    And admin search the title promo "Update promo owner AT" on search box
    And admin delete the promo admin