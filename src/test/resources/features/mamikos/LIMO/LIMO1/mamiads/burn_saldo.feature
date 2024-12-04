@LIMO5 @burnSaldoMamiads
Feature: Mamiads Burn Saldo

  Scenario: Inject To Set Saldo Mamiads on admin page
  # set saldo 5000 on admin (https://jambu.kerupux.com/admin/request/kost/99454727)
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin visit page "/admin/request/kost/99454727"
    And admin bangkrupux adjust mamiads with intial value "5050" usage "" and alocated "0"

  # make sure iklan is active
#
#  # burn saldo
#    Given user go to mamikos homepage
#
#  @TEST_LIMO-1508 @TEST_LIMO-1507
#  Scenario: [MamiAds][Naikkan Iklan]: Switch OFF ads while saldo burn > 0 from maximal budget
#  # verify step