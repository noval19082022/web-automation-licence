@regression @LIMO1 @ubahAnggaran
Feature: Ubah Anggaran

  @TEST_LIMO-1354
  Scenario: Ubah Anggaran - Saldo 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0826666666633 | 0826666666633 | qwerty123 |
   # And user click on Saldo MamiAds at owner dashboard
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user click "ubah"
    Then user will see that the text "Anda belum bisa mengubah anggaran" is displayed
    And user will see that the text "Minimum harus ada saldo 5.000 untuk mengubah anggaran. Silakan beli saldo terlebih dahulu." is displayed

  @TEST_LIMO-1346
  Scenario: Ubah Anggaran - Update Batasan to Less Than Min-Max Amount
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408449 | 083176408449 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user click ubah on "Kos Ranise Mamitest Tobelo Halmahera Utara"
    And user set anggaran harian to "4999"
    Then user will see that the text "Mohon masukkan minimum Rp5.000" is displayed
    When user set anggaran harian to "10000001"
    Then user will see that the text "Maksimum Rp10.000.000" is displayed

  @TEST_LIMO-1352 @continue
  Scenario: Ubah Anggaran - Change saldo Maksimal to saldo Maksimal, Iklan its Naik & toggle ON Saldo burning = 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089504220900 | 089504220900 | qwerty123 |
    And owner click "Nanti Saja"
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    Then user check ads status:
      | ads name      | kost rane hana Mamitest                              |
      | text status   | Naik                                                 |
      | toggle status | on                                                   |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti. |
      | text anggaran | Hari ini terpakai Rp0                                |
    When user click ubah on "kost rane hana Mamitest"
    And owner click Simpan Pengaturan on ubah anggaran
    Then user verify the toast "Tidak ada perubahan tipe anggaran"

  @TEST_LIMO-3385 @continue @web @automated
  Scenario: To make sure wording while iklan Off by owner when set maximal budget and saldo burn = 0
    When user check ads status:
      | ads name      | Kos rane net Mamitest           |
      | text status   | Tidak Naik                      |
      | toggle status | off                             |
      | status desc   | Klik tombol untuk naikkan iklan |
      | text anggaran | Tipe Anggaran: Saldo Maksimal   |
    And user click ubah on "Kos rane net Mamitest"
    And owner click Simpan Pengaturan on ubah anggaran

  @TEST_LIMO-3380 @continue @web @automated
  Scenario: Change daily budged to daily budged, Iklan its Naik & toggle ON saldo burning = 0
    When user check ads status:
      | ads name      | kost rane dul Mamitest                                         |
      | text status   | Naik                                                           |
      | toggle status | on                                                             |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.           |
      | text anggaran | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp20.000 |
    And user click ubah on "kost rane dul Mamitest"
    And owner click Simpan Pengaturan on ubah anggaran

  @TEST_LIMO-3387 @web @automated
  Scenario: To make sure wording while iklan Off by owner when set daily budget and saldo burn = 0
    When user check ads status:
      | ads name      | Kos rane set Mamitest            |
      | text status   | Tidak Naik                       |
      | toggle status | off                              |
      | status desc   | Klik tombol untuk naikkan iklan  |
      | text anggaran | Tipe Anggaran: Rp70.000 per-hari |
    And user click ubah on "Kos rane set Mamitest"
    And owner click Simpan Pengaturan on ubah anggaran

  @TEST_LIMO-1353 @continue
  Scenario: Hit Daily Budget is 0, Toggle ON and status Naik, Change to daily budged
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 085720962105 | 085720962105 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    Then user check ads status:
      | ads name      | Raney Hambura                                                  |
      | text status   | Naik                                                           |
      | toggle status | on                                                             |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.           |
      | text anggaran | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp10.000 |
    When user click ubah on "Raney Hambura"
    And user set anggaran harian to "5000"
    And owner click Simpan Pengaturan on ubah anggaran
    And user click Ya,Ganti button
    And user check ads status:
      | ads name      | Raney Hambura                                                 |
      | text status   | Naik                                                          |
      | toggle status | on                                                            |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.          |
      | text anggaran | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp5.000 |

  @TEST_LIMO-3381 @web @automated @continue
  Scenario: Hit Daily Budget is 0, Toggle ON and status Naik, Change Daily Budget to Saldo Maksimal
    And user click ubah on "Raney Hambura"
    And user set anggaran to saldo maksimal
    And owner click Simpan Pengaturan on ubah anggaran
    And user click Ya,Ganti button
    Then user verify the toast "Anggaran berhasil diubah"
    And user check ads status:
      | ads name      | Raney Hambura                                        |
      | text status   | Naik                                                 |
      | toggle status | on                                                   |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti. |
      | text anggaran | Hari ini terpakai Rp0                                |

  @TEST_LIMO-3383 @web @automated
  Scenario: Hit Maksimal Budget is 0, Toggle ON status Naik, Change Saldo Maksimal to Daily Budget
    And user click ubah on "Raney Hambura"
    And user set anggaran to dibatasi harian
    And owner click Simpan Pengaturan on ubah anggaran
    And user click Ya,Ganti button
    And user check ads status:
      | ads name      | Raney Hambura                                                  |
      | text status   | Naik                                                           |
      | toggle status | on                                                             |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.           |
      | text anggaran | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp10.000 |

  @TEST_LIMO-1351 @continue
  Scenario: Hit Daily Budget is 0, Toggle OFF and status Tidak Naik, Change Daily Budget to Saldo Maksimal
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 085720962105 | 085720962105 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    Then user check ads status:
      | ads name      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara |
      | text status   | Tidak Naik                                    |
      | toggle status | off                                           |
      | status desc   | Klik tombol untuk naikkan iklan               |
      | text anggaran | Tipe Anggaran: Rp19.000 per-hari              |
    When user click ubah on "Kos Ayame Tipe MamiAds Tobelo Halmahera Utara"
    And user set anggaran to saldo maksimal
    And owner click Simpan Pengaturan on ubah anggaran
    And user click Ya,Ganti button
    And user check ads status:
      | ads name      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara |
      | text status   | Tidak Naik                                    |
      | toggle status | off                                           |
      | status desc   | Klik tombol untuk naikkan iklan               |
      | text anggaran | Tipe Anggaran: Saldo Maksimal                 |

  @TEST_LIMO-3382 @web @automated @continue
  Scenario: Hit Maksimal Budget is 0, Toggle OFF status Tidak Naik, Change Saldo Maksimal to Daily Budget
    And user click ubah on "Kos Ayame Tipe MamiAds Tobelo Halmahera Utara"
    And user set anggaran to dibatasi harian
    And user set anggaran harian to "20000"
    And owner click Simpan Pengaturan on ubah anggaran
    And user click Ya,Ganti button
    Then user check ads status:
      | ads name      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara |
      | text status   | Tidak Naik                                    |
      | toggle status | off                                           |
      | status desc   | Klik tombol untuk naikkan iklan               |
      | text anggaran | Tipe Anggaran: Rp20.000 per-hari              |

  @TEST_LIMO-3384 @web @automated
  Scenario: Toggle OFF and status Tidak Naik, Daily Budget Change to Daily Budged
    And user click ubah on "Kos Ayame Tipe MamiAds Tobelo Halmahera Utara"
    And user set anggaran to dibatasi harian
    And user set anggaran harian to "19000"
    And owner click Simpan Pengaturan on ubah anggaran
    And user click Ya,Ganti button
    Then user check ads status:
      | ads name      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara |
      | text status   | Tidak Naik                                    |
      | toggle status | off                                           |
      | status desc   | Klik tombol untuk naikkan iklan               |
      | text anggaran | Tipe Anggaran: Rp19.000 per-hari              |

  @TEST_LIMO-1350 @LIMO1-staging @continue
  Scenario: Success change anggaran when saldo MamiAds < 5000 for Non active ads
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408323 | 083176408323 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user click ubah on "Kos Raney Happyvirus Mamitest Tipe B Tobelo Halmahera Utara"
    And user set anggaran to saldo maksimal
    And owner click Simpan Pengaturan on ubah anggaran
    And user click Ya,Ganti button
    And user check ads status:
      | ads name      | Kos Raney Happyvirus Mamitest Tipe B Tobelo Halmahera Utara |
      | text status   | Tidak Naik                                                  |
      | toggle status | off                                                         |
      | status desc   | Klik tombol untuk naikkan iklan                             |
      | text anggaran | Tipe Anggaran: Saldo Maksimal                               |
    And user click ubah on "Kos Raney Happyvirus Mamitest Tipe B Tobelo Halmahera Utara"
    And user set anggaran to dibatasi harian
    And owner click Simpan Pengaturan on ubah anggaran
    And user click Ya,Ganti button
    And user check ads status:
      | ads name      | Kos Raney Happyvirus Mamitest Tipe B Tobelo Halmahera Utara |
      | text status   | Tidak Naik                                                  |
      | toggle status | off                                                         |
      | status desc   | Klik tombol untuk naikkan iklan                             |
      | text anggaran | Tipe Anggaran: Rp10.000 per-hari                            |

  @TEST_LIMO-3386 @web @automated
  Scenario: Success change anggaran when saldo MamiAds < 5000 for active ads
    And user click ubah on "Kos Raney Happyvirus Mamitest Tipe VIP1 Tobelo Halmahera Utara"
    And user click beli saldo on popup
    Then user redirected to pembelian saldo mamiads page

  @LIMO-3797
  Scenario: Naikan iklan - To make sure wording while iklan Off by owner when set maximal budget and saldo burn > 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202415 | 089504220900 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    Then user check ads status:
      | ads name      | Kos GTA Andreas Rajeg Tangerang  |
      | text status   | Tidak Naik                       |
      | toggle status | off                              |
      | status desc   | Klik tombol untuk naikkan iklan  |
      | text anggaran | Tipe Anggaran: Rp10.000 per-hari |

  @LIMO-3796
  Scenario: Naikan iklan - To make sure wording while iklan Off by owner when set daily budget and saldo burn > 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202202 | 089504220900 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user click ubah on "Kost Supersemar Tobelo Halmahera Utara"
    And user set anggaran harian to "10000"
    And owner click Simpan Pengaturan on ubah anggaran
    And user check ads status:
      | ads name      | Kost Supersemar Tobelo Halmahera Utara |
      | text status   | Tidak Naik                             |
      | toggle status | off                                    |
      | status desc   | Klik tombol untuk naikkan iklan        |
      | text anggaran | Tipe Anggaran: Rp10.000 per-hari       |

  @LIMO-3795  @LIMO-2327
  Scenario: Naikan iklan - [MamiAds][Naikkan Iklan]: Switch OFF ads while saldo burn > 0 from maximal budget
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202407 | 089504220900 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user click ubah on "Kost sambal bakar konoha TIPE A Rajeg Tangerang"
    And user set anggaran to dibatasi harian
    And owner click Simpan Pengaturan on ubah anggaran
    And user click "on" toggle the "Kost sambal bakar konoha TIPE A Rajeg Tangerang"
    And user click "Ya, Nonaktifkan" button on pop up switch toggle iklan
    And user click "off" toggle the "Kost sambal bakar konoha TIPE A Rajeg Tangerang"
    And user click "Aktifkan" button on pop up switch toggle iklan

  @LIMO-2337
  Scenario: [MamjAds][Naikkan iklan]: Iklan has been reset burning saldo and saldo is sufficient while iklan OFF and already reach daily budget
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202302 | 089504220900 | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user click ubah on "Kost Gowongan Jaya Pancoran Mas Depok"
    And user set anggaran to dibatasi harian
    And user set anggaran harian to "10000"
    And owner click Simpan Pengaturan on ubah anggaran
    Then user will see that the text "Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp10.000" is displayed