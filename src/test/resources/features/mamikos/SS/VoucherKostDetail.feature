@SS10 @DOM1
Feature: Voucher Kost Detail

  @TEST_SS-8407 @continue
  Scenario: [Web][Kost Detail][Voucher]Check voucher when have voucher  available (Kost SS)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0812000008 | 0890867321203 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                                 | kost path prod               |
      | kost-kabupaten-lombok-barat-kost-campur-eksklusif-kost-singgahsini-rizki-abadi-tipe-a-lombok-2 | Kos DC BAR Automation Tipe A |
    Then tenant can see "Voucher Khusus Singgahsini" section
    And tenant click on "Voucher Khusus Singgahsini" section
    Then tenant can see voucher list

  @TEST_SS-8408 @continue
  Scenario: [Web][Kost Detail][Voucher]Check voucher when  have voucher  available (Kost Apik)
    Given tenant redirect to kost details:
      | kost path stag                                                                     | kost path prod               |
      | kost-kabupaten-lombok-barat-kost-campur-eksklusif-kost-apik-marlin-tipe-a-lombok-2 | Kos DC BAR Automation Tipe A |
    Then tenant can see "Voucher Khusus APIK" section
    And tenant click on "Voucher Khusus APIK" section
    Then tenant can see voucher list

  @TEST_SS-8412 @continue
  Scenario: [Web][Kost Detail][Voucher]Tenant check voucher when open kost p2
    When tenant redirect to kost details:
      | kost path stag                                                                                | kost path prod               |
      | kost-kota-yogyakarta-kost-campur-eksklusif-kos-raya-raney-tipe-raya-3-danurejan-yogyakarta | Kos DC BAR Automation Tipe A |
    And user dismiss promo ngebut pop up
    Then tenant can not see "Voucher Khusus Singgahsini" section

  @TEST_SS-8411 @continue
  Scenario: [Web][Kost Detail][Voucher]Check close icon from voucher list
    When tenant redirect to kost details:
      | kost path stag                                                                                | kost path prod               |
      | kost-kabupaten-lampung-barat-kost-campur-eksklusif-kost-singgahsini-negri-atas-awan-balik-bukit-lampung-barat-1| Kos DC BAR Automation Tipe A |
    And tenant click on "Voucher Khusus Singgahsini" section
    Then tenant can see voucher list
    And tenant click on close icon
    Then tenant can not see voucher list

  @TEST_SS-8410 @continue
  Scenario: [Web][Kost Detail][Voucher]Tenant check Lihat detail button
    When tenant click on "Voucher Khusus Singgahsini" section
    Then tenant can see voucher list
    And tenant click on lihat detail button for "Regress monthly"
    Then tenant can see voucher detail with "Regress monthly"

  @TEST_SS-8418
  Scenario: [Web][Voucher list][Voucher List ]Salin voucher code
    When tenant redirect to kost details:
      | kost path stag                                                                                | kost path prod               |
      | kost-kabupaten-lampung-barat-kost-campur-eksklusif-kost-singgahsini-negri-atas-awan-balik-bukit-lampung-barat-1| Kos DC BAR Automation Tipe A |
    And tenant click on "Voucher Khusus Singgahsini" section
    And tenant click on "Salin" button
    Then tenant can see toast message "Kode voucher berhasil disalin."
    And tenant click on lihat detail button for "Regress monthly"
    Then tenant can see voucher detail with "Regress monthly"
    And tenant click on "Salin Detail" button
    Then tenant can see toast message "Kode voucher berhasil disalin."
