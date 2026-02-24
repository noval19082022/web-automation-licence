@regression @SS8

Feature: Invoice Detail Kost With DP

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag   | phone prod   |
      | 085432154321 | 085432154321 |

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 085432154321 | 085432154321 | qwerty123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                   | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-adi-automation-add-ons | Kos DC BAR Automation Tipe A |
    And tenant booking kost for "today" and input rent duration equals to 4
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag  | tenant prod  |
      | Sang Pencari | Sang Pencari |
    Then owner should redirect back to pengajuan booking page

  Scenario: Tenant Get Invoice Number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 085432154321 | 085432154321 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant get invoice number from riwayat booking

  @TEST_SS-3392
  Scenario: Deposit And Additional Fee In Invoice Detail Page For Full Payment
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number and go to invoice detail fee:
      | search by      | renter_phone_number |
      | search value   | 085432154321        |
      | invoice number | default             |
    Then admin can sees total cost is basic amount + admin fee