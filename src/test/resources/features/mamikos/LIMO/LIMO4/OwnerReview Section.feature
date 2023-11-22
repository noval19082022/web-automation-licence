@regression @LIMO4 @reviewOwner
Feature: Owner - Review Section

  @TEST_LIMO-3277 @doesnthavereview-listingcardclicked
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Doesn't have any review and Listing card clicked
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod      | password   |
      | 0812345670001   | 0812345670001   | qwerty123  |
    And user click on rating card details
    Then user validate review section with "Belum ada user yang review kost"

  @TEST_LIMO-3278 @yourkosrating-listingcardclicked @continue
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Your kost rating and Listing card clicked
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod   | password   |
      | 0891202103    | 0891202103   | qwerty123  |
    Then user verify there are only 2 review lists
    When user click one of review lists
    Then user should see the review detail page

  @TEST_LIMO-3279 @seeAllRating @continue
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - See all rating
    When user click back button in page
    And owner click "Lihat semua ulasan"
    Then user should redirect to link "https://owner-jambu.kerupux.com/kos/reviews"

  @TEST_LIMO-3280 @ownerHasMoreThan2Listing @continue
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Owner has > 2 listings
    Then user verify there are more than 2 review lists

  @TEST_LIMO-3281 @ownerHasOneOrTwoListings
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Owner has 1 - 2 listings
    When user click back button in page
    Then user verify there are only 2 review lists

  @TEST_LIMO-3282 @ownerDoesntHaveAnyListing
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Owner doesn't have any listing
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password   |
      | 086412300123   | 086412300123   | qwerty123  |
    And user verify there is no kos review section
    Then user validate review section with "Waktunya Mengelola Properti"