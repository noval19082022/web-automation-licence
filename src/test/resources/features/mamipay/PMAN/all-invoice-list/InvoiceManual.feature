@regression @mamipay @all-invoice-list

  Feature: All Invoice List

    @TEST_SS-584 @pman @continue @pman-prod
    Scenario: Invoice manual in All Invoice List Menu
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      When admin open menu all invoice list
      Then list contains invoice manual

    @TEST_SS-711 @pman @pman-prod
    Scenario: Filter Invoice Manual
      And admin filter by order type "Invoice Manual"
      Then system should display only invoice with type "Invoice Manual"

    @TEST_SS-576
    Scenario: Change status invoice manual
      #create invoice manual biaya sewa
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
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
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara   | Rp500.000     | Unpaid          |
      And save invoice manual number
      #paid invoice manual
      When admin open menu all invoice list
      And admin search by "Invoice Number" using "saved invoice"
      Then invoice status should be "unpaid"
      When admin change status invoice to "paid" "today"
      Then invoice status should be "paid"
      #set to unpaid again
      When admin change status invoice to "unpaid" "today"
      Then invoice status should be "unpaid"

    @TEST_SS-574
    Scenario: View log Invoice manual
      #pay using bank
      When admin open tenant invoice
      And admin pay tenant invoice using bank "Mandiri"
      Then invoice status should be "paid"
      #check log
      When admin view log invoice manual
      Then detail data invoice should be
        | Invoice number    | Status  | Order Type                | Amount  | Paid Amount |
        | saved invoice     | paid    | mamipay_cp_manual_invoice | 500000  | 500000      |
      And detail data invoice revision history should be
        | Row | Change by       | Changer role  | What Changed | Old Value | New Value |
        | 1   | Automation PMAN | administrator | status       | unpaid    | paid      |
        | 3   | Automation PMAN | administrator | status       | paid      | unpaid    |
        | 5   | system          | system        | status       | unpaid    | paid      |
      And detail data invoice payment history should be
        | Payment Method        | Amount  | Status  | Paid Amount |
        | midtrans_api_mandiri  | 500000  | paid    | 500000      |