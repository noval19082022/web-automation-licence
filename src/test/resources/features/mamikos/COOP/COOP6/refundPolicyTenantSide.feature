@BBM6 @regression @refundPolishTenantSide @novalinter
Feature: Update Refund Policy kost pilar 1 and reguler

  @COOP-1353
  Scenario: Check refund policy on Tenant side for kost Reguler
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     | phone prod    | password      |
      | 0890000000314  | 0890000000314 | Bismillah@01  |
    And tenant search kost then go to kost details:
      | kost name stag       | kost name prod       |
      | Kost Garden Abepura  | Kost Garden Abepura  |
    Then tenant can see refund policy on kost detail
    When tenant click bagaimana ketentuannya
    Then tenant can see refund policy information with:
      | Bisa ajukan refund sebelum check-in |
      | Langsung lunas, bisa refund 100%    |
      | DP tidak bisa di-refund             |
      | Diproses setelah disetujui pemilik  |
    When tenant click refund policy mamikos
    And tenant set active page to 1
    Then user can see "bagaimana-cara-mengajukan-refund" on mamihelp page


  @TEST_COOP-1226 @COOP-1224
  Scenario: [Kost Detail][Bisa Refund] Tenant can see Refund Info for Kost Pillar 1 and check if Refund Policy redirect to correct page for Pillar1
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     | phone prod    | password      |
      | 0890000000314  | 0890000000314 | Bismillah@01  |
    And tenant search kost then go to kost details:
      | kost name stag                  | kost name prod       |
      | Kost Cibinong Bogor COOP Kece   | kost cibinong bogor  |
    And user dismiss FTUE booking benefit
    Then tenant can see refund policy on kost detail
    When tenant click bagaimana ketentuannya
    Then tenant can see refund policy information with:
      | Refund sebelum check-in               |
      | DP tidak dapat di-refund              |
      | Bayar langsung lunas dapat di-refund  |
    When user click on ketentuan waktu berikut
    And tenant set active page to 1
    Then user can see "https://jambu.kerupux.com/assets/_external-use/refund-policy/refund-policy-controlled-property.png" on mamihelp page