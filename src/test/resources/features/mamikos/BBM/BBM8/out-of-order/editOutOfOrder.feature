@arac @pms @BBM8
Feature: Edit Out Of Order on PMS

  Background: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email                 | password    |
      | dhiandra@mamikos.com  | dh14ndr4321 |
    And admin go to room allotment page
    And admin search "Kost Singgahsini Auto Listing"
    And admin delete OOO on:
      | room number | start date |
      | 2           | 18         |
    Then admin can not see out of order on:
      | room number | start date |
      | 2           | 18         |
    When admin set out of order on room "2"
    And admin fill OOO data with:
      | type        | Renovasi   |
      | start date  | 18         |
      | end date    | 26         |
    Then admin can see out of order on:
      | room number | start date |
      | 2           | 18         |

  @TEST_BBM-3732
  Scenario: Edit OOO Status With Lainnya and Input Note
    When admin edit OOO on:
      | room number | start date |
      | 2           | 18         |
    And admin fill OOO data with:
      | type        | Lainnya     |
      | note        | Jadi Gudang |
      | start date  | 18          |
      | end date    | 26          |
    Then admin can see out of order on:
      | room number | start date |
      | 2           | 18         |

  @TEST_BBM-3733
  Scenario: Edit OOO Status With Lainnya and Not Input Note
    When admin edit OOO on:
      | room number | start date |
      | 2           | 18         |
    And admin fill OOO data with:
      | type        | Lainnya    |
      | start date  | 18         |
      | end date    | 26         |
    Then admin can see that save button is disable

  @TEST_BBM-3734
  Scenario: Edit OOO for update start-end date
    When admin edit OOO on:
      | room number | start date |
      | 2           | 18         |
    And admin fill OOO data with:
      | type        | Undertable |
      | start date  | 16         |
      | end date    | 27         |
    Then admin can see out of order on:
      | room number | start date |
      | 2           | 16         |
    When admin delete OOO on:
      | room number | start date |
      | 2           | 16         |
    Then admin can not see out of order on:
      | room number | start date |
      | 2           | 16         |

  @TEST_BBM-3737
  Scenario: Edit OOO when end date not used other OOO
    When admin edit OOO on:
      | room number | start date |
      | 2           | 18         |
    And admin fill OOO data with:
      | type        | Undertable |
      | start date  | 18         |
      | end date    | 28         |
    Then admin can see out of order on:
      | room number | start date |
      | 2           | 18         |