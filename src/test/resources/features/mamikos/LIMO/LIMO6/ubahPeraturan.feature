@ubahPeraturan @LIMO6
Feature: Owner - Ubah Peraturan

  @TEST_SS-3458 @automated @booking-stay-setting @continue
  Scenario: Dashboard[Pengajuan Booking][Ubah peraturan masuk kos]check button name on dashboard and pengajuan booking page (BBM-536)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod   | password     |
      | 0890000000289 | 082291900002 | Bismillah@01 |
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    When owner click on pengajuan sewa
    And owner click ubah peraturan at "pengajuan sewa"
    Then owner redirect to Peraturan Masuk Kos page

  @TEST_SS-3453 @automated @booking-stay-setting @continue
  Scenario: Ubah peraturan masuk kos [Filter] Change kos setting on kost GP type (BBM-526)
    When owner back to owner dashboard
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    And owner select kost "Kost Norway Tobelo Utara Halmahera Utara"
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Untuk mengubah aturan, mohon hubungi tim Mamikos yang mengelola kos Anda."

  @TEST_SS-3460 @automated @booking-and-billing @booking-stay-setting
  Scenario: Atur Booking [Kost Detail][Booking section] Change booking terdekat = 2 Minggu and Booking waktu terjauh 2 bulan (BBM-541)
    When owner back to owner dashboard
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    And owner select kost "kost flores Tobelo Utara Halmahera Utara"
    And owner clicks on ubah waktu button
    And owner choose minim checkin time with :
      | waktu  | tanggal |
      | Minggu | 2       |
    And owner click Simpan at Peraturan Masuk Kos Pop-up page
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"
#    And owner clicks on ubah waktu button
#    And owner activated toogle checkin button
#    And owner click Simpan at Peraturan Masuk Kos Pop-up page
#    And owner click Simpan at Peraturan Masuk Kos page
#    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_SS-3442 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
  Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa] Activated Boleh Bawa Anak (COOP-1897)
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod   | password     |
      | 0890000000289 | 082291900002 | Bismillah@01 |
    When owner back to owner dashboard
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    And owner select kost "Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara"
    And owner click on kriteria calon penyewa button
    And owner click kriteria penyewa with "Boleh bawa anak"
    And owner click Simpan at Peraturan Masuk Kos page
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                                      | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-madiun-buat-draft-homepage-tobelo-utara-halmahera-utara-1 | Kos DC BAR Automation Tipe A |
    Then tenant can see peraturan kost with "Boleh bawa anak"
    When owner navigates to owner dashboard
    And owner click ubah peraturan at "dashboard"
    And owner select kost "Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara"
    And owner click on kriteria calon penyewa button
    And owner uncheck toogle "Boleh bawa anak"
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_SS-3441 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
  Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa]Activated Wajib Buku Nikah (COOP-1896)
    When owner back to owner dashboard
    And owner click ubah peraturan at "dashboard"
    Then owner redirect to Peraturan Masuk Kos page
    And owner select kost "Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara"
    And owner click on kriteria calon penyewa button
    And owner click kriteria penyewa with "Wajib sertakan buku nikah saat pengajuan sewa"
    Then owner can see "kamar hanya bagi penyewa" will disable
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_SS-3444 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
  Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa] Nonactived Buku Nikah (BBM-525)
    When owner click on kriteria calon penyewa button
    And owner uncheck toogle "Wajib sertakan buku nikah saat pengajuan sewa"
    And owner click Simpan at Peraturan Masuk Kos page
    And owner click on kriteria calon penyewa button
    And owner uncheck toogle "Boleh untuk pasutri"
    Then owner can see "kamar hanya bagi penyewa" will enable
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_SS-3445 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
  Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa]Activated KK (BBM-527)
    When owner click on kriteria calon penyewa button
    And owner click kriteria penyewa with "Wajib sertakan kartu keluarga saat pengajuan sewa"
    Then owner can see "kamar hanya bagi penyewa" will disable
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_SS-3440 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
  Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa]Activated Ktp KK And Buku Nikah
    When owner click on kriteria calon penyewa button
    And owner click kriteria penyewa with "Wajib sertakan KTP saat pengajuan sewa"
    And owner click kriteria penyewa with "Wajib sertakan kartu keluarga saat pengajuan sewa"
    And owner click kriteria penyewa with "Wajib sertakan buku nikah saat pengajuan sewa"
    Then owner can see "kamar hanya bagi penyewa" will disable
    When owner can see "Maks. 2 orang/kamar" will disable
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_SS-3451 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
  Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa]Nonactivated Ktp KK And Buku Nikah (BBM-523)
    When owner click on kriteria calon penyewa button
    And owner uncheck toogle "Wajib sertakan KTP saat pengajuan sewa"
    And owner uncheck toogle "Wajib sertakan kartu keluarga saat pengajuan sewa"
    And owner uncheck toogle "Wajib sertakan buku nikah saat pengajuan sewa"
    Then owner can see "kamar hanya bagi penyewa" will enable
    When owner can see "Maks. 2 orang/kamar" will enable
    And owner uncheck toogle "Boleh untuk pasutri"
    And owner uncheck toogle "Boleh bawa anak"
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_SS-3456 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
  Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa]Owner set kriteria to able for Boleh pasutri (BBM-534)
    When owner click on kriteria calon penyewa button
    And owner click kriteria penyewa with "Boleh untuk pasutri"
    And owner click Simpan at Peraturan Masuk Kos page
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                                      | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-madiun-buat-draft-homepage-tobelo-utara-halmahera-utara-1 | Kos DC BAR Automation Tipe A |
    Then tenant can see peraturan kost with "Boleh pasutri"

  @TEST_SS-3454 @TEST_SS-3446 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
  Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa] Nonactivated Pasutri (BBM-531)
    When owner navigates to owner dashboard
    And owner click ubah peraturan at "dashboard"
    And owner select kost "Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara"
    And owner click on kriteria calon penyewa button
    And owner uncheck toogle "Boleh untuk pasutri"
    Then owner can see "kamar hanya bagi penyewa" will enable
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"

  @TEST_SS-3452 @TEST_SS-3455 @automated @booking-and-billing @booking-stay-setting @web @xray-update @continue
  Scenario: [Ubah peraturan masuk kos][Kriteria calon penyewa]Activated Special Kos for Karyawan (BBM-524) (BBM-533)
    When owner click on kriteria calon penyewa button
    And owner click kriteria penyewa with "Kos dikhususkan untuk karyawan atau mahasiswa"
    And owner click kriteria kos khusus with "Khusus mahasiswa"
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                                      | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-madiun-buat-draft-homepage-tobelo-utara-halmahera-utara-1 | Kos DC BAR Automation Tipe A |
    Then tenant can see peraturan kost with "Khusus Mahasiswa"
    When owner navigates to owner dashboard
    And owner click ubah peraturan at "dashboard"
    And owner select kost "Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara"
    And owner click on kriteria calon penyewa button
    And owner click kriteria penyewa with "Kos dikhususkan untuk karyawan atau mahasiswa"
#    activated kost khusus  karyawan @TEST_COOP-1910
    And owner click kriteria kos khusus with "Khusus karyawan"
    And owner click Simpan at Peraturan Masuk Kos page
    Then owner will see toast "Peraturan terbaru berhasil disimpan"
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                                      | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-eksklusif-kost-madiun-buat-draft-homepage-tobelo-utara-halmahera-utara-1 | Kos DC BAR Automation Tipe A |
    Then tenant can see peraturan kost with "Khusus karyawan"
    When owner navigates to owner dashboard
    And owner click ubah peraturan at "dashboard"
    And owner select kost "Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara"
    And owner click on kriteria calon penyewa button
    And owner uncheck toogle "Kos dikhususkan untuk karyawan atau mahasiswa"
    Then owner click Simpan at Peraturan Masuk Kos page

  @TEST_SS-4929 @booking-stay-setting @web
  Scenario: [Web][UX Improvement][Booking stay setting][waktu ngekos]Update wording on Booking stay setting
    When owner navigates to owner dashboard
    And owner click ubah peraturan at "dashboard"
    And owner select kost "Kost Madiun Buat Draft Homepage Tobelo Utara Halmahera Utara"
    Then owner can see "Anda bisa membuat ketentuan dan syarat untuk calon penyewa." on ubah peraturan
    And owner clicks on ubah waktu button
    Then owner can see "Jarak waktu terdekat (pengajuan dan tanggal masuk kos)" on ubah peraturan

  @TEST_SS-3334
  Scenario: Check the earliest availability kost if the earliest available room to sell is today and BSS Waktu masuk kos terdekat setelah booking is 0 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner clicks on ubah waktu button
    And owner click on toggle pengajuan dan waktu masuk kos
    And user click on "Simpan" button
    And user click on "Simpan" button
    Then owner can see make rules booking page
    And owner logs out

 # Scenario: Cancel Booking if Tenant Have Booking
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0890000000131 | 0890000000131 | qwerty123 |
    And user cancel booking

  #Scenario: tenant booking today
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                 | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-murah-kost-mars-september-rajeg-tangerang | Kos DC BAR Automation Tipe A |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_COOP-813
  Scenario: BSS Waktu masuk kos terdekat setelah booking is 8 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner clicks on ubah waktu button
    And owner click on toggle pengajuan dan waktu masuk kos if active
    And owner click on dropdown waktu masuk kos
    And user click on "8" button
    And owner click on simpan button on popup total day
    And user click on "Simpan" button
    And user click on "Simpan" button
    Then owner can see make rules booking page
    And owner logs out

 # Scenario: Cancel Booking if Tenant Have Booking
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0890000000131 | 0890000000131 | qwerty123 |
    And user cancel booking

  #Scenario: tenant booking today
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                            | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-murah-kost-seribu-pintu-pasar-kemis-tangerang-2 | Kos DC BAR Automation Tipe A |
    Then tenant see today's date and cannot make booking

  @TEST_SS-3337
  Scenario: Check the latest availability kos if BSS Waktu masuk kos terjauh setelah booking is 3 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner select kost "Kost Seribu Pintu Pasar Kemis Tangerang"
    And owner clicks on ubah waktu button
    And owner click on toggle pengajuan dan waktu masuk kos if active
    And owner choose minim checkin time with :
      | waktu | tanggal |
      | Hari  | 3       |
    Then owner can see make rules booking page
    And owner logs out

 # Scenario: Cancel Booking if Tenant Have Booking
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0890000000131 | 0890000000131 | qwerty123 |
    And user cancel booking

  #Scenario: tenant booking today
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                            | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-murah-kost-seribu-pintu-pasar-kemis-tangerang-2 | Kos DC BAR Automation Tipe A |
    Then tenant see today's date and cannot make booking

  @TEST_SS-3336
  Scenario: Check the latest availability kos if BSS Waktu masuk kos terjauh setelah booking is 3 weeks
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner select kost "Kost Seribu Pintu Pasar Kemis Tangerang"
    And owner clicks on ubah waktu button
    And owner click on toggle pengajuan dan waktu masuk kos if active
    And owner choose minim checkin time with :
      | waktu  | tanggal |
      | Minggu | 3       |
    Then owner can see make rules booking page
    And owner logs out

 # Scenario: Cancel Booking if Tenant Have Booking
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0890000000131 | 0890000000131 | qwerty123 |
    And user cancel booking

  #Scenario: tenant booking today
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                            | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-murah-kost-seribu-pintu-pasar-kemis-tangerang-2 | Kos DC BAR Automation Tipe A |
    Then tenant can choose checkin date in the next "1" week

  @TEST_COOP-916
  Scenario: Check the latest availability kos if BSS Waktu masuk kos terjauh setelah booking is 5 month
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner select kost "Kost Seribu Pintu Pasar Kemis Tangerang"
    And owner clicks on ubah waktu button
    And owner click on toogle today
    And owner click on dropdown satuan waktu jarak waktu terjauh
    And user click on "Bulan" button
    And owner click on simpan button on popup satuan waktu
    And owner click on dropdown jumlah jarak waktu terjauh
    And owner click on tanggal "5"
    And owner click on simpan button on popup total day
    And user click on "Simpan" button
    And user click on "Simpan" button
    Then owner can see make rules booking page
    And owner logs out

 # Scenario: Cancel Booking if Tenant Have Booking
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0890000000131 | 0890000000131 | qwerty123 |
    And user cancel booking

  #Scenario: tenant booking today
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                            | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-murah-kost-seribu-pintu-pasar-kemis-tangerang-2 | Kos DC BAR Automation Tipe A |
    Then tenant can choose checkin date in the next "4" month