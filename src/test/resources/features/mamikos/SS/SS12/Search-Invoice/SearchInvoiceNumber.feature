@SS10
Feature: Search Invoice

  @SS10 @searchInvoiceGlobal @TEST_SS-2831 @Automated @web-covered @continue
  Scenario: [BackOffice][Search Invoice] search invoice with use invoice number
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to search invoice number "ST/90743755/2020/11/0031"
    Then admin verify data transaction

    #   Scenario: admin wrong input invoice
    And admin click button reset input invoice number "ST/90743755/2020/11/003"
    Then admin get blank screen

  @SS10 @searchInvoiceGlobal @TEST_SS-2832 @continue
  Scenario: [Mamipay][Search Invoice] Search Invoice With Invoice Code
    Given admin go to mamikos mamipay admin
    And admin want to search invoice code "915000"
    Then admin get blank screen

#    Scenario: search invoice with use invalid invoice code
    And admin click button reset input invoice code "915"
    Then admin verify data transaction

  @TEST_SS-2833 @SS10 @searchInvoiceGlobal @continue
  Scenario: [Mamipay][Search Invoice]Search invoice GP
    Given admin go to mamikos mamipay admin
    And admin want to search invoice number "GP2/20210225/00002146/8312"
    Then admin will get data invoice "GP2/20210225/00002146/8312"

    #    Scenario: search wrong invoice GP
    And admin click button reset
    And admin want to search invoice number "GP2/20210225/00002146/111"
    Then admin get blank screen

  @TEST_SS-2834 @SS10 @searchInvoiceGlobal @continue
  Scenario: [Mamipay][Search Invoice]Search Premium invoice
    Given admin go to mamikos mamipay admin
    And admin want to search invoice number "PRE/20210727/48346/36691"
    Then admin will get data invoice "PRE/20210727/48346/36691"

    #    Scenario: search wrong premium invoice
    And admin click button reset
    And admin want to search invoice number "PRE/20210727/48346/111"
    Then admin get blank screen

  @TEST_SS-2835 @SS10 @searchInvoiceGlobal @basedOnPaymentMethod @continue
  Scenario Outline: [Mamipay][Search Invoice]Search transaction based on payment method
    Given admin go to mamikos mamipay admin
    And admin choose method "<method>"
    Then admin will get data transatcion with method "<output>"
    Examples:
      | method      | output      |
      | mandiri     | mandiri     |
      | indomaret   | indomaret   |
      | other       | other       |
      | permata     | permata     |
      | gopay       | gopay       |
      | alfamart    | alfamart    |
      | lawson      | lawson      |
      | dandan      | dandan      |
      | linkaja     | linkaja     |
      | bri         | bri         |
      | bni         | bni         |
      | dana        | dana        |
      | ovo         | ovo         |
      | credit_card | credit_card |

  @SS10 @searchInvoiceGlobal @TEST_SS-2836 @continue
  Scenario: [Mamipay][Search Invoice]Search Invoice With Schedule Date
    Given admin go to mamikos mamipay admin
    And user click "All Invoice"
    And admin choose date picker "2021-07-01" and "2021-07-19"
    Then data transaction appeared

  @SS10 @searchInvoiceGlobal @TEST_SS-2837 @continue
  Scenario: [Mamipay][Search Invoice]Search Invoice With Nominal Invoice
    Given admin go to mamikos mamipay admin
    And user click "All Invoice"
    And admin input amount from and to "50000" and "50000"
    Then appeared data with amount "50000"

  @TEST_SS-2838 @searchInvoiceGlobal @continue
  Scenario Outline: [Mamipay][Search Invoice]Search transaction based on status
    Given admin go to mamikos mamipay admin
    And user click "All Invoice"
    And admin choose method Status "<method>"
    Then admin will get data Status with method "<output>"
    Examples:
      | method  | output  |
      | Unpaid  | Unpaid  |
      | Paid    | Paid    |
      | Expired | Expired |

  @TEST_SS-2839 @TEST_SS-2840 @SS10 @searchInvoiceGlobal @continue
  Scenario Outline: [Mamipay][Search Invoice]Search transaction baded on order type
    Given admin go to mamikos mamipay admin
    And user click "All Invoice"
    And admin choose order type "<method>"
    Then appeared data transaction with order type "<output>"
    Examples:
      | method              | output              |
      | Pengajuan Sewa      | Bayar Sewa Kos      |
      | Bayar Paket Premium | Bayar Saldo MamiAds |

  @TEST_SS-2841 @SS10 @searchInvoiceGlobal @checkStatusLogInvoice @continue
  Scenario Outline: [Mamipay][Search Invoice]Change transaction from unpaid to paid
    Given admin go to mamikos mamipay admin
    And admin want to search invoice number "45111793/2021/04/0018"
    And admin click change status
    And admin change "<method>"
    And admin input date and time "2021-02-04 16:35:11"
    Then invoice will changes to "<output>"
    Examples:
      | method | output |
      | Paid   | Paid   |

  @TEST_SS-2842 @SS10 @searchInvoiceGlobal @continue
  Scenario Outline: [Mamipay][Search Invoice]Change transaction from Paid to Unpaid
    Given admin go to mamikos mamipay admin
    And admin want to search invoice number "45111793/2021/04/0018"
    And admin click change status
    And admin change "<method>"
    And admin input date and time "2021-02-04 16:35:11"
    Then invoice will changes to "<output>"
    Examples:
      | method | output |
      | Unpaid | Unpaid |

  @TEST_SS-2843 @SS10 @searchInvoiceGlobal @continue
  Scenario: [Mamipay][Search Invoice]Change transaction from unpaid to paid not in mamipay
    Given admin go to mamikos mamipay admin
    And admin want to search invoice number "45111793/2021/04/0018"
    And admin click change status
    And admin change mamipay status to "paid"
    And admin click checkbox not in mamipay
    And admin input date and time "2021-02-04 16:35:11"
    Then invoice will changes to "Paid"

  @SS10 @checkStatusLogInvoice @TEST_SS-2844 @continue
  Scenario: [Mamipay][Search Invoice] check status Log invoice
    Given admin go to mamikos mamipay admin
    And admin want to search invoice number "ST/90743755/2020/11/0031"
    And user click see log button
    Then user see status log invoice "Paid"

  @SS10 @changePrice @TEST_SS-2845 @continue
  Scenario: [Mamipay][Search Invoice]: Change original price for unpaid invoice
    Given admin go to mamikos mamipay admin
    And user click "Search Invoice"
    And admin choose method Status "Unpaid"
    And user click on detail fee button
    And user change basic amount "10000"
    Then user redirect to "Search Invoice" page

  @SS10 @SearchInvoiceByInvoiceNumber @TEST_SS-2846 @continue
  Scenario: [Mamipay][History Log] Check the log of any updates made regarding the invoice via search invoice menu
    Given admin go to mamikos mamipay admin
    And user click "Search Invoice"
    And admin want to search invoice number "ST/90743755/2020/11/0031"
    Then verify invoice number "ST/90743755/2020/11/0031"

  @SS10 @searchValidInvoice @TEST_SS-2847 @continue
  Scenario Outline: [Mamipay][Search Invoice] Search Invoice With Invoice Number
    Given admin go to mamikos mamipay admin
    And user click "Search Invoice"
    And user search by "<searchBy>" and input field "<input>"
    Then user will get data detail invoice
    Examples:
      | searchBy            | input                  |
      | Invoice Number      | 99491321/2023/02/62310 |
      | Invoice Code        | 2RIWW                  |
      | Owner Phone Number  | 083843666900           |
      | Renter Phone Number | 083139263046           |
      | Renter Name         | Ullrich                |

  @SS10 @searchInvoiceByrecuringInvoice @TEST_SS-2848 @continue
  Scenario Outline: [Mamipay][Search Invoice]Search Invoice With Invoice Number And invoice Type Recurring Invoice
    Given admin go to mamikos mamipay admin
    And user click "Search Invoice"
    And user search by "<searchBy>" and input field "<input>"
    Then verify invoice number "<input>"
    Examples:
      | searchBy       | input                     |
      | Invoice Number | DP/78931168/2023/01/11844 |

  @SS10 @TEST_SS-2849 @continue
  Scenario: [Mamipay][Search Invoice] Search Invoice With Invoice Number And invoice Type First Invoice
    Given admin go to mamikos mamipay admin
    And user click "Search Invoice"
    And admin want to search invoice number "ST/45892576/2023/05/00158"
    Then user get invoice result on the list equals to 1

  @TEST_SS-2850 @SS10 @searchByNameKost
  Scenario: [Mamipay][Search Invoice]Check list of data transaction on tab paid Search by Nama Kost
    Given admin go to mamikos mamipay admin
    And admin go to paid invoicr list "Refund"
    And user search by "Kost Name" and input field "kost payment automation casablanca campur" refund menu
    Then user see list in coloum kost detail with name kost "kost payment automation casablanca campur"