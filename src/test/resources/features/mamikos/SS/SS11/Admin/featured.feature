@SS9
Feature: Listing Featured

  @TEST_SS-7285 @continue
  Scenario: [Web][Featured Listing][Data]Admin check kost when kost have review 0
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkerupux navigates listing featured menu
    And admin search by "kost_id" and input "1000042065" on fetaured list
    Then admin can see "Kost rini khai  Kartasura Sukoharjo" on list

  @TEST_SS-7290 @continue
  Scenario: [Web][Featured Listing][Filter]Admin search by kost name
    When admin bangkerupux navigates listing featured menu
    And admin search by "kost_name" and input "Kost Crully Kartasura Sukoharjo" on fetaured list
    Then admin can see "Kost Crully Kartasura Sukoharjo" on list

  @TEST_SS-7291 @continue
  Scenario: [Web][Featured Listing][Search]admin search by owner phone number
    When admin bangkerupux navigates listing featured menu
    And admin search by "phone_number" and input "082239391319" on fetaured list
    Then admin can see "082239391319" on list

  @TEST_SS-7288 @continue
  Scenario: [Web][Featured Listing][Search]admin search by kost id
    When admin bangkerupux navigates listing featured menu
    And admin search by "kost_id" and input "1000041912" on fetaured list
    Then admin can see "Kost Crully Kartasura Sukoharjo" on list

  @TEST_SS-7289 @continue
  Scenario: [Web][Featured Listing][Filter]Admin check filter by Featured Status
    When admin bangkerupux navigates listing featured menu
    And admin search by status "good"
    Then admin can see "Kost Crully Kartasura Sukoharjo" on list
    When admin search by status "not_good"
    Then admin can see "Kost check landmark Genteng Surabaya" on list

  @TEST_SS-7295 @continue
  Scenario: [Web][Featured Listing][Action]Admin flag Mark as Featured
    And admin bangkerupux navigates listing featured menu
    And admin search by "kost_id" and input "1000042065" on fetaured list
    When admin click "Mark as Featured" on listing
    Then admin can see "good" on list

  @TEST_SS-7296 @continue
  Scenario: [Web][Featured Listing][Action]Admin flag Unmark as Featured
    And admin bangkerupux navigates listing featured menu
    And admin search by "kost_id" and input "1000042065" on fetaured list
    When admin click "Unmark as Featured" on listing
    Then admin can see "was_good" on list

  @TEST_SS-7284 @continue
  Scenario: [Web][Featured Listing][Data]Admin check Photo button
    When admin bangkerupux navigates listing featured menu
    And admin search by "phone_number" and input "082239391319" on fetaured list
    And admin click "Photo" on listing
    Then admin can see "Kost Griya Naryo Tipe A Ngemplak Sleman" on list

  @TEST_SS-7283
  Scenario: [Web][Featured Listing][Data]Admin check featured Listing Menu
    When admin bangkerupux navigates listing featured menu
    Then featured table contains column
      | Kost ID                           |
      | Owner Phone Number                |
      | Owner Registered At               |
      | Room Name                         |
      | Chat Room Count                   |
      | Purchaser Category (yearly)       |
      | Purchase Frequency (yearly, freq) |
      | ARPU (yearly, gerak)              |
      | Rating                            |
      | Photo Card                        |
      | Featured Status                   |
      | Action                            |