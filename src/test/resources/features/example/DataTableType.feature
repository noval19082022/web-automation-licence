Feature: Data Table Type Example

  @cobadata
  Scenario: How To Make Data Table
    Given print out data table bellow:
      | phone number staging    | 088808888881 |
      | phone number production | 088808888882 |
      | password                | qwerty123    |
    When print out data table list bellow:
      | emailstag                  |emailprod              | password        |
      | tenant@gmail.com           |tenantprod@gmail.com   |tenantpassword   |
      | owner@gmail.com            |ownerprod@gmail.com    |ownerpassword    |
      | admin@mamiteam.com         |adminprod@mamiteam.com | adminpassword   |