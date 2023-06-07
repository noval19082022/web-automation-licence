@regression @voucher @BBM81

@TEST_BBM-650 @TEST_BBM-651
Feature: Apply Voucher For Kost Type Premium

#  Scenario: Admin Batalkan Contract
#    Given admin go to mamikos mamipay admin
#    When admin login to mamipay:
#      | email stag                   | email prod                   | password  |
#      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
#    And admin search contract by tenant kost name:
#      | kostName stag          | kostName prod    |
#      | Kos Raya Gasim         | Kos Raya Gasim   |
#    And admin terminate contract
#    Then admin should success terminate contract

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                                  |  email prod                                  | password  |
      | dorothy_ucqktkv_vijayvergiyaberg@tfbnw.net  |  dorothy_ucqktkv_vijayvergiyaberg@tfbnw.net  | mamikosqa |
    And user cancel booking
#
#  Scenario: Tenant Booking Kost
#    When user go to mamikos homepage
#    And tenant search kost then go to kost details:
#      | kost name stag            | kost name prod            |
#      | Kos Raya Gasim            | Kos Raya Gasim            |
#    And tenant booking kost
#    Then tenant should success booking kost

#  Scenario: Owner Accept Booking
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag     | phone prod     | password     |
#      | 083176408449   | 0895365624343  | qwerty123    |
#    And owner accept booking
#    Then owner should redirect back to pengajuan booking page
#
#  @continue
#  Scenario: Tenant Apply Voucher for Kost Type Premium
#    Given user go to mamikos homepage
#    When user login as tenant via facebook:
#      | email stag                                  |  email prod                                  | password  |
#      | dorothy_ucqktkv_vijayvergiyaberg@tfbnw.net  |  dorothy_ucqktkv_vijayvergiyaberg@tfbnw.net  | mamikosqa |
#    And tenant navigate to riwayat and draf booking
#    And tenant click button bayar sekarang
#    And tenant apply voucher:
#      | voucher name stag  | voucher name prod  |
#      | VAFORPREMIUM       | VAFORPREMIUM       |
#    Then tenant can see voucher is applied
#
#  Scenario: Tenant Apply Voucher Not Applicable Kost Type Premium
#    When tenant set active page to 1
#    And tenant apply voucher:
#      | voucher name stag   | voucher name prod |
#      | VANONPREMIUM1       | VANONPREMIUM1     |
#    Then tenant can see warning message "Kode voucher tidak bisa digunakan."