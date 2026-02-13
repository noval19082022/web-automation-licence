@LIMO7
Feature: Apply Voucher Annually For Contract Duration

  @continue
  Scenario: Get And Create Tenant Data Add Ons - Extended Contract
    When playwright create register device id for tenant with parameters:
      | device_identifier | Mamitest0890867321205     |
      | device_uuid       | Mamitest0890867321205uuid |
      | device_platform   | Mamitest                  |
      | phone_number      | 0890867321205             |
      | password          | mamikosqa123              |
    When tenant login trough api
    And playwright get tenant data profile

  @continue
  Scenario Outline: Get Active Contract And Active Booking For Add Ons - Extended Contract
    When playwright get tenant booking status with parameter:
      | page   |           |
      | sort   |           |
      | status | <booking> |
    Examples:
      | booking    |
      | booked     |
      | confirmed  |
      | verified   |
      | checked_in |

  @continue
  Scenario: Verify Active Contract And Active Booking For Add Ons - Extended Contract
    When playwright check for active contract and active booking

  @continue
  Scenario: Tenant Batalkan Pengajuan Sewa For Add Ons - Extended Contract
    And playwright batalkan pengajuan sewa for tenant

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0890867321205 | 0890867321205 |

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                                             | kost path prod           |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-adi-auto-with-dp | Kost Adi Auto Voucher DP |
    And tenant booking kost "tomorrow" "Per Tahun"
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag           | tenant prod           |
      | Adi Auto Voucher Satu | Adi Auto Voucher Satu |
    Then owner should redirect back to pengajuan booking page

  @TEST_SS-4255
  Scenario: Tenant Apply Voucher VYEARLYUSAGE
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321205 | 0890867321205 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant click button bayar sekarang
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | SS6ATVYY      | SS6ATVYY      |
    Then tenant can verify voucher discount calculation:
      | voucher code | discount percentage | maximal discount amount |
      | SS6ATVYY     | 50                  | 300000                  |