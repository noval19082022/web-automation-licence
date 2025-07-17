@COOP3
Feature: SinggahSini Survei Tracker Main Page


  @SS-4240 @Automated @web @continue
  Scenario: Pagination Functionality
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to survey tracker menu
    Then user see pagination menu on Detail Tenant is displayed
    When user click pagination number "2"
    Then user see display data row survei tracker from 20 riwayat

  @continue
  Scenario: Main Page Display
    When admin go to survey tracker menu
    Then user see at Tenant Main Page Column contains
      | Head Table         |
      | Survey ID          |
      | Profil Pencari Kos |
      | Nama Properti      |
      | Waktu Survei       |
      | Platform           |
      | Status             |
      | Update Terakhir    |
      | Update Oleh        |
      | Action             |

  @continue
  Scenario: Filter By Nama Pencari Kos
    When user choose "Nama Pencari Kos" and input "Adisinggahsini" in the search field on main page
    And user click search button on main page filter
    Then user verify nama penyewa on main page filter is "Adisinggahsini"

  @continue
  Scenario: Filter By No. HP Pencari Kos
    When user choose "No. HP Pencari Kos" and input "0890867321213" in the search field on main page
    And user click search button on main page filter
    Then user verify nama penyewa on main page filter is "Adisinggahsini"

  @continue
  Scenario: Filter By Nama Properti
    When user choose "Nama Properti" and input "Kost Adi Auto SinggahSini Tobelo Halmahera Utara" in the search field on main page
    And user click search button on main page filter
    Then user verify nama penyewa on main page filter is "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"

  Scenario: Filter by Status Tidak Ada Konfirmasi
    When user click reset button in PMS Admin
    And user choose "Form Aplikasi" on filter Platform and "Tidak Ada Konfirmasi" on filter status
    And user click on terapkan button
    And user click search button on main page filter
    Then user verify search result on main page bse contains "Tidak Ada Konfirmasi"
		
