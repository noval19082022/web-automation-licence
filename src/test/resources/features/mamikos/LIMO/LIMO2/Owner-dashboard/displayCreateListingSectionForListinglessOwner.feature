@LIMO3 @ODCreateProperty
#  source TC: https://mamiteam-qa3.atlassian.net/projects/LIMO?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.xpandit.plugins.xray__testing-board#!page=test-repository&selectedFolder=696468113f6ed945d4660896
Feature: Display Create Listing Section for Listingless Owner


#  https://mamiteam-qa3.atlassian.net/browse/LIMO-10777
#  Owner: 0811978788423/qwerty123
#  Owner does not have any listing with any status (add=0, draft=0, edited=0, unverified/rejected=0, verified=0)
  @TEST_LIMO-10777
  Scenario: [Owner][OD][CreateListing] Display welcome section and create listing flow
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0811978788423 | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    # Verify welcome section is displayed
    Then owner will see that the text "👋🏼 Selamat datang" is displayed
    Then owner will see that the text "Pasang iklan pertama Anda agar bisa segera ditemukan calon penyewa!" is displayed
    And owner can see Pasang Iklan Pertama button
    # Verify paid products section is NOT displayed for listingless owner
    And owner cannot see paid products section
    # Click on create listing section
    When owner clicks on Pasang Iklan Pertama button
    # Verify pilih property page appears
    Then owner can see pilih property page
    And owner can see Kos option in pilih property page
    And owner can see Apartemen option in pilih property page
    And owner can see Buat Kos button in pilih property page

# https://mamiteam-qa3.atlassian.net/browse/LIMO-10778
#  Owner: 0811978788423/qwerty123
#  Test selecting property type (Kos/Apartemen) and clicking Buat Iklan button
  @TEST_LIMO-10778
  Scenario Outline: [Owner][OD][CreateListing] Select property type and create listing - <property_type>
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0811978788423 | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    # Click on create listing section to open pilih property page
    When owner clicks on Pasang Iklan Pertama button
    # Select property type
    When owner selects <property_type> option
    Then owner can see "<property_type>" option is selected
    And owner can see <buat_button> button is enabled
    # Click on Buat button and verify redirect
    When owner clicks on <buat_button> button
    Then user should redirect to link "<redirect_url>"

    Examples:
      | property_type | buat_button    | redirect_url                                                  |
      | Kos           | Buat Kos       | https://owner-jambu.kerupux.com/kos/create?step=1             |
      | Apartemen     | Buat Apartemen | https://jambu.kerupux.com/ownerpage/add?create-apartemen=true |


#  https://mamiteam-qa3.atlassian.net/browse/LIMO-10779
#  Owner: 0811978788423/qwerty123
#  Test dismiss pilih property page without selecting any property type
  @TEST_LIMO-10779
  Scenario: [Owner][OD][CreateListing] Dismiss pilih property page without selecting
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0811978788423 | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    # Click on create listing section to open pilih property page
    When owner clicks on Pasang Iklan Pertama button
    Then owner can see pilih property page
    # Dismiss the pilih property page without selecting
    When owner dismisses the pilih property page
    # Verify owner remains on homepage
    And owner remains on owner dashboard
    # Verify create listing section is still displayed
    And owner can see Pasang Iklan Pertama button