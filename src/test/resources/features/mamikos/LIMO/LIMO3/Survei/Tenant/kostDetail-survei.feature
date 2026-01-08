@regression @LIMO3
Feature: Survei - kos detail

  @TEST_LIMO-7035
  Scenario: Display Survey Benefit for GP Kost
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod | password     |
      | 0891111020199 | 0          | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                              | kost path prod                                      |
      | kost-kota-depok-kost-campur-murah-kirigakure-cilodong-depok | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    And user dismiss FTUE booking benefit
    Then "Survei Kos Tersedia" are displayed in the kos andalan
      | Survei Kos Tersedia                                                                                              |
      | Ajukan survei ke pemilik via chat di platform. Setelahnya, kamu juga bisa dapatkan voucher spesial dari Mamikos. |
    Then "Booking Langsung" are displayed in the kos andalan
      | Booking Langsung                                                                                        |
      | Kos ini bisa di-booking dan dibayar di situs dan aplikasi Mamikos, tanpa harus ketemuan dengan pemilik. |
    Then "Ketentuan Refund" are displayed in the kos andalan
      | Ketentuan Refund                                                                      |
      | Kos bisa refund sesuai dengan ketentuan dan kebijakan refund yang berlaku di Mamikos. |

  @TEST_LIMO-7036
  Scenario: Not Display Survey Benefit for Non Kost GP
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod | password     |
      | 0891111020199 | 0          | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                                      | kost path prod                                      |
      | kost-tangerang-kost-campur-eksklusif-kost-siera-jatiuwung-tangerang | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
   # And user dismiss FTUE booking benefit
    Then "Survei Kos Tersedia" are not displayed in the kos pilar non gp
      | Survei Kos Tersedia                                                                                              |
      | Ajukan survei ke pemilik via chat di platform. Setelahnya, kamu juga bisa dapatkan voucher spesial dari Mamikos. |
    Then "Booking Langsung" are not displayed in the kos pilar non gp
      | Booking Langsung                                                                                        |
      | Kos ini bisa di-booking dan dibayar di situs dan aplikasi Mamikos, tanpa harus ketemuan dengan pemilik. |

  @TEST_LIMO-7037
  Scenario: Display Survey Benefit without "Baru" Label for P1 (Kos Singgahsini and Apik)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod | password     |
      | 0891111020199 | 0          | mamikosqa123 |
    And tenant redirect to kost details:
      | kost path stag                                                                                       | kost path prod                                      |
      | kost-halmahera-utara-kost-campur-eksklusif-kost-singgahsini-ika-purnamasari-tipe-b-halmahera-utara-1 | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then "Dikelola Penuh Oleh Mamikosa" are displayed in the kos andalan
      | Dikelola Penuh Oleh Mamikos                    |
      | Ditangani secara profesional oleh tim Mamikos. |
    Then "Survei Kos Tersedia" are displayed in the kos andalan
      | Survei Kos Tersedia                                                                                                                |
      | (TANPA LABEL BARU)Ajukan survei ke pemilik via chat di platform. Setelahnya, kamu juga bisa dapatkan voucher spesial dari Mamikos. |
    Then "Bisa Refund" are displayed in the kos andalan
      | Bisa Refund                                                           |
      | Sesuai dengan ketentuan dan kebijakan refund yang berlaku di Mamikos. |

  @TEST_LIMO-7038
  Scenario: Not Display Survey Benefit for Non Kost GP
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod | password     |
      | 0891111020199 | 0          | mamikosqa123 |
    And tenant redirect to apartment details:
      | environment | apartment path                                      |
      | stag        | /apartemen-kalibata-city/silalay-123-1room-studio-1 |
   # And user dismiss FTUE booking benefit
    Then user see label Baru should be displayed on the kost detail page

  @TEST_LIMO-7043
  Scenario: Not Display Survey Benefit for Non Kost GP
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod | password     |
      | 0891111020199 | 0          | mamikosqa123 |
    And tenant redirect to apartment details:
      | environment | apartment path                                      |
      | stag        | /apartemen-kalibata-city/silalay-123-1room-studio-1 |
    Then "Survei Kos Tersedia" are not displayed in the kos pilar non gp
      | Survei Kos Tersedia                                                                                              |
      | Ajukan survei ke pemilik via chat di platform. Setelahnya, kamu juga bisa dapatkan voucher spesial dari Mamikos. |