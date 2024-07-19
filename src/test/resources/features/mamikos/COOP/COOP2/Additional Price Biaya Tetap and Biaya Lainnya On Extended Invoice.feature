@COOP2
Feature: Additional Price Biaya Tetap and Biaya Lainnya On Extended Invoice


  @SS-4973
  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod     |
      | 0890867321212 | 0890867321212  |

  @SS-4974 @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  @SS-4975
  Scenario: Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                                        | kost name prod                                        |
      | Test Automation Kost Bagas Automation HahaHehe Tobelo Halmahera Utara | Kost Bagas Automation HahaHehe Tobelo Halmahera Utara |
    When tenant booking kost
    Then tenant should success booking kost

  @SS-4976
  Scenario: Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08916727111    | 08916727111    | qwerty123    |
    And owner accept booking from tenant:
      | tenant stag          | tenant prod          |
      | Adi Auto Addons Satu | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @SS-4977
  Scenario: Tenant Pay 1st Month Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0890867321212"
    And tenant set active page to 0
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant get invoice number

  @SS-4978
  Scenario: Admin Add Additional Price Biaya Lainnya
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin add additional price:
      | search by              | renter_phone_number      |
      | search value           | 0890867321212            |
      | invoice number         | default                  |
      | additional price type  | default                  |
      | additional price title | Automation Biaya Lainnya |
      | addtional price value  | 50000                    |

  @SS-4979
  Scenario:  Tenant Check Additional Price Biaya Tetap and Biaya Lainnya Added By Admin On Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    Then tenant can sees total cost is equal to basic amount, admin fee plus additional price below
      | 50000 |

  @SS-4980
  Scenario:  Owner Check Additional Price Biaya Tetap and Biaya Lainnya Added By Admin On Manage Bills
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08916727111    | 08916727111    | qwerty123    |
    And owner goes to bills details
      | kost name stag                                                        | kost name prod                                        |
      | Test Automation Kost Bagas Automation HahaHehe Tobelo Halmahera Utara | Kost Bagas Automation HahaHehe Tobelo Halmahera Utara |
    And owner set Kelola Tagihan filter month to "next" month
    And owner go to detail tagihan with tenant name is "Adi Auto Addons Satu" and jatuh tempo is current month length
    Then owner can see additional price "Automation Biaya Lainnya" with price "Rp50.000"

