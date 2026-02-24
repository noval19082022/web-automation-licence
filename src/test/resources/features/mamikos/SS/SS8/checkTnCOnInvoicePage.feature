@SS7
Feature: [TnC Invoice][Detail Invoice] Check TnC Invoice on Invoice Page

  @TEST_SS-3404
  Scenario: Check TnC Invoice on Invoice Page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0891112020198 | 0891112020198 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    And tenant make bill payments using "Kartu Kredit"
    Then tenant can see TnC "Dengan menekan tombol Bayar Sekarang Anda telah menyetujui Syarat dan Ketentuan Umum dan akan membayar Total Pembayaran tertera di atas." on invoice
    When tenant click text Syarat dan Ketentuan Umum on invoice
    And tenant set active page to 2
    Then user should redirect to link "https://help.mamikos.com/post/syarat-dan-ketentuan-umum"