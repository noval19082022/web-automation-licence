@regression @LIMO4 @EX-LG

Feature: Edit Kos BBK Rejected

  @EditKosBBKRejected
  Scenario Outline: Edit kost when kost is BBK Rejected
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod      | password    |
      | 0812345670008   | 0812345670008   | qwerty123   |
    And owner navigates to property saya kos
    And owner close pop up BBK at kos list page
    And owner search kost "KosAuto NoBBK Test Kalasan Sleman" on property saya page
    And user click "Edit Data Pribadi"
    And user click "Lanjutkan"
    Then user see activate mamipay form with Full Name "<FullName1>"
    And user see activate mamipay form with Bank Account Number "<BankNo1>"
    And user see active mamipay form with Bank Owner Name "<BankOwner1>"
    And user see active mamipay form with Bank Name "<BankName1>"
    Examples:
      | FullName1                              | BankNo1    | BankOwner1   | BankName1                              | FullName2                              | BankNo2    | BankOwner2   | BankName2                              |
      | tiara lapan abcdefghijklmnopqrstuvwxyz | 36337373   | test         | Bank China Construction Bank Indonesia | eko lapan abcd                         | 8989898989 | Kiai Santang | BCA                                    |
      | eko lapan abcd                         | 8989898989 | Kiai Santang | BCA                                    | tiara lapan abcdefghijklmnopqrstuvwxyz | 36337373   | test         | Bank China Construction Bank Indonesia |