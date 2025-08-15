@essentialTest2

Feature: [PMAN] Essential Test PMS

  @continue @TEST_PMAN-8433
  Scenario: Add new Additional Fee
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to additional fee management menu
    When admin add new additional fee
    When admin input nama biaya "Automated Biaya PMAN"
    And admin select tipe pembayaran biaya "Satu Kali"
    And admin select waktu penentuan harga biaya "Disesuaikan dengan Tagihan"
    When admin select satuan waktu biaya "Harian"
    And admin submit additional fee
    Then new additional fee "Automated Biaya PMAN" added
      | Tipe Pembayaran | Satuan Biaya | Waktu Penentuan Harga Biaya | Penyewa Bisa Pilih Mandiri |
      | Satu Kali       | Harian       | Disesuaikan dengan Tagihan  | Tidak                      |

  @TEST_PMAN-8667
  Scenario: Delete additional fee master data
    When admin delete additional fee "Automated Biaya PMAN"
    Then no additional fee master data with name "Automated Biaya PMAN"

  @TEST_PMAN-7674
  Scenario: Check Auto Disbursement Change Log When Auto Disbursement turn into "ON/OFF"
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to detail property "Khusus Automation"
    #Check Auto Disbursement ON
    And admin change Transfer Pendapatan Otomatis to "ON"
    Then change log auto disbursement "ON" is displayed
      | Diubah oleh | Role        | Data yang Diubah             | Input Lama | Input Baru | Waktu Diubah |
      | PMAN Admin  | Super Admin | Transfer Pendapatan Otomatis | Nonaktif   | Aktif      | today        |
    #Check Auto Disbursement OFF
    When admin change Transfer Pendapatan Otomatis to "OFF"
    Then change log auto disbursement "OFF" is displayed
      | Diubah oleh | Role        | Data yang Diubah             | Input Lama | Input Baru | Waktu Diubah |
      | PMAN Admin  | Super Admin | Transfer Pendapatan Otomatis | Aktif      | Nonaktif   | today        |

  @continue @TEST_PMAN-4620
  Scenario: See and Edit Penanggung Jawab
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to detail property "Khusus Automation"
    When admin see penanggung jawab section
    Then penanggung jawab should be match
      | BSE      | BD      | AS    | Hospitality |
      | Okta BSE | Budiman | Fitri | Dimas       |
    #Edit penanggung jawab
    When admin edit penanggung jawab
      | BSE      | BD        | AS    | Hospitality |
      | Maya BSE | Karentest | Indri | Gilang      |
    Then penanggung jawab should be match
      | BSE      | BD        | AS    | Hospitality |
      | Maya BSE | Karentest | Indri | Gilang      |
    #Revert back penanggung jawab
    When admin edit penanggung jawab
      | BSE      | BD      | AS    | Hospitality |
      | Okta BSE | Budiman | Fitri | Dimas       |
    Then penanggung jawab should be match
      | BSE      | BD      | AS    | Hospitality |
      | Okta BSE | Budiman | Fitri | Dimas       |

  @TEST_PMAN-3949
  Scenario: See and Edit Detail Kerja Sama
    When admin see detail kerja sama
    Then detail kerja sama should be match with data
      | Jenis Produk | Model Kerja Sama | Basic Commission | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP | Presentase ADP | Jumlah ADP | Pemilik Booking | Mamikos Booking | Jangka Waktu | Awal Kerja Sama | Akhir Kerja Sama | Biaya Keanggotaan |
      | Apik         | Static Rate      | 20%              | 9           | Full A  | 5%            | Rp4.000.000 | -        | -              | -          | 75%             | 25%             | 24 Bulan     | 27 October 2023 | 26 October 2025  | Rp25.000          |
    #Admin edit detail kerja sama
    When admin edit detail kerja sama
      | Jenis Produk | Model Kerja Sama | Basic Commission | Tipe JP | Presentase JP | Jumlah JP | Tipe ADP | Presentase ADP | Jumlah ADP | Jangka Waktu | Biaya Keanggotaan |
      | Singgahsini  | Commission Rate  | 15%              | Partial | 10            | 2000000   | 6 Bulan  | 5              | 4000000    | 12           | 5000              |
    Then detail kerja sama should be match with data
      | Jenis Produk | Model Kerja Sama | Basic Commission | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP | Presentase ADP | Jumlah ADP  | Pemilik Booking | Mamikos Booking | Jangka Waktu | Awal Kerja Sama | Akhir Kerja Sama | Biaya Keanggotaan |
      | Singgahsini  | Commission Rate  | 15%              | 9           | Partial | 10%           | Rp2.000.000 | 6 Bulan  | 5%             | Rp4.000.000 | 70%             | 30%             | 12 Bulan     | 27 October 2023 | 26 October 2024  | Rp5.000           |
    #revert back detail kerja sama
    When admin edit detail kerja sama
      | Jenis Produk | Model Kerja Sama | Basic Commission | Tipe JP | Presentase JP | Jumlah JP | Tipe ADP | Presentase ADP | Jumlah ADP | Jangka Waktu | Biaya Keanggotaan |
      | Apik         | Static Rate      | 20%              | Full A  | 5%            | 4000000   | None     | -              | -          | 24           | 25000             |
    Then detail kerja sama should be match with data
      | Jenis Produk | Model Kerja Sama | Basic Commission | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP | Presentase ADP | Jumlah ADP | Pemilik Booking | Mamikos Booking | Jangka Waktu | Awal Kerja Sama | Akhir Kerja Sama | Biaya Keanggotaan |
      | Apik         | Static Rate      | 20%              | 9           | Full A  | 5%            | Rp4.000.000 | -        | -              | -          | 75%             | 25%             | 24 Bulan     | 27 October 2023 | 26 October 2025  | Rp25.000          |

  @TEST_PMAN-6038
  Scenario: Add valid owner expenditure
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to other transation menu
    When admin add new owner expenditure "Reimbursement" in property "Khusus Automation"
    And admin add multiple biaya pengeluaran :
      | no | Kategori Pengeluaran        | Nama Pengeluaran | Kuantitas | Nominal Pengeluaran | Status Persediaan | Jenis Produk |
      | 1  | Administrasi & Iuran Kos    | Wifi             | 1         | 50000               | Non Stock         | LSSS         |
      | 2  | Amenities Penyewa           | Sabun Mandi      | 1         | 20000               | Stock             | LSAP         |
      | 3  | Bahan Pembersih Kos & Dapur | Wipol            | 1         | 20000               | Stock             | PC           |
    And admin upload valid attachment
    And admin input no invoice biaya "AT/2023/01"
    And admin choose tujuan transfer "Other (Internal Mamikos)"
    And submit owner expenditure
    Then owner expenditure confirmation pop up appear
    #cancel confirmation add owner expenditure
    When user "cancel" tambah data owner expenditure
    Then confirmation pop up should closed
    #confirm add owner expenditure
    When submit owner expenditure
    And user "confirm" tambah data owner expenditure
    Then toast message "Data berhasil ditambah" should be appear
    And new owner expenditure record should be on the first list contains:
      | Tipe Pengajuan Cash Out | Nama Properti                                    | Total Pengeluaran |
      | Reimbursement           | Kost Apik Khusus Automation PMAN Halmahera Utara | Rp90.000          |
    And should contains nama pengeluaran:
      | Wifi        |
      | Sabun Mandi |
      | Wipol       |

  @continue @context1 @context2 @TEST_PMAN-3690
  Scenario: Add Role
    Given owner set browser context to "context1"
    And bring page to front
    And admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to role management menu
      #back from tambah Role
    When admin go to tambah role
    And admin set new role "Automation Test"
      | Akses Homepage - Lihat Detail Properti |
      | Akses Homepage - Unduh CSV             |
      | Akses Ketersediaan Kamar               |
    But admin back to role management home
    Then role "Automation Test" should not exist
      #reset permission
    When admin go to tambah role
    And admin set new role "Automation Test"
      | Akses Disbursement - Approve / Unapprove |
      | Akses Disbursement - Edit Transaction    |
      | Akses Disbursement - Lihat Detail        |
      | Akses Homepage - Lihat Detail Properti   |
      | Akses Homepage - Unduh CSV               |
      | Akses Ketersediaan Kamar                 |
    But admin reset permission
    Then all permission are unchecked
      #Add new Role
    When admin set new role "Automation Test"
      | Akses Homepage - Lihat Detail Properti |
      | Akses Homepage - Unduh CSV             |
      | Akses Ketersediaan Kamar               |
    And admin submit add new role
    Then system should show toast message "Role berhasil disimpan."

  @continue @TEST_PMAN-3687
  Scenario: Edit Role
    When admin go to role management menu
      #change using existing role name
    When admin edit role "Automation Test" to "Product PMAN"
    And admin submit add new role
    Then system show nama role error message "Nama role sudah digunakan. Masukkan nama role yang lain."
      #change to new role name
    When admin rename role name to "Automation Test PMAN"
    And admin add permissions
      | Akses Disbursement - Lihat Detail        |
      | Akses Disbursement - Approve / Unapprove |
    And admin submit add new role
    Then system should show toast message "Perubahan berhasil disimpan."

  @continue @TEST_PMAN-3685
  Scenario: Assign Member to Role
      #add invalid member
    When admin assign member "giska@mamiteam.com" to role "Automation Test PMAN"
    Then system show tambah member error message "Member tidak ditemukan"
      #add valid member
    When admin go to role management menu
    When admin assign member "automationpman01@mamikos.com" to role "Automation Test PMAN"
    Then member "automationpman01@mamikos.com" should registered

  @continue @TEST_PMAN-3689
  Scenario: Check Button Available
    Given owner set browser context to "context2"
    And bring page to front
    When admin go to pms singgahsini
    And admin login pms :
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    #check permission homepage
    Then admin automation have permission for button
      | Lihat Detail       |
      | Ketersediaan Kamar |
      | Unduh CSV          |

  @continue @TEST_PMAN-3695
  Scenario: Delete Member
    Given owner set browser context to "context1"
    And bring page to front
      #cancel delete member
    When admin delete member "automationpman01@mamikos.com"
    But admin cancel confirmation to delete
    Then member "automationpman01@mamikos.com" still registered
      #confirm delete member
    When admin delete member "automationpman01@mamikos.com"
    But admin confirm to delete member
    Then member "automationpman01@mamikos.com" not registered

  @TEST_PMAN-3692
  Scenario: Delete Role
    Given owner set browser context to "context1"
    And bring page to front
    When admin go to role management menu
    And admin delete role "Automation Test PMAN"
    Then role "Automation Test PMAN" should not exist