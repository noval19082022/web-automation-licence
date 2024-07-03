@pman2 @pms @autoDisbursementChangeLog

Feature: Auto Disbursement Change Log

  @TEST_PMAN-720
  Scenario: Check Auto Disbursement Change Log When Auto Disbursement turn into "ON/OFF"
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to detail property "Khusus Automation"
    #Check Auto Disbursement ON
    And admin change Transfer Pendapatan Otomatis to "ON"
    Then change log auto disbursement "ON" is displayed
      | Diubah oleh | Role        | Data yang Diubah              | Input Lama  | Input Baru  | Waktu Diubah  |
      | PMAN Admin	| Super Admin | Transfer Pendapatan Otomatis  | Nonaktif    | Aktif       | today         |
    #Check Auto Disbursement OFF
    When admin change Transfer Pendapatan Otomatis to "OFF"
    Then change log auto disbursement "OFF" is displayed
      | Diubah oleh | Role        | Data yang Diubah              | Input Lama  | Input Baru  | Waktu Diubah  |
      | PMAN Admin	| Super Admin | Transfer Pendapatan Otomatis  | Aktif       | Nonaktif    | today         |