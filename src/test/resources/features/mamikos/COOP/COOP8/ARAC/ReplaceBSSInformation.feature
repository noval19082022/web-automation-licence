@regression @replaceBSSInfo @BBM8

Feature: Replace BSS Information

  @TEST_COOP-935
  Scenario: Check Calendar if there is any vacant rooms today
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891111020198 | 0891111020198 | mamikosqa123 |
    And tenant search kost then go to kost details:
      | kost name stag                                 | kost name prod               |
      | Kost General Irvi Automation Abiansemal Badung | Kost General Irvi Automation |
    And tenant open calendar from kost detail
    Then tenant will see BSS Information "Berikut adalah tanggal check-in (mulai ngekos) yang tersedia."

  @TEST_COOP-783
  Scenario: Check the earliest availability kost if the earliest available room to sell is today and BSS Waktu masuk kos terdekat setelah booking is 0 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner click on dropdown rules enter kos button
    And user click on "Ubah waktu" button
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
    And tenant search kost then go to kost details:
      | kost name stag                               | kost name prod         |
      | Kost Primaya Tangerang Pasar Kemis Tangerang | Dont Starve To Get Her |
    And tenant booking kost
    Then tenant should success booking kost

  @TEST_COOP-813
  Scenario: BSS Waktu masuk kos terdekat setelah booking is 8 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner click on dropdown rules enter kos button
    And user click on "Ubah waktu" button
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
    And tenant search kost then go to kost details:
      | kost name stag                               | kost name prod         |
      | Kost Primaya Tangerang Pasar Kemis Tangerang | Dont Starve To Get Her |
    Then tenant see today's date and cannot make booking

  @TEST_COOP-795
  Scenario: Check the latest availability kos if BSS Waktu masuk kos terjauh setelah booking is 3 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner click on dropdown rules enter kos button
    And user click on "Ubah waktu" button
    And owner click on toggle pengajuan dan waktu masuk kos if active
    And owner click on dropdown waktu masuk kos
    And user click on "3" button
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
    And tenant search kost then go to kost details:
      | kost name stag                               | kost name prod         |
      | Kost Primaya Tangerang Pasar Kemis Tangerang | Dont Starve To Get Her |
    Then tenant see today's date and cannot make booking

  @TEST_COOP-792
  Scenario: Check the latest availability kos if BSS Waktu masuk kos terjauh setelah booking is 3 weeks
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner click on dropdown rules enter kos button
    And user click on "Ubah waktu" button
    And owner click on toggle pengajuan dan waktu masuk kos if active
    And owner click on dropdown jarak waktu terjauh
    And user click on "3" button
    And owner click on simpan button on popup total day
    And owner click on dropdown satuan waktu
    And user click on "Minggu" button
    And owner click on simpan button on popup satuan waktu
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
    And tenant search kost then go to kost details:
      | kost name stag                               | kost name prod         |
      | Kost Primaya Tangerang Pasar Kemis Tangerang | Dont Starve To Get Her |
    Then tenant can choose checkin date in the next "1" month

  @TEST_COOP-916
  Scenario: Check the latest availability kos if BSS Waktu masuk kos terjauh setelah booking is 5 month
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod    | password  |
      | 085697344170 | 0891111020198 | qwerty123 |
    And owner navigate to rules enter kos
    And owner click on dropdown rules enter kos button
    And user click on "Ubah waktu" button
    And owner click on toggle pengajuan dan waktu masuk kos if active
    And owner click on dropdown jarak waktu terjauh
    And user click on "5" button
    And owner click on simpan button on popup total day
    And owner click on dropdown satuan waktu
    And user click on "Bulan" button
    And owner click on simpan button on popup satuan waktu
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
    And tenant search kost then go to kost details:
      | kost name stag                               | kost name prod         |
      | Kost Primaya Tangerang Pasar Kemis Tangerang | Dont Starve To Get Her |
    Then tenant can choose checkin date in the next "4" month

