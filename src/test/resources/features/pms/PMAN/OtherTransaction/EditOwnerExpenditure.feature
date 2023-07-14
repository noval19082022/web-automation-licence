@regression @pman @pms @owner-expenditure

  Feature: Edit Owner Expenditure

    Background: Open Other Transaction Menu
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to other transation menu

    @TEST_PMAN-6177
    Scenario: Edit Owner Expenditure with valid value
      When admin filter status konfirmasi manager "Menunggu Konfirmasi"
      And admin edit type pengajuan cash out to "Petty Cash" at property "Harapan Bunda"
      And admin edit pengeluaran owner expenditure :
        | no  | Kategori Pengeluaran        | Nama Pengeluaran  | Kuantitas | Nominal Pengeluaran | Status Persediaan | Jenis Produk  |
        | 1   | Pembayaran Listrik          | Token             | -         | -                   | -                 | LSSS          |
        | 2   | -                           | -                 | 5         | 100000              | Stock             | LSAP          |
      And admin remove pengeluaran "3"
      Then total pengeluaran should be "Rp150.000"
      When admin reupload lampiran
      And admin edit no invoice biaya "AT/2023/01/Edit"
      And admin edit tujuan transfer "CV Jaya Mandiri (Vendor)"
      And edit owner expenditure
      Then toast message "Data berhasil diubah" should be appear
      When admin filter status konfirmasi manager "Menunggu Konfirmasi"
      Then owner expenditure data should be change to :
        | Tipe Pengajuan Cash Out | Nama Properti                                     | Total Pengeluaran |
        | Petty Cash              | Kost Singgahsini Harapan Bunda Halmahera Utara    | Rp150.000         |
      And detail transfer should be change to :
        | Vendor Name     | Vendor Account    | Vendor Bank   | Vendor Owner    | No Invoice Biaya  |
        | CV Jaya Mandiri | 4106667772        | BCA           | Jaya Mandiri CV | AT/2023/01/Edit   |
      And detail pengeluaran data should be change to :
        | Kategori Pengeluaran  | Nama Pengeluaran  |
        | Pembayaran Listrik    | Token             |