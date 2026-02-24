@SS6
Feature: BnB feature with background go to kos saya page

  @TEST_SS-3523
  Scenario: [Kos Saya][Chat Pemilik]Check Chat Pemilik on kost saya page (BBM-912)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod  | password  |
      | 0892202303 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on masukkan kode dari pemilik button
    And user input valid unique code "DSQ641" and click Kirim Kode unik button
    Then user check verification tenant phone number at owner and tenant phone number at kos saya

  @TEST_SS-3502
  Scenario: [Tenant side - Kost saya][Verify phone number]Tenant input valid unique code if tenant not verification phone number, but tenant Cancel verification phone number
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod  | password  |
      | 0892202303 | 08100000622 | qwerty123 |
    And user navigate to kost saya page
    And user click on masukkan kode dari pemilik button
    And user input valid unique code "DSQ641" and click Kirim Kode unik button
    Then user check verification tenant phone number at owner and tenant phone number at kos saya
    And user click on kirim OTP button
    And user click on verification via SMS
    And user click All Back button until first page
    Then user will see kos saya is still empty