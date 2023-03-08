@DOM4
Feature: FTUE Booking Benefit

  @ftuebookingbenefit @continue
  Scenario: User Can See FTUE Booking Benefit
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081223344550 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag       | kost name prod               |
      | Kose Full Automation | Kost Automation Putri Tobelo |
    Then tenant can see FTUE booking benefit with wording:
      | Hanya butuh 4 langkah untuk booking kos tanpa harus ketemu pemilik kos.                    |
      | Udah ngerasa ada kosan yang cocok? Klik “Ajukan Sewa” buat mengajukan sewa ke pemilik kos. |
      | Bantu pemilik kos mengenalimu. Isi data diri dan perkiraan kapan kamu mulai sewa kos.      |
      | Setelah ajukan sewa, kamu bakal dikabari pemilik kos apakah kamu bisa ngekos di tempatnya. |
      | Hore! Pemilik kos siap menerimamu! Segera lakukan pembayaran sebelum kedaluwarsa ya.       |
      | Setelah pembayaran diterima pemilik, kamar kos sudah siap kamu huni.                       |

  @ftuebookingbenefit
  Scenario: User Can Use Button On FTUE Booking Benefit
    When user dismiss FTUE booking benefit
    Then user can not see FTUE booking benefit