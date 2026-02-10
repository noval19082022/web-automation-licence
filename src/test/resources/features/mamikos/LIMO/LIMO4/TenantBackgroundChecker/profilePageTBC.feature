@LIMO4 @regression @tbclimo400 @selasamaintenanceskuy
Feature: Profile Tenant Background Checker

  Scenario: reset Gp
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number
      | 08119787884 |

  @TEST_LIMO-315 @WEB @AUTOMATED
  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check back on tenant profile page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 089145645603 | qwerty123 |
    And user click chat button in top bar owner home page
    And owner open TBC Lihat Profil at chatroom "Noval New"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed

  @TEST_LIMO-317 @WEB @AUTOMATED
  Scenario: [Web][Chat Room][Tenant Background Checker] Check entry point when owner only have apartement
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod   | password  |
      | 08119787884 | 083355251016 | Perempuan |
    And user click chat button in top bar owner home page
    And owner doesn't have GP open TBC Lihat Profil at chatroom "Desta Fajri"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed

  @TEST_LIMO-320 @WEB @AUTOMATED
  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check condition when owner not GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod   | password  |
      | 08119787884 | 083355251030 | Perempuan |
    And owner wants to accsess chatroom
    And owner doesn't have GP open TBC Lihat Profil at chatroom "Tenant Ios Desember"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed

  @TEST_LIMO-4319
  Scenario: Privacy setting wording "lokasi, asal daerah" change to "asal daerah"
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click "Pengaturan"
    And user click "Privasi"
    Then user will see that the text "Berisi informasi lanjutan seperti asal daerah dan no. Hp yang disensor." is displayed

  @TEST_LIMO-4320
  Scenario: Privacy data preview profil penyewa section
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click "Pengaturan"
    And user click "Privasi"
    And user click "Lihat Preview Profilmu"
    Then user will see data profile:
    | Zoro1998    |
    | Kawin Memiliki Anak |
    | Mahasiswa    |

  @TEST_LIMO-4321
  Scenario: Privacy data preview informasi umum section
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod  | password  |
      | 089220221220 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click "Pengaturan"
    And user click "Privasi"
    And user click "Lihat Preview Profilmu"
    Then user will see data profile:
      | Belum upload kartu identitas |
      | Laki-laki |
      | Belum transaksi di Mamikos |
      | Bergabung sejak 20 Des 2022 |

  @TEST_LIMO-4322
  Scenario: Disable Privacy data preview Privasi Riwayat pencarian Kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod  | password  |
      | 0892202506 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click "Pengaturan"
    And user click "Privasi"
    And user click "Lihat Preview Profilmu"
    Then user will see data profile:
      | Kriteria properti yang dicari akan tampil di sini setelah penyewa mengizinkan datanya untuk diperlihatkan. |

  @TEST_LIMO-4323
  Scenario: Disable Privacy data preview Aktivitas di Mamikos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod  | password  |
      | 0892202507 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click "Pengaturan"
    And user click "Privasi"
    And user click "Lihat Preview Profilmu"
    Then user will see data profile:
      | Belum Dapat Ditampilkan |


#  @TEST_LIMO-325
#  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check Section at page profil tenant
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag   | phone prod    | password  |
#      | 0891202407   | 0891111020203 | qwerty123 |
#    And owner dismiss FTUE goldplus
#    And user click chat button in top bar owner home page
#    And owner open TBC Lihat Profil at chatroom "Roti Putih"
#    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed
#    Then owner will see that the text "Minerva" is displayed
#    Then owner will see that the text "Mahasiswa" is displayed
#    Then owner will see that the text "0892-20xx-xx" is displayed
   # And owner can see Tenant Historical Summary Data with Jumlah Pengajuan Sewa,Jumlah Pembayaran Sewa,Rata-Rata Durasi Sewa,Rata-Rata Nominal Sewa,Jumlah Chat yang Aktif

#  @TEST_LIMO-324
#  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check tooltip at section data profil tenant
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag   | phone prod    | password  |
#      | 089145645602 | 0891111020203 | qwerty123 |
#    And user click chat button in top bar owner home page
#    And owner open TBC Lihat Profil at chatroom "Minerva"
#    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed
#    When owner click on tooltip "chatActive"
#    Then owner see explain is "Jumlah chat yang sedang aktif antara penyewa dan pemilik selama 30 hari terakhir."
#    When owner click on tooltip "pembayaranSewa"
#    Then owner see explain is "Total pembayaran dari pengajuan sewa yang telah dilakukan penyewa sejak terdaftar di Mamikos."
#    When owner click on tooltip "ketepatanWaktuBayar"
#    Then owner see explain is "Ukuran ketepatan waktu bayar saat melakukan perpanjangan sewa. Semakin tinggi, semakin tepat waktu."
#    When owner click on tooltip "rataRataDurasiSewa"
#    Then owner see explain is "Rata-rata lama waktu menetap di kos sejak terdaftar di Mamikos."
#    When owner click on tooltip "rataRataNominalSewa"
#    Then owner see explain is "Rata-rata harga kamar yang disewa sejak terdaftar di Mamikos."
#    When owner click on tooltip "pengajuanSewa"
#    Then owner see explain is "Total pengajuan sewa kos yang telah dilakukan penyewa sejak terdaftar di Mamikos."

#  @TEST_LIMO-322
#  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check condition when owner already GP 1
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag   | password  |
#      | 089145645603 | qwerty123 |
#    And user click chat button in top bar owner home page
#    And owner open TBC Lihat Profil at chatroom "Noval Abis Delete Aja"
#    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed
#    Then owner GP-1 upgrade paket to GP-2 from TBC detail page

#  @TEST_LIMO-322
#  Scenario:[Web][Tenant Background Checker][Profil Tenant] Check condition when owner have invoice single or multiple GP 1 activation
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag   | password  |
#      | 089145645603 | qwerty123 |
#    And user click chat button in top bar owner home page
#    And owner open TBC Lihat Profil at chatroom "Noval Abis Delete Aja"
#    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed
#    And owner click on upgrade package at tbc profile tenant
#    Then owner see popup text "Paket akan diganti ke Goldplus 2"

  @turnOffInformasiDataDiri
  Scenario: Tenant turns off privacy setting and verifies profile preview
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | password  |
      | 081280003230  | qwerty123 |
    And tenant visit page "/user/pengaturan"
    And user click "Privasi"
    And tenant click on toggle on to off
    And tenant click on lihat preview profil
    Then tenant should not be able to see the text "Asal Kabupaten Aceh Selatan 0812-8000-xxxx"
    Then tenant should not be able to see the text "0812-8000-xxxx"
