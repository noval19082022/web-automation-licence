@regression @LIMO4 @landingPagePrime
Feature: Mamiprime Landing Page

  @TEST_LIMO-5699 @continue
  Scenario: Visit landing page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod  | password   |
      | 0890910001 | 0890910001  | qwerty123  |
    And user click on mamiprime widget at owner dashboard
    Then user redirected to mamiprime landing page

  @TEST_LIMO-5715 @continue
  Scenario: [WEB][Mamikos Prime][Landing Page] Entry point purchase mamiprime
    #entry point at header landing page
    When owner wants to buy mamiprime from header
    Then owner can see page "Pendaftaran MamiPrime"

    #entry point at product description
    Given owner access mamiprime landing page
    When owner wants to buy mamiprime from product description
    Then owner can see page "Pendaftaran MamiPrime"

  @continue
  Scenario: Benefit Mamiprime Landing Page
    When user redirected to mamiprime landing page
    Then owner can see benefit section

  @continue
  Scenario: Testimonial Mamiprime Landing Page
    When user redirected to mamiprime landing page
    Then owner can see testimonial section

  @TEST_LIMO-5701 @continue
    Scenario: [WEB][Mamikos Prime][FAQ] FAQ Mamikos Prime Landing Page
    Given owner access mamiprime landing page
    Then owner can see FAQ section

  Scenario: Contact Mamiprime Landing Page
    When user redirected to mamiprime landing page
    Then owner can see contact section