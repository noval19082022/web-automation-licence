@listing-monetization @regression @LIMO2
Feature: Search Contract Goldplus at Mamipay

 @searchContractGP @TEST_LIMO-2449
Scenario: [Admin][GP Contract]User want to Search GoldPlus Contract
  #Owner Want To Search GP Contract Search by owner phone
  Given admin go to mamikos mamipay admin
  And admin login to mamipay:
    | email stag                   | email prod                   | password  |
    | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
  And admin accsess menu Goldplus Contract
  When admin search contract based on phone number "087662369014"
  Then admin verify owner phone is "087662369014" with goldplus package "GoldPlus 1 4 Bulan" and status contract is "terminated"
   And admin wants to reset form search

   #Owner Want To Search GP Contract Search by owner name
   When admin search contract based on "Owner Name" is "Rega cek owner baru"
   Then admin verify owner name is "Rega cek owner baru " with goldplus package "GoldPlus 1 4 Bulan" and status contract is "terminated"
   And admin wants to reset form search

  #Owner Want To Search GP Contract Filter by GP Packages
   When admin select package "GoldPlus 1 Periode 12 Bulan"
   Then admin verify list of goldplus contracts is "GoldPlus 1 12 Bulan"
   And admin wants to reset form search

   #Owner Want To Search GP Contract Filter by Status GP
   When admin choose status GoldPlus Contract with "Active"
   Then admin verify list of goldplus contracts status is "Active" "succsess"
   And admin wants to reset form search
   When admin choose status GoldPlus Contract with "Terminated"
   Then admin verify list of goldplus contracts status is "Terminated" "succsess"
   And admin wants to reset form search
   When admin choose status GoldPlus Contract with "Inactive"
   Then admin verify list of goldplus contracts status is "Terminated" "succsess"
   And admin wants to reset form search

   #Owner Want To Combine Search and Filter
   When admin search contract based on phone number "087662369014"
   * admin select package "GoldPlus 1 Periode 4 Bulan"
   * admin choose status GoldPlus Contract with "Terminated"
   Then admin verify owner phone is "087662369014" with goldplus package "GoldPlus 1 4 Bulan" and status contract is "terminated"
   And admin wants to reset form search