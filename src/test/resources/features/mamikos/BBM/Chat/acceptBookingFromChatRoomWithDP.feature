@occupancyAndBilling @OB @BBM5 @BBM-3 @BBM-7 @acceptFromChat
Feature: Accept Booking from Chat room with DP

  Scenario: Delete contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number and akhiri contract:
      | phone stag  | phone prod    |
      | 08100000622 | 0890867321212 |

  @manageBooking @cancelBookingHentikanContract @continue
  Scenario: Owner hentikan kontrak from Add tenant from owner
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod    | password  |
      | 08100000622 | 0890867321212 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And user cancel booking

  @rentKostMonthWithDP
  Scenario: Tenant booking Bulanan for Kost set DP
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag      | kost name prod                        |
      | Kost Automation new | Kost Adi Auto FullPaid AddFee Deposit |
    And tenant booking kost for "today"
    Then tenant should success booking kost

  @TEST_BBM-5 @acceptBooking
  Scenario: Owner accept booking from Chat and see label on owner’s chat is “Belum Bayar Sewa Pertama (BBM-5)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password     |
      | 085600867992 | 0890867321212 | qwerty123 |
    And user click chat button in top bar owner home page
    And search chat in chatlist "Tenant Automation Accept Chat"
    And user clicks on Accept button from chat room
    And user click chat button in top bar owner home page
    Then system display title "Belum bayar DP" after accept booking from chat room

    #  Scenario: If label on owner’s chat is “Belum Bayar Sewa Pertama
    When Owner can see name of Tenant is "Tenant Automation Accept Chat"
    Then Owner can see Kost name, harga kos, sisa kamar