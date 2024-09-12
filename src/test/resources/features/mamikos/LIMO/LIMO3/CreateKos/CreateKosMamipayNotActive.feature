@regression @LIMO3 @EX-LG @createKosMamipayNotActive @DONEMIGRATINGTONEWBOARD

Feature: Create new kos with owner that hasn't activate mamipay

  Scenario: Delete mamipay owner and login to owner account
    # Check if account has mamipay, if true then delete it
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to Mamipay Owner List
    And admin search owner phone "0812345670004" in mamipay owner list
    And admin delete the mamipay data from first list

  @CreateKosExistTypeMamipayNotActv @TEST_LIMO-3670
  Scenario: Create new room type from "Tipe A" && edit data kos && mamipay not active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0812345670004 | qwerty123 |
    And owner navigates to property saya kos
    And owner click "Nanti Saja" in kebijakan baru mamikos pop up
    And owner click tambah data iklan "Kost"
    And  owner click add another type from kos "Kos berTipe"
    And owner click "Tipe Apple" in add new room type pop up and click next
    And owner input room type with random text in pop up
    And owner click lanjutkan button in bottom of add kos page
    And owner select the kost type "girl"
    And owner click lanjutkan button for next steps
    And owner click "Keluar" input data on pop up
    Then verify the title on mamipay owner onboarding displayed
    When owner click Lanjutkan button
    And owner input on "nomor rekening Anda" "09182928329"
    And owner input on "nama pemilik rekening" "Omaiwa wo shinderu"
    And owner input on "nama bank" "BCA"
    And owner select bank name "BCA"
    And owner click "Kirim Data" button
    And owner click Selesai in success page add kos

  # Delete newly created kos in admin
  Scenario: Delete new kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed

  Scenario: Delete mamipay owner
    # Check if account has mamipay, if true then delete it
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to Mamipay Owner List
    And admin search owner phone "0812345670004" in mamipay owner list
    And admin delete the mamipay data from first list

  @CreateKosNewTypeMamipayNotActv @TEST_LIMO-995
  Scenario: Create new room type from "Buat baru" && mamipay not active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0812345670004 | qwerty123 |
    And owner navigates to property saya kos
    And owner click "Nanti Saja" in kebijakan baru mamikos pop up
    And owner click tambah data iklan "Kost"
    And owner click add another type from kos "Kos berTipe"
    And owner click "Buat Baru" in add new room type pop up and click next
    Then verify message "Anda belum mengisi nama tipe kamar ini." the room type
    When owner input room type with "{random_text}"
    And owner select the kost type "boy"
    And owner click lanjutkan button for next steps
    And owner upload valid photo "depan kamar"
    And owner upload valid photo "dalam kamar"
    And owner upload valid photo "kamar mandi"
    And owner click lanjutkan button for next steps
    And user check facilities under "Fasilitas Kamar"
      | AC |
    And owner click lanjutkan button for next steps
    And owner select size room "3 x 3"
    And owner input total room and room available as expected
      | total room | room available |
      | 9          | 5              |
    And owner click lanjutkan button for next steps
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 800000        | no                      |                   | no                |             |              |                     |                   |              |
    And owner click lanjutkan button for next steps
    Then verify the title on mamipay owner onboarding displayed
    When owner click Lanjutkan button
    And owner input on "nomor rekening Anda" "09182928329"
    And owner input on "nama pemilik rekening" "Omaiwa wo shinderu"
    And owner input on "nama bank" "BCA"
    And owner select bank name "BCA"
    And owner click "Kirim Data" button
    And owner click Selesai in success page add kos

  Scenario: Delete new kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed

  Scenario: Delete mamipay owner
    # Check if account has mamipay, if true then delete it
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to Mamipay Owner List
    And admin search owner phone "0812345670004" in mamipay owner list
    And admin delete the mamipay data from first list

  @CreateKosDraft @continue @TEST_LIMO-3681
  Scenario: Create new room type from "Buat baru" until draft
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0812345670004 | qwerty123 |
    And owner navigates to property saya kos
    And owner click "Nanti Saja" in kebijakan baru mamikos pop up
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner fills valid data kos as expected
      | kos name            | room type check | room type name | kos type | description kos              | build kos | other note                   |
      | Kost Draft Skip BBK | yes             | Tipe A         | girl     | Kos tanpa mamipay automation | 2020      | Akan dihapus setelah terbuat |
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
      | 11        | 10             |
    And owner click lanjutkan button for next steps
    And owner navigates to owner dashboard
    And owner navigates to property saya kos
    Then user see kos with valid name, status "Draft" and type "Kos Putri"

  @CreateKosFromDraft @TEST_LIMO-917
  Scenario: Owner wants to continue create kost with status "Draft" and skip mamipay
    Given owner search kos on property saya page
    When owner click "Lengkapi Data Kos" on kos draft
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 300000        | yes                     | Min. 1 Hari       | yes               | 50000       | 200000       | 800000              | 1700000           | 3000000      |
    And owner select additional price
    And owner input additional price
      | price name | price total |
      | Cuci Baju  | 10000       |
    And owner select down payment with "30%" from rent price
    And owner click lanjutkan button for next steps
    Then verify the title on mamipay owner onboarding displayed
    When owner click Lanjutkan button
    And owner click "Lewati" input BBK form request
    And owner click "Lewati" input BBK form request
    And owner click Selesai in success page add kos
    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Putri"

  Scenario: Delete new kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed

  Scenario: Delete mamipay owner
    # Check if account has mamipay, if true then delete it
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to Mamipay Owner List
    And admin search owner phone "0812345670004" in mamipay owner list
    And admin delete the mamipay data from first list

  @CreateNewKosMamipayNotActv @TEST_LIMO-975
  Scenario: Create new kost when user doesnt active mamipay
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0812345670004 | qwerty123 |
    And owner navigates to property saya kos
    And owner click "Nanti Saja" in kebijakan baru mamikos pop up
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner fills valid data kos as expected
      | kos name            | room type check | room type name | kos type | description kos              | build kos | other note                   |
      | Kost Auto NoMamipay | yes             | Tipe A         | girl     | Kos tanpa mamipay automation | 2020      | Akan dihapus setelah terbuat |
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
      | AC |
    And user check facilities under "Fasilitas Kamar Mandi"
      | Bathup |
      | Gayung |
    And user check facilities under "Parkir"
      | Parkir Mobil |
    And owner click lanjutkan button for next steps
    And owner select size room "3 x 3"
    And owner input total room and room available as expected
      | total room | room available |
      | 11         | 10             |
    And owner click lanjutkan button for next steps
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 300000        | yes                     | Min. 1 Hari       | yes               | 50000       | 200000       | 800000              | 1700000           | 3000000      |
    And owner select additional price
    And owner input additional price
      | price name | price total |
      | Cuci Baju  | 10000       |
    And owner select down payment with "30%" from rent price
    And owner click lanjutkan button for next steps
    Then verify the title on mamipay owner onboarding displayed
    When owner click Lanjutkan button
    And owner input on "nomor rekening Anda" "09182928329"
    And owner input on "nama pemilik rekening" "Omaiwa wo shinderu"
    And owner input on "nama bank" "BCA"
    And owner select bank name "BCA"
    And owner click "Kirim Data" button
    And owner click Selesai in success page add kos
    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Putri"

  Scenario: Delete new kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed

  Scenario: Delete mamipay owner
    # Check if account has mamipay, if true then delete it
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to Mamipay Owner List
    And admin search owner phone "0812345670004" in mamipay owner list
    And admin delete the mamipay data from first list

  @CreateKosNewTypeSkipMamipay @TEST_LIMO-916
  Scenario: Owner create new kos but skip fill mamipay data at form Lengkapi Data Diri && skip at page "Tanya Jawab"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0812345670004 | qwerty123 |
    And owner navigates to property saya kos
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner fills valid data kos as expected
      | kos name            | room type check | room type name | kos type | description kos              | build kos | other note                   |
      | Kost Auto Skip Mami | yes             | Tipe A         | girl     | Kos tanpa mamipay automation | 2020      | Akan dihapus setelah terbuat |
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
      | AC |
    And user check facilities under "Fasilitas Kamar Mandi"
      | Bathup |
      | Gayung |
    And user check facilities under "Parkir"
      | Parkir Mobil |
    And owner click lanjutkan button for next steps
    And owner select size room "3 x 3"
    And owner input total room and room available as expected
      | total room | room available |
      | 11         | 10             |
    And owner click lanjutkan button for next steps
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 300000        | yes                     | Min. 1 Hari       | yes               | 50000       | 200000       | 800000              | 1700000           | 3000000      |
    And owner select additional price
    And owner input additional price
      | price name | price total |
      | Cuci Baju  | 10000       |
    And owner select down payment with "30%" from rent price
    And owner click lanjutkan button for next steps
    Then verify the title on mamipay owner onboarding displayed
    When owner click Lanjutkan button
    And owner click "Lewati" input BBK form request
    And owner click "Lewati" input BBK form request
    And owner click Selesai in success page add kos
    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Putri"

  Scenario: Delete new kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed

  Scenario: Delete mamipay owner
    # Check if account has mamipay, if true then delete it
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to Mamipay Owner List
    And admin search owner phone "0812345670004" in mamipay owner list
    And admin delete the mamipay data from first list

  @CreateKosFromDraftActivMamipay @TEST_LIMO-981
  Scenario: Create kos from kos with status draft && user doesn't active mamipay
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0812345670004 | qwerty123 |
    And owner navigates to property saya kos
    And owner click "Nanti Saja" in kebijakan baru mamikos pop up
    And owner click tambah data iklan "Kost"
    And owner click "Tambah Kos Baru"
    And owner fills valid data kos as expected
      | kos name            | room type check | room type name | kos type | description kos                  | build kos | other note |
      | kost Draft Mamipayy | yes             | Tipe A         | boy      | kos harusnya jadi draft then kos | 2020      |            |
    And owner set rules kos:
      | Dilarang bawa hewan |
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
      | AC |
    And user check facilities under "Fasilitas Kamar Mandi"
      | Bathup |
      | Gayung |
    And user check facilities under "Parkir"
      | Parkir Mobil |
    And owner click lanjutkan button for next steps
    And owner select size room "3 x 3"
    And owner input total room and room available as expected
      | total room | room available |
      | 11         | 10             |
    And owner click lanjutkan button for next steps
    And owner navigates to owner dashboard
    And owner navigates to property saya kos
    Then user see kos with valid name, status "Draft" and type "Kos Putra"
    #continue create kos draft
    When owner search kos on property saya page
    And owner click "Lengkapi Data Kos" on kos draft
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 300000        | yes                     | Min. 1 Hari       | yes               | 50000       | 200000       | 800000              | 1700000           | 3000000      |
    And owner click lanjutkan button for next steps
    Then verify the title on mamipay owner onboarding displayed
    When owner click Lanjutkan button
    And owner input on "nomor rekening Anda" "09182928329"
    And owner input on "nama pemilik rekening" "Omaiwa wo shinderu"
    And owner input on "nama bank" "BCA"
    And owner select bank name "BCA"
    And owner click "Lewati" button
    And owner click "Lewati" button
    And owner click done in success page
    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Putra"

  @CreateKosFromDraftActivMamipay
  Scenario: Delete new kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed

  @CreateKosFromDraftActivMamipay
  Scenario: Delete mamipay owner
    # Check if account has mamipay, if true then delete it
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to Mamipay Owner List
    And admin search owner phone "0812345670004" in mamipay owner list
    And admin delete the mamipay data from first list