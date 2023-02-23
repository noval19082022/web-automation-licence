Feature: Filter and Sorting

  Scenario Outline: [Dweb][Listing Kos][Filter]Check description of filter
    Given user navigates to ugm kost listing
    Then user clicks the "<filter>" button and the description will appears "<desc>"
    Examples:
      | filter       | desc                                                                                                       |
      | Promo Ngebut | Dapat diskon pembayaran pertama harga sewa. Diskon hanya berlaku selama program berlangsung.               |
      | Kos Andalan  | Kos favorit dengan harga hemat, dengan berbagai pilihan tipe kamar. Tersebar di ratusan kota di Indonesia. |
    
  Scenario Outline: [Dweb][Listing Kos][Filter]Check filter gender and verify the result
    Given user navigates to ugm kost listing
    When user sets gender filter "<gender>"
    Then user validates the result kos gender is "<gender>"
    Examples:
      | gender |
      | Putra  |
      | Putri  |
      | Campur |

  Scenario Outline: [Dweb][Listing Kos][Filter] Check filter facilityShare and verify the result
    Given user navigates to ugm kost listing
    When user sets facility filter "<facilityShare>"
    Then user validates the result kos facility is "<facilityShare>"
    Examples:
      | facilityShare |
      | WiFi          |

  Scenario Outline: [Dweb][Listing Kos][Filter] Check filter kos rule and verify the result
    Given user navigates to ugm kost listing
    And user sets top kos rule filter "<kos rule>"
    Then user validates the result kos rule is "<kos rule>"
    Examples:
      | kos rule     |
      | Akses 24 Jam |

  Scenario: [Dweb][Listing Kos][Filter] Check Kos Andalan filter
    Given user navigates to ugm kost listing
    And user sets Kos Andalan filter
    Then user validated the result kos have Kos Andalan label

  Scenario: [Dweb][Listing Kos][Filter] Check Dikelola Mamikos filter
    Given user navigates to mamikos kost kost jogja murah
    When user click on Dikelola Mamikos filter
    Then user validate the result kos have Dikelola Mamikos label

  Scenario: [Dweb][Listing Kos][Filter] Check Promo Ngebut filter
    Given user navigates to ugm kost listing
    And user sets Promo Ngebut filter
    Then user validated the result kos have Promo Ngebut label