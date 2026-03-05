@LIMO3 @ODCreateProperty
Feature: Display Create Listing Section for Listingless Owner

  @TEST_LIMO-10777
  Scenario: [Owner][OD][CreateListing] Display welcome section and create listing flow
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0811978788423 | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    Then owner will see that the text "👋🏼 Selamat datang" is displayed
    Then owner will see that the text "Pasang iklan pertama Anda agar bisa segera ditemukan calon penyewa!" is displayed
    And owner can see Pasang Iklan Pertama button
    And owner cannot see paid products section
    When owner clicks on Pasang Iklan Pertama button
    Then owner can see pilih property page
    And owner can see Kos option in pilih property page
    And owner can see Apartemen option in pilih property page
    And owner can see Buat Kos button in pilih property page

  @TEST_LIMO-10778
  Scenario Outline: [Owner][OD][CreateListing] Select property type and create listing - <property_type>
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0811978788423 | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    When owner clicks on Pasang Iklan Pertama button
    When owner selects <property_type> option
    Then owner can see "<property_type>" option is selected
    And owner can see <buat_button> button is enabled
    When owner clicks on <buat_button> button
    Then user should redirect to link "<redirect_url>"

    Examples:
      | property_type | buat_button    | redirect_url                                                  |
      | Kos           | Buat Kos       | https://owner-jambu.kerupux.com/kos/create?step=1             |
      | Apartemen     | Buat Apartemen | https://jambu.kerupux.com/ownerpage/add?create-apartemen=true |

  @TEST_LIMO-10779
  Scenario: [Owner][OD][CreateListing] Dismiss pilih property page without selecting
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0811978788423 | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    When owner clicks on Pasang Iklan Pertama button
    Then owner can see pilih property page
    When owner dismisses the pilih property page
    And owner remains on owner dashboard
    And owner can see Pasang Iklan Pertama button

  @TEST_LIMO-10782 @WEB @AUTOMATED @rejected-listing-earliest
  Scenario: Rejected listing section displays the earliest rejected listing
    # Owner with multiple rejected listings:
    # Kost A - rejected
    # Kost B - rejected (earliest)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081197878819 | 081197878819 | qwerty123 |
    And owner dismiss pop-up if appears
    Then owner will see that the text "⚠️ Iklan Gagal Diverifikasi" is displayed
    And the information listing section should display
    When owner clicks on Cek dan Perbaiki button
    Then owner should see the kos list page
    And the first kos should have rejected status
    Then the first kos in the list should be "Kost B Sukun Malang"

  @TEST_LIMO-10784 @WEB @AUTOMATED @submitted-listing
  Scenario: [Owner][OD][CreateListing] Display and interact with draft1/added listing section
    # Owner with submitted listing (waiting for admin confirmation):
    # - No active/rejected listing
    # - Has listing with status "submitted"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0811978788428 | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    Then the submitted listing section should be displayed with label "Sedang Diperiksa"
    And the submitted listing info message should be "Properti akan diverifikasi dalam 2x24 jam."
    And the submitted listing CTA should be "Lihat Iklan"
    And owner cannot see paid products section
    When owner clicks on Lihat Iklan button
    Then owner should be redirected to Properti Saya screen
