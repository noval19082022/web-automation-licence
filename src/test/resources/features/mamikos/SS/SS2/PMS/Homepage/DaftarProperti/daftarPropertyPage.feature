@regression @SS2 @pms @daftarPropertyPage

Feature: Daftar Property Page

  @TEST_SS-1141 @continue
  Scenario: Close Action Button in Daftar Property Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin clicks kebab button
    Then Action button is displayed in Daftar Property page
    When admin clicks outside Action Button
    Then Action button is dismiss

  @TEST_SS-1142
  Scenario: Check List Property which has 10 Properties in Daftar Property Page
    Then 10 Properties are displayed
