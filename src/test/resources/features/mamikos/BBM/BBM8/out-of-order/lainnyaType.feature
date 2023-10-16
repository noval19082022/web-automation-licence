@arac @pms @BBM8
Feature: Create OOO "Lainnya" Type With/Without Note

  Background: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email                 | password    |
      | dhiandra@mamikos.com  | dh14ndr4321 |
    And admin go to room allotment page
    And admin search "Kost Singgahsini Auto Listing"
    And admin delete OOO on:
      | room number | start date |
      | 1           | 21         |
    Then admin can not see out of order on:
      | room number | start date |
      | 1           | 21         |

  @TEST_COOP-1071
  Scenario: Create OOO "Lainnya" with note
    When admin set out of order on room "1"
    And admin fill OOO data with:
      | type        | Lainnya    |
      | note        | WC Mampet  |
      | start date  | 21         |
      | end date    | 25         |
    Then admin can see out of order on:
      | room number | start date |
      | 1           | 21         |

  @TEST_COOP-1070
  Scenario: Create OOO "Lainnya" without note
    When admin set out of order on room "1"
    And admin fill OOO data with:
      | type        | Lainnya    |
      | start date  | 21         |
      | end date    | 25         |
    Then admin can see that save button is disable