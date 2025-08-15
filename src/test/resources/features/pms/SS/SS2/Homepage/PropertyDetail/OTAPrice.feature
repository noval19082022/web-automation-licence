@ss2 @pms @otaPrice

Feature: Check OTA Price in Detail Kontrak PMS

  @TEST_SS-741 @continue
  Scenario: Check All listings that Does Not Have OTA Price
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to detail property "Male"
    And admin see detail kerja sama
    Then OTA Prices are displayed in Rincian Tipe Kamar dan Harga section
      | Tipe Kamar | Gender | Jumlah Kamar | Harga Static Harian (OTA) | Harga Sewa Bulanan | Harga Sewa 3 Bulan | Harga Sewa 6 Bulan |
      | Red        | campur | 7            | -                         | Rp1.200.000        | Rp0                | Rp7.200.000        |
      | Yellow     | campur | 3            | -                         | Rp2.000.000        | Rp0                | Rp12.000.000       |

  @TEST_SS-830 @continue
  Scenario: Check OTA Price in One of the Listing
    When admin go to Homepage
    And admin go to detail property "Khusus Automation"
    And admin see detail kerja sama
    Then OTA Prices are displayed in Rincian Tipe Kamar dan Harga section
      | Tipe Kamar | Gender | Jumlah Kamar | Harga Static Harian (OTA) | Harga Sewa Bulanan | Harga Sewa 3 Bulan | Harga Sewa 6 Bulan |
      | Tipe A     | campur | 3            | Rp110.000                 | Rp850.000          | Rp0                | Rp4.050.000        |
      | Tipe B     | campur | 3            | -                         | Rp800.000          | Rp0                | Rp4.000.000        |
      | Tipe C     | campur | 3            | -                         | Rp800.000          | Rp0                | Rp4.000.000        |

  @TEST_SS-821
  Scenario: Check All listings that Have OTA Prices
    When admin go to Homepage
    And admin go to detail property "Pangeran Kumbang"
    And admin see detail kerja sama
    Then OTA Prices are displayed in Rincian Tipe Kamar dan Harga section
      | Tipe Kamar | Gender | Jumlah Kamar | Harga Static Harian (OTA) | Harga Sewa Bulanan | Harga Sewa 3 Bulan | Harga Sewa 6 Bulan |
      | Tipe A     | campur | 6            | Rp200.000                 | Rp600.000          | Rp2.500.000        | Rp3.600.000        |
      | Tipe C     | campur | 3            | Rp120.000                 | Rp600.000          | Rp2.500.000        | Rp3.600.000        |
      | Tipe D     | campur | 3            | Rp100.000                 | Rp600.000          | Rp2.500.000        | Rp3.600.000        |