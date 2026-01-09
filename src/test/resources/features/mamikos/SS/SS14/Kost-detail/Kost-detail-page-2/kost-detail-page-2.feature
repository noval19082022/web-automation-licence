@SS14 @KOST_DETAIL_2_SEARCH_MIGRATE
Feature: Kost detail page 2

  @TEST_SS-3195 @Automated @SS14 @Web @discovery-platform @kost-details @report-section
  Scenario: [Dweb][Kost Detail]Check report kos section tenant without login
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod               |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-c-kretek-bantul | Kos DC BAR Automation Tipe B |
    Then user can see kos report section
    #report action
    When user want to report this kos
    Then user will see login pop up

  @TEST_SS-3188 @Automated @SS14 @Web @discovery-platform @kost-details @report-section
  Scenario: [Dweb][Kost Detail]Check report kos section tenant login and already have send report kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user can see kos report section
    #report action
    When user want to report this kos
    And user send text "try to report this kos for testing" in form kos report
    Then user will see display pop up confirmation already have send report kos

  @TEST_SS-3224 @Automated @SS14 @Web @discovery-platform @kost-details @owner-lower-section
  Scenario: [Dweb][Kost Detail] Check Owner lower section
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    And user can see owner information section
    Then user want to see more detail owner information section

  @TEST_SS-3191 @Automated @SS14 @Web @discovery-platform @gallery @kost-details @owner-lower-section
  Scenario: [Dweb][Kost Detail] Check Detail Gallery Photo
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user want to display detail gallery

  @TEST_SS-3222 @Automated @SS14 @Web @discovery-platform @kost-details @recommendation
  Scenario: [Dweb][Kost Detail] Check Recommendation Kos
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                   | kost path prod                                      |
      | kost-bantul-kost-campur-eksklusif-kos-upik-rani-624-tipe-fortuna-kretek-bantul-2 | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user want to dismiss FTUE
    Then user want to see the other kost on recommendation section
    #explore kost recomendation
    When user see description recomendation kos "Kamu mungkin menyukainya"
    Then user want to explore kost recomendation section and see listing kos recommendation arround kos with detail "Kos di sekitar"

  @TEST_SS-3196 @Automated @SS14 @Web @discovery-platform @kost-details @property-price
  Scenario: [Dweb][Kost Detail] Check right panel, duration and price
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user sees total price property
      #user check more detail about booking date
    When user sees form booking date
    Then user validates description "Berikut adalah tanggal check-in (mulai ngekos) yang tersedia."
    * user sees date and alert message "Pastikan tanggal yang kamu masukkan benar"
    #user try too book this room
    When user sees form booking duration
    And user select date "tomorrow" and rent type "Per bulan"
    Then user sees booking button

  @TEST_SS-3186 @Automated @SS14 @Web @apik-badgekos @discovery-platform @kost-details @localhost
  Scenario: [Dweb][Kost Detail] Check APIK Badge Kos
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                               | kost path prod                               |
      | kost-halmahera-utara-kost-putra-murah-kost-apik-mars-white-halmahera-utara-1 | Kos Regress Web 127 Tipe 27 Abepura Jayapura |
    Then user can see apik badge kos

  @TEST_SS-3184 @Automated @SS14 @Web @discovery-platform @kost-details @singgahsini-badgekos @localhost
  Scenario: [Dweb][Kost Detail] Check Singgahsini Badge Kos
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                       | kost path prod                                       |
      | kost-bantul-kost-campur-eksklusif-kos-laris-kretek-1 | kost-bantul-kost-campur-eksklusif-kos-laris-kretek-1 |
    Then user can see singgahsini badge kos

  @TEST_SS-3187 @Automated @SS14 @Web @discovery-platform @kost-details @owner-badges @localhost
  Scenario:  [Dweb][Kost Detail] Check Owner badges section
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user reached owner badges section

  @TEST_SS-3185 @Automated @SS14 @Web @discovery-platform @kost-benefit @kost-details @localhost
  Scenario: [Dweb][Kost Detail] Check Kost Benefit section
    Given user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                | kost path prod                                                             |
      | kost-sleman-kost-campur-murah-kost-apik-desta-tipe-a-tamvan-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user see benefit title, benefit description

  @TEST_SS-3193 @Automated @SS14 @Web @discovery-platform @review-kost @localhost
  Scenario: [Dweb][Kost Detail] Check Tenant Review section
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                             | kost path prod                                                             |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 |
    Then user see review kos detail page section

  @TEST_SS-3192 @Automated @SS14 @Web @discovery-platform @review-kost @localhost
  Scenario: [Dweb][Kost Detail] Click see all Tenant Review
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                             | kost path prod               |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dc-bar-automation-tipe-g-2 | Kos DC BAR Automation Tipe A |
    And user see review kos detail page section
    Then user want to see all review