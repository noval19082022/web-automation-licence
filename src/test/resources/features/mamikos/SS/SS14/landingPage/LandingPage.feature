Feature: Landing Page

  @TEST_SS-3218 @Automated @SS12 @dikelola-mamikos @dikelola-mamikos-filter @discovery-communication @landing-page
  Scenario: [Dweb][Landing Page][Filter] Check dikelola mamikos filter
    Given user navigates to mamikos kost kost jogja murah
    When user activate Dikelola Mamikos filter
    Then user validate the result kos have Dikelola Mamikos label

  @TEST_SS-3252 @Automated @SS12 @dikelola-mamikos @dikelola-mamikos-filter @discovery-communication @landing-page
  Scenario: [Dweb][Landing Page][Filter] Deactivate dikelola mamikos filter
    Given user navigates to mamikos kost kost jogja murah
    When user activate Dikelola Mamikos filter
    And user activate Dikelola Mamikos filter
    Then user see Dikelola Mamikos filter is deactivate

  @TEST_SS-3219 @Automated @SS12 @discovery-platform @landing-page @promo-ngebut-filter
  Scenario: [DWeb][Landing Page][Filter] Check promo ngebut filter
    Given user navigates to mamikos kost kost jogja murah
    And user sets Promo Ngebut filter
    Then user validated the result kos have Promo Ngebut label

  @TEST_SS-3214 @Automated
  Scenario Outline: [Dweb][Landing Page][Filter]Check description of <filter>
    Given user navigates to mamikos kost kost jogja murah
    Then user clicks the "<filter>" button and the description will appears "<desc>"
    Examples:
      | filter           | desc                                                                                                       |
      | Promo Ngebut     | Dapat diskon pembayaran pertama harga sewa. Diskon hanya berlaku selama program berlangsung.               |
      | Dikelola Mamikos | Pilihan Kos Terjamin. Disurvey langsung oleh Mamikos. Lokasi terverifikasi, bangunan kos lolos seleksi.    |
      | Kos Andalan      | Kos favorit dengan harga hemat, dengan berbagai pilihan tipe kamar. Tersebar di ratusan kota di Indonesia. |

  @TEST_SS-3248 @continue
  Scenario: [DWeb][Landing Page][Sorting] User Can Use Price Sorting From Lower To Greater
    Given user navigates to mamikos kost kost jogja murah
    When user set price sorting from lower to greater
    Then user can see kos list rearrange from cheaper to expensive

  @TEST_SS-3253
  Scenario: [DWeb][Landing Page][Sorting] User Can Use Price Sorting From Greater To Lower
    Given user navigates to mamikos kost kost jogja murah
    When user set price sorting from greater to lower
    Then user can see kos list rearrange from expensive to cheaper