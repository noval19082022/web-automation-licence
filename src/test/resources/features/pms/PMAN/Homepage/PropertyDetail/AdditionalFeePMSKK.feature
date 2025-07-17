@regression @pman2 @pms @additionalFeePMSKK

Feature: Additional Fee PMS KK

  @TEST_SS-797 @continue
  Scenario: Check Empty State in Biaya Tambahan PMS KK
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to detail property "Khusus Automation"
    And admin see detail kerja sama
    Then empty state in Biaya Tambahan is displayed

  @TEST_SS-796 @continue
  Scenario: Add Additional Fee Disesuaikan dengan Tagihan in PMS KK for Satuan Waktu only
    When admin add additional fee in PMS KK with data "Disesuaikan dengan Tagihan" for "Satuan Waktu"
      | Nama Biaya        | Ketentuan Bagi Hasil    | Jenis Biaya | Satuan Waktu |
      | Pemakaian Listrik | Sesuai Basic Commission | Opsional    | Bulanan      |
    Then additional fee is created in PMS KK
      | Nama Biaya        | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil    |
      | Pemakaian Listrik | Tidak                      | Opsional    | Tidak                        | Satu Kali             | Sesuai Basic Commission |
    And additional fee is created in every listing
      | Listing | Harga                      |
      | Tipe A  | Disesuaikan dengan Tagihan |
      | Tipe B  | Disesuaikan dengan Tagihan |
      | Tipe C  | Disesuaikan dengan Tagihan |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-802 @continue
  Scenario: Add Additional Fee Ditentukan di Awal in PMS KK for Satuan Waktu and Satuan Besaran
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu and Satuan Besaran"
      | Nama Biaya  | Ketentuan Bagi Hasil | Jenis Biaya | Satuan Waktu | Harga Satuan Waktu | Satuan Besaran |
      | Mamiservice | Full ke Pemilik      | Opsional    | Bulanan      | 19000              | Kilogram (kg)  |
    Then additional fee is created in PMS KK
      | Nama Biaya  | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil |
      | Mamiservice | Tidak                      | Opsional    | Tidak                        | Tetap                 | Full ke Pemilik      |
    And additional fee is created in every listing
      | Listing | Harga                     |
      | Tipe A  | Rp19.000 / Bulan (Per kg) |
      | Tipe B  | Rp19.000 / Bulan (Per kg) |
      | Tipe C  | Rp19.000 / Bulan (Per kg) |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-799 @continue
  Scenario: Add Additional Fee Ditentukan di Awal in PMS KK for Satuan Besaran only
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Besaran"
      | Nama Biaya | Ketentuan Bagi Hasil | Jenis Biaya | Satuan Besaran | Harga Kilogram (kg) |
      | Laundry    | Full ke Pemilik      | Opsional    | Kilogram (kg)  | 15500               |
    Then additional fee is created in PMS KK
      | Nama Biaya | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil |
      | Laundry    | Tidak                      | Opsional    | Tidak                        | Satu Kali             | Full ke Pemilik      |
    And additional fee is created in every listing
      | Listing | Harga         |
      | Tipe A  | Rp15.500 / kg |
      | Tipe B  | Rp15.500 / kg |
      | Tipe C  | Rp15.500 / kg |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-793 @continue
  Scenario: Add Additional Fee Disesuaikan dengan Tagihan in PMS KK for Satuan Besaran only
    When admin add additional fee in PMS KK with data "Disesuaikan dengan Tagihan" for "Satuan Besaran"
      | Nama Biaya            | Ketentuan Bagi Hasil | Jenis Biaya | Satuan Besaran |
      | Kekurangan Bayar Sewa | Full ke Pemilik      | Opsional    | Per orang      |
    Then additional fee is created in PMS KK
      | Nama Biaya            | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil |
      | Kekurangan Bayar Sewa | Tidak                      | Opsional    | Tidak                        | Satu Kali             | Full ke Pemilik      |
    And additional fee is created in every listing
      | Listing | Harga                      |
      | Tipe A  | Disesuaikan dengan Tagihan |
      | Tipe B  | Disesuaikan dengan Tagihan |
      | Tipe C  | Disesuaikan dengan Tagihan |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-791 @continue
  Scenario: Add Additional Fee with 0 Amount in Satuan Waktu Only
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu"
      | Nama Biaya       | Ketentuan Bagi Hasil | Jenis Biaya | Biaya Termasuk Harga Sewa | Pengaturan di Rincian Sewa        | Satuan Waktu | Harga Satuan Waktu |
      | Iuran Lingkungan | Full ke Pemilik      | Wajib       | Ya                        | Hanya nama biaya yang ditampilkan | Bulanan      | 0                  |
    Then additional fee is created in PMS KK
      | Nama Biaya       | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa                          | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil |
      | Iuran Lingkungan | Tidak                      | Wajib       | Ya  Hanya nama biaya yang ditampilkan di rincian sewa | Tetap                 | Full ke Pemilik      |
    And additional fee is created in every listing
      | Listing | Harga       |
      | Tipe A  | Rp0 / Bulan |
      | Tipe B  | Rp0 / Bulan |
      | Tipe C  | Rp0 / Bulan |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-757 @continue
  Scenario: Add Additional Fee with Input Manual for Ketentuan Bagi Hasil
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu and Satuan Besaran"
      | Nama Biaya | Ketentuan Bagi Hasil | Amount | Jenis Biaya | Satuan Waktu | Harga Satuan Waktu | Satuan Besaran |
      | Extend     | Masukkan Manual      | 11     | Opsional    | Harian       | 11000              | Per orang      |
    Then additional fee is created in PMS KK
      | Nama Biaya | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil |
      | Extend     | Tidak                      | Opsional    | Tidak                        | Satu Kali             | 11% ke Pemilik       |
    And additional fee is created in every listing
      | Listing | Harga                       |
      | Tipe A  | Rp11.000 / Hari (Per orang) |
      | Tipe B  | Rp11.000 / Hari (Per orang) |
      | Tipe C  | Rp11.000 / Hari (Per orang) |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-751 @continue
  Scenario: Add Additional Fee Ditentukan di Awal in PMS KK for Satuan Waktu only
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu"
      | Nama Biaya                     | Ketentuan Bagi Hasil    | Jenis Biaya | Biaya Termasuk Harga Sewa | Pengaturan di Rincian Sewa        | Satuan Waktu | Harga Satuan Waktu |
      | Benefit Asuransi & Biaya Admin | Sesuai Basic Commission | Wajib       | Ya                        | Hanya nama biaya yang ditampilkan | Bulanan      | 20000              |
    Then additional fee is created in PMS KK
      | Nama Biaya                     | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa                          | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil    |
      | Benefit Asuransi & Biaya Admin | Tidak                      | Wajib       | Ya  Hanya nama biaya yang ditampilkan di rincian sewa | Tetap                 | Sesuai Basic Commission |
    And additional fee is created in every listing
      | Listing | Harga            |
      | Tipe A  | Rp20.000 / Bulan |
      | Tipe B  | Rp20.000 / Bulan |
      | Tipe C  | Rp20.000 / Bulan |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-749
  Scenario: Add Additional Fee with 0 Amount in Input Manual Bagi Hasil and in Satuan Waktu & Besaran
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu and Satuan Besaran"
      | Nama Biaya      | Ketentuan Bagi Hasil | Amount | Jenis Biaya | Satuan Waktu | Harga Satuan Waktu | Satuan Besaran |
      | Alat Elektronik | Masukkan Manual      | 0      | Opsional    | Bulanan      | 0                  | Item/pcs       |
    Then additional fee is created in PMS KK
      | Nama Biaya      | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil |
      | Alat Elektronik | Tidak                      | Opsional    | Tidak                        | Tetap                 | 0% ke Pemilik        |
    And additional fee is created in every listing
      | Listing | Harga                      |
      | Tipe A  | Rp0 / Bulan (Per item/pcs) |
      | Tipe B  | Rp0 / Bulan (Per item/pcs) |
      | Tipe C  | Rp0 / Bulan (Per item/pcs) |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-7636 @continue
  Scenario: Add existing additional fee
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to detail property "Harapan Bunda"
    And admin see detail kerja sama
    When admin add existing additional fee "Benefit Asuransi & Biaya Admin"
    Then admin can't find additional fee

  @TEST_SS-7637 @continue
  Scenario: Add additional fee in specific listing
    When admin go to pms singgahsini
    And admin go to detail property "Khusus Automation"
    And admin see detail kerja sama
    And admin select additional fee "Bawa Rice Cooker"
    And admin turn off toggle terapkan ke semua listing
    Then dropdown pilih listing appear
    And dropdown pilih listing contains listing
      | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara |
      | Kost Apik Khusus Automation PMAN Tipe B Halmahera Utara |
      | Kost Apik Khusus Automation PMAN Tipe C Halmahera Utara |
    When admin check listing "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"
    And admin select ketentuan bagi hasil "Full ke Pemilik"
    And admin select satuan waktu biaya "Bulanan"
    And admin fill harga bulanan "30000"
    And admin select satuan besaran biaya "Item/pcs"
    And admin submit additional fee pms
    Then additional fee is created in PMS KK
      | Nama Biaya       | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil |
      | Bawa Rice Cooker | Ya  Booking dan Stay       | Opsional    | Tidak                        | Tetap                 | Full ke Pemilik      |
    And additional fee is created in every listing
      | Listing | Harga                           |
      | Tipe A  | Rp30.000 / Bulan (Per item/pcs) |
    #delete additional fee
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-143 @continue
  Scenario: Edit additional fee in listing level
    #Add new additional fee
    When admin select additional fee "Alat Elektronik"
    And admin select ketentuan bagi hasil "Sesuai Basic Commission"
    And admin choose jenis biaya "Opsional"
    And admin select satuan waktu biaya "Bulanan"
    And admin fill harga bulanan "1000000"
    And admin select satuan besaran biaya "Item/pcs"
    And admin submit additional fee pms
    Then additional fee is created in PMS KK
      | Nama Biaya      | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil    |
      | Alat Elektronik | Tidak                      | Opsional    | Tidak                        | Tetap                 | Sesuai Basic Commission |
    And additional fee is created in every listing
      | Listing | Harga                              |
      | Tipe A  | Rp1.000.000 / Bulan (Per item/pcs) |
      | Tipe B  | Rp1.000.000 / Bulan (Per item/pcs) |
      | Tipe C  | Rp1.000.000 / Bulan (Per item/pcs) |
    #Edit additional fee
    When admin edit additional fee in "Tipe A"
    And admin fill harga bulanan "200000"
    And admin submit edit additional fee
    Then additional fee is created in every listing
      | Listing | Harga                              |
      | Tipe A  | Rp200.000 / Bulan (Per item/pcs)   |
      | Tipe B  | Rp1.000.000 / Bulan (Per item/pcs) |
      | Tipe C  | Rp1.000.000 / Bulan (Per item/pcs) |

  @TEST_SS-140
  Scenario: Delete additional fee in Listing level
    When admin delete additional fee in "Tipe A"
    Then additional fee is created in every listing
      | Listing | Harga                              |
      | Tipe B  | Rp1.000.000 / Bulan (Per item/pcs) |
      | Tipe C  | Rp1.000.000 / Bulan (Per item/pcs) |
    When admin delete additional fee in "Tipe B"
    Then additional fee is created in every listing
      | Listing | Harga                              |
      | Tipe C  | Rp1.000.000 / Bulan (Per item/pcs) |
    When admin delete additional fee in "Tipe C"
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-7636 @continue
  Scenario: Add existing additional fee
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to detail property "Harapan Bunda"
    And admin see detail kerja sama
    When admin add existing additional fee "Benefit Asuransi & Biaya Admin"
    Then admin can't find additional fee

  @TEST_SS-7637 @continue
  Scenario: Add additional fee in specific listing
    When admin go to pms singgahsini
    And admin go to detail property "Khusus Automation"
    And admin see detail kerja sama
    And admin select additional fee "Bawa Rice Cooker"
    And admin turn off toggle terapkan ke semua listing
    Then dropdown pilih listing appear
    And dropdown pilih listing contains listing
      | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara |
      | Kost Apik Khusus Automation PMAN Tipe B Halmahera Utara |
      | Kost Apik Khusus Automation PMAN Tipe C Halmahera Utara |
    When admin check listing "Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara"
    And admin select ketentuan bagi hasil "Full ke Pemilik"
    And admin select satuan waktu biaya "Bulanan"
    And admin fill harga bulanan "30000"
    And admin select satuan besaran biaya "Item/pcs"
    And admin submit additional fee pms
    Then additional fee is created in PMS KK
      | Nama Biaya       | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil |
      | Bawa Rice Cooker | Ya  Booking dan Stay       | Opsional    | Tidak                        | Tetap                 | Full ke Pemilik      |
    And additional fee is created in every listing
      | Listing | Harga                           |
      | Tipe A  | Rp30.000 / Bulan (Per item/pcs) |
    #delete additional fee
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_SS-143 @continue
  Scenario: Edit additional fee in listing level
    #Add new additional fee
    When admin select additional fee "Alat Elektronik"
    And admin select ketentuan bagi hasil "Sesuai Basic Commission"
    And admin choose jenis biaya "Opsional"
    And admin select satuan waktu biaya "Bulanan"
    And admin fill harga bulanan "1000000"
    And admin select satuan besaran biaya "Item/pcs"
    And admin submit additional fee pms
    Then additional fee is created in PMS KK
      | Nama Biaya      | Penyewa Bisa Pilih Mandiri | Jenis Biaya | Termasuk di Dalam Harga Sewa | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil    |
      | Alat Elektronik | Tidak                      | Opsional    | Tidak                        | Tetap                 | Sesuai Basic Commission |
    And additional fee is created in every listing
      | Listing | Harga                              |
      | Tipe A  | Rp1.000.000 / Bulan (Per item/pcs) |
      | Tipe B  | Rp1.000.000 / Bulan (Per item/pcs) |
      | Tipe C  | Rp1.000.000 / Bulan (Per item/pcs) |
    #Edit additional fee
    When admin edit additional fee in "Tipe A"
    And admin fill harga bulanan "200000"
    And admin submit edit additional fee
    Then additional fee is created in every listing
      | Listing | Harga                              |
      | Tipe A  | Rp200.000 / Bulan (Per item/pcs)   |
      | Tipe B  | Rp1.000.000 / Bulan (Per item/pcs) |
      | Tipe C  | Rp1.000.000 / Bulan (Per item/pcs) |

  @TEST_SS-140
  Scenario: Delete additional fee in Listing level
    When admin delete additional fee in "Tipe A"
    Then additional fee is created in every listing
      | Listing | Harga                              |
      | Tipe B  | Rp1.000.000 / Bulan (Per item/pcs) |
      | Tipe C  | Rp1.000.000 / Bulan (Per item/pcs) |
    When admin delete additional fee in "Tipe B"
    Then additional fee is created in every listing
      | Listing | Harga                              |
      | Tipe C  | Rp1.000.000 / Bulan (Per item/pcs) |
    When admin delete additional fee in "Tipe C"
    Then additional fee is deleted from Biaya Tambahan table