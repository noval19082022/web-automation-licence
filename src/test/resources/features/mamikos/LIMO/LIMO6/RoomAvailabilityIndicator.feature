@regression @LIMO6 @roomAvailabilityIndicator @WEB @AUTOMATED
Feature: Room Availability Indicator on Owner Dashboard


  @TEST_LIMO-1535 @roomAvailabilityRedDot
  Scenario: [Owner Dashboard][Room Availability] Check red dot indicator when listing has full rooms
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0812345670001 | 0812345670001 | qwerty123 |
    And owner views the Activities section
    And the "Ketersediaan Kamar" icon should have a red dot indicator

  @TEST_LIMO-10537 @roomAvailabilityNavigation
  Scenario: [Owner Dashboard][Room Availability] Navigate to Ketersediaan Kamar from activity section
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0812345670001 | 0812345670001 | qwerty123 |
    And owner views the Activities section
    When owner clicks on "Ketersediaan Kamar" icon in activity section
    Then owner should see "Ketersediaan Kamar" page

  @TEST_LIMO-10538 @roomAvailabilityIconHidden
  Scenario: [Owner Dashboard][Room Availability] Ketersediaan Kamar icon hidden when all rooms available
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0891202601    | 0812345670001 | qwerty123 |
    And owner views the Activities section
    When owner clicks on "Ketersediaan Kamar" icon in activity section
    And user enter text "1" on search bar in room allotment and hit enter
    And user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click "Simpan"
    And owner navigates to owner dashboard
    Then the "Ketersediaan Kamar" icon should NOT be displayed
  #Scenario: [Owner Dashboard][Room Availability] Ketersediaan Kamar icon hidden when all rooms available
    When owner navigates to property saya kos
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    And user enter text "1" on search bar in room allotment and hit enter
    And user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click "Simpan"
    And owner navigates to owner dashboard
    Then the "Ketersediaan Kamar" icon should have a red dot indicator

  @TEST_LIMO-10544 @roomAvailabilityRedDot
  Scenario: [Owner Dashboard][Pengajuan Survei] Display Pengajuan Survei icon for owner with pending survey requests
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0891202601    | 0812345670001 | qwerty123 |
    And owner views the Activities section
    Then the counter badge "Pengajuan Survei" should display "2"

  @TEST_LIMO-10546 @roomAvailabilityNavigation
  Scenario: [Owner Dashboard][Pengajuan Survei] Click Pengajuan Survei redirects to chat list survey
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod    | password  |
      | 0891202601  | 0812345670001 | qwerty123 |
    When owner clicks on "Pengajuan Survei" icon in activity section
    Then owner should see "Pengajuan Survei" page

  @TEST_LIMO-10543 @roomAvailabilityRedDot
  Scenario: [Owner Dashboard][Pengajuan Survei] Display Pengajuan Survei icon for owner with pending survey requests
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0891202601    | 0812345670001 | qwerty123 |
    And owner views the Activities section
    Then the counter badge "Daftar Tunggu" should display "3"

  @TEST_LIMO-10560 @roomAvailabilityNavigation
  Scenario: [Owner Dashboard][Pengajuan Survei] Click Pengajuan Survei redirects to chat list survey
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod    | password  |
      | 0891202601  | 0812345670001 | qwerty123 |
    When owner clicks on "Daftar Tunggu" icon in activity section
    Then owner should see "Daftar Tunggu" page
