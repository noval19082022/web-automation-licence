@regression @kostReviewTenantSubmitted @SS8 @kostReview

Feature: Kost Review Submitted Display

  @TEST_SS-3627 @continue
  Scenario: Kost Review Submitted Display on Kos Saya Page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321201 | 0890867321201 | mamikosqa123 |
    And tenant navigate to kost saya page
    Then there will be a Kost Review submitted with the title "Kamu memberikan nilai:"
    And there will be a Kost Review submitted with the stars amount "3.0"

  @TEST_SS-3995 @continue
  Scenario: Kost Review Submitted Display on Berhenti Sewa Page
    When tenant navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    Then there will be a Kost Review submitted with the title "Kamu memberikan nilai:"
    And there will be a Kost Review submitted with the stars amount "3.0"

  @TEST_SS-3633
  Scenario: Kost Review Submitted Display on Riwayat Kos Page
    When tenant navigate to riwayat kos page
    Then user verify Kost Review entry point is not displayed