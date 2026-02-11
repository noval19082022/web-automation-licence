@LIMO2
#  source TC: https://mamiteam-qa3.atlassian.net/projects/LIMO?selectedItem=com.atlassian.plugins.atlassian-connect-plugin:com.xpandit.plugins.xray__testing-board#!page=test-repository&selectedFolder=696468113f6ed945d4660896
Feature: Display Create Listing Section for Listingless Owner


#  https://mamiteam-qa3.atlassian.net/browse/LIMO-10777
#  Owner: 0811978788423/qwerty123
#  Owner does not have any listing with any status (add=0, draft=0, edited=0, unverified/rejected=0, verified=0)
  @TEST_LIMO-10777
  Scenario: [Owner][OD][CreateListing] Display welcome section and create listing flow
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod | password  |
      | 0811978788423  | 0          | qwerty123 |
    And owner dismiss pop-up if appears
    # Verify welcome section is displayed
    Then owner will see that the text "👋🏼 Selamat datang" is displayed
    Then owner will see that the text "Pasang iklan pertama Anda agar bisa segera ditemukan calon penyewa!" is displayed
    And owner can see Pasang Iklan Pertama button
    # Verify paid products section is NOT displayed for listingless owner
    And owner cannot see paid products section
    # Click on create listing section
    When owner clicks on Pasang Iklan Pertama button
    # Verify bottom sheet "Pilih Jenis Properti" appears
    Then owner can see bottom sheet Pilih Jenis Properti
    And owner can see Kos option in bottom sheet
    And owner can see Apartemen option in bottom sheet
    And owner can see Buat Kos button in bottom sheet
