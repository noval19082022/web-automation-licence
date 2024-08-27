@regression @LIMO4 @EditRejectKost
Feature: Edit Kos BBK Rejected

  @TEST_LIMO-980 @EditKosBBKRejected
  Scenario Outline: Edit kost when kost is BBK Rejected
    #scenario cek before edit BBK
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag      | phone prod      | password    |
      | 0812345670008   | 0812345670008   | qwerty123   |
    And owner navigates to property saya kos
    And owner close pop up bbk on property saya page
    And owner search kost "KosAuto NoBBK Testing Kalasan Sleman" on property saya page
    And user click "Edit Data Pribadi"
    And user click "Lanjutkan"
    Then user see activate mamipay form with Full Name "<FullName1>"
    And user see activate mamipay form with Bank Account Number "<BankNo1>"
    And user see active mamipay form with Bank Owner Name "<BankOwner1>"
    And user see active mamipay form with Bank Name "<BankName1>"

    #scenario edit form BBK
    Given user input field name with "<FullName2>" at form activate mamipay
    And user fill out activate mamipay form with Bank Account Number "<BankNo2>"
    And user fill out active mamipay form with  Bank Owner Name "<BankOwner2>"
    And user select bank account with "<BankName2>"
    And user clicks on Terms And Conditions checkbox in Mamipay form
    When user click submit data button to activate mamipay
    And owner search kost "KosAuto NoBBK Testing Kalasan Sleman" on property saya page
    Then user see kos with name "KosAuto NoBBK Testing Kalasan Sleman", status "Diperiksa Admin" and type "Kos Putra"
    And owner back to owner dashboard
    And owner should successfully log out

    #Scenario Reject BBK Kos
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "KosAuto NoBBK Testing Kalasan Sleman" in admin kos owner page
    When admin click on "BBK Data" link button
    Then admin reject BBK kos

    Examples:
      | FullName1                              | BankNo1    | BankOwner1   | BankName1                              | FullName2                              | BankNo2    | BankOwner2   | BankName2                              |
      | tiara lapan abcdefghijklmnopqrstuvwxyz | 36337373   | test         | Bank China Construction Bank Indonesia | eko lapan abcd                         | 8989898989 | Kiai Santang | Bank China Construction Bank Indonesia |
      | eko lapan abcd                         | 8989898989 | Kiai Santang | Bank China Construction Bank Indonesia | tiara lapan abcdefghijklmnopqrstuvwxyz | 36337373   | test         | Bank China Construction Bank Indonesia |