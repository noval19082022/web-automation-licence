@QAT-2313
Feature: Booking with upload docs

  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And user cancel booking

  Scenario: [Kost Detail][Booking Form][Peraturan Kost][Booking Form ke 2][Summary Booking]Tenant booking for kost when Owner set ON Khusus Karyawan, ON Bisa Pasutri, and ON Boleh bawa anak and with set ON KTP, buku nikah, kartu keluarga
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag          | kost name prod       |
      | Desta Automation tobelo | kost payment desta 2 |
    And user want to dismiss FTUE
    Then user will see rule "Maks. 4"
    * user will see rule "Boleh pasutri"
    * user will see rule "Bawa anak"
    * user will see rule "Wajib sertakan kartu keluarga saat pengajuan sewa"
    * user will see rule "Khusus karyawan"
    * user will see rule "Calon penyewa wajib sertakan KTP."
    * user will see rule "Calon penyewa pasutri wajib sertakan buku nikah."
    When user sees form booking duration
    And user select date "tomorrow" and rent type "Per bulan"
    Then user want to booking this kos
    * user will see Jumlah Penyewa can add until 3 Penyewa
    * user will see enable and tick Check box "Membawa suami/istri"
    * user will see enable and tick Check box "Membawa anak"
    When user want to upload berkas wajib if user haven't upload it
    Then user can set Ajukan Sewa

##  ------------Check on owner-------------
  Scenario: Check on owner
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
#    And user check on booking detail at Pengajuan booking
#    Then user will see Jumlah penyewa 4 at Jumlah Penyewa section
#    And user will see Membawa suami/istri and Membawa anak at Jumlah Penyewa
#    And user will see KTP photo on detail booking