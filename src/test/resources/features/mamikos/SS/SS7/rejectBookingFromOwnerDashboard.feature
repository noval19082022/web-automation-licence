@SS7
Feature: Reject Booking From Owner Dashboard

  Scenario Outline: Cancel and create booking
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag            | phone prod            |
      | <tenant phone number> | <tenant phone number> |

    #Scenario: cancel booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag            | phone prod            | password  |
      | <tenant phone number> | <tenant phone number> | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant cancel all need confirmation booking request

    #Scenario: create booking
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                        | kost path prod               |
      | kost-halmahera-utara-kost-campur-murah-kost-reykjavik | Kos DC BAR Automation Tipe A |
    And tenant booking kost
    Then tenant should success booking kost

    Examples:
      | tenant phone number |
      | 083894304420        |
      | 0822660001          |

  @TEST_SS-3483
  Scenario: [Owner dashboard][Ada yang menunggu]Reject Booking via Homepage (more than 1 waiting booking)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0890000000289 | 0890000000289 | Bismillah@01 |
    And owner reject booking from dashboard
    And owner select reason reject kos "Tanggal masuk/check-in kos terlalu dekat"
    Then owner navigates to owner dashboard