@SS4
Feature: Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement


  @SS-4973
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement] Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag    | phone prod    |
      | 0890867321212 | 0890867321212 |

  @SS-4974 @continue
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement] Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And user cancel booking

  @SS-5035
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement] Tenant Booking Kost
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                            | kost path prod                  |
      | kost-kabupaten-manggarai-kost-campur-eksklusif-kost-adi-auto-dp-additional-fee-langke-rembong-manggarai-1 | Kost Adi Auto DP AddFee Deposit |
    And tenant booking kost
    Then tenant should success booking kost

  @SS-5036
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement] Owner Accept Booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000021 | 08900000000021 | mamikosqa123 |
    And owner accept booking from tenant:
      | tenant stag          | tenant prod          |
      | Adi Auto Addons Satu | Adi Auto Addons Satu |
    Then owner should redirect back to pengajuan booking page

  @SS-5037
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement] Tenant Pay Down Payment For Invoice Detail Check After DP And Settlement Are Paid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "081280003230"
    And tenant set active page to 0
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page after pay DP
    And tenant get invoice number

  @SS-5038
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement] Invoice Detail Settlement Not Yet Paid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number and go to invoice detail fee:
      | search by      | renter_phone_number |
      | search value   | 0890867321212       |
      | invoice number | default             |
    Then admin can sees total cost is basic amount + deposit fee + biaya tetap + admin fee

  @SS-5039
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement] Tenant get invoice number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321212 | 0890867321212 | mamikosqa123 |
    And tenant navigate to riwayat and draf booking
    And tenant go to invoice DP from riwayat booking
    And tenant set active page to 1
    And tenant get invoice number

  @SS-5040
  Scenario: [Invoice admin - Deposit And Additional Fee in Invoice Detail Page for Paid DP And Paid Settlement] Invoice Detail Settlement Paid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search invoice by contact number and go to invoice detail fee:
      | search by      | renter_phone_number |
      | search value   | 0890867321212       |
      | invoice number | default             |
    Then admin can sees total cost is basic amount + deposit fee + biaya tetap + admin fee
		
