@pman @mamipay @invoice-manual

  Feature: Invoice Manual

    @TEST_PMAN-5684 @pman-prod
    Scenario: Auto fill No HP and Nomor Kamar
      Given admin go to mamikos mamipay admin
      When admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
      And admin input nama penyewa in buat invoice manual
        | property name                                                     | tenant name     |
        | Kost Apik Khusus Automation PMAN Tipe A Halmahera Utara           | Indah Trivena   |
        | Kost Apik Khusus Automation Mamitest PMAN Tipe C Halmahera Utara  | Yudha Ferroza   |
      Then tenant information should be auto fill
        | No HP         | No Kamar        |
        | 085157702873  | A3              |
        | 085542455775  | C1              |