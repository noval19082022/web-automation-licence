@BBM6 @ubahPeraturan
  Feature: Owner - Ubah Peraturan

  @TEST_COOP-1913 @automated @booking-stay-setting @continue
  Scenario: Dashboard[Pengajuan Booking][Ubah peraturan masuk kos]check button name on dashboard and pengajuan booking page (BBM-536)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    |  phone prod   | password    |
      | 0890000000289  | 082291900002  | Bismillah@01   |
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    When owner click on pengajuan sewa
    And owner click ubah peraturan at "pengajuan sewa"
    Then owner redirect to Peraturan Masuk Kos page

  @TEST_COOP-1908 @automated @booking-stay-setting @continue
  Scenario: Ubah peraturan masuk kos [Filter] Change kos setting on kost GP type (BBM-526)
    When owner back to owner dashboard
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    And owner select kost "Kost Norway Tobelo Utara Halmahera Utara"
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Untuk mengubah aturan, mohon hubungi tim Mamikos yang mengelola kos Anda."

  @TEST_COOP-1915 @automated @booking-and-billing @booking-stay-setting @continue
  Scenario: Atur Booking [Kost Detail][Booking section] Change booking terdekat = 2 Minggu and Booking waktu terjauh 2 bulan (BBM-541)
    When owner back to owner dashboard
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    And owner select kost "kost flores Tobelo Utara Halmahera Utara"
    And owner clicks on ubah waktu button
    And owner choose minim checkin time with :
      | waktu | tanggal |
      | Minggu | 2 |
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"
    And owner clicks on ubah waktu button
    And owner activated toogle checkin button
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_COOP-1897 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
    Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa] Activated Boleh Bawa Anak (COOP-1897)
    When owner back to owner dashboard
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    And owner select kost "kost semarang promo ngebut Abepura Jayapura"
    And owner click on kriteria calon penyewa button
    And owner click kriteria penyewa with "Boleh bawa anak"
    And owner click Simpan at Peraturan Masuk Kos page
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                    | kost name prod                                            |
      | kost semarang promo ngebut Abepura Jayapura       | Kost Irvi Automation Add Ons Tobelo Barat Halmahera Utara |
    Then tenant can see peraturan kost with "Boleh bawa anak"
    When owner navigates to owner dashboard
    And owner click ubah peraturan at "dashboard"
    And owner select kost "kost semarang promo ngebut Abepura Jayapura"
    And owner click on kriteria calon penyewa button
    And owner uncheck toogle "Boleh bawa anak"
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_COOP-1896 @automated @booking-and-billing @booking-stay-setting @web @xray-update
    Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa]Activated Wajib Buku Nikah (COOP-1896)
    When owner back to owner dashboard
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    And owner select kost "kost semarang promo ngebut Abepura Jayapura"
    And owner click on kriteria calon penyewa button
    And owner click kriteria penyewa with "Wajib sertakan buku nikah saat pengajuan sewa"
    Then owner can see "kamar hanya bagi penyewa" will disable
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"
    And owner click on kriteria calon penyewa button
    And owner uncheck toogle "Boleh untuk pasutri"
    Then owner click Simpan at Peraturan Masuk Kos page