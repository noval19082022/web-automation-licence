@regression @LIMO3 @listing-monetization @manageBookingAndBilling

Feature: Manage Booking And Billing

  @notregisteredmamipay
  Scenario: Manage Booking And Bills Menu - Not Registered Mamipay
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password    |
      | 083320000003 | mamikos2020 |
    Then verify info untuk anda Auto BBK is displayed
    When owner click "Lengkapi Data Diri" button
    Then verify form "Lengkapi data diri Anda" for Auto BBK
    When owner go back to previous page

  @donthavekos
  Scenario: Manage Booking And Bills Menu - Registered Mamipay but don't have kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password    |
      | 08211223344512 | qwerty123 |
    Then verify info untuk anda Auto BBK not displayed
    When owner navigates to property saya kos
    Then verify tambah data pop up is appear
    When owner click "Batal" button
    Then owner will see that the text "Data iklan milik Anda belum ditemukan. Silakan cari atau tambahkan iklan baru." is displayed

  @notactivatebooking
  Scenario: Manage Booking And Bills Menu - Registered Mamipay, have kost but not yet activate booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password    |
      | 0812345670003| qwerty123 |
    Then verify info untuk anda Auto BBK not displayed
    When owner navigates to property saya kos
    Then owner verify Auto BBK pop up is displayed
    When owner click "Pelajari Booking Langsung"
    Then verify the title on mamipay owner onboarding displayed
    When owner go back to previous page
    Then owner will see that the text "Lengkapi Data Pribadi" is displayed
    When owner click "Edit Data Pribadi"
    Then verify the title on mamipay owner onboarding displayed

  @allactive
  Scenario: Manage Booking And Bills Menu - Registered Mamipay, have kost and have activate booking
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password    |
      | 087133998156 | qwerty123 |
    Then verify info untuk anda Auto BBK not displayed
    When owner navigates to property saya kos
    Then owner verify Auto BBK pop up is not displayed
    And verify kos is "Aktif"