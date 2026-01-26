@pms @disbursement @changeRevenueModel @SS2

Feature: PMS Change Revenue Model in Informasi Transfer Pendapatan Properti

  @TEST_SS-642
  Scenario: Get Correct Informasi Transfer Pendapatan Properti for Hybrid Revenue Model
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to Disbursement menu
    And admin select disbursement period "Periode 1"
    And admin go to detail transfer "Khusus Automation"
    And admin open new page
    And admin navigates to Kontrak Kerja Sama
    Then detail kerja sama should be match with data
      | Jenis Produk | Model Kerja Sama | Basic Commission | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP | Presentase ADP | Jumlah ADP | Pemilik Booking | Mamikos Booking | Jangka Waktu | Awal Kerja Sama | Akhir Kerja Sama | Biaya Keanggotaan |
      | Apik         | Static Rate      | 20%              | 9           | Full A  | 5%            | Rp4.000.000 | -        | -%             | -          | 75%             | 25%             | 24 Bulan     | 27 October 2024 | 26 October 2026  | Rp25.000          |
      #Admin edit detail kerja sama
    When admin edit detail kerja sama on Model, JP, and ADP
      | Model Kerja Sama | Tipe JP | Presentase JP | Jumlah JP | Tipe ADP | Presentase ADP | Jumlah ADP |
      | Commission Rate  | Partial | 10            | 2000000   | 6 Bulan  | 5              | 4000000    |
    Then detail kerja sama on Model, JP, and ADP should be match with data
      | Model Kerja Sama | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP | Presentase ADP | Jumlah ADP  |
      | Commission Rate  | Partial | 10%           | Rp2.000.000 | 6 Bulan  | 5%             | Rp4.000.000 |
      #set Hybrid to ON
    When admin turn on Hybrid and set mamikos precentage to "10" percent
    Then kontrak kerja sama should contains hybrid rev share
      | Pemilik DBET | Mamikos DBET |
      | 90%          | 10%          |
      #check on Detail Transfer Pendapatan
    When admin set active page to 1
    Then Model Kerja Sama and Add On are displayed in Informasi Transfer Pendapatan Properti according Detail Kerja Sama data
      | Model Kerja Sama Booking | Model Kerja Sama DBET | Add On JP  | Add On ADP  |
      | commission               | Commission Rate       | Partial JP | ADP 6 Month |
      #revert back into default setting
    And admin edit detail kerja sama on Model, JP, and ADP
      | Model Kerja Sama | Tipe JP | Presentase JP | Jumlah JP | Tipe ADP | Presentase ADP | Jumlah ADP |
      | Static Rate      | Full A  | 5             | 4000000   | None     | -              | -          |
      #revert back Hybrid to turn OFF
    When admin turn off Hybrid
    Then detail kerja sama should be match with data
      | Jenis Produk | Model Kerja Sama | Basic Commission | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP | Presentase ADP | Jumlah ADP | Pemilik Booking | Mamikos Booking | Jangka Waktu | Awal Kerja Sama | Akhir Kerja Sama | Biaya Keanggotaan |
      | Apik         | Static Rate      | 20%              | 9           | Full A  | 5%            | Rp4.000.000 | -        | -%             | -          | 75%             | 25%             | 24 Bulan     | 27 October 2024 | 26 October 2026  | Rp25.000          |
    And kontrak kerja sama should not contains hybrid rev share