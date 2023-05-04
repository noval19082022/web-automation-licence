@regression @pman @pms @owner-expenditure

Feature: Add Owner Expenditure
  Background: Open Other Transaction Menu
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to other transation menu

  @TEST_PMAN-6038 @test
  Scenario: Add valid owner expenditure
    When admin add new owner expenditure "Reimbursement" in property "Khusus Automation"
    And admin add multiple biaya pengeluaran :
      | no  | Kategori Pengeluaran        | Nama Pengeluaran  | Kuantitas | Nominal Pengeluaran | Status Persediaan | Jenis Produk  |
      | 1   | Administrasi & Iuran Kos    | Wifi              | 1         | 50000               | Non Stock         | LSSS          |
      | 2   | Amenities Penyewa           | Sabun Mandi       | 1         | 20000               | Stock             | LSAP          |
      | 3   | Bahan Pembersih Kos & Dapur | Wipol             | 1         | 20000               | Stock             | PC            |
    And admin upload valid attachment