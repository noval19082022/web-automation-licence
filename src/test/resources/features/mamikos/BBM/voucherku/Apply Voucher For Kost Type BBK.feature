@regression @BBM7 @voucher

@TEST_BBM-681
Feature: Apply Voucher For Kost Type BBK
#    BBM-681
  Scenario: Invoice BBK and Voucher Applicable for Kost Type BBK
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     |  phone prod        | password      |
      | 0890867321217  |  0890867321217     | mamikosqa123  |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod   |
      | VBBKFORBOOKING1       | VBBKFORBOOKING1 |
    Then tenant can see voucher is applied

#    TENG-2516
  Scenario: Invoice BBK and Voucher Not Applicable for Kost Type BBK
    And tenant apply voucher:
      | voucher name stag | voucher name prod   |
      | VNABBKBOOKING1         | VNABBKBOOKING1 |
    Then Voucher code has been used

  Scenario: Invoice BBK and Voucher Applicable for Kost Type MAMIROOMS
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VMRBOOKING1         | VMRBOOKING1     |
    Then Voucher code has been used

  Scenario: Invoice BBK and Voucher Not Applicable for Kost Type MAMIROOMS
    And tenant apply voucher:
      | voucher name stag       | voucher name prod   |
      | VNMRBOOKING1              | VNMRBOOKING1      |
    Then tenant can see voucher is applied


  Scenario: Invoice BBK and Voucher Applicable for Kost Type Premium
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VAFORPREMIUM1         | VAFORPREMIUM1 |
    Then Voucher code has been used

  Scenario: Invoice BBK and Voucher Not Applicable for Kost Type Premium
    And tenant apply voucher:
      | voucher name stag       | voucher name prod   |
      | VNAFORPREMIUM1              | VNAFORPREMIUM1  |
    Then tenant can see voucher is applied


  Scenario: Invoice BBK and Voucher Applicable for Kost Type Verified By Mamichecker
    And tenant apply voucher:
      | voucher name stag | voucher name prod         |
      | VAFORMCHECKER1         | VAFORMCHECKER1       |
    Then Voucher code has been used

  Scenario: Invoice BBK and Voucher Not Applicable for Kost Type Verified By Mamichecker
    And tenant apply voucher:
      | voucher name stag       | voucher name prod     |
      | VNAFORMCHECKER1              | VNAFORMCHECKER1  |
    Then tenant can see voucher is applied


  Scenario: Invoice BBK and Voucher Applicable for Kost Type Garansi
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VAFORGARANSI1         | VAFORGARANSI1 |
    Then Voucher code has been used

  Scenario: Invoice BBK and Voucher Not Applicable for Kost Type Garansi
    And tenant apply voucher:
      | voucher name stag       | voucher name prod   |
      | VNAFORGARANSI1              | VNAFORGARANSI1  |
    Then tenant can see voucher is applied


  Scenario: Invoice BBK and Voucher Applicable for Kost Type Goldplus 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOGP1         | AUTOGP1             |
    Then Voucher code has been used

  Scenario: Invoice BBK and Voucher Not Applicable for Kost Type Goldplus 1
    And tenant apply voucher:
      | voucher name stag       | voucher name prod   |
      | AUTOVNAGP1              | AUTOVNAGP1          |
    Then tenant can see voucher is applied
