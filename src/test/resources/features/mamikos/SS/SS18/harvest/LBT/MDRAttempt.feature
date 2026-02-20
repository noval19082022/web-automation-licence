@regression @SS18 @harvest @lbt @MDRAttempt

  Feature: Update Attempts MDR

    @TEST_SS-11044 @continue
    Scenario: MDR update attempts response "No Response"
      Given user navigates to ILB registration page
      And user fill and submit ILB registration form
        | Nama Lengkap       | Nama Kos              | Total Kamar | Kota             | Kecamatan | Kelurahan  | Alamat              |
        | Auto MDR Attempt   | Kos Auto MDR Attempt  | 10          | Kabupaten Bantul | Kasihan   | Tamantirto | Jl. Test Alamat 789 |
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
      And admin adds new attempt with jenis "Call" and response "No Response"
      Then attempt should be saved successfully
      When admin navigates back to LBT list
      And admin clicks on Follow Up tab
      And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
      Then leads response should be "No Response" in the table
      And leads response color should be "#8c3b00"

    @TEST_SS-11045 @continue
    Scenario: MDR update attempts response "Awaiting"
      When admin clicks on leads detail with saved ILB phone number
      And admin adds new attempt with jenis "Call" and response "Awaiting"
      Then attempt should be saved successfully
      When admin navigates back to LBT list
      And admin clicks on Follow Up tab
      And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
      Then leads response should be "Awaiting" in the table
      And leads response color should be "#8c3b00"

    @TEST_SS-11047 @continue
    Scenario: MDR update attempts response "Tidak Tertarik"
      When admin clicks on leads detail with saved ILB phone number
      And admin adds new attempt with jenis "Call" and response "Tidak Tertarik"
      Then attempt should be saved successfully
      When admin navigates back to LBT list
      And admin clicks on Done tab
      And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
      Then leads response should be "Tidak Tertarik" in the table
      And leads response color should be "#757575"

    @TEST_SS-11046 @continue
    Scenario: MDR update attempts response "Tertarik"
      When admin clicks on leads detail with saved ILB phone number
      And admin adds new attempt with jenis "Call" and response "Tertarik"
      Then attempt should be saved successfully
      When admin navigates back to LBT list
      And admin clicks on Visit tab
      And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
      Then leads response should be "Tertarik" in the table
      And leads response color should be "#016034"
