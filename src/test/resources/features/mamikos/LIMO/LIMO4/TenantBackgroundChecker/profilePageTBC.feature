@LIMO4 @regression @tbclimo4
Feature: Profile Tenant Background Checker

  @TEST_LIMO-315 @WEB @AUTOMATED
  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check back on tenant profile page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0891111020203 | 0891111020203 | mamikosqa123 |
    And user click chat button in top bar owner home page
    And owner open TBC Lihat Profil at chatroom "Staging Tbc Test"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed

  @TEST_LIMO-317 @WEB @AUTOMATED
  Scenario: [Web][Chat Room][Tenant Background Checker] Check entry point when owner only have apartement
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083355251016 | 083355251016 | qwerty123 |
    And user click chat button in top bar owner home page
    And owner doesn't have GP open TBC Lihat Profil at chatroom "Desta Tenant D"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed

  @TEST_LIMO-320 @WEB @AUTOMATED
  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check condition when owner not GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083355251030 | 083355251030 | qwerty123 |
    And owner wants to accsess chatroom
    And owner Non GP open TBC Lihat Profil at chatroom "Rega Tenant Tiga"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed

  @TEST_LIMO-325
  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check Section at page profil tenant
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 089145645602 | 0891111020203 | qwerty123 |
    And owner dismiss FTUE goldplus
    And user click chat button in top bar owner home page
    And owner open TBC Lihat Profil at chatroom "Minerva"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed
#    Then owner will see that the text "Minerva" is displayed
#    Then owner will see that the text "Mahasiswa" is displayed
#    Then owner will see that the text "0892-20xx-xx" is displayed
   # And owner can see Tenant Historical Summary Data with Jumlah Pengajuan Sewa,Jumlah Pembayaran Sewa,Rata-Rata Durasi Sewa,Rata-Rata Nominal Sewa,Jumlah Chat yang Aktif

  @TEST_LIMO-324
  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check tooltip at section data profil tenant
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 089145645602 | 0891111020203 | qwerty123 |
    And user click chat button in top bar owner home page
    And owner open TBC Lihat Profil at chatroom "Minerva"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed
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

  @TEST_LIMO-322
  Scenario: [Web][Tenant Background Checker][Profil Tenant] Check condition when owner already GP 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 089145645603 | qwerty123 |
    And user click chat button in top bar owner home page
    And owner open TBC Lihat Profil at chatroom "Noval Abis Delete Aja"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed
#    Then owner GP-1 upgrade paket to GP-2 from TBC detail page

  @TEST_LIMO-322
  Scenario:[Web][Tenant Background Checker][Profil Tenant] Check condition when owner have invoice single or multiple GP 1 activation
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 089145645603 | qwerty123 |
    And user click chat button in top bar owner home page
    And owner open TBC Lihat Profil at chatroom "Noval Abis Delete Aja"
    Then owner will see that the text "Untuk saat ini, fitur Profil Penyewa hanya dapat digunakan di aplikasi Mamikos di Android dan iOS." is displayed
#    And owner click on upgrade package at tbc profile tenant
#    Then owner see popup text "Paket akan diganti ke Goldplus 2"


