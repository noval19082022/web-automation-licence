@LIMO5 @regression @landingpageowner
Feature: Entry Point Landing Page Owner

  @TEST_LIMO-365 @entrypointLPOwner @WEB @AUTOMATED
  Scenario: [Homepage][Non Login] User can see entry point landing page owner
    Given user go to mamikos homepage
    When user scroll into entry point landing page owner
    And user scroll into promo kost section
    Then user can see "Daftarkan Kos Anda di Mamikos" and button "Pelajari Lebih Lanjut" on Homepage
    And user click "Promosikan Iklan Anda"
    Then user can see title "Yuk, Segera Daftarkan Kos Anda di Mamikos" on Landing Page Owner

  @TEST_LIMO-364 @entrypointLPOwner @WEB @AUTOMATED
  Scenario: [Homepage][Login] User cannot see entry point landing page owner
  #tenant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag      | phone prod  | password     |
      | 0891111020199   | 0           | mamikosqa123 |
    Then user cannot see entry point landing page owner
    And user logs out as a Tenant user
  #owner
    When user login as owner:
      | phone stag     | phone prod | password  |
      | 0812345670001  | 0          | qwerty123 |
    And user go to mamikos homepage
    Then user cannot see entry point landing page owner
    When user click "Promosikan Iklan Anda"
    Then user redirected to mamiads page