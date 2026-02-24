@SS15 @contractManagement
Feature: PMS Contract Management - Ubah Phone Number

  @TEST_SS-8752 @automated @contract-management @continue
  Scenario: [Web][Ubah Phone Number][PMS - Detail Kontrak]Check Ubah button when contract status as Active
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Taman Anggur Bantul"
    And admin clicks on contract "Tenant Complementary Tiga"
    And admin clicks on view contract detail button
    Then admin can see Ubah button on penyewa section

  @TEST_SS-8787 @continue
  Scenario: [Web][Ubah Data Penyewa][Riwayat Perubahan]Check riwayat Perubaha data when admin not update data penyewa
    When admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Taman Anggur Bantul"
    And admin clicks on contract "Tenant kosong empat"
    And admin clicks on view contract detail button
    And admin clicks "Riwayat perubahan data penyewa" button on penyewa section
    Then admin can see "Data Tidak Ditemukan" on riwayat page

  @TEST_SS-8788 @continue
  Scenario: [Web][Ubah Data Penyewa][Riwayat Perubahan]Check riwayat Perubaha data when admin updated data penyewa
    When admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Taman Anggur Bantul"
    And admin clicks on contract "Tenant Complementary Tiga"
    And admin clicks on view contract detail button
    And admin clicks "Riwayat perubahan data penyewa" button on penyewa section
    Then admin can see updated text with "Rini Widyarini"
    When admin can see updated text with "QA BBM"
    Then admin can see updated text with "Nama"
    When admin can see updated text with "Tenant Complementary Tiga Kosing"
    Then admin can see updated text with "Tenant Complementary Tiga Kosong Satu"

  @TEST_SS-8789 @continue
  Scenario: [Web][Ubah Data Penyewa][Riwayat Perubahan]Check view lampiran on riwayat perubahan
    When admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Taman Anggur Bantul"
    And admin clicks on contract "Tenant Complementary Tiga"
    And admin clicks on view contract detail button
    And admin clicks "Riwayat perubahan data penyewa" button on penyewa section
    And admin click on lampiran
    Then lampiran image opened in new tab

  @TEST_SS-8751
  Scenario: [Web][Ubah Phone Number][PMS - Detail Kontrak]Check Ubah button when contract status as Terminated, Booked, Cancelled and Finished
    When admin go to pms singgahsini
    And admin go to room allotment page "Kost Singgahsini Taman Anggur Bantul"
    And admin click on previous month
    And admin clicks on contract "Tenant Dua Lima"
    And admin clicks on view contract detail button
    Then admin can see disable ubah button

    