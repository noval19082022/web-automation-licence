@COOP2
Feature: Additional Price Biaya Tetap and Biaya Lainnya On First Invoice

  @SS-4981
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod  |
      | 08912887122   | 08912887122 |

  @SS-4982 @continue
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 08912887122 | 08912887122     | qwerty123    |
    And user cancel booking

  @SS-4983
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                                | kost path prod            |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-first-invoice-bagas-hahahehe-tobelo-halmahera-utara | Kost Adi Auto SinggahSini |
    And tenant booking kost
    Then tenant should success booking kost

  @SS-4984
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 089172812122   | 089172812122   | qwerty123    |
    And owner accept booking from tenant:
      | tenant stag            | tenant prod            |
      | Bagas First Invoice At | Bagas First Invoice At |
    Then owner should redirect back to pengajuan booking page

  @SS-4985
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Tenant Get Invoice Number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 08912887122   | 08912887122   | qwerty123    |
    And tenant navigate to riwayat and draf booking
    And tenant get invoice number from riwayat booking

  @SS-4986
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Add Biaya Tetap + Biaya Lainnya On First Invoice From Mamipay
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number |
      | search value           | 08912887122         |
      | invoice number         | default             |
      | additional price type  | default             |
      | additional price title | Automation          |
      | addtional price value  | 50000               |

  @SS-4987
  Scenario: [Add Ons - Additional Price Biaya Tetap and Biaya Lainnya On First Invoice] Tenant Check Additional Price Biaya Tetap and Lainnya Added By Admin On Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 08912887122   | 08912887122   | qwerty123    |
    And tenant navigate to riwayat and draf booking
    And user open riwayat booking
    Then tenant can sees total cost is equal to basic amount, admin fee plus additional price below
      | 50000 |

  @SS-4988
  Scenario: Owner can sees total amount is basic amount plus other price
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 089172812122   | 089172812122   | qwerty123    |
    And owner goes to bills details
      | kost name stag                                                           | kost name prod      |
      | Test Automation Kost First Invoice Bagas Hahahehe Tobelo Halmahera Utara | Kost Adi Auto Fpaid |
    And owner go to detail tagihan with tenant name is "Adi Auto Addons Satu" and jatuh tempo is "Belum bayar - Jatuh tempo sekarang"
    Then owner can sees total amount is basic amount plus other price
      | 50000 |
		
