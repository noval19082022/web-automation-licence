@pman @mamipay @invoice-manual

  Feature: Invoice Manual

    @TEST_PMAN-5684 @pman-prod
    Scenario: Auto fill No HP and Nomor Kamar
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin input nama penyewa in buat invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
        | Kost Apik Khusus Automation Mamitest PMAN Tipe C Halmahera Utara  | Yudha Ferroza   |
      Then tenant information should be auto fill
        | No HP         | No Kamar        |
        | 0895346050317 | A1              |
        | 085542455775  | C1              |

    @TEST_PMAN-5689
    Scenario Outline: Buat dan Kirim Invoice Manual <Jenis Invoice>
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin input nama penyewa in buat invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
        | Kost Apik Khusus Automation Mamitest PMAN Tipe C Halmahera Utara  | Yudha Ferroza   |
      When admin add invoice manual "<Jenis Invoice>"
        | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya  | Jumlah Biaya  |
        | Parkir Mobil            | today         | tomorrow        | 3 hari        | 25000         |
        | Perpanjang sewa harian  | today         | tomorrow        | 2 Hari        | 500000        |
      Then admin verify data "<Jenis Invoice>" in Buat dan Kirim pop up correct
        | Nama Biaya                        | Awal    | Akhir       | Jumlah Biaya   | Disburse to Pemilik |
        | Parkir Mobil (3 hari)             | today   | tomorrow    | Rp 25.000      | Ya                  |
        | Perpanjang sewa harian (2 Hari)   | today   | tomorrow    | Rp 500.000     | -                   |
      When admin check pop up button and confirm it
      Then invoice manual "<Jenis Invoice>" created
        | Nama Listing                                              | Jumlah Biaya  | Status Invoice  |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara   | Rp25.000      | unpaid          |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara   | Rp500.000     | unpaid          |
      And show detail biaya "<Jenis Invoice>" if hovered
        | Nama Biaya                        |  Jumlah Biaya |
        | Parkir Mobil (3 hari)             |  Rp25.000     |
        | Perpanjang sewa harian (2 Hari)   |  Rp500.000    |

      Examples:
        | Jenis Invoice   |
        | Biaya Tambahan  |
        | Biaya Sewa      |

    @TEST_PMAN-5655 @pman-prod
    Scenario Outline: Back from Create Invoice Manual <Jenis Invoice>
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin input nama penyewa in buat invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
        | Kost Apik Khusus Automation Mamitest PMAN Tipe C Halmahera Utara  | Yudha Ferroza   |
      #back if no biaya added yet
      When admin click back button in buat invoice manual page
      Then admin redirect to invoice manual page without confirmation
      When admin add invoice manual "<Jenis Invoice>"
        | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya  | Jumlah Biaya  |
        | Parkir Mobil            | today         | tomorrow        | 3 hari        | 25000         |
        | Perpanjang sewa harian  | today         | tomorrow        | 2 Hari        | 500000        |
      #back if there is biaya added
      When admin click back button in buat invoice manual page
      Then exit buat invoice confirmation pop up should be appear
      When admin check confirmation functionality and confirm exit
      Then admin redirect to invoice manual page

      Examples:
        | Jenis Invoice   |
        | Biaya Tambahan  |
        | Biaya Sewa      |