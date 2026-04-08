@owner @sidebar @functional @LIMO3
Feature: Owner Dashboard Sidebar Navigation

  @continue
  Scenario: Owner login and dismiss popup
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 082233545517  | 082233545517  | qwerty123 |
    When owner dismiss pop-up if appears
    Then owner should see dashboard homepage

  @continue
  Scenario: Navigate to Laporan Statistik
    When owner clicks "Laporan Statistik" in sidebar
    Then owner should see "Laporan Statistik" page

  @continue
  Scenario: Navigate to Akun
    When owner clicks "Akun" in sidebar
    Then owner should see "Akun" page

  @continue
  Scenario: Navigate to Properti Saya - Kos
    When owner navigates to owner dashboard
    When owner clicks "Properti Saya" in sidebar
    When owner clicks "Kos" in submenu
    Then owner should see "Kos" page

  @continue
  Scenario: Navigate to Properti Saya - Apartemen
    When owner clicks "Apartemen" in submenu
    Then owner should see "Apartemen" page

  @continue
  Scenario: Navigate to Fitur Promosi - Cek Properti Sekitar
    When owner navigates to owner dashboard
    When owner clicks "Fitur Promosi" in sidebar
    When owner clicks "Cek Properti Sekitar" in submenu
    Then owner should see "Cek Properti Sekitar" page

  @continue
  Scenario: Navigate to Fitur Promosi - Broadcast Chat
    When owner clicks "Broadcast Chat" in submenu
    Then owner should see "Broadcast Chat" page

  @continue
  Scenario: Navigate to Fitur Promosi - Promo Iklan
    When owner dismiss pop-up if appears
    When owner clicks "Promo Iklan" in submenu
    Then owner should see "Promo Iklan" page

  @continue
  Scenario: Navigate to Cek Peminat - Pengunjung Iklan
    When owner navigates to owner dashboard
    When owner clicks "Cek Peminat" in sidebar
    When owner clicks "Pengunjung Iklan" in submenu
    Then owner should see "Pengunjung Iklan" page

  @continue
  Scenario: Navigate to Cek Peminat - Pengajuan Survei
    When owner clicks "Pengajuan Survei" in submenu
    Then owner should see "Pengajuan Survei" page

  @continue
  Scenario: Navigate to Cek Peminat - Daftar Tunggu
    When owner navigates to owner dashboard
    When owner clicks "Cek Peminat" in sidebar
    When owner clicks "Daftar Tunggu" in submenu
    Then owner should see "Daftar Tunggu" page

  @continue
  Scenario: Navigate to Manajemen Kos - Ketersediaan Kamar
    When owner navigates to owner dashboard
    When owner clicks "Manajemen Kos" in sidebar
    When owner clicks "Ketersediaan Kamar" in submenu
    Then owner should see "Ketersediaan Kamar" page

  @continue
  Scenario: Navigate to Manajemen Kos - Pengajuan Sewa
    When owner clicks "Pengajuan Sewa" in submenu
    Then owner should see "Pengajuan Sewa" page

  @continue
  Scenario: Navigate to Manajemen Kos - Peraturan Sewa
    When owner clicks "Peraturan Sewa" in submenu
    Then owner should see "Peraturan Sewa" page

  @continue
  Scenario: Navigate to Manajemen Kos - Tagihan Penyewa
    When owner clicks "Tagihan Penyewa" in submenu
    Then owner should see "Tagihan Penyewa" page

  @continue
  Scenario: Navigate to Manajemen Kos - Laporan Keuangan
    When owner clicks "Laporan Keuangan" in submenu
    Then owner should see "Laporan Keuangan" page

  @continue
  Scenario: Navigate to Manajemen Kos - Kontrak Penyewa
    When owner clicks "Kontrak Penyewa" in submenu
    Then owner should see "Kontrak Penyewa" page

  Scenario: Navigate to Manajemen Kos - Penilaian Kos
    When owner clicks "Penilaian Kos" in submenu
    Then owner should see "Penilaian Kos" page

  # Test scenarios for different owner states
  # Owner 0895365623388: NO Kos + NO Apartments + NO MamiAds
  @continue
  Scenario: Owner without any properties navigates to Kos submenu
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0895365623388 | 0          | qwerty123 |
    When owner dismiss pop-up if appears
    Then owner should see dashboard homepage
    When owner clicks "Properti Saya" in sidebar
    When owner clicks "Kos" in submenu
    Then owner should see "Kos" page

  @continue
  Scenario: Owner without any properties navigates to Apartemen submenu
    When owner navigates to owner dashboard
    When owner clicks "Properti Saya" in sidebar
    When owner clicks "Apartemen" in submenu
    Then owner should see "Apartemen" page

  Scenario: Owner without any properties navigates to Promo Iklan
    When owner navigates to owner dashboard
    When owner clicks "Fitur Promosi" in sidebar
    When owner clicks "Promo Iklan" in submenu
    Then owner should see "Promo Iklan" page

  # Owner 08111000222: Has Kos + NO Apartments + NO MamiAds
  @continue
  Scenario: Owner without apartments navigates to Apartemen submenu
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 08111000222  | 08111000222  | qwerty123 |
    When owner dismiss pop-up if appears
    Then owner should see dashboard homepage
    When owner clicks "Properti Saya" in sidebar
    When owner clicks "Apartemen" in submenu
    Then owner should see "Apartemen no properties" page

  Scenario: Owner without MamiAds navigates to Promo Iklan
    When owner navigates to owner dashboard
    When owner clicks "Fitur Promosi" in sidebar
    When owner clicks "Promo Iklan" in submenu
    Then owner should see "Promo Iklan" page

  # Owner 08123450977: Has Kos + MamiAds + NO Apartments
  Scenario: Owner with MamiAds navigates to Promo Iklan
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 08123450977  | 08123450977  | qwerty123 |
    When owner dismiss pop-up if appears
    When owner clicks "Fitur Promosi" in sidebar
    When owner dismiss pop-up if appears
    When owner clicks "Promo Iklan" in submenu
    Then owner should see "Promo Iklan" page