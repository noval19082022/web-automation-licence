@regression @pman @pms @disbursement

  Feature: Disbursement PMS

    @TEST_PMAN-4473
    Scenario: Tambahan Pendapatan for Owner
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to Disbursement menu
      And admin go to detail transfer "Khusus Automation"
      #create tambahan pendapatan
      When admin add new tambahan pendapatan
        | Denda Keterlambatan |
        | 2                   |
        | 50000               |
      Then tambahan pendapatan should contains biaya
        | Nama Pendapatan     | Harga Satuan  | Kuantitas | Total Pendapatan  | Total Tambahan Pendapatan |
        | Denda Keterlambatan | Rp50.000      | 2x        | Rp100.000         | Rp100.000                 |
      #edit tambahan pendapatan
      When admin edit tambahan pendapatan 1
        | Pindah Tipe |
        | 4           |
        | 10000       |
      Then tambahan pendapatan should contains biaya
        | Nama Pendapatan | Harga Satuan  | Kuantitas | Total Pendapatan | Total Tambahan Pendapatan |
        | Pindah Tipe     | Rp10.000      | 4x        | Rp40.000         | Rp40.000                  |
      #delete tambahan pendapatan
      When admin delete tambahan pendapatan 1
      Then tambahan pendapatan should be empty

    @TEST_PMAN-5040 @pman-prod
    Scenario: Check Riwayat Transfer Pendapatan
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to Disbursement menu
      And admin go to detail transfer "Khusus Automation"
      When admin click riwayat transfer pendapatan
      Then admin should redirect to riwayat transfer pendapatan section

    @TEST_PMAN-5571
    Scenario: Button Refresh Availablity
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to Disbursement menu
      And admin go to detail transfer "Khusus Automation"
      Then button refresh should be visible
      #Approve from detail disbursement
      When admin "approve" dibursement from detail
      Then button refresh should be invisible
      When admin "unapprove" dibursement from detail
      Then button refresh should be visible
      #Approve from list disbursement
      When admin go to Disbursement menu
      And admin search disbursement "Khusus Automation"
      And admin "approve" disbursement from list
      And admin go to detail transfer
      Then button refresh should be invisible
      When admin go to Disbursement menu
      And admin search disbursement "Khusus Automation"
      And admin "unapprove" disbursement from list
      And admin go to detail transfer
      Then button refresh should be visible

    @TEST_PMAN-5447 @pman-prod
    Scenario: Check empty state in the transfer pendapatan pemilik table
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to Disbursement menu
      And admin clicks on next month in calendar
      And admin search disbursement "Khusus Automation"
      Then empty state in Disbursement menu is displayed