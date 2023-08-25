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

    @continue @TEST_PMAN-5689
    Scenario: Buat dan Kirim Invoice Manual Biaya Tambahan
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin input nama penyewa in buat invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
        | Kost Apik Khusus Automation Mamitest PMAN Tipe C Halmahera Utara  | Yudha Ferroza   |
      When admin add invoice manual "Biaya Tambahan"
        | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya  | Jumlah Biaya  |
        | Parkir Mobil            | today         | tomorrow        | 3 hari        | 25000         |
      Then admin verify data "Biaya Tambahan" in Buat dan Kirim pop up correct
        | Nama Biaya                        | Awal    | Akhir       | Jumlah Biaya   | Disburse to Pemilik |
        | Parkir Mobil (3 hari)             | today   | tomorrow    | Rp 25.000      | Ya                  |
      When admin check pop up button and confirm it
      Then invoice manual "Biaya Tambahan" created
        | Nama Listing                                              | Jumlah Biaya  | Status Invoice  |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara   | Rp25.000      | unpaid          |
      And show detail biaya "Biaya Tambahan" if hovered
        | Nama Biaya                        |  Jumlah Biaya |
        | Parkir Mobil (3 hari)             |  Rp25.000     |

    @TEST_PMAN-5766
    Scenario: Check invoice data in invoice page
      When admin clicks invoice number with unpaid status
      Then invoice detail for "Biaya Tambahan" is displayed

    @continue @TEST_PMAN-5689
    Scenario: Buat dan Kirim Invoice Manual Biaya Sewa
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin input nama penyewa in buat invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
        | Kost Apik Khusus Automation Mamitest PMAN Tipe C Halmahera Utara  | Yudha Ferroza   |
      When admin add invoice manual "Biaya Sewa"
        | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya  | Jumlah Biaya  |
        | Perpanjang sewa harian  | today         | tomorrow        | 2 Hari        | 500000        |
      Then admin verify data "Biaya Sewa" in Buat dan Kirim pop up correct
        | Nama Biaya                        | Awal    | Akhir       | Jumlah Biaya   | Disburse to Pemilik |
        | Perpanjang sewa harian (2 Hari)   | today   | tomorrow    | Rp 500.000     | -                   |
      When admin check pop up button and confirm it
      Then invoice manual "Biaya Sewa" created
        | Nama Listing                                              | Jumlah Biaya  | Status Invoice  |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara   | Rp500.000     | unpaid          |
      And show detail biaya "Biaya Sewa" if hovered
        | Nama Biaya                        |  Jumlah Biaya |
        | Perpanjang sewa harian (2 Hari)   |  Rp500.000    |

    @TEST_PMAN-5766
    Scenario: Check invoice data in invoice page
      When admin clicks invoice number with unpaid status
      Then invoice detail for "Biaya Sewa" is displayed

    @TEST_PMAN-5655 @pman-prod @continue
    Scenario: Back from Create Invoice Manual Biaya Tambahan
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
      #back if there is biaya added
      When admin create invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
      When admin add invoice manual "Biaya Tambahan"
        | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya  | Jumlah Biaya  |
        | Parkir Mobil            | today         | tomorrow        | 3 hari        | 25000         |
      When admin click back button in buat invoice manual page
      Then exit buat invoice confirmation pop up should be appear
      When admin check confirmation functionality and confirm exit
      Then admin redirect to invoice manual page

    @TEST_PMAN-7961 @pman-prod
    Scenario: Back from Create Invoice Manual Biaya Sewa
      When admin create invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
      #back if no biaya added yet
      When admin click back button in buat invoice manual page
      Then admin redirect to invoice manual page without confirmation
      #back if there is biaya added
      When admin create invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
      When admin add invoice manual "Biaya Sewa"
        | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya  | Jumlah Biaya  |
        | Perpanjang sewa harian  | today         | tomorrow        | 2 Hari        | 500000        |
      When admin click back button in buat invoice manual page
      Then exit buat invoice confirmation pop up should be appear
      When admin check confirmation functionality and confirm exit
      Then admin redirect to invoice manual page

    @TEST_PMAN-5744 @pman-prod
    Scenario Outline: Durasi Biaya in <Jenis Invoice> max 255 characters
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin input nama penyewa in buat invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
        | Kost Apik Khusus Automation Mamitest PMAN Tipe C Halmahera Utara  | Yudha Ferroza   |
      When admin add invoice manual "<Jenis Invoice>" without submit
        | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya              | Jumlah Biaya  |
        | Parkir Mobil            | today         | tomorrow        | more than 255 characters  | 25000         |
        | Perpanjang sewa harian  | today         | tomorrow        | more than 255 characters  | 500000        |
      Then durasi biaya should be only contains "max 255 characters" and counter show "255 / 255"

      Examples:
        | Jenis Invoice   |
        | Biaya Tambahan  |
        | Biaya Sewa      |

    @TEST_PMAN-5657 @pman-prod @continue
    Scenario: Change Jenis Invoice to Biaya Tambahan When There Are Biaya Sewa
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin input nama penyewa in buat invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
        | Kost Apik Khusus Automation Mamitest PMAN Tipe C Halmahera Utara  | Yudha Ferroza   |
      And admin add invoice manual "Biaya Sewa"
        | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya  | Jumlah Biaya  |
        | Perpanjang sewa harian  | today         | tomorrow        | 2 Hari        | 500000        |
      #change invoice type
      When admin selects Jenis Invoice "Biaya Tambahan" when "There are Biaya Data"
      Then empty state on the biaya "Biaya Tambahan" table is displayed

    @TEST_PMAN-7962 @pman-prod
    Scenario: Change Jenis Invoice to Biaya Sewa When There Are Biaya Tambahan
      When admin go to invoice manual page
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
      And admin add invoice manual "Biaya Tambahan"
        | Nama Biaya              | Periode Awal  | Periode Akhir   | Durasi Biaya  | Jumlah Biaya  |
        | Parkir Mobil            | today         | tomorrow        | 3 hari        | 25000         |
      #change invoice type
      When admin selects Jenis Invoice "Biaya Sewa" when "There are Biaya Data"
      Then empty state on the biaya "Biaya Sewa" table is displayed

    @continue @TEST_PMAN-5745 @pman-prod
    Scenario: Change Jenis Invoice - When There Is No Biaya Tambahan & Biaya Sewa Data
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin input nama penyewa in buat invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
        | Kost Apik Khusus Automation Mamitest PMAN Tipe C Halmahera Utara  | Yudha Ferroza   |
      #change invoice type
      When admin selects Jenis Invoice
        | Jenis Invoice   | Change Invoice to | Change Invoice again to |
        | Biaya Tambahan  | Biaya Sewa        | Biaya Tambahan          |
      Then the pop up confirmation is not displayed

    @TEST_PMAN-5822
    Scenario: Disable Buat dan Kirim Button
      Then the Buat dan Kirim button is disabled

    @continue @TEST_PMAN-6045
    Scenario: Search invoice manual by Nomor Invoice
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin search by "Nomor Invoice without change Search By" with value "MI/49220517/2022/09/80637"
      Then the result is displayed according the value "MI/49220517/2022/09/80637", "Indah Trivena Tampubolon", "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"

    @continue @TEST_PMAN-6045
    Scenario: Search invoice manual by Nama Penyewa
      When admin search by "Nama Penyewa" with value "Indah Trivena Tampubolon"
      Then the result is displayed according the value "MI/49220517/2022/09/80637", "Indah Trivena Tampubolon", "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"

    @continue @TEST_PMAN-6045
    Scenario: Search invoice manual by Nama Listing
      When admin search by "Nama Listing" with value "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"
      Then the result is displayed according the value "MI/49220517/2022/09/80637", "Indah Trivena Tampubolon", "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"

    @continue @TEST_PMAN-6046
    Scenario: Search Nama Listing per word with value "Singgahsini"
      When admin search by "Nama Listing" with value "Singgahsini"
      Then the result is displayed according the value Search per word "Data yang dicari tidak ditemukan"

    @continue @TEST_PMAN-6046
    Scenario: Search Nama Listing per word with value "khus"
      When admin search by "Nama Listing" with value "khus"
      Then the result is displayed according the value Search per word "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"

    @continue @TEST_PMAN-6046
    Scenario: Search Nama Listing per word with value "Omen tipe c"
      When admin search by "Nama Listing" with value "Omen tipe c"
      Then the result is displayed according the value Search per word "Kost Singgahsini Omen Tipe C Halmahera Utara"

    @continue @TEST_PMAN-6046
    Scenario: Search Nama Listing per word with value "Halmahera Utara"
      When admin search by "Nama Listing" with value "Halmahera Utara"
      Then the result is displayed according the value Search per word "Data yang dicari tidak ditemukan"

    @continue @TEST_PMAN-6046
    Scenario: Search Nomor Invoice per word with value "12345"
      When admin search by "Nomor Invoice" with value "12345"
      Then the result is displayed according the value Search per word "Data yang dicari tidak ditemukan"

    @TEST_PMAN-6046
    Scenario: Search Nama Penyewa per word with value "asdf yoohoo"
      When admin search by "Nama Penyewa" with value "asdf yoohoo"
      Then the result is displayed according the value Search per word "Data yang dicari tidak ditemukan"