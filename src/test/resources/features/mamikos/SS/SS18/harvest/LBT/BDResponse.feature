@regression @SS16 @harvest @lbt @BDResponse

Feature: BD Response

  @TEST_SS-11053 @continue
  Scenario: BD update visit status "Reschedule"
    Given user navigates to ILB registration page
    And user fill and submit ILB registration form
      | Nama Lengkap       | Nama Kos               | Total Kamar | Kota             | Kecamatan | Kelurahan  | Alamat              |
      | Auto BD Response   | Kos Auto BD Response   | 10          | Kabupaten Bantul | Kasihan   | Tamantirto | Jl. Test Alamat 789 |
    Then system show ILB registration success message
    When admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email                | password   |
      | yudha@mamiteam.com   | II7ucivwqd |
    And admin click sidebar menu "Lead Base Tracker"
    And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
    Then leads with saved ILB phone number found in LBT
    When admin clicks on leads with saved ILB phone number
    And admin clicks Assign to me button
    Then leads should be assigned successfully
    When admin navigates back to LBT list
    And admin clicks on Follow Up tab
    And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
    And admin clicks on leads detail with saved ILB phone number
    And admin adds new attempt with jenis "Call" and response "Tertarik"
    Then attempt should be saved successfully
    When admin navigates back to LBT list
    And admin clicks on Visit tab
    And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
    And admin clicks on leads detail with saved ILB phone number
    And admin updates BD visit status to "Reschedule"
    Then BD response should be saved successfully
    When admin navigates back to LBT list
    And admin clicks on Visit tab
    And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
    Then BD response should be "Reschedule" in the table
    And BD response color should be "#8c3b00"

  @TEST_SS-11054 @continue
  Scenario: BD update visit status "Awaiting"
    When admin clicks on leads detail with saved ILB phone number
    And admin updates BD visit status to "Awaiting"
    Then BD response should be saved successfully
    When admin navigates back to LBT list
    And admin clicks on Visit tab
    And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
    Then BD response should be "Awaiting" in the table
    And BD response color should be "#8c3b00"

  @TEST_SS-11056 @continue
  Scenario: BD update visit status "Tidak Tertarik"
    When admin clicks on leads detail with saved ILB phone number
    And admin updates BD visit status to "Tidak Tertarik"
    Then BD response should be saved successfully
    When admin navigates back to LBT list
    And admin clicks on Done tab
    And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
    Then BD response should be "Tidak Tertarik" in the table
    And BD response color should be "#757575"

  @TEST_SS-11057 @continue
  Scenario: BD update visit status "Unqualified"
    When admin clicks on leads detail with saved ILB phone number
    And admin updates BD visit status to "Unqualified"
    Then BD response should be saved successfully
    When admin navigates back to LBT list
    And admin clicks on Done tab
    And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
    Then BD response should be "Unqualified" in the table
    And BD response color should be "#9b292d"

  @TEST_SS-11058 @continue
  Scenario: BD update visit status "Cancel"
    When admin clicks on leads detail with saved ILB phone number
    And admin updates BD visit status to "Cancel"
    Then BD response should be saved successfully
    When admin navigates back to LBT list
    And admin clicks on Done tab
    And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
    Then BD response should be "Cancel" in the table
    And BD response color should be "#9b292d"

  @TEST_SS-11055
  Scenario: BD update visit status "Tertarik"
    When admin clicks on leads detail with saved ILB phone number
    And admin updates BD visit status to "Tertarik"
    Then BD response should be saved successfully
    When admin navigates back to LBT list
    And admin clicks on Done tab
    And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
    Then BD response should be "Tertarik" in the table
    And BD response color should be "#016034"
    And leads status should be "Submitted to Kissflow via LBT" in the table
