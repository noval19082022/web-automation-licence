@regression @LIMO3 @createKosBBKNotActive @DONEMIGRATINGTONEWBOARD

Feature: Create new kos with owner not active BBK

  @TEST_LIMO-3670 @CreateKosExistTypeBBKNotActv
  Scenario: [Form add New Kost][Kos]Create new room type from "Tipe A" && edit data kos && mamipay not active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0823333333330 | qwerty123 |
    And owner navigates to property saya kos
    When owner close pop up BBK at kos list page
    And owner click tambah data iklan "Kost"
    And user click add new kos button
    And owner fills valid data kos as expected
      | kos name             | room type check | room type name        | kos type | description kos       | build kos | other note |
      | kost Automation TEST | yes             | Tipe New BBK Rejected | mix      | kos terbaik hari raya | 2023      |            |
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
    When owner click Lanjutkan button
    And user see activate mamipay form with Bank Account Number "977689900"
    And user see active mamipay form with Bank Owner Name "Automation BBK Not Active"
    And user see active mamipay form with Bank Name "CTBC (Chinatrust) Indonesia"
    And owner click term and condition
    And owner click "Kirim Data" button
    And owner click Selesai in success page add kos
    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Campur"

  Scenario: Delete and reject kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner "0823333333330" in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed

#  @TEST_LIMO-3660 @CreateNewRoomTypeBBKNotActv @continue
#  Scenario: [Add new kost][Kos]Create new room type from "Buat baru" when user already active mamipay && all bbk kos not active
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag    | password  |
#      | 0823333333330 | qwerty123 |
#    And owner navigates to property saya kos
#    When owner close pop up BBK at kos list page
#    And owner click tambah data iklan "Kost"
#    And owner click add another type from kos "Tipe New BBK Rejected"
#    And owner click "Buat Baru" in add new room type pop up and click next
#    Then verify message "Anda belum mengisi nama tipe kamar ini." the room type
#    When owner input room type with "{random_text}"
#    And owner select the kost type "mix"
#    And owner click lanjutkan button for next steps
#    And owner upload valid photo "depan kamar"
#    And owner upload valid photo "dalam kamar"
#    And owner upload valid photo "kamar mandi"
#    And owner click lanjutkan button for next steps
#    And user check facilities under "Fasilitas Kamar"
#      | AC |
#    And owner click lanjutkan button for next steps
#    And owner select size room "3 x 4"
#    And owner input total room and room available as expected
#      | total room | room available |
#      | 15         | 10             |
#    And owner click lanjutkan button for next steps
#    And owner input the price room as expected
#      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
#      | 300000        | no                      |                   | no                |             |              |                     |                   |              |
#    And owner click lanjutkan button for next steps
#    Then owner will see that the text "Data Kos Dikirimkan" is displayed
#    When owner click Lanjutkan button
#    And user see activate mamipay form with Bank Account Number "977689900"
#    And user see active mamipay form with Bank Owner Name "Automation BBK Not Active"
#    And user see active mamipay form with Bank Name "CTBC (Chinatrust) Indonesia"
#    And owner click "Kirim Data" button
#    And owner click Selesai in success page add kos
#    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Campur"
#    And user logs out

#  Scenario: Delete and reject kos from admin
#    Given admin go to mamikos bangkrupux admin
#    When admin login to bangkrupux:
#      | email stag                 | email prod                 | password  |
#      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin bangkrupux navigate to kost owner menu
#    And admin bangkrupux search phone owner "0823333333330" in admin kos owner page
#    And admin delete kos
#    Then verify "Success! Room has been succesfully deleted" displayed
#    When admin click on "BBK Data" link button
#    And admin reject bulk BBK kos

  @TEST_LIMO-3671 @CreateNewKosBBKNotActv @continue
  Scenario: [Add new kost][Kos]Create new kost when user already active mamipay && all bbk kos not active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0823333333330 | qwerty123 |
    And owner navigates to property saya kos
    When owner close pop up BBK at kos list page
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner fills valid data kos as expected
      | kos name             | room type check | room type name | kos type | description kos              | build kos | other note                   |
      | kost automation test | yes             | Tipe A         | girl     | Kos new draft not active BBK | 2020      | Akan dihapus setelah terbuat |
    And owner set rules kos:
      | Dilarang bawa hewan |
    And owner input data pengelola as expected:
      | add data pengelola | pengelola name | pengelola phone |
      | yes                | Omeii          | 083333373777    |
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
    And owner click lanjutkan button for next steps
    And user check facilities under "Fasilitas Umum"
      | Dapur |
    And user check facilities under "Fasilitas Kamar"
      | AC   |
      | Sofa |
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
    And owner click lanjutkan button for next steps
    And owner navigates to owner dashboard
    And owner navigates to property saya kos
    Then user see kos with valid name, status "Draft" and type "Kos Putri"

  @TEST_LIMO-3672 @CreateKosFromDraftBBKInactv
  Scenario: Create from kos with status draft && mamipay active && all bbk kos not active
    And owner navigates to property saya kos
    And owner click close icon pop up
    And owner search kos on property saya page
    And owner click "Lengkapi Data Kos" on kos draft
    When owner close pop up BBK at kos list page
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 300000        | yes                     | Min. 1 Hari       | yes               | 50000       | 200000       | 800000              | 1700000           | 3000000      |
    And owner select additional price
    And owner input additional price
      | price name | price total |
      | Cuci Baju  | 10000       |
    And owner select down payment with "30%" from rent price
    And owner click lanjutkan button for next steps
    #Then owner will see that the text "Data Kos Dikirimkan" is displayed
    When owner click Lanjutkan button
    And user see activate mamipay form with Bank Account Number "977689900"
    And user see active mamipay form with Bank Owner Name "Automation BBK Not Active"
    And user see active mamipay form with Bank Name "CTBC (Chinatrust) Indonesia"
    And owner click term and condition
    And owner click "Kirim Data" button
    And owner click Selesai in success page add kos
    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Putri"

  Scenario: Delete and reject kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner "0823333333330" in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed