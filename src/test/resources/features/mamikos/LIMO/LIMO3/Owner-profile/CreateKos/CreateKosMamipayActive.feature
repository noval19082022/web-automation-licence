@regression @LIMO3 @listing-monetization @createKosMamipayActive
Feature: Create Kos Mamipay Active

  Background: Go to tambah data kos form
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password    |
      | 083176408311  | qwerty123   |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"

  @TEST_LIMO-2913 @Automated @web-covered
  Scenario: [Form add New Kost][Harga] Create new kos with PLM and select room type "Buat Baru" from list room type && input invalid value room type
    Given owner click add another type from kos "Kos oke bebek"
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

  @TEST_LIMO-2909 @Automated @web-covered
  Scenario: [Form add New Kost][Harga] Create new kos with PLM and select room type "Tipe A" from list room type && input invalid value room type
    Given owner click add another type from kos "Kos oke bebek"
    When owner click "Tipe o" in add new room type pop up and click next
    When owner input room type with "  " in pop up
    Then verify message "Tipe kamar tidak boleh kosong." the room type
    And see next button disable in pop up
    When owner input room type with "Tipe o" in pop up
    Then verify message "Tipe kamar tidak boleh sama." the room type

  @TEST_LIMO-2914 @Automated @web-covered
  Scenario: [Form add New Kost][Harga] Check function pop up confirmation on screen form create kos
    Given owner click "Tambah Kos Baru"
    When owner input kos name "Kost Coba AutoJava"
    And user click back button in page input kos
#    Then owner see pop up confirmation request attention
    When owner click "Lanjut Isi Data" input data on pop up
    And owner select the kost type "girl"
    And user click back button in page
    When owner click "Keluar" input data on pop up

  @TEST_LIMO-2915 @Automated @web-covered
  Scenario: [Form add New Kost][Harga] Create new kos from Add New when user already active mamipay && all bbk kos active or has BBK Waiting for Verif
    And owner click "Tambah Kos Baru"
    And owner fills valid data kos as expected
      | kos name            | room type check | room type name | kos type | description kos                 | build kos | other note |
      | Kost Wanita AutoJava | yes             | Tipe A         | girl     | kos terbaik hari raya          | 2023      |            |
    And owner set rules kos:
      | Akses 24 Jam  |
      | Security |
    And owner upload valid rule kos
    And owner click Lanjutkan for input kos address
    And owner input address is "Tobelo"
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
    And user check facilities under "Fasilitas Kamar"
      | Kasur |
    And user check facilities under "Fasilitas Kamar Mandi"
      | Air panas|
      | Shower   |
    And user check facilities under "Parkir"
      | Parkir Sapi |
    And owner click lanjutkan button for next steps
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
      | price name | price total|
      | Cuci Baju  | 10000      |
    And owner select down payment with "30%" from rent price
    And owner set penalty is "50000"
    And owner click lanjutkan button for next steps
    And owner click done in success page
    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Putri"







