@DOM4
Feature: FTUE Booking Benefit

  @ftuebookingbenefit @continue @TEST_COOP-5659
  Scenario: User Can See FTUE Booking Benefit
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag               | kost name prod               |
      | Kos Dom Automation PLM Tipe E Kretek Bantul | Kos DC BAR Automation Tipe A |
    Then tenant can see FTUE booking benefit with wording:
      | Hanya butuh 4 langkah untuk booking kos tanpa harus ketemu pemilik kos.                    |
      | Udah ngerasa ada kosan yang cocok? Klik “Ajukan Sewa” buat mengajukan sewa ke pemilik kos. |
      | Bantu pemilik kos mengenalimu. Isi data diri dan perkiraan kapan kamu mulai sewa kos.      |
      | Setelah ajukan sewa, kamu bakal dikabari pemilik kos apakah kamu bisa ngekos di tempatnya. |
      | Hore! Pemilik kos siap menerimamu! Segera lakukan pembayaran sebelum kedaluwarsa ya.       |
      | Setelah pembayaran diterima pemilik, kamar kos sudah siap kamu huni.                       |

  @ftuebookingbenefit @TEST_COOP-5662
  Scenario: User Can Use Button On FTUE Booking Benefit
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                              | kost name prod               |
      | Kos Dom Automation PLM Tipe E Kretek Bantul | Kos DC BAR Automation Tipe A |
    When user dismiss FTUE booking benefit
    Then user can not see FTUE booking benefit

  @ftuebookingbenefit1 @TEST_COOP-5660
  Scenario: User Can Still See FTUE For The Second Time Visit To Other Kost Without Dismissing FTUE Booking Benefit
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                              | kost name prod               |
      | Kos Dom Automation PLM Tipe E Kretek Bantul | Kos DC BAR Automation Tipe A |
    And tenant can see FTUE booking benefit with wording:
      | Hanya butuh 4 langkah untuk booking kos tanpa harus ketemu pemilik kos.                    |
      | Udah ngerasa ada kosan yang cocok? Klik “Ajukan Sewa” buat mengajukan sewa ke pemilik kos. |
      | Bantu pemilik kos mengenalimu. Isi data diri dan perkiraan kapan kamu mulai sewa kos.      |
      | Setelah ajukan sewa, kamu bakal dikabari pemilik kos apakah kamu bisa ngekos di tempatnya. |
      | Hore! Pemilik kos siap menerimamu! Segera lakukan pembayaran sebelum kedaluwarsa ya.       |
      | Setelah pembayaran diterima pemilik, kamar kos sudah siap kamu huni.                       |
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    Then tenant can see FTUE booking benefit with wording:
      | Hanya butuh 4 langkah untuk booking kos tanpa harus ketemu pemilik kos.                    |
      | Udah ngerasa ada kosan yang cocok? Klik “Ajukan Sewa” buat mengajukan sewa ke pemilik kos. |
      | Bantu pemilik kos mengenalimu. Isi data diri dan perkiraan kapan kamu mulai sewa kos.      |
      | Setelah ajukan sewa, kamu bakal dikabari pemilik kos apakah kamu bisa ngekos di tempatnya. |
      | Hore! Pemilik kos siap menerimamu! Segera lakukan pembayaran sebelum kedaluwarsa ya.       |
      | Setelah pembayaran diterima pemilik, kamar kos sudah siap kamu huni.                       |

  @ftuebookingbenefit @TEST_COOP-5663
  Scenario: User Can Not See FTUE For The Second Time Visit To Other Kost After Dismissing FTUE Booking Benefit
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                              | kost name prod                                      |
      | Kos Dom Automation PLM Tipe A Kretek Bantul | Kos BX Automation PLM Tipe A Tobelo Halmahera Utara |
    When user dismiss FTUE booking benefit
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag       | kost name prod               |
      | Kose Full Automation | Kost Automation Putri Tobelo |
    Then user can not see FTUE booking benefit

  @ftuebookingbenefit @TEST_COOP-5661
  Scenario: User Can Not See FTUE For Non BBK Kos
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag     | kost name prod             |
      | Kost BG Automation | Kost Dumbledore Automation |
    Then user can not see FTUE booking benefit

  @ftuebookingbenefit @TEST_COOP-1714
  Scenario: User Can Not See FTUE Booking Benefit On Apartment Details
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And user go to apartment details from apartment landing list number 1
    And tenant set active page to 0
    Then user can not see FTUE booking benefit