@arac @pms @SS8
Feature: Edit Out Of Order on PMS

  Background: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Ersa Tobelo Halmahera Utara"
    And admin delete OOO on:
      | room number | start date |
      | 2           | 18         |
    Then admin can not see out of order on:
      | room number | start date |
      | 2           | 18         |
    When admin set out of order on room "2"
    And admin fill OOO data with:
      | type       | Renovasi |
      | start date | 18       |
      | end date   | 26       |
    Then admin can see out of order on:
      | room number | start date |
      | 2           | 18         |

  @TEST_SS-3370
  Scenario: Edit OOO Status With Lainnya and Input Note
    When admin edit OOO on:
      | room number | start date |
      | 2           | 18         |
    And admin fill OOO data with:
      | type       | Lainnya     |
      | note       | Jadi Gudang |
      | start date | 18          |
      | end date   | 26          |
    Then admin can see out of order on:
      | room number | start date |
      | 2           | 18         |

  @TEST_SS-3369
  Scenario: Edit OOO Status With Lainnya and Not Input Note
    When admin edit OOO on:
      | room number | start date |
      | 2           | 18         |
    And admin fill OOO data with:
      | type       | Lainnya |
      | start date | 18      |
      | end date   | 26      |
    Then admin can see that save button is disable

  @TEST_SS-3368
  Scenario: Edit OOO for update start-end date
    When admin edit OOO on:
      | room number | start date |
      | 2           | 18         |
    And admin fill OOO data with:
      | type       | Undertable |
      | start date | 16         |
      | end date   | 27         |
    Then admin can see out of order on:
      | room number | start date |
      | 2           | 16         |
    When admin delete OOO on:
      | room number | start date |
      | 2           | 16         |
    Then admin can not see out of order on:
      | room number | start date |
      | 2           | 16         |

  @TEST_SS-3384
  Scenario: Edit OOO when end date smaller than start date
    When admin edit OOO on:
      | room number | start date |
      | 2           | 18         |
    And admin edit start date to "19"
    Then admin can see date 18 is disable

  @TEST_SS-3366
  Scenario: Edit OOO when end date already used other OOO
    When admin delete OOO on:
      | room number | start date |
      | 2           | 28         |
    Then admin can not see out of order on:
      | room number | start date |
      | 2           | 28         |
    When admin set out of order on room "2"
    And admin fill OOO data with:
      | type       | Renovasi |
      | start date | 28       |
      | end date   | 28       |
    Then admin can see out of order on:
      | room number | start date |
      | 2           | 28         |
    When admin edit OOO on:
      | room number | start date |
      | 2           | 28         |
    And admin fill OOO data with:
      | type       | Undertable |
      | start date | 18         |
      | end date   | 18         |
    Then admin can see popup with:
      | title    | Tidak dapat tandai “Out of Order”                               |
      | subtitle | Mohon maaf, kamar terisi dan tidak dapat ditandai Out of Order. |

  @TEST_SS-3367
  Scenario: Edit OOO when end date not used other OOO
    When admin edit OOO on:
      | room number | start date |
      | 2           | 18         |
    And admin fill OOO data with:
      | type       | Undertable |
      | start date | 18         |
      | end date   | 28         |
    Then admin can see out of order on:
      | room number | start date |
      | 2           | 18         |