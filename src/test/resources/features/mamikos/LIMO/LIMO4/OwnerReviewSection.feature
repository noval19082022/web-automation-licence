@regression @LIMO4 @reviewOwner @flaky
Feature: Owner - Review Section

  @TEST_LIMO-1024 @doesnthavereview-listingcardclicked @WEB @AUTOMATED
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Doesn't have any review and Listing card clicked
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0812345670001 | 0812345670001 | qwerty123 |
    And user redirected to URL "https://owner-jambu.kerupux.com/kos/reviews"
    Then owner will see that the text "Belum ada user yang review kost" is displayed

  @TEST_LIMO-1078 @yourkosrating-listingcardclicked @continue @WEB @AUTOMATED
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Your kost rating and Listing card clicked
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202103 | 0891202103 | qwerty123 |
    Then user verify there are only 2 review lists
    When user click one of review lists
    Then user should see the review detail page

  @TEST_LIMO-1077 @seeAllRating @continue @WEB @AUTOMATED
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - See all rating
    When user click back button in page
    And owner click "Lihat semua ulasan"
    Then user should redirect to link "https://owner-jambu.kerupux.com/kos/reviews"

  @TEST_LIMO-1076 @ownerHasMoreThan2Listing @continue @WEB @AUTOMATED
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Owner has > 2 listings
    Then user verify there are more than 2 review lists

  @TEST_LIMO-1075 @ownerHasOneOrTwoListings @WEB @AUTOMATED
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Owner has 1 - 2 listings
    When user click back button in page
    Then user verify there are only 2 review lists

  @TEST_LIMO-1074 @ownerDoesntHaveAnyListing @WEB @AUTOMATED
  Scenario: [Owner Dahsboard][Rating Kost]Review Section - Owner doesn't have any listing
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 086412300123 | 086412300123 | qwerty123 |
    And user verify there is no kos review section
    Then user validate review section with "Waktunya Mengelola Properti"