@DOM3
Feature: [Test-Execution][DOM] Web - Platform

  @TEST_DOM-400 @Automated @web-covered
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

  @TEST_DOM-398 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @DOM3 @web-covered
  Scenario: [Test][Admin][SanJunipero] Create New Parent Using Virtual Tour, Allgoldplus. and Mami Checker Kost Type
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux create new san junipero parent
    And admin bangkrupux fills all field on create new san junipero parent "Automation Slug", "All_goldplus", "weekly", "Automation Tittle Tag", "Automation Tittle Header", "Automation Subtittle Header", "Akses 24 jam", "Automation FAQ", "Automation FAQ Answer"
    And admin bangkrupux check the checkbox Active on create new san junipero
    And admin bangkrupux save Sanjunipero on create new san junipero
    Then admin bangkerupux verify success create new sanjunipero "Success! Record success to saved."

  @TEST_DOM-399 @Automated @web-covered
  Scenario: [Web][Apartement] Positive case tenant search apartment by Area
    Given user go to mamikos homepage
    When user go to landing apartment
    Then user redirected to "/apartemen"
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

  @TEST_DOM-397 @Automated @web-covered
  Scenario: [Web][Landing Kos][Popular city] Search Another Category
    Given user go to mamikos homepage
    When user visit search page, and visit popular search based on "Area" for location on "Yogyakarta"
    Then user can see kost list is more than 10

  @TEST_DOM-396 @TESTSET_UG-4895 @TESTSET_UG-6226 @TESTSET_PF-1792 @Automated @web-covered
  Scenario: [Tenant][FB - Tennat login page]Login with FB
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                          | email prod                          | password    |
      | lingga_ccabvrn_marqansyah@tfbnw.net | lingga_ccabvrn_marqansyah@tfbnw.net | joinmamikos |
    Then navbar after login appears

  @TEST_DOM-395 @Automated @web-covered
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

  @TEST_DOM-393 @Automated @web-covered
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

  @TEST_DOM-391 @TESTSET_UG-6228 @Automated @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Visit Page - Play Video
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user want to play the video on LandingPage EnaknyaNgekos
    Then user see pop up video player is shown on EnaknyaNgekos LP and can play video it

  @TEST_DOM-390 @Automated @web-covered
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

  @TEST_DOM-388 @Automated @web-covered
  Scenario: [Web][Apartement] Login as Tenant Can View Profile Picture and Option Dropdown Menu Profile
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                              | email prod                              | password  |
      | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | mamikosqa |
    Then tenant can see profile dropdown option

  @TEST_DOM-385 @Automated @web-covered
  Scenario: [Web][Apartement] Tenant Hubungi Pengelola
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                              | email prod                              | password  |
      | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | mamikosqa |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | rane 78        |                |
    When user click on hubungi pengelola button
    And user select question "Boleh tahu alamat lengkap apartemen ini?"
    And user click send chat from popup
    Then chat room appear with latest message "Hai, terima kasih sudah berminat pada apartemen ini. Alamat lengkapnya adalah"

  @TEST_DOM-383 @Automated @web-covered
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

  @TEST_DOM-381 @Automated @web-covered
  Scenario: [Web][Apartement] Tenant Verify Profile Dropdown
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                              | email prod                              | password  |
      | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | mamikosqa |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | rane 78        |                |
    Then tenant can see profile dropdown option

  @TEST_DOM-382 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos] Footer - click App Store icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user want to click on App Store on the footer
    Then user redirected to "https://apps.apple.com/"

  @TEST_DOM-380 @Automated @web-covered
  Scenario: [Web][Apartement] Tenant Contact Apartment
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                              | email prod                              | password  |
      | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | mamikosqa |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | rane 78        |                |
    And user click on hubungi pengelola button
    Then user see phone number field and selectable question options :
      | Bagaimana bisa menghubungi apartemen ini? |
      | Boleh tahu alamat lengkap apartemen ini?  |

  @TEST_DOM-379 @Automated @web-covered
  Scenario: [Web][Apartement] Tenant Verify Search Ads Dropdown
    Given user visit page "/daftar/apartemen-di-jakarta"
    When user select the first apartment on the list apartment page
    And user want to visit cari kost list page from ads Dropdown
    Then user redirected to "/cari"

  @TEST_DOM-377 @Automated @web-covered
  Scenario: [Web][Apartement] Favorite an Apartment
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                              | email prod                              | password  |
      | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | mamikosqa |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | rane 78        |                |
    When user click on favorite btn on the apartment detail
    Then user get success message "Sukses tersimpan"
    And tenant navigate to favorite page
    Then tenant will see that the text "rane 78" is displayed

  @TEST_DOM-376 @Automated @web-covered
  Scenario: [Web][Apartement] unFavorite an Apartment
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                              | email prod                              | password  |
      | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | mamikosqa |
    And tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | rane 78        |                |
    When user click on favorite btn on the apartment detail
    And tenant navigate to favorite page
    Then tenant should not be able to see the text "rane 78"

  @TEST_DOM-375 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos] Footer - click Email Address
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open e-mail in footer
    Then user will see that the text "Halo, ada yang bisa kami bantu? Mohon isi form di bawah ini dengan lengkap." is displayed

  @TEST_DOM-374 @TESTSET_UG-6221 @TESTSET_PF-1792 @Automated @web-covered
  Scenario: [Web][Login][Pop Up Login] Pop up Close
    Given user go to mamikos homepage
    When user masuk sebagai
    And user click close on pop up login
    Then user verify pop up "Masuk ke Mamikos" "Saya ingin masuk sebagai" are not appeared

  @TEST_DOM-373 @TESTSET_UG-6228 @AUTOMATED @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos] Footer - click Whatsapp number
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open whatsapp in footer
    Then user redirected to "https://api.whatsapp.com/"

  @TEST_DOM-371 @Automated @web-covered
  Scenario: [Web][Pop up login] Tenant - Click Maps
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag | kost name prod               |
      | Desta tobello  | Kos DC BAR Automation Tipe A |
    Then user want to reached map section and see lihat peta button
    When user want to see more detail kost location
    And user click back button in login page
    And user want to report this kos
    Then user will see login pop up

  @TEST_DOM-368 @TESTSET_UG-4895 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Pengaturan page  - Change password]hidden for login social
    Given user go to mamikos homepage
    When user login as tenant via facebook:
      | email stag                              | email prod                              | password  |
      | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | lisagor_jiuogfi_rosenthalwitz@tfbnw.net | mamikosqa |
    And user visit page "/user"
    Then user should not be able to see the text "Pengaturan"

  @TEST_DOM-366 @Automated @DOM3 @web-covered
  Scenario: [Login][Owner] Login From Detail Page
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag | kost name prod               |
      | Desta tobello  | Kos DC BAR Automation Tipe A |
    And user want to reached map section and see lihat peta button
    And user want to see more detail kost location
    Then user will see login pop up

  @TEST_DOM-363 @Automated @DOM3 @web-covered
  Scenario: [Web][login]: Tenant - Can see maps
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag | kost name prod               |
      | Desta tobello  | Kos DC BAR Automation Tipe A |
    And user want to reached map section and see tanya alamat lengkap button
    Then user want to ask kost address

  @TEST_DOM-362 @Automated @DOM3 @web-covered
  Scenario: [Test][Landing Page][SanJunipero] Check room list
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag              | email prod              | password  |
      | uncle.coop1@mamikos.com | uncle.coop1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux preview action kost on sanjunipero page
    Then admin can see kost list is more than 0

  @TEST_DOM-360 @Automated @DOM3 @web-covered
  Scenario: [Web][Owner] Choose Add New Kos
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | password  |
      | 08119787884 | Perempuan |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    Then user redirected to "https://owner-jambu.kerupux.com/kos/create?step=1"

  @TEST_DOM-357 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @DOM3 @web-covered
  Scenario: [Test][Admin][SanJunipero] User able to activate or deactivate certain landing page
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag              | email prod              | password  |
      | uncle.coop1@mamikos.com | uncle.coop1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux deactive first sanjunipero on sanjunipero page
    Then admin bangkerupux will see last updated sanjunipero is current time
    And admin bangkerupux activate first sanjunipero on sanjunipero page
    Then admin bangkerupux will see last updated sanjunipero is current time

  @TEST_DOM-359 @Automated @DOM3 @web-covered
  Scenario: [Web][non login]: Login pop-up options appear
    Given user go to mamikos homepage
    When user visit page "/room/kost-kabupaten-halmahera-utara-kost-campur-eksklusif-desta-kost-tobello-tobelo-halmahera-utara"
    And user want to reached map section and see lihat peta button
    And user want to see more detail kost location
    Then user will see login pop up

  @TEST_DOM-358 @TESTSET_UG-6221 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Web][Login][Pop Up Login] From Listing Detail Page
    Given user go to mamikos homepage
    When user visit page "/room/kost-sleman-kost-campur-murah-kost-apik-desta-tipe-b-tamvan-2"
    Then user want to reached map section and see lihat peta button

  @TEST_DOM-349 @Automated @DOM3 @web-covered
  Scenario: [Test][Admin][SanJunipero] Slug name already exist
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux create new san junipero parent
    And admin bangkrupux fills all field on create new san junipero parent already exist "Automation Slug", "All_goldplus", "weekly", "Automation Tittle Tag", "Automation Tittle Header", "Automation Subtittle Header", "Akses 24 jam", "Automation FAQ", "Automation FAQ Answer"
    And admin bangkrupux check the checkbox Active on create new san junipero
    And admin bangkrupux save Sanjunipero on create new san junipero
    Then admin verify see text "The slug has already been taken."

  @TEST_DOM-342 @Automated @DOM3 @web-covered
  Scenario: [Web][Landing Kos][Popular city] Search Time Period
    Given user go to mamikos homepage
    When user open Popular Area in Yogyakarta
    Then user should redirect to link that contains "/kost/kost-jogja-murah"

  @TEST_DOM-341 @Automated @DOM3 @web-covered
  Scenario: [Web][Landing Kos][Popular campus] Search Kost Type
    Given user go to mamikos homepage
    When  user open Around University in UNDIP
    Then user should redirect to link that contains "/kost/kost-dekat-undip-semarang-murah"

  @TEST_DOM-337 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Google Play icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user click on Google play on the footer
    And tenant set active page to 1
    Then user redirected to "https://play.google.com/store/apps/details?id=com.git.mami.kos&utm_campaign=DAppAndroFooter&utm_source=DownloadAppFooter&utm_medium=DownloadAppFooter&utm_term=DownloadAppFooter"

  @TEST_DOM-331 @TESTSET_UG-4894 @TESTSET_PF-1792 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Bell Notification] Bell icon - lihat semua clicked
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787342 | Perempuan |
    And owner open notification icon
    And owner wants to see all notification
    Then user redirected to "/ownerpage/notification"

  @TEST_DOM-322 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Instagram icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open instagram in footer
    And tenant set active page to 1
    Then user redirected to "https://www.instagram.com/mamikosapp"

  @TEST_DOM-321 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Twitter icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open twitter in footer
    And tenant set active page to 1
    Then user redirected to "https://twitter.com/mamikosapp"

  @TEST_DOM-319 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Facebook icon
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open facebook in footer
    And tenant set active page to 1
    Then user redirected to "https://www.facebook.com/mamikosapp"

  @TEST_DOM-318 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open tentang kami in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/tentang-kami"

  @TEST_DOM-318 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open job mamikos in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/career"

  @TEST_DOM-318 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open promosikan kost anda in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/mamiads"

  @TEST_DOM-318 @TEST_DOM-304 @TEST_DOM-303 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open pusat bantuan in footer
    And tenant set active page to 1
    Then user redirected to "https://help.mamikos.com/"

  @TEST_DOM-318 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open blog mamikos in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/info/"

  @TEST_DOM-318 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open sewa kost untuk perusahaan in footer
    And tenant set active page to 1
    Then user redirected to "https://mamikos.com/info/mamikos-corporate-accommodation/"

  @TEST_DOM-318 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open kebijakan privasi in footer
    And tenant set active page to 1
    Then user redirected to "https://help.mamikos.com/post/kebijakan-privasi-mamikos"

  @TEST_DOM-318 @TEST_DOM-304 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Footer - click Syarat dan Ketentuan - kebijakan privasi - corporate - blog - help - mamiads - career - tentang kami
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open syarat dan ketentuan in footer
    And tenant set active page to 1
    Then user redirected to "https://help.mamikos.com/category/umum/syarat-dan-ketentuan"

  @TEST_DOM-316 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Promo page] User can open promo detail
    Given user navigates to promo mamikos
  ## this step is comment because page https://promo.mamikos.com/ is empty
#    And user see the promo title in first promo
#    When user click see detail on first promo
#    Then detail promo page opened with correct title
#    And user see button booking now

  @TEST_DOM-312 @Automated @DOM3 @web-covered
  Scenario: [Test][Admin][SanJunipero] User able to enable certain landing page
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux deactive first sanjunipero on sanjunipero page
    Then admin bangkerupux will see last updated sanjunipero is current time
    And admin bangkerupux activate first sanjunipero on sanjunipero page
    Then admin bangkerupux will see last updated sanjunipero is current time
    And admin bangkerupux preview action kost on sanjunipero page
    Then admin can see kost list is more than 0

  @TEST_DOM-314 @TEST_DOM-313 @Automated @DOM3 @web-covered
  Scenario: [Tenant][Promo page] Check pagination in promo page
    Given user navigates to promo mamikos
  ## this step is comment because page https://promo.mamikos.com/ is empty
#    When user click next page button
#    Then next promo page will be opened
#    When user click previous page button
#    Then previous promo page will be opened
#    When user click page index "2"
#    Then promo page "2" will be opened

  @TEST_DOM-302 @TESTSET_UG-6228 @AUTOMATED @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: View Content - click Cari kos Singgahsini
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user open singgahsini in footer
    And tenant set active page to 1
    Then user redirected to "https://singgahsini.id/"

  @TEST_DOM-298 @TESTSET_PF-1393 @Automated @DOM3 @web-covered
  Scenario Outline: [WEB Tenant][Register] error message "Penulisan alamat email salah"
    Given user go to mamikos homepage
    When user want to register as tenant
    And user fills out registration form without click register "Rheza Haryo Hanggara", "08210391239921", "<Email>", "Password123", " "
    Then user will see that the text "<Error Message>" is displayed
    Examples:
      | Email             | Error Message                                  |
      | asdasd.com        | Gunakan format email seperti: mami@mamikos.com |
      | draft@xyz.com.net | Mohon masukkan email yang valid                |

  @TEST_DOM-297 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - Scroll Page
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    Then user verify see button Mulai Cari Kos when scroll into Kenapa #EnaknyaNgekos

  @TEST_DOM-296 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @DOM3 @web-covered
  Scenario: [Test][Filter][Landing Page][SanJunipero] Check on Gender filter data kost in the landing page
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux preview action kost on sanjunipero page
    And admin open gender filter on landing
    Then user will see that the text "Campur" is displayed
    Then user will see that the text "Putra" is displayed
    Then user will see that the text "Putri" is displayed

  @TEST_DOM-295 @TESTSET_MT-1726 @TESTSET_UG-6247 @TESTSET_PF-1952 @TESTSET_PF-1400 @Automated @DOM3 @web-covered
  Scenario: [Test][Filter][Landing Page][SanJunipero] Check on filter data kost in the landing page
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/sanjunipero/parent"
    And admin bangkerupux preview action kost on sanjunipero page
    Then user will see that the text "Semua Tipe Kos" is displayed
    Then user will see that the text "Semua Area" is displayed
    Then user will see that the text "Paling direkomendasikan" is displayed

  @TEST_DOM-292 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - click Booking Kos
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user click booking kos button
    Then user redirected to "/booking"

  @TEST_DOM-293 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - click Fitur Unggulan
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user clicks on Fitur Unggulan on the header on enaknyangekos page
    Then user will see that the text "Fitur-fitur yang kamu pakai buat #EnaknyaNgekos" is displayed

  @TEST_DOM-291 @TESTSET_PF-1393 @TESTSET_PF-1951 @Automated @DOM3 @web-covered
  Scenario: [WEB Tenant][Register] error message "Nomor handphone harus diawali dengan 08."
    Given user go to mamikos homepage
    When user want to register as tenant
    And user fills out registration form without click register "Rheza Haryo Hanggara", "666", "email@gmail.com", "Password123", " "
    Then user will see that the text "Nomor handphone harus diawali dengan 08." is displayed

  @TEST_DOM-290 @TESTSET_UG-6228 @Automated @DOM3 @web-covered
  Scenario: [Web Owner][Campaign EnaknyaNgekos]: Header - click Produk dan Layanan
    Given user visit page "/enaknyangekos"
    When user is on the LandingPage EnaknyaNgekos
    And user clicks on Product dan layanan on the header on enaknyangekos page
    Then user will see that the text "Kenapa #EnaknyaNgekos?" is displayed

  @TEST_DOM-271 @TESTSET_UG-4895 @TESTSET_PF-1792 @Automated @web-covered
  Scenario: [Tenant][Pengaturan page ]Ubah password valid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878412 | 083311231113 | qwerty123 |
    And user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "qwerty123"
    And user fills password baru "qwerty111"
    And user fills ketik ulang password "qwerty111"
    And user clicks on simpan password button
    Then user see successfully changed password "Password berhasil diubah"

  @TEST_DOM-384 @Automated @web-covered
  Scenario: [Tenant][Pengaturan page ] Restore Ubah password valid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878412 | 083311231113 | qwerty111 |
    And user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "qwerty111"
    And user fills password baru "qwerty123"
    And user fills ketik ulang password "qwerty123"
    And user clicks on simpan password button
    Then user see successfully changed password "Password berhasil diubah"

  @TEST_DOM-282 @Automated @DOM3 @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner redirection
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787342 | Perempuan |
    And owner go to event banner section
    And owner click on banner on dari mamikos section
    Then user redirected to "https://docs.google.com/forms/d/e/1FAIpQLSdGrn3lbLwSWxdb4tJ1hVJI7qi0nYW77sVXB0YsMXaA4tORKA/viewform"

  @TEST_DOM-279 @Automated @DOM3 @web-covered
  Scenario: [OD Revamp][Event Banner] Event banner check content
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787342 | Perempuan |
    And owner go to event banner section
    Then user will see that the text "Dari Mamikos" is displayed

  @TEST_DOM-277 @Automated @DOM3 @web-covered
  Scenario: [Web][Non Login][Pop Up Login] From Listing Detail Page
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag | kost name prod               |
      | Desta tobello  | Kos DC BAR Automation Tipe A |
    And user want to reached map section and see lihat peta button
    And user want to see more detail kost location
    Then user will see login pop up