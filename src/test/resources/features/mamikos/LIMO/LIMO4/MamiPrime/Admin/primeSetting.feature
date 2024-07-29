@LIMO4 @regression
Feature: Prime Setting

  @TEST_LIMO-620 @continue @primeSetting @WEB @AUTOMATED
  Scenario: [Admin][Prime Menu] Admin can search by subdistrict id and name
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                     | email prod | password  |
      | uncle.limo2@admin-mamiteam.com |            | qwerty123 |
    #search by name invalid
    And admin wants to accsess prime setting
    When admin search subdistrict with "aaa"
    Then admin cannot see result at prime setting
    #searcg by subdistrict invalid
    Given admin reset form search subdsitrict
    When admin search subdistrict with "110"
    Then admin cannot see result at prime setting
     #search by name valid
    Given admin reset form search subdsitrict
    When admin search subdistrict with "Tobelo Utara"
    Then admin can see result data of district id "8205042" with name "Tobelo Utara (Kabupaten Halmahera Utara)"
    #searcg by subdistrict valid
    Given admin reset form search subdsitrict
    When admin search subdistrict with "8205042"
    Then admin can see result data of district id "8205042" with name "Tobelo Utara (Kabupaten Halmahera Utara)"

  @TEST_LIMO-619 @primeSetting @continue @WEB @AUTOMATED
  Scenario: [Admin][Prime Menu] Admin adjusts slotting for a specific district
    Given admin wants to accsess prime setting
    * admin search subdistrict with "Wamena"
    * admin can see slot is "Slot: 10"
    #invalid
    When admin wants to adjust slot " "
    Then admin can see message "The slot field is required." at prime setting
    #Valid
    When admin wants to adjust slot "15" from page slot
    * admin search subdistrict with "Wamena"
    Then admin can see slot is "Slot: 15"
    #revert slot to 10
    When admin wants to adjust slot "10"
    * admin search subdistrict with "Wamena"
    * admin can see slot is "Slot: 10"

  @TEST_LIMO-621 @primeSetting @WEB @AUTOMATED
  Scenario: [Admin][Prime Menu] Admin sets default favorite pricing on Prime Settings menu
    Given admin wants to accsess prime setting
    When admin search subdistrict with "Aceh"
    Then admin can see package name "30 Hari" has label "Favorit"
    And admin reset form search subdsitrict
    When admin search subdistrict with "Wamena"
    Then admin can see package name "30 Hari" has label "Favorit"