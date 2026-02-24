@SS15 @billingTrackerFull
Feature: Update Billing tracker flow

  Scenario: Terminated contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag  | phone prod |
      | 08100000214 | 0816000001 |

  Scenario: Booking and confirm kost
    Given user go to mamikos homepage
    Then user login as tenant via phone number:
      | phone stag  | phone prod | password  |
      | 08100000214 | 0816000001 | qwerty123 |
    And user cancel booking
    And user go to mamikos homepage
    When tenant redirect to kost details:
      | kost path stag                                                                                | kost path prod                                           |
      | kost-kabupaten-sidoarjo-kost-campur-murah-kost-singgahsini-bundaran-aloha-superior-sidoarjo-2 | kost lombok homepage reject Tobelo Utara Halmahera Utara |
    And user dismiss FTUE booking benefit
    And tenant booking kost for "today"
    And user go to mamikos homepage
    And user logs out as a Tenant user
    Then admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to data booking menu
    And admin show filter data booking
    And admin filter data booking by tenant phone number:
      | Tenant Phone | Kos Type |
      | 08100000214  | All      |
    And admin click actions button on booking list
    And admin accept booking for kost add fee
    And admin click on next button accept booking for kost add fee

#    Tenant paid invoice
  Scenario: tenant paid invoice
    When user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag  | phone prod    | password  |
      | 08100000214 | 0890867321212 | qwerty123 |
    And tenant navigate to riwayat and draf booking
    And tenant pay kost from riwayat booking using ovo "08100000214" without close the page
    And tenant close unused browser tab
    When user go to mamikos homepage
    And tenant navigate to riwayat and draf booking
    And tenant checkin kost from riwayat booking
    Then tenant navigate to kontrak kost saya
    And user logs out as a Tenant user

#      tenant check data on billing tracker
  @SS-4375 @continue
  Scenario: check data on billing tracker and filter with aktif contract status
    When admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to billing tracker
    And admin clicks on next month in calendar
    And admin search billing tracker by "No. HP Penyewa" and "08100000214"
    And admin filter contract status with "Aktif"
    Then admin can see contract status with "Aktif"

  @SS-5081 @continue
  Scenario: [Billing Tracker][Notes]Create notes on invoice
    When admin can see "Tambah Catatan" button
    And admin fill notes tracker with:
      | type             | notes         |
      | Refund (garansi) | updated again |
    Then admin can see notes with:
      | type             | notes         |
      | Refund (garansi) | updated again |


  @SS-5082 @continue
  Scenario: [Billing Tracker][Notes]Create notes for tag = Blast
    And admin fill notes tracker with:
      | type  | notes             |
      | Blast | Tutup jam 9 malam |
    Then admin can see notes with:
      | type             | notes             |
      | Refund (garansi) | updated again     |
      | Blast            | Tutup jam 9 malam |

  @SS-4309 @continue
  Scenario: [Billing Tracker][Notes]Create notes for many tag on 1 invoice
    And admin fill notes tracker with:
      | type           | notes              |
      | Input cash out | cash out tanggal 5 |
    Then admin can see notes with:
      | type           | notes              |
      | Input cash out | cash out tanggal 5 |
      | Blast          | Tutup jam 9 malam  |
    And admin click on Lihat lebih banyak catatan note dropdown
    Then admin can see notes with:
      | type             | notes              |
      | Input cash out   | cash out tanggal 5 |
      | Blast            | Tutup jam 9 malam  |
      | Refund (garansi) | updated again      |

  @SS-5083 @continue
  Scenario: [Billing Tracker][Notes]Check the display when invoice have many notes > 2 noted
    When admin click on reset button
    And admin clicks on next month in calendar
    And admin search billing tracker by "No. HP Penyewa" and "08100000214"
    And admin filter contract status with "Aktif"
    When admin fill notes tracker with:
      | type               | notes                        |
      | Pindah jatuh tempo | jatuh tempo pindah tanggal 5 |
    And admin click on Lihat lebih banyak catatan note dropdown
    Then admin can see notes with:
      | type               | notes                        |
      | Refund (garansi)   | updated again                |
      | Blast              | Tutup jam 9 malam            |
      | Input cash out     | cash out tanggal 5           |
      | Pindah jatuh tempo | jatuh tempo pindah tanggal 5 |

  @SS-5086 @continue @SS-4308
  Scenario: [Billing Tracker][Notes]Edit notes
    And admin edit note "Pindah tipe kamar"
    Then admin can see notes with:
      | type              | notes             |
      | Pindah tipe kamar | updated again     |
      | Blast             | Tutup jam 9 malam |

  @SS-4310 @continue
  Scenario: [Billing Tracker][Notes]Check notes for many tag on 1 invoice
    When admin click on reset button
    And admin clicks on next month in calendar
    And admin search billing tracker by "No. HP Penyewa" and "08100000214"
    And admin filter contract status with "Aktif"
    And admin click on Lihat lebih banyak catatan note dropdown
    Then admin can see notes with:
      | type              | notes                        |
      | Pindah tipe kamar | jatuh tempo pindah tanggal 5 |
      | Input cash out    | cash out tanggal 5           |
      | Blast             | Tutup jam 9 malam            |
      | Refund (garansi)  | updated again                |
    When admin can see "Sembunyikan" button

  Scenario: tenant ajukan berhenti sewa
    When user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag  | phone prod    | password  |
      | 08100000214 | 0890867321212 | qwerty123 |
    Then tenant navigate to kontrak kost saya
    And user click ajukan berhenti sewa on kontrak saya page
    And user click review kost
    And user input review kost with rating 5:
      | review stop rent stag       |
      | Kost sangat aman dan bersih |
    And user stop rent kost with reason "Lingkungan" and subreason "Tidak aman"
    And user click ajukan berhenti sewa on kontrak saya after input data diri
    And tenant click on "Kirim form ke pemilik" button on popup confirmation
    When tenant navigate to kontrak kost saya
    And user logs out as a Tenant user

  @SS-4376 @continue
  Scenario: [Billing Tracker][Productivity] Check filter combination contract status Ajukan Checkout
    When admin go to pms singgahsini
    And admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to billing tracker
    And admin clicks on next month in calendar
    And admin search billing tracker by "No. HP Penyewa" and "08100000214"
    And admin filter contract status with "Ajukan Check-out"
    Then admin can see contract status with "Ajukan Check-out"

  @SS-4361 @continue
  Scenario: [Billing Tracker][Productivity] Check contract when tenant request terminated contract
    When admin click on reset button
    And admin clicks on next month in calendar
    And admin filter contract status with "Ajukan Check-out"
    Then admin can see contract status with "Ajukan Check-out"

  @SS-4372 @continue
  Scenario: [Billing Tracker][Productivity] Check filter combination contract status Ajukan Check-out + Sudah Check-out
    When admin can see contract status with "Ajukan Check-out"
    And admin filter contract status with "Sudah Check-out"
    Then admin can see contract status with "Sudah Check-out"

  @SS-4368 @continue
  Scenario: [Billing Tracker][Productivity] Check filter combination contract status Ajukan Check-out + Aktif + Sudah Check-out
    And admin click on reset button
    And admin clicks on next month in calendar
    And admin filter contract status with "Ajukan Check-out"
    When admin can see contract status with "Ajukan Check-out"
    And admin filter contract status with "Sudah Check-out"
    And admin click on pagination
    Then admin can see contract status with "Sudah Check-out"
    And admin filter contract status with "Aktif"
    Then admin can see contract status with "Aktif"

  @SS-4378 @continue
  Scenario: [Billing Tracker][Productivity] Check filter combination contract status Sudah Checkout
    When admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag  | phone prod |
      | 08100000214 | 0816000001 |
    When admin go to pms singgahsini
    And admin go to billing tracker
    And admin clicks on next month in calendar
    And admin search billing tracker by "No. HP Penyewa" and "08100000214"
    And admin filter contract status with "Sudah Check-out"
    Then admin can see contract status with "Sudah Check-out"

  @SS-4367 @continue
  Scenario: Billing Tracker][Productivity] Check filter combination contract status Sudah Check-out + phone number
    And admin click on reset button
    And admin clicks on next month in calendar
    And admin search billing tracker by "No. HP Penyewa" and "08100000214"
    And admin filter contract status with "Sudah Check-out"
    Then admin can see contract status with "Sudah Check-out"
    And admin can see phone number with "08100000214"

  @SS-4373 @continue
  Scenario: [Billing Tracker][Productivity] Check filter combination contract status Aktif + Sudah checkout
    When admin click on reset button
    And admin clicks on next month in calendar
    And admin filter contract status with "Aktif"
    And admin filter contract status with "Sudah Check-out"
    Then admin can see contract status with "Aktif"
    And admin click on pagination
    Then admin can see contract status with "Sudah Check-out"

  @SS-4363 @continue
  Scenario: [Billing Tracker][Productivity] Check filter result for contract status
    When admin click on reset button
    And admin filter contract status with "Aktif"
    Then admin can see contract status with "Aktif"

  @SS-4360 @continue
  Scenario:[Billing Tracker][Productivity] Check contract status active for next month on billing tracker
    When admin click on reset button
    And admin clicks on next month in calendar
    And admin filter contract status with "Aktif"
    Then admin can see contract status with "Aktif"

  @SS-4359 @continue
  Scenario: [Billing Tracker][Productivity] Check contract status column on billing tracker page
    Then admin can see contract status with "Aktif"

  @SS-4362
  Scenario: [Billing Tracker][Productivity] Check filter contract status
    When admin click on reset button
    And admin clicks on Filter button
    And admin can see contract status filtering with:
      | status           |
      | Aktif            |
      | Ajukan Check-out |
      | Akan Check-out   |
      | Sudah Check-out  |