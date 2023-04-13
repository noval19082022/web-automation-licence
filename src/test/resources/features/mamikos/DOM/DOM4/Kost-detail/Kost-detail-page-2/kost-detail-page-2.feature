#@localhost #@DOM4
Feature: Kost detail page 2

  @TEST_DOM-1875 @Automated @DOM4 @Web @discovery-platform @kost-details @report-section
  Scenario: [Dweb][Kost Detail]Check report kos section tenant without login
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe B | Kos DC BAR Automation Tipe B |
    Then user can see kos report section
    #report action
    When user want to report this kos
    Then user will see login pop up

  @TEST_DOM-1882 @Automated @DOM4 @Web @discovery-platform @kost-details @report-section
  Scenario: [Dweb][Kost Detail]Check report kos section tenant login and already have send report kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user can see kos report section
    #report action
    When user want to report this kos
    And user send text "try to report this kos for testing" in form kos report
    Then user will see display pop up confirmation already have send report kos

  @TEST_DOM-1884 @Automated @DOM4 @Web @discovery-platform @kost-details @owner-lower-section
  Scenario: [Dweb][Kost Detail] Check Owner lower section
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    And user can see owner information section
    Then user want to see more detail owner information section

  @TEST_DOM-1883 @Automated @DOM4 @Web @discovery-platform @gallery @kost-details @owner-lower-section
  Scenario: [Dweb][Kost Detail] Check Detail Gallery Photo
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user want to display detail gallery

  @TEST_DOM-1885 @Automated @DOM4 @Web @discovery-platform @kost-details @recommendation
  Scenario: [Dweb][Kost Detail] Check Recommendation Kos
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then user want to see the other kost on recommendation section
    #explore kost recomendation
    When user see description recomendation kos "Kamu mungkin menyukainya"
    Then user want to explore kost recomendation section and see listing kos recommendation arround kos with detail "Kos di sekitar" and filter by mix gender

  @TEST_DOM-1876 @Automated @DOM4 @Web @discovery-platform @kost-details @property-price
  Scenario: [Dweb][Kost Detail] Check right panel, duration and price
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user sees total price property
    #user check more detail about booking date
    When user sees form booking date
    Then user validates description "Bisa di hari H setelah pengajuan sewa."
    * user validates description "2 bulan setelah pengajuan sewa."
    * user sees date and alert message "Pastikan tanggal yang kamu masukkan benar"
    #user try too book this room
    When user sees form booking duration
    And user select date "tomorrow" and rent type "Per bulan"
    Then user sees booking button

  @TEST_DOM-1877 @Automated @DOM4 @Web @apik-badgekos @discovery-platform @kost-details @localhost
  Scenario: [Dweb][Kost Detail] Check APIK Badge Kos
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag                       | kost name prod                               |
      | Kost Apik Mars White Halmahera Utara | Kos Regress Web 127 Tipe 27 Abepura Jayapura |
    Then user can see apik badge kos

  @TEST_DOM-1880 @Automated @DOM4 @Web @discovery-platform @kost-details @singgahsini-badgekos @localhost
  Scenario: [Dweb][Kost Detail] Check Singgahsini Badge Kos
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag   | kost name prod   |
      | Kos Laris Kretek | Kos Laris Kretek |
    Then user can see singgahsini badge kos

  @TEST_DOM-1879 @Automated @DOM4 @Web @discovery-platform @kost-details @owner-badges @localhost
  Scenario:  [Dweb][Kost Detail] Check Owner badges section
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user reached owner badges section

  @TEST_DOM-1881 @Automated @DOM4 @Web @discovery-platform @kost-benefit @kost-details @localhost
  Scenario: [Dweb][Kost Detail] Check Kost Benefit section
    Given user go to mamikos homepage
    When tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user see benefit title, benefit description

  @TEST_DOM-3811 @Automated @DOM4 @Web @discovery-platform @review-kost @localhost
  Scenario: [Dweb][Kost Detail] Check Tenant Review section
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    Then user see review kos detail page section

  @TEST_DOM-3812 @Automated @DOM4 @Web @discovery-platform @review-kost @localhost
  Scenario: [Dweb][Kost Detail] Click see all Tenant Review
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos DC BAR Automation Tipe A | Kos DC BAR Automation Tipe A |
    And user see review kos detail page section
    Then user want to see all review