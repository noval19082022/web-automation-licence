@regression @manageBooking @hubungiKostDetail @OB @booking @SS6
Feature: OB Booking From Hubungi Kost

  @continue
  Scenario: Admin Batalkan Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin search contract by tenant phone number:
      | phone stag  | phone prod    |
      | 08922024500 | 0890000000314 |
    And admin akhiri contract
    Then admin should success terminate contract

  @continue
  Scenario: Cancel Booking if Tenant Have Booking
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod    | password  |
      | 08922024500 | 0890000000314 | qwerty123 |
    And user cancel booking

  @TEST_COOP-1995
  Scenario: OB Booking Hubungi Kost From Detail Kost
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                                                                                     | kost path prod               |
      | kost-kabupaten-halmahera-utara-kost-campur-murah-kost-bima-booking-dp-biaya-lain-dan-denda-automation-tobelo-utara-halmahera-utara | Kos DC BAR Automation Tipe A |
    And tenant dismiss FTUE booking benefit
    And user click chat in kos detail
    And user select question "Saya butuh cepat nih. Bisa booking sekarang?"
    And tenant click button ajukan sewa from chat popup
    Then it will redirect to Booking page
