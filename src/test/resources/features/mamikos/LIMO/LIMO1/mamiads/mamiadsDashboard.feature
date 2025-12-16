@regression @LIMO1 @mamiadsDashboard @DONEMIGRATINGTONEWBOARD
Feature: MamiAds Dashboard

  @TEST_LIMO-1346 @mamiads @mamiads-dashboard
  Scenario: Empty state if owner each filter while owner didn't have property
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0895365623388 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user can see filter iklan saya is "Semua Iklan"
    And user will see that the text "Anda Belum Punya Properti" is displayed
    And user will see that the text " Daftarkan dulu properti Anda di Mamikos untuk bisa memakai MamiAds. " is displayed
    When owner choose filter iklan saya to "Iklan Aktif"
    Then user will see that the text "Anda Belum Punya Properti" is displayed
    And user will see that the text " Daftarkan dulu properti Anda di Mamikos untuk bisa memakai MamiAds. " is displayed
    When owner choose filter iklan saya to "Iklan Nonaktif"
    Then user will see that the text "Anda Belum Punya Properti" is displayed
    And user will see that the text " Daftarkan dulu properti Anda di Mamikos untuk bisa memakai MamiAds. " is displayed

  @TEST_LIMO-1340 @LIMO1-staging
  Scenario Outline: Switch ON OFF ads while saldo burn = 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 0891202414   | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user cek status toggle iklan "<adsName>" is "<currentPosisiIklan>"
    And user verify the toggle iklan "<adsName>" is "<currentToggle>"
    And user verify the wording iklan "<adsName>" is "<currentStatusDesc>"
    And user verify the wording anggaran of iklan "<adsName>" is "<currentAnggaranDesc>"
    When user click "<currentToggle>" toggle the "<adsName>"
    Then user verify the pop up switch "<currentToggle>" toggle iklan "<adsName>" is displayed
    When user click "<actionButton>" button on pop up switch toggle iklan
#    Then user verify the toast "<messageToast>"
    And user cek status toggle iklan "<adsName>" is "<expectedPosisiIklan>"
    And user verify the toggle iklan "<adsName>" is "<expectedToggle>"
    And user verify the wording iklan "<adsName>" is "<expectedStatusDesc>"
    And user click "<currentToggle2>" toggle the "<adsName>"
    And user click "<actionButton2>" button on pop up switch toggle iklan
    Then user verify the wording anggaran of iklan "<adsName>" is "<expectedAnggaranDesc>"
    Examples:
      | adsName                                  | currentPosisiIklan | currentToggle | currentToggle2 | currentStatusDesc                                    | currentAnggaranDesc                                             |  actionButton   | actionButton2     | messageToast              | expectedPosisiIklan | expectedToggle | expectedStatusDesc                                   | expectedAnggaranDesc             |
      | Kos Matrix Keanu Makasar Jakarta Barat   | tidak-naik         | off           | on             | Klik tombol untuk naikkan iklan                      | Tipe Anggaran: Rp15.000 per-hari                                | Ya, Nonaktifkan | Aktifkan          | Iklan berhasil dinaikkan   | naik                | on             | Posisi iklan telah naik di hasil pencarian properti. | Tipe Anggaran: Rp15.000 per-hari |
      | Kos Matrix Keanu Makasar Jakarta Timur   | naik               | on            | off            | Posisi iklan telah naik di hasil pencarian properti. | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp10.000  | Aktifkan        | Ya, Nonaktifkan   | Iklan berhenti dinaikkan. | tidak-naik          | off            | Klik tombol untuk naikkan iklan                      | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp10.000 |

  @TEST_LIMO-1318 @LIMO1-staging @maDashboard @continue
  Scenario: Set full occupancy and make sure the wording if condition ON OFF
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 0891202530   | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user cek status toggle iklan "Kost Bitcoin Tipe A Kelapa Dua Tangerang" is "Naik"
    And user verify the toggle iklan "Kost Bitcoin Tipe A Kelapa Dua Tangerang" is "on"
    And user verify the wording iklan "Kost Bitcoin Tipe A Kelapa Dua Tangerang" is "Posisi iklan telah naik di hasil pencarian properti."
    When owner navigates to property saya kos
    And owner search kost "Kost Bitcoin Tipe A Kelapa Dua Tangerang" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click update kamar kost
    And user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click "Simpan"
    And user navigates to mamiads dashboard
    Then user cek status toggle iklan "Kost Bitcoin Tipe A Kelapa Dua Tangerang" is "Naik"
    And user verify the toggle iklan "Kost Bitcoin Tipe A Kelapa Dua Tangerang" is "on"
    And user verify the wording iklan kamar penuh "Kost Bitcoin Tipe A Kelapa Dua Tangerang" is "Kamar Penuh. Silahkan nonaktifkan jika tidak ingin menaikkan posisi iklan ini"

  @TEST_LIMO-3368 @continue @maDashboard
  Scenario: OFF ads full occupancy
    When user click "on" toggle the "Kost Bitcoin Tipe A Kelapa Dua Tangerang"
    And user click "Ya, Nonaktifkan" button on pop up switch toggle iklan

  @TEST_LIMO-3372 @continue @maDashboard
  Scenario: To make sure wording if ads full occupancy
    Then user verify the wording iklan kamar penuh "Kost Bitcoin Tipe A Kelapa Dua Tangerang" is "Kamar Penuh. Silahkan nonaktifkan jika tidak ingin menaikkan posisi iklan ini"

  @TEST_LIMO-3369
  Scenario: Available room in property full occupancy
    When owner navigates to property saya kos
    And owner search kost "Kost Bitcoin Tipe A Kelapa Dua Tangerang" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click update kamar kost
    And user click edit button in first row of the table
    And user tick already inhabited checkbox
    And owner click "Simpan"
    And user navigates to mamiads dashboard
    Then user verify the wording iklan "Kost Bitcoin Tipe A Kelapa Dua Tangerang" is "Klik tombol untuk naikkan iklan"
    When user click "off" toggle the "Kost Bitcoin Tipe A Kelapa Dua Tangerang"
    And user click "Aktifkan" button on pop up switch toggle iklan

  @TEST_LIMO-1343 @LIMO1-staging
  Scenario: See ads on filter nonaktif
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 085720962105 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user can see filter iklan saya is "Semua Iklan"
    And ads list rooms as expected
      | adsName                                       | posisiIklan | currentToggle | availRoom                                                                     | currentStatusDesc                                    |
      | Kos Khalif Automation                         | Tidak Naik  | off           | -                                                                             | Klik tombol untuk naikkan iklan                      |
      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara | Tidak Naik  | off           | -                                                                             | Klik tombol untuk naikkan iklan                      |
      | Kos Ayame Tipe Umo Tobelo Halmahera Utara     | Tidak Naik  | off           | -                                                                             | Klik tombol untuk naikkan iklan                      |
      | Kos Ayame Tipe Mami Tobelo Halmahera Utara    | Naik        | on            | -                                                                             | Posisi iklan telah naik di hasil pencarian properti. |
      | Raney Hambura                                 | Naik        | on            | -                                                                             | Posisi iklan telah naik di hasil pencarian properti. |
      | MamiAds Ham                                   | Naik        | on            | Kamar Penuh. Silahkan nonaktifkan jika tidak ingin menaikkan posisi iklan ini | -                                                    |
      | MamiAds Bura                                  | Kamar Penuh | -             | -                                                                             | -                                                    |
    When owner choose filter iklan saya to "Iklan Aktif"
    Then ads list rooms as expected
      | adsName                                    | posisiIklan | currentToggle | availRoom                                                                     | currentStatusDesc                                    |
      | Kos Ayame Tipe Mami Tobelo Halmahera Utara | Naik        | on            | -                                                                             | Posisi iklan telah naik di hasil pencarian properti. |
      | MamiAds Ham                                | Naik        | on            | Kamar Penuh. Silahkan nonaktifkan jika tidak ingin menaikkan posisi iklan ini | -                                                    |
      | Raney Hambura                              | Naik        | on            | -                                                                             | Posisi iklan telah naik di hasil pencarian properti. |
    When owner choose filter iklan saya to "Iklan Nonaktif"
    Then ads list rooms as expected
      | adsName                                       | posisiIklan | currentToggle | availRoom | currentStatusDesc               |
      | Kos Khalif Automation                         | Tidak Naik  | off           | -         | Klik tombol untuk naikkan iklan |
      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara | Tidak Naik  | off           | -         | Klik tombol untuk naikkan iklan |
      | Kos Ayame Tipe Umo Tobelo Halmahera Utara     | Tidak Naik  | off           | -         | Klik tombol untuk naikkan iklan |
      | MamiAds Bura                                  | Kamar Penuh | -             | -         | -                               |

  @TEST_LIMO-1345 @continue
  Scenario: [MamiAds][Naikkan iklan]: Switch ON and ubah anggaran the ads never allocate if saldo mamiads sufficient
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 085951394565 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user cek status toggle iklan "Kos Never Allocate Tobelo Halmahera Utara" is "tidak-naik"
    #MA-5766 to make sure the ads never allocate
    And user verify the toggle iklan "Kos Never Allocate Tobelo Halmahera Utara" is "off"
    And user verify the wording iklan "Kos Never Allocate Tobelo Halmahera Utara" is "Klik tombol untuk naikkan iklan"
    And user verify the wording anggaran of iklan "Kos Never Allocate Tobelo Halmahera Utara" is "Tipe Anggaran: Rp10.000 per-hari"
    When user click "off" toggle the "Kos Never Allocate Tobelo Halmahera Utara"
    Then user verify the pop up switch "off" toggle iklan "Kos Never Allocate Tobelo Halmahera Utara" is displayed
    When owner click "Batal"
    Then user cek status toggle iklan "Kos Never Allocate Tobelo Halmahera Utara" is "tidak-naik"
    And user verify the toggle iklan "Kos Never Allocate Tobelo Halmahera Utara" is "off"
    And user verify the wording iklan "Kos Never Allocate Tobelo Halmahera Utara" is "Klik tombol untuk naikkan iklan"
    And user verify the wording anggaran of iklan "Kos Never Allocate Tobelo Halmahera Utara" is "Tipe Anggaran: Rp10.000 per-hari"

  @TEST_LIMO-3367
  Scenario: To make sure redirect to form anggaran while click ubah the ads never allocate
    When user click ubah on "Kos Never Allocate Tobelo Halmahera Utara"
    And owner click "Simpan Pengaturan"
    Then user verify the toast "Tidak ada perubahan tipe anggaran"

  @TEST_LIMO-1341 @LIMO1-staging
  Scenario: To make sure wording while iklan ON toggle and already reach daily budget
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 089504220900 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user cek status toggle iklan "Kos raney chan mamitest" is "Tidak Naik"
    And user verify the toggle iklan "Kos raney chan mamitest" is "on"
    And user verify the wording iklan "Kos raney chan mamitest" is "Anggaran harian telah terpenuhi untuk hari ini dan akan naik kembali besok."

  @TEST_LIMO-1342 @LIMO1-staging @continue
  Scenario: Switch ON and ubah anggaran the ads never allocate if saldo mamiads insufficient
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 083176408323 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then verify the saldo mamiads with condition lessThan 5000
    And user check ads status:
      | ads name      | Kos Never Allocate Tipe Insufficient Tobelo Halmahera Utara |
      | text status   | tidak-naik                                                  |
      | toggle status | off                                                         |
      | status desc   | Klik tombol untuk naikkan iklan                             |
      | text anggaran | Tipe Anggaran: Rp10.000 per-hari                            |
    When user click "off" toggle the "Kos Never Allocate Tipe Insufficient Tobelo Halmahera Utara"
    Then user verify the pop up switch "off" toggle iklan "Kos Never Allocate Tobelo Halmahera Utara" is displayed
    And user will see that the text "Anda belum bisa menaikkan iklan." is displayed
    And user will see that the text "Silakan beli saldo terlebih dahulu untuk dapat menaikkan posisi iklan properti Anda." is displayed

  @TEST_LIMO-3370 @continue
  Scenario: Ubah anggaran the ads never allocate when saldo insufficient
    When user click beli saldo on popup on toggle iklan
    And user navigates to mamiads dashboard
    And user click ubah on "Kos Never Allocate Tipe Insufficient Tobelo Halmahera Utara"
    Then user will see that the text "Anda belum bisa mengubah anggaran" is displayed
    And user will see that the text "Minimum harus ada saldo 5.000 untuk mengubah anggaran. Silakan beli saldo terlebih dahulu." is displayed

  @TEST_LIMO-3371
  Scenario: Switch toggle ON, when saldo is < 5000 on property ever allocate saldo
    When user click beli saldo on popup
    And user navigates to mamiads dashboard
    Then user check ads status:
      | ads name      | Kos Raney Happyvirus Mamitest Tipe A Tobelo Halmahera Utara |
      | text status   | tidak-naik                                                  |
      | toggle status | off                                                         |
      | status desc   | Klik tombol untuk naikkan iklan                             |
      | text anggaran | Tipe Anggaran: Saldo Maksimal                               |
    When user click "off" toggle the "Kos Raney Happyvirus Mamitest Tipe A Tobelo Halmahera Utara"
    Then user will see that the text "Anda belum bisa menaikkan iklan." is displayed
    And user will see that the text "Silakan beli saldo terlebih dahulu untuk dapat menaikkan posisi iklan properti Anda." is displayed

  @TEST_LIMO-1344 @LIMO1-staging @TEST_LIMO-245
  Scenario: Owner want to see Semua Iklan and saldo mamiads insufficient
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 083176950241 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And owner clicks on coba sekarang button
    Then user can see filter iklan saya is "Semua Iklan"
    And ads list rooms as expected
      | adsName                                      | posisiIklan | currentToggle | currentStatusDesc                                 | currentStatusSaldo                                             |
      | Kos Caye Raney Tipe A Tobelo Halmahera Utara | Tidak Naik  | off           | Saldo MamiAds tidak mencukupi. Silahkan beli lagi | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp10.000 |
      | Kos Caye Raney Tipe B Tobelo Halmahera Utara | Tidak Naik  | off           | Saldo MamiAds tidak mencukupi. Silahkan beli lagi | Tipe Anggaran: Saldo Maksimal                                  |
      | Kos Caye Raney Tipe C Tobelo Halmahera Utara | Tidak Naik  | off           | Saldo MamiAds tidak mencukupi. Silahkan beli lagi | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp30.000 |
      | Kos Caye Raney Tipe E Tobelo Halmahera Utara | Kamar Penuh | -             | -                                                 | -                                                              |
    When owner choose filter iklan saya to "Iklan Aktif"
    Then user will see that the text "Anda Belum Beriklan" is displayed
    And user will see that the text " Pasang anggaran dan naikkan iklan properti untuk menjangkau lebih banyak penyewa. " is displayed