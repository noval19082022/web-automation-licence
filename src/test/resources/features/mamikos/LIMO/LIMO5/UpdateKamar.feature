@regression @LIMO5 @updateKamar
Feature: Update Kamar

  @TEST_LIMO-876 @WEB @AUTOMATED
  Scenario: [WEB][Update Room] Access page "Update Kamar" from entry point kos list when kost status == Active by add new rooms and delete it
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 0891202506   | 083176408311 | qwerty123 |
    When owner navigates to property saya kos
    And owner search kost "Kost Zymuno Rajeg" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    And owner add room with name or room number "89"
    And owner click simpan on add room pop up
    Then user can sees toast on update room as "Kosong" "Total Kamar 3"
    And user see total room is "Total Kamar 3" in update room page
    When user enter text "89" on search bar in room allotment and hit enter
    And user delete room name or number in room allotment
    Then user see total room is "Total Kamar 1" in update room page

  @TEST_LIMO-3463 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Room] Access page "Update Kamar" from entry point kos list when kost status == Active by update rooms become unavailable
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408311 | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kos Testing 123 Tipe B Danurejan Yogyakarta" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    And user enter text "1" on search bar in room allotment and hit enter
    And user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click "Simpan"
    When user enter text "" on search bar in room allotment and hit enter
    Then user see total room is "Total Kamar 7" in update room page
    When user filter the room with "Kamar Kosong" in update room page
    Then user see total room is "Total Kamar 6" in update room page
    When user filter the room with "Kamar Terisi" in update room page
    Then user see total room is "Total Kamar 1" in update room page
    When user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click "Simpan"
    And user filter the room with "Kamar Kosong" in update room page
    Then user see total room is "Total Kamar 7" in update room page
    When user filter the room with "Kamar Terisi" in update room page
    Then user see total room is "Total Kamar 1" in update room page

  @TEST_LIMO-874 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Room] Access page "Update Kamar" from entry point kos list when kost status == Active by update text box "Lantai (Opsional)"
    When owner navigates to property saya kos
    And owner search kost "Kos Testing 123 Tipe B Danurejan Yogyakarta" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    And user enter text "1" on search bar in room allotment and hit enter
    And user click edit button in first row of the table
    And user fill room floor in room allotment page with "1"
    And owner click "Simpan"
    When user click edit button in first row of the table
    And user fill room floor in room allotment page with "abcd"
    And owner click "Simpan"
    Then user can sees toast on update room as "Kosong" "Total Kamar 1"

  @TEST_LIMO-3462 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Room] Access page "Update Kamar" from entry point kost list when kost status == Active by update text box "Nomor/ Nama Kamar?"
    When user enter text "1" on search bar in room allotment and hit enter
    And user click edit button in first row of the table
    And user fill room name in room allotment page with "001A"
    And owner click "Simpan"
    When user click edit button in first row of the table
    And user fill room name in room allotment page with "1"
    And owner click "Simpan"
    Then user can sees toast on update room as "Kosong" "Total Kamar 1"

  @TEST_LIMO-900 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Room] Filter on room allotments is always shown when total rooms == 0 or != 0
    When user enter text "" on search bar in room allotment and hit enter
    Then user see total room is "Total Kamar 7" in update room page
    When user filter the room with "Kamar Kosong" in update room page
    Then user see total room is "Total Kamar 7" in update room page
    When user filter the room with "Kamar Terisi" in update room page
    Then user see total room is "Total Kamar 1" in update room page
    When owner navigates to property saya kos
    And owner search kost "Kose Full Automation" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    And user filter the room with "Kamar Kosong" in update room page
    Then user see total room is "Total Kamar 1" in update room page

  @TEST_LIMO-879 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Room]  Check box "Sudah Berpenghuni" is set to define room status when kost not in Goldplus Level
    When owner navigates to property saya kos
    And owner search kost "Property Automation x94Om" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    When user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click "Simpan"
    When user filter the room with "Kamar Kosong" in update room page
    Then user see total room is "Total Kamar 4" in update room page
    When user filter the room with "Kamar Terisi" in update room page
    Then user see total room is "Total Kamar 1" in update room page
    When user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click "Simpan"
    Then user see total room is "Total Kamar 1" in update room page

  @TEST_LIMO-878 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Room]  Show label goldplus if rooms set as goldplus from room list
    When owner navigates to property saya kos
    And owner search kost "Kose Mamiset Automation" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    And user enter text "GoldPlus" on search bar in room allotment and hit enter
    Then user see label "Goldplus" in room name

  @TEST_LIMO-884 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Room] Search function on page room allotments
    When user enter text "33" on search bar in room allotment and hit enter
    Then user see label "33" in room name
    When user enter text "?,.?" on search bar in room allotment and hit enter
    Then user see room list is empty in room allotment page
    When user enter text "sela" on search bar in room allotment and hit enter
    Then user see room list is empty in room allotment page

  @TEST_LIMO-880 @continue @WEB @AUTOMATED
  Scenario: [WEB][Update Room]  Text box "Nomor/Nama Kamar?" is edited with invalid value
    When owner navigates to property saya kos
    And owner search kost "Kos oke bebek AA Batre Depok Sleman" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    And user enter text "18" on search bar in room allotment and hit enter
    And user click edit button in first row of the table
    And user fill room name in room allotment page with "123456789012345678901234567890123456789012345678901"
    Then user see error message "Maks. 50 karakter." under room name field in update room page
    When user fill room name in room allotment page with "22"
    Then user see error message "Nomor/ nama sudah dipakai kamar lain." under room name field in update room page
    When user fill room name in room allotment page with " "
    Then user see error message "Nomor/ nama masih kosong." under room name field in update room page

  @TEST_LIMO-885 @WEB @AUTOMATED
  Scenario: [WEB][Update Room] Text box Floor (Optional) is edited with invalid value
    When owner navigates to property saya kos
    And owner search kost "Kost Cooling Efect" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Kamar"
    And user enter text "2" on search bar in room allotment and hit enter
    And user click edit button in first row of the table
    And user fill room floor in room allotment page with "123456789012345678901234567890123456789012345678901"
    Then user see error message "Maks. 50 karakter." under floor field in update room page