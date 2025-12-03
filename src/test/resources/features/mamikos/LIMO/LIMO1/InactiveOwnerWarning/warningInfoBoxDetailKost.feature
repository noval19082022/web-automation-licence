@LIMO6 @inactiveOwnerWarning
Feature: Inactive Owner Warning Info Box

  Background: Admin reset GP owner
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "0891202520"

  @TEST_LIMO-10068 @TEST_LIMO-10104
  Scenario:[Warning Info Box][Detail Kost] Warning info box reappears after navigating back from SRP
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                               | kost path prod                                      |
      | kost-kota-bontang-kost-campur-murah-kos-ququ-99-tipe-aa-bontang-utara-bontang | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And a tenant is on a property detail page where the inactive owner warning is displayed
    And the tenant clicks the close icon on the warning info box
    And the tenant navigates back to the Search Result Page SRP
    And then navigates back to the same property detail page
    Then the inactive owner warning info box should be displayed again

  @TEST_LIMO-10091
  Scenario:[Warning Info Box][Detail Kost] Admin fails to add an active owner to the inactive segment
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                     | email prod | password  |
      | uncle.limo2@admin-mamiteam.com |            | qwerty123 |
    And admin accsess menu whitelist feature
    And admin wants to add whitelist feature
    And admin click on dropdown feature
    And admin choose feature "inactive_owner_warning"
    And admin input owner id with "99454398"
    And admin click submit button whitelist
    Then admin verify see text "User `99454398` already whitelisted for feature `inactive_owner_warning`"

  @TEST_LIMO-10092 @TEST_LIMO-10102
  Scenario:[Warning Info Box][Detail Kost] Admin fails to add an active owner to the inactive segment
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                     | email prod | password  |
      | uncle.limo2@admin-mamiteam.com |            | qwerty123 |
    And admin accsess menu whitelist feature
    And admin wants to add whitelist feature
    And admin click on dropdown feature
    And admin choose feature "inactive_owner_warning"
    And admin input owner id with "99447855"
    And admin click submit button whitelist
    Then admin verify see text "User ID 99447855 is a GoldPlus owner"

  @TEST_LIMO-10106
  Scenario:[Warning Info Box][Detail Kost] Successfully Close Warning Info Box
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                               | kost path prod                                      |
      | kost-kota-bontang-kost-campur-murah-kos-ququ-99-tipe-aa-bontang-utara-bontang | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And a tenant is on a property detail page where the inactive owner warning is displayed
    And the tenant clicks the close icon on the warning info box
    Then tenant should not be able to see the text "Pemilik Kos Tidak Aktif"

  @TEST_LIMO-10105
  Scenario:[Warning Info Box][Detail Kost] Successfully Display Warning Info Box (Non LogIn User)
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                               | kost path prod                                      |
      | kost-kota-bontang-kost-campur-murah-kos-ququ-99-tipe-aa-bontang-utara-bontang | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And a tenant is on a property detail page where the inactive owner warning is displayed

  @TEST_LIMO-10094
  Scenario:[Warning Info Box][Detail Kost] Owner is automatically removed from inactive segment after purchasing GoldPlus
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                     | email prod | password  |
      | uncle.limo2@admin-mamiteam.com |            | qwerty123 |
    And admin accsess menu whitelist feature
    And admin wants to add whitelist feature
    And admin click on dropdown feature
    And admin choose feature "inactive_owner_warning"
    And admin input owner id with "99455096"
    And admin click submit button whitelist
    And admin logout from bangkrupux

    Scenario:tenant verify inactive owner warning
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                               | kost path prod                                      |
      | kost-kabupaten-tangerang-kost-campur-eksklusif-kost-suvarna-sutera-utara-tipe-a-cikupa-tangerang | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And a tenant is on a property detail page where the inactive owner warning is displayed
    And tenant logs out

  Scenario:owner buy package goldplus
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 0891202520   | 083176408442 | qwerty123 |
    And user click daftar GP button
    And user wants to subscribe Goldplus 1
    And owner select payment using alfamart xendit as payment method from invoice detail
    And owner navigates to owner dashboard
    And owner logs out

  Scenario:tenant verify inactive owner warning in detail kos page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                               | kost path prod                                      |
      | kost-kabupaten-tangerang-kost-campur-eksklusif-kost-suvarna-sutera-utara-tipe-a-cikupa-tangerang | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then tenant should not be able to see the text "Pemilik Kos Tidak Aktif"
