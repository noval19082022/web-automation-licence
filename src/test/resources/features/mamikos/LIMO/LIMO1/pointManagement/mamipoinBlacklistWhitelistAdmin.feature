@listing-monetization @regression @LIMO1 @mamipoinOwnerEntryPoint @mamipoinOwner @mamiPointBlacklistWhitelist
Feature: Mamipoint Blacklist and Whitelist Admin

  @TEST_LIMO-1133 @Automated @Web @listing-monetization @mamipoin-owner @continue
  Scenario: [Admin] Change Whitelist to Blacklist
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    Then admin successfully "blacklisted" user named "Ramos Pembina Komsel1" with status "Whitelist"

  @TEST_LIMO-1134 @Automated @Web @listing-monetization @mamipoin-owner @continue
  Scenario: [Admin] Change Blacklist to Whitelist
    Then admin successfully "whitelisted" user named "Ramos Pembina Komsel1" with status "Blacklist"
    Then admin successfully "blacklisted" user named "Rega Dian Watts" with status "Whitelist"

  @TEST_LIMO-2013 @Automated @Web @listing-monetization @mamipoin-owner
  Scenario: [Admin] Change Blacklist to Whitelist
    Then admin successfully "whitelisted" user named "Rega Dian Watts" with status "Blacklist"