@DOM3 @apartmen
Feature: [Test-Execution][DOM] Web - apartment

  @TEST_SS-2973 @Automated @web-covered
  Scenario: [Web][Apartement] Positive Case Tenant Filter Apartment by Time Period
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user filter apartment by time period is "Harian"
    Then user see displays apartment lists by time period is "hari"

		#  Scenario: Positive case tenant filter apartment by time period "Mingguan"
    When user filter apartment by time period is "Mingguan"
    Then user see displays apartment lists by time period is "minggu"

		#  Scenario: Positive case tenant filter apartment by time period "Bulanan"
    When user filter apartment by time period is "Bulanan"
    Then user see displays apartment lists by time period is "bulan"

		#  Scenario: Positive case tenant filter apartment by time period "Tahunan"
    When user filter apartment by time period is "Tahunan"
    Then user see displays apartment lists by time period is "tahun"

  @TEST_SS-2975 @Automated @web-covered
  Scenario: [Web][Apartement] Positive case tenant search apartment by Area
    Given user go to mamikos homepage
    When user go to landing apartment
    Then user redirected to "/apartemen"
    And user search "Bandung" on landing apartment
    Then user will see displays apartment lists by area and city
      | Coblong       |
      | Buah batu     |
      | Pasteur       |
      | Sumur Bandung |
      | Coblong       |
      | Coblong       |
      | Coblong       |
      | Cicendo       |

  @TEST_SS-2978 @Automated @web-covered
  Scenario: [Web][Apartement] Positive Case Tenant Filter Apartment by Furniture
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user filter apartment by furniture is "Furnished"
    Then user see displays apartment lists by furniture is "Furnished"

		#  Scenario: Positive case tenant search apartment filter by furniture "Semi Furnished"
    When user filter apartment by furniture is "Semi Furnished"
    Then user see displays apartment lists by furniture is "Semi Furnished"

		#  Scenario: Positive case tenant search apartment filter by furniture "Not furnished"
    When user filter apartment by furniture is "Not furnished"
    Then user see displays apartment lists by furniture is "Not Furnished"

  @TEST_SS-2979 @Automated @web-covered
  Scenario: [Web][Apartement] Positive Case Tenant Sort Apartment by Price
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user filter apartment by price direction is "Acak"
    Then user see displays apartment lists by price direction is "Acak"

		#  Scenario: Positive case tenant sort the list of apartments from the cheapest
    When user filter apartment by price direction is "Harga Termurah"
    Then user see displays apartment lists by price direction is "Harga Termurah"

		#  Scenario: Positive case tenant sort the list of apartments most expensive
    When user filter apartment by price direction is "Harga Termahal"
    Then user see displays apartment lists by price direction is "Harga Termahal"

  @TEST_SS-2981 @Automated @web-covered
  Scenario: [Web][Apartement] Positive Case Tenant Filter Apartment by Unit Type
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user filter apartment by unit type is "1-Room Studio"
    Then user see apartment lists by unit type is "1-Room Studio"

		#  Scenario: Positive case tenant search apartment filter by unit type "1 BR"
    When user filter apartment by unit type is "1 BR"
    Then user see apartment lists by unit type is "1 BR"

		#  Scenario: Positive case tenant search apartment filter by unit type "2 BR"
    When user filter apartment by unit type is "2 BR"
    Then user see apartment lists by unit type is "2 BR"

		#  Scenario: Positive case tenant search apartment filter by unit type "3 BR"
    When user filter apartment by unit type is "3 BR"
    Then user see apartment lists by unit type is "3 BR"

		#  Scenario: Positive case tenant search apartment filter by unit type "4 BR"
    When user filter apartment by unit type is "4 BR"
    Then user see apartment lists by unit type is "4 BR"

  @TEST_SS-2982 @Automated @web-covered
  Scenario: [Web][Apartement] Login as Tenant Can View Profile Picture and Option Dropdown Menu Profile
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0891234567897  | 08100000622 | qwerty123 |
    Then tenant can see profile dropdown option

  @TEST_SS-2983 @Automated @web-covered
  Scenario: [Web][Apartement] Tenant Hubungi Pengelola
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0888881478  | 08100000622 | qwerty123 |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | Rane 78        |                |
    When user click on hubungi pengelola button
    And user select question "Boleh tahu alamat lengkap apartemen ini?"
    And user click send chat from popup
    Then chat room appear with latest message "Hai, terima kasih sudah berminat pada apartemen ini. Alamat lengkapnya adalah"

  @TEST_SS-2984 @Automated @web-covered
  Scenario: [Web][Apartement] Positive case tenant search apartment by keyword
    Given user go to mamikos homepage
    When user want to visit apartment list page from ads Dropdown
    Then user redirected to "/apartemen"
		#  Scenario: Positive case tenant search by input keyword on field search apartment
    And user search "Bandung" on landing apartment
    Then user will see displays apartment lists by area and city
      | Coblong       |
      | Sumur Bandung |
      | Coblong       |
      | Coblong       |
      | Coblong       |
      | Coblong       |
      | Sumur Bandung |
      | Bandung       |
		#  Scenario: Positive case tenant click logo for redirect to home page
    When user click mamikos logo on apartement list page
    Then user redirected to "/"

  @TEST_SS-2985 @Automated @web-covered
  Scenario: [Web][Apartement] Tenant Verify Profile Dropdown
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0891234567897  | 08100000622 | qwerty123 |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | Rane 78        |                |
    Then tenant can see profile dropdown option

  @TEST_SS-2987 @Automated @web-covered
  Scenario: [Web][Apartement] Tenant Contact Apartment
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0891234567897  | 08100000622 | qwerty123 |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | Rane 78        |                |
    And user click on hubungi pengelola button
    Then user see phone number field and selectable question options :
      | Bagaimana bisa menghubungi apartemen ini? |
      | Boleh tahu alamat lengkap apartemen ini?  |

  @TEST_SS-2988 @Automated @web-covered
  Scenario: [Web][Apartement] Tenant Verify Search Ads Dropdown
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user select the first apartment on the list apartment page
    And user want to visit cari kost list page from ads Dropdown
    Then user redirected to "/cari"

  @TEST_SS-2989 @Automated @web-covered
  Scenario: [Web][Apartement] Favorite an Apartment
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0891234567897  | 08100000622 | qwerty123 |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | Rane 78        |                |
    When user click on favorite btn on the apartment detail
    Then user get success message "Sukses tersimpan"
    And tenant navigate to favorite page
    Then tenant will see that the text "Rane 78" is displayed

  @TEST_SS-2990 @Automated @web-covered
  Scenario: [Web][Apartement] unFavorite an Apartment
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0891234567897  | 08100000622 | qwerty123 |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | Rane 78        |                |
    When user click on favorite btn on the apartment detail
    And tenant navigate to favorite page
    Then tenant should not be able to see the text "Rane 78"