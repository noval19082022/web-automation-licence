@SS13
Feature: Kost Review

  @TEST_SS-4271
  Scenario: Cancel create review
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And user Create Review without contract data:
      | annonymous         | 0                                                |
      | review type        | Without Contract                                 |
      | OTA                | Traveloka                                        |
      | tenant name        | Rheza Haryo Hanggara                             |
      | tenant phoneNumber | 0898765432166                                    |
      | kost name          | Kost Adi Auto SinggahSini Tobelo Halmahera Utara |
      | start date         | today                                            |
      | end date           | tomorrow                                         |
    And user fill second Create Review data
      | kebersihan       | 5                                                          |
      | kenyamanan       | 5                                                          |
      | fasilitas kamar  | 5                                                          |
      | keamanan         | 5                                                          |
      | fasilitas umum   | 5                                                          |
      | kesesuaian harga | 1                                                          |
      | review field     | Just a test content that will match 25 characters of input |
    And user click cancel on Create Review section
    Then user redirected to "/admin/review"

  Scenario: Create review without contract
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And user Create Review without contract data:
      | annonymous         | 0                                                |
      | review type        | Without Contract                                 |
      | OTA                | Traveloka                                        |
      | tenant name        | Rheza Haryo Hanggara                             |
      | tenant phoneNumber | 0898765432166                                    |
      | kost name          | Kost Adi Auto SinggahSini Tobelo Halmahera Utara |
      | start date         | today                                            |
      | end date           | tomorrow                                         |
    And user fill second Create Review data
      | kebersihan       | 5                                                          |
      | kenyamanan       | 5                                                          |
      | fasilitas kamar  | 5                                                          |
      | keamanan         | 5                                                          |
      | fasilitas umum   | 5                                                          |
      | kesesuaian harga | 1                                                          |
      | review field     | Just a test content that will match 25 characters of input |
    And user click Save on Create Review section
    Then user verify success alert with "Success! Review added successfully."

  @continue
  Scenario: Edit review without contract
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And user Edit Review without contract data on "Just a test content that will match 25 characters of input":
      | annonymous         | 0                                                |
      | OTA                | Tiket                                            |
      | tenant name        | Rheza Haryo Hanggara Edit                        |
      | tenant phoneNumber | 0898765432166                                    |
      | kost name          | Kost Adi Auto SinggahSini Tobelo Halmahera Utara |
      | start date         | today                                            |
      | end date           | tomorrow                                         |
    And user fill second Create Review data
      | kebersihan       | 2                                                               |
      | kenyamanan       | 2                                                               |
      | fasilitas kamar  | 2                                                               |
      | keamanan         | 2                                                               |
      | fasilitas umum   | 2                                                               |
      | kesesuaian harga | 2                                                               |
      | review field     | Just a test content that will match 25 characters of input edit |
    And user click Save on Create Review section
    Then user verify success edit alert with "Success! Review Updated"

  @continue
  Scenario: Update kost review to Live
    Given admin go to mamikos bangkrupux admin
    And user click Live button on "Just a test content that will match 25 characters of input edit"
    Then user receive success alert for kost review updated to live with text "Success! Review Updated to live"

  @continue
  Scenario: Update kost review to Reject
    Given admin go to mamikos bangkrupux admin
    And user click Reject button on "Just a test content that will match 25 characters of input edit"
    Then user receive success alert for kost review updated to reject with text "Success! Berhasil menolak review"

  Scenario: Delete kost review
    Given admin go to mamikos bangkrupux admin
    And user click Delete button on "Just a test content that will match 25 characters of input edit"
    Then user receive success alert for deleted kost review with text "Success! Success, Review Deleted"

  Scenario: Create review with contract
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And user Create Review with contract data:
      | annonymous  | 0             |
      | review type | with_contract |
      | contract id | 29265         |
    And user fill second Create Review data
      | kebersihan       | 5                                                          |
      | kenyamanan       | 5                                                          |
      | fasilitas kamar  | 5                                                          |
      | keamanan         | 5                                                          |
      | fasilitas umum   | 5                                                          |
      | kesesuaian harga | 1                                                          |
      | review field     | Just a test content that will match 25 characters of input |
    And user click Save on Create Review section
    Then user verify success alert with "Success! Review added successfully."

  @continue
  Scenario: Edit review with contract
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | qaeautomation3@mamikos.com | qwerty123 |
    And user Edit Review wit contract data on "Just a test content that will match 25 characters of input":
      | annonymous  | 0     |
      | contract id | 29265 |
    And user fill second Create Review data
      | kebersihan       | 2                                                               |
      | kenyamanan       | 2                                                               |
      | fasilitas kamar  | 2                                                               |
      | keamanan         | 2                                                               |
      | fasilitas umum   | 2                                                               |
      | kesesuaian harga | 2                                                               |
      | review field     | Just a test content that will match 25 characters of input edit |
    And user click Save on Create Review section
    Then user verify success edit alert with "Success! Review Updated"

  Scenario: Delete kost review
    Given admin go to mamikos bangkrupux admin
    And user click Delete button on "Just a test content that will match 25 characters of input edit"
    Then user receive success alert for deleted kost review with text "Success! Success, Review Deleted"
		
