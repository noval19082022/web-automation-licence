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

    @TEST_SS-11086 @filterLBT @continue
    Scenario: Verify multiple filters work together
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email                | password   |
        | yudha@mamiteam.com   | II7ucivwqd |
      And admin click sidebar menu "Lead Base Tracker"
      And admin resets LBT filter
      And admin clicks LBT Filter
      And admin selects Leads Source "MLB" in LBT filter
      And admin selects LBT filter "Kota/ Kabupaten" with "Kabupaten Bantul"
      And admin selects LBT filter "Kecamatan" with "Kasihan"
      And admin selects LBT filter "Kelurahan" with "Tamantirto"
      And admin selects LBT filter "Area Priority" with "1st Priority"
      And admin clicks Terapkan in LBT filter
      Then all rows in LBT table column "Lead ID" should contain "MLB"
      And all rows in LBT table column "Kota" should contain "Kabupaten Bantul"
      And all rows in LBT table column "Kecamatan" should contain "Kasihan"
      And all rows in LBT table column "Kelurahan" should contain "Tamantirto"
      And all rows in LBT table column "Area Priority" should contain "1st Priority"

    @TEST_SS-11087 @filterLBT @continue
    Scenario: Search and filter work together
      When admin search LBT by "Leadbase ID" with "MLB704"
      Then admin validate "Leadbase ID" column in LBT table with "MLB704"
      And all rows in LBT table column "Kota" should contain "Kabupaten Bantul"
      And all rows in LBT table column "Kecamatan" should contain "Kasihan"
      And all rows in LBT table column "Kelurahan" should contain "Tamantirto"
      And all rows in LBT table column "Area Priority" should contain "1st Priority"

    @TEST_SS-11088 @filterLBT @continue
    Scenario: Reset clears both search and filter
      When admin resets LBT filter
      Then LBT search field should be empty
      And admin clicks LBT Filter
      And LBT filter should have no leads source checked
      And admin closes LBT Filter
      Then LBT table should contain multiple lead sources

    @TEST_SS-11093 @filterLBT
    Scenario: search & filter state persists when navigating to detail page
      When admin clicks LBT Filter
      And admin selects Leads Source "MLB" in LBT filter
      And admin clicks Terapkan in LBT filter
      And admin navigates to LBT page 3
      Then all rows in LBT table column "Lead ID" should contain "MLB"
      When admin clicks first leads row in LBT table
      And admin cancels leads edit
      Then LBT current page should be 3
      And all rows in LBT table column "Lead ID" should contain "MLB"
