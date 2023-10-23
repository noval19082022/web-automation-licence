@regression @pman @mamipay @cp-disbursement @transfer-cp-disbursement

Feature: CP Disbursement - Transfer CP Disbursement

  @TEST_PMAN-3360
  Scenario: Edit and Transfer CP Disbursement
    Given user navigates to "backoffice"
    When user login Backoffice as a "PMAN03" via credentials
    And user access menu CP Disbursement
    #Search property testing
    When user choose search cp disbursement by "Nama Property"
    And user write search cp disbursement keyword "Khusus Automation"
    Then should be show all disbursement with nama property "PMAN"
    #Edit transfer detail
    When user preview data transfer and edit the information
    And user click transfer sekarang
    Then system show message "Transfer berhasil di request"
    #Check in Transfer Diproses tab
    When user open "Transfer Diproses" tab
    And user choose search cp disbursement by "Nama Property"
    And user write search cp disbursement keyword "Harapan Anak"
    Then disbursement "edit" should in process