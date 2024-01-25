@listing-monetization @regression @LIMO1 @mamipoinOwnerEntryPoint @mamipoinOwner
Feature: Mamipoint Blacklist and Whitelist Admin

  Background:
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |

  @TEST_LIMO-2014 @Automated @Web @listing-monetization @mamipoin-owner
  Scenario: [Admin] Change Whitelist to Blacklist
    Then admin successfully "blacklisted" user named "Ramos Pembina Komsel" with status "Whitelist"

  @TEST_LIMO-2013 @Automated @Web @listing-monetization @mamipoin-owner
  Scenario: [Admin] Change Blacklist to Whitelist
    Then admin successfully "whitelisted" user named "Ramos Pembina Komsel" with status "Blacklist"