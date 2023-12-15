@regression @pman @pms @additionalFeePMSKK

Feature: Additional Fee PMS KK

  @TEST_PMAN-8916 @continue
  Scenario: Check Empty State in Biaya Tambahan PMS KK
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to detail property "Khusus Automation"
    And admin see detail kerja sama
    Then empty state in Biaya Tambahan is displayed

  @TEST_PMAN-8917 @continue
  Scenario: Add Additional Fee Disesuaikan dengan Tagihan in PMS KK for Satuan Waktu only
    When admin add additional fee in PMS KK with data "Disesuaikan dengan Tagihan" for "Satuan Waktu"
      | Nama Biaya        | Ketentuan Bagi Hasil    | Jenis Biaya | Satuan Waktu  |
      | Pemakaian Listrik | Sesuai Basic Commission | Opsional    | Bulanan       |
    Then additional fee is created in PMS KK
      | Nama Biaya        | Penyewa Bisa Pilih Mandiri  | Jenis Biaya | Termasuk di Dalam Harga Sewa  | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil    |
      | Pemakaian Listrik | Tidak                       | Opsional    | Tidak                         | Satu Kali             | Sesuai Basic Commission |
    And additional fee is created in every listing
      | Listing | Harga                       |
      | Tipe A  | Disesuaikan dengan Tagihan  |
      | Tipe B  | Disesuaikan dengan Tagihan  |
      | Tipe C  | Disesuaikan dengan Tagihan  |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_PMAN-8918 @continue
  Scenario: Add Additional Fee Ditentukan di Awal in PMS KK for Satuan Waktu and Satuan Besaran
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu and Satuan Besaran"
      | Nama Biaya  | Ketentuan Bagi Hasil  | Jenis Biaya | Satuan Waktu  | Harga Satuan Waktu | Satuan Besaran  |
      | Mamiservice | Full ke Pemilik       | Opsional    | Bulanan       | 19000         | Kilogram (kg)   |
    Then additional fee is created in PMS KK
      | Nama Biaya  | Penyewa Bisa Pilih Mandiri  | Jenis Biaya | Termasuk di Dalam Harga Sewa  | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil  |
      | Mamiservice | Tidak                       | Opsional    | Tidak                         | Tetap                 | Full ke Pemilik       |
    And additional fee is created in every listing
      | Listing | Harga                       |
      | Tipe A  | Rp19.000 / Bulan (Per kg)   |
      | Tipe B  | Rp19.000 / Bulan (Per kg)   |
      | Tipe C  | Rp19.000 / Bulan (Per kg)   |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_PMAN-8919 @continue
  Scenario: Add Additional Fee Ditentukan di Awal in PMS KK for Satuan Besaran only
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Besaran"
      | Nama Biaya  | Ketentuan Bagi Hasil  | Jenis Biaya | Satuan Besaran  | Harga Kilogram (kg) |
      | Laundry     | Full ke Pemilik       | Opsional    | Kilogram (kg)   | 15500               |
    Then additional fee is created in PMS KK
      | Nama Biaya  | Penyewa Bisa Pilih Mandiri  | Jenis Biaya | Termasuk di Dalam Harga Sewa  | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil  |
      | Laundry     | Tidak                       | Opsional    | Tidak                         | Satu Kali             | Full ke Pemilik       |
    And additional fee is created in every listing
      | Listing | Harga           |
      | Tipe A  | Rp15.500 / kg   |
      | Tipe B  | Rp15.500 / kg   |
      | Tipe C  | Rp15.500 / kg   |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_PMAN-8920 @continue
  Scenario: Add Additional Fee Disesuaikan dengan Tagihan in PMS KK for Satuan Besaran only
    When admin add additional fee in PMS KK with data "Disesuaikan dengan Tagihan" for "Satuan Besaran"
      | Nama Biaya            | Ketentuan Bagi Hasil  | Jenis Biaya | Satuan Besaran  |
      | Kekurangan Bayar Sewa | Full ke Pemilik       | Opsional    | Per orang       |
    Then additional fee is created in PMS KK
      | Nama Biaya            | Penyewa Bisa Pilih Mandiri  | Jenis Biaya | Termasuk di Dalam Harga Sewa  | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil  |
      | Kekurangan Bayar Sewa | Tidak                       | Opsional    | Tidak                         | Satu Kali             | Full ke Pemilik       |
    And additional fee is created in every listing
      | Listing | Harga                       |
      | Tipe A  | Disesuaikan dengan Tagihan  |
      | Tipe B  | Disesuaikan dengan Tagihan  |
      | Tipe C  | Disesuaikan dengan Tagihan  |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_PMAN-8921 @continue
  Scenario: Add Additional Fee with 0 Amount in Satuan Waktu Only
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu"
      | Nama Biaya        | Ketentuan Bagi Hasil  | Jenis Biaya | Biaya Termasuk Harga Sewa | Pengaturan di Rincian Sewa        | Satuan Waktu  | Harga Satuan Waktu |
      | Iuran Lingkungan  | Full ke Pemilik       | Wajib       | Ya                        | Hanya nama biaya yang ditampilkan | Bulanan       | 0                  |
    Then additional fee is created in PMS KK
      | Nama Biaya       | Penyewa Bisa Pilih Mandiri  | Jenis Biaya | Termasuk di Dalam Harga Sewa                           | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil  |
      | Iuran Lingkungan | Tidak                       | Wajib       | Ya  Hanya nama biaya yang ditampilkan di rincian sewa  | Tetap                 | Full ke Pemilik       |
    And additional fee is created in every listing
      | Listing | Harga       |
      | Tipe A  | Rp0 / Bulan |
      | Tipe B  | Rp0 / Bulan |
      | Tipe C  | Rp0 / Bulan |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_PMAN-8923 @continue
  Scenario: Add Additional Fee with Input Manual for Ketentuan Bagi Hasil
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu and Satuan Besaran"
      | Nama Biaya  | Ketentuan Bagi Hasil  | Amount  | Jenis Biaya | Biaya Termasuk Harga Sewa | Pengaturan di Rincian Sewa        | Satuan Waktu  | Harga Satuan Waktu |  Satuan Besaran  |
      | Extend      | Masukkan Manual       | 11      | Wajib       | Ya                        | Hanya nama biaya yang ditampilkan | Harian        | 11000              |  Per orang       |
    Then additional fee is created in PMS KK
      | Nama Biaya  | Penyewa Bisa Pilih Mandiri  | Jenis Biaya | Termasuk di Dalam Harga Sewa                          | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil  |
      | Extend      | Tidak                       | Wajib       | Ya  Hanya nama biaya yang ditampilkan di rincian sewa | Satu Kali             | 11% ke Pemilik        |
    And additional fee is created in every listing
      | Listing | Harga                       |
      | Tipe A  | Rp11.000 / Hari (Per orang) |
      | Tipe B  | Rp11.000 / Hari (Per orang) |
      | Tipe C  | Rp11.000 / Hari (Per orang) |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_PMAN-8924 @continue
  Scenario: Add Additional Fee Ditentukan di Awal in PMS KK for Satuan Waktu only
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu"
      | Nama Biaya                     | Ketentuan Bagi Hasil     | Jenis Biaya | Biaya Termasuk Harga Sewa | Pengaturan di Rincian Sewa        | Satuan Waktu  | Harga Satuan Waktu |
      | Benefit Asuransi & Biaya Admin | Sesuai Basic Commission  | Wajib       | Ya                        | Hanya nama biaya yang ditampilkan | Bulanan       | 20000              |
    Then additional fee is created in PMS KK
      | Nama Biaya                     | Penyewa Bisa Pilih Mandiri  | Jenis Biaya | Termasuk di Dalam Harga Sewa                           | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil    |
      | Benefit Asuransi & Biaya Admin | Tidak                       | Wajib       | Ya  Hanya nama biaya yang ditampilkan di rincian sewa  | Tetap                 | Sesuai Basic Commission |
    And additional fee is created in every listing
      | Listing | Harga            |
      | Tipe A  | Rp20.000 / Bulan |
      | Tipe B  | Rp20.000 / Bulan |
      | Tipe C  | Rp20.000 / Bulan |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table

  @TEST_PMAN-8925
  Scenario: Add Additional Fee with 0 Amount in Input Manual Bagi Hasil and in Satuan Waktu & Besaran
    When admin add additional fee in PMS KK with data "Ditentukan di Awal" for "Satuan Waktu and Satuan Besaran"
      | Nama Biaya      | Ketentuan Bagi Hasil  | Amount  | Jenis Biaya | Satuan Waktu  | Harga Satuan Waktu |  Satuan Besaran  |
      | Alat Elektronik | Masukkan Manual       | 0       | Opsional    | Bulanan       | 0                  |  Item/pcs        |
    Then additional fee is created in PMS KK
      | Nama Biaya      | Penyewa Bisa Pilih Mandiri  | Jenis Biaya | Termasuk di Dalam Harga Sewa  | Tipe Pembayaran Biaya | Ketentuan Bagi Hasil  |
      | Alat Elektronik | Tidak                       | Opsional    | Tidak                         | Tetap                 | 0% ke Pemilik         |
    And additional fee is created in every listing
      | Listing | Harga                      |
      | Tipe A  | Rp0 / Bulan (Per item/pcs) |
      | Tipe B  | Rp0 / Bulan (Per item/pcs) |
      | Tipe C  | Rp0 / Bulan (Per item/pcs) |
    #@TEST_PMAN-8663
    #Scenario: Delete additional fee in General Level
    When admin delete additional fee in General Level
    Then additional fee is deleted from Biaya Tambahan table