@arac @pms @BBM8
Feature: Create OOO "Lainnya" Type With/Without Note

  Background: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email                 | password    |
      | dhiandra@mamikos.com  | dh14ndr4321 |
    And Admin go to room allotment page
    And Admin search "Kost Singgahsini Auto Listing"
    And Admin delete OOO on:
      | room number | start date |
      | 1           | 21         |
    Then Admin can not see out of order on:
      | room number | start date |
      | 1           | 21         |

  @TEST_BBM-3727
  Scenario: Create OOO "Lainnya" with note
    When Admin create OOO on:
      | room number | 1          |
      | type        | Lainnya    |
      | note        | WC Mampet  |
      | start date  | 21         |
      | end date    | 25         |
    Then Admin can see out of order on:
      | room number | start date |
      | 1           | 21         |

  @TEST_BBM-3728
  Scenario: Create OOO "Lainnya" without note
    When Admin create OOO on:
      | room number | 1          |
      | type        | Lainnya    |
      | start date  | 21         |
      | end date    | 25         |
    Then Admin can see that save button is disable