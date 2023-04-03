@pman @mamipay @invoice-manual

Feature: Invoice Manual - Biaya Tambahan

  @TEST_PMAN-5773 @pman-prod
  Scenario: Periode is disabled when choose Deposit
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the admin selects "Deposit" in the Biaya Tambahan
    Then the Periode Awal and Periode Akhir are disable

  @TEST_PMAN-5771 @pman-prod
  Scenario Outline: <button> modal tambah biaya sewa
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the admin selects "Deposit" in the Biaya Tambahan
    When the admin fill all fields in Tambah Biaya Tambahan pop up
      | Durasi Biaya  | Jumlah Biaya  |
      | Park Fee      | 25000         |
    And the admin click "<button>" modal tambah biaya
    Then tambah biaya modal is closed

    Examples:
      | button  |
      | Close   |
      | Kembali |

  @TEST_PMAN-5697 @pman-prod
  Scenario Outline: Check required fields in the biaya tambahan
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman02@mamikos.com | automationpman02@mamikos.com | qwerty123 |
    And the admin create Invoice Manual "Biaya Tambahan" and check required fields "<Nama Biaya>", "<Awal>", "<Akhir>", "<Durasi Biaya>", "<Jumlah Biaya>"
    Then the error messages "<Nama Biaya Error Msg>", "<Awal Error Msg>", "<Akhir Error Msg>", "<Jumlah Biaya Error Msg>" are displayed

    Examples:
      | Nama Biaya      | Awal  | Akhir     | Durasi Biaya  | Jumlah Biaya  | Nama Biaya Error Msg            | Awal Error Msg                    | Akhir Error Msg                   | Jumlah Biaya Error Msg            |
      | -               | -     | -         | -             | -             | Nama biaya tidak boleh kosong.  | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
      | Parkir Mobil    | -     | -         | -             | -             | -                               | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
      | -               | today | -         | -             | -             | Nama biaya tidak boleh kosong.  | -                                 | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
      | -               | -     | -         | 1 hari        | -             | Nama biaya tidak boleh kosong.  | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | Jumlah biaya tidak boleh kosong.  |
      | -               | -     | -         | -             | 11000         | Nama biaya tidak boleh kosong.  | Periode awal tidak boleh kosong.  | Periode akhir tidak boleh kosong. | -                                 |