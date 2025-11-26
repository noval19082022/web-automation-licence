@LIMO1 @Mamifoto @mamifotoAdmin
Feature: Create invoice mamifoto from admin

  @TEST_LIMO-3568 @continue
  Scenario: [WEB][Admin] As Admin wants to create invoice mamifoto at menu premium add on
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to premium add on menu
    When admin create invoice mamifoto from phone number "082233545509"
    Then invoice mamifoto succsess created with status "unpaid" and for owner "082233545509"
    And mamikos bangkrupux admin should be successfully logged out

  @TEST_LIMO-3569
  Scenario: [WEB] Owner wants to paid Mamifoto Invoice from admin
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 082233545509 | 0          | 12345678 |
    * owner wants to accsess mamifoto
    * owner click riwayat paket button
    When owner see Riwayat MamiFoto purchase page
    Then owner can verify transaction have status "Menunggu Pembayaran" from "MamiFoto A GP"
    And payment owner success using ovo as payment method