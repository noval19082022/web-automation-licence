@regression @LIMO1
Feature: Ubah Anggaran

  @TEST_LIMO-306
  Scenario: Ubah Anggaran - Saldo 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0826666666633 | 0826666666633 | qwerty123    |
    And user click on Saldo MamiAds at owner dashboard
    And user click coba sekarang header
    And user close mamiads onboarding popup
    And user click "ubah"
    Then user will see that the text "Anda belum bisa mengubah anggaran" is displayed
    And user will see that the text "Minimum harus ada saldo 5.000 untuk mengubah anggaran. Silakan beli saldo terlebih dahulu." is displayed

  @TEST_LIMO-311
  Scenario: Ubah Anggaran - Update Batasan to Less Than Min-Max Amount
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 083176408449 | 083176408449 | qwerty123    |
    And user click on Saldo MamiAds at owner dashboard
    And user close mamiads onboarding popup
    And user click ubah on "Kos Ranise Mamitest Tobelo Halmahera Utara"
    And user set anggaran harian to "4999"
    Then user will see that the text "Mohon masukkan minimum Rp5.000" is displayed
    #Scenario MA-5735
    When user set anggaran harian to "10000001"
    Then user will see that the text "Maksimum Rp10.000.000" is displayed

  @TEST_LIMO-308
  Scenario: Ubah Anggaran - Change saldo Maksimal to saldo Maksimal, Iklan its Naik & toggle ON Saldo burning = 0
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 089504220900 | 089504220900 | qwerty123    |
    And owner click "Nanti Saja"
    And user click on Saldo MamiAds at owner dashboard
    And user close mamiads onboarding popup
    Then user check ads status:
      | ads name      | kost rane hana Mamitest                               |
      | text status   | Naik                                                  |
      | toggle status | on                                                    |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.  |
      | text anggaran | Hari ini terpakai Rp0                                 |
    When user click ubah on "kost rane hana Mamitest"
    And owner click "Simpan Pengaturan"
    Then user verify the toast "Tidak ada perubahan tipe anggaran"
    #Scenario change saldo maksimal to saldo maksimal, if iklan its Tidak Naik and toggle OFF
    #Scenario To make sure wording while iklan Off by owner when set maximal budget and saldo burn = 0 (MA-5815)
    When user check ads status:
      | ads name      | Kos rane net Mamitest                                 |
      | text status   | Tidak Naik                                            |
      | toggle status | off                                                   |
      | status desc   | Klik tombol untuk naikkan iklan                       |
      | text anggaran | Tipe Anggaran: Saldo Maksimal                         |
    And user click ubah on "Kos rane net Mamitest"
    And owner click "Simpan Pengaturan"
    Then user verify the toast "Tidak ada perubahan tipe anggaran"
    #Scenario change daily budged to daily budged, Iklan its Naik & toggle ON saldo burning = 0 (MA-5796)
    When user check ads status:
      | ads name      | kost rane dul Mamitest                                         |
      | text status   | Naik                                                           |
      | toggle status | on                                                             |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.           |
      | text anggaran | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp20.000 |
    And user click ubah on "kost rane dul Mamitest"
    And owner click "Simpan Pengaturan"
    Then user verify the toast "Tidak ada perubahan tipe anggaran"
    #Scenario change daily budged to daily budged, if iklan its Tidak Naik and toggle OFF
    #Scenario To make sure wording while iklan Off by owner when set daily budget and saldo burn = 0 (MA-5814)
    When user check ads status:
      | ads name      | Kos rane set Mamitest                                  |
      | text status   | Tidak Naik                                             |
      | toggle status | off                                                    |
      | status desc   | Klik tombol untuk naikkan iklan                        |
      | text anggaran | Tipe Anggaran: Rp70.000 per-hari                       |
    And user click ubah on "kost rane dul Mamitest"
    And owner click "Simpan Pengaturan"
    Then user verify the toast "Tidak ada perubahan tipe anggaran"


  @TEST_LIMO-307
  Scenario: Hit Daily Budget is 0, Toggle ON and status Naik, Change to daily budged
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 085720962105 | 085720962105 | qwerty123    |
    And user click on Saldo MamiAds at owner dashboard
    And user close mamiads onboarding popup
    Then user check ads status:
      | ads name      | Raney Hambura                                                   |
      | text status   | Naik                                                            |
      | toggle status | on                                                              |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.            |
      | text anggaran | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp10.000  |
    When user click ubah on "Raney Hambura"
    And user set anggaran harian to "5000"
    And owner click "Simpan Pengaturan"
    And user click Ya,Ganti button
    Then user verify the toast "Anggaran berhasil diubah"
    And user check ads status:
      | ads name      | Raney Hambura                                                   |
      | text status   | Naik                                                            |
      | toggle status | on                                                              |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.            |
      | text anggaran | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp5.000   |
    #Scenario: Hit Daily Budget is 0, Toggle ON and status Naik, Change Daily Budget to Saldo Maksimal (MA-5777)
    And user click ubah on "Raney Hambura"
    And user set anggaran to saldo maksimal
    And owner click "Simpan Pengaturan"
    And user click Ya,Ganti button
    Then user verify the toast "Anggaran berhasil diubah"
    And user check ads status:
      | ads name      | Raney Hambura                                         |
      | text status   | Naik                                                  |
      | toggle status | on                                                    |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.  |
      | text anggaran | Hari ini terpakai Rp0                                 |
    #Scenario: Hit Maksimal Budget is 0, Toggle ON status Naik, Change Saldo Maksimal to Daily Budget (MA-5780)
    And user click ubah on "Raney Hambura"
    And user set anggaran to dibatasi harian
    And owner click "Simpan Pengaturan"
    And user click Ya,Ganti button
    Then user verify the toast "Anggaran berhasil diubah"
    And user check ads status:
      | ads name      | Raney Hambura                                                  |
      | text status   | Naik                                                           |
      | toggle status | on                                                             |
      | status desc   | Posisi iklan telah naik di hasil pencarian properti.           |
      | text anggaran | Hari ini Rp0 sudah dipakai dari batas pemakaian saldo Rp10.000 |

  @TEST_LIMO-309
  Scenario: Hit Daily Budget is 0, Toggle OFF and status Tidak Naik, Change Daily Budget to Saldo Maksimal
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 085720962105 | 085720962105 | qwerty123    |
    And user click on Saldo MamiAds at owner dashboard
    And user close mamiads onboarding popup
    Then user check ads status:
      | ads name      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara     |
      | text status   | Tidak Naik                                        |
      | toggle status | off                                               |
      | status desc   | Klik tombol untuk naikkan iklan                   |
      | text anggaran | Tipe Anggaran: Rp19.000 per-hari                  |
    When user click ubah on "Kos Ayame Tipe MamiAds Tobelo Halmahera Utara"
    And user set anggaran to saldo maksimal
    And owner click "Simpan Pengaturan"
    And user click Ya,Ganti button
    Then user verify the toast "Anggaran berhasil diubah"
    And user check ads status:
      | ads name      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara     |
      | text status   | Tidak Naik                                        |
      | toggle status | off                                               |
      | status desc   | Klik tombol untuk naikkan iklan                   |
      | text anggaran | Tipe Anggaran: Saldo Maksimal                     |
    #Scenario: Hit Maksimal Budget is 0, Toggle OFF status Tidak Naik, Change Saldo Maksimal to Daily Budget (MA-5792)
    And user click ubah on "Kos Ayame Tipe MamiAds Tobelo Halmahera Utara"
    And user set anggaran to dibatasi harian
    And user set anggaran harian to "20000"
    And owner click "Simpan Pengaturan"
    And user click Ya,Ganti button
    Then user verify the toast "Anggaran berhasil diubah"
    And user check ads status:
      | ads name      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara     |
      | text status   | Tidak Naik                                        |
      | toggle status | off                                               |
      | status desc   | Klik tombol untuk naikkan iklan                   |
      | text anggaran | Tipe Anggaran: Rp20.000 per-hari                  |
    #Scenario: Toggle OFF and status Tidak Naik, Daily Budget Change to Daily Budged (MA-5786)
    And user click ubah on "Kos Ayame Tipe MamiAds Tobelo Halmahera Utara"
    And user set anggaran to dibatasi harian
    And user set anggaran harian to "19000"
    And owner click "Simpan Pengaturan"
    And user click Ya,Ganti button
    Then user verify the toast "Anggaran berhasil diubah"
    And user check ads status:
      | ads name      | Kos Ayame Tipe MamiAds Tobelo Halmahera Utara     |
      | text status   | Tidak Naik                                        |
      | toggle status | off                                               |
      | status desc   | Klik tombol untuk naikkan iklan                   |
      | text anggaran | Tipe Anggaran: Rp19.000 per-hari                  |

  @TEST_LIMO-310 @LIMO1-staging
  Scenario: Success change anggaran when saldo MamiAds < 5000 for Non active ads
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 083176408323 | 083176408323 | qwerty123    |
    And user click on Saldo MamiAds at owner dashboard
    And user go back to previous page
    And user click on Saldo MamiAds at owner dashboard
    And user close mamiads onboarding popup
    And user click ubah on "Kos Raney Happyvirus Mamitest Tipe B Tobelo Halmahera Utara"
    And user set anggaran to saldo maksimal
    And owner click "Simpan Pengaturan"
    And user click Ya,Ganti button
    Then user verify the toast "Anggaran berhasil diubah"
    And user check ads status:
      | ads name      | Kos Raney Happyvirus Mamitest Tipe B Tobelo Halmahera Utara  |
      | text status   | Tidak Naik                                                   |
      | toggle status | off                                                          |
      | status desc   | Klik tombol untuk naikkan iklan                              |
      | text anggaran | Tipe Anggaran: Saldo Maksimal                                |
    And user click ubah on "Kos Raney Happyvirus Mamitest Tipe B Tobelo Halmahera Utara"
    And user set anggaran to dibatasi harian
    And owner click "Simpan Pengaturan"
    And user click Ya,Ganti button
    Then user verify the toast "Anggaran berhasil diubah"
    And user check ads status:
      | ads name      | Kos Raney Happyvirus Mamitest Tipe B Tobelo Halmahera Utara  |
      | text status   | Tidak Naik                                                   |
      | toggle status | off                                                          |
      | status desc   | Klik tombol untuk naikkan iklan                              |
      | text anggaran | Tipe Anggaran: Rp10.000 per-hari                             |
    #Scenario: Success change anggaran when saldo MamiAds < 5000 for active ads
    And user click ubah on "Kos Raney Happyvirus Mamitest Tipe VIP1 Tobelo Halmahera Utara"
    And user click beli saldo on popup
    Then user redirected to pembelian saldo mamiads page