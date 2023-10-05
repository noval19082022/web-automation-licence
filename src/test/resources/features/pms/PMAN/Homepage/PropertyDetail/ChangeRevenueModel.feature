@pman @pms @disbursement @changeRevenueModel

Feature: PMS Change Revenue Model in Informasi Transfer Pendapatan Properti

  @TEST_PMAN-5505
  Scenario: Change revenue model
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to Disbursement menu
    And admin go to detail transfer "Khusus Automation"
#    And admin open new tab on Riwayat Transfer Pendapatan
    And admin open new page
    And admin navigates to Kontrak Kerja Sama
#    And admin go to Kontrak Kerja Sama tab
    Then detail kerja sama should be match with data
      | Jenis Produk  | Model Kerja Sama  | Basic Commission  | Total Kamar | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP  | Presentase ADP  | Jumlah ADP  | Pemilik Booking | Mamikos Booking | Jangka Waktu  | Awal Kerja Sama | Akhir Kerja Sama  | Biaya Keanggotaan |
      | Apik          | Static Rate       | 20%               | 9           | Full A  | 5%            | Rp4.000.000 | -         | -               | -           | 75%             | 25%             | 24 Bulan      | 1 November 2021 | 31 October 2023   | Rp25.000          |
    #Admin edit detail kerja sama
    When admin edit detail kerja sama on Model, JP, and ADP
      | Model Kerja Sama  | Tipe JP | Presentase JP | Jumlah JP | Tipe ADP  | Presentase ADP  | Jumlah ADP  |
      | Commission Rate   | Partial | 10            | 2000000   | 6 Bulan   | 5               | 4000000     |
    Then detail kerja sama on Model, JP, and ADP should be match with data
      | Model Kerja Sama  | Tipe JP | Presentase JP | Jumlah JP   | Tipe ADP  | Presentase ADP  | Jumlah ADP  |
      | Commission Rate   | Partial | 10%           | Rp2.000.000 | 6 Bulan   | 5%              | Rp4.000.000 |
      #set Hybrid to ON
    When admin turn on Hybrid and set mamikos precentage to "10" percent
    Then kontrak kerja sama should contains hybrid rev share
      | Pemilik DBET  | Mamikos DBET  |
      | 90%           | 10%           |
    When admin set active page to 1
    And admin clicks Refresh Halaman ini
#    And admin go to detail property "Khusus Automation"

#  When user clicks disbursement menu on PMS navbar
#  And user search disbursement property using name "PMAN"
#  Then search result should match with profile "PMAN"
#  When user click disbursement action button "Lihat Detail"
#  And user redirect to Detail Transfer Pendapatan for "PMAN"
#  When user open new tab on Riwayat Transfer Pendapatan
#  And user click property detail tab "Kontrak Kerja Sama"
#  And user scroll to detail kerja sama section
      #change the revenue model, JP, ADP and set ON hybrid
#  And user click ubah on detail kerja sama section
#  When user change Model Kerja Sama "<model kerja sama>"
#  And user change Tipe Add On JP "<add on jp>"
#  And user change Persentase Add On JP "<jp %>"
#  And user change Jumlah Add On JP "<jp amount>"
#  And user change Tipe Add On ADP "<add on adp>"
#  And user change Persentase Add On ADP "<adp %>"
#  And user change Jumlah Add On ADP "<adp amount>"
#  And user change details on Model kerja sama hybrid using detail "PMAN Hybrid on"
#      #check the revenue model, JP, ADP label on the first window
#  And user switch to 1 window
#  And user click Refresh Halaman ini
#  Then user will see Model Kerja Sama Booking "<expect MKS booking>" in Informasi Transfer Pendapatan Properti
#  And user will see Model Kerja Sama DBET "<expect MKS dbet>" in Informasi Transfer Pendapatan Properti
#  And user will see Add On JP "<expect AO jp>" in Informasi Transfer Pendapatan Properti
#  And user will see Add On ADP "<expect AO adp>" in Informasi Transfer Pendapatan Properti
#      #revert back into default setting
#  When user switch to 2 window
#  And user click ubah on detail kerja sama section
#  And user change the revenue model, jp type, adp type into default setting
#  And user change details on Model kerja sama hybrid using detail "PMAN Hybrid off"
#
#  Examples:
#  | model kerja sama  | add on jp | jp % | jp amount | add on adp  | adp %  | adp amount  | expect MKS booking | expect MKS dbet  | expect AO jp | expect AO adp  |
#  | Commission        | None      | -    | -         | None        | -      | -           | Commission Rate    | Commission Rate  | No JP        | No ADP         |
#  | Static            | None      | -    | -         | None        | -      | -           | Static Rate        | Commission Rate  | No JP        | No ADP         |
#  | Commission        | Full A    | 10   | 3000000   | 3 Bulan     | 15     | 3500000     | Commission Rate    | Commission Rate  | Full JP A    | ADP 3 Month    |
#  | Static            | Full B    | 10   | 3000000   | 3 Bulan     | 15     | 3500000     | Static Rate        | Commission Rate  | Full JP B    | ADP 3 Month    |
#  | Commission        | Partial   | 10   | 3000000   | 6 Bulan     | 15     | 3500000     | Commission Rate    | Commission Rate  | Partial JP   | ADP 6 Month    |