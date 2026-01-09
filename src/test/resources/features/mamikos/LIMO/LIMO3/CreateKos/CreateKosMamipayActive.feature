@regression @LIMO3 @listing-monetization @createKosMamipayActive @essentialTest2 @loadingrevamp
Feature: Create Kos Mamipay Active

  @TEST_LIMO-776 @Automated @web-covered
  Scenario: [Form add New Kost][Harga] Create new kos with PLM and select room type "Buat Baru" from list room type && input invalid value room type
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click add another type from kos "Kos oke bebek"
    When owner click "Buat Baru" in add new room type pop up and click next
    Then verify message "Anda belum mengisi nama tipe kamar ini." the room type
    When owner input room type with "  "
    Then verify message "Anda belum mengisi nama tipe kamar ini." the room type
    And see next button disable
    When owner input room type with "Tipe VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIP VVIPPm"
    Then verify message "Tidak boleh lebih dari 100 karakter." the room type
    When owner input room type with "a"
    Then verify message "Tidak boleh kurang dari 2 karakter." the room type
    When owner input room type with "()"
    Then verify message "Tidak boleh menggunakan karakter spesial seperti / ( ) - . , ’ dan “" the room type
    When owner input room type with "Tipe v"
    Then verify message "Tipe kamar tidak boleh sama." the room type
    When owner select the kost type "girl"

  @TEST_LIMO-768 @Automated @web-covered
  Scenario: [Form add New Kost][Harga] Create new kos with PLM and select room type "Tipe A" from list room type && input invalid value room type
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click add another type from kos "Property Automation"
    And owner click "Tipe A" in add new room type pop up and click next
    And owner input room type with "  " in pop up
    Then verify message "Tipe kamar tidak boleh kosong." the room type
    And see next button disable in pop up
    When owner input room type with "Tipe A" in pop up
    Then verify message "Tipe kamar tidak boleh sama." the room type
    When owner input room type with random text in pop up
    And owner click lanjutkan button in bottom of add kos page
    And owner click "Edit Selesai" button
    And owner upload valid photo "kamar mandi"
    And owner upload valid photo "lain"
    And owner click lanjutkan button for next steps
    When user click button edit "Fasilitas" kos
    And user uncheck facilities under "Fasilitas Kamar"
      | TV |
    Then user see "Fasilitas Kamar" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    When user check facilities under "Fasilitas Kamar"
      | TV |
    And owner click "Edit Selesai" button
    And owner input total room and room available as expected
      | total room | room available |
      | 2          | 7              |
    Then user see error message "Jumlah kamar tersedia tidak boleh lebih dari total kamar." under total room available
    When owner input total room and room available as expected
      | total room | room available |
      | 4          | 3,5            |
    Then user see error message "Hanya boleh menggunakan angka." under total room available
    When owner input total room and room available as expected
      | total room | room available |
      | 3          | 2              |
    And owner click "Atur Ketersediaan Kamar" ketersediaan kamar
    And owner input room name or number in room allotment page with "  "
    Then user see error message "Nomor/nama masih kosong." under room type field
    When owner input room name or number in room allotment page with "24"
    Then user see error message "Nomor/nama sudah dipakai kamar lain." under room type field
    When owner input room name or number in room allotment page with "123456789012345678901234567890123456789012345678901"
    Then user see error message "Maksimal 50 karakter." under room type field
    When owner input room name or number in room allotment page with "1"
    And owner input room floor with "123456789012345678901234567890123456789012345678901"
    Then user see error message "Maksimal 50 karakter." under floor field
    When owner click "Selesai Ketersediaan Kamar" in data ketersediaan kamar
    And owner click lanjutkan button for next steps

  @deleteKosFromAdmin
  Scenario: Delete kos from admin
    When admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner in admin kos owner page
    And admin delete kos

  @TEST_LIMO-765 @Automated @web-covered
  Scenario: [Form add New Kost][Harga] Check function pop up confirmation on screen form create kos
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner input kos name "Kost Coba AutoJava"
    And user click back button in page input kos
    And owner click "Lanjut Isi Data" input data on pop up
    And owner select the kost type "girl"
    And user click back button in page
    Then owner click "Keluar" input data on pop up

  @TEST_LIMO-3678 @Automated @web-covered
  Scenario: [Form add New Kost][Harga] Create new kos from Add New and reject kos and deleted
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner fills valid data kos as expected
      | kos name            | room type check | room type name | kos type | description kos       | build kos | other note |
      | kost Automation TEST | yes             | Tipe A         | girl     | kos terbaik hari raya | 2023      |            |
    And owner set rules kos:
      | Akses 24 Jam |
      | Security     |
    And owner upload valid rule kos
    And owner click Lanjutkan for input kos address
    And owner click on leftlet marker
    And owner click lanjutkan button for next steps
    And user clicks on the close button
    And owner upload valid photo "bangunan tampak depan"
    And owner upload valid photo "tampilan dalam bangunan"
    And owner upload valid photo "tampak dari jalan"
    And owner click lanjutkan button for next steps
    And owner upload valid photo "depan kamar"
    And owner upload valid photo "dalam kamar"
    And owner upload valid photo "kamar mandi"
    And owner upload valid photo "lain"
    And owner click lanjutkan button for next steps
    And user check facilities under "Fasilitas Umum"
      | Air Jernih |
      | Kompor     |
    And user uncheck facilities under "Fasilitas Umum"
      | Air Jernih |
      | Kompor     |
    And user see "Fasilitas Umum" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user check facilities under "Fasilitas Umum"
      | Air Jernih |
      | Kompor     |
    And user check facilities under "Fasilitas Kamar"
      | Kasur |
    And user check facilities under "Fasilitas Kamar Mandi"
      | Air panas |
      | Shower    |
    And user uncheck facilities under "Fasilitas Kamar Mandi"
      | Air panas |
      | Shower    |
    And user see "Fasilitas Kamar Mandi" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user check facilities under "Fasilitas Kamar Mandi"
      | Air panas |
      | Shower    |
    And user check facilities under "Parkir"
      | Parkir Sapi |
    And owner click lanjutkan button for next steps
    And owner select size room "3 x 4"
    And owner input total room and room available as expected
      | total room | room available |
      | 15         | 10             |
    And owner click lanjutkan button for next steps
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 300000        | yes                     | Min. 1 Hari       | yes               | 50000       | 200000       | 800000              | 1700000           | 3000000      |
    And owner select additional price
    And owner input additional price
      | price name | price total |
      | Cuci Baju  | 10000       |
    And owner select down payment with "30%" from rent price
    And owner set penalty is "50000"
    And user select payment expired date after "3" "Minggu"
    And owner click lanjutkan button for next steps
    And owner click done in success page
    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Putri"

  @rejectKos @TEST_LIMO-3679
  Scenario: Reject kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner in admin kos owner page
    And admin reject kos
    And admin input the reason "Posisi di peta kurang sesuai" in reject reason page below "Alamat Kos"
    And user click "Reject" button in kos owner reject reason
    And user click "Send" in send reject pop up

  @deleteKosRejected @TEST_LIMO-3680
  Scenario: Delete kos with status di tolak from ownerpage
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kos on property saya page
    Then user see kos with valid name, status "Data Kos Ditolak" and type "Kos Putri"
    And user delete first kos on the list

  @TEST_LIMO-782
  Scenario: [Form add New Kost][Harga]Add new kos and without input mandatory field in some entity on screen harga
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kost Automation TEST NB62KV2B" on property saya page
    And owner click "Lengkapi Data Kos" on kos draft
    And user click button edit "Harga" kos
    And owner edit data harga kos as expected
      | monthly price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 0             | 0           | 0            | 0                   | 0                 | 0            |
    Then user see warning price on add kos with:
      | warningMessage                                            |
      | Harga per bulan min. Rp50.000 dan maks. Rp100.000.000.    |
      | Harga per hari min. Rp10.000 dan maks. Rp10.000.000.      |
      | Harga per minggu min. Rp50.000 dan maks. Rp50.000.000.    |
      | Harga per 3 bulan min. Rp100.000 dan maks. Rp100.000.000. |
      | Harga per 6 bulan min. Rp100.000 dan maks. Rp100.000.000. |
      | Harga per tahun min. Rp100.000 dan maks. Rp100.000.000.   |

  @TEST_LIMO-3669
  Scenario: [Add New Kost][Mamipay]Check T&C remote condition with status true
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083176408311 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner input kos name "Property Automation" for existing kost name
    Then verify message "Nama ini telah digunakan kos lain." the room type
    When owner fills valid data kos as expected
      | kos name             | room type check | room type name | kos type | description kos                   | build kos | other note                   |
      | kost Automation TEST | no              |                | boy      | kos harusnya Kost noBBK noMamipay | 2020      | Akan dihapus setelah terbuat |
    And owner set rules kos:
      | Ada jam malam |
    And owner upload rule kos
    And owner upload valid rule kos
    Then verify warning upload gagal disappear
    When owner click Lanjutkan for input kos address
    And owner click on leftlet marker
    And owner click lanjutkan button for next steps
    And user clicks on the close button
    And owner upload valid photo "bangunan tampak depan"
    And owner upload valid photo "tampilan dalam bangunan"
    And owner upload valid photo "tampak dari jalan"
    And owner click lanjutkan button for next steps
    And owner upload valid photo "depan kamar"
    And owner upload valid photo "dalam kamar"
    And owner upload valid photo "kamar mandi"
    And owner click lanjutkan button for next steps
    And user check facilities under "Fasilitas Umum"
      | Dapur |
    And user check facilities under "Fasilitas Kamar"
      | AC |
    And user check facilities under "Fasilitas Kamar Mandi"
      | Bathup |
      | Gayung |
    And user check facilities under "Parkir"
      | Parkir Mobil |
    And owner click lanjutkan button for next steps
    And owner select size room "3 x 4"
    And owner input total room and room available as expected
      | total room | room available |
      | 1          | 1              |
    And owner click "Atur Ketersediaan Kamar" ketersediaan kamar
    And owner input room name or number in room allotment page with "2"
    And user click back button in page input kos
    And owner click "Keluar" input data on pop up
    And owner input total room and room available as expected
      | total room | room available |
      | 2          | 1              |
    And owner click lanjutkan button for next steps
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 500000        | no                      |                   | no                |             |              |                     |                   |              |
    And owner navigates to owner dashboard
    And owner navigates to property saya kos
    Then user see kos with valid name, status "Draft" and type "Kos Putra"
    When user delete first kos on the list