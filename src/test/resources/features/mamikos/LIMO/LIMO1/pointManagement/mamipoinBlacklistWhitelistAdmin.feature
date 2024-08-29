@listing-monetization @regression @LIMO1
Feature: Mamipoint Blacklist and Whitelist Admin (Already migrate

  @TEST_LIMO-3298 @Automated @Web @listing-monetization @mamipoin-owner @continue
  Scenario: [Admin] Change Whitelist to Blacklist
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    Then admin successfully "blacklisted" user named "Ramos Pembina Komsel1" with status "Whitelist"

  @TEST_LIMO-3299 @Automated @Web @listing-monetization @mamipoin-owner @continue
  Scenario: [Admin] Change Blacklist to Whitelist
    Then admin successfully "whitelisted" user named "Ramos Pembina Komsel1" with status "Blacklist"
    Then admin successfully "blacklisted" user named "Rega Dian update" with status "Whitelist"

  @TEST_LIMO-3300 @Automated @Web @listing-monetization @mamipoin-owner
  Scenario: [Admin] Change Blacklist to Whitelist
    Then admin successfully "whitelisted" user named "Rega Dian update" with status "Blacklist"