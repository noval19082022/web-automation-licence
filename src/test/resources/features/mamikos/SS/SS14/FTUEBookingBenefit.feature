@SS12 @DONE_SEARCH_MIGRATE
Feature: FTUE Booking Benefit

  @ftuebookingbenefit @continue @TEST_SS-3257
  Scenario: User Can See FTUE Booking Benefit
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod               |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-e-kretek-bantul | Kos DC BAR Automation Tipe A |
    Then tenant can see FTUE booking benefit with wording:
      | Hanya butuh 4 langkah untuk booking kos tanpa harus ketemu pemilik kos.                    |
      | Udah ngerasa ada kosan yang cocok? Klik “Ajukan Sewa” buat mengajukan sewa ke pemilik kos. |
      | Bantu pemilik kos mengenalimu. Isi data diri dan perkiraan kapan kamu mulai sewa kos.      |
      | Setelah ajukan sewa, kamu bakal dikabari pemilik kos apakah kamu bisa ngekos di tempatnya. |
      | Hore! Pemilik kos siap menerimamu! Segera lakukan pembayaran sebelum kedaluwarsa ya.       |
      | Setelah pembayaran diterima pemilik, kamar kos sudah siap kamu huni.                       |

  @ftuebookingbenefit @TEST_SS-3258
  Scenario: User Can Use Button On FTUE Booking Benefit
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod               |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-e-kretek-bantul | Kos DC BAR Automation Tipe A |
    When user dismiss FTUE booking benefit
    Then user can not see FTUE booking benefit

  @ftuebookingbenefit1 @TEST_SS-3254
  Scenario: User Can Still See FTUE For The Second Time Visit To Other Kost Without Dismissing FTUE Booking Benefit
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod               |
      | kost-kabupaten-bantul-kost-putri-eksklusif-kos-dom-automation-plm-tipe-e-kretek-bantul | Kos DC BAR Automation Tipe A |
    And tenant can see FTUE booking benefit with wording:
      | Hanya butuh 4 langkah untuk booking kos tanpa harus ketemu pemilik kos.                    |
      | Udah ngerasa ada kosan yang cocok? Klik “Ajukan Sewa” buat mengajukan sewa ke pemilik kos. |
      | Bantu pemilik kos mengenalimu. Isi data diri dan perkiraan kapan kamu mulai sewa kos.      |
      | Setelah ajukan sewa, kamu bakal dikabari pemilik kos apakah kamu bisa ngekos di tempatnya. |
      | Hore! Pemilik kos siap menerimamu! Segera lakukan pembayaran sebelum kedaluwarsa ya.       |
      | Setelah pembayaran diterima pemilik, kamar kos sudah siap kamu huni.                       |
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-a-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then tenant can see FTUE booking benefit with wording:
      | Hanya butuh 4 langkah untuk booking kos tanpa harus ketemu pemilik kos.                    |
      | Udah ngerasa ada kosan yang cocok? Klik “Ajukan Sewa” buat mengajukan sewa ke pemilik kos. |
      | Bantu pemilik kos mengenalimu. Isi data diri dan perkiraan kapan kamu mulai sewa kos.      |
      | Setelah ajukan sewa, kamu bakal dikabari pemilik kos apakah kamu bisa ngekos di tempatnya. |
      | Hore! Pemilik kos siap menerimamu! Segera lakukan pembayaran sebelum kedaluwarsa ya.       |
      | Setelah pembayaran diterima pemilik, kamar kos sudah siap kamu huni.                       |

  @ftuebookingbenefit @TEST_SS-3278
  Scenario: User Can Not See FTUE For The Second Time Visit To Other Kost After Dismissing FTUE Booking Benefit
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                          | kost path prod                                      |
      | kost-kabupaten-bantul-kost-campur-eksklusif-kos-dom-automation-plm-tipe-a-kretek-bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    When user dismiss FTUE booking benefit
    Given user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag       | kost path prod               |
      | Kose Full Automation | Kost Automation Putri Tobelo |
    Then user can not see FTUE booking benefit

  @ftuebookingbenefit @TEST_SS-3255
  Scenario: User Can Not See FTUE For Non BBK Kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                         | kost path prod             |
      | kost-sorong-kost-campur-eksklusif-kost-bg-automation-1 | Kost Dumbledore Automation |
    Then user can not see FTUE booking benefit

  @ftuebookingbenefit @TEST_SS-3256
  Scenario: User Can Not See FTUE Booking Benefit On Apartment Details
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344570 | 083176408442 | qwerty123 |
    And user go to apartment details from apartment landing list number 1
    And tenant set active page to 0
    Then user can not see FTUE booking benefit