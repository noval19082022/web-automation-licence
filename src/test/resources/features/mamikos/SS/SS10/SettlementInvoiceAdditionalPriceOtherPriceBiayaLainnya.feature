@regression @SS8
Feature: Settlement Invoice Additional Price Other Price / Biaya Lainnya

  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag | phone prod |
      | 0812000005 | 0812000005 |

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000005 | 0812000005 | qwerty123 |
    And user cancel booking

  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                | kost path prod               |
      | kost-sleman-kost-campur-eksklusif-kost-wild-rift-settlement-1 | Kos DC BAR Automation Tipe A |
    And user want to dismiss FTUE
    And tenant booking kost for "today"
    Then tenant should success booking kost

  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    And owner accept booking from tenant:
      | tenant stag               | tenant prod      |
      | Tenant Complementary Lima | Nunu And Willump |
    Then owner should redirect back to pengajuan booking page

  Scenario: Tenant Check Invoice number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000005 | 0812000005 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant get invoice number from riwayat booking
    And user logs out as a Tenant user

  @TEST_SS-4042
  Scenario: Admin Changed Basic Amount DP Settlement Invoice, Add Additional Price Biaya Lainnya And Biaya Tetap
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin clicks on invoice details first index:
      | search by    | renter_phone_number |
      | search value | 0812000005          |
    Then admin changes DP basic amount and verify total amount change on settlement invoice for tenant 907000:
      | search by    | renter_phone_number |
      | search value | 0812000005          |

  Scenario: Tenant Pay DP Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000005 | 0812000005 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "087708777618"
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice DP from riwayat booking
    And tenant set active page to 1
    And tenant get invoice number

  @TEST_SS-4043
  Scenario: Admin Add Additional Price Biaya Lainnya
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number      |
      | search value           | 0812000005               |
      | invoice number         | default                  |
      | additional price type  | default                  |
      | additional price title | Automation Biaya Lainnya |
      | addtional price value  | 50000                    |

  @TEST_SS-4041
  Scenario: Tenant Check Additional Price Biaya Lainnya Added By Admin On Settlement Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000005 | 0812000005 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice DP from riwayat booking
    And tenant set active page to 1
    Then tenant can see additional price "Automation Biaya Lainnya" with price "Rp50.000"

  Scenario: Owner Check Additional Price Biaya Lainnya Added By Admin On Manage Bills
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 081362464341 | 081362464341 | 1d0lt3stb4ru |
    And owner go to bill page of kost "Kost Wild Rift Settlement" on month of "current"
    And owner go to detail tagihan with tenant name is "Tenant Complementary Lima" and jatuh tempo is "Belum bayar - Jatuh tempo sekarang"
    Then owner can see additional price "Automation Biaya Lainnya" with price "Rp50.000"