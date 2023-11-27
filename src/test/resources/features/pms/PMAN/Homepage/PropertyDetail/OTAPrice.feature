@pman @pms @otaPrice

Feature: Check OTA Price in Detail Kontrak PMS

  @TEST_PMAN-7086 @continue
  Scenario: Check All listings that Does Not Have OTA Price
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to detail property "Male"
    And admin see detail kerja sama
    Then OTA Prices "are not" displayed in Rincian Tipe Kamar dan Harga section
      | Tipe Kamar  | Gender  | Jumlah Kamar  | Harga Static Harian (OTA) | Harga Sewa Bulanan  | Harga Sewa 3 Bulan  | Harga Sewa 6 Bulan  |
      | Red         | campur  | 7             | -                         | Rp1.200.000         | Rp0                 | Rp7.200.000         |
      | Yellow      | campur  | 3	          | -                         | Rp2.000.000         | Rp0                 | Rp12.000.000	    |

#  @aaa
#  Scenario: Check OTA Price in One of the Listings
#    When admin go to Homepage
#    And admin go to detail property "Khusus Automation"
#    And admin see detail kerja sama
#    Then OTA Prices "is" displayed in Rincian Tipe Kamar dan Harga section
#      | Tipe Kamar  | Gender  | Jumlah Kamar  | Harga Static Harian (OTA) | Harga Sewa Bulanan  | Harga Sewa 3 Bulan  | Harga Sewa 6 Bulan  |
#      | Tipe A      | campur  | 3             | Rp110.000	              | Rp850.000           | Rp0                 | Rp4.050.000         |
#      | Tipe B      | campur  | 3	          | -                         | Rp800.000           | Rp0                 | Rp4.000.000 	    |
#      | Tipe C	    | campur  | 3             | -                         | Rp800.000	        | Rp0                 | Rp4.000.000	        |