@SS6 @tikiTaka
Feature: Tiki Taka - Bank Account

  Background: Terminated contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag | phone prod |
      | 0816000001 | 0816000001 |

  @TEST_SS-4300 @TEST_SS-4302 @TEST_SS-4301
  Scenario: [WEB][Ajukan Berhenti Sewa] Check Bank account form for Kost P1 have Deposit
    Given user go to mamikos homepage
    Then user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0816000001 | 0816000001 | qwerty123 |
    And user cancel booking
    When tenant redirect to kost details:
      | kost path stag                                                                                            | kost path prod               |
      | kost-kabupaten-ogan-ilir-kost-campur-eksklusif-kost-fahmi-singgahsini-pertama-indralaya-utara-ogan-ilir-1 | Kos DC BAR Automation Tipe A |
    And tenant booking kost for "today"
    And user go to mamikos homepage
    And user logs out as a Tenant user
    Then user login as owner:
      | phone stag   | phone prod    | password  |
      | 085312345690 | 0890000000289 | qwerty123 |
    And owner navigates to owner dashboard
    And owner accept booking from tenant:
      | tenant stag    | tenant prod        |
      | Akun Tiki taka | Hagaromo Otsutsuki |
    Then owner should redirect back to pengajuan booking page
    And owner navigates to owner dashboard
    Then owner logs out

#  @TEST_SS-4300
#  Scenario: [WEB][Ajukan Berhenti Sewa] Check Bank account form for Kost P1 have Deposit
    When user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0816000001 | 0890867321212 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0816000001" without close the page
    And tenant close unused browser tab
    When user go to mamikos homepage
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    Then tenant navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    Then tenant can see "Pastikan data rekening diisi dengan benar, agar tidak terjadi salah transfer." on bank account section
    When tenant can see "Nama bank*" on bank account section
    Then tenant can see "Nomor rekening*" on bank account section
    When tenant can see "Nama pemilik rekening*" on bank account section
    And user click review kost
    And user input review kost with rating 5:
      | review stop rent stag       |
      | Kost sangat aman dan bersih |
    And user stop rent kost with reason "Alasan Pribadi" and subreason "-"
    And user click ajukan berhenti sewa on kontrak saya after input data diri

#  @TEST_SS-4302
#  Scenario: [WEB][Ajukan Berhenti Sewa] Confirmation Pop Up - Confirm
    Then tenant can see popup with:
      | Nama bank | Nomor rekening | Nama pemilik rekening |
      | BCA       | 9900090900     | Akun Tiki Taka        |

#  @TEST_SS-4301
#  Scenario: [WEB][Ajukan Berhenti Sewa] Cancel ajukan berhenti sewa submitted
    And tenant click on "Kembali ke form" button on popup confirmation
    Then tenant can see "Nama bank*" on bank account section
    When tenant can see "Nomor rekening*" on bank account section
    Then tenant can see "Nama pemilik rekening*" on bank account section
    And user click ajukan berhenti sewa on kontrak saya after input data diri
    And tenant click on "Kirim form ke pemilik" button on popup confirmation
    When tenant navigate to kontrak kost saya
    Then tenant can see "Diajukan pada 20 Mei 2024. Deposit akan ditransfer maksimal H+7 setelah pemilik " on bank account section

  @TEST_SS-4858 @TEST_SS-4864
  Scenario: Booking and confirm booking
    Given user go to mamikos homepage
    Then user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0816000001 | 0816000001 | qwerty123 |
    And user cancel booking
    When tenant redirect to kost details:
      | kost path stag                                                       | kost path prod               |
      | kost-kost-campur-murah-kost-scenario-tujuh-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
    And tenant booking kost for "today"
    And user go to mamikos homepage
    And user logs out as a Tenant user
    Then user login as owner:
      | phone stag   | phone prod   | password  |
      | 087800001007 | 087800001007 | qwerty123 |
    And owner navigates to owner dashboard
    And owner accept booking from tenant:
      | tenant stag    | tenant prod        |
      | Akun Tiki taka | Hagaromo Otsutsuki |
    Then owner should redirect back to pengajuan booking page
    And owner navigates to owner dashboard
    Then owner logs out

#  @TEST_SS-4858
#  Scenario: Tenant paid invoice
    When user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0816000001 | 0890867321212 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "0816000001" without close the page
    And tenant close unused browser tab
    When user go to mamikos homepage
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    Then tenant navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    Then tenant cannot see "Pastikan data rekening diisi dengan benar, agar tidak terjadi salah transfer." on bank account section
    And user click review kost
    And user input review kost with rating 5:
      | review stop rent stag       |
      | Kost sangat aman dan bersih |
    And user stop rent kost with reason "Alasan Pribadi" and subreason "-"
    And user click ajukan berhenti sewa on kontrak saya after input data diri
    Then tenant can see "Pastikan form sudah diisi dengan benar untuk memudahkan pemilik melakukan konfirmasi." on bank account section
    And tenant click on "Kirim form ke pemilik" button on popup confirmation
    And tenant navigate to kontrak kost saya
