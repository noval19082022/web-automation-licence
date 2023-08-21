@regression @surveyAdmin @BBM4

Feature: Admin Survey

  @TEST_BBM-512
  @continue
  Scenario Outline: Change the survey status to waiting
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | qaeautomation3@mamikos.com   | qaeautomation3@mamikos.com   |qwerty123 |
    And user edit Tenant Survey on "<name>"
    And user change survey status to "Waiting"
    Then user verify change survey success alert with "Success! Survey <name> (<kos>) berhasil dirubah"
    Examples:
      | name           | kos             |
      | Aditenant ubah | Kos Lempuyangan |

  @TEST_BBM-514
  @continue
  Scenario Outline: Change the survey status to on survey
    Given admin go to mamikos bangkrupux admin
    And user edit Tenant Survey on "<name>"
    And user change survey status to "On Survey"
    Then user verify change survey success alert with "Success! Survey <name> (<kos>) berhasil dirubah"
    Examples:
      | name           | kos             |
      | Aditenant ubah | Kos Lempuyangan |

  @TEST_BBM-518
  @continue
  Scenario Outline: Change the survey status to cancelled
    Given admin go to mamikos bangkrupux admin
    And user edit Tenant Survey on "<name>"
    And user change survey status to "Cancelled"
    Then user verify change survey success alert with "Success! Survey <name> (<kos>) berhasil dirubah"
    Examples:
      | name           | kos             |
      | Aditenant ubah | Kos Lempuyangan |

  @TEST_BBM-519
  @continue
  Scenario Outline: Change the survey date
    Given admin go to mamikos bangkrupux admin
    And user edit Tenant Survey on "<name>"
    And user change survey date to "Tomorrow"
    Then user verify change survey success alert with "Success! Survey <name> (<kos>) berhasil dirubah"
    Examples:
      | name           | kos             |
      | Aditenant ubah | Kos Lempuyangan |

  @TEST_BBM-515
  @continue
  Scenario Outline: Change the survey time
    Given admin go to mamikos bangkrupux admin
    And user edit Tenant Survey on "<name>"
    And user change survey time to "12:30"
    Then user verify change survey success alert with "Success! Survey <name> (<kos>) berhasil dirubah"
    Examples:
      | name           | kos             |
      | Aditenant ubah | Kos Lempuyangan |

  @TEST_BBM-517
  @continue
  Scenario: Filter by tenant name
    Given admin go to mamikos bangkrupux admin
    When user filter Tenant Survey using name on "Eremes Guile"
    Then user verify Tenant Name filter result with "Eremes Guile"

  @TEST_BBM-516
  @continue
  Scenario: Filter by survey status
    Given admin go to mamikos bangkrupux admin
    And user filter Tenant Survey using Status on "On Survey"
    Then user verify Tenant Status filter result with "Datang Survei"

  @TEST_BBM-510
  @continue
  Scenario: Filter by survey date
    Given admin go to mamikos bangkrupux admin
    And user filter Tenant Survey using survey date on "2022-01-24"
    Then user verify Tenant Survey Date filter result with "24 January 2022"

  @TEST_BBM-511
  @continue
  Scenario: Filter by tenant phone number
    Given admin go to mamikos bangkrupux admin
    And user filter Tenant Survey using phone on "087739881010"
    Then user verify Tenant Phone filter result with "087739881010"

  @TEST_BBM-509
  @continue
  Scenario: Filter by property name
    Given admin go to mamikos bangkrupux admin
    And user filter Tenant Survey using Kost name on "Kos Onan Gasim"
    Then user verify Tenant Kost Name filter result with "Kos Onan Gasim"
