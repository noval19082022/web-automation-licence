@regression @SS16 @harvest @lbt

  Feature: Search and Filter LBT

    @TEST_SS-11068 @searchLBT @continue
    Scenario: Search by No HP Pemilik
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email                | password   |
        | yudha@mamiteam.com   | II7ucivwqd |
      And admin click sidebar menu "Lead Base Tracker"
      And admin search LBT by "No. HP Pemilik" with "084811029938"
      Then admin validate "No. HP Pemilik" column in LBT table with "084811029938"

    @TEST_SS-11069 @searchLBT @continue
    Scenario: Search by Lead ID
      When admin clears LBT search
      And admin search LBT by "Leadbase ID" with "CLB463"
      Then admin validate "Leadbase ID" column in LBT table with "CLB463"
      When admin clears and search LBT with "ILB666"
      Then admin validate "Leadbase ID" column in LBT table with "ILB666"
      When admin clears and search LBT with "MLB704"
      Then admin validate "Leadbase ID" column in LBT table with "MLB704"
      When admin clears and search LBT with "NLB363"
      Then admin validate "Leadbase ID" column in LBT table with "NLB363"

    @TEST_SS-11070 @searchLBT @continue
    Scenario: Search by Nama Kost
      When admin clears LBT search
      And admin search LBT by "Nama Properti" with "Kost Menjangan Mart"
      Then admin validate "Nama Properti" column in LBT table with "Kost Menjangan Mart"
      When admin clears and search LBT with "menjangan"
      Then admin validate "Nama Properti" column in LBT table with "Kost Menjangan Mart"

    @TEST_SS-11071 @searchLBT
    Scenario: Search by Nama Pemilik
      When admin clears LBT search
      And admin search LBT by "Nama Pemilik" with "Muh Tofa"
      Then admin validate "Nama Pemilik" column in LBT table with "Muh Tofa"
      When admin clears and search LBT with "Tofa"
      Then admin validate "Nama Pemilik" column in LBT table with "Muh Tofa"
