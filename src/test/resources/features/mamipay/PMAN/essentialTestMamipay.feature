@essentialTest2

  Feature: [PMAN] Essential Test Mamipay

    @TEST_PMAN-3359
    Scenario: Transfer Disbursement Without Edit Data
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
      And admin open menu CP Disbursement
    #create new cp disbursement
      And admin tambah data transfer
      And admin search property "khu" in tambah data transfer
      And admin select suggestion "Kost Apik Khusus Automation PMAN Halmahera Utara"
      Then transfer information should auto fill
        | Product Type | Bank     | Nomor Rekening | Nama Pemilik Rekening | Nomor Telepon Pemilik |
        | APIK         | mandiri  | 10000245429    | Yudha Ferroza         | 083342344565          |
      When admin fill remaining field
        | Total Pendapatan  | Tipe Transaksi  | Tanggal Transfer  | Berkas Laporan  | Tipe Disbursement     |
        | 100000            | Commission      | today             | pdf example.pdf | Disbursement susulan  |
      And admin submit tambah data transfer
      Then new cp disbursement data should add in daftar transfer
        | Tanggal Transfer ke Pemilik | Nama Property                                     | Tipe Transaksi  | Total Pendapatan  | Detail Rekening                   |
        | (Today)                     | Kost Apik Khusus Automation PMAN Halmahera Utara  | Commission      | Rp100.000         | Yudha Ferroza 10000245429 mandiri |
    #transfer cp disbursement
      When admin search cp disbursement by "Nama Property" using keyword "Khusus Automation"
      Then show all disbursement from property name "Kost Apik Khusus Automation PMAN Halmahera Utara"
      When admin checks Preview Data Transfer
      Then Data Transfer that has been inputted is displayed on Preview Data Transfer
        | Nama Property                                     | Product Type | Bank     | Nomor Rekening | Nama Pemilik Rekening | Nomor Telepon Pemilik | Total Pendapatan  | Tipe Transaksi  | Tanggal Transfer  | Tipe Disbursement     |
        | Kost Apik Khusus Automation PMAN Halmahera Utara  | APIK         | mandiri  | 10000245429    | Yudha Ferroza         | 083342344565          | 100000.00         | Commission      | today             | Disbursement susulan  |
      When admin clicks Transfer Sekarang on Preview Data Transfer
    #Check in Transfer Diproses tab
      And admin open "Transfer Diproses" tab
      And admin search cp disbursement by "Nama Property" using keyword "Khusus Automation"
      Then disbursement "without edit" is displayed in Process tab