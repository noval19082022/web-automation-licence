@pman @mamipay @invoice-manual

Feature: Invoice Manual - Biaya Tambahan

  @TEST_PMAN-5773 @pman-prod
  Scenario: Periode is disabled when choose Deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the user selects "Deposit" in the Biaya Tambahan
    Then the Periode Awal and Periode Akhir are disable

  @TEST_PMAN-5771 @pman-prod
  Scenario Outline: <button> modal tambah biaya sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the user selects "Deposit" in the Biaya Tambahan
    When the user fill all fields in Tambah Biaya Tambahan pop up
      | Durasi Biaya  | Jumlah Biaya  |
      | Park Fee      | 25000         |
    And the user click "<button>" modal tambah biaya
    Then tambah biaya modal is closed

    Examples:
      | button  |
      | Close   |
      | Kembali |