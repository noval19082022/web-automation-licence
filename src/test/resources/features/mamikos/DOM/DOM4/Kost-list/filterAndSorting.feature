@DOM4
Feature: Filter and Sorting

  @TEST_SS-3202 @Automated @Web @discovery-platform @filter
  Scenario Outline: [Dweb][Listing Kos][Filter]Check description of filter
    Given user navigates to ugm kost listing
    Then user clicks the "<filter>" button and the description will appears "<desc>"
    Examples:
      | filter           | desc                                                                                                       |
      | Promo Ngebut     | Dapat diskon pembayaran pertama harga sewa. Diskon hanya berlaku selama program berlangsung.               |
      | Dikelola Mamikos | Pilihan Kos Terjamin. Disurvey langsung oleh Mamikos. Lokasi terverifikasi, bangunan kos lolos seleksi.    |
      | Kos Andalan      | Kos favorit dengan harga hemat, dengan berbagai pilihan tipe kamar. Tersebar di ratusan kota di Indonesia. |

  @TEST_SS-3199 @Automated @Web @discovery-platform @filter
  Scenario Outline: [Dweb][Listing Kos][Filter]Check filter gender and verify the result
    Given user navigates to ugm kost listing
    When user sets gender filter "<gender>"
    Then user validates the result kos gender is "<gender>"
    Examples:
      | gender |
      | Putra  |
      | Putri  |
      | Campur |

  @TEST_SS-3206 @Automated @Web @discovery-platform @filter
  Scenario Outline: [Dweb][Listing Kos][Filter] Check filter facilityShare and verify the result
    Given user navigates to ugm kost listing
    When user sets facility filter "<facilityShare>"
    Then user validates the result kos facility is "<facilityShare>"
    Examples:
      | facilityShare |
      | WiFi          |

  @TEST_SS-3204 @Automated @Web @discovery-platform @filter
  Scenario Outline: [Dweb][Listing Kos][Filter] Check filter kos rule and verify the result
    Given user navigates to ugm kost listing
    And user sets top kos rule filter "<kos rule>"
    Then user validates the result kos rule is "<kos rule>"
    Examples:
      | kos rule     |
      | Akses 24 Jam |

  @TEST_SS-3197 @Automated @Web @discovery-platform @filter
  Scenario: [Dweb][Listing Kos][Filter] Check Kos Andalan filter
    Given user navigates to ugm kost listing
    And user sets Kos Andalan filter
    Then user validated the result kos have Kos Andalan label

  @TEST_SS-3245 @Automated @Web @discovery-platform @filter
  Scenario: [Dweb][Listing Kos][Filter] Check Dikelola Mamikos filter functionality
    Given user navigates to ugm kost listing
    When user activate Dikelola Mamikos filter
    Then user validate the result kos have Dikelola Mamikos label

  @TEST_SS-3241 @Automated @Web @discovery-platform @filter
  Scenario: [Dweb][Listing Kos][Filter] Check Promo Ngebut filter
    Given user navigates to ugm kost listing
    And user sets Promo Ngebut filter
    Then user validated the result kos have Promo Ngebut label

  @TEST_SS-3240 @Automated @Web @discovery-platform @filter
  Scenario Outline: [Dweb][Listing Kos][Filter]Check time range filter functionality
    Given user navigates to ugm kost listing
    When user set range time filter "<timeFilter>"
    Then user validates the result range time is "<time>"
    Examples:
      | timeFilter     | time    |
      | Mingguan       | minggu  |
      | Per 3 Bulan    | 3 bulan |

  @TEST_SS-3244 @Automated @Web @discovery-platform @sorting
  Scenario: [Dweb][Listing Kos][Sorting] check sorting function "Harga Termahal"
    Given user navigates to ugm kost listing
    When user selects sorting "Harga tertinggi" in kost listing
    Then user can see kos list rearrange from expensive to cheaper

  @TEST_SS-3205 @Automated @Web @discovery-platform @sorting
  Scenario: [Dweb][Listing Kos][Sorting] check sorting function "Harga Termurah"
    Given user navigates to ugm kost listing
    When user selects sorting "Harga terendah" in kost listing
    Then user can see kos list rearrange from cheaper to expensive