@regression @SS8 @searchInvoice

Feature: Search invoice

  @TEST_SS-3953 @autoExtendTrue @continue
  Scenario: Auto extend is true
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin clicks on Search Invoice Menu form left bar
    And user select "True" on auto extend selection
    And user click search invoice button on search invoice admin page
    Then user verify search invoice results have auto extend "True", "success"

  @TEST_SS-3952 @autoExtendFalse
  Scenario: Auto extend is false
    When admin clicks on Search Invoice Menu form left bar
    And user select "False" on auto extend selection
    And user click search invoice button on search invoice admin page
    Then user verify search invoice results have auto extend "False", "danger"

#  Temporary Commenting the scenarios for the future unexpected usage
#  @TEST_COOP-2629 @reminderStatusInformationH-5 @continue
#  Scenario: Reminder status information H-5
#    When admin clicks on Search Invoice Menu form left bar
#    And admin search invoice:
#      | search by    | invoice_number        |
#      | search value | 15906136/2021/11/0015 |
#    And admin clicks on see log button with link value "/52856"
#    And admin set active page to 1
#    Then admin verify invoice log has "Billing Reminder H-5" as "Reminder Type"
#    And user verify PN Template content with "Wah, 5 hari lagi sewa kos habis"

#  @TEST_COOP-2629 @reminderStatusInformationH-1 @continue
#  Scenario: Reminder status information H-1
#    Then admin verify invoice log has "Billing Reminder H-1" as "Reminder Type"
#    And user verify PN Template content with "Udah coba bayar kosan yang anti ribet?"
#
#  @TEST_COOP-2632 @billingReminderDueDate @continue
#  Scenario: Billing reminder due date
#    Then user verify PN Template content with "Pake Mamikos, bayar kos bisa di mana aja"

#  @TEST_COOP-2637 @pnReminderStatusInformation @continue
#  Scenario: PN reminder status information
#    Then admin verify PN reminder status information
#      | Platform          | Content                                | Created At          | Reminder Type             | Status    |
#      | Push Notification | Udah coba bayar kosan yang anti ribet? | 2021-09-07 09:05:06 | Billing Reminder Due Date | delivered |

#  @TEST_COOP-2687 @whatsAppReminderStatusInformation
#  Scenario: Whatsapp reminder status information
#    Then admin verify WhatsApp reminder status information
#      | Platform | Content                                                                                                                                                                                        | Created At          | Reminder Type                          | Status  |
#      | WhatsApp | Hai  Laksana Adi, Udah coba bayar kosan yang anti ribet? Cuma beberapa klik, uang sewa langsung diterima pemilik.Yuk, cobain langsung di https://mamikos.com/user/kost-saya?tagihan=true&ch=08 | 2021-09-06 05:12:10 | Billing Reminder Without Voucher Today | pending |

  @TEST_SS-3435
  Scenario Outline: [Search invoice]Find <status> data invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin clicks on Search Invoice Menu form left bar
    And admin choose filter Status "<status>" "status"
    Then admin will get data Status with method "<output>"
    Examples:
      | status  | output  |
      | Unpaid  | Unpaid  |
      | Paid    | Paid    |
      | Expired | Expired |

  @TEST_SS-3436 @continue
  Scenario: [Search invoice]Find recurring data invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin clicks on Search Invoice Menu form left bar
    And admin clicks on Search Invoice Menu form left bar
    And admin choose invoice type "recurring_invoice"
    Then admin should be able to see the text "Pembayaran bulan ke-2"

  @TEST_SS-4281
  Scenario: [Search invoice]Find first invoice data invoice
    And admin clicks on Search Invoice Menu form left bar
    And admin choose invoice type "first_invoice"
    Then admin should not be able to see the text "Pembayaran bulan ke-2"

  @TEST_SS-3434 @TEST_SS-3429
  Scenario Outline: [Search invoice]Find sort by data invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin clicks on Search Invoice Menu form left bar
    And admin choose filter Status "<sort_by>" "sort_by"
    Then admin will get data Status with method "<output>"
    Examples:
      | sort_by                   | output |
      | Scheduled Date Descending | Unpaid |
      | Scheduled Date Ascending  | paid   |

  @TEST_SS-3432
  Scenario: change status invoice to paid
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When admin clicks on Search Invoice Menu form left bar
    And admin search invoice:
      | search by    | invoice_number        |
      | search value | 91938181/2018/10/0001 |
    And user click on "Change Status" button
    And admin change mamipay status to "Paid"
    And admin fills transaction date "2024-01-01 10:00:00"
    And admin click submit button
    And user click on "Change Status" button
    And admin change mamipay status to "Unpaid"
    And admin click submit button
    Then admin verify see text "Data telah berhasil diupdate."

  @TEST_SS-3430
  Scenario: change status invoice to no in mamipay
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When admin clicks on Search Invoice Menu form left bar
    And admin search invoice:
      | search by    | invoice_number        |
      | search value | 91938181/2018/10/0001 |
    And user click on "Change Status" button
    And admin change mamipay status to "Not In Mamipay"
    And admin fills transaction date "2024-01-01 10:00:00"
    And admin click submit button
    Then admin verify see text "Data telah berhasil diupdate."

  @TEST_SS-3428
  Scenario: change status invoice to paid or not in mamipay withount input date
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When admin clicks on Search Invoice Menu form left bar
    And admin search invoice:
      | search by    | invoice_number        |
      | search value | 68468805/2018/12/0001 |
    And user click on "Change Status" button
    And admin change mamipay status to "Not In Mamipay"
    And admin click submit button
    Then admin verify see text "The transaction date field is required when status is not_in_mamipay."

  @TEST_SS-3431
  Scenario: change original price for paid invoice
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When admin clicks on Search Invoice Menu form left bar
    And admin search invoice:
      | search by    | invoice_number            |
      | search value | DP/38443528/2024/03/90665 |
    And user click on detail fee button
    Then admin see edit basic amount button disable